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
 * A select-attributes-entry is a type of select-entry, which refers to an alias
 * and a set of attribute names (or field names for structure types) for the
 * from-entry it refers to. It specifies as many columns as provided attributes
 * (or field names) in the {@link ResultSet}.
 */
final public class SelectAttrs extends SelectEntry {

	/*
	 * This is the list of attribute names (or field names), which have to occur
	 * in the result list.
	 */
	private String[] attrNames;

	/**
	 * Constructs a select-entry, which selects the attributes of a MOF type
	 * represented by the alias (or field names of a Structure Type represented
	 * by the alias). Only primitive typed (but multi-valued) attributes can be
	 * selected. To select class-typed attributes, an extra from-entry has to be
	 * defined and joined over containment of the attribute via the
	 * {@link WhereRelationReference} class. Each selection should only occur
	 * once in a select clause.
	 * 
	 * @param _aliasName
	 *            the alias name of the selection
	 * @param _attrNames
	 *            the attribute names of the selection
	 */
	public SelectAttrs(String _aliasName, String[] _attrNames) {

		this.aliasName = _aliasName;
		this.attrNames = _attrNames;
	}

	/**
	 * Constructs a select-entry, which selects the attributes of a MOF type
	 * represented by the alias (or field names of a Structure Type represented
	 * by the alias). Only primitive typed (but multi-valued) attributes can be
	 * selected. To select class-typed attributes, an extra from-entry has to be
	 * defined and joined over containment of the attribute via the
	 * {@link WhereRelationReference} class. Each selection should only occur
	 * once in a select clause.
	 * 
	 * @param _aliasName
	 *            the alias name of the selection
	 * @param _attrNames
	 *            the attribute names of the selection
	 */
	public SelectAttrs(String _aliasName, List<String> _attrNames) {

		this.aliasName = _aliasName;
		this.attrNames = _attrNames.toArray(new String[_attrNames.size()]);
	}

	/**
	 * Returns the attribute (or field) names used in this selection.
	 * 
	 * @return the attribute names of the selection
	 */
	public String[] getAttrNames() {

		return this.attrNames;
	}

	@Override
	protected void toString(StringBuilder sb, int ident) {

		if (this.attrNames != null && this.attrNames.length > 0) {
			sb.append(this.aliasName);
			sb.append('.');
			sb.append(this.attrNames[0]);
			for (int i = 1; i < this.attrNames.length; i++) {
				sb.append(", "); //$NON-NLS-1$
				sb.append(this.aliasName);
				sb.append('.');
				sb.append(this.attrNames[i]);
			}
		}
	}

}
