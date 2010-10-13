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
package org.eclipse.emf.query2.internal.bql.api;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;


/**
 * Implements the Like operator
 */
@Deprecated
public final class SpiLike extends SpiLeafExpression {

	// wildcard characters
	public static final char ZERO_TO_N_ARBITRARY_CHARACTERS = '*';

	public static final char ONE_ARBITRARY_CHARACTER = '?';

	// escape character
	public static final char ESCAPE_CHARACTER = '\\';

	private String pattern;

	private boolean not;

	private Object[] parseResult;

	/**
	 * Constructor takes a list of operands.
	 * <p>
	 * LIMITATION: all strings returned by the facility should cut off any
	 * trailing blanks as this is the standard behaviour from OpenSQL (which is
	 * the driving implementation) of BQL. String patterns inserted in BQL
	 * expressions from MQL will not contain trailing blanks. Thus, patterns
	 * such as "mystr *" can be entered, but "mystr * " won't occur. Moreover,
	 * all pattern variables in trailing positions do <b>not</b> match blanks,
	 * and, if a trailing pattern variable is preceded by a blank, such
	 * wildcards do not match the empty string. So, "mystr *" will match "mystr
	 * a", but not "mystr ", not "mystr" and not even "mystr ".
	 */
	public SpiLike(String anId, boolean not, String pattern) {

		super(anId, SpiFqlPrimitiveType.STRING);
		this.pattern = pattern;
		this.parseResult = this.parsePattern(pattern);
		this.not = not;
	}

	/**
	 * Parses the pattern string if not already done. The result of the parsing
	 * is an object array. Each object of the array of the parseResult is either
	 * a string representing a sub string of the pattern or an Integer
	 * representing one or more wildcard characters. If an ESCAPE_CHARACTER
	 * character is found then the following character has no special meaning.
	 * This method extracts the unescaped special characters
	 * ZERO_TO_N_ARBITRARY_CHARACTERS and ONE_ARBITRARY_CHARACTER. For the
	 * remaining substrings containing escaped special characters and characters
	 * without special meaning the ESCAPE_CHARACTER characters are removed.
	 * Successive unescaped special characters are condensed into Integer
	 * objects v with the following meaning: v == 0: 0 ore more arbitrary
	 * characters, v < 0: abs(v) ore more arbitrary characters, v > 0: v
	 * arbitrary characters.
	 * <p>
	 * For instance, the parsing of the pattern "hallo*A?B*?C*?*D???E\*" results
	 * into the following parseResult: {"hallo", 0, "A", 1, "B", -1, "C", -1,
	 * "D", 3, "E*"}
	 * 
	 * @return array of objects containing sub-strings and Integer objects
	 *         specifying arbitrary characters
	 */
	private Object[] parsePattern(String _pattern) {

		List<Object> parseResultList = new ArrayList<Object>();
		int patternLength = _pattern.length();
		// string buffer for constructing the pattern sub strings
		StringBuffer buf = new StringBuffer();
		// counter for the currently relevant occurrences of ONE_ARBITRARY_CHARACTER
		int numberOfOneArbitraryCharacters = 0;
		// counter for the currently relevant occurrences of ZERO_TO_N_ARBITRARY_CHARACTERS
		int numberOfZeroToNArbitraryCharacters = 0;
		for (int currentPos = 0; currentPos < patternLength; currentPos++) {
			char currentChar = _pattern.charAt(currentPos);
			switch (currentChar) {
			case ZERO_TO_N_ARBITRARY_CHARACTERS:
				// new wildcard character -> put current sub string (if there is one) into the parse result and
				// reset current sub string
				if (buf.length() > 0) {
					parseResultList.add(buf.toString());
					buf.delete(0, buf.length());
				}
				numberOfZeroToNArbitraryCharacters++;
				break;
			case ONE_ARBITRARY_CHARACTER:
				// new wildcard character -> put current sub string (if there is one) into the parse result and
				// reset current sub string
				if (buf.length() > 0) {
					parseResultList.add(buf.toString());
					buf.delete(0, buf.length());
				}
				numberOfOneArbitraryCharacters++;
				break;
			case ESCAPE_CHARACTER:
				addWildcardCharacterIntegerObjectToParseResultList(numberOfOneArbitraryCharacters, numberOfZeroToNArbitraryCharacters,
						parseResultList);
				numberOfOneArbitraryCharacters = 0;
				numberOfZeroToNArbitraryCharacters = 0;
				currentPos++;
				if (currentPos >= patternLength) {
					throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
							BQLBugMessages.FALSE_ESCAPE_CHARACTER_SETTING_PATTERN, _pattern);
				}
				currentChar = _pattern.charAt(currentPos);
				buf.append(currentChar);
				break;
			default:
				addWildcardCharacterIntegerObjectToParseResultList(numberOfOneArbitraryCharacters, numberOfZeroToNArbitraryCharacters,
						parseResultList);
				numberOfOneArbitraryCharacters = 0;
				numberOfZeroToNArbitraryCharacters = 0;
				buf.append(currentChar);
			}
		}
		addWildcardCharacterIntegerObjectToParseResultList(numberOfOneArbitraryCharacters, numberOfZeroToNArbitraryCharacters,
				parseResultList);
		if (buf.length() > 0) {
			parseResultList.add(buf.toString());
			buf.delete(0, buf.length());
		}

		return parseResultList.toArray();
	}

	/**
	 * Adds arbitrary character specifying Integer object to parse result list
	 * if required
	 * 
	 * @param numberOfOneArbitraryCharacters
	 *            number of special characters specifying one arbitrary
	 *            character
	 * @param numberOfZeroOneToNArbitraryCharacters
	 *            number of special characters specifying zero to n arbitrary
	 *            characters
	 * @param parseResultList
	 *            parse result list which is to be updated
	 */
	private void addWildcardCharacterIntegerObjectToParseResultList(int numberOfOneArbitraryCharacters,
			int numberOfZeroToNArbitraryCharacters, List<Object> parseResultList) {

		if (numberOfOneArbitraryCharacters == 0 && numberOfZeroToNArbitraryCharacters == 0) {
			// no arbitrary character - do nothing
			return;
		}
		int value = numberOfOneArbitraryCharacters;
		if (numberOfZeroToNArbitraryCharacters > 0) {
			value = -value;
		}
		parseResultList.add(Integer.valueOf(value));
	}

	/**
	 * @return Returns the pattern.
	 */
	public String getPattern() {

		return this.pattern;
	}

	public Object[] getParseResult() {

		return this.parseResult;
	}

	public boolean isNegated() {

		return this.not;
	}

	/**
     *
     */
	public void toString(StringBuffer sb, int ident, boolean newline) {

		if (newline) {
			SpiUtils.toStringNewLine(sb, ident);
		}
		sb.append(SpiUtils.OPENING_PARENTHESES);
		sb.append(this.getAttributeId());
		sb.append(' ');
		sb.append(SpiUtils.LIKE);
		sb.append(' ');
		sb.append(this.pattern);
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}

}
