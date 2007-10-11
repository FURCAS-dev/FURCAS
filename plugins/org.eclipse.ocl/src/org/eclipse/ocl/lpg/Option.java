/**
 * <copyright> 
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Option.java,v 1.1 2007/10/11 23:04:53 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

/**
 * Interface implemented by the enumerations of the parsing options
 * available for a particular parser implementation.
 * 
 * @param <T> the type of the option's value
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public interface Option<T> {
	/**
	 * Obtains my string key, which may be used for persistence in a
	 * preference store.
	 * 
	 * @return my key.  Is never <code>null</code>
	 */
	String getKey();
	
	/**
	 * Obtains the option's default value.
	 * 
	 * @return my default value, which default-default is <code>null</code>
	 */
	T getDefaultValue();
}
