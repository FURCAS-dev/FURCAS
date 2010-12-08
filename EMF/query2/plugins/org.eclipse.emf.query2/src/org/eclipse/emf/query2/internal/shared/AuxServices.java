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
 * Created on 17.03.2006
 */
package org.eclipse.emf.query2.internal.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.ast.AliasName;
import org.eclipse.emf.query2.internal.moinql.ast.AssocPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntry;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntryFixedSet;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntryReference;
import org.eclipse.emf.query2.internal.moinql.ast.AttrComparison;
import org.eclipse.emf.query2.internal.moinql.ast.ComparisonWithEntry;
import org.eclipse.emf.query2.internal.moinql.ast.EmptyQuery;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LeafQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LeafSelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.LikeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.LinksPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.NaryWhereClause;
import org.eclipse.emf.query2.internal.moinql.ast.NestedQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NodeQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NodeSelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.NumericComparison;
import org.eclipse.emf.query2.internal.moinql.ast.ResultUnion;
import org.eclipse.emf.query2.internal.moinql.ast.SelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.TypeAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.TypeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.TypeReference;
import org.eclipse.emf.query2.internal.moinql.ast.VirtualAtomicAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.VirtualAtomicEntryReference;
import org.eclipse.emf.query2.internal.moinql.ast.WhereClause;
import org.eclipse.emf.query2.internal.moinql.ast.WithEntry;

/**
 * The MQL transformation service provides services which are shared across transformation phases in the MQL processor.
 */
final public class AuxServices {

	/*
	 * --------- PUBLIC CONSTANTS ---------
	 */

	public static final String INTERNALALIASPREFIX = "MQL_INTERNAL"; //$NON-NLS-1$

	//    public static final String MOFCONTAINERNAME = MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME;

	public static final String REFLECTPACKAGENAME = "Reflect"; //$NON-NLS-1$

	public static final String ELEMENTCLASSNAME = "Element"; //$NON-NLS-1$

	public static final String MOIN_TOP_PACKAGE = "MOIN"; //$NON-NLS-1$

	public static final int STRING_COMPARISON_MAX_LENGTH = 200;

	@SuppressWarnings("nls")
	public static final String OPENPAREN_T = "(", CLOSEPAREN_T = ")", SYMNOT_T = "!", COMMA_T = ",", DOT_T = ".", BACKSLASH_T = "\\", GREATER_T = ">", GREATEREQUAL_T = ">=", EQUAL_T = "=", NOTEQUAL_T = "<>", LESS_T = "<", LESSEQUAL_T = "<=", SPACE_T = " ", OPENCURLY_T = "{", CLOSECURLY_T = "}", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			OPENBRACKET_T = "[", CLOSEBRACKET_T = "]", OPENQUOTE_T = "'", CLOSEQUOTE_T = "'", AND_T = "and", OR_T = "or", NOT_T = "not", SELECT_T = "select", FROM_T = "from", WHERE_T = "where", AS_T = "as", RESET_T = "reset", UNION_T = "union", ASSOC_T = "assoc", IN_T = "in", LIKE_T = "like", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$
			ISMULTIVALUED_T = "multi", COLONCOLON_T = "::", EMPTY_T = "EMPTY", STORAGE_T = "@", PARTITION_T = "P", ELEMENTS_T = "E", CONTAINER_T = "C", FOR_T = "for", SHARP_T = "#", EMPTYSTR = ""; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$

	public static final String RESULTALIAS = "MQL_RESULT"; //$NON-NLS-1$

	public static final String NESTEDALIAS = "MQL_NESTED"; //$NON-NLS-1$

	private static final QueryLogger logger = LoggerFactory.getLogger(AuxServices.class);

	/*
	 * -------- PUBLIC STATIC AUXILIARIES --------
	 */

	public static String newLine(int indent) {

		char[] spaces = new char[indent + 1];
		Arrays.fill(spaces, ' ');
		spaces[0] = '\n';
		return new String(spaces);
	}

	/**
	 * This method cuts off any trailing blanks.
	 */
	public static String cutOffTrailingBlanks(String str) {

		String result = str;
		if (str != null) {
			// we need it as a char array
			char[] strAsArray = str.toCharArray();
			// the position of the last blank is one after the last character
			int lastBlankPos = strAsArray.length;

			// we count down until we do not find a blank anymore (or the string is empty)
			for (boolean stillBlanks = true; stillBlanks && lastBlankPos > 0;) {
				// check if we have another blank
				stillBlanks = strAsArray[lastBlankPos - 1] == ' ';
				if (stillBlanks) {
					// if we do have another blank, we adjust the lastBlankPos
					lastBlankPos--;
				}
			}

			// cut off the trailing blanks
			result = str.substring(0, lastBlankPos);

		}
		return result;
	}

	/**
	 * Compares two object values for the operation. IMPORTANT: this has to be semantically identical to the meaning of the operations in
	 * FQL!
	 */
	public static boolean compareValues(Object obj1, SpiFqlComparisonOperation operation, Object obj2) {

		if (obj1 == null || obj2 == null) {
			// if one object is null, we only compare for equality or inequality
			switch (operation) {
			case EQUAL:
			case GREATER_OR_EQUAL:
			case LESS_OR_EQUAL:
				// equality
				return (obj1 == null && obj2 == null);
			case GREATER:
			case LESS:
				return false;
			case NOT_EQUAL:
				// inequality
				return (obj1 == null ? obj2 != null : obj2 == null);
			default:
				throw new BugException(BugMessages.UNKNOWN_OPERATOR, operation);
			}
		}

		// if we are dealing with enums, we obtain the strings
		if (obj1 instanceof Enumerator) {
			obj1 = obj1.toString();
		}

		if (obj2 instanceof Enumerator) {
			obj2 = obj2.toString();
		}

		// if we are dealing with strings, we have to artificially impose the string limitations
		if (obj1 instanceof String) {
			String str1 = (String) obj1;
			str1 = (str1.length() > STRING_COMPARISON_MAX_LENGTH ? str1.substring(0, STRING_COMPARISON_MAX_LENGTH) : str1);
			obj1 = AuxServices.cutOffTrailingBlanks(str1);
		}

		if (obj2 instanceof String) {
			String str2 = (String) obj2;
			str2 = (str2.length() > STRING_COMPARISON_MAX_LENGTH ? str2.substring(0, STRING_COMPARISON_MAX_LENGTH) : str2);
			obj2 = AuxServices.cutOffTrailingBlanks(str2);
		}

		// sanity check
		if (!obj1.getClass().equals(obj2.getClass())) {
			throw new BugException(BugMessages.UNEXPECTED_DIFFERENT_VALUE_TYPES, obj1.getClass().getName(), obj2.getClass().getName());
		}

		/*
		 * perform the operation
		 */

		// strings or booleans
		if (obj1 instanceof String || obj1 instanceof Boolean) {
			if (operation == SpiFqlComparisonOperation.EQUAL) {
				return obj1.equals(obj2);
			} else if (operation == SpiFqlComparisonOperation.NOT_EQUAL) {
				return !(obj1.equals(obj2));
			} else {
				throw new BugException(BugMessages.UNEXPECTED_COMPARATOR_STRING_BOOL, operation);
			}
		}

		// numerals
		Number valueNumber = (Number) obj1;
		Number comparedValueNumber = (Number) obj2;

		// calculate long comparison value indicating
		// value > compared value -> positive
		// value < compared value -> negative
		// value == compared value -> 0
		long comparisonValue;

		if (obj1 instanceof Double || obj1 instanceof Float) {
			// case for doubles and floats
			double valueDouble = valueNumber.doubleValue();
			double comparedValueDouble = comparedValueNumber.doubleValue();
			if (valueDouble == comparedValueDouble) {
				comparisonValue = 0;
			} else if (valueDouble > comparedValueDouble) {
				comparisonValue = 1;
			} else {
				comparisonValue = -1;
			}
		} else {
			// case for longs and integers
			long valueLong = valueNumber.longValue();
			long comparedValueLong = comparedValueNumber.longValue();
			comparisonValue = valueLong - comparedValueLong;
		}

		// compare
		switch (operation) {
		case EQUAL:
			return comparisonValue == 0;
		case NOT_EQUAL:
			return comparisonValue != 0;
		case GREATER:
			return comparisonValue > 0;
		case GREATER_OR_EQUAL:
			return comparisonValue >= 0;
		case LESS:
			return comparisonValue < 0;
		case LESS_OR_EQUAL:
			return comparisonValue <= 0;
		default:
			throw new BugException(BugMessages.UNKNOWN_OPERATOR, operation);
		}
	}

	/*
	 * -------- PUBLIC TRANSFORMATION SERVICES --------
	 */

