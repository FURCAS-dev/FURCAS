package com.sap.mi.gfw.util;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Interface ILocationInfo.
 */
public interface ILocationInfo {

	/**
	 * Gets the shape.
	 * 
	 * @return the shape of this location information
	 */
	Shape getShape();

	/**
	 * Gets the graphics algorithm.
	 * 
	 * @return the graphics algorithm of this location information
	 */
	GraphicsAlgorithm getGraphicsAlgorithm();
}
