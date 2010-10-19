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
 * Compares a float value with one of the possible operations.
 */
final public class WhereFloat extends WhereComparator {

	/*
	 * Comparison value
	 */
	private float floatValue;

	/**
	 * The predicate is true if the floatValue compares to the attribute value
	 * in a way determined by the operator. If the multiplicity <> 1, then the
	 * predicate is true whenever the comparison holds for one or more elements
	 * from the collection. The operation LIKE is not permitted.
	 * 
	 * @param _attrName
	 *            the attribute name.
	 * @param _operation
	 *            the operation.
	 * @param _floatValue
	 *            the float value.
	 */
	public WhereFloat(String _attrName, Operation _operation, float _floatValue) {

		this.attrName = _attrName;
		this.floatValue = _floatValue;
		this.operation = _operation;
	}

	/**
	 * Return the value to which the float-typed attribute is compared.
	 * 
	 * @return the value to which the float-typed attribute is compared.
	 */
	public float getFloatValue() {

		return this.floatValue;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		super.toString(sb, indent);
		sb.append(this.floatValue);
	}

}
