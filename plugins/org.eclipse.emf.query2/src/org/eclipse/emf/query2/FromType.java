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

import org.eclipse.emf.common.util.URI;

/**
 * This type of from-entry is defined per qualified MOF name.
 */
public class FromType extends FromEntry {

	/*
	 * The qualified name of the type for this from entry.
	 */
	private URI typeUri;

	/**
	 * With this type of from-entry, the from-set is defined to be all the
	 * instances of the type given by the qualified name. The alias can be used
	 * elsewhere to identify this from-entry. If withoutSubtypes==true, then the
	 * instances of the sub-types of the qualified type name are <b>not</b>
	 * considered in the from-set.
	 * 
	 * @param _aliasName
	 *            of the FromEntry
	 * @param _typeUri
	 *            the fully qualified name of the type of the from Entry
	 * @param _withoutSubtypes
	 *            to indicated whether subtypes are to be included or not
	 */
	public FromType(String _aliasName, URI _typeUri, boolean _withoutSubtypes) {

		this.aliasName = _aliasName;
		this.typeUri = _typeUri;
		this.withoutSubtypes = _withoutSubtypes;
	}

	/**
	 * With this type of from-entry, the from-set is defined to be all the
	 * instances of the type given by the qualified name. The alias can be used
	 * elsewhere to identify this from-entry. If withoutSubtypes==true, then the
	 * instances of the sub-types of the qualified type name are <b>not</b>
	 * considered in the from-set. A {@link TypeScopeProvider} is provided to
	 * additionally limit where the instances of the type or types in this from
	 * entry are to be taken from.
	 * 
	 * @param _aliasName
	 *            of the FromEntry
	 * @param _typeUri
	 *            the fully qualified name of the type of the from Entry
	 * @param _withoutSubtypes
	 *            to indicated whether subtypes are to be included or not
	 * @param queryScopeProvider
	 *            the query scope provider to limit the scope of where instances
	 *            are taken from
	 */
	public FromType(String _aliasName, URI _typeUri, boolean _withoutSubtypes, TypeScopeProvider queryScopeProvider) {

		this(_aliasName, _typeUri, _withoutSubtypes);
		this.scopeProvider = queryScopeProvider;
	}

	/**
	 * Returns the qualified name of this from-entry.
	 * 
	 * @return the qualified name of this from-entry.
	 */
	public URI getTypeUri() {

		return this.typeUri;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		sb.append("type: "); //$NON-NLS-1$
		if (this.typeUri != null) {
			sb.append(this.typeUri);
		}
		super.toString(sb, indent + 6);
	}
}
