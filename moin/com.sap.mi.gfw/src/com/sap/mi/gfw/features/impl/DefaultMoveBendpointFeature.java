package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveBendpointFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IMoveBendpointContext;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.util.GaUtil;

/**
 * The Class DefaultMoveBendpointFeature.
 */
public class DefaultMoveBendpointFeature extends AbstractFeature implements IMoveBendpointFeature {

	/**
	 * Instantiates a new default move bendpoint feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultMoveBendpointFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveBendpointFeature#moveBendpoint(com.sap.mi.gfw.features.context.IMoveBendpointContext)
	 */
	public boolean moveBendpoint(IMoveBendpointContext context) {
		Point newPoint = GaUtil.createPoint(context.getConnection(), context.getX(), context.getY());
		context.getConnection().getBendpoints().set(context.getBendpointIndex(), newPoint);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IMoveBendpointContext) {
			IMoveBendpointContext moveContext = (IMoveBendpointContext) context;
			ret = canMoveBendpoint(moveContext);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		moveBendpoint((IMoveBendpointContext) context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMoveBendpointFeature#canMoveBendpoint(com.sap.mi.gfw.features.context.IMoveBendpointContext)
	 */
	public boolean canMoveBendpoint(IMoveBendpointContext context) {
		return true;
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

	private static final String NAME = Messages.DefaultMoveBendpointFeature_0_xfld;
}
