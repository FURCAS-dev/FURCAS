package com.sap.mi.gfw.util;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class LocationInfo.
 */
public class LocationInfo implements ILocationInfo {

	private Shape shape;

	private GraphicsAlgorithm graphicsAlgorithm;

	/**
	 * Constructs a new instance of this class with given shape and graphics algorithm.
	 * 
	 * @param shape
	 *            the shape
	 * @param graphicsAlgorithm
	 *            the graphics algorithm
	 */
	public LocationInfo(Shape shape, GraphicsAlgorithm graphicsAlgorithm) {
		this.shape = shape;
		this.graphicsAlgorithm = graphicsAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILocationInfo#getShape()
	 */
	public Shape getShape() {
		return shape;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILocationInfo#getGraphicsAlgorithm()
	 */
	public GraphicsAlgorithm getGraphicsAlgorithm() {
		return graphicsAlgorithm;
	}
}
