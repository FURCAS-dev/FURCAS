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

import java.util.Arrays;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * This type of from-entry is defined per qualified MOF name and allows the
 * provision of a fixed set of model elements by means of their {@link URI}.
 */
final public class FromFixedSet extends FromType {

	/*
	 * The fixed set of elements for this from entry
	 */
	private URI[] elements;

	/**
	 * With this type of from-entry, the from-set is fixed by the client. All
	 * provided elements have to be instances of the provided type or any of its
	 * sub-types. The type is given by its qualified name. Additionally, the
	 * container name of the meta-model can be used to avoid ambiguities for the
	 * qualified name. The alias can be used elsewhere to identify this
	 * from-entry.
	 * 
	 * @param _aliasName
	 *            of the FromEntry
	 * @param _typeUri
	 *            of the common supertype of the fixed elements
	 * @param _containerName
	 *            the optional container name of the common supertype of the
	 *            fixed elements
	 * @param _elements
	 *            the actual fixed elements, encoded as MRIs
	 */
	public FromFixedSet(String _aliasName, URI _typeUri, URI[] _elements) {

		super(_aliasName, _typeUri, false);
		this.elements = _elements;
		this.included = true;
	}

	/**
	 * With this type of from-entry, the from-set is fixed by the client. All
	 * provided elements have to be instances of the provided type or any of its
	 * sub-types. The type is given by its qualified name. Additionally, the
	 * container name of the meta-model can be used to avoid ambiguities for the
	 * qualified name. The alias can be used elsewhere to identify this
	 * from-entry.
	 * 
	 * @param _aliasName
	 *            of the FromEntry
	 * @param _typeUri
	 *            of the common supertype of the fixed elements
	 * @param _containerName
	 *            the optional container name of the common supertype of the
	 *            fixed elements
	 * @param _elements
	 *            the actual fixed elements, encoded as MRIs
	 */
	public FromFixedSet(String _aliasName, URI _typeUri, Set<URI> _elements) {

		super(_aliasName, _typeUri, false);
		this.elements = _elements.toArray(new URI[_elements.size()]);
		this.included = true;
	}

	/**
	 * Returns the elements of the fixed set of this from-entry.
	 * 
	 * @return the elements of the fixed set of this from-entry.
	 */
	public URI[] getElements() {

		return this.elements;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		super.toString(sb, indent);

		if (this.elements.length > 0) {
			sb.append('\n');
			char[] whiteSpace = new char[indent + 6];
			Arrays.fill(whiteSpace, ' ');
			sb.append(whiteSpace);
			sb.append("in elements {"); //$NON-NLS-1$

			sb.append(this.elements[0].toString());

			for (int i = 1; i < this.elements.length; i++) {
				sb.append(",\n"); //$NON-NLS-1$
				char[] whiteSpaceN = new char[indent + 13 + 6];
				Arrays.fill(whiteSpaceN, ' ');
				sb.append(whiteSpaceN);
				sb.append(this.elements[i].toString());
			}

			sb.append("}"); //$NON-NLS-1$
		}

	}
}
