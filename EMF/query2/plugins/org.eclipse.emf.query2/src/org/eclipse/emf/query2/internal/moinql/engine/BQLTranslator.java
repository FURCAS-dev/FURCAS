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
package org.eclipse.emf.query2.internal.moinql.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.bql.api.SpiAnd;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeInModelElement;
import org.eclipse.emf.query2.internal.bql.api.SpiAttributeToAttributeComparisonExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiBasicQueryProcessor;
import org.eclipse.emf.query2.internal.bql.api.SpiLike;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementClusterExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiMultiplicityType;
import org.eclipse.emf.query2.internal.bql.api.SpiOr;
import org.eclipse.emf.query2.internal.bql.api.SpiPartitionExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectList;
import org.eclipse.emf.query2.internal.bql.api.SpiSimpleComparisonExpression;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.ast.AssocPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntry;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntryFixedSet;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntryReference;
import org.eclipse.emf.query2.internal.moinql.ast.AttrComparison;
import org.eclipse.emf.query2.internal.moinql.ast.LeafQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LeafSelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.LikeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.LinksPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.NaryWhereClause;
import org.eclipse.emf.query2.internal.moinql.ast.NestedQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NumericComparison;
import org.eclipse.emf.query2.internal.moinql.ast.SelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.TypeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.TypeReference;
import org.eclipse.emf.query2.internal.moinql.ast.WhereClause;
import org.eclipse.emf.query2.internal.moinql.ast.WithEntry;
import org.eclipse.emf.query2.internal.moinql.engine.InterpreterImpl.PositionRecord;
import org.eclipse.emf.query2.internal.shared.BugException;


/**
 * Translates FQL queries into BQL
 */
public class BQLTranslator {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(BQLTranslator.class);

