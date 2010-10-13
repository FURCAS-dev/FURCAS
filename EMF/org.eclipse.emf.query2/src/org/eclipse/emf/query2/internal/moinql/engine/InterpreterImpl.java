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
 * Created on 02.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.EmfHelper;
import org.eclipse.emf.query2.QueryExecutionException;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.bql.api.SpiBasicQueryProcessor;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectExpression;
import org.eclipse.emf.query2.internal.bql.engine.BasicQueryProcessorMemoryEstimationImpl;
import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntry;
import org.eclipse.emf.query2.internal.moinql.ast.AttrComparison;
import org.eclipse.emf.query2.internal.moinql.ast.ComparisonWithEntry;
import org.eclipse.emf.query2.internal.moinql.ast.EmptyQuery;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LeafQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LinksPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.NestedQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NodeQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NodeSelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.QueryResultSetImpl;
import org.eclipse.emf.query2.internal.moinql.ast.ResultUnion;
import org.eclipse.emf.query2.internal.moinql.ast.SelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.TypeAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.TypeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.TypeReference;
import org.eclipse.emf.query2.internal.moinql.ast.VirtualAtomicEntryReference;
import org.eclipse.emf.query2.internal.moinql.ast.WithEntry;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.emf.query2.internal.moinql.controller.ResultSetImpl;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;

/**
 * This service interpretes the {@link org.eclipse.emf.query2.internal.moinql.ast.InternalQuery} structure. It uses the FQL services,
 * including the memory FQL to calculate parts of the query. Its query part results are further combined in-memory according to the
 * operations defined in the Internal Query.
 */
final public class InterpreterImpl implements Interpreter {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(InterpreterImpl.class);

	// we keep the connection
	//    final private CoreConnection conn;

	// we keep the memory processor
	final private SpiFacilityQueryLanguage memoryFQL;

	// this registers the maximum result set size
	private int maxResultSetSize;

	// Needed for emitting JMX notifications.
	final private QueryProcessorImpl mqlProcessor;

	// a translator from MQL internal to BQL
	final private BQLTranslator bqlTranslator;

	// additional transformation services
	final private AuxServices mqlAuxServices;

	// we require the OCL partition PRI for mof rom injection
	//    final private PRI oclPri;

	private EmfHelper emfHelper;

	public InterpreterImpl(EmfHelper _emfHelper, SpiFacilityQueryLanguage memoryFQL, QueryProcessorImpl mqlProcessor,
			AuxServices transformationService) {

		this.emfHelper = _emfHelper;
		//        this.conn = _conn;
		this.memoryFQL = memoryFQL;
		this.mqlProcessor = mqlProcessor;
		this.bqlTranslator = new BQLTranslator();
		this.mqlAuxServices = transformationService;
		//        this.oclPri = _conn.getSession( ).getMoin( ).createPri( MoinMofRomServicesImpl.OCL_PRI_STRING );
	}

	/* ---------------- */
	/* Public methods */
	/* ---------------- */

	public ResultSet execute(InternalQuery internalQuery, int _maxResultSetSize, int numberOfResults) throws QueryExecutionException {

		// set the maximum result set size. If this is exceeded, we throw and MQLExecutionException
		this.maxResultSetSize = _maxResultSetSize;

		ResultSet resultSet = null;

		// determine the number of requested rows (always positive)
		int numberOfRequestedRows = (numberOfResults < 0 ? this.maxResultSetSize + 1 : numberOfResults);

		// fixe the top-level selected entries for this query
		List<SelectEntry> topLevelSelectEntries = this.mqlAuxServices.calculateSelectEntries(internalQuery);

		if (numberOfRequestedRows == 0) {
			// empty result set
			resultSet = new ResultSetImpl(this.emfHelper, topLevelSelectEntries);
		} else {

			// we keep a position map, which projects a TypeReference on a position record in a result set
			Map<SelectEntry, PositionRecord> positionMap = new HashMap<SelectEntry, PositionRecord>();

			// execute the internal query
			SpiFqlQueryResultSet facilityResultSet = this.executeInternalQuery(internalQuery, positionMap, numberOfRequestedRows);

			// sanity check
			if (facilityResultSet == null) {
				throw new BugException(BugMessages.UNEXPECTED_NULL_RESULT_SET);
			}

			if (facilityResultSet.getSize() == 0) {
				// we have an empty result set
				resultSet = new ResultSetImpl(this.emfHelper, topLevelSelectEntries);
			} else {
				// for a non-empty result set, we fix the alias and attribute position maps
				Map<String, Integer> aliasToPosition = new HashMap<String, Integer>();
				List<Map<String, Integer>> attrsToPosition = new ArrayList<Map<String, Integer>>();

				this.calculateAliasAttributePositionMaps(topLevelSelectEntries, positionMap, aliasToPosition, attrsToPosition);

				// construct result
				resultSet = new ResultSetImpl(this.emfHelper, topLevelSelectEntries, facilityResultSet, aliasToPosition, attrsToPosition);
			}
		}

		return resultSet;
	}

	/* ----------------- */
	/* Private methods */
	/* ----------------- */

	/**
	 * This record keeps track of the position of aliases and attributes. For an alias, the attributePosition is -1 and if we have an
	 * attribute the multivalued boolean keeps track whether the value is multivalued or not.
	 */
	public static final class PositionRecord {

		public int aliasPosition;

