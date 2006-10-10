/**
 * <copyright>
 *
 * Copyright (c) 2002, 2006 IBM Corporation and others.
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

import org.eclipse.emf.query.conditions.Condition;

/**
 * A <code>Condition</code> object that tests for <code>Boolean</code>
 * arguments. The arguments being evaluated are adapted to a
 * <code>Boolean</code> first using a <code>BooleanAdapter</code> and then
 * compared to the initialization value of this <code>BooleanCondition</code>.
 * It evaluates to <code>true</code> when values are equal
 */
public class BooleanCondition
	extends Condition {

	private boolean booleanValue;

	private BooleanAdapter adapter;

	/**
	 * Constructs this <code>BooleanCondition</code> with a boolean value to
	 * test for. It uses the BooleanAdapter.DEFAULT adapter to handle the
	 * simplest case when argument objects are known to be instances of
	 * <code>Boolean</code> class
	 * 
	 * @param booleanValue
	 *            The initialization value of this <code>Condition</code> to
	 *            use in testing argument objects for equality.
	 */
	public BooleanCondition(boolean booleanValue) {
		this(booleanValue, BooleanAdapter.DEFAULT);
	}

	/**
	 * Constructs this <code>BooleanCondition</code> with a boolean value to
	 * test for. It uses the argument <code>BooleanAdapter</code> adapter to
	 * adapt argument objects to <code>Boolean</code> objects in order to do
	 * the comparison
	 * 
	 * @param booleanValue
	 *            The initialization value of this <code>Condition</code> to
	 *            use in testing argument objects for equality.
	 * @param adapter
	 *            The <code>BooleanAdapter</code> to use to extract a
	 *            <code>Boolean</code> representation of the argument object
	 *            when evaluating it.
	 */
	public BooleanCondition(boolean booleanValue, BooleanAdapter adapter) {
		this.booleanValue = booleanValue;
		this.adapter = adapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
	 */
	public boolean isSatisfied(Object object) {
		return adapter.getBoolean(object).booleanValue() == booleanValue;
	}

}