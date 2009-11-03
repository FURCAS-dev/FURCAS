/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IRemoveContext;

/**
 * This feature is for removing pictogram elements from a diagram. Remove features must not modify any business content.
 */
public interface IRemoveFeature extends IFeature {

	/**
	 * Remove the given object.
	 * 
	 * @param context
	 *            contains object to remove
	 */
	void remove(IRemoveContext context);

	/**
	 * Checks if given object could be removed.
	 * 
	 * @param context
	 *            contains object to remove
	 * 
	 * @return true if remove is possible
	 */
	boolean canRemove(IRemoveContext context);

	/**
	 * called prior to remove call.
	 * 
	 * @param context
	 *            the context
	 */
	void preRemove(IRemoveContext context);

	/**
	 * called after remove call.
	 * 
	 * @param context
	 *            the context
	 */
	void postRemove(IRemoveContext context);
}