		// by default no attribute
		public int attributePosition = -1;

		// by default not multivalued
		public boolean multivalued = false;
	}

	/**
	 * Based on the resulting select entries and the positionMap, this method calculates the aliasToPosition, attrsToPosition, and
	 * multiValuedAttrs maps required to construct an MQL result set
	 */
	private void calculateAliasAttributePositionMaps(List<SelectEntry> topLevelSelectEntries, Map<SelectEntry, PositionRecord> positionMap,
			Map<String, Integer> aliasToPosition, List<Map<String, Integer>> attrsToPosition) {

		// walk over each select entry in the top-level select entries and construct the entries in the relevant maps
		for (SelectEntry topLevelSelectEntry : topLevelSelectEntries) {
			// first get the type reference
			TypeReference typeRef = topLevelSelectEntry.getTypeReference();

			// and the alias name of the true atomic entry
			String originalAliasName = typeRef.getAtomicEntry().getAliasName().getOriginalName();

			// and the position record for this entry
			PositionRecord positionRecord = positionMap.get(topLevelSelectEntry);

			// sanity check
			if (positionRecord == null) {
				throw new BugException(BugMessages.TOP_LEVEL_WITHOUT_ENTRY_IN_POSITION_MAP);
			}

			// obtain the aliasPosition and attrToPosition information (if it exists)
			Integer aliasPosition = aliasToPosition.get(originalAliasName);
			Map<String, Integer> attrToPosition;

			if (aliasPosition == null) {
				// we have not yet registered a position, so we use the positionRecord to construct what we need
				aliasPosition = positionRecord.aliasPosition;
				attrToPosition = new HashMap<String, Integer>();

				// fill the to-be-constructed map and lists
				aliasToPosition.put(originalAliasName, aliasPosition);
				attrsToPosition.add(aliasPosition, attrToPosition);
			} else {
				attrToPosition = attrsToPosition.get(aliasPosition);
			}

			// if we are dealing with an attribute, we have to also register the required attribute information
			if (typeRef instanceof TypeAttrReference) {
				TypeAttrReference typeAttrRef = (TypeAttrReference) typeRef;
				String attrName = typeAttrRef.getAttrName();

				// fill the attrToPosition map
				attrToPosition.put(attrName, positionRecord.attributePosition);
			}
		}
	}

	/* -------------------------------- */
	/* Interpretation methods for IQF */
	/* -------------------------------- */

	/**
	 * Main execution method dispatches on the structure of the internal query
	 */
	private SpiFqlQueryResultSet executeInternalQuery(InternalQuery internalQuery, Map<SelectEntry, PositionRecord> positionMap,
			int numberOfRequestedRows) throws QueryExecutionException {

		// for the result
		SpiFqlQueryResultSet resultSet;

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			// execute the union by concatenating the results
			resultSet = this.executeResultUnion((ResultUnion) internalQuery, positionMap, numberOfRequestedRows);

		} else if (internalQuery instanceof NodeQuery) {
			// execute the node query by internal joining
			resultSet = this.executeNodeQuery((NodeQuery) internalQuery, positionMap, numberOfRequestedRows);

		} else if (internalQuery instanceof EmptyQuery) {
			// Empty query means an empty result set
			resultSet = this.constructEmptyBasicQueryResultSet(this.mqlAuxServices.calculateSelectEntries(internalQuery), positionMap);

		} else if (internalQuery instanceof LeafQuery) {

			// execute the leaf query by translation into the responsible FQL processor
			resultSet = this.executeLeafQuery((LeafQuery) internalQuery, positionMap, numberOfRequestedRows);

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		return resultSet;
	}

	/**
	 * Calculates the union by concatenating the internal results. The positionMap registers the position for all participating operands!
	 */
	private SpiFqlQueryResultSet executeResultUnion(ResultUnion resultUnion, Map<SelectEntry, PositionRecord> positionMap,
			int numberOfRequestedRows) throws QueryExecutionException {

		SpiFqlQueryResultSet resultSet;

		long timeStamp = System.nanoTime();
		try {
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_EXECUTING_FOLLOWING_UNION_QUERY, "\n", resultUnion); //$NON-NLS-1$
			}

			// obtain the operands
			Iterator<InternalQuery> operandsIter = resultUnion.getOperands().iterator();

