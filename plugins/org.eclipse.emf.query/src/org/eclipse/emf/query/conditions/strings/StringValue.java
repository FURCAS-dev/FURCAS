/******************************************************************************
 * Copyright (c) 2002, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.query.conditions.strings;

/**
 * A <code>String<code> related condition class that compares a <code>String<code> value to another. 
 * The arguments being evaluated are adapted to a <code>String<code> first using a <code>StringAdapter</code> 
 * and then the string will be compared with the initialization string  
 * to see if they are equal.
 *
 */
public class StringValue
	extends StringCondition {

	private String string;

	private boolean caseSensitive;

	/**
	 * A simple constructor that takes an initialization
	 * <code>String<code> to match against.
	 * It defaults to using the StringAdapter.DEFAULT for adapting the evaluated 
	 * object to string before matching them, and it defaults to being case-sensitive.
	 *    
	 * @param string the initialization <code>String<code> to use for equality testing
	 */
	public StringValue(String string) {
		this(string, true);
	}

	/**
	 * A simple constructor that takes an initialization
	 * <code>String<code> to match against.
	 * It defaults to using the StringAdapter.DEFAULT for adapting the evaluated 
	 * object to string before matching them.
	 *    
	 * @param string the initialization <code>String<code> to use for equality testing
	 * @param caseSensitive a boolean value specifying whether to use case in matching strings
	 */
	public StringValue(String string, boolean caseSensitive) {
		this(string, caseSensitive, StringAdapter.DEFAULT);
	}

	/**
	 * A simple constructor that takes an initialization
	 * <code>String<code> to match against,
	 * a <code>StringAdapter</code> for adapting the evaluated object to string before matching 
	 * them and a boolean flag indicating whether the pattern matching 
	 * should be case-sensitive or not.	 
	 *    
	 * @param string the initialization <code>String<code> to use for equality testing
	 * @param caseSensitive a boolean value specifying whether to use case in matching strings
	 * @param adpater The <code>StringAdapter</code> to use to get a <code>String<code> out of evaluated Objects
	 */
	public StringValue(String string, boolean caseSensitive,
		StringAdapter adpater) {
		super(adpater);
		this.string = (caseSensitive) ? string : string.toLowerCase();
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Tests whether the argument string equals to the initialization
	 * <code>String<code>. 
	 * @see org.eclipse.emf.query.conditions.strings.StringCondition#isSatisfied(java.lang.String)
	 */
	public boolean isSatisfied(String str) {
		return getString().equals(
			(isCaseSensitive()) ? str : str.toLowerCase());
	}

	/**
	 * A getter function for the case-sensitive value used by this
	 * <code>StringValue</code> condition
	 * 
	 * @return boolean indicating whether or not to compare string in
	 *         case-sensitive manner or not.
	 */
	protected final boolean isCaseSensitive() {
		return caseSensitive;
	}

	/**
	 * A getter function for the
	 * <code>String<code> used by this <code>StringValue</code> condition for comparison
	 * with other argument string
	 * 
	 * @return The initialization <code>String<code> that this <code>StringValue</code> condition uses for testing
	 */
	protected final String getString() {
		return string;
	}

}