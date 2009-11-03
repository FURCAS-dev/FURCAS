package com.sap.mi.gfw.features.jam;

import java.util.Iterator;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.PeUtil;

/**
 * The Class DefaultRemoveFeature.
 */
public class DefaultRemoveFeature extends AbstractFeature implements IRemoveFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultRemoveFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDeleteFeature#canDelete(com.sap.mi.gfw.dt.IContext)
	 */
	public boolean canRemove(IRemoveContext context) {
		return !(context.getPictogramElement() instanceof Diagram);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IRemoveFeature#remove(com.sap.mi.gfw.features.context.IRemoveContext)
	 */
	public final void remove(IRemoveContext context) {
		if (!getUserDecision()) {
			return;
		}
		preRemove(context);

		PictogramElement pe = context.getPictogramElement();

		// if (pe instanceof ContainerShape) {
		// ContainerShape containerShape = (ContainerShape) pe;
		// // array instead of an unmodifiable list is necessary
		// Shape shapes[] = (Shape[]) containerShape.getChildren().toArray(new
		// Shape[0]);
		// for (Shape shape : shapes) {
		// if (shape.isActive()) {
		// IRemoveContext removeContext = new RemoveContext(shape);
		// IRemoveFeature removeFeature =
		// getFeatureProvider().getRemoveFeature(removeContext);
		// if (removeFeature != null) {
		// removeFeature.remove(removeContext);
		// }
		// }
		// }
		// }

		if (pe instanceof Shape) {
			Shape shape = (Shape) pe;
			removeAllConnections(shape);
		}

		PeUtil.deletePictogramElement(pe);

		// IJAMFeatureProvider jamFp = getJamFeatureProvider();
		// if (jamFp != null) {
		// Link link = jamFp.getLinkForPictogramElement(pe);
		// if (link != null) {
		// link.refDelete();
		// }
		// }
		//
		// if (pe != null && MoinHelper.isObjectAlive(pe)) {
		// pe.refDelete();
		// }

		postRemove(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDeleteFeature#delete(com.sap.mi.gfw.dt.IContext)
	 */
	public void preRemove(IRemoveContext context) {
	}

	/**
	 * Removes the all connections.
	 * 
	 * @param shape
	 *            the shape
	 */
	protected void removeAllConnections(Shape shape) {
		IFeatureProvider featureProvider = getFeatureProvider();
		for (Iterator iter = shape.getAnchors().iterator(); iter.hasNext();) {
			Anchor anchor = (Anchor) iter.next();
			for (Iterator iterator = PeUtil.getAllConnections(anchor).iterator(); iterator.hasNext();) {
				Connection connection = (Connection) iterator.next();
				if (MoinHelper.isObjectAlive(connection)) {
					IRemoveContext rc = new RemoveContext(connection);
					IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
					if (removeFeature != null) {
						ConnectionDecorator decorators[] = connection.getConnectionDecorators().toArray(new ConnectionDecorator[0]);
						for (ConnectionDecorator decorator : decorators) {
							if (decorator != null && MoinHelper.isObjectAlive(decorator)) {
								decorator.refDelete();
							}
						}
						removeFeature.remove(rc);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDeleteFeature#postDelete(com.sap.mi.gfw.dt.IContext)
	 */
	public void postRemove(IRemoveContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IRemoveContext) {
			ret = canRemove((IRemoveContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IRemoveContext) {
			remove((IRemoveContext) context);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#getName()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	private static final String NAME = Messages.DefaultRemoveFeature_0_xfld;
}