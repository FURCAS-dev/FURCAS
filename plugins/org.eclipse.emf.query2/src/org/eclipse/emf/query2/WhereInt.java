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
 * Compares an integer value with one of the possible operations.
 */
final public class WhereInt extends WhereComparator {

	/*
	 * Comparison value
	 */
	private int intValue;

	/**
	 * The predicate is true if the intValue compares to the attribute value in
	 * a way determined by the operator. If the multiplicity <> 1, then the
	 * predicate is true whenever the comparison holds for one or more elements
	 * from the collection. The operation LIKE is not permitted.
	 * 
	 * @param _attrName
	 *            the attribute name.
	 * @param _operation
	 *            the operation.
	 * @param _intValue
	 *            the int value.
	 */
	public WhereInt(String _attrName, Operation _operation, int _intValue) {

		this.attrName = _attrName;
		this.intValue = _intValue;
		this.operation = _operation;
	}

	/**
	 * Returns the value to which the integer-typed attribute is compared.
	 * 
	 * @return the value to which the integer-typed attribute is compared.
	 */
	public int getIntValue() {

		return this.intValue;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		super.toString(sb, indent);
		sb.append(this.intValue);
	}
}
