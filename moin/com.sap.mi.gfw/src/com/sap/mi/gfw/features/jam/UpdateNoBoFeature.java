package com.sap.mi.gfw.features.jam;

import java.util.List;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.impl.AbstractUpdateFeature;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.LinkUtil;

/**
 * An update feature, which marks a pictogram element without a linked business object as "update needed". On "update" such a pictogram
 * element is deleted.
 */
class UpdateNoBoFeature extends AbstractUpdateFeature {

	public UpdateNoBoFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canUpdate(IUpdateContext context) {
		return context.getPictogramElement() != null;
	}

	public IReason updateNeeded(IUpdateContext context) {
		IReason ret = Reason.createFalseReason();
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			PictogramLink linkForPictogramElement = LinkUtil.getLinkForPictogramElement(pe);
			if (linkForPictogramElement != null && linkForPictogramElement.getBusinessObjects().isEmpty()) {
				ret = new Reason(true, "No business object linked to graphical representation"); //$NON-NLS-1$
			}
		}
		return ret;
	}

	public boolean update(IUpdateContext context) {
		boolean ret = false;
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			PictogramLink linkForPictogramElement = LinkUtil.getLinkForPictogramElement(pe);
			if (linkForPictogramElement != null) {
				List businessObject = linkForPictogramElement.getBusinessObjects();
				if (businessObject != null && businessObject.isEmpty()) {
					ret = removeIfPossible(pe);
					ret = true;
				}
			}
		}
		return ret;
	}

	private boolean removeIfPossible(PictogramElement pe) {
		IRemoveContext context = new RemoveContext(pe);
		final IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(context);
		if (removeFeature != null && removeFeature.canRemove(context)) {
			removeFeature.remove(context);
			return true;
		}
		return false;
	}
}
