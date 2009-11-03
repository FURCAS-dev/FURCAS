package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Interface ISplitConnectionContext.
 */
public interface ISplitConnectionContext extends IContext {

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	Connection getConnection();

	/**
	 * Gets the shape.
	 * 
	 * @return the shape
	 */
	Shape getShape();
}
