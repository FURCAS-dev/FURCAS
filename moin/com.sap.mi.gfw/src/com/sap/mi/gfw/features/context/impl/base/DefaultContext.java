/*
 * Created on 20.06.2005
 */
package com.sap.mi.gfw.features.context.impl.base;

import com.sap.mi.gfw.features.context.IContext;

/**
 * The Class DefaultContext.
 */
public class DefaultContext implements IContext {

	/**
	 * Instantiates a new default context.
	 */
	public DefaultContext() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}