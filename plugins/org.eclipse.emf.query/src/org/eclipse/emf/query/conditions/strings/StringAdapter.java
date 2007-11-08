/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.query.conditions.strings;

import org.eclipse.emf.query.conditions.IDataTypeAdapter;

/**
 * An Adapter class to be used to extract from -adapt- the argument object to
 * some
 * <code>String<code> value that would later be used in <code>Condition</code> evaluation.
 * 
 * Clients can subclass it and provide their own implementation
 *  
 * @see StringCondition
 */
public abstract class StringAdapter implements IDataTypeAdapter<String> {

	/**
	 * The simplest <code>StringAdapter</code> implementation that represents
	 * the case when the argument object to adapt is a
	 * <code>String<code> object itself.
	 */
	public static final StringAdapter DEFAULT = new StringAdapter() {

		@Override
		public String getString(Object object) {
			return (String) object;
		}
		
		@Override
		public String adapt(Object value) {
			return (String) value;
		}
	};

	/**
	 * Extracts from/Adapts the argument object to a <code>String<code>
	 * 
	 * @param object The argument object to adapt to a <code>String<code> by this adapter
	 * @return String the <code>String<code> object representation of the argument object
	 */
	public abstract String getString(Object object);
	
	public String adapt(Object value) {
		return getString(value);
	}

}