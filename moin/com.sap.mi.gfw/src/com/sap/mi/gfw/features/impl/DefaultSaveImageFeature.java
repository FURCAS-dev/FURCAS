package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.ISaveImageFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ISaveImageContext;

/**
 * The Class DefaultSaveImageFeature.
 */
public class DefaultSaveImageFeature extends AbstractFeature implements ISaveImageFeature {

	/**
	 * Instantiates a new default save image feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultSaveImageFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ISaveImageFeature#canSave(com.sap.mi.gfw.features.context.ISaveImageContext)
	 */
	public boolean canSave(ISaveImageContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ISaveImageFeature#postSave(com.sap.mi.gfw.features.context.ISaveImageContext)
	 */
	public void postSave(ISaveImageContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ISaveImageFeature#preSave(com.sap.mi.gfw.features.context.ISaveImageContext)
	 */
	public void preSave(ISaveImageContext context) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof ISaveImageContext) {
			ret = canSave((ISaveImageContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		// todo: not possible yet
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

	private static final String NAME = Messages.DefaultSaveImageFeature_0_xfld;
}
