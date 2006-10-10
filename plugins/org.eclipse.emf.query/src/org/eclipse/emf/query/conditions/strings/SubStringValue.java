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

package org.eclipse.emf.query.conditions.strings;

import com.ibm.icu.text.Collator;
import com.ibm.icu.text.RuleBasedCollator;
import com.ibm.icu.text.SearchIterator;
import com.ibm.icu.text.StringSearch;

/**
 * A <code>StringValue</code> condition subclass that checks to see if the
 * initialization <code>String<code> 
 * value is a sub-string to the one being evaluated. 
 * The arguments being evaluated are adapted to a <code>String<code> first using a <code>StringAdapter</code> 
 * and then the initialization string will be compared with the string being     
 * evaluated to see if the initialization string is a sub-string of it.
 *
 */
public class SubStringValue
	extends StringValue {

	private static RuleBasedCollator CASE_INSENSITIVE_COLLATOR;

	static {
		CASE_INSENSITIVE_COLLATOR = (RuleBasedCollator) Collator.getInstance();
		CASE_INSENSITIVE_COLLATOR.setStrength(Collator.PRIMARY);
	}
	/**
	 * A simple constructor that takes an initialization <code>String<code> to 
	 * see if it is a sub-string of those being evaluated
	 * It defaults to using the StringAdapter.DEFAULT for adapting the evaluated 
	 * object to string before checking them, and it defaults to being case-sensitive.
	 *    
	 * @param subString The initialization <code>String<code> to see if it is a sub-string of those being evaluated
	 */
	public SubStringValue(String subString) {
		this(subString, true);
	}

	/**
	 * A constructor that takes an initialization <code>String<code> to 
	 * see if it is a sub-string of those being evaluated and a <code>StringAdapter</code> for  
	 * adapting the evaluated object to string before checking them.	 
	 * It defaults to being case-sensitive.
	 *    
	 * @param subString The initialization <code>String<code> to see if it is a sub-string of those being evaluated
	 * @param adpater The <code>StringAdapter</code> to use to get a <code>String<code> out of evaluated Objects
	 */
	public SubStringValue(String subString, StringAdapter adpater) {
		this(subString, true, adpater);
	}

	/**
	 * A constructor that takes an initialization <code>String<code> to 
	 * see if it is a sub-string of those being evaluated and a boolean  
	 * flag indicating whether the matching should be case-sensitive or not.
	 * It defaults to using the StringAdapter.DEFAULT for adapting the evaluated 
	 * object to string before checking them.
	 *    
	 * @param subString The initialization <code>String<code> to see if it is a sub-string of those being evaluated
	 * @param caseSensitive A boolean value specifying whether to use case in matching strings
	 */
	public SubStringValue(String subString, boolean caseSensitive) {
		this(subString, caseSensitive, StringAdapter.DEFAULT);
	}

	/**
	 * A constructor that takes an initialization <code>String<code> to 
	 * see if it is a sub-string of those being evaluated, a boolean  
	 * flag indicating whether the matching should be case-sensitive or not and
	 * and a <code>StringAdapter</code> for adapting the evaluated object to string before checking them.
	 *    
	 * @param subString The initialization <code>String<code> to see if it is a sub-string of those being evaluated
	 * @param caseSensitive A boolean value specifying whether to use case in matching strings
	 * @param adpater The <code>StringAdapter</code> to use to get a <code>String<code> out of evaluated Objects
	 */
	public SubStringValue(String subString, boolean caseSensitive,
		StringAdapter adpater) {
		super(subString, caseSensitive, adpater);
	}

	/**
	 * Checks to see if the initialization
	 * <code>String<code> to is a sub-string of the 
	 * argument string being evaluated
	 * 
	 * @see org.eclipse.emf.query.conditions.strings.StringCondition#isSatisfied(java.lang.String)
	 */
	public boolean isSatisfied(String str) {
		StringSearch search = new StringSearch(getString(), str);
		
		if (!isCaseSensitive()) {
			search.setCollator(CASE_INSENSITIVE_COLLATOR);
		}
		
		return search.next() != SearchIterator.DONE;
	}

}