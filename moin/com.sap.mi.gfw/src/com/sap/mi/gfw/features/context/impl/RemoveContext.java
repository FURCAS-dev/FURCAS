/*
 * Created on 17.11.2005
 *


 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class RemoveContext.
 */
public class RemoveContext extends PictogramElementContext implements IRemoveContext {

	/**
	 * Instantiates a new removes the context.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 */
	public RemoveContext(PictogramElement pictogramElement) {
		super(pictogramElement);
	}
}