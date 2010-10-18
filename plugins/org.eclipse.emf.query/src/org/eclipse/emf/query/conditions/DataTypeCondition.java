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
 * $Id: DataTypeCondition.java,v 1.1 2007/11/08 23:00:30 cdamus Exp $
 */
package org.eclipse.emf.query.conditions;


/**
 * A condition on data-type (primitive) values.
 * 
 * @param <T> the data type, of which values the condition tests
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public class DataTypeCondition<T>
	extends Condition {

	private static IDataTypeAdapter<?> DEFAULT_ADAPTER = new IDataTypeAdapter<Object>() {
		public Object adapt(Object value) {
			return value;
		}};
	
	protected final IDataTypeAdapter<? extends T> adapter;
	
	protected final T value;
	
	public DataTypeCondition(T value, IDataTypeAdapter<? extends T> adapter) {
		this.value = value;
		this.adapter = adapter;
	}
	
	@SuppressWarnings("unchecked")
	public DataTypeCondition(T value) {
		this(value, (IDataTypeAdapter<T>) DEFAULT_ADAPTER);
	}
	
	// Documentation copied from the inherited specification
	@Override
	public boolean isSatisfied(Object object) {
		return value.equals(adapter.adapt(object));
	}

}
