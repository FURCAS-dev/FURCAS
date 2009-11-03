package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.ICreateConnectionContext;
import com.sap.mi.gfw.mm.pictograms.Connection;

/**
 * The Interface ICreateConnection.
 */
public interface ICreateConnection extends ICreateInfo {

	/**
	 * Can create.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canCreate(ICreateConnectionContext context);

	/**
	 * Creates the.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the connection
	 */
	Connection create(ICreateConnectionContext context);

	/**
	 * Can start connection.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canStartConnection(ICreateConnectionContext context);

}
