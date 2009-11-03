/*
 * Created on 12.12.2005
 */
package com.sap.mi.gfw.features.context.impl.base;

import com.sap.mi.gfw.features.context.IPictogramElementContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class PictogramElementContext.
 */
public class PictogramElementContext extends DefaultContext implements IPictogramElementContext {

	private PictogramElement pictogramElement;

	/**
	 * The Constructor.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 */
	public PictogramElementContext(PictogramElement pictogramElement) {
		this();
		setPictogramElement(pictogramElement);
	}

	/**
	 * Instantiates a new pictogram element context.
	 */
	public PictogramElementContext() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IDeleteContext#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() {
		return pictogramElement;
	}

	/**
	 * Sets the pictogram element.
	 * 
	 * @param pictogramElement
	 *            The pictogramElement to set.
	 */
	protected void setPictogramElement(PictogramElement pictogramElement) {
		this.pictogramElement = pictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.impl.base.DefaultContext#toString()
	 */
	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " pictogramElement: " + getPictogramElement(); //$NON-NLS-1$
	}

}
