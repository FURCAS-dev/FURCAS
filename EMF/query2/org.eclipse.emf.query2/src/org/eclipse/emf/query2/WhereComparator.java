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
 * A where-comparator embodies comparisons as they may occur in a where-entry.
 * Such a comparator always refers to an attribute and has a defined comparison
 * operation.
 */
abstract public class WhereComparator extends WhereClause {

	/*
	 * The attribute on the left of the comparison.
	 */
	protected String attrName;

	/*
	 * The comparison operation
	 */
	protected Operation operation;

	/**
	 * Return the attribute name of the left operand of the operation.
	 * 
	 * @return the attribute name of the left operand of the operation.
	 */
	public String getAttrName() {

		return this.attrName;
	}

	/**
	 * Return the comparison operation.
	 * 
	 * @return the comparison operation.
	 */
	public Operation getOperation() {

		return this.operation;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		sb.append(this.attrName);
		sb.append(" "); //$NON-NLS-1$
		sb.append(this.operation.toString());
		sb.append(" "); //$NON-NLS-1$
	}
}
