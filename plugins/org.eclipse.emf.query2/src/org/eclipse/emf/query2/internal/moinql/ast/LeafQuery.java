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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.fql.SpiFqlAttributeSelection;
import org.eclipse.emf.query2.internal.fql.SpiFqlJoinConstraint;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.fql.SpiFqlQuery;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryEntry;
import org.eclipse.emf.query2.internal.fql.SpiFqlSelection;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.moinql.engine.InterpreterImpl.PositionRecord;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;


/**
 * Leaf queries are internal queries which are directly the result of
 * translation from MQL AST (provided the query was well-typed and
 * well-formatted).
 */
final public class LeafQuery extends InternalQuery implements SpiFqlQuery {

	private SpiFacilityQueryLanguage fqlProcessor;

	private List<AtomicEntry> fromEntries;

	private List<WithEntry> withEntries;

	private List<LeafSelectEntry> selectEntries;

	private SpiFqlSelection[] selections;

	/**
	 * Use factory method!
	 */
	private LeafQuery(AliasName _aliasName, List<AtomicEntry> _fromEntries, List<WithEntry> _withEntries,
			List<LeafSelectEntry> _selectEntries) {

		this.aliasName = _aliasName;
		this.fromEntries = (_fromEntries == null ? new ArrayList<AtomicEntry>(0) : _fromEntries);
		this.withEntries = (_withEntries == null ? new ArrayList<WithEntry>(0) : _withEntries);
		this.selectEntries = _selectEntries;
	}

	/**
	 * Constructs a leaf query, but also sets the owning query (bidirectional
	 * assoc). The facility processor is not set.
	 */
	static public LeafQuery construct(AliasName _aliasName, List<AtomicEntry> _fromEntries, List<WithEntry> _withEntries,
			List<LeafSelectEntry> _selectEntries) {

		// construct the object
		LeafQuery leafQuery = new LeafQuery(_aliasName, _fromEntries, _withEntries, _selectEntries);

		// set the owning query
		for (LeafSelectEntry entry : _selectEntries) {
			entry.setOwningQuery(leafQuery);
		}

		return leafQuery;
	}

	/**
	 * Constructs a leaf query, but also sets the owning query (bidirectional
	 * assoc)
	 */
	static public LeafQuery construct(AliasName _aliasName, List<AtomicEntry> _fromEntries, List<WithEntry> _withEntries,
			List<LeafSelectEntry> _selectEntries, SpiFacilityQueryLanguage _fqlProcessor) {

		LeafQuery leafQuery = construct(_aliasName, _fromEntries, _withEntries, _selectEntries);
		leafQuery.setFqlProcessor(_fqlProcessor);
		return leafQuery;
	}

	public boolean isEmpty() {

		return false;
	}

	public SpiFacilityQueryLanguage getFqlProcessor() {

		return this.fqlProcessor;
	}

	public void setFqlProcessor(SpiFacilityQueryLanguage fqlProcessor) {

		this.fqlProcessor = fqlProcessor;
	}

	public List<AtomicEntry> getFromEntries() {

		return this.fromEntries;
	}

	public void setFromEntries(List<AtomicEntry> fromEntries) {

		this.fromEntries = (fromEntries == null ? new ArrayList<AtomicEntry>(0) : fromEntries);
	}

	public List<LeafSelectEntry> getSelectEntries() {

		return this.selectEntries;
	}

	public void setSelectEntries(List<LeafSelectEntry> selectEntries) {

		this.selectEntries = selectEntries;

		// reset the selections
		this.selections = null;

		// set the owning query
		for (LeafSelectEntry entry : selectEntries) {
			entry.setOwningQuery(this);
		}
	}

	public List<WithEntry> getWithEntries() {

		return this.withEntries;
	}

