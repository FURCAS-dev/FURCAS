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
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.shared.BugException;

/**
 * A node select entry represents a selection on a node query.
 */
final public class NodeSelectEntry extends SelectEntry {

	private VirtualAtomicEntryReference virtualAtomicEntryReference;

	private NodeQuery owningQuery;

	public NodeSelectEntry(VirtualAtomicEntryReference _virtualAtomicEntryReference) {

		this.virtualAtomicEntryReference = _virtualAtomicEntryReference;
	}

	@Override
	public AliasName getTopAlias() {

		if (this.owningQuery == null) {
			throw new BugException(BugMessages.TOP_ALIAS_NOT_SET_FOR_NODESELECTENTRY);
		} else {
			return this.owningQuery.getAliasName();
		}
	}

	@Override
	public TypeReference getTypeReference() {

		return this.virtualAtomicEntryReference;
	}

	@Override
	public ColumnType getColumnType() {

		return this.virtualAtomicEntryReference.getNestedSelectEntry().getColumnType();
	}

	@Override
	public LeafSelectEntry getLeafSelectEntry() {

		SelectEntry nestedSelectEntry = getVirtualAtomicEntryReference().getNestedSelectEntry();
		return nestedSelectEntry.getLeafSelectEntry();
	}

	@Override
	public NodeQuery getOwningQuery() {

		return this.owningQuery;
	}

	public void setOwningQuery(NodeQuery owningQuery) {

		this.owningQuery = owningQuery;
	}

	public VirtualAtomicEntryReference getVirtualAtomicEntryReference() {

		return this.virtualAtomicEntryReference;
	}

	public void setVirtualAtomicEntryReference(VirtualAtomicEntryReference virtualAtomicEntryReference) {

		this.virtualAtomicEntryReference = virtualAtomicEntryReference;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		return this.virtualAtomicEntryReference.toString(indent, accumSb);
	}
}
