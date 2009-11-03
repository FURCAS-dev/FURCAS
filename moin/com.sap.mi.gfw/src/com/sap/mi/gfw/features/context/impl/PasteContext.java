/*
 * Created on 17.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IPasteContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementsContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class PasteContext.
 */
public class PasteContext extends PictogramElementsContext implements IPasteContext {

	/**
	 * Instantiates a new paste context.
	 * 
	 * @param pictogramElements
	 *            the pictogram elements
	 */
	public PasteContext(PictogramElement[] pictogramElements) {
		super(pictogramElements);
	}
}
