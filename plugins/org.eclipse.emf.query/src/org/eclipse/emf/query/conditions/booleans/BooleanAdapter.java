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

package org.eclipse.emf.query.conditions.booleans;

import org.eclipse.emf.query.conditions.IDataTypeAdapter;

/**
 * An Adapter class to be used to extract from -adapt- the argument object some
 * Boolean object (value) that would later be used in <code>Condition</code>
 * evaluation. Clients can subclass an provide their own implementation
 * 
 * @see BooleanCondition
 */
public abstract class BooleanAdapter implements IDataTypeAdapter<Boolean> {

	/**
	 * The simplest <code>BooleanAdapter</code> implementation that represents
	 * the case when the argument object to adapt is a <code>Boolean</code>
	 * object itself.
	 */
	public static final BooleanAdapter DEFAULT = new BooleanAdapter() {

		@Override
		public Boolean getBoolean(Object object) {
			return (Boolean) object;
		}
		
		@Override
		public Boolean adapt(Object value) {
			return (Boolean) value;
		}
	};

	/**
	 * Extracts from/Adapts the argument object to a <code>Boolean</code>
	 * 
	 * @param object
	 *            The argument object to adapt to a <code>Boolean</code> by
	 *            this adapter
	 * @return Boolean the <code>Boolean</code> object representation of the argument object
	 */
	public abstract Boolean getBoolean(Object object);
	
	public Boolean adapt(Object value) {
		return getBoolean(value);
	}
}