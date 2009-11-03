/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IDeleteContext;

/**
 * The Interface IDeleteFeature.
 */
public interface IDeleteFeature extends IFeature {

	/**
	 * Delete.
	 * 
	 * @param context
	 *            the context
	 */
	void delete(IDeleteContext context);

	/**
	 * Can delete.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canDelete(IDeleteContext context);

	/**
	 * Pre delete.
	 * 
	 * @param context
	 *            the context
	 */
	void preDelete(IDeleteContext context);

	/**
	 * Post delete.
	 * 
	 * @param context
	 *            the context
	 */
	void postDelete(IDeleteContext context);
}