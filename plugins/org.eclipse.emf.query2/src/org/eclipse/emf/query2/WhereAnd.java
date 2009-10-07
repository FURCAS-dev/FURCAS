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

import java.util.List;

/**
 * This boolean AND-operator can be used in a where-entry and is n-ary, i.e. can
 * take multiple operands.
 */
final public class WhereAnd extends WhereNary {

	/**
	 * Connects the provided nested clauses by a logical AND.
	 * 
	 * @param _nestedClauses
	 *            the nested clauses.
	 */
	public WhereAnd(WhereClause[] _nestedClauses) {

		this.nestedClauses = _nestedClauses;
	}

	/**
	 * Connects the provided nested clauses by a logical AND.
	 * 
	 * @param _nestedClauses
	 *            the nested clauses.
	 */
	public WhereAnd(List<WhereClause> _nestedClauses) {

		this.nestedClauses = _nestedClauses.toArray(new WhereClause[_nestedClauses.size()]);
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		if (this.nestedClauses != null && this.nestedClauses.length > 0) {
			sb.append("and ("); //$NON-NLS-1$
			this.nestedClauses[0].toString(sb, indent);
			for (int i = 1; i < this.nestedClauses.length; i++) {
				sb.append(", "); //$NON-NLS-1$
				this.nestedClauses[i].toString(sb, indent);
			}
			sb.append(")"); //$NON-NLS-1$
		}
	}
}
