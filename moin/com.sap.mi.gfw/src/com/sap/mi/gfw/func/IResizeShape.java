package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.IResizeShapeContext;

/**
 * The Interface IResizeShape.
 */
public interface IResizeShape {

	/**
	 * Can resize shape.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canResizeShape(IResizeShapeContext context);

	/**
	 * Resize shape.
	 * 
	 * @param context
	 *            the context
	 */
	void resizeShape(IResizeShapeContext context);
}
