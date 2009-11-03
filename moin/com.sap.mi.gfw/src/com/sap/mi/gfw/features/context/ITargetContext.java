package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.ContainerShape;

/**
 * The Interface ITargetContext.
 */
public interface ITargetContext extends IContext {

	/**
	 * Gets the target container.
	 * 
	 * @return the target container shape where the new pictogram element (currently this has to be a shape) has to be added
	 */
	ContainerShape getTargetContainer();

}
