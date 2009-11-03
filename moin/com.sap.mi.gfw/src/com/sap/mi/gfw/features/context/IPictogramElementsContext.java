/*
 * Created on 12.12.2005
 */
package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IPictogramElementsContext.
 */
public interface IPictogramElementsContext extends IContext {

	/**
	 * Gets the pictogram elements.
	 * 
	 * @return the pictogram elements
	 */
	PictogramElement[] getPictogramElements();

	/**
	 * Sets the pictogram elements.
	 * 
	 * @param pes
	 *            the new pictogram elements
	 */
	void setPictogramElements(PictogramElement[] pes);
}
