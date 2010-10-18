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
 * Created on 20.02.2006
 */
package org.eclipse.emf.query2;

/**
 * A local where-entry allows the definition of a boolean expression, which
 * compares the primitive typed attributes of one alias.
 */
final public class LocalWhereEntry extends WhereEntry {

	/*
	 * A where clause is provided, which is a boolean expression comparing
	 * attributes of the alias to constants (of the right corresponding type).
	 */
	private WhereClause whereClause;

	/**
	 * A local where-entry puts <i>local</i> constraints on the attributes of
	 * the type of the provided alias. The constraints are formulated in a
	 * boolean formula in the {@link WhereClause}.
	 * 
	 * @param _aliasName
	 *            the alias name which is being constraint by the where clause
	 * @param _whereClause
	 *            the where clause which constrains the relevant instances of
	 *            the from type denoted by the alias
	 */
	public LocalWhereEntry(String _aliasName, WhereClause _whereClause) {

		this.leftAlias = _aliasName;
		this.whereClause = _whereClause;
	}

	/**
	 * Obtain the nested clause which is contained in this where-entry.
	 * 
	 * @return the nested clause which is contained in this where-entry.
	 */
	public WhereClause getNestedClause() {

		return this.whereClause;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		sb.append("for "); //$NON-NLS-1$
		sb.append(this.leftAlias);
		sb.append("("); //$NON-NLS-1$
		this.whereClause.toString(sb, indent + 6);
		sb.append(")"); //$NON-NLS-1$
	}
}
