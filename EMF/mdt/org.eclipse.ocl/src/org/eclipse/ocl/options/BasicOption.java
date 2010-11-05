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
 * $Id: BasicOption.java,v 1.1 2007/11/06 19:47:11 cdamus Exp $
 */
package org.eclipse.ocl.options;




/**
 * Useful implementation of the {@link Option} interface for OCL parsing options.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class BasicOption<T> implements Option<T> {
	private final String key;
	private final T defaultValue;
	
	/**
	 * Initializes me with my key and default value.
	 * 
	 * @param key identifies me
	 * @param defaultValue my default value
	 */
	public BasicOption(String key, T defaultValue) {
		this.key = key;
		this.defaultValue = defaultValue;
	}
	
	public final String getKey() {
		return key;
	}
	
	public final T getDefaultValue() {
		return defaultValue;
	}
}
