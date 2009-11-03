/*
 * Created on 17.11.2005
 *


 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class DeleteContext.
 */
public class DeleteContext extends PictogramElementContext implements IDeleteContext {

	/**
	 * Instantiates a new delete context.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 */
	public DeleteContext(PictogramElement pictogramElement) {
		super();
		setPictogramElement(pictogramElement);
	}
}
