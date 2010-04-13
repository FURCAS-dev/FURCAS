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
 * Created on 17.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.ColumnType;

/**
 * A SelectEntry is a way to refer to an alias or an attribute within the result
 * set computed from the particular alias.
 */
public abstract class SelectEntry {

	abstract public AliasName getTopAlias();

	abstract public TypeReference getTypeReference();

	abstract public ColumnType getColumnType();

	abstract public LeafSelectEntry getLeafSelectEntry();

	abstract public InternalQuery getOwningQuery();

	/*
	 * Pretty-printing
	 */
	abstract public String toString(int indent, StringBuilder accumSb);

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

}
