/*
 * Created on 16.11.2005
 *


 */
package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Interface IResizeShapeContext.
 */
public interface IResizeShapeContext extends IResizeContext, IPictogramElementContext {

	/**
	 * Gets the shape.
	 * 
	 * @return the shape
	 */
	Shape getShape();
}