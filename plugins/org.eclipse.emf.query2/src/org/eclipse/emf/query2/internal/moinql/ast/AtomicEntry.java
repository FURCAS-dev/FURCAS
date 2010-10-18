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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.fql.SpiFqlEntryType;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
import org.eclipse.emf.query2.internal.fql.SpiFqlLocalConstraint;
import org.eclipse.emf.query2.internal.shared.AuxServices;


/**
 * An AtomicEntry is one of two possible from-entries. It defines the MOF type
 * and possibly its subtypes via its MOF MRI. Optionally, the scope from which
 * the model elements are taken can be reduced in one of two ways: if included
 * is true, then the scope is defined by the PRIs found in the variable scope.
 * If included is false, then the scope is defined by the client scope, except
 * for the PRIs defined in the variable scope. Optionally, the elements of the
 * type can be constrained with a where-clause.
 */
public class AtomicEntry extends FromEntry implements SpiFqlEntryType {

	private List<URI> classMRIs;

	private SpiFqlFromTypeCategory atomicEntryCategory;

	private List<String> classNames;

	private Set<URI> scope;

	private Set<URI> containerScope;

	// If included==false and scope.size() == 0, we assume global scope without restrictions.
	// If included==true and scope.size() == 0, the result set has to be empty
	private boolean included;

	// we keep a boolean flag indicating if the first URI in classMRIs is that of MOF's Reflect::Element
	private boolean isReflectElement;

	// optional: null means not present
	private WhereClause whereClause = null;

	public AtomicEntry(AliasName _aliasName, List<URI> _classMRIs, List<String> _classNames, SpiFqlFromTypeCategory _atomicEntryCategory,
			boolean _isReflectElement, Set<URI> _scope, Set<URI> _containerScope, boolean _included) {

		this.atomicEntryCategory = _atomicEntryCategory;
		this.aliasName = _aliasName;
		this.classMRIs = (_classMRIs == null ? new ArrayList<URI>(0) : _classMRIs);
		this.scope = (_scope == null ? new HashSet<URI>(0) : _scope);
		this.included = _included;
		this.classNames = (_classNames == null ? new ArrayList<String>(0) : _classNames);
		this.containerScope = (_containerScope == null ? new HashSet<URI>(0) : _containerScope);
		this.isReflectElement = _isReflectElement;
	}

	public void setWhereClause(WhereClause whereClause) {

		this.whereClause = whereClause;
	}

	public void setClassMRIs(List<URI> classMRIs) {

		this.classMRIs = (classMRIs == null ? new ArrayList<URI>(0) : classMRIs);
	}

	public void setClassNames(List<String> classNames) {

		this.classNames = (classNames == null ? new ArrayList<String>(0) : classNames);
	}

	public void setScope(Set<URI> scope, Set<URI> containerScope, boolean _scopeIncluded) {

		this.included = _scopeIncluded;
		this.scope = (scope == null ? new HashSet<URI>(0) : scope);
		this.containerScope = (containerScope == null ? new HashSet<URI>(0) : containerScope);
	}

	public List<URI> getClassMRIs() {

		return this.classMRIs;
	}

	public boolean isScopeInclusive() {

		return this.included;
	}

	public Set<URI> getScope() {

		return this.scope;
	}

	public WhereClause getWhereClause() {

		return this.whereClause;
	}

	public List<String> getClassNames() {

		return this.classNames;
	}

	public Set<URI> getContainerScope() {

		return this.containerScope;
	}

	public URI getClassMRI() {

		return getClassMRIs().get(0);
	}

	public String getClassName() {

		return getClassNames().get(0);
	}

	public SpiFqlFromTypeCategory getTypeCategory() {

		return this.atomicEntryCategory;
	}

	public void setAtomicEntryCategory(SpiFqlFromTypeCategory atomicEntryCategory) {

		this.atomicEntryCategory = atomicEntryCategory;
	}

	public boolean isReflectElement() {

		return this.isReflectElement;
	}

	public void setReflectElement(boolean isReflectElement) {

		this.isReflectElement = isReflectElement;
	}

