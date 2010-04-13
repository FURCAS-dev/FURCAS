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

import org.eclipse.emf.query2.ColumnType;

/**
 * A leaf select entry represents a selection on a leaf query.
 */
final public class LeafSelectEntry extends SelectEntry {

	private String originalUserDefinedName;

	private AtomicEntryReference atomicEntryReference;

	private LeafQuery owningQuery;

	public LeafSelectEntry(AtomicEntryReference _atomicEntryReference) {

		this.atomicEntryReference = _atomicEntryReference;
		// we keep the original name to avoid that redirections loose the original user-defined name
		this.originalUserDefinedName = _atomicEntryReference.getAtomicEntry().getAliasName().getOriginalName();
	}

	@Override
	public AliasName getTopAlias() {

		return this.owningQuery.getAliasName();
	}

	@Override
	public TypeReference getTypeReference() {

		return this.atomicEntryReference;
	}

	@Override
	public LeafSelectEntry getLeafSelectEntry() {

		return this;
	}

	@Override
	public ColumnType getColumnType() {

		ColumnType result = new ColumnType();

		AtomicEntryReference aeRef = this.getAtomicEntryReference();
		AtomicEntry ae = aeRef.getAtomicEntry();

		result.newRuntimeAlias = ae.getAliasName().getOriginalName();
		result.alias = this.originalUserDefinedName;

		if (aeRef instanceof AtomicAttrReference) {
			// alias and attribute
			AtomicAttrReference aeAttrRef = (AtomicAttrReference) aeRef;
			result.attribute = aeAttrRef.getAttrName();
			result.multiValued = aeAttrRef.isMultiValued();
			result.isOrdered = aeAttrRef.isOrdered();
			result.isUnique = aeAttrRef.isUnique();
			result.typeName = aeAttrRef.getAttrType().toString();
		} else {
			// only alias
			result.attribute = null;
			result.multiValued = false;
			result.isOrdered = false;
			result.isUnique = false;
			result.typeName = ae.getClassName();
		}

		return result;
	}

	public String getOriginalUserDefinedName() {

		return this.originalUserDefinedName;
	}

	public void setOriginalUserDefinedName(String originalUserDefinedName) {

		this.originalUserDefinedName = originalUserDefinedName;
	}

	public AtomicEntryReference getAtomicEntryReference() {

		return this.atomicEntryReference;
	}

	public void setAtomicEntryReference(AtomicEntryReference atomicEntryReference) {

		this.atomicEntryReference = atomicEntryReference;
	}

	@Override
	public LeafQuery getOwningQuery() {

		return this.owningQuery;
	}

	public void setOwningQuery(LeafQuery owningQuery) {

		this.owningQuery = owningQuery;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		return this.atomicEntryReference.toString(indent, accumSb);
	}
}
