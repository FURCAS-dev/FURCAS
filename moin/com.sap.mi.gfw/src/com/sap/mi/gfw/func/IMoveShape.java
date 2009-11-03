package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.IMoveShapeContext;

/**
 * The Interface IMoveShape.
 */
public interface IMoveShape {

	/**
	 * Can move shape.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canMoveShape(IMoveShapeContext context);

	/**
	 * Move shape.
	 * 
	 * @param context
	 *            the context
	 */
	void moveShape(IMoveShapeContext context);
}
