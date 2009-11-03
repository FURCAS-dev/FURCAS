/*
 * Created on 17.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ICopyContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementsContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class CopyContext.
 */
public class CopyContext extends PictogramElementsContext implements ICopyContext {

	/**
	 * Instantiates a new copy context.
	 * 
	 * @param pictogramElements
	 *            the pictogram elements
	 */
	public CopyContext(PictogramElement[] pictogramElements) {
		super(pictogramElements);
	}
}
