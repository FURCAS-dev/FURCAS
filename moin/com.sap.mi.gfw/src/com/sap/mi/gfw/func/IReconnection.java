/**
 * 
 */
package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.IReconnectionContext;

/**
 * The Interface IReconnection.
 * 
 * @author d023588
 */
public interface IReconnection {

	/**
	 * Can reconnect.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canReconnect(IReconnectionContext context);

	/**
	 * Reconnnect.
	 * 
	 * @param context
	 *            the context
	 */
	void reconnnect(IReconnectionContext context);

	/**
	 * Pre reconnnect.
	 * 
	 * @param context
	 *            the context
	 */
	void preReconnnect(IReconnectionContext context);

	/**
	 * Post reconnnect.
	 * 
	 * @param context
	 *            the context
	 */
	void postReconnnect(IReconnectionContext context);

}
