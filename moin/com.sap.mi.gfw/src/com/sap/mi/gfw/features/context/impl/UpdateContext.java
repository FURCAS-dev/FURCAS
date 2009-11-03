/*
 * Created on 30.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class UpdateContext.
 */
public class UpdateContext extends PictogramElementContext implements IUpdateContext {

	/**
	 * The Constructor.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 */
	public UpdateContext(PictogramElement pictogramElement) {
		super(pictogramElement);
	}
}