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
 * $Id: Option.java,v 1.1 2007/11/06 19:47:11 cdamus Exp $
 */
package org.eclipse.ocl.options;

/**
 * Interface implemented by the options that can be applied to {@link Customizable}
 * entities such as OCL environments.
 * 
 * @param <T> the type of the option's value
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 * 
 * @see Customizable
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
