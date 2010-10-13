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
package org.eclipse.emf.query2;

/**
 * A where-entry allows to constraint one or more aliases defined in a
 * from-entry.
 */
public abstract class WhereEntry extends QueryElement {

	/*
	 * The alias name to which the where condition refers to.
	 */
	protected String leftAlias;

	/**
	 * Obtain the alias name to which this where entry refers.
	 * 
	 * @return the alias name to which this where entry refers.
	 */
	public String getLeftAlias() {

		return this.leftAlias;
	}

	abstract protected void toString(StringBuilder sb, int indent);

}
