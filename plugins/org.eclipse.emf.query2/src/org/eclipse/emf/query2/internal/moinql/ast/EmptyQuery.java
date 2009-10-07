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
package org.eclipse.emf.query2.internal.moinql.ast;

import java.util.List;

import org.eclipse.emf.query2.internal.shared.AuxServices;


/**
 * The empty query represents a query which has been optimized away, i.e. it was
 * statically determined that no elements would satisfy the query (typically
 * caused by incompatible scopes).
 */
final public class EmptyQuery extends InternalQuery {

	private List<SelectEntry> selectEntries;

	public EmptyQuery(AliasName _aliasName, List<SelectEntry> _selectEntries) {

		this.selectEntries = _selectEntries;
		this.aliasName = _aliasName;
	}

	public List<SelectEntry> getSelectEntries() {

		return this.selectEntries;
	}

	public void setSelectEntries(List<SelectEntry> selectEntries) {

		this.selectEntries = selectEntries;
	}

	public boolean isEmpty() {

		return true;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		// end of select query
		sb.append(AuxServices.EMPTY_T + AuxServices.SPACE_T + AuxServices.AS_T + AuxServices.SPACE_T);

		// show the alias
		sb.append(getAliasName().toString());

		// finalize
		accumSb.append(sb);

		return sb.toString();
	}

}
