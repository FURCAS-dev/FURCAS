package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.ISaveImageContext;

/**
 * The Interface ISaveImageFeature.
 */
public interface ISaveImageFeature extends IFeature {

	/**
	 * Can save.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canSave(ISaveImageContext context);

	/**
	 * Pre save.
	 * 
	 * @param context
	 *            the context
	 */
	void preSave(ISaveImageContext context);

	/**
	 * Post save.
	 * 
	 * @param context
	 *            the context
	 */
	void postSave(ISaveImageContext context);
}
