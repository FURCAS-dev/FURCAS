package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.context.impl.base.DetailedPictogramElementContext;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class DirectEditingContext.
 */
public class DirectEditingContext extends DetailedPictogramElementContext implements IDirectEditingContext {

	/**
	 * Instantiates a new direct editing context.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @param graphicsAlgorithm
	 *            the graphics algorithm
	 */
	public DirectEditingContext(PictogramElement pictogramElement, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElement, graphicsAlgorithm);

	}

}
