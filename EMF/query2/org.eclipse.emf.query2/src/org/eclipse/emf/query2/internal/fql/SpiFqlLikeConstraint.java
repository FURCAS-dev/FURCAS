/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.fql;

/**
 * This constraint on an attribute permits the verification of a string pattern
 * (modulo some conditions as indicated in {@link #getLikePattern()})
 * 
 * @author D045917
 */
public interface SpiFqlLikeConstraint extends SpiFqlValueConstraint {

	// wildcard characters
	static final char ZERO_TO_N_ARBITRARY_CHARACTERS = '*';

	static final char ONE_ARBITRARY_CHARACTER = '?';

	// escape character
	static final char ESCAPE_CHARACTER = '\\';

	/**
	 * Returns the like pattern to be used in the constraint.
	 * <p>
	 * A pattern may contain the following special pattern matching characters:
	 * <ul>
	 * <li>'?' : matches with any character</li>
	 * <li>'*' : matches with any sequence of characters, including the empty
	 * sequence</li>
	 * <li>'\' : escapes the pattern matching characters '?' and '*', including
	 * '\', i.e. itself</li>
	 * </ul>
	 * Note that the empty string is a legal pattern. Null however is not!
	 * Moreover, the following limitations are in place:
	 * <ul>
	 * <li>LIMITATION 1: the pattern constant part cannot be longer than 200
	 * characters. Moreover, a match will only take place on the first 200
	 * characters.
	 * <li>LIMITATION 2: the pattern is not allowed to have trailing blanks,
	 * also not when they are preceded with a pattern variable. For example,
	 * 'myStr ' and 'myStr * ' are both illegal patterns. Trailing pattern
	 * variables do not match blanks. E.g. 'myStr*' will not match a stored
	 * value 'myStr ', but it will match 'myStr str'. Moreover, a trailing
	 * pattern with preceding blanks does not match blanks or the empty string.
	 * For example the pattern 'myStr *' is permitted and matches 'myStr str',
	 * but not 'myStr', or even 'myStr '.
	 * </ul>
	 */
	String getLikePattern();
}
