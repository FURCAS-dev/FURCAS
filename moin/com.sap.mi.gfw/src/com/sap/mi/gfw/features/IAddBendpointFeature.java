package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IAddBendpointContext;

/**
 * Feature, that can add a bendpoint to a {@link com.sap.mi.gfw.mm.pictograms.FreeFormConnection}.
 */
public interface IAddBendpointFeature extends IFeature {

	/**
	 * Checks if bendpoint can be added.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if can add bendpoint
	 */
	boolean canAddBendpoint(IAddBendpointContext context);

	/**
	 * Adds a bendpoint.
	 * 
	 * @param context
	 *            the context
	 */
	void addBendpoint(IAddBendpointContext context);
}
