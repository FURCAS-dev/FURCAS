/*
 * Created on 05.04.2005
 */
package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.Arrays;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.tools.ConnectionDragCreationTool;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.gef.MultiCreationFactory;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.BoxRelativeAnchor;
import com.sap.mi.gfw.util.PeUtil;

/**
 * The Class BoxRelativeAnchorEditPart.
 */
public class BoxRelativeAnchorEditPart extends AnchorEditPart implements IBoxRelativeAnchorEditPart {

	/**
	 * The Constructor.
	 * 
	 * @param anchor
	 *            the anchor
	 * @param configurationProvider
	 *            the configuration provider
	 */
	public BoxRelativeAnchorEditPart(IConfigurationProvider configurationProvider, BoxRelativeAnchor anchor) {
		super(configurationProvider, anchor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, getConfigurationProvider().getEditPolicyFactory().createModelObjectDeleteEditPolicy(
				getConfigurationProvider()));
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, getConfigurationProvider().getEditPolicyFactory().createConnectionEditPolicy());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request request) {

		PictogramElementContext context = new PictogramElementContext(getPictogramElement());
		IFeature[] dragAndDropFeatures = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider().getDragAndDropFeatures(
				context);
		if (dragAndDropFeatures == null || dragAndDropFeatures.length == 0)
			return super.getDragTracker(request);

		ConnectionDragCreationTool tool = new ConnectionDragCreationTool() {

			/**
			 * changed order: feedback gets deleted after command is executed (popup!)
			 */
			@Override
			protected boolean handleCreateConnection() {

				Command endCommand = getCommand();
				setCurrentCommand(endCommand);
				executeCurrentCommand();
				eraseSourceFeedback();

				return true;
			}

		};

		tool.setFactory(new MultiCreationFactory(Arrays.asList(dragAndDropFeatures)));

		return tool;

	}

	/**
	 * Show on demand.
	 * 
	 * @return true, if successful
	 */
	public boolean showOnDemand() {
		// TODO: this is a temporary workaround until the metamodel has been
		// changed
		return MoinHelper.isObjectAlive(getPictogramElement()) && PeUtil.getProperty(getPictogramElement(), "SHOWONDEMAND") != null; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.AnchorEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {

		if (!showOnDemand())
			return super.createFigure();

		IFigure theFigure = super.createFigure();
		theFigure.setVisible(false);
		return theFigure;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.AnchorEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		if (showOnDemand()) {
			delegate.refreshFigureForEditPart();
			getFigure().setVisible(false);
		} else
			super.refreshVisuals();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.AnchorEditPart#getFeatureProvider()
	 */
	@Override
	public IFeatureProvider getFeatureProvider() {
		IFeatureProvider ret = null;
		if (delegate != null) {
			ret = delegate.getFeatureProvider();
		}
		return ret;
	}

}