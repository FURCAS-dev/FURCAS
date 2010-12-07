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
 * The attribute comparison constraint is set over type {@link SpiFqlQueryEntry}
 * s as indicated by {@link #getLeftQueryEntry()} and
 * {@link #getRightQueryEntry()}. The permitted operations and limitations are
 * given in {@link #getOperation()}.
 * 
 * @author D045917
 */
public interface SpiFqlAttributeComparisonConstraint extends SpiFqlJoinConstraint {

	/**
	 * Returns the permitted comparison operations.
	 * <p>
	 * The provided attributes have to be of one of MOF's 6 simple types (i.e.
	 * int, long, float, double, boolean, string). In the case of string, the
	 * comparison operation reduces to equality or inequality. In the case of
	 * boolean, the comparison reduces to equality. If either one or both
	 * attributes are multi-valued, the operation returns true as soon as one
	 * pair of values satisfies the comparison.
	 * <p>
	 * We have the following additional limitations:
	 * <ul>
	 * <li>LIMITATION 1: an attribute comparison on string-typed values will
	 * ignore trailing blanks, so the (in-)equality on strings happens modulo
	 * these trailing blanks.
	 * <li>LIMITATION 2: an attribute comparison on string-typed values will
	 * only consider the first 200 characters, so the equality on strings
	 * happens modulo the first 200 characters.
	 * <ul>
	 */
	SpiFqlComparisonOperation getOperation();

	/**
	 * The left query entry from which the left attribute is taken for
	 * comparison.
	 */
	SpiFqlQueryEntry getLeftQueryEntry();

	/**
	 * The attribute of the left query entry which is used for comparison. For
	 * permitted values, see {@link #getOperation()}.
	 */
	String getLeftAttributeName();

	/**
	 * Returns whether the attribute of the left query entry is multivalued.
	 */
	boolean isLeftAttributeMultiValued();

	/**
	 * Returns the primitive type of the attribute of the left query entry.
	 */
	SpiFqlPrimitiveType getPrimitiveTypeOfLeftAttribute();

	/**
	 * The right query entry from which the right attribute is taken for
	 * comparison.
	 */
	SpiFqlQueryEntry getRightQueryEntry();

	/**
	 * The attribute of the right query entry which is used for comparison. For
	 * permitted values, see {@link #getOperation()}.
	 */
	String getRightAttributeName();

	/**
	 * Returns whether the attribute of the right query entry is multivalued.
	 */
	boolean isRightAttributeMultiValued();

	/**
	 * Returns the primitive type of the attribute of the right query entry.
	 */
	SpiFqlPrimitiveType getPrimitiveTypeOfRightAttribute();

}
