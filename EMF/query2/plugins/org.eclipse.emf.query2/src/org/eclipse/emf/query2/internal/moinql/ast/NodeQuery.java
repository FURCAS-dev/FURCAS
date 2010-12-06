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

import java.util.List;

import org.eclipse.emf.query2.internal.shared.AuxServices;


/**
 * Node queries are queries whose from-entries themselves are internal queries.
 * They have to be processed in-memory by the interpreter.
 */
final public class NodeQuery extends InternalQuery {

	private InternalQuery firstFromEntry;

	private InternalQuery secondFromEntry;

	private List<ComparisonWithEntry> withEntries;

	private List<NodeSelectEntry> selectEntries;

	/**
	 * Use factory method
	 */
	private NodeQuery(AliasName _aliasName, InternalQuery _firstFromEntry, InternalQuery _secondFromEntry,
			List<ComparisonWithEntry> _withEntries, List<NodeSelectEntry> _selectEntries) {

		this.aliasName = _aliasName;
		this.firstFromEntry = _firstFromEntry;
		this.secondFromEntry = _secondFromEntry;
		this.withEntries = _withEntries;
		this.selectEntries = _selectEntries;
	}

	/**
	 * Factory constructs node query, but also sets the owning query
	 */
	static public NodeQuery construct(AliasName _aliasName, InternalQuery _firstFromEntry, InternalQuery _secondFromEntry,
			List<ComparisonWithEntry> _withEntries, List<NodeSelectEntry> _selectEntries) {

		// construct the object
		NodeQuery nodeQuery = new NodeQuery(_aliasName, _firstFromEntry, _secondFromEntry, _withEntries, _selectEntries);

		// set the owning query
		for (NodeSelectEntry selectEntry : _selectEntries) {
			selectEntry.setOwningQuery(nodeQuery);
		}

		return nodeQuery;
	}

	public boolean isEmpty() {

		return false;
	}

	public InternalQuery getFirstFromEntry() {

		return this.firstFromEntry;
	}

	public InternalQuery getSecondFromEntry() {

		return this.secondFromEntry;
	}

	public void setFirstFromEntry(InternalQuery firstFromEntry) {

		this.firstFromEntry = firstFromEntry;
	}

	public void setSecondFromEntry(InternalQuery secondFromEntry) {

		this.secondFromEntry = secondFromEntry;
	}

	public List<NodeSelectEntry> getSelectEntries() {

		return this.selectEntries;
	}

	public void setSelectEntries(List<NodeSelectEntry> selectEntries) {

		this.selectEntries = selectEntries;

		// set the owning query
		for (NodeSelectEntry entry : selectEntries) {
			entry.setOwningQuery(this);
		}
	}

	public List<ComparisonWithEntry> getWithEntries() {

		return this.withEntries;
	}

	public void setWithEntries(List<ComparisonWithEntry> withEntries) {

		this.withEntries = withEntries;
	}

	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		// select Entries
		String selectEntriesPrefix = AuxServices.OPENPAREN_T + AuxServices.SELECT_T + AuxServices.SPACE_T;
		sb.append(selectEntriesPrefix);

		if (this.selectEntries.size() == 0) {
			sb.append(">>MQL Internal Format Error: no select entries<<"); //$NON-NLS-1$
		} else {
			int newIndent = indent + selectEntriesPrefix.length();
			this.selectEntries.get(0).toString(newIndent, sb);
			for (int i = 1; i < this.selectEntries.size(); i++) {
				sb.append(AuxServices.COMMA_T + AuxServices.SPACE_T);
				this.selectEntries.get(i).toString(newIndent, sb);
			}
		}

		// from Entries
		String fromEntriesPrefix = AuxServices.SPACE_T + AuxServices.FROM_T + AuxServices.SPACE_T;
		sb.append(AuxServices.newLine(indent) + fromEntriesPrefix);

		int newIndent = indent + fromEntriesPrefix.length();
		if (this.firstFromEntry == null) {
			sb.append(">>MQL Internal Format Error: invalid from entry<<"); //$NON-NLS-1$
		} else {
			this.firstFromEntry.toString(newIndent, sb);
		}
		sb.append(AuxServices.COMMA_T + AuxServices.newLine(newIndent));
		if (this.firstFromEntry == null) {
			sb.append(">>MQL Internal Format Error: invalid from entry<<"); //$NON-NLS-1$
		} else {
			this.secondFromEntry.toString(newIndent, sb);
		}

		// with Entries
		if (this.withEntries.size() > 0) {
			String withEntriesPrefix = AuxServices.SPACE_T + AuxServices.WHERE_T + AuxServices.SPACE_T;
			sb.append(AuxServices.newLine(indent) + withEntriesPrefix);
			int newWithIndent = indent + withEntriesPrefix.length();
			this.withEntries.get(0).toString(newWithIndent, sb);
			for (int i = 1; i < this.withEntries.size(); i++) {
				sb.append(AuxServices.newLine(indent) + withEntriesPrefix);
				this.withEntries.get(i).toString(newWithIndent, sb);
			}
		}

		// end of Select query
		sb.append(AuxServices.CLOSEPAREN_T + AuxServices.SPACE_T + AuxServices.AS_T + AuxServices.SPACE_T);

		// show the alias
		sb.append(getAliasName().toString());

		// finalize
		accumSb.append(sb);

		return sb.toString();
	}

}
