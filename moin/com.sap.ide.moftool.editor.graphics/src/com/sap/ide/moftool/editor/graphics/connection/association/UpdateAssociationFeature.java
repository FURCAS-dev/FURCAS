package com.sap.ide.moftool.editor.graphics.connection.association;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.ide.moftool.editor.graphics.diagram.ForcedUpdateContext;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionDecoratorUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.impl.AbstractUpdateFeature;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.PeUtil;

public class UpdateAssociationFeature extends AbstractUpdateFeature {

	public UpdateAssociationFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canUpdate(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object businessObject = getBusinessObjectForPictogramElement(pe);
		if (pe instanceof Connection && businessObject instanceof Association) {
			return true;
		}

		return false;
	}

	public boolean update(IUpdateContext context) {
		boolean ret = false;

		if (canUpdate(context)) {
			FreeFormConnection connection = (FreeFormConnection)context.getPictogramElement();
			Association association = (Association)getBusinessObjectForPictogramElement(connection);

			// Update connection itself
			if (checkConnectionLineUpdateNecessary(connection)) {
				// Remove old connection line
				connection.getGraphicsAlgorithm().refDelete();

				// Find new anchors...
				// ... start anchor
				AssociationEnd[] ends = AssociationService.getAssociationEnds(association);
				ContainerShape cs = DiagramUtil.getExistingMofClassShapeFromDiagram(getDiagram(),
						(MofClass)ends[0].getType());
				if (cs == null) {
					// Start class not on diagram -> remove association
					removeConnection(connection);
					return true;
				}
				Anchor fromAnchor = (Anchor)cs.getAnchors().toArray()[0];
				
				// ... target anchor
				cs = DiagramUtil.getExistingMofClassShapeFromDiagram(getDiagram(), (MofClass)ends[1].getType());
				if (cs == null) {
					// Target class not on diagram -> remove association
					removeConnection(connection);
					return true;
				}
				Anchor toAnchor = (Anchor)cs.getAnchors().toArray()[0];

				// Set new anchors for connection
				connection.setStart(fromAnchor);
				connection.setEnd(toAnchor);

				// Draw new line
				createConnectionLine(connection);
			}
			else if (connection.getGraphicsAlgorithm() == null) {
				createConnectionLine(connection);
			}

			// Update decorators
			updateDecorators(connection, association);

			ret = true;
		}
		return ret;
	}

	public IReason updateNeeded(IUpdateContext context) {

		if (context instanceof ForcedUpdateContext) {
			return Reason.createTrueReason();
		}

		IReason ret = Reason.createFalseReason();
		if (!canUpdate(context)) {
			return ret;
		}

		Connection connection = (Connection)context.getPictogramElement();

		// Check if connection line is correct
		if (checkConnectionLineUpdateNecessary(connection)) {
			return Reason.createTrueReason(Messages.UpdateAssociationFeature_0_xmsg);
		}

		// Check if update for decorators is needed
		Collection<ConnectionDecorator> col = connection.getConnectionDecorators();
		for (Iterator<ConnectionDecorator> iter = col.iterator(); iter.hasNext();) {
			ConnectionDecorator decorator = iter.next();
			UpdateContext updateContext = new UpdateContext(decorator);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
			if (updateFeature != null && updateFeature.canUpdate(updateContext)) {
				ret = updateFeature.updateNeeded(updateContext);
				if (ret.toBoolean()) {
					return ret;
				}
			}

		}
		return ret;

	}

