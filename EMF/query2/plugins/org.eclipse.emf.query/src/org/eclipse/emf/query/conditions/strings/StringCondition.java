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

import org.eclipse.emf.query.conditions.DataTypeCondition;
import org.eclipse.emf.query.conditions.IDataTypeAdapter;

/**
 * An abstract <code>Condition</code> object that tests for
 * <code>String<code> related values. The arguments being evaluated
 * are adapted to a <code>String<code> first using a <code>StringAdapter</code> and then subjected to evaluation
 *
 */
public abstract class StringCondition
	extends DataTypeCondition<String> {

	/**
	 * Constructs this <code>StringCondition</code> with a
	 * <code>StringAdapter</code> adapter to adapt argument objects to
	 * <code>String<code> objects in order to do the evaluation 
	 *  
	 * @param adapter The <code>StringAdapter</code> to use to extract a <code>String<code> representation
	 * of the argument object when evaluating it.
	 */
	protected StringCondition(StringAdapter adapter) {
		this(null, adapter);
	}

	/**
	 * Constructs this <code>StringCondition</code> with a
	 * <code>StringAdapter</code> adapter to adapt argument objects to
	 * <code>String<code> objects in order to do the evaluation, and a string
	 * to test inputs against.
	 *  
	 * @param value the value against which to test inputs
	 * @param adapter a generic string adapter to use to extract a <code>String<code> representation
	 * of the argument object when evaluating it.
	 * 
	 * @since 1.2
	 */
	protected StringCondition(String value, IDataTypeAdapter<String> adapter) {
		super(value, adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
	 */
	@Override
	public boolean isSatisfied(Object object) {
		return isSatisfied(adapter.adapt(object));
	}

	/**
	 * An abstract method that answers whether the argument string satisfies
	 * this <code>StringCondition</code>
	 * 
	 * @param str
	 *            The <code>String<code> to evaluate
	 * @return boolean <code>true</code> if the argument string satisfies this <code>StringCondition</code>, <code>false</code> otherwise
	 */
	public abstract boolean isSatisfied(String str);

}