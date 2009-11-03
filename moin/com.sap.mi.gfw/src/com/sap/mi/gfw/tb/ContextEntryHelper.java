package com.sap.mi.gfw.tb;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IDeleteFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.DeleteContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.platform.IPlatformImageConstants;

public class ContextEntryHelper {

	public static void markAsUpdateContextEntry(IContextEntry entry) {
		if (entry != null) {
			entry.setText(Messages.ContextEntryHelper_0_xfld);
			entry.setDescription(Messages.ContextEntryHelper_1_xfld);
			entry.setIconId(IPlatformImageConstants.IMG_EDIT_REFRESH);
		}
	}

	public static void markAsRemoveContextEntry(IContextEntry entry) {
		if (entry != null) {
			entry.setText(Messages.ContextEntryHelper_2_xfld);
			entry.setDescription(Messages.ContextEntryHelper_3_xfld);
			entry.setIconId(IPlatformImageConstants.IMG_EDIT_REMOVE);
		}
	}

	public static void markAsDeleteContextEntry(IContextEntry entry) {
		if (entry != null) {
			entry.setText(Messages.ContextEntryHelper_4_xfld);
			entry.setDescription(Messages.ContextEntryHelper_5_xfld);
			entry.setIconId(IPlatformImageConstants.IMG_EDIT_DELETE);
		}
	}

	public static void markAsCollapseContextEntry(IContextEntry entry, boolean collapse) {
		if (entry != null) {
			if (collapse) {
				entry.setText(Messages.ContextEntryHelper_6_xfld);
				entry.setDescription(Messages.ContextEntryHelper_7_xfld);
				entry.setIconId(IPlatformImageConstants.IMG_EDIT_COLLAPSE);
			} else {
				entry.setText(Messages.ContextEntryHelper_8_xfld);
				entry.setDescription(Messages.ContextEntryHelper_9_xfld);
				entry.setIconId(IPlatformImageConstants.IMG_EDIT_EXPAND);
			}
		}
	}

	public static IContextButtonEntry createDefaultUpdateContextButton(IFeatureProvider featureProvider, PictogramElement pe) {
		IUpdateContext updateContext = new UpdateContext(pe);
		IUpdateFeature updateFeature = featureProvider.getUpdateFeature(updateContext);
		IContextButtonEntry ret = null;
		if (updateFeature != null && updateFeature.updateNeeded(updateContext).toBoolean()) {
			ret = new ContextButtonEntry(updateFeature, updateContext);
			markAsUpdateContextEntry(ret);
		}
		return ret;
	}

	public static IContextButtonEntry createDefaultRemoveContextButton(IFeatureProvider featureProvider, PictogramElement pe) {
		IRemoveContext removeContext = new RemoveContext(pe);
		IRemoveFeature removeFeature = featureProvider.getRemoveFeature(removeContext);
		IContextButtonEntry ret = null;
		if (removeFeature != null) {
			ret = new ContextButtonEntry(removeFeature, removeContext);
			markAsRemoveContextEntry(ret);
		}
		return ret;
	}

	public static IContextButtonEntry createDefaultDeleteContextButton(IFeatureProvider featureProvider, PictogramElement pe) {
		IDeleteContext deleteContext = new DeleteContext(pe);
		IDeleteFeature deleteFeature = featureProvider.getDeleteFeature(deleteContext);
		IContextButtonEntry ret = null;
		if (deleteFeature != null) {
			ret = new ContextButtonEntry(deleteFeature, deleteContext);
			markAsDeleteContextEntry(ret);
		}
		return ret;
	}

	public static IContextButtonEntry createCollapseContextButton(boolean collapse, IFeature customFeature, IContext customContext) {
		IContextButtonEntry ret = null;
		ret = new ContextButtonEntry(customFeature, customContext);
		if (collapse) {
			ret.setText(Messages.ContextEntryHelper_10_xfld);
			ret.setDescription(Messages.ContextEntryHelper_11_xfld);
			ret.setIconId(IPlatformImageConstants.IMG_EDIT_COLLAPSE);
		} else {
			ret.setText(Messages.ContextEntryHelper_12_xfld);
			ret.setDescription(Messages.ContextEntryHelper_13_xfld);
			ret.setIconId(IPlatformImageConstants.IMG_EDIT_EXPAND);
		}
		return ret;
	}
}
