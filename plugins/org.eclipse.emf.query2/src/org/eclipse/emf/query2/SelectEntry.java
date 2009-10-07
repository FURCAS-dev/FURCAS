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
 * In an MQL query, a select-entry defines what alias or alias-feature should be
 * returned as a column in an {@link ResultSet}.
 */
abstract public class SelectEntry extends QueryElement {

	/*
	 * All select entries refer to an alias name defined in a from clause
	 */
	protected String aliasName;

	/**
	 * Return the alias name where this select-entry is referring to.
	 * 
	 * @return the alias name of the selection
	 */
	public String getAliasName() {

		return this.aliasName;
	}

	protected abstract void toString(StringBuilder sb, int ident);
}
