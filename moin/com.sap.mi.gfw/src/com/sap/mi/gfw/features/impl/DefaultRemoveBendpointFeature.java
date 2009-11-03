package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveBendpointFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IRemoveBendpointContext;

/**
 * The Class DefaultRemoveBendpointFeature.
 */
public class DefaultRemoveBendpointFeature extends AbstractFeature implements IRemoveBendpointFeature {

	/**
	 * Instantiates a new default remove bendpoint feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultRemoveBendpointFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IRemoveBendpointFeature#canRemoveBendpoint(com.sap.mi.gfw.features.context.IRemoveBendpointContext)
	 */
	public boolean canRemoveBendpoint(IRemoveBendpointContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IRemoveBendpointFeature#removeBendpoint(com.sap.mi.gfw.features.context.IRemoveBendpointContext)
	 */
	public void removeBendpoint(IRemoveBendpointContext context) {
		context.getConnection().getBendpoints().remove(context.getBendpointIndex());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IRemoveBendpointContext) {
			ret = canRemoveBendpoint((IRemoveBendpointContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		removeBendpoint((IRemoveBendpointContext) context);
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

	private static final String NAME = Messages.DefaultRemoveBendpointFeature_0_xfld;
}
