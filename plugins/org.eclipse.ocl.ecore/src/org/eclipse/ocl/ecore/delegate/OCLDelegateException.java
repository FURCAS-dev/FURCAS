package org.eclipse.ocl.ecore.delegate;

import org.eclipse.emf.common.util.WrappedException;

/**
 * @since 3.0
 */
public class OCLDelegateException extends WrappedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OCLDelegateException(String message) {
		super(message, null);
	}

	public OCLDelegateException(String message, Exception cause) {
		super(message, cause);
	}
}
