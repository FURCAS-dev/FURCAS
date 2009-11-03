package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ISaveImageContext;
import com.sap.mi.gfw.features.context.impl.base.DefaultContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class SaveImageContext.
 */
public class SaveImageContext extends DefaultContext implements ISaveImageContext {

	private PictogramElement pictogramElements[];

	/**
	 * Instantiates a new save image context.
	 * 
	 * @param pictogramElements
	 *            the pictogram elements
	 */
	public SaveImageContext(PictogramElement[] pictogramElements) {
		this();
		setPictogramElements(pictogramElements);
	}

	/**
	 * Instantiates a new save image context.
	 */
	public SaveImageContext() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ISaveImageContext#getPictogramElements()
	 */
	public PictogramElement[] getPictogramElements() {
		return pictogramElements;
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
		return ret + " pictogramElements: " + getPictogramElements(); //$NON-NLS-1$
	}

}
