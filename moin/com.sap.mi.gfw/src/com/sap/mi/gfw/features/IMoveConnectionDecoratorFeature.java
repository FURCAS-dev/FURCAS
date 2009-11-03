package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext;

/**
 * Moving shapes means to change their coordinates or/and their parent.
 */
public interface IMoveConnectionDecoratorFeature extends IMoveFeature {

	/**
	 * Can move connection decorator.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canMoveConnectionDecorator(IMoveConnectionDecoratorContext context);

	/**
	 * Move connection decorator.
	 * 
	 * @param context
	 *            the context
	 */
	void moveConnectionDecorator(IMoveConnectionDecoratorContext context);
}