	/**
	 * Splits the internal into strongly connected components in terms of association predicates. The result is again an internal query
	 */
	public InternalQuery split(InternalQuery internalQuery) {

		// split the query and ignore the selectEntryMap
		InternalQuery newInternalQuery = null;

		try {

			// to avoid multiple splits
			Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>();

			// because a splitter may changes the nature of a leaf query, we have to keep a map from select entries to possibly new select entries
			Map<SelectEntry, SelectEntry> selectEntryMap = new HashMap<SelectEntry, SelectEntry>();

			newInternalQuery = this.splitInternalQuery(internalQuery, seenNestedQuery, selectEntryMap);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_SPLITTING,
						"\n", (newInternalQuery == null ? "NULL query" : newInternalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return newInternalQuery;
	}

	/**
	 * Produce a clone of the internal query. The flag allows for a clone which shares internal queries occurring in nested queries (in link
	 * predicates). In other words, if includeNestedQueries is true, a deep clone is made, otherwise, a shallow clone. The atomicEntryMap is
	 * a return parameter, which registers which atomic entries have been mapped to which atomic entries
	 */
	public InternalQuery clone(InternalQuery internalQuery, boolean includeNestedQueries, Map<AtomicEntry, AtomicEntry> atomicEntryMap) {

		// to avoid redoing the same nested query
		Map<NestedQuery, NestedQuery> nestedQueryMap = new HashMap<NestedQuery, NestedQuery>();

		// this hash maps along with the atomicEntryMap keep track of previously cloned elements
		Map<SelectEntry, SelectEntry> selectEntryMap = new HashMap<SelectEntry, SelectEntry>();

		// actually produce the deep copy of the internal query
		return this.deepCopyInternalQuery(internalQuery, selectEntryMap, atomicEntryMap, nestedQueryMap, includeNestedQueries);
	}

	/**
	 * Just clone the atomic entry
	 */
	public AtomicEntry cloneAtomicEntry(AtomicEntry atomicEntry) {

		return this.deepCopyAtomicEntry(atomicEntry, new HashMap<AtomicEntry, AtomicEntry>(1));
	}

	/**
	 * Transforms the query by adjusting structure-type scopes and looking for empty parts.
	 */
	public InternalQuery reduceQueryAfterScopeChanges(InternalQuery internalQuery) {

		/*
		 * (1) adjusting structure type scope
		 */

		/*
		 * Adjust the scope of structure-based atomic entries. They have to be the union of the scopes of the class-based atomic entries to
		 * which they are connected (directly or indirectly). This is necessary because phase 2 ignores structure types in its optimization.
		 */
		try {
			this.adjustStructureTypeScopeInternalQuery(internalQuery);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_ADJUSTING_STRUCTURE_TYPE_SCOPE,
						"\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		/*
		 * (2) Remove empty parts from the query
		 */
		InternalQuery newInternalQuery = null;

		try {

			// to avoid redoing the same nested query
			Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>();

			// we need this redirection map because it is possible that the first operand of a result-union disappears
			// if has become empty. Encompassing node queries need to be able to redirect properly
			Map<SelectEntry, SelectEntry> selectEntryMap = new HashMap<SelectEntry, SelectEntry>();

			// remove empty parts of a query
			newInternalQuery = this.removeEmptyPartsForInternalQuery(internalQuery, seenNestedQuery, selectEntryMap);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_REMOVING_EMPTY_PARTS,
						"\n", (newInternalQuery == null ? "NULL query" : newInternalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return newInternalQuery;
	}

	/**
	 * Computes the set intersection of two scopes. Note that the two booleans are combined by a logical OR (we leave it to the caller to
	 * handle this)
	 */
	public <E> Set<E> intersectScopes(Set<E> leftScope, boolean leftIncluded, Set<E> rightScope, boolean rightIncluded) {

		return this.combineSets(true, leftScope, leftIncluded, rightScope, rightIncluded);
	}

	/**
	 * Computes the set union of two scopes. Note that the two booleans are combined by a logical AND (we leave it to the caller to handle
	 * this)
	 */
	public <E> Set<E> unionScopes(Set<E> leftScope, boolean leftIncluded, Set<E> rightScope, boolean rightIncluded) {

		return this.combineSets(false, leftScope, leftIncluded, rightScope, rightIncluded);
	}

	/**
	 * Recursively searches for the outermost select entry list
	 */
	public List<SelectEntry> calculateSelectEntries(InternalQuery internalQuery) {

		return this.calculateSelectEntriesFromInternalQuery(internalQuery);
	}

	/**
	 * Simply redirects the contained select entries of the virtualAtomicEntryReference in the provided nodeSelectEntries and
	 * comparisonWithEntries
	 */
	public void redirectTypeReferencesForNodeQuery(List<NodeSelectEntry> selectEntries, List<ComparisonWithEntry> withEntries,
			Map<SelectEntry, SelectEntry> selectEntryMap) {

		this.redirectTypeReferencesForNodeQueries(selectEntries, withEntries, selectEntryMap);
	}

	/**
	 * Convenience method to insert extra indirection
	 */
	public VirtualAtomicEntryReference constructVirtualAtomicEntryReference(SelectEntry nestedSelectEntry) {

		return this.constructVirtualIndirection(nestedSelectEntry);
	}

	/**
	 * Type comparison removal happens by walking over the type comparisons, constructing a new atomic entry which builds the intersection
	 * entry, removing the type comparison, removing the old atomic entries from the from-entries and finally replacing any references to
	 * the old atomic entry with the new atomic entry
	 */
	public void removeTypeComparisons(InternalQuery internalQuery) {

		try {
			// this set keeps track of shared nested queries
			Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>();

			this.removeTypeComparisonsForInternalQuery(internalQuery, seenNestedQuery);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_REMOVING_TYPE_COMPARISONS,
						"\n", internalQuery == null ? "NULL query" : internalQuery); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Compresses node queries where possible by combining leaf queries if they operate in the same facility and only have alias comparisons
	 * between the two leaf queries At some point, we want to also compress attribute comparisons, but is only possible whenever FQL queries
	 * can handle non-assocPredicate connected attribute comparisons.
	 */
	public InternalQuery compressNodeQueries(InternalQuery internalQuery) {

		InternalQuery resultQuery = null;
		try {
			// this set keeps track of shared nested queries
			Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>();

			// because the compressor may change the nature of a node query, we have to keep a map from select entries to possibly new select entries
			Map<SelectEntry, SelectEntry> selectEntryMap = new HashMap<SelectEntry, SelectEntry>();

			resultQuery = this.compressNodeQueriesForInternalQuery(internalQuery, seenNestedQuery, selectEntryMap);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_COMPRESSING_NODE_QUERIES,
						"\n", (resultQuery == null ? "NULL query" : resultQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return resultQuery;
	}

	/*
	 * ------------- PRIVATE METHODS -------------
	 */

	/* -------- */
	/* Splitter */
	/* -------- */

	/**
	 * The general splitter is the standard recursion over the different query types, with possible redirections for the node queries
	 */
	private InternalQuery splitInternalQuery(InternalQuery internalQuery, Set<NestedQuery> seenNestedQuery,
			Map<SelectEntry, SelectEntry> selectEntryMap) {

		InternalQuery resultQuery = null;

		// case analysis on the internal query
		if (internalQuery instanceof LeafQuery) {
			resultQuery = this.splitLeafQuery((LeafQuery) internalQuery, seenNestedQuery, selectEntryMap);

		} else if (internalQuery instanceof NodeQuery) {
			resultQuery = this.splitNodeQuery((NodeQuery) internalQuery, seenNestedQuery, selectEntryMap);

		} else if (internalQuery instanceof ResultUnion) {
			// obtain operands ...
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();
			AliasName aliasName = internalQuery.getAliasName();

			// ... and split recursively
			List<InternalQuery> newOperands = new ArrayList<InternalQuery>(operands.size());

			// we split each operand
			for (InternalQuery operand : operands) {
				InternalQuery newOperand = this.splitInternalQuery(operand, seenNestedQuery, selectEntryMap);
				newOperands.add(newOperand);
			}

			// construct result
			resultQuery = new ResultUnion(aliasName, newOperands);

		} else if (internalQuery instanceof EmptyQuery) {
			resultQuery = internalQuery;

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		// return result
		return resultQuery;
	}

	/**
	 * Splitting of a NodeQuery is essentially a recursion. However, because query splitting may affect the form of the select entries in
	 * nested from-query, we have to use the newSelectEntryMap to correct the SelectEntries and ComparisonWithEntries of the encompassing
	 * node query.
	 */
	private InternalQuery splitNodeQuery(NodeQuery nodeQuery, Set<NestedQuery> seenNestedQuery, Map<SelectEntry, SelectEntry> selectEntryMap) {

		InternalQuery firstFromEntry = nodeQuery.getFirstFromEntry();
		InternalQuery secondFromEntry = nodeQuery.getSecondFromEntry();

		List<NodeSelectEntry> selectEntries = nodeQuery.getSelectEntries();
		List<ComparisonWithEntry> withEntries = nodeQuery.getWithEntries();

		// work recursively on the first entry
		InternalQuery newFirstFromEntry = this.splitInternalQuery(firstFromEntry, seenNestedQuery, selectEntryMap);

		// work recursively on the second entry
		InternalQuery newSecondFromEntry = this.splitInternalQuery(secondFromEntry, seenNestedQuery, selectEntryMap);

		// update the type references for the select and with entries of this node query
		this.redirectTypeReferencesForNodeQueries(selectEntries, withEntries, selectEntryMap);

		// construct result
		nodeQuery.setFirstFromEntry(newFirstFromEntry);
		nodeQuery.setSecondFromEntry(newSecondFromEntry);

		return nodeQuery;
	}

	/**
	 * The splitter works per leaf query (and recursively for nested leaf queries) and consists of several phases:
	 * <ul>
	 * <li>(1) Split the query along cluster boundaries, where for each cluster we maintain the following data:
	 * <ul>
	 * <li>the atomic from-entries belonging to this component (including their where-clauses)</li>
	 * <li>the required select-entries to construct the final result</li>
	 * <li>the required with-clauses which belong to the cluster</li>
	 * <li>the required cross-cluster (attribute or type ) comparisons</li>
	 * </ul>
	 * </li>
	 * <li>(2) We collect all cross-cluster comparisons, group them in pairs according to aliases and weigh them with the number of
	 * comparisons
	 * <li>(3) Based on the cross-cluster comparisons, we start combining queries pairwise and construct the entire query from that. Note
	 * that if no further cross-cluster comparisons are available, we can pair in any order. Also, we maintain some book-keeping to minimize
	 * the number of select entries to what is required for the encompassing query
	 * </ul>
	 * </ul>
	 */
	private InternalQuery splitLeafQuery(LeafQuery leafQuery, Set<NestedQuery> seenNestedQuery, Map<SelectEntry, SelectEntry> selectEntryMap) {

		// this set will contain all the ComparisonWithEntries, which cross cluster boundaries 
		Set<ComparisonWithEntry> crossComparisonWithEntries = new HashSet<ComparisonWithEntry>();

		// in the first phase, we scan the leafQuery and construct clusters with
		// strongly assoc-connected types. As a result, we have a list of Leaf Queries, which are strongly connected. 
		// moreover, it will also select the atomic entries required for cross-cluster comparisons, which we keep in a list.
		// The ComparisonWithEntries keeps those comparisonWithEntries, which cross cluster boundaries. It lifts them so
		// that they refer to the select entry they need from the participating leaf entry
		Set<InternalQuery> clustersFromLeafQuery = this.buildStronglyConnectedClusters(leafQuery, crossComparisonWithEntries,
				seenNestedQuery);

		// we only need to do anything at all if we *had* clusters
		if (clustersFromLeafQuery.size() == 0) {
			// sanity check
			throw new BugException(BugMessages.NO_CLUSTER_AVAILABLE);
		} else if (clustersFromLeafQuery.size() == 1) {
			if (!crossComparisonWithEntries.isEmpty()) {
				// sanity check
				throw new BugException(BugMessages.CROSS_CLUSTER_COMPARISON_WITHENTRIES_IN_ONE_CLUSTER);
			}

			InternalQuery oneResultQuery = clustersFromLeafQuery.iterator().next();

			// update the select entry map for encompassing queries (if they exist)
			this.updateSelectEntryMap(this.calculateSelectEntriesFromInternalQuery(leafQuery), this
					.calculateSelectEntriesFromInternalQuery(oneResultQuery), selectEntryMap);

			return oneResultQuery;

		} else {

			// if we have more than one cluster, we analyze the ComparisonWithEntries and
			// build up a list of ClusterPair elements which are sorted according to their weight. 
			// There will always be at least one pair!

			List<ClusterPair> clusterPairs = this.assignClusterPairs(clustersFromLeafQuery, crossComparisonWithEntries);

			// for reconstructing the leaf selections in the right order, we require the leafquery's select entries
			List<LeafSelectEntry> leafSelectEntries = leafQuery.getSelectEntries();
			// and a set of its atomic entry references
			Set<AtomicEntryReference> topLevelAtomicEntryRefs = new HashSet<AtomicEntryReference>(leafSelectEntries.size());
			for (LeafSelectEntry leafSelectEntry : leafSelectEntries) {
				topLevelAtomicEntryRefs.add(leafSelectEntry.getAtomicEntryReference());
			}

			// we use the sorted list of cluster pairs to construct the new InternalQuery which is always a NodeQuery.
			NodeQuery nodeQuery = this.combineClusterComponents(leafSelectEntries, topLevelAtomicEntryRefs, clusterPairs,
					crossComparisonWithEntries);

			// remove nodeSelectEntries, which do not exist as leafSelectEntry of the original (can with free-floating clusters)
			for (Iterator<NodeSelectEntry> nodeSelectEntryIterator = nodeQuery.getSelectEntries().iterator(); nodeSelectEntryIterator
					.hasNext();) {
				if (!topLevelAtomicEntryRefs.contains(nodeSelectEntryIterator.next().getLeafSelectEntry().getAtomicEntryReference())) {
					nodeSelectEntryIterator.remove();
				}
			}

			// finally, update the select entry map for encompassing queries (if they exist)
			this.updateSelectEntryMap(this.calculateSelectEntriesFromInternalQuery(leafQuery), this
					.calculateSelectEntriesFromInternalQuery(nodeQuery), selectEntryMap);

			return nodeQuery;
		}
	}

	/**
	 * Produces a bunch of LeafQueries for each strongly connected set of atomic entries. As an invariant, we assume that the list of
	 * atomicEntries is not empty. The Set of ComparisonWithEntries is filled with all cross-cluster comparisonWithEntries
	 */
	private Set<InternalQuery> buildStronglyConnectedClusters(LeafQuery leafQuery, Set<ComparisonWithEntry> crossComparisonWithEntries,
			Set<NestedQuery> seenNestedQuery) {

		// get the leafQuery parts
		AliasName leafQueryName = leafQuery.getAliasName();
		SpiFacilityQueryLanguage fqlProcessor = leafQuery.getFqlProcessor();
		List<LeafSelectEntry> leafSelectEntries = leafQuery.getSelectEntries();
		List<AtomicEntry> oldAtomicEntries = leafQuery.getFromEntries();
		List<WithEntry> oldWithEntries = leafQuery.getWithEntries();

		Set<InternalQuery> resultLeafQueries = new HashSet<InternalQuery>();
		while (!(oldAtomicEntries.isEmpty())) {
			// keep building cluster components as long as there are atomicEntries left
			resultLeafQueries.add(this.buildOneStronglyComponent(leafQueryName, fqlProcessor, leafSelectEntries, oldAtomicEntries,
					oldWithEntries, crossComparisonWithEntries, seenNestedQuery));
		}

		return resultLeafQueries;
	}

	/**
	 * Actually builds a leaf query for a found strongly connected cluster component
	 */
	private LeafQuery buildOneStronglyComponent(AliasName leafQueryName, SpiFacilityQueryLanguage fqlProcessor,
			List<LeafSelectEntry> topLevelSelectEntries, List<AtomicEntry> oldAtomicEntries, List<WithEntry> oldWithEntries,
			Set<ComparisonWithEntry> crossComparisonWithEntries, Set<NestedQuery> seenNestedQuery) {

		// for lookup reasons
		Set<AtomicEntry> clusterAtomicEntries = new HashSet<AtomicEntry>();
		Map<AtomicEntryReference, LeafSelectEntry> clusterSelectEntryMap = new HashMap<AtomicEntryReference, LeafSelectEntry>();

		// for constructing the new cluster leaf query
		List<AtomicEntry> clusterAtomicEntryList = new ArrayList<AtomicEntry>();
		List<LeafSelectEntry> clusterSelectEntries = new ArrayList<LeafSelectEntry>();
		List<WithEntry> clusterWithEntryList = new ArrayList<WithEntry>();

		// (1) first, we calculate one strongly-connected cluster

		// Search for the atomic entries which actually belong to this cluster
		Set<AtomicEntry> stillToProcess = new LinkedHashSet<AtomicEntry>();

		// we initialize it with the one guaranteed member
		stillToProcess.add(oldAtomicEntries.get(0));

		// keep going until the to-be-processed set is empty
		while (!stillToProcess.isEmpty()) {
			// first we obtain an entry to-be-processed
			AtomicEntry atomicEntry = stillToProcess.iterator().next();

			// and remove it from the stillToProcess set
			stillToProcess.remove(atomicEntry);

			// remove the element also from the atomicEntries list
			oldAtomicEntries.remove(atomicEntry);

			// add it to the from-entries of the cluster
			clusterAtomicEntries.add(atomicEntry);
			clusterAtomicEntryList.add(atomicEntry);

			// for all with entries, we first build up the cluster by investigating assocPredicates
			for (Iterator<WithEntry> withEntryIterator = oldWithEntries.iterator(); withEntryIterator.hasNext();) {
				WithEntry withEntry = withEntryIterator.next();

				// case analysis on the with entry
				if (withEntry instanceof LinksPredicate) {
					LinksPredicate linksPredicate = (LinksPredicate) withEntry;

					// check if this linksPredicate belongs to this cluster
					if (linksPredicate.getFromType().getAtomicEntry().equals(atomicEntry)) {
						// if the linksPredicate belongs to this cluster, we may want to do recursive splitting
						NestedQuery nestedQuery = linksPredicate.getNestedQuery();

						if (seenNestedQuery.add(nestedQuery)) {
							nestedQuery.setInternalQuery(this.splitInternalQuery(nestedQuery.getInternalQuery(), seenNestedQuery,
									new HashMap<SelectEntry, SelectEntry>()));
						}

						// add withEntry to the cluster
						clusterWithEntryList.add(linksPredicate);

						// remove this with-entry from the original list
						withEntryIterator.remove();
					}

				} else if (withEntry instanceof AssocPredicate) {
					AssocPredicate assocPredicate = (AssocPredicate) withEntry;

					// get the left and right atomic entries
					AtomicEntry leftAtomicEntry = assocPredicate.getFromType().getAtomicEntry();
					AtomicEntry rightAtomicEntry = assocPredicate.getToType().getAtomicEntry();

					if (leftAtomicEntry.equals(atomicEntry)) {
						// the assocPredicate belongs to this cluster via the
						// left type. Add the withEntry to the cluster.
						clusterWithEntryList.add(assocPredicate);
						// check if we have to put the other type in the stillToProcess set
						if (!clusterAtomicEntries.contains(rightAtomicEntry)) {
							// only if the "other type" is still in the list of
							// atomic entries, it might still have to be processed
							stillToProcess.add(rightAtomicEntry);
						}
						// remove this with-entry from the original list
						withEntryIterator.remove();

					} else if (rightAtomicEntry.equals(atomicEntry)) {
						// the assocPredicate belongs to this cluster via the
						// right. Add the withEntry to the cluster
						clusterWithEntryList.add(assocPredicate);
						// check if we have to put the other type in the set
						if (!clusterAtomicEntries.contains(leftAtomicEntry)) {
							// only if the "other type" is still in the list of
							// atomic entries, it might still has to be processed
							stillToProcess.add(leftAtomicEntry);
						}
						// remove this with-entry from the original list
						withEntryIterator.remove();
					}
				}

			}
		}

		// (2) now run over the remaining withEntries and check for all comparisonWithEntries if
		// a) they belong to the cluster -> add them
		// b) one reference hangs in this cluster, which means it crosses the cluster -> add a select entry and 
		// update the comparisonWithEntry to reflect this as well 
		for (Iterator<WithEntry> withEntryIterator = oldWithEntries.iterator(); withEntryIterator.hasNext();) {
			WithEntry withEntry = withEntryIterator.next();

			// only do something for ComparisonWithEntries
			if (withEntry instanceof ComparisonWithEntry) {
				ComparisonWithEntry comparisonWithEntry = (ComparisonWithEntry) withEntry;
				TypeReference leftReference = comparisonWithEntry.getLeftTypeReference();
				TypeReference rightReference = comparisonWithEntry.getRightTypeReference();

				boolean leftPointsInCluster = clusterAtomicEntries.contains(leftReference.getAtomicEntry());
				boolean rightPointsInCluster = clusterAtomicEntries.contains(rightReference.getAtomicEntry());

				if (leftPointsInCluster && rightPointsInCluster) {
					// case a), so just belongs to cluster without adaptation
					clusterWithEntryList.add(comparisonWithEntry);
					// remove from original list
					withEntryIterator.remove();
				} else if (leftPointsInCluster || rightPointsInCluster) {
					// case b)

					// get the relevant atomic entry reference
					AtomicEntryReference internalAtomicEntryReference = (AtomicEntryReference) (leftPointsInCluster ? leftReference
							: rightReference);

					// obtain or construct the select entry for the outside comparison into this cluster
					LeafSelectEntry newSelectEntry = clusterSelectEntryMap.get(internalAtomicEntryReference);
					if (newSelectEntry == null) {
						// create extra leafSelectEntry
						newSelectEntry = new LeafSelectEntry(internalAtomicEntryReference);
						clusterSelectEntryMap.put(internalAtomicEntryReference, newSelectEntry);
					}

					// construct a new type reference
					TypeReference newTypeReference = this.constructVirtualIndirection(newSelectEntry);

					// upgrade the appropriate side of the comparisonWithEntry
					if (leftPointsInCluster) {
						comparisonWithEntry.setLeftType(newTypeReference);
						// add to the list of comparisonWithEntries if not already there
						if (rightReference instanceof VirtualAtomicEntryReference) {
							// if the right reference has already been lifted, it is already known as a crossComparisonWithEntry
							// and we only should remove it from the to-be-handled with entries 
							withEntryIterator.remove();
						} else {
							// this is the first side, which is lifted, so register the comparison as a cross-cluster comparison with entry
							crossComparisonWithEntries.add(comparisonWithEntry);
						}

					} else {
						comparisonWithEntry.setRightType(newTypeReference);
						// add to the list of comparisonWithEntries if not already there
						if (leftReference instanceof VirtualAtomicEntryReference) {
							// if the left reference has already been lifted, it is already known as a crossComparisonWithEntry
							// and we only should remove it from the to-be-handled with entries 
							withEntryIterator.remove();
						} else {
							// this is the first side, which is lifted, so register the comparison as a cross-cluster comparison with entry
							crossComparisonWithEntries.add(comparisonWithEntry);
						}
					}

				} // all other cases not of interest               
			}
		}

		// (3) finally, walk over the select entries, and for all those pointing in the cluster, add them to the to-be-constructed leaf query
		// and construct a nodeSelectEntry for the result
		for (LeafSelectEntry oldLeafSelectEntry : topLevelSelectEntries) {

			AtomicEntryReference oldSelectAtomicEntryReference = oldLeafSelectEntry.getAtomicEntryReference();

			// we're only interested if the leaf select entry points in the current cluster
			if (clusterAtomicEntries.contains(oldSelectAtomicEntryReference.getAtomicEntry())) {
				// however, we use the constructed leaf select entry if we had to reconstruct one for crossCluster comparisonWithEntries
				LeafSelectEntry newLeafSelectEntry = clusterSelectEntryMap.remove(oldSelectAtomicEntryReference);
				if (newLeafSelectEntry != null) {
					//select entry construct before for cross-cluster comparisonWithEntry 
					clusterSelectEntries.add(newLeafSelectEntry);
				} else {
					// select entry only required for top-level resulting select entries
					clusterSelectEntries.add(oldLeafSelectEntry);
				}
			}
		}

		// we add the additional select entries required for comparisons outside this cluster
		for (Map.Entry<AtomicEntryReference, LeafSelectEntry> selectEntryRecord : clusterSelectEntryMap.entrySet()) {
			clusterSelectEntries.add(selectEntryRecord.getValue());
		}

		if (clusterSelectEntries.isEmpty()) {
			// only happens in degenerated cases - just select the first atomic entry
			clusterSelectEntries.add(new LeafSelectEntry(new AtomicEntryReference(clusterAtomicEntryList.iterator().next())));
		}

		// construct the result
		return LeafQuery.construct(new AliasName(leafQueryName), clusterAtomicEntryList, clusterWithEntryList, clusterSelectEntries,
				fqlProcessor);

	}

	/**
	 * This class represents a pair of cluster components, which is compared one or more times with a ComparisonWithEntry. The left and
	 * right cluster match the left and right of the comparisons.
	 */
	private final class ClusterPair implements Comparable<ClusterPair> {

		// the number of comparisons in this pair (indicates its weight)
		private int weight;

		// left cluster involved in a comparison
		private InternalQuery leftCluster;

		// right cluster involved in a comparison
		private InternalQuery rightCluster;

		// all the comparisons inside *this* pair
		private List<ComparisonWithEntry> comparisons;

		// constructor with one comparison
		public ClusterPair(InternalQuery leftCluster, InternalQuery rightCluster, List<ComparisonWithEntry> comparisonWithEntries) {

			this.leftCluster = leftCluster;
			this.rightCluster = rightCluster;
			this.comparisons = comparisonWithEntries;
			this.weight = comparisonWithEntries.size();
		}

		// constructor with no comparison
		public ClusterPair(InternalQuery leftCluster, InternalQuery rightCluster) {

			this(leftCluster, rightCluster, new ArrayList<ComparisonWithEntry>());
		}

		public void addComparison(ComparisonWithEntry comparisonWithEntry) {

			this.comparisons.add(comparisonWithEntry);
			this.weight++;
		}

		public List<ComparisonWithEntry> getComparisons() {

			return this.comparisons;
		}

		public InternalQuery getLeftCluster() {

			return this.leftCluster;
		}

		public InternalQuery getRightCluster() {

			return this.rightCluster;
		}

		public void setLeftCluster(InternalQuery leftCluster) {

			this.leftCluster = leftCluster;
		}

		public void setRightCluster(InternalQuery rightCluster) {

			this.rightCluster = rightCluster;
		}

		// the comparator compares the weights in reverse order, i.e. the
		// highest weight comes first
		public int compareTo(ClusterPair other) {

			int otherWeight = other.weight;
			return (this.weight > otherWeight ? -1 : (this.weight == otherWeight ? 0 : 1));
		}
	}

	/**
	 * We group all comparisonWithEntries in clusterPairs combining the comparisons between the same InternalQueries (which are LeafQueries
	 * for now). We also construct ClusterPairs for all ClusterComponents which do not collaborate with other cluster components and connect
	 * them (arbitrarily) with the first clusterComponent. At this point, there is *always* more than one cluster component
	 */
	private List<ClusterPair> assignClusterPairs(Set<InternalQuery> clusterComponents, Set<ComparisonWithEntry> comparisonWithEntries) {

		// (1) Now construct the pairs from the comparisonWithEntries

		// we keep a map from components to the cluster pairs in which they participate
		Map<InternalQueryPair, List<ComparisonWithEntry>> queryPairToComparisons = new HashMap<InternalQueryPair, List<ComparisonWithEntry>>();

		// we first scan the comparisonWithEntries and fill the queryPairToComparisons map
		for (ComparisonWithEntry comparisonWithEntry : comparisonWithEntries) {

			// we obtain the two involved queries
			InternalQuery leftCluster = ((VirtualAtomicEntryReference) comparisonWithEntry.getLeftTypeReference()).getNestedSelectEntry()
					.getLeafSelectEntry().getOwningQuery();
			InternalQuery rightCluster = ((VirtualAtomicEntryReference) comparisonWithEntry.getRightTypeReference()).getNestedSelectEntry()
					.getLeafSelectEntry().getOwningQuery();

			// check if this pair of clusters was seen before in a comparisonWithEntry
			InternalQueryPair pairFromLeftToRight = new InternalQueryPair(leftCluster, rightCluster);

			List<ComparisonWithEntry> comparisonWithEntriesForPair = queryPairToComparisons.get(pairFromLeftToRight);
			if (comparisonWithEntriesForPair == null) {
				InternalQueryPair pairFromRightToLeft = new InternalQueryPair(rightCluster, leftCluster);
				// if one order no success, try the other order
				comparisonWithEntriesForPair = queryPairToComparisons.get(pairFromRightToLeft);
			}

			if (comparisonWithEntriesForPair == null) {
				// the combination was certainly not seen before
				comparisonWithEntriesForPair = new ArrayList<ComparisonWithEntry>();
				// add this to the pairFromLeftToRight (arbitrary)
				queryPairToComparisons.put(pairFromLeftToRight, comparisonWithEntriesForPair);
			}

			// now actually add the comparison
			comparisonWithEntriesForPair.add(comparisonWithEntry);
		}

		// this is the first cluster component, which was put in a cluster pair (if any)
		InternalQuery arbitraryClusterComponentInPair = null;

		// start producing the resulting cluster pairs
		List<ClusterPair> resultPairs = new ArrayList<ClusterPair>(queryPairToComparisons.size());

		for (Map.Entry<InternalQueryPair, List<ComparisonWithEntry>> pairToComparisonsEntry : queryPairToComparisons.entrySet()) {
			InternalQuery firstQuery = pairToComparisonsEntry.getKey().firstQuery;
			InternalQuery secondQuery = pairToComparisonsEntry.getKey().secondQuery;

			// first remove from the cluster components list, as this means these two queries are already paired
			clusterComponents.remove(firstQuery);
			clusterComponents.remove(secondQuery);

			// however, arbitrary register the first of these for hooking up the components which are not connected at all
			if (arbitraryClusterComponentInPair == null) {
				arbitraryClusterComponentInPair = firstQuery;
			}

			// construct the cluster pair and add it to the result
			ClusterPair clusterPair = new ClusterPair(firstQuery, secondQuery, pairToComparisonsEntry.getValue());
			resultPairs.add(clusterPair);
		}

		// (2) also handle the clusterComponents which are not connected (if they exist)
		// those are the ones left in the clusterComponents Set

		// get the iterator
		Iterator<InternalQuery> clusterComponentsIterator = clusterComponents.iterator();

		if (arbitraryClusterComponentInPair == null) {
			// if we have no arbitraryClusterComponentInPair, we use the first from the set of cluster components (there is at least one then!)
			arbitraryClusterComponentInPair = clusterComponentsIterator.next();
		}

		// loop over the remaining ones and connect them

		for (; clusterComponentsIterator.hasNext();) {
			// we arbitrary hook up the remaining non-connected cluster components
			ClusterPair clusterPair = new ClusterPair(arbitraryClusterComponentInPair, clusterComponentsIterator.next());
			resultPairs.add(clusterPair);
		}

		// finally we sort the ClusterGroup list such that the highest weighted
		// ClusterPair comes first
		Collections.sort(resultPairs);

		return resultPairs;
	}

	/**
	 * Simply a pair of internal queries whose identity is defined by the two queries (in the right order)
	 */
	public class InternalQueryPair {

		final public InternalQuery firstQuery;

		final public InternalQuery secondQuery;

		public InternalQueryPair(InternalQuery firstQuery, InternalQuery secondQuery) {

			this.firstQuery = firstQuery;
			this.secondQuery = secondQuery;
		}

		@Override
		public int hashCode() {

			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.firstQuery == null) ? 0 : this.firstQuery.hashCode());
			result = prime * result + ((this.secondQuery == null) ? 0 : this.secondQuery.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {

			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			final InternalQueryPair other = (InternalQueryPair) obj;
			if (this.firstQuery == null) {
				if (other.firstQuery != null) {
					return false;
				}
			} else if (!this.firstQuery.equals(other.firstQuery)) {
				return false;
			}
			if (this.secondQuery == null) {
				if (other.secondQuery != null) {
					return false;
				}
			} else if (!this.secondQuery.equals(other.secondQuery)) {
				return false;
			}
			return true;
		}
	}

	/**
	 * Combines the pairs of clusters in the order of the provided clusterPairList and constructs new node queries out of this. We assume at
	 * least one cluster pair at this point.
	 */
	private NodeQuery combineClusterComponents(List<LeafSelectEntry> topLevelSelectEntries,
			Set<AtomicEntryReference> topLevelAtomicEntryRefs, List<ClusterPair> clusterPairs,
			Set<ComparisonWithEntry> crossComparisonWithEntries) {

		ClusterPair removedClusterPair = clusterPairs.remove(0);

		// we first construct a new node query from the cluster pair. This means combining the query, 
		// constructing select entries and redefining all other comparisonWithEntries (potentially).
		// We also remove those comparisonWithEntries, which are subsumed in the built node query
		NodeQuery nodeQuery = this.constructQueryFromClusterPair(topLevelSelectEntries, topLevelAtomicEntryRefs, removedClusterPair,
				crossComparisonWithEntries);

		// we have to verify the end of the recursion
		if (clusterPairs.isEmpty()) {
			// end of recursion, simply return result
			return nodeQuery;
		} else {
			// we have to continue processing 

			// adapt the clusterPair list to reflect the new node query
			// we also maintain the crossComparisonWithEntries by removing thos which 
			this.regroupClusterPairs(nodeQuery, removedClusterPair, clusterPairs);

			// resort because some clusterPairs merged and increased their weight
			Collections.sort(clusterPairs);

			// do the recursion
			return this.combineClusterComponents(topLevelSelectEntries, topLevelAtomicEntryRefs, clusterPairs, crossComparisonWithEntries);
		}
	}

	/**
	 * Produces the correct node query from the cluster pair
	 */
	private NodeQuery constructQueryFromClusterPair(List<LeafSelectEntry> topLevelSelectEntries,
			Set<AtomicEntryReference> topLevelAtomicEntryRefs, ClusterPair clusterPair, Set<ComparisonWithEntry> crossComparisonWithEntries) {

		// the from-entry parts
		InternalQuery firstFromEntry = clusterPair.getLeftCluster();
		InternalQuery secondFromEntry = clusterPair.getRightCluster();

		// the comparisonWithEntries
		List<ComparisonWithEntry> comparisonWithEntries = clusterPair.getComparisons();

		// first remove these from the overall set of crossComparisonWithEnries
		for (ComparisonWithEntry comparisonWithEntry : comparisonWithEntries) {
			if (!(crossComparisonWithEntries.remove(comparisonWithEntry))) {
				// sanity check
				throw new BugException(BugMessages.COMPARISON_WITH_ENTRY_OF_PAIR_FAILED);
			}
		}

		// the selection part is more tricky

		// we first produce a set of all atomic entries references used in the cross-cluster comparison in withEntries for other pairs
		// This will help to determine which select entries we have to keep from the leaf queries
		Set<AtomicEntryReference> atomicEntryReferenceForOtherComparisonWithEntries = new HashSet<AtomicEntryReference>();
		for (ComparisonWithEntry comparisonWithEntry : crossComparisonWithEntries) {
			atomicEntryReferenceForOtherComparisonWithEntries.add(comparisonWithEntry.getLeftTypeReference().getAtomicEntryReference());
			atomicEntryReferenceForOtherComparisonWithEntries.add(comparisonWithEntry.getRightTypeReference().getAtomicEntryReference());
		}

		// we produce a map of the required select entries for which we have to do a selection in this query.
		// It maps the original atomicEntryReference on the actually used select entry
		Map<AtomicEntryReference, SelectEntry> requiredSelectEntries = new HashMap<AtomicEntryReference, SelectEntry>();

		// for firstFromEntry
		for (SelectEntry firstSelectEntry : this.calculateSelectEntriesFromInternalQuery(firstFromEntry)) {
			AtomicEntryReference firstAtomicEntryReference = firstSelectEntry.getLeafSelectEntry().getAtomicEntryReference();

			// we only enter if a) the select entry is required in end-result or b) the select entry is required for other(!) cross-comparison entries
			if (topLevelAtomicEntryRefs.contains(firstAtomicEntryReference)
					|| atomicEntryReferenceForOtherComparisonWithEntries.contains(firstAtomicEntryReference)) {
				requiredSelectEntries.put(firstAtomicEntryReference, firstSelectEntry);
			}
		}

		// for secondFromEntry
		for (SelectEntry secondSelectEntry : this.calculateSelectEntriesFromInternalQuery(secondFromEntry)) {
			AtomicEntryReference secondAtomicEntryReference = secondSelectEntry.getLeafSelectEntry().getAtomicEntryReference();

			// we only enter if a) the select entry is required in end-result or b) the select entry is required for other(!) cross-comparison entries
			if (topLevelAtomicEntryRefs.contains(secondAtomicEntryReference)
					|| atomicEntryReferenceForOtherComparisonWithEntries.contains(secondAtomicEntryReference)) {
				requiredSelectEntries.put(secondAtomicEntryReference, secondSelectEntry);
			}
		}

		// now build up the actual list of select entries for this node query
		List<NodeSelectEntry> newSelectEntries = new ArrayList<NodeSelectEntry>();

		// first, we enter the select entries for the end-result in the right order. This is important because if 
		// this is the last node query to-be-built, this will be the basis for the result of the transformed leaf query
		for (LeafSelectEntry topLevelLeafSelectEntry : topLevelSelectEntries) {
			SelectEntry mappedSelectEntry = requiredSelectEntries.remove(topLevelLeafSelectEntry.getAtomicEntryReference());
			if (mappedSelectEntry != null) {
				// add it to the final result
				newSelectEntries.add(new NodeSelectEntry(this.constructVirtualIndirection(mappedSelectEntry)));
			}
		}

		// now we have to deal with the remaining required select entries, i.e. the ones needed by "other" comparisonWithEntries.
		for (Map.Entry<AtomicEntryReference, SelectEntry> remainingRequiredSelectEntry : requiredSelectEntries.entrySet()) {
			newSelectEntries.add(new NodeSelectEntry(this.constructVirtualIndirection(remainingRequiredSelectEntry.getValue())));
		}

		// build result query
		return NodeQuery.construct(new AliasName(firstFromEntry.getAliasName()), firstFromEntry, secondFromEntry, comparisonWithEntries,
				newSelectEntries);
	}

	/**
	 * Convenience method to insert extra indirection
	 */
	private VirtualAtomicEntryReference constructVirtualIndirection(SelectEntry nestedSelectEntry) {

		TypeReference atomicEntryReference = nestedSelectEntry.getTypeReference();
		if (atomicEntryReference instanceof TypeAttrReference) {
			atomicEntryReference = new VirtualAtomicAttrReference(nestedSelectEntry);
		} else {
			atomicEntryReference = new VirtualAtomicEntryReference(nestedSelectEntry);
		}
		return (VirtualAtomicEntryReference) atomicEntryReference;
	}

	/**
	 * Now we have to integrate the newly built nodeQuery in the existing data structures, which means to adapt the new clusterPairs, and
	 * all the "other" comparisonWithEntries
	 */
	private void regroupClusterPairs(NodeQuery newNodeQuery, ClusterPair disappaeringClusterPair, List<ClusterPair> clusterPairs) {

		// This maps registers all select entries of the new node query as a map from its original leaf to its current node
		Map<LeafSelectEntry, NodeSelectEntry> selectedEntries = new HashMap<LeafSelectEntry, NodeSelectEntry>();
		for (NodeSelectEntry nodeSelectEntry : newNodeQuery.getSelectEntries()) {
			selectedEntries.put(nodeSelectEntry.getLeafSelectEntry(), nodeSelectEntry);
		}

		// we need access to this
		InternalQuery disappearingLeftClusterComponent = disappaeringClusterPair.getLeftCluster();
		InternalQuery disappearingRightClusterComponent = disappaeringClusterPair.getRightCluster();

		// we work ourselves through the existing cluster pairs and do some book-keeping
		for (ClusterPair clusterPair : clusterPairs) {

			// we first adapt all comparisonWithEntries of the clusterPairs, which "look" into the new node query
			for (ComparisonWithEntry comparisonWithEntry : clusterPair.getComparisons()) {
				// for each, check if we have to adapt and if so, do it
				// observe that the TypeReferences *have* to be virtual at this point
				SelectEntry leftNestedSelectEntry = ((VirtualAtomicEntryReference) comparisonWithEntry.getLeftTypeReference())
						.getNestedSelectEntry();
				SelectEntry rightNestedSelectEntry = ((VirtualAtomicEntryReference) comparisonWithEntry.getRightTypeReference())
						.getNestedSelectEntry();

				// check if left is relevant
				NodeSelectEntry leftNodeSelectEntry = selectedEntries.get(leftNestedSelectEntry.getLeafSelectEntry());
				if (leftNodeSelectEntry != null) {
					// update by constructing a new indirection
					comparisonWithEntry.setLeftType(this.constructVirtualIndirection(leftNodeSelectEntry));
				}

				// check if right is relevant
				NodeSelectEntry rightNodeSelectEntry = selectedEntries.get(rightNestedSelectEntry.getLeafSelectEntry());
				if (rightNodeSelectEntry != null) {
					// update by constructing a new indirection
					comparisonWithEntry.setRightType(this.constructVirtualIndirection(rightNodeSelectEntry));
				}
			}

			// update the cluster pair itself as well (if necessary)

			// obtain the two relevant internal queries
			InternalQuery leftClusterComponent = clusterPair.getLeftCluster();
			InternalQuery rightClusterComponent = clusterPair.getRightCluster();

			// if the left Cluster component looks into the disappearing pair, update it to the new node query
			if (leftClusterComponent.equals(disappearingLeftClusterComponent)
					|| leftClusterComponent.equals(disappearingRightClusterComponent)) {
				// simply replace the leftClusterComponent with the new node query
				clusterPair.setLeftCluster(newNodeQuery);
			}

			// if the right Cluster component looks into the disappearing pair, update it to the new node query
			// note that these 2 conditions are exclusive from each other
			if (rightClusterComponent.equals(disappearingLeftClusterComponent)
					|| rightClusterComponent.equals(disappearingRightClusterComponent)) {
				// simply replace the rightClusterComponent with the new node query
				clusterPair.setRightCluster(newNodeQuery);
			}
		}

		// the previous iteration may have constructed ClusterPairs which refer to the same two internal queries. These have to be 
		// merged. We again use the InternalQueryPair structure for this.
		Map<InternalQueryPair, ClusterPair> internalQueryPairToClusterPairMap = new HashMap<InternalQueryPair, ClusterPair>(clusterPairs
				.size());
		for (Iterator<ClusterPair> clusterPairsIterator = clusterPairs.iterator(); clusterPairsIterator.hasNext();) {
			ClusterPair clusterPair = clusterPairsIterator.next();
			InternalQuery leftClusterComponent = clusterPair.getLeftCluster();
			InternalQuery rightClusterComponent = clusterPair.getRightCluster();

			// check if one direction
			InternalQueryPair pairFromLeftToRight = new InternalQueryPair(leftClusterComponent, rightClusterComponent);
			ClusterPair previousClusterPair = internalQueryPairToClusterPairMap.get(pairFromLeftToRight);

			if (previousClusterPair == null) {
				InternalQueryPair pairFromRightToLeft = new InternalQueryPair(rightClusterComponent, leftClusterComponent);
				// check in the other direction
				previousClusterPair = internalQueryPairToClusterPairMap.get(pairFromRightToLeft);
			}

			// if it exists before, conflate in the previous and remove the current cluster pair
			if (previousClusterPair != null) {
				// remove the current one
				clusterPairsIterator.remove();

				// conflate by adding the comparison with entries
				for (ComparisonWithEntry comparisonWithEntry : clusterPair.getComparisons()) {
					previousClusterPair.addComparison(comparisonWithEntry);
				}

			} else {
				// otherwise just add
				internalQueryPairToClusterPairMap.put(pairFromLeftToRight, clusterPair);
			}
		}
	}

	/**
	 * Merges the source atomicEntry and target atomicEntry (does not alter the source atomic entry). The invariant is that the source
	 * atomic entry cannot be a fixed set entry if the target atomic entry is not a fixed set.
	 */
	private void mergeLeftAtomicEntryIntoRightAtomicEntry(AtomicEntry sourceAtomicEntry, AtomicEntry targetAtomicEntry) {

		// we keep a boolean flag to see if the atomic entries are actually incompatible. By default, we assume
		// they are compatible
		boolean incompatible = false;

		// (1) merge types (the lists are live, so transform the targetAtomicEntry into the correct version
		List<URI> sourceTypes = sourceAtomicEntry.getClassMRIs();

		if (targetAtomicEntry.isReflectElement()) {
			// if the target entry is reflective, we move the types from the source entry
			targetAtomicEntry.setClassMRIs(sourceAtomicEntry.getClassMRIs());
			targetAtomicEntry.setClassNames(sourceAtomicEntry.getClassNames());
		} else if (!sourceAtomicEntry.isReflectElement()) {
			// if the target and source entries are *not* reflective, we intersect the types 
			Iterator<URI> targetTypeIter = targetAtomicEntry.getClassMRIs().iterator();
			Iterator<String> targetTypeNamesIter = targetAtomicEntry.getClassNames().iterator();
			for (; targetTypeIter.hasNext();) {
				URI element = targetTypeIter.next();
				targetTypeNamesIter.next();
				if (!sourceTypes.contains(element)) {
					targetTypeIter.remove();
					targetTypeNamesIter.remove();
				}
			}

			// if there are no target atomic entry class MRIs left, we have an incompatibility
			incompatible = targetAtomicEntry.getClassMRIs().isEmpty();

		} // if the source is reflective, we do not have to do anything in terms of types

		if (!incompatible) {
			// if the two atomic entries are compatible

			// we have to set the reflection flag of the target.
			targetAtomicEntry.setReflectElement((sourceAtomicEntry.isReflectElement() && targetAtomicEntry.isReflectElement()));

			// (2) now handle the scopes and/or fixed element sets
			if (targetAtomicEntry instanceof AtomicEntryFixedSet) {
				Set<URI> sourceElements = null;
				if (sourceAtomicEntry instanceof AtomicEntryFixedSet) {
					sourceElements = ((AtomicEntryFixedSet) sourceAtomicEntry).getElements();
				}

				// fixed sets are inclusive, so destructively update the target elements by possibly removing elements
				Set<URI> targetElements = ((AtomicEntryFixedSet) targetAtomicEntry).getElements();

				if (sourceElements != null) {
					// case where the source entry also has fixed elements
					for (Iterator<URI> iterator = targetElements.iterator(); iterator.hasNext();) {
						URI element = iterator.next();
						if (sourceElements != null) {
							if (!sourceElements.contains(element)) {
								iterator.remove();
							}
						}
					}
				} else {
					// case where the source entry has no fixed elements.
					for (Iterator<URI> iterator = targetElements.iterator(); iterator.hasNext();) {
						URI element = iterator.next();

						URI priOfElement = element.trimFragment();
						//                        CRI criOfElement = priOfElement.getCri( );

						// if source scope does not include the element, it should be removed        
						if (sourceAtomicEntry.isScopeInclusive()) {
							// for an inclusive scope
							//                            if ( !( sourceAtomicEntry.getScope( ).contains( priOfElement ) || sourceAtomicEntry.getContainerScope( ).contains( criOfElement ) ) ) {
							if (!(sourceAtomicEntry.getScope().contains(priOfElement))) {
								iterator.remove();
							}
						} else {
							// for an exclusive scope
							//                            if ( sourceAtomicEntry.getScope( ).contains( priOfElement ) || sourceAtomicEntry.getContainerScope( ).contains( criOfElement ) ) {
							if (sourceAtomicEntry.getScope().contains(priOfElement)) {
								iterator.remove();
							}
						}
					}
				}

			} else if (sourceAtomicEntry instanceof AtomicEntryFixedSet) {
				throw new BugException(BugMessages.SOURCE_AE_FIXED_BUT_NOT_TARGET_AE);

			} else {
				// in this case, we have to intersect the scopes and assign them to the target entry
				boolean sourceIncluded = sourceAtomicEntry.isScopeInclusive();
				boolean targetIncluded = targetAtomicEntry.isScopeInclusive();
				Set<URI> newPriScope = this.intersectScopes(sourceAtomicEntry.getScope(), sourceIncluded, targetAtomicEntry.getScope(),
						targetIncluded);
				Set<URI> newCriScope = this.intersectScopes(sourceAtomicEntry.getContainerScope(), sourceIncluded, targetAtomicEntry
						.getContainerScope(), targetIncluded);
				targetAtomicEntry.setScope(newPriScope, newCriScope, sourceIncluded || targetIncluded);
			}

			// (3) merge the where-clauses. Simply done by adding an and-clause between the original clauses if they exist
			WhereClause sourceWhereClause = sourceAtomicEntry.getWhereClause();
			WhereClause targetWhereClause = targetAtomicEntry.getWhereClause();

			if (targetWhereClause == null) {
				targetAtomicEntry.setWhereClause(sourceWhereClause);
			} else if (sourceWhereClause != null) {
				List<WhereClause> nestedClauses = new ArrayList<WhereClause>(2);
				nestedClauses.add(sourceWhereClause);
				nestedClauses.add(targetWhereClause);
				targetAtomicEntry.setWhereClause(new NaryWhereClause(targetAtomicEntry, false, nestedClauses));
			}
		} else {
			// if the two atomic entries are not compatible, we set the target atomic entry as a the source atomic entry
			// but with an empty scope, because it means that no results can be produced
			targetAtomicEntry.setClassMRIs(sourceAtomicEntry.getClassMRIs());
			targetAtomicEntry.setClassNames(sourceAtomicEntry.getClassNames());
			targetAtomicEntry.setReflectElement(sourceAtomicEntry.isReflectElement());
			targetAtomicEntry.setWhereClause(sourceAtomicEntry.getWhereClause());
			targetAtomicEntry.setScope(null, null, true);
		}
	}

	/**
	 * Calculates the intersection or union between two sets and their inclusion properties (non-destructively). Note that the including
	 * property of the intersection is given by leftIncluding || rightIncluding (to be set by the caller) and the including property of the
	 * union is given by leftIncluding && rightIncluding (to be set by the caller).
	 */
	private <E> Set<E> combineSets(boolean intersect, Set<E> leftSet, boolean leftIncluding, Set<E> rightSet, boolean rightIncluding) {

		Set<E> newScope = new HashSet<E>();

		// make sure the left and right scopes are made as sets
		leftSet = (leftSet == null ? new HashSet<E>() : leftSet);
		rightSet = (rightSet == null ? new HashSet<E>() : rightSet);

		// make a case analysis for the 4 inclusion cases
		if (leftIncluding && rightIncluding) {
			if (intersect) {
				// true intersection
				for (E leftScopeEl : leftSet) {
					if (rightSet.contains(leftScopeEl)) {
						newScope.add(leftScopeEl);
					}
				}
			} else {
				// true union
				newScope.addAll(leftSet);
				newScope.addAll(rightSet);
			}

		} else if (!leftIncluding && !rightIncluding) {
			if (intersect) {
				// true union
				newScope.addAll(leftSet);
				newScope.addAll(rightSet);
			} else {
				// true intersection
				for (E leftScopeEl : leftSet) {
					if (rightSet.contains(leftScopeEl)) {
						newScope.add(leftScopeEl);
					}
				}
			}

		} else if (leftIncluding && !rightIncluding) {
			if (intersect) {
				// fill the result with the left set
				newScope.addAll(leftSet);
				// take out the rest
				newScope.removeAll(rightSet);
			} else {
				// fill the result with the rigth set
				newScope.addAll(rightSet);
				// take out the rest
				newScope.removeAll(leftSet);
			}

		} else if (rightIncluding && !leftIncluding) {
			if (intersect) {
				// fill the result with the right set
				newScope.addAll(rightSet);
				// take out the rest
				newScope.removeAll(leftSet);
			} else {
				// fill the result with the left set
				newScope.addAll(leftSet);
				// take out the rest
				newScope.removeAll(rightSet);
			}
		}

		// return the result
		return newScope;
	}

	/* ------------- */
	/* Deep copier */
	/* ------------- */

	/**
	 * This method produces an identical internal query copy. The maps are required to hook up the pointers appropriately for the
	 * <b>shared</b> types in IQF
	 */
	private InternalQuery deepCopyInternalQuery(InternalQuery internalQuery, Map<SelectEntry, SelectEntry> selectEntryMap,
			Map<AtomicEntry, AtomicEntry> atomicEntryMap, Map<NestedQuery, NestedQuery> nestedQueryMap, boolean includeNestedQueries) {

		InternalQuery resultQuery = null;
		AliasName newAliasName = new AliasName(internalQuery.getAliasName());

		if (internalQuery instanceof ResultUnion) {
			ResultUnion resultUnion = (ResultUnion) internalQuery;
			List<InternalQuery> operands = resultUnion.getOperands();

			// copy
			List<InternalQuery> newOperands = new ArrayList<InternalQuery>(operands.size());
			for (InternalQuery operand : operands) {
				newOperands.add(this.deepCopyInternalQuery(operand, selectEntryMap, atomicEntryMap, nestedQueryMap, includeNestedQueries));
			}

			resultQuery = new ResultUnion(newAliasName, newOperands);

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;
			InternalQuery firstFromEntry = nodeQuery.getFirstFromEntry();
			InternalQuery secondFromEntry = nodeQuery.getSecondFromEntry();
			List<ComparisonWithEntry> withEntries = nodeQuery.getWithEntries();
			List<NodeSelectEntry> selectEntries = nodeQuery.getSelectEntries();

			// copy
			InternalQuery newFirstFromEntry = this.deepCopyInternalQuery(firstFromEntry, selectEntryMap, atomicEntryMap, nestedQueryMap,
					includeNestedQueries);
			InternalQuery newSecondFromEntry = this.deepCopyInternalQuery(secondFromEntry, selectEntryMap, atomicEntryMap, nestedQueryMap,
					includeNestedQueries);

			List<ComparisonWithEntry> newWithEntries = new ArrayList<ComparisonWithEntry>(withEntries.size());
			for (ComparisonWithEntry withEntry : withEntries) {
				newWithEntries.add(this.deepCopyComparisonWithEntry(withEntry, selectEntryMap, atomicEntryMap));
			}

			List<NodeSelectEntry> newSelectEntries = new ArrayList<NodeSelectEntry>(selectEntries.size());
			for (NodeSelectEntry selectEntry : selectEntries) {
				newSelectEntries.add((NodeSelectEntry) this.deepCopySelectEntry(selectEntry, selectEntryMap, atomicEntryMap));
			}

			resultQuery = NodeQuery.construct(newAliasName, newFirstFromEntry, newSecondFromEntry, newWithEntries, newSelectEntries);

		} else if (internalQuery instanceof LeafQuery) {
			LeafQuery leafQuery = (LeafQuery) internalQuery;
			SpiFacilityQueryLanguage bqProcessor = leafQuery.getFqlProcessor();
			List<AtomicEntry> fromEntries = leafQuery.getFromEntries();
			List<LeafSelectEntry> selectEntries = leafQuery.getSelectEntries();
			List<WithEntry> withEntries = leafQuery.getWithEntries();

			// copy
			List<AtomicEntry> newFromEntries = new ArrayList<AtomicEntry>(fromEntries.size());
			for (AtomicEntry fromEntry : fromEntries) {
				newFromEntries.add(this.deepCopyAtomicEntry(fromEntry, atomicEntryMap));
			}

			List<LeafSelectEntry> newSelectEntries = new ArrayList<LeafSelectEntry>(selectEntries.size());
			for (LeafSelectEntry selectEntry : selectEntries) {
				newSelectEntries.add((LeafSelectEntry) this.deepCopySelectEntry(selectEntry, selectEntryMap, atomicEntryMap));
			}

			List<WithEntry> newWithEntries = new ArrayList<WithEntry>(withEntries.size());
			for (WithEntry withEntry : withEntries) {
				newWithEntries.add(this.deepCopyWithEntry(withEntry, selectEntryMap, atomicEntryMap, nestedQueryMap, includeNestedQueries));
			}

			resultQuery = LeafQuery.construct(newAliasName, newFromEntries, newWithEntries, newSelectEntries, bqProcessor);

		} else if (internalQuery instanceof EmptyQuery) {
			EmptyQuery emptyQuery = (EmptyQuery) internalQuery;
			List<SelectEntry> selectEntries = emptyQuery.getSelectEntries();

			// copy
			List<SelectEntry> newSelectEntries = new ArrayList<SelectEntry>(selectEntries.size());

			for (SelectEntry selectEntry : selectEntries) {
				newSelectEntries.add(this.deepCopySelectEntry(selectEntry, selectEntryMap, atomicEntryMap));
			}

			resultQuery = new EmptyQuery(newAliasName, newSelectEntries);

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName() + "InternalQuery"); //$NON-NLS-1$
		}

		return resultQuery;
	}

	private ComparisonWithEntry deepCopyComparisonWithEntry(ComparisonWithEntry comparisonWithEntry,
			Map<SelectEntry, SelectEntry> selectEntryMap, Map<AtomicEntry, AtomicEntry> atomicEntryMap) {

		ComparisonWithEntry comparisonWithEntryResult = null;

		if (comparisonWithEntry instanceof TypeComparison) {
			TypeComparison typeComparison = (TypeComparison) comparisonWithEntry;
			TypeReference leftTypeRef = typeComparison.getLeftType();
			TypeReference rightTypeRef = typeComparison.getRightType();

			// copy left
			TypeReference newLeftTypeRef = null;
			if (leftTypeRef instanceof AtomicEntryReference) {
				newLeftTypeRef = this.deepCopyAtomicEntryReference((AtomicEntryReference) leftTypeRef, atomicEntryMap);
			} else if (leftTypeRef instanceof VirtualAtomicEntryReference) {
				newLeftTypeRef = this.deepCopyVirtualAtomicEntryReference((VirtualAtomicEntryReference) leftTypeRef, selectEntryMap,
						atomicEntryMap);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, leftTypeRef.getClass().getCanonicalName(), "TypeReference"); //$NON-NLS-1$
			}

			// copy right
			TypeReference newRightTypeRef = null;
			if (rightTypeRef instanceof AtomicEntryReference) {
				newRightTypeRef = this.deepCopyAtomicEntryReference((AtomicEntryReference) rightTypeRef, atomicEntryMap);
			} else if (leftTypeRef instanceof VirtualAtomicEntryReference) {
				newRightTypeRef = this.deepCopyVirtualAtomicEntryReference((VirtualAtomicEntryReference) rightTypeRef, selectEntryMap,
						atomicEntryMap);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, rightTypeRef.getClass().getCanonicalName(), "TypeReference"); //$NON-NLS-1$
			}

			comparisonWithEntryResult = new TypeComparison(newLeftTypeRef, newRightTypeRef);

		} else if (comparisonWithEntry instanceof AttrComparison) {
			AttrComparison attrComparison = (AttrComparison) comparisonWithEntry;
			TypeAttrReference leftTypeAttrRef = attrComparison.getLeftAttr();
			TypeAttrReference rightTypeAttrRef = attrComparison.getRightAttr();
			SpiFqlComparisonOperation operation = attrComparison.getOperation();

			// copy left
			TypeAttrReference newLeftTypeAttrRef = null;
			if (leftTypeAttrRef instanceof AtomicAttrReference) {
				newLeftTypeAttrRef = (AtomicAttrReference) this.deepCopyAtomicEntryReference((AtomicAttrReference) leftTypeAttrRef,
						atomicEntryMap);
			} else if (leftTypeAttrRef instanceof VirtualAtomicAttrReference) {
				newLeftTypeAttrRef = (VirtualAtomicAttrReference) this.deepCopyVirtualAtomicEntryReference(
						(VirtualAtomicAttrReference) leftTypeAttrRef, selectEntryMap, atomicEntryMap);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, leftTypeAttrRef.getClass().getCanonicalName(), "TypeAttrReference"); //$NON-NLS-1$
			}

			// copy right
			TypeAttrReference newRightTypeAttrRef = null;
			if (rightTypeAttrRef instanceof AtomicAttrReference) {
				newRightTypeAttrRef = (AtomicAttrReference) this.deepCopyAtomicEntryReference((AtomicAttrReference) rightTypeAttrRef,
						atomicEntryMap);
			} else if (rightTypeAttrRef instanceof VirtualAtomicAttrReference) {
				newRightTypeAttrRef = (VirtualAtomicAttrReference) this.deepCopyVirtualAtomicEntryReference(
						(VirtualAtomicAttrReference) rightTypeAttrRef, selectEntryMap, atomicEntryMap);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, rightTypeAttrRef.getClass().getCanonicalName(), "TypeAttrReference"); //$NON-NLS-1$
			}

			comparisonWithEntryResult = new AttrComparison(operation, newLeftTypeAttrRef, newRightTypeAttrRef);

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, comparisonWithEntry.getClass().getCanonicalName(), "ComparisonWithEntry"); //$NON-NLS-1$
		}

		return comparisonWithEntryResult;
	}

	private WithEntry deepCopyWithEntry(WithEntry withEntry, Map<SelectEntry, SelectEntry> selectEntryMap,
			Map<AtomicEntry, AtomicEntry> atomicEntryMap, Map<NestedQuery, NestedQuery> nestedQueryMap, boolean includeNestedQueries) {

		WithEntry withEntryResult = null;

		if (withEntry instanceof ComparisonWithEntry) {
			withEntryResult = this.deepCopyComparisonWithEntry((ComparisonWithEntry) withEntry, selectEntryMap, atomicEntryMap);

		} else if (withEntry instanceof AssocPredicate) {
			AssocPredicate assocPredicate = (AssocPredicate) withEntry;
			URI assocMRI = assocPredicate.getAssocMRI();
			//            SpiFqlAssociationCategory assocCategory = assocPredicate.getAssocCategory( );
			//            int leftAssocEnd = assocPredicate.getFromAssocEnd( );
			//            int rightAssocEnd = assocPredicate.getToAssocEnd( );
			String assocName = assocPredicate.getAssocName();
			//            String leftAssocEndName = assocPredicate.getFromAssocEndName( );
			//            String rightAssocEndName = assocPredicate.getToAssocEndName( );
			//            boolean leftStored = assocPredicate.hasStorageAtFromEnd( );
			//            boolean rightStored = assocPredicate.hasStorageAtToEnd( );
			AtomicEntryReference leftType = assocPredicate.getFromType();
			AtomicEntryReference rightType = assocPredicate.getToType();

			// copy
			AtomicEntryReference newLeftType = this.deepCopyAtomicEntryReference(leftType, atomicEntryMap);
			AtomicEntryReference newRightType = this.deepCopyAtomicEntryReference(rightType, atomicEntryMap);

			withEntryResult = new AssocPredicate(assocMRI, assocName, newLeftType, newRightType);

		} else if (withEntry instanceof LinksPredicate) {
			LinksPredicate linksPredicate = (LinksPredicate) withEntry;
			boolean not = linksPredicate.isNegated();
			URI assocMRI = linksPredicate.getAssocMRI();
			//            SpiFqlAssociationCategory assocCategory = linksPredicate.getAssocCategory( );
			//            int assocEnd = linksPredicate.getToAssocEnd( );
			//            int leftAssocEnd = linksPredicate.getFromAssocEnd( );
			String assocName = linksPredicate.getAssocName();
			//            String assocEndName = linksPredicate.getToAssocEndName( );
			//            String leftAssocEndName = linksPredicate.getFromAssocEndName( );
			//            boolean stored = linksPredicate.hasStorageAtToEnd( );
			//            boolean linkedToStored = linksPredicate.hasStorageAtFromEnd( );
			AtomicEntryReference linkedTo = linksPredicate.getFromType();
			NestedQuery nestedQuery = linksPredicate.getNestedQuery();

			NestedQuery newNestedQuery = nestedQuery;
			if (includeNestedQueries) {
				// only if wanted, we actually look into cloning the nested query

				newNestedQuery = nestedQueryMap.get(nestedQuery);

				// we only do it if not done before (reusing the old one if already done)
				if (newNestedQuery == null) {
					// construct new nested query
					InternalQuery newInternalQuery = this.deepCopyInternalQuery(nestedQuery.getInternalQuery(),
							new HashMap<SelectEntry, SelectEntry>(), new HashMap<AtomicEntry, AtomicEntry>(), nestedQueryMap,
							includeNestedQueries);
					newNestedQuery = new NestedQuery(newInternalQuery);

					// copy the result set
					newNestedQuery.setResultSet(nestedQuery.getResultSet());
					// copy the reset value
					newNestedQuery.setReset(nestedQuery.isReset());

					nestedQueryMap.put(nestedQuery, newNestedQuery);
				}
			}

			AtomicEntryReference newLinkedTo = this.deepCopyAtomicEntryReference(linkedTo, atomicEntryMap);

			LinksPredicate newLinksPredicate = new LinksPredicate(not, assocMRI, assocName, newLinkedTo, newNestedQuery.getInternalQuery());

			// CAREFUL: we want the to exactly set the newNestedQuery in case it is the old nested query. 
			newLinksPredicate.setNestedQuery(newNestedQuery);

			withEntryResult = newLinksPredicate;

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, withEntry.getClass().getCanonicalName(), "JoinWhereEntry"); //$NON-NLS-1$
		}

		return withEntryResult;
	}

	private AtomicEntryReference deepCopyAtomicEntryReference(AtomicEntryReference atomicEntryReference,
			Map<AtomicEntry, AtomicEntry> atomicEntryMap) {

		AtomicEntryReference atomicEntryReferenceResult = null;
		AtomicEntry newAtomicEntry = this.deepCopyAtomicEntry(atomicEntryReference.getAtomicEntry(), atomicEntryMap);

		if (atomicEntryReference instanceof AtomicAttrReference) {
			AtomicAttrReference atomicAttrRef = (AtomicAttrReference) atomicEntryReference;
			String attrName = atomicAttrRef.getAttrName();
			boolean multivalued = atomicAttrRef.isMultiValued();
			boolean isordered = atomicAttrRef.isOrdered();
			boolean isunique = atomicAttrRef.isUnique();
			SpiFqlPrimitiveType attrType = atomicAttrRef.getAttrType();

			// copy
			atomicEntryReferenceResult = new AtomicAttrReference(newAtomicEntry, attrName, attrType, multivalued, isordered, isunique);

		} else {
			atomicEntryReferenceResult = new AtomicEntryReference(newAtomicEntry);
		}

		return atomicEntryReferenceResult;
	}

	private VirtualAtomicEntryReference deepCopyVirtualAtomicEntryReference(VirtualAtomicEntryReference virtualAtomicEntryReference,
			Map<SelectEntry, SelectEntry> selectEntryMap, Map<AtomicEntry, AtomicEntry> atomicEntryMap) {

		SelectEntry newSelectEntry = this.deepCopySelectEntry(virtualAtomicEntryReference.getNestedSelectEntry(), selectEntryMap,
				atomicEntryMap);

		return this.constructVirtualIndirection(newSelectEntry);
	}

	private SelectEntry deepCopySelectEntry(SelectEntry selectEntry, Map<SelectEntry, SelectEntry> selectEntryMap,
			Map<AtomicEntry, AtomicEntry> atomicEntryMap) {

		SelectEntry resultSelectEntry = selectEntryMap.get(selectEntry);

		// only copy if not already copied
		if (resultSelectEntry == null) {

			if (selectEntry instanceof NodeSelectEntry) {
				VirtualAtomicEntryReference newVirtualAtomicEntryReference = this.deepCopyVirtualAtomicEntryReference(
						((NodeSelectEntry) selectEntry).getVirtualAtomicEntryReference(), selectEntryMap, atomicEntryMap);
				resultSelectEntry = new NodeSelectEntry(newVirtualAtomicEntryReference);

			} else if (selectEntry instanceof LeafSelectEntry) {
				AtomicEntryReference newAtomicEntryReference = this.deepCopyAtomicEntryReference(((LeafSelectEntry) selectEntry)
						.getAtomicEntryReference(), atomicEntryMap);
				resultSelectEntry = new LeafSelectEntry(newAtomicEntryReference);
				((LeafSelectEntry) resultSelectEntry).setOriginalUserDefinedName(((LeafSelectEntry) selectEntry)
						.getOriginalUserDefinedName());

			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, selectEntry.getClass().getCanonicalName(), "SelectEntry"); //$NON-NLS-1$
			}

			// maintain map
			selectEntryMap.put(selectEntry, resultSelectEntry);
		}

		return resultSelectEntry;
	}

	@SuppressWarnings("unchecked")
	private AtomicEntry deepCopyAtomicEntry(AtomicEntry atomicEntry, Map<AtomicEntry, AtomicEntry> atomicEntryMap) {

		AtomicEntry resultAtomicEntry = atomicEntryMap.get(atomicEntry);

		// only copy if not already copied
		if (resultAtomicEntry == null) {

			List<URI> classMRIs = atomicEntry.getClassMRIs();
			SpiFqlFromTypeCategory modelElementCategory = atomicEntry.getTypeCategory();
			Set<URI> scope = atomicEntry.getScope();
			Set<URI> containedScope = atomicEntry.getContainerScope();
			AliasName aliasName = atomicEntry.getAliasName();
			boolean including = atomicEntry.isScopeInclusive();
			List<String> classNames = atomicEntry.getClassNames();
			boolean isReflectElement = atomicEntry.isReflectElement();

			// copy
			List<URI> newClassMRIs = (List<URI>) ((ArrayList<URI>) classMRIs).clone();

			Set<URI> newScope = null;
			if (scope != null) {
				newScope = (Set<URI>) ((HashSet<URI>) scope).clone();
			}

			Set<URI> newContainedScope = null;
			if (containedScope != null) {
				newContainedScope = (Set<URI>) ((HashSet<URI>) containedScope).clone();
			}

			List<String> newClassNames = new ArrayList<String>(classNames.size());
			newClassNames.addAll(classNames);

			// construction depends on whether it is a fixed set
			if (atomicEntry instanceof AtomicEntryFixedSet) {
				Set<URI> elements = ((AtomicEntryFixedSet) atomicEntry).getElements();
				resultAtomicEntry = AtomicEntryFixedSet.newAtomicEntryFixedSetWithClonedElements(new AliasName(aliasName), newClassMRIs,
						newClassNames, elements, isReflectElement, scope, containedScope, including);
			} else {
				resultAtomicEntry = new AtomicEntry(new AliasName(aliasName), newClassMRIs, newClassNames, modelElementCategory,
						isReflectElement, newScope, newContainedScope, including);
			}

			WhereClause newWhereClause = this.deepCopyWhereClause(resultAtomicEntry, atomicEntry.getWhereClause());
			resultAtomicEntry.setWhereClause(newWhereClause);

			// maintain map
			atomicEntryMap.put(atomicEntry, resultAtomicEntry);
		}

		return resultAtomicEntry;
	}

	private WhereClause deepCopyWhereClause(AtomicEntry atomicEntry, WhereClause whereClause) {

		WhereClause whereClauseResult = null;

		if (whereClause == null) {
			// do nothing and stop
		} else if (whereClause instanceof NaryWhereClause) {
			NaryWhereClause naryWhereClause = (NaryWhereClause) whereClause;
			List<WhereClause> nestedClauses = naryWhereClause.getNestedClauses();
			boolean withOr = naryWhereClause.isOrConnected();

			// copy

			List<WhereClause> newNestedClauses = new ArrayList<WhereClause>(nestedClauses.size());
			for (WhereClause clause : nestedClauses) {
				newNestedClauses.add(this.deepCopyWhereClause(atomicEntry, clause));
			}

			whereClauseResult = new NaryWhereClause(atomicEntry, withOr, newNestedClauses);

		} else if (whereClause instanceof LikeComparison) {
			LikeComparison likeComparison = (LikeComparison) whereClause;
			String attrName = likeComparison.getAttrName();
			String stringPattern = likeComparison.getLikePattern();
			boolean not = likeComparison.isNegated();

			// copy
			whereClauseResult = new LikeComparison(atomicEntry, attrName, not, stringPattern);

		} else if (whereClause instanceof NumericComparison) {
			NumericComparison numericComparison = (NumericComparison) whereClause;
			String attrName = numericComparison.getAttrName();
			SpiFqlPrimitiveType attrType = numericComparison.getAttrType();
			boolean multivalued = numericComparison.isMultiValued();
			SpiFqlComparisonOperation operation = numericComparison.getOperation();
			Object operand = numericComparison.getOperandValue();

			// copy
			whereClauseResult = new NumericComparison(atomicEntry, attrName, attrType, multivalued, operation, operand);

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, whereClause.getClass().getCanonicalName(), "WhereClause"); //$NON-NLS-1$
		}

		return whereClauseResult;
	}