	protected void printScope(StringBuilder mainEntryString, int indent) {

		Set<URI> pScope = getScope();
		boolean _included = isScopeInclusive();

		// shows partition scope provided it exists
		if (pScope != null && pScope.size() != 0) {

			String prefix = AuxServices.EMPTYSTR;

			// negated scope
			if (!_included) {
				prefix = AuxServices.SPACE_T + AuxServices.NOT_T + AuxServices.SPACE_T + AuxServices.IN_T
						+ AuxServices.SPACE_T + AuxServices.PARTITION_T + AuxServices.OPENCURLY_T;
			} else {
				prefix = AuxServices.SPACE_T + AuxServices.IN_T + AuxServices.SPACE_T + AuxServices.PARTITION_T
						+ AuxServices.OPENCURLY_T;
			}

			Iterator<URI> scopeIterator = pScope.iterator();

			mainEntryString.append(AuxServices.newLine(indent) + prefix + scopeIterator.next().toString());

			for (; scopeIterator.hasNext();) {
				URI scopePRI = scopeIterator.next();
				mainEntryString.append(AuxServices.COMMA_T + AuxServices.newLine(indent + prefix.length()));
				mainEntryString.append(scopePRI.toString());
			}
			mainEntryString.append(AuxServices.CLOSECURLY_T);
		}

		Set<URI> cScope = getContainerScope();

		// shows container scope provided the scope exists
		if (cScope != null && cScope.size() != 0) {

			String prefix = AuxServices.EMPTYSTR;

			// negated scope
			if (!_included) {
				prefix = AuxServices.SPACE_T + AuxServices.NOT_T + AuxServices.SPACE_T + AuxServices.IN_T
						+ AuxServices.SPACE_T + AuxServices.CONTAINER_T + AuxServices.OPENCURLY_T;
			} else {
				prefix = AuxServices.SPACE_T + AuxServices.IN_T + AuxServices.SPACE_T + AuxServices.CONTAINER_T
						+ AuxServices.OPENCURLY_T;
			}

			Iterator<URI> containedScopeIterator = cScope.iterator();

			mainEntryString.append(AuxServices.newLine(indent) + prefix + containedScopeIterator.next());

			for (; containedScopeIterator.hasNext();) {
				String containerName = containedScopeIterator.next().toString();
				mainEntryString.append(AuxServices.COMMA_T + AuxServices.newLine(indent + prefix.length()));
				mainEntryString.append(containerName);
			}
			mainEntryString.append(AuxServices.CLOSECURLY_T);
		}

		if (_included && (pScope == null || pScope.size() == 0) && (cScope == null || cScope.size() == 0)) {
			mainEntryString.append(AuxServices.newLine(indent + 1) + AuxServices.IN_T + AuxServices.SPACE_T
					+ AuxServices.EMPTY_T);
		}
	}

	/*
	 * Pretty-printing
	 */
	public String toString(int indent, StringBuilder accumSb, int wIndent, StringBuilder whereSb) {

		/* first we construct the from part */
		StringBuilder mainEntryString = new StringBuilder();

		// MOF type and possible subtypes
		mainEntryString.append(AuxServices.OPENCURLY_T);

		List<String> cNames = getClassNames();
		List<URI> cMRIs = getClassMRIs();

		if (cNames == null || cNames.size() == 0) {
			mainEntryString.append(">>MQL Internal Format Error: no MOF types provided<<"); //$NON-NLS-1$
		} else {
			mainEntryString.append(cNames.get(0));
			for (int i = 1; i < cMRIs.size(); i++) {
				mainEntryString.append(AuxServices.COMMA_T + AuxServices.newLine(indent + 1) + cNames.get(i));
			}
		}

		mainEntryString.append(AuxServices.CLOSECURLY_T + AuxServices.SPACE_T);

		// assign alias
		mainEntryString.append(AuxServices.AS_T + AuxServices.SPACE_T);
		mainEntryString.append(getAliasName().toString());

		printScope(mainEntryString, indent);

		/* second, we construct a whereClause, provided there is one */
		StringBuilder whereEntriesString = new StringBuilder();
		if (getWhereClause() != null) {
			whereEntriesString.append(AuxServices.newLine(wIndent));
			String whereClausePrefix = AuxServices.SPACE_T + AuxServices.WHERE_T + AuxServices.SPACE_T + AuxServices.FOR_T
					+ AuxServices.SPACE_T + getAliasName().toString() + AuxServices.OPENPAREN_T;
			int whereClauseIndent = wIndent + whereClausePrefix.length();
			whereEntriesString.append(whereClausePrefix);
			getWhereClause().toString(whereClauseIndent, whereEntriesString);
			whereEntriesString.append(AuxServices.CLOSEPAREN_T);
		}

		/* finalize */
		accumSb.append(mainEntryString);
		whereSb.append(whereEntriesString);

		return mainEntryString.toString() + AuxServices.newLine(indent) + whereSb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder(), 0, new StringBuilder());
	}

	/*
	 * FQL
	 */

	public SpiFqlLocalConstraint getCondition() {

		return this.getWhereClause();
	}

	public URI[] getTypes() {

		List<URI> mris = this.getClassMRIs();
		return mris.toArray(new URI[mris.size()]);
	}

	public String[] getTypeNames() {

		List<String> typeNames = this.getClassNames();
		return typeNames.toArray(new String[typeNames.size()]);
	}

}
