/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features.jam;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IDeleteFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class DefaultDeleteFeature.
 */
public class DefaultDeleteFeature extends AbstractFeature implements IDeleteFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultDeleteFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDeleteFeature#canDelete(com.sap.mi.gfw.dt.IContext)
	 */
	public boolean canDelete(IDeleteContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		IRemoveContext rc = new RemoveContext(pictogramElement);
		IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(rc);
		boolean ret = (removeFeature != null) && removeFeature.canRemove(rc);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDeleteFeature#delete(com.sap.mi.gfw.features.context.IDeleteContext)
	 */
	public void delete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object[] businessObjectsForPictogramElement = getAllBusinessObjectsForPictogramElement(pe);
		if (businessObjectsForPictogramElement != null && businessObjectsForPictogramElement.length > 0) {
			if (!getUserDecision()) {
				return;
			}
		}

		preDelete(context);

		IRemoveContext rc = new RemoveContext(pe);
		IFeatureProvider featureProvider = getFeatureProvider();
		IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
		if (removeFeature != null) {
			removeFeature.remove(rc);
		}

		deleteBusinessObjects(businessObjectsForPictogramElement);

		postDelete(context);
	}

	/**
	 * Delete business objects.
	 * 
	 * @param businessObjects
	 *            the business objects
	 */
	protected void deleteBusinessObjects(Object[] businessObjects) {
		if (businessObjects != null) {
			for (Object bo : businessObjects) {
				deleteBusinessObject(bo);
			}
		}
	}

	/**
	 * Delete business object.
	 * 
	 * @param bo
	 *            the bo
	 */
	protected void deleteBusinessObject(Object bo) {
		if (bo instanceof RefObject) {
			((RefObject) bo).refDelete();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#getQuestionToUser()
	 */
	@Override
	protected String getQuestionToUser() {
		return Messages.DefaultDeleteFeature_0_xmsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDeleteFeature#delete(com.sap.mi.gfw.dt.IContext)
	 */
	public void preDelete(IDeleteContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDeleteFeature#postDelete(com.sap.mi.gfw.dt.IContext)
	 */
	public void postDelete(IDeleteContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IDeleteContext) {
			ret = canDelete((IDeleteContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IDeleteContext) {
			delete((IDeleteContext) context);
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

	private static final String NAME = Messages.DefaultDeleteFeature_1_xfld;
}