			// we expect at least one operand
			if (operandsIter.hasNext()) {
				// execute it and fill the position map
				resultSet = this.executeInternalQuery(operandsIter.next(), positionMap, numberOfRequestedRows);

				// calculate the remaining operands and add the results
				for (; operandsIter.hasNext();) {
					InternalQuery secondOperand = operandsIter.next();
					// execute, but only if we have not crossed the maxNumberOfResults yet
					int resultSetSize = resultSet.getSize();
					if (resultSetSize < numberOfRequestedRows) {
						SpiFqlQueryResultSet operandResultSet = this
								.executeInternalQuery(secondOperand, positionMap, numberOfRequestedRows);

						int newResultSetSize = operandResultSet.getSize() + resultSetSize;

						// check if result is not too large
						if (newResultSetSize > this.maxResultSetSize) {
							throw new QueryExecutionException(ApiMessages.RESULTSET_TOO_LARGE);
						} else if (newResultSetSize > numberOfRequestedRows) {
							resultSet.addFixedAmountEntriesFromResult(operandResultSet, numberOfRequestedRows - resultSetSize);
						} else {
							// add all the results at the end of the previous result set
							resultSet.addEntriesFromResultSet(operandResultSet);
						}
					}
				}
			} else {
				throw new BugException(BugMessages.EXPECTED_AT_LEAST_ONE_OPERAND_IN_RESULT_UNION);
			}
		} finally {
			if (logger.isTraced(LogSeverity.DEBUG)) {
				long queryTime = (System.nanoTime() - timeStamp) / 1000000;
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_EXECUTED_UNION_QUERY, queryTime);
			}
		}

		return resultSet;
	}

	/**
	 * Leaf queries are executed on their FQL processor. Before doing this, we check for nested queries (but only ones which are reset) and
	 * execute those first and adapt the internal structure accordingly.
	 */
	private SpiFqlQueryResultSet executeLeafQuery(LeafQuery leafQuery, Map<SelectEntry, PositionRecord> positionMap,
			int numberOfRequestedRows) throws QueryExecutionException {

		// Before executing the leaf query, we check for nested queries (which
		// are reset and execute those first). We adapt the internal structure accordingly
		this.executeNestedResetQueries(leafQuery.getWithEntries());

		// obtain the processor
		SpiFacilityQueryLanguage fqlProcessor = leafQuery.getFqlProcessor();

		// we define the partition for executing the query
		Set<URI> scope = Collections.emptySet();
		boolean scopeInclusive = false;

		// if we are dealing with the memory processor, the bqlScope cannot not
		// be null, otherwise it *has* to be null
		if (this.memoryFQL.equals(fqlProcessor)) {

			// this query has to be executed in-memory because of the scheduling process. The maximal scope in which
			// the query has to operate is the inclusive-memory scope for each element of the query
			scope = new HashSet<URI>();

			// calculate the scope for the leaf query
			this.calculateMemoryInclusiveScope(leafQuery, scope);
			scopeInclusive = true;
		}

		// check if we query for MOF instances and inject second mof rom phase if required 
		//        else {
		//            CoreMoin moin = this.conn.getSession( ).getMoin( );
		//            if ( !moin.isSecondStageInjected( ) ) {
		//                for ( AtomicEntry fromEntry : leafQuery.getFromEntries( ) ) {
		//                    if ( fromEntry.getScope( ).contains( this.oclPri ) == fromEntry.isScopeInclusive( ) ) {
		//                        moin.injectSecondMofRomStage( );
		//                        break;
		//                    }
		//                }
		//            }
		//        }

		// we execute the BasicQL Query with its assigned bqlProcessor
		SpiFqlQueryResultSet resultSet;

		long timeStamp = System.nanoTime();
		try {

			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_EXECUTING_FOLLOWING_LEAF_QUERY_IN_SERVICE, fqlProcessor
						.getFacilityId(), "\n", leafQuery); //$NON-NLS-1$
			}

			//FIXME deprecated BQL scenario
			if (fqlProcessor instanceof SpiBasicQueryProcessor) {

				// execute the translated leaf query
				try {
					SpiBasicQueryProcessor bql = (SpiBasicQueryProcessor) fqlProcessor;

					// translate the (possibly adapted) leaf query
					SpiSelectExpression selectExpression = this.bqlTranslator.leafQuery2bql(leafQuery, positionMap);

					//					if (JMX_ENABLED && this.mqlProcessor.jmxNotificationsEnabled) {
					//						long duration = System.nanoTime();
					//						resultSet = bql.execute(this.emfHelper, new CoreQueryClientScope(scope, scopeInclusive), selectExpression,
					//								this.maxResultSetSize, numberOfRequestedRows);
					//						duration = (System.nanoTime() - duration) / 1000000;
					//						this.mqlProcessor.leafQueryExecuted(selectExpression.toString(), duration);
					//					} else {
					if (bql instanceof BasicQueryProcessorMemoryEstimationImpl) {
						this.emfHelper.setUseNonDirty();
						resultSet = bql.execute(this.emfHelper, new CoreQueryClientScope(scope, scopeInclusive), selectExpression,
								this.maxResultSetSize, numberOfRequestedRows);
						this.emfHelper.setUseDirty();
					} else {
						resultSet = bql.execute(this.emfHelper, new CoreQueryClientScope(scope, scopeInclusive), selectExpression,
								this.maxResultSetSize, numberOfRequestedRows);
					}
					//					}

					// sanity check
					if (resultSet == null) {
						throw new BugException(BugMessages.BQL_EXECUTION_RETURNS_NULL_RESULT_SET);
					}

				} catch (SpiFacilityQueryServiceException e) {
					switch (e.getErrorCode()) {
					case SpiFacilityQueryServiceException.ERROR_CODE_RESULTSET_TOO_LARGE:
						throw new QueryExecutionException(e, ApiMessages.RESULTSET_TOO_LARGE);

					case SpiFacilityQueryServiceException.ERROR_CODE_REFLECT_ELEMENT:
						throw new QueryExecutionException(e, ApiMessages.MUST_RESTRICT_SCOPE_FOR_ELEMENT);

					default:
						throw new BugException(e, BugMessages.SPI_FACILITY_QUERY_SERVICE_EXCEPTION);
					}
				}
			} else {

				try {
					// we have to make sure the selections of the leaf query are set so FQL requests are correct. This is also the 
					// basis for the position map
					leafQuery.setSelections(positionMap);

					//					if (JMX_ENABLED && this.mqlProcessor.jmxNotificationsEnabled) {
					//						long duration = System.nanoTime();
					//						resultSet = fqlProcessor.execute(new CoreQueryClientScope(scope, scopeInclusive), leafQuery, this.maxResultSetSize,
					//								numberOfRequestedRows);
					//						duration = (System.nanoTime() - duration) / 1000000;
					//						//						this.mqlProcessor.leafQueryExecuted(leafQuery.toString(), duration);
					//					} else {
					resultSet = fqlProcessor.execute(new CoreQueryClientScope(scope, scopeInclusive), leafQuery, this.maxResultSetSize,
							numberOfRequestedRows);
					//					}

					// sanity check
					if (resultSet == null) {
						throw new BugException(BugMessages.FQL_EXECUTION_RETURNS_NULL_RESULT_SET);
					}

				} catch (SpiFacilityQueryServiceException e) {
					switch (e.getErrorCode()) {
					case SpiFacilityQueryServiceException.ERROR_CODE_RESULTSET_TOO_LARGE:
						throw new QueryExecutionException(e, ApiMessages.RESULTSET_TOO_LARGE);

					case SpiFacilityQueryServiceException.ERROR_CODE_REFLECT_ELEMENT:
						throw new QueryExecutionException(e, ApiMessages.MUST_RESTRICT_SCOPE_FOR_ELEMENT);

					default:
						throw new BugException(e, BugMessages.SPI_FACILITY_QUERY_SERVICE_EXCEPTION);
					}
				}
			}

		} finally {
			if (logger.isTraced(LogSeverity.INFO)) {
				long queryTime = (System.nanoTime() - timeStamp) / 1000000;
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_EXECUTED_LEAF_QUERY_IN_SERVICE, queryTime, fqlProcessor
						.getFacilityId());
			}
		}

		return resultSet;
	}

	/**
	 * Calculates the scope in which the leaf query operates
	 */
	private void calculateMemoryInclusiveScope(LeafQuery leafQuery, Set<URI> scope) {

		// Calculate all the partitions relevant for this scope
		for (AtomicEntry entry : leafQuery.getFromEntries()) {
			if (entry.isScopeInclusive()) {
				Set<URI> entryScopeSet = entry.getScope();
				// expect an non-empty scope
				if ((entryScopeSet != null) && (entryScopeSet.size() != 0)) {
					scope.addAll(entryScopeSet);
				} else {
					throw new BugException(BugMessages.UNEXPECTED_EMPTY_SCOPE_FOR_LEAF_QUERY_DURING_EXECUTION);
				}

			} else {
				// should not happen!
				throw new BugException(BugMessages.UNEXPECTED_EXCLUSIVE_SCOPE_FOR_SCHEDULED_MEMORY_EXECUTION);
			}
		}

		// work recursively on link predicates who are *not* reset
		for (WithEntry withEntry : leafQuery.getWithEntries()) {
			// only something to do for a links predicate
			if (withEntry instanceof LinksPredicate) {
				// get the nested query and check if it is not reset
				NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

				if (!nestedQuery.isReset()) {
					// only then, we keep collecting recursively down
					InternalQuery nestedInternalQuery = nestedQuery.getInternalQuery();

					// sanity check
					if (nestedInternalQuery instanceof LeafQuery) {
						this.calculateMemoryInclusiveScope((LeafQuery) nestedInternalQuery, scope);
					} else {
						throw new BugException(BugMessages.NESTED_SELECT_WAS_NOT_RESET);
					}
				}
			}
		}
	}

	/**
	 * This methods walks over the with entries and for the link predicates, investigates the nested query. If it is reset, it executes the
	 * nested query and caches the result set. Otherwise, if there was no reset, the nested query is not touched and left for execution of
	 * the encompassing leaf query.
	 */
	private void executeNestedResetQueries(List<WithEntry> leafQueryWithEntries) throws QueryExecutionException {

		// run over the with entries
		for (WithEntry entry : leafQueryWithEntries) {
			// we are only interested in the link predicates
			if (entry instanceof LinksPredicate) {
				NestedQuery nestedQuery = ((LinksPredicate) entry).getNestedQuery();

				// Only do something if reset and if the intermediate result does not already exist
				if (nestedQuery.isReset() && (nestedQuery.getResultSet() == null)) {
					// construct a new position map
					Map<SelectEntry, PositionRecord> positionMap = new HashMap<SelectEntry, PositionRecord>();
					// execute the nested internal query (note that we obtain as many results as possible)
					SpiFqlQueryResultSet nestedResultSet = this.executeInternalQuery(nestedQuery.getInternalQuery(), positionMap,
							this.maxResultSetSize + 1);
					// set the intermediate result
					nestedQuery.setResultSet(nestedResultSet);
				}
			}
		}
	}

	/**
	 * This method interprets the node query by evaluating the two from-entries and joins the results in a new result set. It does this by
	 * emptying the largest result set row by row. For each row, the joined rows are put in the new result set.
	 */
	private SpiFqlQueryResultSet executeNodeQuery(NodeQuery nodeQuery, Map<SelectEntry, PositionRecord> positionMap,
			int numberOfRequestedRows) throws QueryExecutionException {

		// the result set is constructed to be an empty result set. 
		// Even in the join-case (i.e. where both from entries are not the empty result, 
		// we have to start out from an empty result set. Moreover, this method sets up 
		// the positionMap for the result, a fact we exploit in the joining of the two
		// from entries.
		SpiFqlQueryResultSet resultSet = this.constructEmptyBasicQueryResultSet(this.mqlAuxServices.calculateSelectEntries(nodeQuery),
				positionMap);

		long timeStamp = System.nanoTime();
		try {
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_EXECUTING_FOLLOWING_NODE_QUERY, "\n", nodeQuery); //$NON-NLS-1$
			}

			// the internal queries to be processed
			InternalQuery firstFromEntry = nodeQuery.getFirstFromEntry();
			InternalQuery secondFromEntry = nodeQuery.getSecondFromEntry();

			// (1) execute the first from-entry
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_EXECUTING_FIRST_PART_OF_NODE_QUERY);
			}

			SpiFqlQueryResultSet firstFromEntryResultSet = this
					.executeInternalQuery(firstFromEntry, positionMap, this.maxResultSetSize + 1);

			// get the size of the result
			int firstFromEntryResultSetSize = firstFromEntryResultSet.getSize();

			SpiFqlQueryResultSet secondFromEntryResultSet = null;
			int secondFromEntryResultSetSize = 0;

			// execute the second from-entry, but only if the first was not empty
			if (firstFromEntryResultSetSize != 0) {
				// (2) execute the second from-entry
				if (logger.isTraced(LogSeverity.DEBUG)) {
					logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_EXECUTING_SECOND_PART_OF_NODE_QUERY);
				}
				secondFromEntryResultSet = this.executeInternalQuery(secondFromEntry, positionMap, this.maxResultSetSize + 1);

				// get the size of the result
				secondFromEntryResultSetSize = secondFromEntryResultSet.getSize();

				if (secondFromEntryResultSetSize != 0) {
					// if none of the two from-internal queries produced an empty result, we do not have an 
					// empty result set for this node query and have to start joining

					// we determine which is the larger result set
					SpiFqlQueryResultSet largerSet;
					SpiFqlQueryResultSet otherSet;

					// this is the first non-ResultUnion query (and non-EmptyQuery of course) from the larger 
					// FromEntry. It is a "handle" so we can relate the "owning query" of a select entry 
					// (and thus the result set) to the FromEntry producing the larger result set.
					InternalQuery largerFromEntry;

					if (secondFromEntryResultSetSize > firstFromEntryResultSetSize) {
						largerSet = secondFromEntryResultSet;
						largerFromEntry = secondFromEntry;
						otherSet = firstFromEntryResultSet;
					} else {
						largerSet = firstFromEntryResultSet;
						largerFromEntry = firstFromEntry;
						otherSet = secondFromEntryResultSet;
					}

					// obtain the first non-ResultUnion (from which the selection happens) 
					while (largerFromEntry instanceof ResultUnion) {
						largerFromEntry = ((ResultUnion) largerFromEntry).getOperands().get(0);
					}

					// produce an array of ExecutableComparisons for the given withComparisons
					ExecutableComparison[] exectuableComparisons = this.constructExecutableComparisons(nodeQuery.getWithEntries(),
							positionMap, largerFromEntry, largerSet, otherSet);

					// produce an array of ExecutableSelections which are required to know what elements to pick from the different result sets
					ExecutableSelection[] executableSelections = this.constructExecutableSelections(nodeQuery.getSelectEntries(),
							positionMap, largerFromEntry, largerSet, otherSet);

					// finally join the largerstSet and otherSet into the (currently empty) result set 
					this.joinResultSets(resultSet, largerSet, otherSet, exectuableComparisons, executableSelections, numberOfRequestedRows);

				} else {
					if (logger.isTraced(LogSeverity.DEBUG)) {
						logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_SECOND_PART_OF_NODE_QUERY_IS_EMPTY);
					}
				}
			} else {
				if (logger.isTraced(LogSeverity.DEBUG)) {
					logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_FIRST_PART_OF_NODE_QUERY_IS_EMPTY);
				}
			}

		} finally {
			if (logger.isTraced(LogSeverity.DEBUG)) {
				long queryTime = (System.nanoTime() - timeStamp) / 1000000;
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_EXECUTED_NODE_QUERY, queryTime);
			}
		}

		return resultSet;
	}

	/**
	 * This record is the internal representation required to calculate ComparisonWithEntries on FacilityQueryResultSets
	 */
	public static final class ExecutableComparison {

		// indicates whether it is a type or attribute comparison
		public boolean typeComparison;

		public SpiFqlQueryResultSet largerLeftResultSet;

		public PositionRecord positionInLargerLeftResultSet;

		public SpiFqlComparisonOperation operation;

		public SpiFqlQueryResultSet smallerRightResultSet;

		public PositionRecord positionInSmallerRightResultSet;
	}

	/**
	 * This method constructs the executable representation of a ComparisonWithEntry, where it makes sure that the largest result set is on
	 * the left.
	 */
	private ExecutableComparison[] constructExecutableComparisons(List<ComparisonWithEntry> withEntries,
			Map<SelectEntry, PositionRecord> positionMap, InternalQuery largerLeftQuery, SpiFqlQueryResultSet largerLeftResultSet,
			SpiFqlQueryResultSet smallerRightResultSet) {

		// for the result
		List<ExecutableComparison> comparisonList = new ArrayList<ExecutableComparison>();

		// walk over the with entries
		for (ComparisonWithEntry comparisonWithEntry : withEntries) {

			// get the left select node and its query
			SelectEntry leftSelectNode = ((VirtualAtomicEntryReference) comparisonWithEntry.getLeftTypeReference()).getNestedSelectEntry();

			// get the right select node
			SelectEntry rightSelectNode = ((VirtualAtomicEntryReference) comparisonWithEntry.getRightTypeReference())
					.getNestedSelectEntry();
			InternalQuery rightSelectQuery = rightSelectNode.getOwningQuery();

			// determine if we have to swap operations
			boolean swapOperations = largerLeftQuery.equals(rightSelectQuery);

			// construct result
			ExecutableComparison executableComparison = new ExecutableComparison();

			executableComparison.largerLeftResultSet = largerLeftResultSet;
			executableComparison.smallerRightResultSet = smallerRightResultSet;

			if (swapOperations) {
				executableComparison.positionInLargerLeftResultSet = positionMap.get(rightSelectNode);
				executableComparison.positionInSmallerRightResultSet = positionMap.get(leftSelectNode);
			} else {

				executableComparison.positionInLargerLeftResultSet = positionMap.get(leftSelectNode);
				executableComparison.positionInSmallerRightResultSet = positionMap.get(rightSelectNode);
			}

			// now handle the operation and the nature of the comparison
			if (comparisonWithEntry instanceof TypeComparison) {
				executableComparison.operation = SpiFqlComparisonOperation.EQUAL;
				executableComparison.typeComparison = true;

			} else if (comparisonWithEntry instanceof AttrComparison) {
				executableComparison.typeComparison = false;
				executableComparison.operation = ((AttrComparison) comparisonWithEntry).getOperation();

				// swap operation
				if (swapOperations) {
					switch (executableComparison.operation) {
					case EQUAL:
						break;
					case NOT_EQUAL:
						break;
					case GREATER:
						executableComparison.operation = SpiFqlComparisonOperation.LESS_OR_EQUAL;
						break;
					case GREATER_OR_EQUAL:
						executableComparison.operation = SpiFqlComparisonOperation.LESS;
						break;
					case LESS:
						executableComparison.operation = SpiFqlComparisonOperation.GREATER_OR_EQUAL;
						break;
					case LESS_OR_EQUAL:
						executableComparison.operation = SpiFqlComparisonOperation.GREATER;
						break;
					default:
						throw new BugException(BugMessages.UNEXPECTED_SIMPLE_COMPARISON_OPERATOR);
					}
				}

			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, comparisonWithEntry.getClass().getCanonicalName(),
						"ComparisonWithEntry"); //$NON-NLS-1$
			}

			comparisonList.add(executableComparison);
		}

		// construct result
		return comparisonList.toArray(new ExecutableComparison[comparisonList.size()]);
	}

	/**
	 * This record keeps positional information required to make the selection in a join. It says that the element in the
	 * originatingPosition of the originatingResultSet has to appear in the targetPosition of the to-be-constructed resultSet.
	 */
	public static final class ExecutableSelection {

		public SpiFqlQueryResultSet originatingResultSet;

		public boolean originatingIsLargerResultSet;

		public PositionRecord originatingPosition;

		public PositionRecord targetPosition;
	}

	/**
	 * This method produces the SelectionPositions which are required to know what elements to pick from the different result sets.
	 */
	private ExecutableSelection[] constructExecutableSelections(List<NodeSelectEntry> selectEntries,
			Map<SelectEntry, PositionRecord> positionMap, InternalQuery largerLeftQuery, SpiFqlQueryResultSet largerResultSet,
			SpiFqlQueryResultSet otherResultSet) {

		// for the result
		ExecutableSelection[] executableSelections = new ExecutableSelection[selectEntries.size()];

		// this is the index for the selections
		int selectionIndex = 0;

		// walk over the select entries
		for (NodeSelectEntry nodeSelectEntry : selectEntries) {
			// construct an executable selection
			ExecutableSelection executableSelection = new ExecutableSelection();

			// obtain the select entry one down and its owning query
			SelectEntry nestedSelectEntry = nodeSelectEntry.getVirtualAtomicEntryReference().getNestedSelectEntry();
			InternalQuery nestedOwningQuery = nestedSelectEntry.getOwningQuery();

			// check if the selectiong happens in the largerResultSet
			executableSelection.originatingIsLargerResultSet = largerLeftQuery.equals(nestedOwningQuery);

			// set the correct result set
			if (executableSelection.originatingIsLargerResultSet) {
				executableSelection.originatingResultSet = largerResultSet;
			} else {
				executableSelection.originatingResultSet = otherResultSet;
			}

			// set the originating and target positions
			executableSelection.originatingPosition = positionMap.get(nestedSelectEntry);
			executableSelection.targetPosition = positionMap.get(nodeSelectEntry);

			executableSelections[selectionIndex++] = executableSelection;
		}

		return executableSelections;
	}

	/**
	 * This method produces an empty new BasicQueryResultSet of the correct structure and fills the positionMap.
	 */
	private SpiFqlQueryResultSet constructEmptyBasicQueryResultSet(List<SelectEntry> selectEntries,
			Map<SelectEntry, PositionRecord> positionMap) {

		// we also keep a map from atomic entries to their alias index
		Map<AtomicEntry, Integer> aliasPositionMap = new HashMap<AtomicEntry, Integer>();

		// keeps track of the index of aliases (number of select lists)
		int aliasIndex = 0;

		// keeps track of the number of attributes for each alias (or select list)
		List<Integer> numberOfAttributesForAlias = new ArrayList<Integer>();

		// walk over the select entries
		for (SelectEntry selectEntry : selectEntries) {

			// we need the type reference
			TypeReference typeRef = selectEntry.getTypeReference();

			// and its atomic entry
			AtomicEntry atomicEntry = typeRef.getAtomicEntry();

			// we construct a position record, no matter what
			PositionRecord positionRecord = new PositionRecord();

			// put it in the map
			positionMap.put(selectEntry, positionRecord);

			// first check if we already have position for it
			if (aliasPositionMap.containsKey(atomicEntry)) {
				positionRecord.aliasPosition = aliasPositionMap.get(atomicEntry);
			} else {
				// not yet there, so set with the current alias index
				positionRecord.aliasPosition = aliasIndex;

				// set the number of attributes as being 0
				numberOfAttributesForAlias.add(aliasIndex, 0);

				// see the atomic entry
				aliasPositionMap.put(atomicEntry, aliasIndex);

				// increase the aliasIndex
				aliasIndex++;
			}

			// we have to do more if we are dealing with an attribute reference
			if (typeRef instanceof TypeAttrReference) {
				// first, we set the attribute position
				positionRecord.attributePosition = numberOfAttributesForAlias.get(positionRecord.aliasPosition);

				// we set if we have a multi-valued attribute
				positionRecord.multivalued = ((TypeAttrReference) typeRef).isMultiValued();

				// we increase the size of attributes
				numberOfAttributesForAlias.set(positionRecord.aliasPosition, positionRecord.attributePosition + 1);
			}

		}

		// finally, we construct the actual result set
		int[] numberOfAttributes = new int[numberOfAttributesForAlias.size()];
		for (int i = 0; i < numberOfAttributes.length; i++) {
			numberOfAttributes[i] = numberOfAttributesForAlias.get(i);
		}

		return new QueryResultSetImpl(numberOfAttributes);
	}

	/**
	 * This method actually performs the in-memory join. The targetResultSet is initially empty. We make the product of the baseResultSet
	 * and the otherResultSet where for each new row, we remove the last row of the baseResultSet. The comparisons provide the information
	 * to select and execute the elements from each of the rows. The selections provide the information to fill a new row in the
	 * targetResultSet.
	 */
	private void joinResultSets(SpiFqlQueryResultSet targetResultSet, SpiFqlQueryResultSet largerBaseResultSet,
			SpiFqlQueryResultSet smallerOtherResultSet, ExecutableComparison[] executableComparisons,
			ExecutableSelection[] executableSelections, int numberOfRequestedRows) {

		// solely for debugging purposes
		if (logger.isTraced(LogSeverity.DEBUG)) {
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_JOINING_RESULT_SETS);

			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_FIRST_RESULT_SET_OF_SIZE, String.valueOf(largerBaseResultSet
					.getSize()), "\n", largerBaseResultSet); //$NON-NLS-1$

			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_SECOND_RESULT_SET_OF_SIZE, String.valueOf(smallerOtherResultSet
					.getSize()), "\n", smallerOtherResultSet); //$NON-NLS-1$

			for (int i = 0; i < executableComparisons.length; i++) {
				String leftPosition = String.valueOf(executableComparisons[i].positionInLargerLeftResultSet.aliasPosition);
				String rightPosition = String.valueOf(executableComparisons[i].positionInSmallerRightResultSet.aliasPosition);
				String forOperation = (executableComparisons[i].typeComparison ? "type" : "attribute"); //$NON-NLS-1$ //$NON-NLS-2$
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_COMPARE_ELEMENTS_IN_SETS, forOperation, leftPosition,
						rightPosition, executableComparisons[i].operation);
			}

			for (int i = 0; i < executableSelections.length; i++) {
				String originalPos = String.valueOf(executableSelections[i].originatingPosition.aliasPosition);
				String targetPos = String.valueOf(executableSelections[i].targetPosition.aliasPosition);
				String setNumber = (executableSelections[i].originatingIsLargerResultSet ? "1" : "2"); //$NON-NLS-1$ //$NON-NLS-2$
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_SELECTING_POSITION_FROM_SET, originalPos, setNumber,
						targetPos);
			}
		}

		// this index is for the targetResultSet
		int targetRowIndex = 0;

		// we walk over the baseResultSet from the end until the start, so
		// its index is at the end of the set
		int baseRowIndex = largerBaseResultSet.getSize() - 1;

		// we keep going until we finished the baseResultSet
		while (baseRowIndex >= 0) {

			// idem for the other row index
			int otherRowIndex = smallerOtherResultSet.getSize() - 1;

			// note that for each baseRowIndex, we iterate over the otherResultSet
			while (otherRowIndex >= 0) {

				// we check if this combination of rows is a hit. We do not have a hit anymore once the 
				// targetRowIndex + 1 is over the maximum requested number of rows
				boolean hit = targetRowIndex < numberOfRequestedRows;

				// run over the comparisons and validate
				for (int comparisonIndex = 0; hit && comparisonIndex < executableComparisons.length; comparisonIndex++) {
					ExecutableComparison executableComparison = executableComparisons[comparisonIndex];

					// do something different depending on the type of comparison
					if (executableComparison.typeComparison) {
						// type comparison

						// get the MRIs
						URI leftMRI = executableComparison.largerLeftResultSet.getMri(baseRowIndex,
								executableComparison.positionInLargerLeftResultSet.aliasPosition);
						URI rightMRI = executableComparison.smallerRightResultSet.getMri(otherRowIndex,
								executableComparison.positionInSmallerRightResultSet.aliasPosition);

						if (leftMRI == null || rightMRI == null) {
							throw new BugException(BugMessages.UNEXPECTED_NULL_MRI);
						}

						hit = leftMRI.equals(rightMRI);

					} else {
						// attribute comparison

						// get the values
						Object leftValue = executableComparison.largerLeftResultSet.getAttributeValue(baseRowIndex,
								executableComparison.positionInLargerLeftResultSet.aliasPosition,
								executableComparison.positionInLargerLeftResultSet.attributePosition);

						Object rightValue = executableComparison.smallerRightResultSet.getAttributeValue(otherRowIndex,
								executableComparison.positionInSmallerRightResultSet.aliasPosition,
								executableComparison.positionInSmallerRightResultSet.attributePosition);

						// if one object is null
						if (leftValue == null || rightValue == null) {
							hit = AuxServices.compareValues(leftValue, executableComparison.operation, rightValue);

						} else {

							// we do something different with multi-valued attributes
							if (executableComparison.positionInLargerLeftResultSet.multivalued) {
								if (executableComparison.positionInSmallerRightResultSet.multivalued) {
									// two sets: the first pair that matches produces a hit
									Object[] leftValues = (Object[]) leftValue;
									Object[] rightValues = (Object[]) rightValue;

									// run over both sets and look for the first match
									hit = false;
									for (int i = 0; !hit && i < leftValues.length; i++) {
										for (int j = 0; !hit && j < rightValues.length; j++) {
											hit = AuxServices.compareValues(leftValues[i], executableComparison.operation, rightValues[j]);
										}
									}
								} else {
									// check if the right value exists in the left set
									Object[] leftValues = (Object[]) leftValue;

									// run over the left set and look for the first match
									hit = false;
									for (int i = 0; !hit && i < leftValues.length; i++) {
										hit = AuxServices.compareValues(leftValues[i], executableComparison.operation, rightValue);
									}
								}
							} else {
								if (executableComparison.positionInSmallerRightResultSet.multivalued) {
									// check if the left value exists in the right set
									Object[] rightValues = (Object[]) rightValue;

									// run over the right set and look for the first match
									hit = false;
									for (int i = 0; !hit && i < rightValues.length; i++) {
										hit = AuxServices.compareValues(rightValues[i], executableComparison.operation, leftValue);
									}

								} else {
									// no multivalued, just check values for a match
									hit = AuxServices.compareValues(leftValue, executableComparison.operation, rightValue);
								}
							}
						}
					}
				}

				// only if we have a hit, we construct a row in the target
				if (hit) {
					// check if not too large though
					if (targetRowIndex >= this.maxResultSetSize) {
						throw new QueryExecutionException(ApiMessages.RESULTSET_TOO_LARGE);
					}

					// add a row in the target result set
					targetResultSet.addEmptyEntry();

					// we enter the new data for each selection
					for (int selectionIndex = 0; selectionIndex < executableSelections.length; selectionIndex++) {
						ExecutableSelection executableSelection = executableSelections[selectionIndex];

						// do something different for aliases and attribute selections
						if (executableSelection.originatingPosition.attributePosition < 0) {
							// we have an alias selection

							// get the original value
							URI selectedMRI;
							if (executableSelection.originatingIsLargerResultSet) {
								selectedMRI = executableSelection.originatingResultSet.getMri(baseRowIndex,
										executableSelection.originatingPosition.aliasPosition);
							} else {
								selectedMRI = executableSelection.originatingResultSet.getMri(otherRowIndex,
										executableSelection.originatingPosition.aliasPosition);
							}

							// put it in the target row
							targetResultSet.setMri(targetRowIndex, executableSelection.targetPosition.aliasPosition, selectedMRI);

						} else {
							// we have an attribute selection

							// get the original value
							Object selectedAttributeValue;
							if (executableSelection.originatingIsLargerResultSet) {
								selectedAttributeValue = executableSelection.originatingResultSet.getAttributeValue(baseRowIndex,
										executableSelection.originatingPosition.aliasPosition,
										executableSelection.originatingPosition.attributePosition);
							} else {
								selectedAttributeValue = executableSelection.originatingResultSet.getAttributeValue(otherRowIndex,
										executableSelection.originatingPosition.aliasPosition,
										executableSelection.originatingPosition.attributePosition);
							}

							// put it in the target row
							targetResultSet.setAttributeValue(targetRowIndex, executableSelection.targetPosition.aliasPosition,
									executableSelection.targetPosition.attributePosition, selectedAttributeValue);
						}
					}

					// try to construct next row in the target result set
					targetRowIndex++;
				}

				// next row in the smaller original result set
				otherRowIndex--;
			}

			// we remove each base row at the end, so we reduce the amount of used memory to a minimum
			largerBaseResultSet.removeEntry(baseRowIndex);

			// next rwo in the larger base result set
			baseRowIndex--;
		}

		// solely for debugging purposes
		if (logger.isTraced(LogSeverity.DEBUG)) {
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_TARGET_RESULT_SET, "\n", targetResultSet); //$NON-NLS-1$
		}
	}
}
