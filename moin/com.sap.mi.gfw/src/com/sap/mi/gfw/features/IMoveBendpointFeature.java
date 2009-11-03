package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IMoveBendpointContext;

/**
 * The Interface IMoveBendpointFeature.
 */
public interface IMoveBendpointFeature extends IMoveFeature {

	/**
	 * Can move bendpoint.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canMoveBendpoint(IMoveBendpointContext context);

	/**
	 * Move bendpoint.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean moveBendpoint(IMoveBendpointContext context);
}
