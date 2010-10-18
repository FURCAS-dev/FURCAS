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

import java.util.regex.Pattern;

import org.eclipse.emf.query.conditions.IDataTypeAdapter;

/**
 * A <code>StringValue</code> condition subclass that tests for
 * <code>String<code> using regular expression. 
 * The arguments being evaluated are adapted to a <code>String<code> first using a <code>StringAdapter</code> 
 * and then the string will be compared with the initialization regular expression 
 * to see if it matches.
 *
 */
public class StringRegularExpressionValue
	extends StringValue {

	private Pattern pattern;

	/**
	 * A simple constructor that takes the regular expression to use for
	 * matching. It defaults to using the StringAdapter.DEFAULT for adapting the
	 * evaluated object to string before matching them, and it defaults to being
	 * case-sensitive.
	 * 
	 * @param patternStr
	 *            The regular expression pattern to use for matching strings
	 *            when evaluating this <code>StringRegularExpressionValue</code>
	 *            condition
	 */
	public StringRegularExpressionValue(String patternStr) {
		this(patternStr, StringAdapter.DEFAULT);
	}

	/**
	 * A constructor that takes the regular expression to use for matching, and
	 * a <code>StringAdapter</code> for adapting the evaluated object to
	 * string before matching them. It defaults to being case-sensitive.
	 * 
	 * @param patternStr
	 *            The regular expression pattern to use for matching strings
	 *            when evaluating this <code>StringRegularExpressionValue</code>
	 *            condition.
	 * @param adapter
	 *            The <code>StringAdapter</code> to use to get a
	 *            <code>String<code> out of evaluated Objects
	 */
	public StringRegularExpressionValue(String patternStr, StringAdapter adapter) {
		this(patternStr, true, adapter);
	}

	/**
	 * A constructor that takes the regular expression to use for matching, and
	 * a <code>StringAdapter</code> for adapting the evaluated object to
	 * string before matching them. It defaults to being case-sensitive.
	 * 
	 * @param patternStr
	 *            The regular expression pattern to use for matching strings
	 *            when evaluating this <code>StringRegularExpressionValue</code>
	 *            condition.
	 * @param adapter
	 *            A generic string adapter to use to get a
	 *            <code>String<code> out of evaluated Objects
	 *            
	 * @since 1.2
	 */
	public StringRegularExpressionValue(String patternStr, IDataTypeAdapter<String> adapter) {
		this(patternStr, true, adapter);
	}

	/**
	 * A constructor that takes the regular expression to use for matching, a
	 * <code>StringAdapter</code> for adapting the evaluated object to string
	 * before matching them and a boolean flag indicating whether the pattern
	 * matching should be case-sensitive or not.
	 * 
	 * @param patternStr
	 *            The regular expression pattern to use for matching strings
	 *            when evaluating this <code>StringRegularExpressionValue</code>
	 *            condition.
	 * @param caseSensitive
	 *            a boolean value specifying whether to use case in matching
	 *            strings
	 * @param adapter
	 *            The <code>StringAdapter</code> to use to get a
	 *            <code>String<code> out of evaluated Objects
	 */
	public StringRegularExpressionValue(String patternStr,
		boolean caseSensitive, StringAdapter adapter) {
		super(patternStr, caseSensitive, adapter);
		pattern = (caseSensitive) ? Pattern.compile(patternStr) : Pattern
			.compile(patternStr, Pattern.CASE_INSENSITIVE
				| Pattern.UNICODE_CASE);
	}

	/**
	 * A constructor that takes the regular expression to use for matching, a
	 * <code>StringAdapter</code> for adapting the evaluated object to string
	 * before matching them and a boolean flag indicating whether the pattern
	 * matching should be case-sensitive or not.
	 * 
	 * @param patternStr
	 *            The regular expression pattern to use for matching strings
	 *            when evaluating this <code>StringRegularExpressionValue</code>
	 *            condition.
	 * @param caseSensitive
	 *            a boolean value specifying whether to use case in matching
	 *            strings
	 * @param adapter
	 *            A generic string adapter to use to get a
	 *            <code>String<code> out of evaluated Objects
	 *            
	 * @since 1.2
	 */
	public StringRegularExpressionValue(String patternStr,
		boolean caseSensitive, IDataTypeAdapter<String> adapter) {
		super(patternStr, caseSensitive, adapter);
		pattern = (caseSensitive) ? Pattern.compile(patternStr) : Pattern
			.compile(patternStr, Pattern.CASE_INSENSITIVE
				| Pattern.UNICODE_CASE);
	}

	/**
	 * Answers whether the argument string matches the regular expression used
	 * in initialization of this <code>StringRegularExpressionValue</code>
	 * 
	 * @see org.eclipse.emf.query.conditions.strings.StringCondition#isSatisfied(java.lang.String)
	 */
	@Override
	public boolean isSatisfied(String str) {
		return getPattern().matcher(str).find();
	}

	/**
	 * A getter for the <code>Pattern</code> used by this
	 * <code>StringRegularExpressionValue</code>
	 * 
	 * @return Pattern The <code>Pattern</code> generated by compiling the
	 *         regular expression
	 */
	protected final Pattern getPattern() {
		return pattern;
	}
}