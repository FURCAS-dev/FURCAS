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
 * Created on 16.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import java.util.List;

import org.eclipse.emf.query2.internal.fql.SpiFqlConnectedConstraint;
import org.eclipse.emf.query2.internal.fql.SpiFqlLocalConstraint;
import org.eclipse.emf.query2.internal.shared.AuxServices;


/**
 * Provides a logical connection between a set of where-clauses. The logical
 * connection is either conjunctive or disjunctive.
 */
final public class NaryWhereClause extends WhereClause implements SpiFqlConnectedConstraint {

	private boolean withOr;

	private List<WhereClause> nestedClauses;

	public NaryWhereClause(AtomicEntry _alias, boolean _withOr, List<WhereClause> _nestedClauses) {

		this.atomicEntry = _alias;
		this.withOr = _withOr;
		this.nestedClauses = _nestedClauses;
	}

	public List<WhereClause> getNestedClauses() {

		return this.nestedClauses;
	}

	public boolean isOrConnected() {

		return this.withOr;
	}

	public void setNestedClauses(List<WhereClause> nestedClauses) {

		this.nestedClauses = nestedClauses;
	}

	public void setWithOr(boolean withOr) {

		this.withOr = withOr;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		String connector = AuxServices.EMPTYSTR;
		if (this.withOr) {
			connector = AuxServices.OR_T;
		} else {
			connector = AuxServices.AND_T;
		}

		if (this.nestedClauses.size() < 2) {
			sb.append(">>MQL Internal Format Error: less than 2 where-conditions for " + connector + "-clause <<"); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			sb.append(AuxServices.OPENPAREN_T);
			int newIndent = indent + 1;
			this.nestedClauses.get(0).toString(newIndent, sb);
			for (int i = 1; i < this.nestedClauses.size(); i++) {
				sb.append(AuxServices.CLOSEPAREN_T + AuxServices.SPACE_T + connector + AuxServices.newLine(indent)
						+ AuxServices.OPENPAREN_T);
				this.nestedClauses.get(i).toString(newIndent, sb);
			}
			sb.append(AuxServices.CLOSEPAREN_T);
		}

		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

	/*
	 * FQL
	 */

	public SpiFqlLocalConstraint[] getNestedConstraint() {

		List<WhereClause> clauses = this.getNestedClauses();
		return clauses.toArray(new SpiFqlLocalConstraint[clauses.size()]);
	}

}
