package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * The Interface IDirectEditingContext.
 */
public interface IDirectEditingContext extends IPictogramElementContext {

	/**
	 * Gets the graphics algorithm.
	 * 
	 * @return the graphics algorithm on which direct editing has been invoked
	 */
	GraphicsAlgorithm getGraphicsAlgorithm();
}
