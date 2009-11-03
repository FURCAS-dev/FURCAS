/**
 * 
 */
package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface ICustomContext.
 */
public interface ICustomContext extends ILocationContext {

	/**
	 * Gets the pictogram elements.
	 * 
	 * @return the currently selected pictogram elements
	 */
	PictogramElement[] getPictogramElements();

	/**
	 * Gets the inner pictogram element.
	 * 
	 * @return the pictogram element at the mouse click position
	 */
	PictogramElement getInnerPictogramElement();

	/**
	 * Gets the inner graphics algorithm.
	 * 
	 * @return the graphics algorithm at the mouse click position
	 */
	GraphicsAlgorithm getInnerGraphicsAlgorithm();
}
