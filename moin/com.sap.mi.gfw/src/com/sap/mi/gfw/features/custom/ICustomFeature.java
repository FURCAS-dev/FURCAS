/*
 * Created on 12.12.2005
 */
package com.sap.mi.gfw.features.custom;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.ICustomContext;

/**
 * The Interface ICustomFeature.
 */
public interface ICustomFeature extends IFeature {

	/**
	 * Gets the image id.
	 * 
	 * @return the image id
	 */
	String getImageId();

	/**
	 * Can execute.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canExecute(ICustomContext context);

	/**
	 * Execute.
	 * 
	 * @param context
	 *            the context
	 */
	void execute(ICustomContext context);
}