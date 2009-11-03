package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.ICreateContext;

/**
 * The Interface ICreate.
 */
public interface ICreate extends ICreateInfo {

	/**
	 * Empty object array as return for unsuccessful create operations.
	 */
	static final Object[] EMPTY = new Object[0];

	/**
	 * Checks if business object can be created for the given context.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true if create is possible.
	 */
	boolean canCreate(ICreateContext context);

	/**
	 * Creates the business object for the given context.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the newly created objects
	 */
	Object[] create(ICreateContext context);
}
