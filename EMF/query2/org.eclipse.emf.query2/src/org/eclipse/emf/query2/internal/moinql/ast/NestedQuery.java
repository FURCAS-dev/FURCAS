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
/**
 * 
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.shared.AuxServices;

/**
 * A nested query is a query used in a links predicate. It refers to an internal
 * query, indicates whether the nested query can be computed in one go with the
 * encompassing query, and keeps possibly a result set. The latter may be set
 * during interpretation.
 */
final public class NestedQuery {

	private InternalQuery internalQuery;

	// this flag is used to indicate if the nested query should be evaluated by itself or be considered part of the larger
	// query that contains it
	private boolean reset;

	private SpiFqlQueryResultSet resultSet = null;

	public NestedQuery(InternalQuery _internalQuery) {

		this.internalQuery = _internalQuery;
		this.reset = true;
	}

	public InternalQuery getInternalQuery() {

		return this.internalQuery;
	}

	public boolean isReset() {

		return this.reset;
	}

	public SpiFqlQueryResultSet getResultSet() {

		return this.resultSet;
	}

	public void setInternalQuery(InternalQuery internalQuery) {

		this.internalQuery = internalQuery;
	}

	public void setReset(boolean reset) {

		this.reset = reset;
	}

	public void setResultSet(SpiFqlQueryResultSet resultSet) {

		this.resultSet = resultSet;
	}

	/*
	 * Pretty-printing
	 */
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		String resetStr = (this.reset ? AuxServices.RESET_T + AuxServices.SPACE_T : AuxServices.EMPTYSTR);

		sb.append(resetStr);

		this.internalQuery.toString(indent + resetStr.length(), accumSb);

		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}
}
