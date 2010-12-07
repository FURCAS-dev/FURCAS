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
/*
 * Created on 12.02.2006
 */
package org.eclipse.emf.query2;

/**
 * Compares a string value with one of the possible operations.
 */
final public class WhereString extends WhereComparator {

	/*
	 * Comparison value
	 */
	private String stringValue;

	/**
	 * If the operator is not {@link Operation#LIKE}, then the predicate is true
	 * if the stringValue is equal (or not equal) to the attribute value in the
	 * way determined by the operator. Only the two equality operations
	 * {@link Operation#EQUAL} and {@link Operation#NOTEQUAL} are allowed. If
	 * the operator is {@link Operation#LIKE}, then the predicate is true if the
	 * attribute value is an instance of the pattern in the string value. A
	 * pattern is a string and may contain the following special pattern
	 * matching characters:
	 * <ul>
	 * <li>'?' : matches with any character</li>
	 * <li>'*' : matches with any sequence of characters, including the empty
	 * sequence</li>
	 * <li>'\' : escapes the pattern matching characters '?' and '*', including
	 * '\', i.e. itself</li>
	 * </ul>
	 * If the multiplicity <> 1, then the predicate is true whenever the
	 * comparison holds for one or more elements from the collection.
	 * <p>
	 * LIMITATION 1: an attribute comparison with {@link Operation#EQUAL} or
	 * {@link Operation#NOTEQUAL} on a string constant does not allow the string
	 * constant to have trailing blanks. For example, it is not allowed to
	 * compare with 'myStr '. Moreover, the comparison happens modulo trailing
	 * blanks for <i>stored</i> attributes (it is possible to persist strings
	 * with trailing blanks in MOIN). For example, the comparison attr = 'myStr'
	 * will be true if attr is 'myStr' <i>or</i> 'myStr '.
	 * <p>
	 * LIMITATION 2: an attribute comparison with {@link Operation#LIKE} on a
	 * string constant does not allow the comparison pattern to have trailing
	 * blanks, also not when they are preceded with a pattern variable. For
	 * example, 'myStr ' and 'myStr * ' are both illegal patterns. Trailing
	 * pattern variables do not match blanks. E.g. 'myStr*' will not match a
	 * stored value 'myStr ', but it will match 'myStr str'. Moreover, a
	 * trailing pattern with preceding blanks does not match blanks or the empty
	 * string. For example the pattern 'myStr *' is permitted and matches 'myStr
	 * str', but not 'myStr', or even 'myStr '.
	 * <p>
	 * LIMITATION 3: Both the comparisons {@link Operation#EQUAL} and
	 * {@link Operation#LIKE} do not allow a string constant or constant part
	 * (in the case of LIKE) which is longer than 200 characters. Moreover, in
	 * the case of LIKE, a match will only take place on the first 200
	 * characters. This limitation is caused by the underlying database schema
	 * and can be handled with the following workaround. If you have a string
	 * constant which is longer than 200 characters, compare only for the first
	 * 200 characters. The result set thus may include more matches than
	 * anticipated and simply has to be further reduced by doing the full match
	 * in Java.
	 * 
	 * @param _attrName
	 *            the attribute name taking part in the comparison
	 * @param _operation
	 *            the operation with which is compared
	 * @param _stringValue
	 *            the string value to be compared against
	 */
	public WhereString(String _attrName, Operation _operation, String _stringValue) {

		this.attrName = _attrName;
		this.operation = _operation;

		// in the concrete syntax, this check is handled by the lexer
		if (this.operation.equals(Operation.LIKE)) {
			boolean removeLastChar = false;
			// if not null, we verify if the pattern has no illegal escapes
			char[] valueAsChars = _stringValue.toCharArray();
			for (int i = 0; i < valueAsChars.length; i++) {
				switch (valueAsChars[i]) {
				case '\\':
					i++;
					// when we have the escape sign, we only accept 3 characters
					if (i >= valueAsChars.length) {
						// escape sign at end of pattern -> remove escaper
						removeLastChar = true;
					} else {
						switch (valueAsChars[i]) {
						case '\\':
						case '?':
						case '*':
							// all is good in this scenario
							break;
						default:
							// remove escaper
							valueAsChars[i - 1] = ' ';
							break;
						}
					}
					break;
				default: // all good, nothing to do
				}
			}
			// possibly repair string
			if (removeLastChar) {
				this.stringValue = String.copyValueOf(valueAsChars, 0, valueAsChars.length - 2);
			} else {
				this.stringValue = String.copyValueOf(valueAsChars);
			}
		} else {
			this.stringValue = _stringValue;
		}
	}

	/**
	 * Returns the value to which the string-typed attribute is compared.
	 * 
	 * @return the value to which the string-typed attribute is compared.
	 */
	public String getStringValue() {

		return this.stringValue;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		super.toString(sb, indent);
		if (this.stringValue != null) {
			sb.append("'"); //$NON-NLS-1$
			sb.append(this.stringValue);
			sb.append("'"); //$NON-NLS-1$
		} else {
			sb.append("null"); //$NON-NLS-1$
		}
	}
}
