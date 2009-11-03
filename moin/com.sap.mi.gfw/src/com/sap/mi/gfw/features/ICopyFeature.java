/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.ICopyContext;

/**
 * The Interface ICopyFeature.
 */
public interface ICopyFeature extends IFeature {

	/**
	 * Copy.
	 * 
	 * @param context
	 *            the context
	 */
	void copy(ICopyContext context);

	/**
	 * Can copy.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canCopy(ICopyContext context);
}