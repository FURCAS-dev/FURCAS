package com.sap.mi.gfw.features.context.impl.base;

import com.sap.mi.gfw.features.context.IDoubleClickContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class DoubleClickContext.
 */
public class DoubleClickContext extends CustomContext implements IDoubleClickContext {

	/**
	 * Instantiates a new double click context.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @param innerPictogramElement
	 *            the inner pictogram element
	 * @param innerGraphicsAlgorithm
	 *            the inner graphics algorithm
	 */
	public DoubleClickContext(PictogramElement pictogramElement, PictogramElement innerPictogramElement,
			GraphicsAlgorithm innerGraphicsAlgorithm) {
		super(new PictogramElement[] { pictogramElement });
		setInnerPictogramElement(innerPictogramElement);
		setInnerGraphicsAlgorithm(innerGraphicsAlgorithm);
	}

}
