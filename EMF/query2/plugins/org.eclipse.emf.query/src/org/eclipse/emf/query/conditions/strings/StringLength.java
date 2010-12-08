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
 * A Condition object that tests for
 * <code>String<code> length values. The arguments being evaluated
 * are adapted to a <code>String<code> first using a <code>StringAdapter</code> and then the length of the
 * string will be compared with the initialization numeric values to see if it is
 * equal/in-range.
 *
 */
public class StringLength
	extends StringCondition {

	private int upperBound;

	private int lowerBound;

	/**
	 * A simple constructor that takes one int argument to test strings' length
	 * against It evaluates to <code>true</code> when the evaluated
	 * <code>String<code> length equals the length 
	 * initialization argument. It defaults to using the StringAdapter.DEFAULT
	 * for adapting the evaluated object to string before getting their length.
	 * 
	 * @param length The int value that the evaluated string length must match
	 */
	public StringLength(int length) {
		this(length, StringAdapter.DEFAULT);
	}

	/**
	 * A constructor that takes one int argument to test strings' length against
	 * and a <code>StringAdapter</code>. It evaluates to <code>true</code>
	 * when the evaluated <code>String<code> length equals the length 
	 * initialization argument. It uses the argument <code>StringAdapter</code> 
	 * for adapting the evaluated object to string before getting their length.
	 * 
	 * @param length The int value that the evaluated string length must match
	 * @param adapter The <code>StringAdapter</code> to use to get a <code>String<code> out of evaluated Objects
	 */
	public StringLength(int length, StringAdapter adapter) {
		this(length, length, adapter);
	}

	/**
	 * A constructor that takes one int argument to test strings' length against
	 * and a <code>StringAdapter</code>. It evaluates to <code>true</code>
	 * when the evaluated <code>String<code> length equals the length 
	 * initialization argument. It uses the argument <code>StringAdapter</code> 
	 * for adapting the evaluated object to string before getting their length.
	 * 
	 * @param length The int value that the evaluated string length must match
	 * @param adapter a generic string adapter to use to get a <code>String<code> out of evaluated Objects
	 * 
	 * @since 1.2
	 */
	public StringLength(int length, IDataTypeAdapter<String> adapter) {
		this(length, length, adapter);
	}

	/**
	 * A constructor that takes two int arguments representing a range to test
	 * strings' length against. It evaluates to <code>true</code> when the
	 * evaluated <code>String<code> length is equal to any 
	 * these two int values passed or fall in between.
	 * It defaults to using the StringAdapter.DEFAULT
	 * for adapting the evaluated object to string before getting their length.
	 * 
	 * @param lowerBound the int value representing the lower-bound in range testing
	 * @param upperBound the int value representing the upper-bound in range testing
	 */
	public StringLength(int lowerBound, int upperBound) {
		this(lowerBound, upperBound, StringAdapter.DEFAULT);
	}

	/**
	 * A constructor that takes two int arguments representing a range to test
	 * strings' length against. It evaluates to <code>true</code> when the
	 * evaluated <code>String<code> length is equal to any 
	 * these two int values passed or fall in between. It uses the argument <code>StringAdapter</code> 
	 * for adapting the evaluated object to string before getting their length.
	 * 
	 * @param lowerBound the int value representing the lower-bound in range testing
	 * @param upperBound the int value representing the upper-bound in range testing
	 * @param adapter The <code>StringAdapter</code> to use to get a <code>String<code> out of evaluated Objects
	 */
	public StringLength(int lowerBound, int upperBound, StringAdapter adapter) {
		super(adapter);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	/**
	 * A constructor that takes two int arguments representing a range to test
	 * strings' length against. It evaluates to <code>true</code> when the
	 * evaluated <code>String<code> length is equal to any 
	 * these two int values passed or fall in between. It uses the argument <code>StringAdapter</code> 
	 * for adapting the evaluated object to string before getting their length.
	 * 
	 * @param lowerBound the int value representing the lower-bound in range testing
	 * @param upperBound the int value representing the upper-bound in range testing
	 * @param adapter a generic string adapter to use to get a <code>String<code> out of evaluated Objects
	 */
	public StringLength(int lowerBound, int upperBound, IDataTypeAdapter<String> adapter) {
		super(null, adapter);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.strings.StringCondition#isSatisfied(java.lang.String)
	 */
	@Override
	public boolean isSatisfied(String str) {
		return ((str.length() >= lowerBound) && (str.length() <= upperBound));
	}

}