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

import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.moinql.engine.SchedulerImpl;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;

/**
 * This reference refers to a select entry, which in itself refers again to a
 * TypeReference.
 */
public class VirtualAtomicEntryReference implements TypeReference {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(SchedulerImpl.class);

	protected SelectEntry nestedSelectEntry;

	public VirtualAtomicEntryReference(SelectEntry _nestedSelectEntry) {

		this.nestedSelectEntry = _nestedSelectEntry;
	}

	public SelectEntry getNestedSelectEntry() {

		return this.nestedSelectEntry;
	}

	public AtomicEntry getAtomicEntry() {

		return getAtomicEntryReference().getAtomicEntry();
	}

	public AtomicEntryReference getAtomicEntryReference() {

		TypeReference elRef = this.nestedSelectEntry.getTypeReference();
		AtomicEntryReference result = null;
		if (elRef instanceof VirtualAtomicEntryReference) {
			result = ((VirtualAtomicEntryReference) elRef).getAtomicEntryReference();
		} else if (elRef instanceof AtomicEntryReference) {
			result = ((AtomicEntryReference) elRef);
		} else {
			throw new BugException(BugMessages.VIRTUAL_ATOMIC_ENTRY_REF_HAS_TO_REFER_TO_TYPE_REF);
		}
		return result;
	}

	public void setNestedSelectEntry(SelectEntry nestedSelectEntry) {

		this.nestedSelectEntry = nestedSelectEntry;
	}

	/*
	 * Redefine identity
	 */
	@Override
	public boolean equals(Object otherReference) {

		boolean result = false;
		if (otherReference instanceof TypeReference) {
			TypeReference otherTypeReference = (TypeReference) otherReference;
			result = getAtomicEntry().equals(otherTypeReference.getAtomicEntry());
		}
		return result;
	}

	@Override
	public int hashCode() {

		return getAtomicEntry().hashCode();
	}

	/*
	 * Pretty-printing
	 */
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		if (logger.isTraced(LogSeverity.DEBUG)) {
			sb.append(this.nestedSelectEntry.getTopAlias() + AuxServices.DOT_T);
		}
		this.nestedSelectEntry.toString(indent, sb);

		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}
}
