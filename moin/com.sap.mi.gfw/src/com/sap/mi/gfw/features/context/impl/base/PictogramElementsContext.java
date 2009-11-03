/*
 * Created on 12.12.2005
 */
package com.sap.mi.gfw.features.context.impl.base;

import com.sap.mi.gfw.features.context.IPictogramElementsContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class PictogramElementsContext.
 */
public class PictogramElementsContext extends DefaultContext implements IPictogramElementsContext {

	private PictogramElement[] pictogramElements;

	/**
	 * The Constructor.
	 * 
	 * @param pictogramElements
	 *            the pictogram elements
	 */
	public PictogramElementsContext(PictogramElement[] pictogramElements) {
		this();
		setPictogramElements(pictogramElements);
	}

	/**
	 * Instantiates a new pictogram elements context.
	 */
	public PictogramElementsContext() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IDeleteContext#getPictogramElement()
	 */
	public PictogramElement[] getPictogramElements() {
		return pictogramElements;
	}

	/**
	 * Sets the pictogram elements.
	 * 
	 * @param pictogramElements
	 *            the pictogram elements
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
