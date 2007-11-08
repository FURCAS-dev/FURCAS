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
 * $Id: IDataTypeAdapter.java,v 1.1 2007/11/08 23:00:30 cdamus Exp $
 */
package org.eclipse.emf.query.conditions;


/**
 * An object that knows how to adapt objects to a given type.
 * 
 * @param <T> the type of object to which the adapter adapts values
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public interface IDataTypeAdapter<T> {

	/**
	 * Adapts the specified input value to the type that I provide.
	 * 
	 * @param value the input value
	 * 
	 * @return the corresponding output value
	 * 
	 * @since 1.2
	 */
	T adapt(Object value);
}