	/* ---------------------- */
	/* Removing empty parts */
	/* ---------------------- */

	@SuppressWarnings("unchecked")
	private InternalQuery removeEmptyPartsForInternalQuery(InternalQuery internalQuery, Set<NestedQuery> seenNestedQuery,
			Map<SelectEntry, SelectEntry> selectEntryMap) {

		// by default, we assume no change in the result
		InternalQuery resultQuery = internalQuery;

		// case analysis
		if (internalQuery instanceof EmptyQuery) {
			// nothing to do

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;
			InternalQuery firstFromEntry = nodeQuery.getFirstFromEntry();
			InternalQuery secondFromEntry = nodeQuery.getSecondFromEntry();

			// we handle the two from-entries and check if any of the nested queries is empty
			boolean nestedEmpty = false;

			// the first from entry
			InternalQuery newFirstFromEntry = this.removeEmptyPartsForInternalQuery(firstFromEntry, seenNestedQuery, selectEntryMap);
			nestedEmpty = newFirstFromEntry instanceof EmptyQuery;

			// the second from entry
			InternalQuery newSecondFromEntry = null;
			if (!nestedEmpty) {
				// only continue if the first entry was not already empty (in which case the entire query is empty)
				newSecondFromEntry = this.removeEmptyPartsForInternalQuery(secondFromEntry, seenNestedQuery, selectEntryMap);
				nestedEmpty = newSecondFromEntry instanceof EmptyQuery;
			}

			// we turn the query into an empty query if we have at least one empty part
			if (nestedEmpty) {
				resultQuery = new EmptyQuery(nodeQuery.getAliasName(), (List) nodeQuery.getSelectEntries());
			} else {
				// otherwise, we simply add the new version of the nested queries
				nodeQuery.setFirstFromEntry(newFirstFromEntry);
				nodeQuery.setSecondFromEntry(newSecondFromEntry);

				// We use the redirection map to make sure that all type references to different parts of the node query
				// are rerouted if used to refer to a part of a union which disappeared
				this.redirectTypeReferencesForNodeQueries(nodeQuery.getSelectEntries(), nodeQuery.getWithEntries(), selectEntryMap);
			}

		} else if (internalQuery instanceof ResultUnion) {
			// unions are more tricky because if the first sub-query is empty (and thus disappears), we have to update
			// the redirection map

			ResultUnion resultUnion = (ResultUnion) internalQuery;
			List<InternalQuery> operands = resultUnion.getOperands();

			// we construct a list of new operands
			List<InternalQuery> newOperands = new ArrayList<InternalQuery>();

			Iterator<InternalQuery> iterator = operands.iterator();

			// first recursive handle the first operand
			InternalQuery firstOperand = iterator.next();
			InternalQuery newFirstOperand = this.removeEmptyPartsForInternalQuery(firstOperand, seenNestedQuery, selectEntryMap);

			// if the first operands disappears we have extra book-keeping to do
			List<SelectEntry> disappearingSelectEntries = null;

			// add in right list
			if (newFirstOperand instanceof EmptyQuery) {
				// keep the list of select entries in order to update the redirectionMap to a remaining operand
				disappearingSelectEntries = ((EmptyQuery) newFirstOperand).getSelectEntries();
				// remove the empty query
				iterator.remove();
			} else {
				newOperands.add(newFirstOperand);
			}

			// do the remaining operands
			for (; iterator.hasNext();) {
				InternalQuery newOperand = this.removeEmptyPartsForInternalQuery(iterator.next(), seenNestedQuery, selectEntryMap);

				// add in right list
				if (newOperand instanceof EmptyQuery) {
					iterator.remove();
				} else {
					newOperands.add(newOperand);
				}
			}

			if (newOperands.size() == 0) {
				// if no operand is left, construct the empty query with the disappearing first select entries which are definitely not null then!
				resultQuery = new EmptyQuery(resultUnion.getAliasName(), disappearingSelectEntries);
			} else if (newOperands.size() == 1) {
				// if one operand is left, we keep it as the result
				resultQuery = newOperands.get(0);
			} else {
				// otherwise construct a new union
				resultQuery = new ResultUnion(resultUnion.getAliasName(), newOperands);
			}

			// we have to update redirection is there were disappearing first select entries
			if (disappearingSelectEntries != null) {
				this.updateSelectEntryMap(disappearingSelectEntries, this.calculateSelectEntriesFromInternalQuery(resultQuery),
						selectEntryMap);
			}

		} else if (internalQuery instanceof LeafQuery) {
			LeafQuery leafQuery = (LeafQuery) internalQuery;
			List<AtomicEntry> fromEntries = leafQuery.getFromEntries();

			// assume not empty until proven otherwise
			boolean empty = false;

			// work recursively over link predicates (unless the query is already empty)
			for (Iterator<WithEntry> iterator = leafQuery.getWithEntries().iterator(); !empty && iterator.hasNext();) {
				WithEntry withEntry = iterator.next();

				if (withEntry instanceof LinksPredicate) {
					LinksPredicate linksPredicate = (LinksPredicate) withEntry;

					NestedQuery nestedQuery = linksPredicate.getNestedQuery();

					// only if not handled before
					if (seenNestedQuery.add(nestedQuery)) {
						InternalQuery newNestedInternalQuery = this.removeEmptyPartsForInternalQuery(nestedQuery.getInternalQuery(),
								seenNestedQuery, selectEntryMap);

						// if this query is empty now, we can simplify
						if (newNestedInternalQuery instanceof EmptyQuery) {
							// if the linksPredicate is a negation, this predicate is useless and can be removed
							if (linksPredicate.isNegated()) {
								iterator.remove();
							} else {
								// otherwise, the predicate can never be fulfilled and the entire query is emptied
								empty = true;
							}
						} else {
							// in all other cases, we just rewire
							nestedQuery.setInternalQuery(newNestedInternalQuery);
						}
					}
				}
			}

			// walk over from-entries and check if scope is empty with inclusion
			// or has a fixed set which is empty
			for (Iterator<AtomicEntry> iter = fromEntries.iterator(); !empty && iter.hasNext();) {
				AtomicEntry atomicEntry = iter.next();
				Set<URI> scope = atomicEntry.getScope();
				Set<URI> containedScope = atomicEntry.getContainerScope();
				boolean including = atomicEntry.isScopeInclusive();

				// we calculate the boolean as follows
				empty = including && (scope == null || scope.size() == 0) && (containedScope == null || containedScope.size() == 0);

				// if we have FixedSet, check if it is empty as well
				if (!empty && (atomicEntry instanceof AtomicEntryFixedSet)) {
					Set<URI> elements = ((AtomicEntryFixedSet) atomicEntry).getElements();
					empty = (elements == null || elements.size() == 0);
				}
			}

			// if empty scope or empty fixed set found, we have an empty query
			if (empty) {
				resultQuery = new EmptyQuery(leafQuery.getAliasName(), (List) leafQuery.getSelectEntries());
			}

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		return resultQuery;
	}

	/**
	 * Updates the select entry map with old-to-new entries
	 */
	private void updateSelectEntryMap(List<SelectEntry> oldSelectEntries, List<SelectEntry> newSelectEntries,
			Map<SelectEntry, SelectEntry> selectEntryMap) {

		Iterator<SelectEntry> iterNewSelectEntries = newSelectEntries.iterator();
		Iterator<SelectEntry> iterOldSelectEntries = oldSelectEntries.iterator();
		for (; iterNewSelectEntries.hasNext();) {
			if (iterOldSelectEntries.hasNext()) {
				selectEntryMap.put(iterOldSelectEntries.next(), iterNewSelectEntries.next());
			} else {
				throw new BugException(BugMessages.MISSALIGNED_EMPTY_QUERY_IN_UNION);
			}
		}
	}

	/**
	 * Simply redirects the contained select entries of the virtualAtomicEntryReference in the provided nodeSelectEntries and
	 * comparisonWithEntries
	 */
	private void redirectTypeReferencesForNodeQueries(List<NodeSelectEntry> selectEntries, List<ComparisonWithEntry> withEntries,
			Map<SelectEntry, SelectEntry> selectEntryMap) {

		// first redirect the selectEntries
		for (NodeSelectEntry selectEntry : selectEntries) {
			VirtualAtomicEntryReference virtualAer = selectEntry.getVirtualAtomicEntryReference();
			this.resetVirtualEntry(virtualAer, selectEntryMap);
		}

		// then the Comparison With Entries
		for (ComparisonWithEntry withEntry : withEntries) {
			TypeReference leftTypeRef = withEntry.getLeftTypeReference();
			TypeReference rightTypeRef = withEntry.getRightTypeReference();

			// these have to be virtual ones (bug otherwise)

			// left one
			if (leftTypeRef instanceof VirtualAtomicEntryReference) {
				VirtualAtomicEntryReference leftVirtualAer = (VirtualAtomicEntryReference) leftTypeRef;
				this.resetVirtualEntry(leftVirtualAer, selectEntryMap);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_NON_VIRTUAL_REF_REFERRING_SELECT_ENTRY);
			}

			// right one
			if (rightTypeRef instanceof VirtualAtomicEntryReference) {
				VirtualAtomicEntryReference rightVirtualAer = (VirtualAtomicEntryReference) rightTypeRef;
				this.resetVirtualEntry(rightVirtualAer, selectEntryMap);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_NON_VIRTUAL_REF_REFERRING_SELECT_ENTRY);
			}
		}
	}

	/**
	 * Simply rewires the virtual atomic entry if the selectEntryMap has a matching selectEntry. Otherwise, this is a noop
	 */
	private void resetVirtualEntry(VirtualAtomicEntryReference virtualAer, Map<SelectEntry, SelectEntry> selectEntryMap) {

		// check the map
		SelectEntry mappedSelectEntry = selectEntryMap.get(virtualAer.getNestedSelectEntry());

		// we only have to rewire this if it is in the map at all
		if (mappedSelectEntry != null) {
			// rewire the select entry
			virtualAer.setNestedSelectEntry(mappedSelectEntry);
		}
	}

	/**
	 * Recursively searches for the outermost select entry list
	 */
	private List<SelectEntry> calculateSelectEntriesFromInternalQuery(InternalQuery internalQuery) {

		// for the result
		List<SelectEntry> selectEntries = null;

		// simple case analysis
		if (internalQuery instanceof LeafQuery) {
			// get the select entries
			List<LeafSelectEntry> oldList = ((LeafQuery) internalQuery).getSelectEntries();
			selectEntries = new ArrayList<SelectEntry>(oldList.size());
			selectEntries.addAll(oldList);

		} else if (internalQuery instanceof NodeQuery) {
			// get the select entries
			List<NodeSelectEntry> oldList = ((NodeQuery) internalQuery).getSelectEntries();
			selectEntries = new ArrayList<SelectEntry>(oldList.size());
			selectEntries.addAll(oldList);

		} else if (internalQuery instanceof EmptyQuery) {
			selectEntries = ((EmptyQuery) internalQuery).getSelectEntries();

		} else if (internalQuery instanceof ResultUnion) {
			// work recursively on the first operand
			selectEntries = this.calculateSelectEntriesFromInternalQuery(((ResultUnion) internalQuery).getOperands().get(0));

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		// return result
		return selectEntries;
	}

	/* -------------------------------- */
	/* Adjusting structure type scope */
	/* -------------------------------- */

	/**
	 * Adjusts the structure type scope of the internal query, by setting each to the union of the scopes of the class-typed atomic entry to
	 * which they are "connected" (directly or indirectly).
	 */
	private void adjustStructureTypeScopeInternalQuery(InternalQuery internalQuery) {

		// first build a map which contains for each atomic entry all assocPredicate edges (with the atomic entry on
		// the left-hand side) but only if right-hand side is a definitely structure type.
		Map<AtomicEntry, Set<AtomicEntry>> structureEdgeMap = new HashMap<AtomicEntry, Set<AtomicEntry>>();

		// for avoiding duplicate calculations of shared nested queries
		Set<NestedQuery> seenQueries = new HashSet<NestedQuery>();

		// we also keep a set of atomic entries with the pure CLASS-typed
		// atomic entries. Entries in this set have a correct scope already.
		Set<AtomicEntry> classBasedAtomicEntries = new HashSet<AtomicEntry>();

		// this builds up the structureEntryMap and the classBasedAtomicEntries
		this.constructStructureEntryMap(internalQuery, seenQueries, classBasedAtomicEntries, structureEdgeMap);

		// now, for each scoped atomic entry, we propagate its scope to the connected structure types
		for (AtomicEntry atomicEntry : classBasedAtomicEntries) {

			// for each walk, we keep this set to avoid cyclic adapting the scope
			Set<AtomicEntry> seenAtomicEntries = new HashSet<AtomicEntry>();

			// now recursively walk over all connected edges and propagate the scopes by union
			this.walkStructureTypedEdges(atomicEntry, seenAtomicEntries, structureEdgeMap);
		}
	}

	/**
	 * Simple recursively walk over the internal query, which builds the atomicEntryMap and the structureEdgeMap
	 */
	@SuppressWarnings("unchecked")
	private void constructStructureEntryMap(InternalQuery internalQuery, Set<NestedQuery> seenQueries,
			Set<AtomicEntry> classBasedAtomicEntries, Map<AtomicEntry, Set<AtomicEntry>> structureEdgeMap) {

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			// go recursively down
			for (InternalQuery operand : operands) {
				this.constructStructureEntryMap(operand, seenQueries, classBasedAtomicEntries, structureEdgeMap);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			// go recursively down
			this.constructStructureEntryMap(nodeQuery.getFirstFromEntry(), seenQueries, classBasedAtomicEntries, structureEdgeMap);
			this.constructStructureEntryMap(nodeQuery.getSecondFromEntry(), seenQueries, classBasedAtomicEntries, structureEdgeMap);

		} else if (internalQuery instanceof EmptyQuery) {
			// do not do anything

		} else if (internalQuery instanceof LeafQuery) {
			// deal with leaf queries
			LeafQuery leafQuery = (LeafQuery) internalQuery;

			// collect structure atomic entries and give them no connection (to start)
			for (AtomicEntry atomicEntry : leafQuery.getFromEntries()) {
				// construct empty set of edges
				structureEdgeMap.put(atomicEntry, new HashSet<AtomicEntry>());

				switch (atomicEntry.getTypeCategory()) {
				case CLASS:
					// scope is already correct. Put in scopedAtomicEntries
					classBasedAtomicEntries.add(atomicEntry);
					break;
				case STRUCTURETYPE:
					// empty the structure type scope if it was given any
					atomicEntry.setScope(Collections.EMPTY_SET, Collections.EMPTY_SET, true);
					break;
				default:
					throw new BugException(BugMessages.UNKNOWN_ATOMIC_ENTRY_CATEGORY, atomicEntry.getTypeCategory());
				}
			}

			// look for possible nested queries in link predicates. Also get all
			// assocPredicates which involve a structure type and set up the structureEdgeMap
			for (WithEntry withEntry : leafQuery.getWithEntries()) {

				// case analysis
				if (withEntry instanceof LinksPredicate) {
					// for LinksPredicates, we only need to work recursively deeper
					NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

					// but only if not seen before
					if (seenQueries.add(nestedQuery)) {
						this.constructStructureEntryMap(nestedQuery.getInternalQuery(), seenQueries, classBasedAtomicEntries,
								structureEdgeMap);
					}

				} else if (withEntry instanceof AssocPredicate) {
					// these are the with entries of interest
					AssocPredicate assocPredicate = (AssocPredicate) withEntry;

					// get the left and right atomic entry of the predicate
					AtomicEntry leftAtomicEntry = assocPredicate.getFromType().getAtomicEntry();
					AtomicEntry rightAtomicEntry = assocPredicate.getToType().getAtomicEntry();

					// we are only interested in the edges which have at least a structure type involved

					// found structure type on the left
					if (leftAtomicEntry.getTypeCategory().equals(SpiFqlFromTypeCategory.STRUCTURETYPE)) {
						// add this as an edge from right-to-left
						structureEdgeMap.get(rightAtomicEntry).add(leftAtomicEntry);
					}

					// found structure type on the right
					if (rightAtomicEntry.getTypeCategory().equals(SpiFqlFromTypeCategory.STRUCTURETYPE)) {
						// add this as an edge from left-to-right
						structureEdgeMap.get(leftAtomicEntry).add(rightAtomicEntry);
					}
				}
			}

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}
	}

	/**
	 * This recursive function walks over all edges in the structureEdgeMap and unions the scope with whatever scope is already available in
	 * the sourceAtomicEntry. To avoid an infinite walk with cycle in the edgeMap, we also record which structure typed atomic entries we
	 * have already seen.
	 */
	private void walkStructureTypedEdges(AtomicEntry sourceAtomicEntry, Set<AtomicEntry> seenAtomicEntries,
			Map<AtomicEntry, Set<AtomicEntry>> structureEdgeMap) {

		// only deal with it if it was not seen before to avoid cycles
		if (seenAtomicEntries.add(sourceAtomicEntry)) {

			// obtain the connected structure types (this set may be empty)
			Set<AtomicEntry> connectedStructureTypeAtomicEntries = structureEdgeMap.get(sourceAtomicEntry);

			// union the connected scope
			for (AtomicEntry newConnectedStructureTypeAtomicEntry : connectedStructureTypeAtomicEntries) {
				// Unions the scope of the source and target and then replaces it in the target atomic entry

				Set<URI> newAtomicEntryScope = this.unionScopes(sourceAtomicEntry.getScope(), sourceAtomicEntry.isScopeInclusive(),
						newConnectedStructureTypeAtomicEntry.getScope(), newConnectedStructureTypeAtomicEntry.isScopeInclusive());
				Set<URI> newAtomicEntryContainerScope = this.unionScopes(sourceAtomicEntry.getContainerScope(), sourceAtomicEntry
						.isScopeInclusive(), newConnectedStructureTypeAtomicEntry.getContainerScope(), newConnectedStructureTypeAtomicEntry
						.isScopeInclusive());
				newConnectedStructureTypeAtomicEntry.setScope(newAtomicEntryScope, newAtomicEntryContainerScope, sourceAtomicEntry
						.isScopeInclusive()
						&& newConnectedStructureTypeAtomicEntry.isScopeInclusive());

				// work recursively 
				this.walkStructureTypedEdges(newConnectedStructureTypeAtomicEntry, seenAtomicEntries, structureEdgeMap);
			}
		}
	}

	/**
	 * Main type comparison removal function (recursive)
	 */
	private void removeTypeComparisonsForInternalQuery(InternalQuery internalQuery, Set<NestedQuery> seenNestedQuery) {

		// case analysis on the internal query
		if (internalQuery instanceof LeafQuery) {
			this.removeTypeComparisonsForLeafQuery((LeafQuery) internalQuery, seenNestedQuery);

		} else if (internalQuery instanceof NodeQuery) {
			// just go recursively down
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			this.removeTypeComparisonsForInternalQuery(nodeQuery.getFirstFromEntry(), seenNestedQuery);
			this.removeTypeComparisonsForInternalQuery(nodeQuery.getSecondFromEntry(), seenNestedQuery);

		} else if (internalQuery instanceof ResultUnion) {
			// obtain operands ...
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			for (InternalQuery operand : operands) {
				this.removeTypeComparisonsForInternalQuery(operand, seenNestedQuery);
			}

		} else if (internalQuery instanceof EmptyQuery) {
			// nothing to do

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}
	}

	/**
	 * Type comparison removal happens by walking over the type comparisons, constructing a new atomic entry which builds the intersection
	 * entry, removing the type comparison, removing the old atomic entries from the from-entries and finally replacing any references to
	 * the old atomic entry with the new atomic entry
	 */
	private void removeTypeComparisonsForLeafQuery(LeafQuery leafQuery, Set<NestedQuery> seenNestedQuery) {

		// for the new result
		List<WithEntry> withEntries = leafQuery.getWithEntries();
		List<LeafSelectEntry> leafSelectEntries = leafQuery.getSelectEntries();
		List<AtomicEntry> leafAtomicEntries = leafQuery.getFromEntries();

		// (1) keep a map from all existing leaf atomic entries to a set of atomic entries, which are to be merged with the key.
		// Each original leaf atomic entry occurs as a key.
		Map<AtomicEntry, Set<AtomicEntry>> connectedAtomicEntriesMap = new HashMap<AtomicEntry, Set<AtomicEntry>>(leafAtomicEntries.size());

		// we initialize this map with all atomic leaf queries
		for (AtomicEntry currentAtomicLeafEntry : leafAtomicEntries) {
			connectedAtomicEntriesMap.put(currentAtomicLeafEntry, new HashSet<AtomicEntry>());
		}

		// run through the withEntries and remove/process the superfluous TypeComparisons. Fill the atomicEntriesMap with
		// the pairs of atomic entries which are to be compressed
		for (Iterator<WithEntry> iter = withEntries.iterator(); iter.hasNext();) {
			WithEntry withEntry = iter.next();

			// we only have to take action with TypeComparisons and LinksPredicates
			if (withEntry instanceof LinksPredicate) {

				// just go recursively deeper
				NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

				// but only if not already seen
				if (seenNestedQuery.add(nestedQuery)) {
					this.removeTypeComparisonsForInternalQuery(nestedQuery.getInternalQuery(), seenNestedQuery);
				}
			} else if (withEntry instanceof TypeComparison) {
				TypeComparison typeComparison = (TypeComparison) withEntry;

				// get the atomic entries
				AtomicEntry leftAtomicEntry = typeComparison.getLeftAtomicEntry();
				AtomicEntry rightAtomicEntry = typeComparison.getRightAtomicEntry();

				// add on both sides, so we build a set of connected atomic entries, indexed by each of its members
				connectedAtomicEntriesMap.get(leftAtomicEntry).add(rightAtomicEntry);
				connectedAtomicEntriesMap.get(rightAtomicEntry).add(leftAtomicEntry);

				// remove this typeComparison from the list
				iter.remove();

			} else if (withEntry instanceof AttrComparison || withEntry instanceof AssocPredicate) {
				// do nothing, i.e. just keep them
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, withEntry.getClass().getCanonicalName(), "JoinWhereEntry"); //$NON-NLS-1$
			}
		}

		// (2) for each atomic entry, we have to decide if we have to keep it. We do this by maintaining a map with 
		// the atomic entries which we have to throw out, and the atomic entries which we keep. 
		Map<AtomicEntry, AtomicEntry> toBeRemovedAtomicEntries = new HashMap<AtomicEntry, AtomicEntry>();

		// first run over all leaf atomic entries and decide for each if we keep it 
		for (AtomicEntry leafAtomicEntry : leafAtomicEntries) {
			this.manageConnectedAtomicEntriesMap(connectedAtomicEntriesMap, toBeRemovedAtomicEntries, leafAtomicEntry);
		}

		// (3) based on this information (i.e. the toBeRemovedAtomicEntries), we can adapt the current leaf query

		//first do the from entries by removing the old atomic entries from the from-list
		for (Iterator<AtomicEntry> iter = leafAtomicEntries.iterator(); iter.hasNext();) {
			if (toBeRemovedAtomicEntries.containsKey(iter.next())) {
				iter.remove();
			}
		}

		// adapt the select entries by rewiring
		for (LeafSelectEntry selectEntry : leafSelectEntries) {
			this.replaceAtomicEntryForReference(selectEntry.getAtomicEntryReference(), toBeRemovedAtomicEntries);
		}

		// adapt the with entries by rewiring
		this.rewireWithEntriesForRemovedAtomicEntries(withEntries, toBeRemovedAtomicEntries);
	}

	/**
	 * Give a map of toBeRemovedAtomicEntries, it rewires the withEntries, which have to be at the leafQuery level.
	 */
	private void rewireWithEntriesForRemovedAtomicEntries(List<WithEntry> withEntries,
			Map<AtomicEntry, AtomicEntry> toBeRemovedAtomicEntries) {

		for (WithEntry withEntry : withEntries) {
			AtomicEntryReference leftAtomicEntryRef = null;
			AtomicEntryReference rightAtomicEntryRef = null;
			if (withEntry instanceof LinksPredicate) {
				leftAtomicEntryRef = ((LinksPredicate) withEntry).getFromType();
			} else if (withEntry instanceof TypeComparison) {
				leftAtomicEntryRef = (AtomicEntryReference) ((TypeComparison) withEntry).getLeftTypeReference();
				rightAtomicEntryRef = (AtomicEntryReference) ((TypeComparison) withEntry).getRightTypeReference();
			} else if (withEntry instanceof AttrComparison) {
				leftAtomicEntryRef = (AtomicEntryReference) ((AttrComparison) withEntry).getLeftTypeReference();
				rightAtomicEntryRef = (AtomicEntryReference) ((AttrComparison) withEntry).getRightTypeReference();
			} else if (withEntry instanceof AssocPredicate) {
				leftAtomicEntryRef = ((AssocPredicate) withEntry).getFromType();
				rightAtomicEntryRef = ((AssocPredicate) withEntry).getToType();
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, withEntry.getClass().getCanonicalName(), "JoinWhereEntry"); //$NON-NLS-1$
			}
			this.replaceAtomicEntryForReference(leftAtomicEntryRef, toBeRemovedAtomicEntries);
			this.replaceAtomicEntryForReference(rightAtomicEntryRef, toBeRemovedAtomicEntries);
		}
	}

	/**
	 * Compresses node queries where possible by combining leaf queries if they operate in the same facility and only have alias comparisons
	 * (
	 */
	private InternalQuery compressNodeQueriesForInternalQuery(InternalQuery internalQuery, Set<NestedQuery> seenNestedQuery,
			Map<SelectEntry, SelectEntry> selectEntryMap) {

		InternalQuery resultQuery = internalQuery;

		// case analysis on internal query
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();
			List<InternalQuery> newOperands = new ArrayList<InternalQuery>(operands.size());

			// go recursively down
			for (InternalQuery operand : operands) {
				InternalQuery newOperand = this.compressNodeQueriesForInternalQuery(operand, seenNestedQuery, selectEntryMap);
				newOperands.add(newOperand);
			}

			((ResultUnion) internalQuery).setOperands(newOperands);

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			List<NodeSelectEntry> selectEntries = nodeQuery.getSelectEntries();
			List<ComparisonWithEntry> withEntries = nodeQuery.getWithEntries();

			// first go recursively down (the compression works bottom-up)
			InternalQuery firstCompressedFromEntry = this.compressNodeQueriesForInternalQuery(nodeQuery.getFirstFromEntry(),
					seenNestedQuery, selectEntryMap);
			InternalQuery secondCompressedFromEntry = this.compressNodeQueriesForInternalQuery(nodeQuery.getSecondFromEntry(),
					seenNestedQuery, selectEntryMap);

			// set these two parts
			nodeQuery.setFirstFromEntry(firstCompressedFromEntry);
			nodeQuery.setSecondFromEntry(secondCompressedFromEntry);

			// then update the type references for the select and with entries of the current node query itself
			this.redirectTypeReferencesForNodeQuery(selectEntries, withEntries, selectEntryMap);

			// when this redirection is done, we can check if the node query itself can be compressed
			resultQuery = this.compressTwoLeafQueriesIfPossible(nodeQuery, firstCompressedFromEntry, secondCompressedFromEntry,
					selectEntryMap);

		} else if (internalQuery instanceof LeafQuery) {

			for (WithEntry withEntry : ((LeafQuery) internalQuery).getWithEntries()) {
				if (withEntry instanceof LinksPredicate) {
					// just go recursively deeper
					NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

					// but only if not already seen
					if (seenNestedQuery.add(nestedQuery)) {
						this.compressNodeQueriesForInternalQuery(nestedQuery.getInternalQuery(), seenNestedQuery, selectEntryMap);
					}
				}
			}

		} else if (internalQuery instanceof EmptyQuery) {
			// don't do anything here

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		return resultQuery;
	}

	/**
	 * Given a map of connectedAtomicEntriesMap, produce the toBeRemovedAtomicEntries, giving a reference atomic entry
	 */
	private void manageConnectedAtomicEntriesMap(Map<AtomicEntry, Set<AtomicEntry>> connectedAtomicEntriesMap,
			Map<AtomicEntry, AtomicEntry> toBeRemovedAtomicEntries, AtomicEntry atomicEntry) {

		// obtain the set of entries which belong to the connected type-compared atomic entries
		Set<AtomicEntry> connectedAtomicEntries = connectedAtomicEntriesMap.get(atomicEntry);
		if (connectedAtomicEntries != null && !connectedAtomicEntries.isEmpty()) {
			// only if this set is not empty, we have atomic entries, which are to be removed

			// in the non-empty set of type-comparison connected atomic entries, we choose the first fixedSetAtomicEntry 
			// if it exists, otherwise we just take the reference atomic entry as the one to keep
			AtomicEntry atomicEntryToBeKept = null;
			for (Iterator<AtomicEntry> iterator = connectedAtomicEntries.iterator(); atomicEntryToBeKept == null && iterator.hasNext();) {
				AtomicEntry entryInConnectedSet = iterator.next();
				if (entryInConnectedSet instanceof AtomicEntryFixedSet) {
					atomicEntryToBeKept = entryInConnectedSet;
				}
			}

			// perhaps no fixed set atomic entry was found, just take the reference atomic entry as the one-to-be-kept
			if (atomicEntryToBeKept == null) {
				atomicEntryToBeKept = atomicEntry;
			}

			// get the set for the atomicEntryToBeKept and remove it from the map, so we do not handle it again
			Set<AtomicEntry> connectedEntriesForEntryTobeKept = connectedAtomicEntriesMap.remove(atomicEntryToBeKept);

			// for each of these, register them in the toBeRemovedAtomicEntries
			for (AtomicEntry connectedToBeRemovedEntry : connectedEntriesForEntryTobeKept) {
				// now also remove the atomic entry which is to-be-removed from the connectedAtomicEntriesMap
				connectedAtomicEntriesMap.remove(connectedToBeRemovedEntry);

				// then merge the to-be-removed entry with the atomicEntryToBeKept 
				// which is a fixed set atomic entry unless there where no fixed set 
				// atomic entries in the group in the first place. This guarantees the invariant
				this.mergeLeftAtomicEntryIntoRightAtomicEntry(connectedToBeRemovedEntry, atomicEntryToBeKept);

				// register the to-be-removed entry and map it to the one which replaces it
				toBeRemovedAtomicEntries.put(connectedToBeRemovedEntry, atomicEntryToBeKept);
			}
		}
	}

	/**
	 * If the atomicEntryRef is not null and can be found in the map, it is replaced with the target.
	 */
	private void replaceAtomicEntryForReference(AtomicEntryReference atomicEntryRef, Map<AtomicEntry, AtomicEntry> toBeRemovedAtomicEntries) {

		if (atomicEntryRef != null) {
			AtomicEntry newAtomicEntry = toBeRemovedAtomicEntries.get(atomicEntryRef.getAtomicEntry());
			if (newAtomicEntry != null) {
				// if we have an entry, we know that atomicEntryRef was referring to an entry which is to-be-removed
				// simply rewire it to the entry in which it is merged
				atomicEntryRef.setAtomicEntry(newAtomicEntry);
			}
		}
	}

	/**
	 * Check if the node query is unnecessary and compress if possible. Observe that firstNode and secondNode have been compressed already
	 * if it was possible in the first place.
	 */
	private InternalQuery compressTwoLeafQueriesIfPossible(NodeQuery nodeQuery, InternalQuery firstCompressedFromEntry,
			InternalQuery secondCompressedFromEntry, Map<SelectEntry, SelectEntry> selectEntryMap) {

		// by default, we assume compression was not possible, so the result *is* the node query without adaptations
		InternalQuery result = nodeQuery;

		// first we need to have two leaf queries
		if (firstCompressedFromEntry instanceof LeafQuery && secondCompressedFromEntry instanceof LeafQuery) {
			LeafQuery firstLeaf = (LeafQuery) firstCompressedFromEntry;
			LeafQuery secondLeaf = (LeafQuery) secondCompressedFromEntry;

			// check if both leaf queries are in the same facility
			if (firstLeaf.getFqlProcessor().getFacilityId().equals(secondLeaf.getFqlProcessor().getFacilityId())) {
				// now we need to check all comparisons and see if we can compress
				// NOTE: once we also are able to compress attribute comparisons, compressionPossible is true at this point.

				List<ComparisonWithEntry> withEntries = nodeQuery.getWithEntries();

				// (1) keep a map from all existing leaf atomic entries in the two member leaf queries 
				// which map to a set of atomic entries, which are to be merged with the key (provided we can compress)
				// Each original leaf atomic entry occurs as a key.
				Map<AtomicEntry, Set<AtomicEntry>> connectedAtomicEntriesMap = new HashMap<AtomicEntry, Set<AtomicEntry>>();

				// we keep this set to figure out which atomic entries we have to inspect for removal
				Set<AtomicEntry> toBeInspectedAtomicEntries = new HashSet<AtomicEntry>();

				// we also keep the list of attribute comparisons
				List<AttrComparison> attributeComparisons = new ArrayList<AttrComparison>();

				for (ComparisonWithEntry comparisonWithEntry : withEntries) {
					if (comparisonWithEntry instanceof TypeComparison) {
						TypeComparison typeComparison = (TypeComparison) comparisonWithEntry;
						AtomicEntry leftAtomicEntry = typeComparison.getLeftType().getAtomicEntry();
						AtomicEntry rightAtomicEntry = typeComparison.getRightType().getAtomicEntry();

						// register on the left
						Set<AtomicEntry> leftConnectedEntries = connectedAtomicEntriesMap.get(leftAtomicEntry);
						if (leftConnectedEntries == null) {
							leftConnectedEntries = new HashSet<AtomicEntry>();
							connectedAtomicEntriesMap.put(leftAtomicEntry, leftConnectedEntries);
						}
						leftConnectedEntries.add(rightAtomicEntry);
						toBeInspectedAtomicEntries.add(rightAtomicEntry);

						// register on the right
						Set<AtomicEntry> rightConnectedEntries = connectedAtomicEntriesMap.get(rightAtomicEntry);
						if (rightConnectedEntries == null) {
							rightConnectedEntries = new HashSet<AtomicEntry>();
							connectedAtomicEntriesMap.put(rightAtomicEntry, rightConnectedEntries);
						}
						rightConnectedEntries.add(leftAtomicEntry);
						toBeInspectedAtomicEntries.add(leftAtomicEntry);

					} else if (comparisonWithEntry instanceof AttrComparison) {
						attributeComparisons.add((AttrComparison) comparisonWithEntry);
					} else {
						throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, comparisonWithEntry.getClass().getCanonicalName(),
								"ComparisonWithEntry"); //$NON-NLS-1$
					}
				}

				// we can *only* compress two leaf queries whenever we have at least one type comparison
				// which combines two atomic entries in the two leaf queries
				if (connectedAtomicEntriesMap.size() != 0) {
					// in this case, we have to compress the two queries into one leaf query

					// we have to produce a map from all atomic entries, which we want to disappear
					// to the atomic entry which it is connected to and which will remain
					Map<AtomicEntry, AtomicEntry> toBeRemovedAtomicEntries = new HashMap<AtomicEntry, AtomicEntry>();

					// check the entries which we have to investigate
					for (AtomicEntry entryToBeInvestigated : toBeInspectedAtomicEntries) {
						// build up the toBeRemovedAtomicEntries map
						this.manageConnectedAtomicEntriesMap(connectedAtomicEntriesMap, toBeRemovedAtomicEntries, entryToBeInvestigated);
					}

					// build resulting leaf query

					List<AtomicEntry> leafFromEntries = new ArrayList<AtomicEntry>();
					List<WithEntry> leafWithEntries = new ArrayList<WithEntry>();
					List<LeafSelectEntry> leafSelectEntries = new ArrayList<LeafSelectEntry>();

					// (1) add all atomic entries from both leaf queries, which are not a key in the toBeRemovedAtomicEntries 

					// first leaf query
					for (AtomicEntry atomicEntry : firstLeaf.getFromEntries()) {
						if (!toBeRemovedAtomicEntries.containsKey(atomicEntry)) {
							leafFromEntries.add(atomicEntry);
						}
					}

					// second leaf query
					for (AtomicEntry atomicEntry : secondLeaf.getFromEntries()) {
						if (!toBeRemovedAtomicEntries.containsKey(atomicEntry)) {
							leafFromEntries.add(atomicEntry);
						}
					}

					// (2) for each node select entry, we take the approriate leaf select entry and possibly rewire
					// the atomic entry reference
					for (NodeSelectEntry nodeSelectEntry : nodeQuery.getSelectEntries()) {
						LeafSelectEntry leafSelectEntry = nodeSelectEntry.getLeafSelectEntry();

						// register this change in the selectEntryMap so encompassing queries can adapt to the change
						selectEntryMap.put(nodeSelectEntry, leafSelectEntry);

						// add the new (leaf) select entry
						leafSelectEntries.add(leafSelectEntry);

						// make sure that possible selections of diappearing atomic entries are redirected to the merged atomic entry
						this.replaceAtomicEntryForReference(leafSelectEntry.getAtomicEntryReference(), toBeRemovedAtomicEntries);
					}

					// (3) finally, collect the with entries from both leaf queries together with the attribute comparisons
					// and rewire if necessary

					// for the left leaf query
					for (WithEntry withEntry : firstLeaf.getWithEntries()) {
						leafWithEntries.add(withEntry);
					}

					// for the right leaf query
					for (WithEntry withEntry : secondLeaf.getWithEntries()) {
						leafWithEntries.add(withEntry);
					}

					// add the attribute comparisons as well, but enter them as leaf-based comparison with entries
					for (AttrComparison attrComparison : attributeComparisons) {
						// left
						AtomicAttrReference leftTypeAtomicAttrRef = (AtomicAttrReference) ((LeafSelectEntry) ((VirtualAtomicAttrReference) attrComparison
								.getLeftAttr()).getNestedSelectEntry()).getAtomicEntryReference();
						attrComparison.setLeftType(leftTypeAtomicAttrRef);

						// right
						AtomicAttrReference rightTypeAtomicAttrRef = (AtomicAttrReference) ((LeafSelectEntry) ((VirtualAtomicAttrReference) attrComparison
								.getRightAttr()).getNestedSelectEntry()).getAtomicEntryReference();
						attrComparison.setRightType(rightTypeAtomicAttrRef);

						// add it
						leafWithEntries.add(attrComparison);
					}

					// rewire these leafWithEntries where necessary
					this.rewireWithEntriesForRemovedAtomicEntries(leafWithEntries, toBeRemovedAtomicEntries);

					// construct the new result
					result = LeafQuery.construct(nodeQuery.getAliasName(), leafFromEntries, leafWithEntries, leafSelectEntries, firstLeaf
							.getFqlProcessor());
				}
			}
		}

		return result;
	}

}
