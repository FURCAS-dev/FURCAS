/**
 * 
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class CustomContext.
 */
public class CustomContext extends LocationContext implements ICustomContext {

	private GraphicsAlgorithm innerGraphicsAlgorithm;

	private PictogramElement innerPictogramElement;

	private PictogramElement pictogramElements[];

	/**
	 * Instantiates a new custom context.
	 */
	public CustomContext() {
		super();
	}

	/**
	 * The Constructor.
	 * 
	 * @param pictogramElements
	 *            the pictogram elements
	 */
	public CustomContext(PictogramElement[] pictogramElements) {
		this();
		setPictogramElements(pictogramElements);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ICustomContext#getInnerGraphicsAlgorithm()
	 */
	public GraphicsAlgorithm getInnerGraphicsAlgorithm() {
		return innerGraphicsAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ICustomContext#getInnerPictogramElement()
	 */
	public PictogramElement getInnerPictogramElement() {
		return innerPictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ICustomContext#getPictogramElements()
	 */
	public PictogramElement[] getPictogramElements() {
		return pictogramElements;
	}

	/**
	 * Sets the inner graphics algorithm.
	 * 
	 * @param innerGraphicsAlgorithm
	 *            the new inner graphics algorithm
	 */
	public void setInnerGraphicsAlgorithm(GraphicsAlgorithm innerGraphicsAlgorithm) {
		this.innerGraphicsAlgorithm = innerGraphicsAlgorithm;
	}

	/**
	 * Sets the inner pictogram element.
	 * 
	 * @param innerPictogramElement
	 *            the new inner pictogram element
	 */
	public void setInnerPictogramElement(PictogramElement innerPictogramElement) {
		this.innerPictogramElement = innerPictogramElement;
	}

	/**
	 * Sets the pictogram elements.
	 * 
	 * @param pictogramElements
	 *            The pictogramElements to set.
	 */
	public void setPictogramElements(PictogramElement[] pictogramElements) {
		this.pictogramElements = pictogramElements;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " innerGraphicsAlgorithm: " + getInnerGraphicsAlgorithm() + " innerPictogramElement: " + getInnerPictogramElement() //$NON-NLS-1$ //$NON-NLS-2$
				+ " pictogramElements: " + getPictogramElements(); //$NON-NLS-1$
	}

}
