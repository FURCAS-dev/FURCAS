package com.sap.mi.fwk.util;

/**
 * A simple exception handler protocol.<p/> Clients may implement.
 * 
 * @author d031150
 */
public interface IExceptionHandler {

	/**
	 * Handles the exception, which usually means logging it or raising an error
	 * UI. (Re)throwing an exception is permitted but should be used with care
	 * since the original exception will be shadowed if it's not included in the
	 * thrown exception. This means for <em>callers</em> of this method to be
	 * able to cope with an exception being thrown here.
	 * 
	 * @param t
	 *            the exception that occured
	 */
	void handleException(Throwable t);

}
