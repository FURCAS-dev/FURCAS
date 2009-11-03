package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IRemoveBendpointContext;

/**
 * The Interface IRemoveBendpointFeature.
 */
public interface IRemoveBendpointFeature extends IFeature {

	/**
	 * Can remove bendpoint.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canRemoveBendpoint(IRemoveBendpointContext context);

	/**
	 * Removes the bendpoint.
	 * 
	 * @param context
	 *            the context
	 */
	void removeBendpoint(IRemoveBendpointContext context);
}