	private boolean checkConnectionLineUpdateNecessary(Connection connection) {
		Object bo = getBusinessObjectForPictogramElement(connection);
		if (bo instanceof Association) {
			Association association = (Association)bo;
			AssociationEnd[] associationEnds = AssociationService.getAssociationEnds(association);
			for (int i = 0; i < associationEnds.length; i++) {
				// Check if association end corresponds to source anchor
				if (connection.getStart() != null) {
					bo = getBusinessObjectForPictogramElement(connection.getStart().getParent());
					if (bo instanceof MofClass) {
						MofClass mofClass = (MofClass)bo;
						if (!mofClass.equals(associationEnds[i].getType())) {
							// Check if association end corresponds to target anchor
							if (connection.getEnd() != null) {
								bo = getBusinessObjectForPictogramElement(connection.getEnd().getParent());
								if (bo instanceof MofClass) {
									mofClass = (MofClass)bo;
									if (!mofClass.equals(associationEnds[i].getType())) {
										// End does not match to any of the anchors -> association end type has changed
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Updates all decorators for the connection object
	 * @param connection
	 * @param relativeLocationInactive
	 * @param absoluteLocationActive
	 */
	private void updateDecorators(Connection connection, Association association) {
		// Check if decorators exist and create them if not
		if (!ConnectionDecoratorUtil.existNameDecorator(connection)) {
			ConnectionDecorator cd = ConnectionDecoratorUtil.createConnectionNameDecorator(connection);
			link(cd, getFeatureProvider().getBusinessObjectForPictogramElement(connection));
		}
		AssociationEnd[] assocEnds = AssociationService.getAssociationEnds(association);
		if (assocEnds != null && assocEnds.length == 2) {
			AssociationEnd sourceEnd = assocEnds[0];
			AssociationEnd targetEnd = assocEnds[1];
			// Name for start end
			if (!ConnectionDecoratorUtil.existEndNameDecorator(connection, sourceEnd, getFeatureProvider())) {
				ConnectionDecorator cd = ConnectionDecoratorUtil.createStartEndNameDecorator(connection);
				link(cd, sourceEnd);
			}
			// Name for target end
			if (!ConnectionDecoratorUtil.existEndNameDecorator(connection, targetEnd, getFeatureProvider())) {
				ConnectionDecorator cd = ConnectionDecoratorUtil.createTargetEndNameDecorator(connection);
				link(cd, targetEnd);
			}
			// Multiplicity for start end
			if (!ConnectionDecoratorUtil.existEndMultiplicityDecorator(connection, sourceEnd, getFeatureProvider())) {
				ConnectionDecorator cd = ConnectionDecoratorUtil.createStartEndMultiplicityDecorator(connection);
				link(cd, sourceEnd);
			}
			// Multiplicity for target end
			if (!ConnectionDecoratorUtil.existEndMultiplicityDecorator(connection, targetEnd, getFeatureProvider())) {
				ConnectionDecorator cd = ConnectionDecoratorUtil.createTargetEndMultiplicityDecorator(connection);
				link(cd, targetEnd);
			}
			// Navigability for source end
			if (!ConnectionDecoratorUtil.existEndNavigabilityDecorator(connection, sourceEnd, getFeatureProvider())) {
				ConnectionDecorator cd = ConnectionDecoratorUtil.createStartEndNavigationDecorator(connection);
				link(cd, sourceEnd);
			}
			// Navigability for target end
			if (!ConnectionDecoratorUtil.existEndNavigabilityDecorator(connection, targetEnd, getFeatureProvider())) {
				ConnectionDecorator cd = ConnectionDecoratorUtil.createTargetEndNavigationDecorator(connection);
				link(cd, targetEnd);
			}
		}

		// Check if decorators should be visible
		if (!MOFToolConstants.VALUE_YES.equals(PeUtil.getPropertyValue(connection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE))) {
			// Should not be visible -> remove all active ones (navigability is the only non-active one)
			Collection<ConnectionDecorator> col = connection.getConnectionDecorators();
			Collection<ConnectionDecorator> listToBeDeltetet = new ArrayList<ConnectionDecorator>();

			for (ConnectionDecorator decorator : col) {
				if (decorator.isActive() &&
						PeUtil.getProperty(decorator, MOFToolConstants.NAVIGABLE) == null
						&& PeUtil.getProperty(decorator, MOFToolConstants.COMPOSITE) == null) {
					listToBeDeltetet.add(decorator);
				}
			}
			// remove the decorators from diagram
			for (ConnectionDecorator dec : listToBeDeltetet) {
				IRemoveContext rc = new RemoveContext(dec);
				IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(rc);
				if (removeFeature != null) {
					removeFeature.remove(rc);
				}
			}
		}

		// Update all decorators
		Collection<ConnectionDecorator> c = connection.getConnectionDecorators();
		for (ConnectionDecorator decorator : c) {
			updatePictogramElement(decorator);
		}
	}

	private Polyline createConnectionLine(FreeFormConnection connection) {

		Polyline p = GaUtil.createPolyline(connection);
		GaUtil.ignoreAll(p);
		p.setStyle(StyleService.getAssociationStyle(PeUtil.getDiagramForPictogramElement(connection)));
		AnchorContainer fromParent = connection.getStart().getParent();
		AnchorContainer toParent = connection.getEnd().getParent();

		if (fromParent.equals(toParent)) {
			Collection<Point> newPoints = new ArrayList<Point>();

			// calculate parent position
			int parentX = fromParent.getGraphicsAlgorithm().getX();
			int parentY = fromParent.getGraphicsAlgorithm().getY();
			int parentWidth = fromParent.getGraphicsAlgorithm().getWidth() / 2;
			int parentHeight = fromParent.getGraphicsAlgorithm().getHeight() / 2;

			newPoints.add(GaUtil.createPoint(connection.getStart(), parentX - parentWidth, parentY + parentHeight));
			newPoints.add(GaUtil.createPoint(connection.getStart(), parentX - parentWidth, parentY - parentHeight));
			newPoints.add(GaUtil.createPoint(connection.getStart(), parentX + parentWidth, parentY - parentHeight));

			connection.getBendpoints().addAll(newPoints);
		}

		return p;
	}
	
	private void removeConnection(Connection connection) {
		RemoveContext context = new  RemoveContext(connection);
		IRemoveFeature feature = getFeatureProvider().getRemoveFeature(context);
		feature.execute(context);
	}
}
