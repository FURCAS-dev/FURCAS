package com.sap.mi.gfw.features.impl;

import java.util.List;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IAddBendpointFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAddBendpointContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.util.GaUtil;

/**
 * Prefer using this default implementation over implementing interface {@link com.sap.mi.gfw.features.IAddBendpointFeature} for yourself.
 */
public class DefaultAddBendpointFeature extends AbstractFeature implements IAddBendpointFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public DefaultAddBendpointFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IAddBendpointFeature#canAddBendpoint(com.sap.mi.gfw.features.context.IAddBendpointContext)
	 */
	public boolean canAddBendpoint(IAddBendpointContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IAddBendpointFeature#addBendpoint(com.sap.mi.gfw.features.context.IAddBendpointContext)
	 */
	public void addBendpoint(IAddBendpointContext context) {
		FreeFormConnection freeFormConnection = context.getConnection();
		List<Point> bendpoints = freeFormConnection.getBendpoints();
		Point newPoint = GaUtil.createPoint(freeFormConnection, context.getX(), context.getY());
		int index = context.getBendpointIndex();
		bendpoints.add(index, newPoint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IAddBendpointContext) {
			ret = canAddBendpoint((IAddBendpointContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		addBendpoint((IAddBendpointContext) context);
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

	private static final String NAME = Messages.DefaultAddBendpointFeature_0_xfld;
}