	/**
	 * We assume that the provided leaf query obeys the following invariants:
	 * <ul>
	 * <li>We expect that all assoc-predicates are connected in a cluster</li>
	 * <li>We expect that all attribute comparisons occur within the cluster</li>
	 * <li>We have no type comparisons in the with-entries</li>
	 * <li>For each nested query, we either assume it is again a leaf query
	 * obeying the described invariants, or if this is not the case, we expect
	 * an intermediate result</li>
	 * </ul>
	 * This function translates the leaf query into a BasicQL query and updates
	 * the positionMap appropriately.
	 */
	public SpiSelectExpression leafQuery2bql(LeafQuery leafQuery, Map<SelectEntry, PositionRecord> positionMap) {

		SpiSelectExpression result = null;

		try {
			result = this.toSelectExpression(leafQuery, positionMap);
		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_TRANSLATION_PRODUCED_QUERY,
						(result == null ? "NULL query" : result)); //$NON-NLS-1$
			}
		}

		return result;
	}

	/**
	 * Converts a leafQuery into a BQL SelectExpression.
	 */
	private SpiSelectExpression toSelectExpression(LeafQuery leafQuery, Map<SelectEntry, PositionRecord> positionMap) {

		// get the relevant query parts
		List<LeafSelectEntry> selectEntries = leafQuery.getSelectEntries();
		List<AtomicEntry> fromEntries = leafQuery.getFromEntries();
		List<WithEntry> withEntries = leafQuery.getWithEntries();
		SpiBasicQueryProcessor bqlProcessor = (SpiBasicQueryProcessor) (leafQuery.getFqlProcessor());

		// the fromEntries are copied into a list (on which the algorithm will work)
		List<AtomicEntry> atomicEntries = new ArrayList<AtomicEntry>(fromEntries.size());
		atomicEntries.addAll(fromEntries);

		// the head atomic entry for top-level query parts is simply the first from entry
		AtomicEntry headAtomicEntry = atomicEntries.remove(0);

		// we maintain a Map which maps aliases to AtomicEntries
		Map<String, SpiModelElementExpression> aliasToModelElement = new HashMap<String, SpiModelElementExpression>(fromEntries.size());

		// convert the actual internal query
		SpiModelElementClusterExpression modelElementCluster = this.toModelElementCluster(headAtomicEntry, atomicEntries, withEntries,
				aliasToModelElement, bqlProcessor);

		// calculate the select lists and fill the positionMap
		SpiSelectList[] selectLists = this.toSelectLists(selectEntries, aliasToModelElement, positionMap);

		// construct result

		return new SpiSelectExpression(modelElementCluster, selectLists);
	}

	/**
	 * Construct the select lists as well as the mappings from aliases and
	 * attribute names to their respective indices
	 */
	private SpiSelectList[] toSelectLists(List<LeafSelectEntry> selectEntries, Map<String, SpiModelElementExpression> aliasToModelElement,
			Map<SelectEntry, PositionRecord> positionMap) {

		// the selectList result structure
		List<SpiSelectList> selectLists = new ArrayList<SpiSelectList>();

		// we maintain a hashmap of aliases and its select list
		Map<AtomicEntry, SpiSelectList> aliasSelectLists = new HashMap<AtomicEntry, SpiSelectList>();

		// we keep a separate counter for the number of result sets
		int resultSetCounter = 0;

		// for each selectEntry, construct a new selectList if required
		for (LeafSelectEntry selectEntry : selectEntries) {
			// get the type reference of the select entry
			TypeReference typeRef = selectEntry.getTypeReference();

			// we also need the atomic entry of the reference
			AtomicEntry atomicEntry = typeRef.getAtomicEntry();

			// construct a positionRecord and add it the positionMap
			PositionRecord positionRecord = new PositionRecord();
			positionMap.put(selectEntry, positionRecord);

			// we have to manage the select list for *this* select entry
			SpiSelectList selectList = null;

			// Add a select list if the reference is a AtomicEntryReference
			if (typeRef instanceof AtomicEntryReference) {
				if (aliasSelectLists.containsKey(atomicEntry)) {
					// we already have a select list, so get it
					selectList = aliasSelectLists.get(atomicEntry);
					// set the alias position
					positionRecord.aliasPosition = selectLists.indexOf(selectList);
				} else {
					// if the select list has not been constructed

					// make the selectList
					selectList = new SpiSelectList(aliasToModelElement.get(atomicEntry.getAliasName().toString()));
					// add the result
					selectLists.add(resultSetCounter, selectList);
					// add the position data for aliases
					positionRecord.aliasPosition = resultSetCounter;

					// add to the hashMap
					aliasSelectLists.put(atomicEntry, selectList);

					// increase the counter;
					resultSetCounter++;
				}

			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, typeRef.getClass().getCanonicalName(), "TypeReference"); //$NON-NLS-1$
			}

			// Add the attribute if we are dealing with an AtomicAttrReference
			if (typeRef instanceof AtomicAttrReference) {
				AtomicAttrReference typeAttrRef = (AtomicAttrReference) typeRef;

				// get the relevant features
				boolean isMultiValued = typeAttrRef.isMultiValued();
				String attrName = typeAttrRef.getAttrName();
				SpiFqlPrimitiveType attrType = typeAttrRef.getAttrType();

				// check if we have a multi-valued attribute reference
				SpiMultiplicityType multiValued = (isMultiValued ? SpiMultiplicityType.ATTRIBUTE_MULTI_VALUED
						: SpiMultiplicityType.ATTRIBUTE_SINGLE_VALUED);

				// add the attribute to the select list
				selectList.addAttributeDefinition(attrName, attrType, multiValued);

				// the index for the attribute is determined via the constructed
				// selectList
				int attributeIndex = selectList.getNumberOfAttributeDefinitions() - 1;

				// complete the positionRecord
				positionRecord.attributePosition = attributeIndex;
				positionRecord.multivalued = isMultiValued;
			}
		}

		// construct the result
		SpiSelectList[] result = selectLists.toArray(new SpiSelectList[selectLists.size()]);

		return result;
	}

	/**
	 * Constructs a model element cluster. The head atomic entry becomes the
	 * head element. The other atomic Entries, the other
	 * ModelElementExpressions. WithEntries lead to the different link forms
	 */
	SpiModelElementClusterExpression toModelElementCluster(AtomicEntry headAtomicEntry, List<AtomicEntry> atomicEntries,
			List<WithEntry> withEntries, Map<String, SpiModelElementExpression> aliasToModelElement, SpiBasicQueryProcessor bqlProcessor) {

		// register the with entries, which are AttrComparisons, for later insertion
		Map<String, List<AttrComparison>> attrComparisons = new HashMap<String, List<AttrComparison>>();

		for (WithEntry withEntry : withEntries) {
			if (withEntry instanceof AttrComparison) {
				AttrComparison attrComparison = (AttrComparison) withEntry;
				// we always use the *left* attribute as the basis for inclusion
				// this decision is __arbitrary__
				String leftAliasName = attrComparison.getLeftAttr().getAtomicEntry().getAliasName().toString();
				if (attrComparisons.containsKey(leftAliasName)) {
					attrComparisons.get(leftAliasName).add(attrComparison);
				} else {
					List<AttrComparison> attrComparisonsList = new ArrayList<AttrComparison>();
					attrComparisonsList.add(attrComparison);
					attrComparisons.put(leftAliasName, attrComparisonsList);
				}
			}
		}

		// construct a headModelElementExpression out of the head Atomic Entry
		String headAlias = headAtomicEntry.getAliasName().toString();
		SpiModelElementExpression headModelElementExpression = this.toModelElementExpression(headAtomicEntry);
		headModelElementExpression.setAlias(headAlias);
		aliasToModelElement.put(headAlias, headModelElementExpression);

		// construct the cluster
		SpiModelElementClusterExpression cluster = new SpiModelElementClusterExpression(headModelElementExpression);

		// we then construct modelElementExpressions out of the atomic entries
		for (Iterator<AtomicEntry> iter = atomicEntries.iterator(); iter.hasNext();) {
			AtomicEntry atomicEntry = iter.next();
			String entryAlias = atomicEntry.getAliasName().toString();
			SpiModelElementExpression modelElementExpression = this.toModelElementExpression(atomicEntry);
			modelElementExpression.setAlias(entryAlias);
			aliasToModelElement.put(entryAlias, modelElementExpression);
			cluster.addModelElementExpressionToCluster(modelElementExpression);
		}

		// now, we have to extend each model element expression potentially with
		// extra attribute expressions to cater for attribute comparisons
		this.addAttributeComparisons(headModelElementExpression, attrComparisons.get(headAlias), aliasToModelElement);

		List<SpiModelElementExpression> modelElementExpressions = cluster.getAdditionalModelElementExpressions();
		for (SpiModelElementExpression modelElementExpression : modelElementExpressions) {
			// add the assigned AttrComparisons for each model element expression
			this.addAttributeComparisons(modelElementExpression, attrComparisons.get(modelElementExpression.getAlias()),
					aliasToModelElement);
		}

		// finally, we have to process the Assoc and Link predicates in the with
		// entries and add them to the cluster
		for (WithEntry withEntry : withEntries) {
			this.addLinkToCluster(cluster, withEntry, aliasToModelElement, bqlProcessor);
		}

		return cluster;
	}

	/**
	 * For a an atomic entry, we can construct a ModelElementExpression.
	 */
	private SpiModelElementExpression toModelElementExpression(AtomicEntry atomicEntry) {

		// first, convert the local where clause to a local attribute expression
		SpiAttributeExpression attributeExpression = this.toAttributeExpression(atomicEntry.getWhereClause());

		// to keep the result
		SpiModelElementExpression result = null;

		// the kind of model element expression to construct depends on the
		// nature of the atomic entry
		if (atomicEntry instanceof AtomicEntryFixedSet) {
			Set<URI> elements = ((AtomicEntryFixedSet) atomicEntry).getElements();
			URI[] elementsAsArray = elements.toArray(new URI[elements.size()]);

			// construct result
			result = new SpiModelElementExpression(elementsAsArray);

		} else {
			// the types are directly available
			List<URI> types = atomicEntry.getClassMRIs();
			URI[] typesAsArray = null;

			// however, if we have Reflect::Element, we enter the empty type set
			if (atomicEntry.isReflectElement()) {
				typesAsArray = new URI[0];
			} else {
				typesAsArray = types.toArray(new URI[types.size()]);
			}

			// construct partition expression
			SpiPartitionExpression partitionExpression = null;

			Set<URI> scope = atomicEntry.getScope();
			URI[] scopeAsArray = null;
			if (scope == null) {
				scopeAsArray = new URI[0];
			} else {
				scopeAsArray = new URI[scope.size()];
				scope.toArray(scopeAsArray);
			}

			if (atomicEntry.isScopeInclusive()) {
				partitionExpression = new SpiPartitionExpression(scopeAsArray, true);
			} else if (scope != null && scopeAsArray.length > 0) {
				partitionExpression = new SpiPartitionExpression(scopeAsArray, false);
			}

			// the category
			SpiFqlFromTypeCategory modelElementCategory = atomicEntry.getTypeCategory();

			// construct result
			result = new SpiModelElementExpression(typesAsArray, modelElementCategory, partitionExpression);
		}

		// attach the attribute expression
		result.setAttributeExpression(attributeExpression);

		return result;
	}

	/**
	 * A WhereClause can be translated into an AttributeExpression
	 */
	private SpiAttributeExpression toAttributeExpression(WhereClause whereClause) {

		SpiAttributeExpression result = null;

		// first check if we actually have a where clause in the first place
		if (whereClause != null) {

			if (whereClause instanceof NaryWhereClause) {
				NaryWhereClause naryWhereClause = (NaryWhereClause) whereClause;
				List<WhereClause> nestedWhereClauses = naryWhereClause.getNestedClauses();

				// translate recursively for all nested where clauses
				List<SpiAttributeExpression> anExpressionList = new ArrayList<SpiAttributeExpression>(nestedWhereClauses.size());

				for (WhereClause nestedClause : nestedWhereClauses) {
					anExpressionList.add(this.toAttributeExpression(nestedClause));
				}

				// construct the result and consider whether we have an OR or AND clause
				if (naryWhereClause.isOrConnected()) {
					result = new SpiOr(anExpressionList);
				} else {
					result = new SpiAnd(anExpressionList);
				}

			} else if (whereClause instanceof LikeComparison) {
				LikeComparison likeComparison = (LikeComparison) whereClause;
				result = new SpiLike(likeComparison.getAttrName(), likeComparison.isNegated(), likeComparison.getLikePattern());

			} else if (whereClause instanceof NumericComparison) {
				NumericComparison numericComparison = (NumericComparison) whereClause;
				String attrName = numericComparison.getAttrName();
				SpiFqlPrimitiveType attrType = numericComparison.getAttrType();
				Object operand = numericComparison.getOperandValue();
				result = new SpiSimpleComparisonExpression(attrName, attrType, numericComparison.getOperation(), operand);

			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, whereClause.getClass().getCanonicalName(), "WhereClause"); //$NON-NLS-1$
			}
		}

		return result;
	}

	/**
	 * This method alters the attribute expression of the modelElementExpression
	 * if additional attrComparisons exist. It requires the aliasToModelElement
	 * structure for this
	 */
	private void addAttributeComparisons(SpiModelElementExpression modelElementExpression, List<AttrComparison> attrComparisons,
			Map<String, SpiModelElementExpression> aliasToModelElement) {

		SpiAttributeExpression attrExpression = modelElementExpression.getAttributeExpression();

		// only change something if attrComparisons are not empty
		if (attrComparisons != null && attrComparisons.size() > 0) {
			// collect all constructed attribute expressions
			List<SpiAttributeExpression> attributeExpressions = new ArrayList<SpiAttributeExpression>(attrComparisons.size());

			for (Iterator<AttrComparison> iter = attrComparisons.iterator(); iter.hasNext();) {
				// obtain all the relevant features
				AttrComparison attrComp = iter.next();
				String leftAttrName = attrComp.getLeftAttr().getAttrName();
				String rightAliasName = attrComp.getRightAttr().getAtomicEntry().getAliasName().toString();
				String rightAttrName = attrComp.getRightAttr().getAttrName();
				SpiModelElementExpression rightModelElementExpr = aliasToModelElement.get(rightAliasName);

				// construct AttributeInModelElement
				SpiAttributeInModelElement attrInModelElement = new SpiAttributeInModelElement(rightModelElementExpr, rightAttrName);

				// construct attributeExpr
				SpiAttributeExpression newAttrExpr = new SpiAttributeToAttributeComparisonExpression(leftAttrName, attrComp.getLeftAttr()
						.getAttrType(), attrComp.getOperation(), attrInModelElement);

				// add in the list
				attributeExpressions.add(newAttrExpr);
			}

			// reconstruct the attrExpressions
			SpiAttributeExpression resultAttrExpression = null;

			if (attrExpression == null && attributeExpressions.size() == 1) {
				// special case
				resultAttrExpression = attributeExpressions.get(0);
			} else {
				// otherwise we always construct a conjunction

				if (attrExpression != null) {
					// add the previous attribute expression to the list
					attributeExpressions.add(attrExpression);
					// construct result as a logical AND
					resultAttrExpression = new SpiAnd(attributeExpressions);
				}

			}

			// assign result
			modelElementExpression.setAttributeExpression(resultAttrExpression);
		}
	}

	/**
	 * WithEntries, which are assoc or link predicates, can be added to the
	 * cluster
	 */
	@SuppressWarnings("null")
	private void addLinkToCluster(SpiModelElementClusterExpression cluster, WithEntry withEntry,
			Map<String, SpiModelElementExpression> aliasToModelElement, SpiBasicQueryProcessor bqlProcessor) {

		// case analysis on the type of the JoinWhereEntry

		if (withEntry instanceof TypeComparison) {
			// currently not supported
			throw new BugException(BugMessages.TYPE_COMPARISON_NOT_SUPPORTED);
		} else if (withEntry instanceof AttrComparison) {
			// already dealt with
		} else if (withEntry instanceof AssocPredicate) {
			AssocPredicate assocPredicate = (AssocPredicate) withEntry;

			// the fromModelElement is the "left" side and the toLinkable is the
			// "right" side
			String leftAliasName = assocPredicate.getFromType().getAtomicEntry().getAliasName().toString();
			String rightAliasName = assocPredicate.getToType().getAtomicEntry().getAliasName().toString();
			SpiModelElementExpression fromModelElementExpression = aliasToModelElement.get(leftAliasName);
			SpiModelElementExpression toModelElementExpression = aliasToModelElement.get(rightAliasName);

			// set the other features of the link expression
			URI linkMRI = assocPredicate.getAssocMRI();
			//            SpiFqlAssociationCategory assocCatogory = SpiFqlAssociationCategory.ASSOCIATION;
			//            byte storageEnd = (byte) ( assocPredicate.hasStorageAtFromEnd( ) ? assocPredicate.getFromAssocEnd( ) : assocPredicate.getToAssocEnd( ) );
			//            byte assocEnd = (byte) assocPredicate.getToAssocEnd( );

			// add it
			cluster.addClusterInternalLink(linkMRI, fromModelElementExpression, toModelElementExpression);

		} else if (withEntry instanceof LinksPredicate) {
			LinksPredicate linksPredicate = (LinksPredicate) withEntry;

			// obtain the relevant LinkExpression features (except the nested query)
			String aliasName = linksPredicate.getFromType().getAtomicEntry().getAliasName().toString();
			SpiModelElementExpression fromModelElementExpression = aliasToModelElement.get(aliasName);
			URI linkMRI = linksPredicate.getAssocMRI();
			//            SpiFqlAssociationCategory assocCategory = linksPredicate.getAssocCategory( );

			//            byte storageEnd = (byte) ( linksPredicate.hasStorageAtToEnd( ) ? linksPredicate.getToAssocEnd( ) : ( linksPredicate.getToAssocEnd( ) == 0 ? 1 : 0 ) );
			//            byte assocEnd = (byte) linksPredicate.getToAssocEnd( );
			boolean isLinked = !linksPredicate.isNegated();

			// deal with the nested query to produce the link expression
			NestedQuery nestedQuery = linksPredicate.getNestedQuery();

			if (nestedQuery.getResultSet() != null) {
				SpiFqlQueryResultSet resultSet = nestedQuery.getResultSet();
				// unwrap the nested result set
				int resultSetSize = (resultSet == null ? 0 : resultSet.getSize());
				URI[] MRIs = new URI[resultSetSize];
				for (int i = 0; i < resultSetSize; i++) {
					MRIs[i] = resultSet.getMri(i, 0);
				}

				// immediately build the result
				cluster.addMriSetLink(isLinked, linkMRI, fromModelElementExpression, MRIs);
			} else if (nestedQuery.getInternalQuery() instanceof LeafQuery) {
				// we are not given an intermediate result set, so translate the
				// nested query (which has to be a leaf query) recursively
				LeafQuery nestedLeafQuery = (LeafQuery) nestedQuery.getInternalQuery();

				// first check if the basic query processor of the nested query
				// is identical to that of the encompassing query
				SpiBasicQueryProcessor nestedBqlProcessor = (SpiBasicQueryProcessor) (nestedLeafQuery.getFqlProcessor());
				//                String facilityId = bqlProcessor.getFacilityId( );
				//                String nestedFacilityId = nestedBqlProcessor.getFacilityId( );
				//                if ( !( facilityId.equals( nestedFacilityId ) ) ) {
				//                    throw new MQLBugException( MQLBugMessages.INCOMPATIBLE_FQL_IN_LEAF_QUERIES, facilityId, nestedFacilityId );
				//                }

				// get the relevant query parts
				List<LeafSelectEntry> selectEntries = nestedLeafQuery.getSelectEntries();
				List<AtomicEntry> fromEntries = nestedLeafQuery.getFromEntries();
				List<WithEntry> withEntries = nestedLeafQuery.getWithEntries();

				// copy the from entries
				List<AtomicEntry> atomicEntries = new ArrayList<AtomicEntry>(fromEntries.size());
				atomicEntries.addAll(fromEntries);

				// the head atomic entry for top-level query parts is decided by
				// the first select entry
				AtomicEntry headAtomicEntry = selectEntries.get(0).getAtomicEntryReference().getAtomicEntry();

				// remove it from the atomicEntries
				atomicEntries.remove(headAtomicEntry);

				// we maintain a new Map which maps aliases to AtomicEntries
				Map<String, SpiModelElementExpression> newAliasToModelElement = new HashMap<String, SpiModelElementExpression>(fromEntries
						.size());

				// convert the nested query
				SpiModelElementClusterExpression nestedCluster = this.toModelElementCluster(headAtomicEntry, atomicEntries, withEntries,
						newAliasToModelElement, nestedBqlProcessor);

				// build result
				cluster.addClusterExternalLink(isLinked, linkMRI, fromModelElementExpression, nestedCluster);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_UNEVALUATED_NESTED_QUERY);
			}

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, withEntry.getClass().getCanonicalName(), "JoinWhereEntry"); //$NON-NLS-1$
		}

	}

}
