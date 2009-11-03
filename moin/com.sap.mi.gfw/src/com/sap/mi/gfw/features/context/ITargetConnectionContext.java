package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.Connection;

/**
 * The Interface ITargetConnectionContext.
 */
public interface ITargetConnectionContext extends IContext {

	/**
	 * Gets the target connection.
	 * 
	 * @return the target connection where the new pictogram element (currently this has to be a shape) has to be inserted
	 */
	Connection getTargetConnection();

}
