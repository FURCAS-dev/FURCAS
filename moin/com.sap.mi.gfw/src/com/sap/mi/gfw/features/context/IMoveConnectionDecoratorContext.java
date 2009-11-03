package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;

/**
 * The Interface IMoveConnectionDecoratorContext.
 */
public interface IMoveConnectionDecoratorContext extends ILocationContext {

	/**
	 * Gets the connection decorator.
	 * 
	 * @return the connection decorator
	 */
	ConnectionDecorator getConnectionDecorator();

	/**
	 * Checks if execute is allowed.
	 * 
	 * @return true, if execute is allowed
	 */
	boolean isExecuteAllowed();
}