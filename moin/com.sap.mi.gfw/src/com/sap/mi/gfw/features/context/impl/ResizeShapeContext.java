/*
 * Created on 16.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class ResizeShapeContext.
 */
public class ResizeShapeContext extends ResizeContext implements IResizeShapeContext {

	private Shape shape;

	/**
	 * The Constructor.
	 * 
	 * @param shape
	 *            the shape
	 */
	public ResizeShapeContext(Shape shape) {
		super();
		setShape(shape);
	}

	/**
	 * Gets the shape.
	 * 
	 * @return Returns the shape.
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * @param shape
	 *            The shape to set.
	 */
	private void setShape(Shape shape) {
		this.shape = shape;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IPictogramElementContext#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() {
		return getShape();
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " shape: " + getShape(); //$NON-NLS-1$
	}

}
