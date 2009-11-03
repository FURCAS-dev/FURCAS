/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IMoveAnchorContext;

/**
 * Layouting shapes means to change their ccordinates or/and their parent.
 */
public interface IMoveAnchorFeature extends IMoveFeature {

	/**
	 * Can move anchor.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canMoveAnchor(IMoveAnchorContext context);

	/**
	 * Move anchor.
	 * 
	 * @param context
	 *            the context
	 */
	void moveAnchor(IMoveAnchorContext context);

	/**
	 * Pre move anchor.
	 * 
	 * @param context
	 *            the context
	 */
	void preMoveAnchor(IMoveAnchorContext context);

	/**
	 * Post move anchor.
	 * 
	 * @param context
	 *            the context
	 */
	void postMoveAnchor(IMoveAnchorContext context);
}