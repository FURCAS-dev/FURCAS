package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReconnectionFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;
import com.sap.mi.gfw.func.IReconnection;

/**
 * The Class ReconnectionFeatureForPattern.
 */
public class ReconnectionFeatureForPattern extends AbstractFeature implements IReconnectionFeature {

	private IReconnection deletegate;

	/**
	 * Instantiates a new reconnection feature for pattern.
	 * 
	 * @param fp
	 *            the fp
	 * @param pattern
	 *            the pattern
	 */
	public ReconnectionFeatureForPattern(IFeatureProvider fp, IReconnection pattern) {
		super(fp);
		this.deletegate = pattern;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IReconnection#canReconnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public boolean canReconnect(IReconnectionContext context) {
		return deletegate.canReconnect(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IReconnection#postReconnnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public void postReconnnect(IReconnectionContext context) {
		deletegate.postReconnnect(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IReconnection#preReconnnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public void preReconnnect(IReconnectionContext context) {
		deletegate.preReconnnect(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IReconnection#reconnnect(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public void reconnnect(IReconnectionContext context) {
		deletegate.reconnnect(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IReconnectionContext) {
			ret = canReconnect((IReconnectionContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IReconnectionContext) {
			reconnnect((IReconnectionContext) context);
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

	private static final String NAME = Messages.ReconnectionFeatureForPattern_0_xfld;

}
