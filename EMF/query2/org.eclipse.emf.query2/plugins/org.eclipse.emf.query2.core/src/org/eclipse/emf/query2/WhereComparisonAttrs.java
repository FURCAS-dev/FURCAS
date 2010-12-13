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
 * Created on 10.02.2006
 */
package org.eclipse.emf.query2;

/**
 * A where-comparison attributes compares two attributes of two aliases to each
 * other for equality, where both attributes have to be of the same primitive
 * type.
 */
final public class WhereComparisonAttrs extends JoinWhereEntry {

	/*
	 * The left-hand attribute name
	 */
	private String leftAttrName;

	/*
	 * The operation used in the comparison (LIKE not permitted)
	 */
	private Operation operation;

	/*
	 * The right-hand alias
	 */
	private String rightAlias;

	/*
	 * the right-hand attribute name
	 */
	private String rightAttrName;

	/**
	 * Constructs a predicate which compares two primitively typed attributes
	 * (where enumeration labels are handled as strings) of two aliases in the
	 * way determined by the operation. If one attribute has a multiplicity type
	 * different than 1, then the predicate returns true whenever the comparator
	 * holds for at least one element in the collection of the multi-valued
	 * attribute. If both attributes have multiplicity different than 1, then
	 * the predicate is true whenever at least one pair exists for which the
	 * comparator is true. Only attributes of primitive types are allowed, i.e.
	 * boolean, integer, long, float, double, and String. The operation does not
	 * include LIKE and only permits scalar comparison on numeric types, i.e.
	 * not on boolean and strings.
	 * <p>
	 * LIMITATION 1: an attribute comparison on string-typed values will ignore
	 * trailing blanks, so the equality on strings happens modulo these trailing
	 * blanks.
	 * <p>
	 * LIMITATION 2: an attribute comparison on string-typed values will only
	 * consider the first 200 characters, so the equality on strings happens
	 * modulo the first 200 characters!
	 * 
	 * @param _leftAlias
	 *            the left alias.
	 * @param _leftAttrName
	 *            the left attribute name.
	 * @param _operation
	 *            the operation.
	 * @param _rightAlias
	 *            the right alias.
	 * @param _rightAttrName
	 *            the right attribute name.
	 */
	public WhereComparisonAttrs(String _leftAlias, String _leftAttrName, Operation _operation, String _rightAlias, String _rightAttrName) {

		this.operation = _operation;
		this.leftAlias = _leftAlias;
		this.leftAttrName = _leftAttrName;
		this.rightAlias = _rightAlias;
		this.rightAttrName = _rightAttrName;
	}

	/**
	 * Returns right-hand alias.
	 * 
	 * @return right-hand alias.
	 */
	public String getRightAlias() {

		return this.rightAlias;
	}

	/**
	 * Returns right-hand attribute name.
	 * 
	 * @return the right-hand attribute name.
	 */
	public String getRightAttrName() {

		return this.rightAttrName;
	}

	/**
	 * Returns left-hand attribute name.
	 * 
	 * @return the left-hand attribute name.
	 */
	public String getLeftAttrName() {

		return this.leftAttrName;
	}

	/**
	 * Returns the operation used in the comparison.
	 * 
	 * @return the operation used in the comparison.
	 */
	public Operation getOperation() {

		return this.operation;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		sb.append(this.leftAlias);
		sb.append("."); //$NON-NLS-1$
		sb.append(this.leftAttrName);
		switch (this.operation) {
		case EQUAL:
			sb.append(" = "); //$NON-NLS-1$
			break;
		case GREATER:
			sb.append(" > "); //$NON-NLS-1$
			break;
		case GREATEREQUAL:
			sb.append(" >= "); //$NON-NLS-1$
			break;
		case NOTEQUAL:
			sb.append(" <> "); //$NON-NLS-1$
			break;
		case SMALLER:
			sb.append(" < "); //$NON-NLS-1$
			break;
		case SMALLEREQUAL:
			sb.append(" <= "); //$NON-NLS-1$
			break;
		case LIKE:
			sb.append(" LIKE "); //$NON-NLS-1$
			break;
		default:
			sb.append(" UNKNOWN OP "); //$NON-NLS-1$
			break;
		}
		sb.append(this.rightAlias);
		sb.append("."); //$NON-NLS-1$
		sb.append(this.rightAttrName);
	}
}
