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

import java.util.Arrays;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * Each from-entry is used in a query to define a type from where instances are
 * taken. Optionally, a scope is provided to include or exclude partitions or
 * container names. By default, the sub-types of a type are also considered. The
 * <i>withoutSubtypes</i> flag has to be set to true if no sub-types should be
 * considered!
 */
abstract public class FromEntry extends QueryElement {

	protected String aliasName;

	/*
	 * Optionally includes and exclude lists of PRIs exist to reduce scoping. By
	 * default, the list is empty
	 */
	protected URI[] partitionScope = new URI[0];

	/*
	 * When the partitionScope is empty, and included is false, we will assume
	 * that the entire ClientScope is considered. This is the default for a
	 * FromEntry.
	 */
	protected boolean included = false;

	/*
	 * If withoutSubtypes == true, the subtypes are not considered. By default,
	 * this is not the case.
	 */
	protected boolean withoutSubtypes = false;

	/*
	 * The scope provider for the from type. Stored for downstreamed scope
	 * resolving.
	 */
	protected TypeScopeProvider scopeProvider = null;

	/*
	 * If this set is null and withoutSubtypes = true, then no subtypes are
	 * considered. If the set is not null, only the subtypes in this set are
	 * taken out. It is illegal to remove the top-level type of the from-entry.
	 */
	private Set<URI> withoutSubtypeSet = null;

	/**
	 * Returns the alias name of the from-entry.
	 * 
	 * @return the alias name of the from-entry.
	 */
	public String getAliasName() {

		return this.aliasName;
	}

	/**
	 * Returns true if the scope of this from-entry is reduced to the included
	 * partitions or containers.
	 * 
	 * @return true if the scope of this from-entry is reduced to the included
	 *         partitions or containers.
	 */
	public boolean isIncluded() {

		if (scopeProvider == null) {
			return this.included;
		} else {
			return scopeProvider.isInclusiveScope();
		}
	}

	/**
	 * Returns partitions of the scope of this from-entry.
	 * 
	 * @return partitions of the scope of this from-entry.
	 */
	public URI[] getPartitionScope() {

		if (scopeProvider == null) {
			return this.partitionScope;
		} else {
			return scopeProvider.getPartitionScope();
		}
	}

	/**
	 * Returns true if the sub-types for this from-entry are not to be
	 * considered.
	 * 
	 * @return true if the sub-types for this from-entry are not to be
	 *         considered.
	 */
	public boolean isWithoutSubtypes() {

		return this.withoutSubtypes;
	}

	/**
	 * Returns a set of sub-types which do not have to be considered when the
	 * the flag withoutSubtypes = true. If this set is null and withoutSubtypes
	 * = true, no subtypes are considered. If withoutSubtypes = false, the value
	 * of this set is ignored.
	 * 
	 * @return a set of sub-types which do not have to be considered when the
	 *         the flag withoutSubtypes = true.
	 */
	public Set<URI> getWithoutSubtypeSet() {

		return this.withoutSubtypeSet;
	}

	/**
	 * This value is only relevant when withoutSubtypes = true. If the set is
	 * null no subtypes are considered for this fromType. Otherwise, the
	 * fromEntry includes all subtypes except those in the set. If the set
	 * contains types which are not a subtype, they are simply ignored. It is a
	 * type-error if an attempt is made to remove the top-level type of this
	 * fromEntry.
	 * 
	 * @param withoutSubtypeSet
	 *            The set of specific types which is to be removed
	 */
	public void setWithoutSubtypeSet(Set<URI> withoutSubtypeSet) {

		this.withoutSubtypeSet = withoutSubtypeSet;
	}

	protected void toString(StringBuilder sb, int ident) {

		if (this.withoutSubtypes) {
			sb.append(" withoutSubtypes"); //$NON-NLS-1$
		}

		sb.append(" as "); //$NON-NLS-1$
		sb.append(this.aliasName);

		if (this.partitionScope.length > 0) {
			sb.append('\n');
			char[] whiteSpace = new char[ident];
			Arrays.fill(whiteSpace, ' ');
			sb.append(whiteSpace);
			if (this.included) {
				sb.append("in partitions {"); //$NON-NLS-1$
			} else {
				sb.append("not in partitions {"); //$NON-NLS-1$
			}

			sb.append(this.partitionScope[0].toString());

			for (int i = 1; i < this.partitionScope.length; i++) {
				sb.append(",\n"); //$NON-NLS-1$
				char[] whiteSpaceN = new char[ident + (this.included ? 15 : 19)];
				Arrays.fill(whiteSpaceN, ' ');
				sb.append(whiteSpaceN);
				sb.append(this.partitionScope[i].toString());
			}

			sb.append("}"); //$NON-NLS-1$
		}
	}
}
