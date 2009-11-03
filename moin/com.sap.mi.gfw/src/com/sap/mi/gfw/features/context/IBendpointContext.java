package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;

/**
 * The Interface IBendpointContext.
 */
public interface IBendpointContext {

	/**
	 * Gets the bendpoint.
	 * 
	 * @return the bendpoint
	 */
	Point getBendpoint();

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	FreeFormConnection getConnection();

	/**
	 * Gets the bendpoint index.
	 * 
	 * @return the bendpoint index
	 */
	int getBendpointIndex();
}
