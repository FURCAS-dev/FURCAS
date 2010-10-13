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
 * This constraint stands for a numerical comparison with some constraints as
 * listed in {@link #getOperandValue()}.
 * 
 * @author D045917
 */
public interface SpiFqlNumericConstraint extends SpiFqlValueConstraint {

	/**
	 * Returns one of the comparing operators as defined by
	 * {@link SpiFqlComparisonOperation}.
	 */
	SpiFqlComparisonOperation getOperation();

	/**
	 * Returns the value which is used to compare the attribute with. The
	 * attribute has to be of one of MOF's 6 simple types (i.e. int, long,
	 * float, double, boolean, string) as indicated by the primitive type of the
	 * condition Null is a legal constant to compare attribute values with. The
	 * following restrictions are in place:
	 * <ul>
	 * <li>int, long, float, double: all operations are permitted with the
	 * expected semantics
	 * <li>boolean: only the operation EQUAL is permitted with the expected
	 * semantics
	 * <li>string: only the operations NOTEQUAL, and EQUAL are permitted. Note
	 * that an empty string is a legal value for a comparison. In addition, we
	 * have the following restrictions:
	 * <ul>
	 * <li>LIMITATION 1: a comparison for a string-typed attribute does not
	 * allow a string constant which is longer than 200 characters. Moreover, if
	 * the stored attribute has more than 200 characters, only the first 200
	 * characters are considered in the comparison.
	 * <li>LIMITATION 2: a string attribute comparison does not allow the string
	 * constant to have trailing blanks. For example, it is not allowed to
	 * compare with 'myStr '. Moreover, the comparison happens modulo trailing
	 * blanks for <i>stored</i> attributes (it is possible to persist strings
	 * with trailing blanks in MOIN). For example, the comparison attr = 'myStr'
	 * will be true if attr is 'myStr' <i>or</i> 'myStr '.
	 * </ul>
	 * </ul>
	 */
	Object getOperandValue();
}
