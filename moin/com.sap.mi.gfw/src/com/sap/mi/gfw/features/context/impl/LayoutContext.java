/*
 * Created on 30.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class LayoutContext.
 */
public class LayoutContext extends PictogramElementContext implements ILayoutContext {

	/**
	 * The Constructor.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 */
	public LayoutContext(PictogramElement pictogramElement) {
		super(pictogramElement);
	}
}