	public void setWithEntries(List<WithEntry> withEntries) {

		this.withEntries = (withEntries == null ? new ArrayList<WithEntry>(0) : withEntries);
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		// select Entries
		String bqProcessorName = AuxServices.EMPTYSTR;
		if (this.fqlProcessor != null) {
			bqProcessorName = AuxServices.OPENBRACKET_T + this.fqlProcessor.getFacilityId() + AuxServices.CLOSEBRACKET_T;
		}

		String selectEntriesPrefix = AuxServices.OPENPAREN_T + AuxServices.SELECT_T + bqProcessorName + AuxServices.SPACE_T;
		sb.append(selectEntriesPrefix);

		if (this.selectEntries.size() == 0) {
			throw new BugException(BugMessages.NO_SELECT_ENTRIES);
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

		// we buffer possible whereClauses
		StringBuilder whereClauseString = new StringBuilder();

		if (this.fromEntries.size() == 0) {
			throw new BugException(BugMessages.NO_FROM_ENTRIES);
		} else {
			int newIndent = indent + fromEntriesPrefix.length();
			this.fromEntries.get(0).toString(newIndent, sb, indent, whereClauseString);
			for (int i = 1; i < this.fromEntries.size(); i++) {
				sb.append(AuxServices.COMMA_T + AuxServices.newLine(newIndent));
				this.fromEntries.get(i).toString(newIndent, sb, indent, whereClauseString);
			}
		}

		// with Entries
		if (this.withEntries.size() > 0) {
			String withEntriesPrefix = AuxServices.SPACE_T + AuxServices.WHERE_T + AuxServices.SPACE_T;
			sb.append(AuxServices.newLine(indent) + withEntriesPrefix);
			int newIndent = indent + withEntriesPrefix.length();
			this.withEntries.get(0).toString(newIndent, sb);
			for (int i = 1; i < this.withEntries.size(); i++) {
				sb.append(AuxServices.newLine(indent) + withEntriesPrefix);
				this.withEntries.get(i).toString(newIndent, sb);
			}
		}

		// finalize where-clauses if they exist
		sb.append(whereClauseString);

		// end of select query
		sb.append(AuxServices.CLOSEPAREN_T + AuxServices.SPACE_T + AuxServices.AS_T + AuxServices.SPACE_T);

		// show the alias
		sb.append(getAliasName().toString());

		// finalize
		accumSb.append(sb);

		return sb.toString();
	}

	/*
	 * FQL
	 */

	public final class FqlSelectionImpl implements SpiFqlSelection {

		final private List<SpiFqlAttributeSelection> fqlAttributeSelections;

		final private SpiFqlQueryEntry owningEntry;

		public FqlSelectionImpl(SpiFqlQueryEntry owningEntry) {

			this.owningEntry = owningEntry;
			this.fqlAttributeSelections = new ArrayList<SpiFqlAttributeSelection>();
		}

		public void addAttributeSelection(SpiFqlAttributeSelection attributeSelection) {

			this.fqlAttributeSelections.add(attributeSelection);
		}

		public int getNumberOfAttributeSelections() {

			return this.fqlAttributeSelections.size();
		}

		public SpiFqlAttributeSelection[] getAttributeSelections() {

			return this.fqlAttributeSelections.toArray(new SpiFqlAttributeSelection[this.fqlAttributeSelections.size()]);
		}

		public SpiFqlQueryEntry getOwningQueryEntry() {

			return this.owningEntry;
		}
	}

	public final class FqlAttributeSelectionImpl implements SpiFqlAttributeSelection {

		final private String attributeName;

		final private SpiFqlPrimitiveType primitiveType;

		final private boolean isMultiValued;

		public FqlAttributeSelectionImpl(String attributeName, SpiFqlPrimitiveType primitiveType, boolean isMultiValued) {

			this.attributeName = attributeName;
			this.primitiveType = primitiveType;
			this.isMultiValued = isMultiValued;
		}

		public String getAttributeName() {

			return this.attributeName;
		}

		public SpiFqlPrimitiveType getPrimitiveType() {

			return this.primitiveType;
		}

		public boolean isMultiValued() {

			return this.isMultiValued;
		}
	}

	/*
	 * Query selections are rebuilt only if they did not exist before
	 */

	public SpiFqlSelection[] getQuerySelections() {

		if (this.selections == null) {
			// should not happen at this point
			throw new BugException(BugMessages.SETSELECTIONS_ORDERING_WRONG);
		}
		// only return the selections
		return this.selections;
	}

	/**
	 * Method constructs an FqlSelection[] array and a positioning map which
	 * tracks the relation between the internal selectioning and the
	 * FqlResultSet way of selecting.
	 */
	public void setSelections(Map<SelectEntry, PositionRecord> positionMap) {

		// the result selections
		List<SpiFqlSelection> selectionsList = new ArrayList<SpiFqlSelection>();

		// we maintain a map of atomic entries to its selections
		Map<AtomicEntry, FqlSelectionImpl> atomicEntryToSelection = new HashMap<AtomicEntry, FqlSelectionImpl>();

		// we keep a separate counter for the number of selections
		int selectionCounter = 0;

		// for each selectEntry, construct a new selection if required
		for (LeafSelectEntry selectEntry : this.selectEntries) {
			// get the type reference of the select entry
			TypeReference typeRef = selectEntry.getTypeReference();

			// we also need the atomic entry of the reference
			AtomicEntry atomicEntry = typeRef.getAtomicEntry();

			// construct a positionRecord and add it the positionMap
			PositionRecord positionRecord = new PositionRecord();
			positionMap.put(selectEntry, positionRecord);

			// we have to manage the selection for *this* select entry
			FqlSelectionImpl selection = null;

			// Add a selection if the reference is a AtomicEntryReference (this happens *also* for AtomicAttrReferences)
			if (typeRef instanceof AtomicEntryReference) {
				if (atomicEntryToSelection.containsKey(atomicEntry)) {
					// we already have a selection, so get it
					selection = atomicEntryToSelection.get(atomicEntry);

					// set the alias position
					positionRecord.aliasPosition = selectionsList.indexOf(selection);
				} else {
					// if the selection has not been constructed, construct one
					selection = new FqlSelectionImpl(atomicEntry);

					// add it to the result list
					selectionsList.add(selectionCounter, selection);

					// add the position data for aliases
					positionRecord.aliasPosition = selectionCounter;

					// add to the hashMap
					atomicEntryToSelection.put(atomicEntry, selection);

					// increase the counter;
					selectionCounter++;
				}

			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, typeRef.getClass().getCanonicalName(), "TypeReference"); //$NON-NLS-1$
			}

			// Add the attribute if we are dealing with an AtomicAttrReference
			if (typeRef instanceof AtomicAttrReference) {
				AtomicAttrReference typeAttrRef = (AtomicAttrReference) typeRef;

				// construct an attribute selection and set its features
				FqlAttributeSelectionImpl attributeSelection = new FqlAttributeSelectionImpl(typeAttrRef.getAttrName(), typeAttrRef
						.getAttrType(), typeAttrRef.isMultiValued());

				// add the attribute to the selection
				selection.addAttributeSelection(attributeSelection);

				// the index for the attribute is determined via the constructed selection
				int attributeIndex = selection.getNumberOfAttributeSelections() - 1;

				// complete the positionRecord
				positionRecord.attributePosition = attributeIndex;
				positionRecord.multivalued = attributeSelection.isMultiValued();
			}
		}

		// construct the result
		this.selections = selectionsList.toArray(new SpiFqlSelection[selectionsList.size()]);

	}

	public SpiFqlJoinConstraint[] getJoinConstraints() {

		List<WithEntry> withs = this.getWithEntries();
		return withs.toArray(new SpiFqlJoinConstraint[withs.size()]);
	}

	public SpiFqlQueryEntry[] getQueryEntries() {

		List<AtomicEntry> atomicEntries = this.getFromEntries();
		return atomicEntries.toArray(new SpiFqlQueryEntry[atomicEntries.size()]);
	}

	public String getUniqueAliasName() {

		return this.aliasName.toString();
	}
}
