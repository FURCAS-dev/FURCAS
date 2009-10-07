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
 * A where n-ary operation can be used in a where-entry and embodies boolean AND
 * and OR with multiple operands.
 */
abstract public class WhereNary extends WhereClause {

	/*
	 * This list contains the operands of the nested clause
	 */
	protected WhereClause[] nestedClauses;

	/**
	 * Return the operands of this n-ary operation.
	 * 
	 * @return the operands of this n-ary operation.
	 */
	public WhereClause[] getNestedClauses() {

		return this.nestedClauses;
	}
}
