/*
 * Created on 16.11.2005
 *


 */
package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Interface IMoveShapeContext.
 */
public interface IMoveShapeContext extends IMoveContext, IPictogramElementContext, ITargetContext, ITargetConnectionContext {

	/**
	 * Gets the shape.
	 * 
	 * @return the shape
	 */
	Shape getShape();

	/**
	 * Gets the source container.
	 * 
	 * @return the source container
	 */
	ContainerShape getSourceContainer();

	/**
	 * Gets the delta x.
	 * 
	 * @return the delta x
	 */
	int getDeltaX();

	/**
	 * Gets the delta y.
	 * 
	 * @return the delta y
	 */
	int getDeltaY();
}