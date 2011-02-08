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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.EmfHelper;
import org.eclipse.emf.query2.QueryExecutionException;
import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
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
import org.eclipse.emf.query2.internal.moinql.ast.LinksPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.NestedQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NodeQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NodeSelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.ResultUnion;
import org.eclipse.emf.query2.internal.moinql.ast.SelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.TypeAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.TypeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.TypeReference;
import org.eclipse.emf.query2.internal.moinql.ast.VirtualAtomicEntryReference;
import org.eclipse.emf.query2.internal.moinql.ast.WithEntry;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;


/**
 * The scheduling algorithms are described in the MQL design document.
 */
final public class SchedulerImpl implements Scheduler {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(SchedulerImpl.class);

	// we keep the memory FQL processor
	private final SpiFacilityQueryLanguage memFQL;

	// we keep the connection
	//    private final CoreConnection conn;

	// the relevant partitions are the ones which lead to actual scheduling
	private Set<URI> relevantPartitionPRIs;

	// and their partitions
	private Set<Resource> relevantPartitions;

	// auxiliary services
	private final AuxServices mqlAuxServices;

	// we keep the relevant data area descriptors for the session to which the MQL processor hangs
	//    private final Set<DataAreaDescriptor> sessionRelevantDataAreas;

	/**
	 * we only do a pre-optimization of a query if the number of relevant
	 * partition does not exceed this threshold.
	 */
	private int thresholdForNumberOfRelevantPartitionsForOptimization;

	/**
	 * per partitions, we only do a pre-optimization of a query if the number of
	 * elements does not exceed this threshold.
	 */
	private int thresholdForNumberOfElementsInPartitionForOptimization;

	private final EmfHelper emfHelper;

	//    public MQLSchedulerImpl( CoreConnection _conn, SpiFacilityQueryLanguage memFQL, MQLAuxServices mqlAuxServices, Set<DataAreaDescriptor> sessionRelevantDataAreas ) {
	//
	//        this.memFQL = memFQL;
	//        this.conn = _conn;
	//        this.mqlAuxServices = mqlAuxServices;
	//        this.sessionRelevantDataAreas = sessionRelevantDataAreas;
	//    }

	public SchedulerImpl(EmfHelper emfHelper, SpiFacilityQueryLanguage memFQL, AuxServices mqlAuxServices) {

		this.memFQL = memFQL;
		this.emfHelper = emfHelper;
		this.mqlAuxServices = mqlAuxServices;
		//        this.sessionRelevantDataAreas = sessionRelevantDataAreas;
	}

	/* ---------------- */
	/* Public methods */
	/* ---------------- */

	@Override
    public InternalQuery schedule(InternalQuery internalQuery, boolean schedulingWanted, boolean globalScopeIncluded,
			URI[] globalPartitionScope, URI[] globalContainerScope, int _thresholdForNumberOfRelevantPartitionsForOptimization,
			int _thresholdForNumberOfElementsInPartitionForOptimization) throws QueryExecutionException {

		this.thresholdForNumberOfRelevantPartitionsForOptimization = _thresholdForNumberOfRelevantPartitionsForOptimization;
		this.thresholdForNumberOfElementsInPartitionForOptimization = _thresholdForNumberOfElementsInPartitionForOptimization;

		// for the result
		InternalQuery resultQuery = null;

		/*
		 * We always make a (deep) clone of the prepared query to avoid
		 * inconsistencies between multiple executions of the same prepared
		 * query.
		 */
		resultQuery = this.mqlAuxServices.clone(internalQuery, true, new HashMap<AtomicEntry, AtomicEntry>());

		/*
		 * In order to execute a query, we have to translate CRIs into their
		 * associated PRIs. Moreover, we filter the scopes for relevant (i.e.
		 * existing and correct) partitions. Finally, we also incorporate the
		 * globally provided scope into the scope of each atomic entry.
		 */
		this.translateScopes(resultQuery, globalScopeIncluded, globalPartitionScope, globalContainerScope);

		/*
		 * Since scope translation may have changed the scope, we perform a
		 * reduction
		 */
		resultQuery = this.mqlAuxServices.reduceQueryAfterScopeChanges(resultQuery);

		if (resultQuery instanceof EmptyQuery) {
			return resultQuery;
		}

		// we perform the scheduling phases 
		if (schedulingWanted) {
			/*
			 * We adapt the relevantPartitions to the entire set of loaded
			 * partitions (i.e., beyond the dirty partitions) if all of the
			 * scopes are entirely inside the loaded partitions. Otherwise, the
			 * relevant partitions are the dirty partitions and the non-empty
			 * transient partitions.
			 */
			this.defineRelevantPartitions(resultQuery);

			/*
			 * We verify if the relevant partitions contain instances of the
			 * types in the atomic entry of the query. Per type, if no such
			 * instances can be found, we can simplify the scope. However, we
			 * only do this optimization if certain thresholds are met.
			 */
			this.optimizeRelevantPartitionScope(resultQuery);

			/*
			 * Since scope translation may have changed the scope, we perform a
			 * reduction
			 */
			resultQuery = this.mqlAuxServices.reduceQueryAfterScopeChanges(resultQuery);

			if (resultQuery instanceof EmptyQuery) {
				return resultQuery;
			}

			/* ---- The Actual Scheduling Algorithm ---- */

			/*
			 * (1) Construct a graph for each leaf query and build up a
			 * node-map, mapping the atomic entries to their nodes in the
			 * respective graphs
			 */
			Map<AtomicEntry, Node> nodeMap = this.buildNodeMap(resultQuery);

			/*
			 * (2) Apply the algorithm for breaking up the graph, cloning atomic
			 * entries and introducing the required type comparisons
			 */
			this.breakGraph(resultQuery, nodeMap);

			/*
			 * (3) Apply the splitting algorithm
			 */
			resultQuery = this.mqlAuxServices.split(resultQuery);

			/*
			 * (4) Apply the spreading algorithm, which transforms the leaf
			 * queries to the appropriate queries Q1, Q2, Q3, or Q1'. The basis
			 * for this is the nodeMap, which has the broken graphs
			 */
			resultQuery = this.spread(resultQuery, nodeMap);
		}

		/*
		 * post-processing
		 */
		resultQuery = this.postProcessing(resultQuery);

		return resultQuery;
	}

	/* ----------------- */
	/* Private methods */
	/* ----------------- */

	/**
	 * Bunch of post-processing transformations to simplify the resulting query
	 * as much as possible.
	 */
	private InternalQuery postProcessing(InternalQuery query) {

		/*
		 * Remove any mention of the transient partitions in scopes in leaf
		 * queries, which operate on true facility FQLs (and thus not in-memory)
		 */
		this.removeScopedTransientPartitionsInFacilityQueries(query);

		/*
		 * Remove unnecessary type comparisons in the leaf queries of this query
		 */
		this.mqlAuxServices.removeTypeComparisons(query);

		/*
		 * Since scope translation may have changed the scope, we perform a
		 * reduction
		 */
		InternalQuery resultQuery = this.mqlAuxServices.reduceQueryAfterScopeChanges(query);

		/*
		 * Compress the resulting query, by combining nodes between identical
		 * facilities. The idea is to compress type comparisons only. Once
		 * facilities can handle attribute comparisons, we should also compress
		 * those. Additionally, we compress unnecessary type comparisons within
		 * leaf queries
		 */
		return this.mqlAuxServices.compressNodeQueries(resultQuery);
	}

	/**
	 * If CRIs where used for scope specification, this method will translate
	 * them into partition scopes. Additionally, this method imposes the global
	 * scope on all atomic-entry-local scopes and filters scopes for
	 * relevant/existing partitions
	 */
	private void translateScopes(InternalQuery internalQuery, boolean globalScopeIncluded, URI[] globalPartitionScope,
			URI[] globalContainerScope) throws QueryExecutionException {

		try {
			if (logger.isTraced(LogSeverity.DEBUG)) {
				if (!globalScopeIncluded) {
					logger.trace(LogSeverity.DEBUG,
							FQLTraceMessages.MQL_PROCESSOR_USER_PROVIDED_GLOBAL_EXECUTION_SCOPE_IS_NOT_INCLUSIVE_AND_DEFINED_OVER);
				} else {
					logger.trace(LogSeverity.DEBUG,
							FQLTraceMessages.MQL_PROCESSOR_USER_PROVIDED_GLOBAL_EXECUTION_SCOPE_IS_INCLUSIVE_AND_DEFINED_OVER);
				}

				if (globalPartitionScope != null) {
					for (URI pri : globalPartitionScope) {
						logger.trace(LogSeverity.DEBUG, "Partition " + pri); //$NON-NLS-1$
					}
				}
				if (globalContainerScope != null) {
					for (URI cri : globalContainerScope) {
						logger.trace(LogSeverity.DEBUG, "Container " + cri); //$NON-NLS-1$
					}
				}
			}

			// first we normalize the global scope by translating the cri scope into partitions and verifying if 
			// each of these exist and is actually valid

			Set<URI> newGlobalPartitionScope = new HashSet<URI>();
			// translate if the global container scope is not null
			//            if ( globalContainerScope != null ) {
			//
			//                // we incorporate the partitions resulting from explicit container scopes
			//                for ( int i = 0; i < globalContainerScope.length; i++ ) {
			//                    URI cri = globalContainerScope[i];
			//                    if ( this.sessionRelevantDataAreas.contains( cri.getDataAreaDescriptor( ) ) ) {
			//                        // but only if relevant for the session
			//                        newGlobalPartitionScope.addAll( this.conn.getSession( ).getInnerPartitions( cri ) );
			//                    }
			//                }
			//            }

			// add the partition scope if it is not null
			if (globalPartitionScope != null) {
				for (int i = 0; i < globalPartitionScope.length; i++) {
					URI pri = globalPartitionScope[i];
					// only add if the partition actually exists
					if (this.emfHelper.existsResource(pri)) {
						newGlobalPartitionScope.add(pri);
					}
				}
			}
			// to avoid redoing the same nested query
			Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>();

			// now actually translate
			this.translateScopesInternalQuery(internalQuery, globalScopeIncluded, newGlobalPartitionScope, seenNestedQuery);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_TRANSLATING_AND_VERIFYING_SCOPE,
						"\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Translates contained scopes into partition scopes and verifies if the
	 * PRIs can be handled
	 */
	private void translateScopesInternalQuery(InternalQuery internalQuery, boolean globalScopeIncluded, Set<URI> globalPartitionScope,
			Set<NestedQuery> seenNestedQuery) throws QueryExecutionException {

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();
			for (InternalQuery operand : operands) {
				this.translateScopesInternalQuery(operand, globalScopeIncluded, globalPartitionScope, seenNestedQuery);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;
			this.translateScopesInternalQuery(nodeQuery.getFirstFromEntry(), globalScopeIncluded, globalPartitionScope, seenNestedQuery);
			this.translateScopesInternalQuery(nodeQuery.getSecondFromEntry(), globalScopeIncluded, globalPartitionScope, seenNestedQuery);

		} else if (internalQuery instanceof LeafQuery) {
			LeafQuery leafQuery = (LeafQuery) internalQuery;

			//            String queryFqlId = leafQuery.getFqlProcessor( ).getFacilityId( );

			// update the atomic entries
			List<AtomicEntry> fromEntries = leafQuery.getFromEntries();

			for (AtomicEntry fromEntry : fromEntries) {

				// get the partition and container scope
				Set<URI> partitionScope = fromEntry.getScope();
				//                Set<URI> containerScope = fromEntry.getContainerScope( );
				boolean included = fromEntry.isScopeInclusive();

				// we construct the new scope (purely based on partitions)
				Set<URI> newScope = new HashSet<URI>();

				// first, we handle the container scope if it exists
				//                if ( containerScope != null ) {
				//                    for ( CRI cri : containerScope ) {
				//                        DataAreaDescriptor dataAreaDescriptor = cri.getDataAreaDescriptor( );
				//                        if ( this.sessionRelevantDataAreas.contains( dataAreaDescriptor ) && dataAreaDescriptor.getFacilityId( ).equals( queryFqlId ) ) {
				//                            //we only add if this leaf query has the "right" facility ID and the cri resides in a relevant data area
				//                            newScope.addAll( this.conn.getSession( ).getInnerPartitions( cri ) );
				//                        }
				//                    }
				//                }

				// now handle partition scope if it exists
				if (partitionScope != null) {
					// Add the partition scope PRIs to the containedPartitionScope
					for (URI pri : partitionScope) {
						if (this.emfHelper.existsResource(pri)) {
							//we only add if this leaf query has the "right" facility ID, the pri resides in a relevant data area
							// and partition actually exists in some form or another (i.e. is not just an identifier)
							newScope.add(pri);
						}
					}
				}

				// finally, we have to intersect this with the global scope
				Set<URI> resultScope = this.mqlAuxServices.intersectScopes(newScope, included, globalPartitionScope, globalScopeIncluded);

				// set the new scope (in the case of fixed elements, it may reduce this set if the scope gets smaller)
				fromEntry.setScope(resultScope, null, included || globalScopeIncluded);
			}

			// work recursively deeper if necessary
			List<WithEntry> withEntries = leafQuery.getWithEntries();
			for (WithEntry withEntry : withEntries) {
				if (withEntry instanceof LinksPredicate) {
					NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();
					// but only if not already seen
					if (seenNestedQuery.add(nestedQuery)) {
						this.translateScopesInternalQuery(nestedQuery.getInternalQuery(), globalScopeIncluded, globalPartitionScope,
								seenNestedQuery);
					}
				}
			}

		} else if (internalQuery instanceof EmptyQuery) {
			// nothing to be done

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}
	}

	/**
	 * We verify for each relevant partition whether it has instances of the
	 * types in the atomic entries. Based on this calculation, we pre-optimize
	 * the scope of each atomic entry. This optimization can be expensive if
	 * there are too many relevant partitions. So, we stick to some predefined
	 * thresholds for the number of relevant partitions and their size (in
	 * elements)
	 */
	private void optimizeRelevantPartitionScope(InternalQuery internalQuery) throws QueryExecutionException {

		int numberOfRelevantPartitions = this.relevantPartitions.size();

		if (numberOfRelevantPartitions < this.thresholdForNumberOfRelevantPartitionsForOptimization) {
			if (logger.isTraced(LogSeverity.INFO)) {
				logger
						.trace(
								LogSeverity.INFO,
								FQLTraceMessages.MQL_PROCESSOR_OPTIMIZATION_OF_RELEVANT_PARTITION_SCOPE_BECAUSE_THE_NUMBER_OF_RELEVANT_PARTITIONS_SMALLER_THAN_THRESHOLD,
								numberOfRelevantPartitions, this.thresholdForNumberOfRelevantPartitionsForOptimization);
			}
			try {

				// We collect all atomic entries for non-structure types in this query
				Set<AtomicEntry> atomicEntries = new HashSet<AtomicEntry>();

				// for avoiding duplicate calculations of shared nested queries
				Set<NestedQuery> seenQueries = new HashSet<NestedQuery>();

				// we first collect the atomic entries of the query. We do this because there will likely
				// be much more partitions X elements than atomic entries. The algorithm only collects atomic
				// entries which represent MOF Classes (not structure types) 
				this.collectClassTypeAtomicEntries(internalQuery, seenQueries, atomicEntries);

				// for each relevant partition, update the map of possible dirty partitions
				if (atomicEntries.size() > 0) {
					for (Resource mp : this.relevantPartitions) {
						URI pri = mp.getURI();

						//                        Collection<Partitionable> elements = mp.getElements( );
						List<EObject> elements = this.emfHelper.getElementsInResource(mp);
						int elementsInPartition = elements.size();

						// we only optimize if there are not too many elements in the partition
						if (elementsInPartition < this.thresholdForNumberOfElementsInPartitionForOptimization) {

							// then run over all atomic entries
							for (AtomicEntry atomicEntry : atomicEntries) {
								Set<URI> scopeForAtomicEntry = atomicEntry.getScope();

								// first check if this partition is relevant at all for the known scope of this atomic entry
								boolean isRelevantPartition = (atomicEntry.isScopeInclusive() ? scopeForAtomicEntry.contains(pri)
										: !scopeForAtomicEntry.contains(pri));

								if (isRelevantPartition) {
									// if we are in scope, we check if at least one element is of the right type
									boolean elementOfAtomicEntryType = false;
									for (Iterator<EObject> partitionIterator = elements.iterator(); !elementOfAtomicEntryType
											&& partitionIterator.hasNext();) {

										EObject someElementInPartition = partitionIterator.next();

										// get the MRI type of the element
										//                                        MRI typeOfSomeElementInPartition = ( (CorePartitionable) ( ( (RefBaseObject) someElementInPartition ).refMetaObject( ) ) ).get___Mri( );
										URI typeOfSomeElementInPartition = EcoreUtil.getURI(someElementInPartition.eClass());

										// always true for Reflect::Element
										elementOfAtomicEntryType = atomicEntry.isReflectElement();

										// walk over all (sub)types of the atomic entry under investigation
										for (Iterator<URI> iter = atomicEntry.getClassMRIs().iterator(); !elementOfAtomicEntryType
												&& iter.hasNext();) {
											elementOfAtomicEntryType = typeOfSomeElementInPartition.equals(iter.next());
										}
									}

									// the partition is relevant as soon as one element is of the right type 
									isRelevantPartition = elementOfAtomicEntryType;
								}

								if (!isRelevantPartition) {
									// if the partition turns out not to be relevant, we actually adjust scope
									if (atomicEntry.isScopeInclusive()) {
										// if the scope was inclusive, we have to take out the partition
										scopeForAtomicEntry.remove(pri);
									} else {
										// if it was exclusive, we add the partition as one which is to-be-excluded
										scopeForAtomicEntry.add(pri);
									}
								}
							}
						} else if (logger.isTraced(LogSeverity.INFO)) {
							logger.trace(LogSeverity.INFO,
									FQLTraceMessages.MQL_PROCESSOR_NUMBER_OF_ELEMENTS_IN_PARTITION_EXCEEDS_THRESHOLD, elementsInPartition,
									mp, this.thresholdForNumberOfElementsInPartitionForOptimization);
						}
					}
				}

			} finally {
				// trace the intermediate result
				if (logger.isTraced(LogSeverity.DEBUG)) {
					logger.trace(LogSeverity.DEBUG,
							FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_OPTIMIZING_NON_DIRTY_PARTITION_SCOPE,
							"\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} else {
			if (logger.isTraced(LogSeverity.INFO)) {
				logger
						.trace(
								LogSeverity.INFO,
								FQLTraceMessages.MQL_PROCESSOR_NO_OPTIMIZATION_OF_RELEVANT_PARTITION_SCOPE_BECAUSE_THE_NUMBER_OF_RELEVANT_PARTITIONS_EXCEEDS_THRESHOLD,
								numberOfRelevantPartitions, this.thresholdForNumberOfRelevantPartitionsForOptimization);
			}
		}
	}

	/**
	 * Visits the internal query structure and collects all atomic entries of
	 * Class Type, which are not fixed sets
	 */
	private void collectClassTypeAtomicEntries(InternalQuery internalQuery, Set<NestedQuery> seenQueries, Set<AtomicEntry> atomicEntries) {

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			// go recursively down
			for (InternalQuery operand : operands) {
				this.collectClassTypeAtomicEntries(operand, seenQueries, atomicEntries);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			// go recursively down
			this.collectClassTypeAtomicEntries(nodeQuery.getFirstFromEntry(), seenQueries, atomicEntries);
			this.collectClassTypeAtomicEntries(nodeQuery.getSecondFromEntry(), seenQueries, atomicEntries);

		} else if (internalQuery instanceof EmptyQuery) {
			// do not do anything

		} else if (internalQuery instanceof LeafQuery) {
			// deal with leaf queries
			LeafQuery leafQuery = (LeafQuery) internalQuery;

			// collect the class and structure atomic entries
			for (AtomicEntry atomicEntry : leafQuery.getFromEntries()) {
				switch (atomicEntry.getTypeCategory()) {
				case CLASS:
					if (!(atomicEntry instanceof AtomicEntryFixedSet)) {
						// we do not optimize atomic entries for fixed sets, because usually, there will be lots of elements in the fixed set
						atomicEntries.add(atomicEntry);
					}
					break;
				case STRUCTURETYPE:
					// we ignore structure types because their scope will be adapt afterwards
					break;
				default:
					throw new BugException(BugMessages.UNKNOWN_ATOMIC_ENTRY_CATEGORY, atomicEntry.getTypeCategory());
				}
			}

			// look for possible nested queries in link predicates
			for (WithEntry withEntry : leafQuery.getWithEntries()) {

				// case analysis
				if (withEntry instanceof LinksPredicate) {
					// for LinksPredicates, we need to work recursively deeper
					NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

					// if not seen before
					if (seenQueries.add(nestedQuery)) {
						this.collectClassTypeAtomicEntries(nestedQuery.getInternalQuery(), seenQueries, atomicEntries);
					}
				}
			}

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}
	}

	/* ---- Important data structures for Scheduling ---- */

	/**
	 * The category of a node, i.e. entire scope non-dirty, entire scope dirty,
	 * or scope in both states.
	 */
	private enum NodeCategory {
		/* green */
		NONDIRTY,
		/* blue */
		DIRTY,
		/* red */
		MIXED
	}

	/**
	 * This data structure for a node is the essential building block of the
	 * graph which is constructed for each leaf query.
	 */
	final private class Node {

		@SuppressWarnings("synthetic-access")
		public Node(AtomicEntry atomicEntry) {

			//            this.facilityID = facilityID;
			this.atomicEntry = atomicEntry;
			this.connectedAssocEdges = new ArrayList<Edge>();
			// observe that the true dirty scope is always inclusive
			this.trueDirtyScope = SchedulerImpl.this.mqlAuxServices.intersectScopes(atomicEntry.getScope(), atomicEntry
					.isScopeInclusive(), SchedulerImpl.this.relevantPartitionPRIs, true);

			// now, make sure the trueDirtyScope of this atomic entry only contains PRIs of the provided facilityID
			//            for ( Iterator<URI> iterator = this.trueDirtyScope.iterator( ); iterator.hasNext( ); ) {
			//                URI pri = iterator.next( );
			//                if ( !( pri.getDataAreaDescriptor( ).getFacilityId( ).equals( facilityID ) ) ) {
			//                    iterator.remove( );
			//                }
			//            }

			switch (atomicEntry.getTypeCategory()) {
			case CLASS:
				this.isStructType = false;
				break;
			case STRUCTURETYPE:
				this.isStructType = true;
				break;
			default:
				throw new BugException(BugMessages.UNKNOWN_ATOMIC_ENTRY_CATEGORY, atomicEntry.getTypeCategory());
			}
		}

		// the trueDirtyScope is the part of an atomic entry's scope, which is a
		// subset of the dirty (or relevant) partitions
		final public Set<URI> trueDirtyScope;

		// the atomic entry itself
		final public AtomicEntry atomicEntry;

		// whether it is a structure type (structure types should not be
		// separated from their owners)
		final public boolean isStructType;

		// the original facility ID of the leaf query to which this atomic entry belongs
		//        final public String facilityID;

		/* ====== data set during graph construction ====== */

		// edges which are connected to this node
		public List<Edge> connectedAssocEdges;

		// the category of this node
		public NodeCategory nodeCategory = null;

		// indication whether the node is "simple", by default false
		public boolean simpleNode = false;

		/* ====== data set during graph break up ======= */

		// the graphType in which the node is participating. A node is
		// unassigned whenever graphType == null
		public GraphType graphType = null;

	}

	/**
	 * Represents an edge in the graph. An edge goes from a fromNode to a toNode
	 * and has dominance either in the fromNode or toNode with respect to the
	 * give assocPredicate.
	 */
	final private class Edge {

		public Edge(AssocPredicate assocPredicate, Node fromNode, Node toNode) {

			this.fromNode = fromNode;
			this.toNode = toNode;
			this.assocPredicate = assocPredicate;
			this.fromNodeDominant = assocPredicate.hasStorageAtFromEnd();
		}

		public Node fromNode;

		public Node toNode;

		public AssocPredicate assocPredicate;

		public boolean fromNodeDominant;
	}

	/**
	 * This enumeration allows us to distinguish between sub-graph types, one
	 * which is built by combining dominant dirty nodes, one which is build by
	 * combining dominant non-dirty nodes, one which is used for all other
	 * sub-graphs, consisting of maximally two nodes, and, finally, one which is
	 * used to denote the trivial graph of one node. See the MQLDesignDocument
	 * for details.
	 */
	private enum GraphType {
		DIRTYDOMINANT, NONDIRTYDOMINANT, REMNANT, SINGULAR
	}

	/* (1) ---- Graph and NodeMap construction ---- */

	/**
	 * This method constructs a map which maps atomic entries to their partially
	 * complete nodes.
	 */
	private Map<AtomicEntry, Node> buildNodeMap(InternalQuery internalQuery) {

		// we maintain a map from atomic entries to their scheduling nodes
		Map<AtomicEntry, Node> nodeMap = new HashMap<AtomicEntry, Node>();

		// this structure is used to avoid duplicate graph calculations on shared internal queries
		Set<NestedQuery> seenQueries = new HashSet<NestedQuery>();

		this.buildNodeMapInternalQuery(internalQuery, nodeMap, seenQueries);

		return nodeMap;
	}

	/**
	 * Recursive function which builds the nodeMap
	 */
	private void buildNodeMapInternalQuery(InternalQuery internalQuery, Map<AtomicEntry, Node> nodeMap, Set<NestedQuery> seenQueries) {

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			// go recursively down
			for (InternalQuery operand : operands) {
				this.buildNodeMapInternalQuery(operand, nodeMap, seenQueries);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			// go recursively down
			this.buildNodeMapInternalQuery(nodeQuery.getFirstFromEntry(), nodeMap, seenQueries);
			this.buildNodeMapInternalQuery(nodeQuery.getSecondFromEntry(), nodeMap, seenQueries);

		} else if (internalQuery instanceof EmptyQuery) {
			// do not do anything

		} else if (internalQuery instanceof LeafQuery) {
			// deal with leaf queries
			this.buildNodeMapLeafQuery((LeafQuery) internalQuery, nodeMap, seenQueries);

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}
	}

	/**
	 * Calculates the nodeMap for a leaf query
	 */
	private void buildNodeMapLeafQuery(LeafQuery leafQuery, Map<AtomicEntry, Node> nodeMap, Set<NestedQuery> seenQueries) {

		// obtain some important data from the leaf query
		List<LeafSelectEntry> selectEntries = leafQuery.getSelectEntries();
		List<WithEntry> withEntries = leafQuery.getWithEntries();
		List<AtomicEntry> atomicEntries = leafQuery.getFromEntries();

		// run over all the atomic entries and construct a node for each of them
		for (AtomicEntry atomicEntry : atomicEntries) {

			// sanity check - we should not have registered a node for the give atomic entry before
			if (nodeMap.containsKey(atomicEntry)) {
				throw new BugException(BugMessages.ATOMIC_ENTRY_ALREADY_IN_NODE_MAP);
			}

			// get the scope for the atomic entry and its size and inclusion properties
			Set<URI> atomicEntryScope = atomicEntry.getScope();
			int atomicEntryScopeSize = (atomicEntryScope == null ? 0 : atomicEntryScope.size());
			boolean included = atomicEntry.isScopeInclusive();

			// construct a node object for this atomic entry
			Node node = new Node(atomicEntry);

			// we need to know the size of the true dirty scope of this node
			int trueDirtyScopeSize = (node.trueDirtyScope == null ? 0 : node.trueDirtyScope.size());

			// determine the node category
			if (included) {

				// otherwise we look at the trueDirtyScopeSize to determine the node category
				if (trueDirtyScopeSize == 0) {
					// all non-dirty (or empty)
					node.nodeCategory = NodeCategory.NONDIRTY;
				} else if (trueDirtyScopeSize > 0 && trueDirtyScopeSize == atomicEntryScopeSize) {
					// all dirty
					node.nodeCategory = NodeCategory.DIRTY;
				} else if (trueDirtyScopeSize > 0 && trueDirtyScopeSize < atomicEntryScopeSize) {
					// both dirty and non-dirty
					node.nodeCategory = NodeCategory.MIXED;
				} else {
					// impossible
					throw new BugException(BugMessages.UNEXPECTED_TRUE_DIRTY_SCOPE_SIZE);
				}

			} else {
				// with an exclusive scope, we have less possibilities
				if (trueDirtyScopeSize == 0) {
					// if there is not dirty scope at all, we can classify the node as such
					node.nodeCategory = NodeCategory.NONDIRTY;

				} else {
					// in all other cases, we have mixed scope
					node.nodeCategory = NodeCategory.MIXED;
				}
			}

			// determine simplicity
			node.simpleNode = this.determineWhetherNodeIsSimple(selectEntries, withEntries, atomicEntry, node);

			// add to the nodeMap
			nodeMap.put(atomicEntry, node);
		}

		// now we run over all with entries and construct an edge for each assocPredicate
		for (WithEntry withEntry : withEntries) {

			if (withEntry instanceof AssocPredicate) {
				AssocPredicate assocPredicate = (AssocPredicate) withEntry;

				// obtain from node
				Node fromNode = nodeMap.get(assocPredicate.getFromType().getAtomicEntry());

				// sanity check
				if (fromNode == null) {
					throw new BugException(BugMessages.ATOMIC_ETNRY_NOT_FOUND_IN_NODE_MAP);
				}

				// obtain to node
				Node toNode = nodeMap.get(assocPredicate.getToType().getAtomicEntry());

				// sanity check
				if (toNode == null) {
					throw new BugException(BugMessages.ATOMIC_ETNRY_NOT_FOUND_IN_NODE_MAP);
				}

				// construct the edge
				Edge newEdge = new Edge(assocPredicate, fromNode, toNode);

				// add edge on both nodes
				fromNode.connectedAssocEdges.add(newEdge);
				toNode.connectedAssocEdges.add(newEdge);

			} else if (withEntry instanceof LinksPredicate) {
				// in the case of link predicates, we work recursively on the nested query
				NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

				// but only if we have not already seen this nested query
				if (seenQueries.add(nestedQuery)) {
					// recursively build nodeMap
					this.buildNodeMapInternalQuery(nestedQuery.getInternalQuery(), nodeMap, seenQueries);
				}
			}
		}
	}

	/**
	 * determine whether this atomic entry is "simple", i.e. 1) no attribute
	 * selections 2) no where conditions 3) no attribute comparison with another
	 * attribute comparison 4) no involvement in a links predicate 5) no assoc
	 * predicate towards a structure type
	 */
	private boolean determineWhetherNodeIsSimple(List<LeafSelectEntry> selectEntries, List<WithEntry> withEntries, AtomicEntry atomicEntry,
			Node node) {

		// the where condition should be null and we are not dealing with a structure-typed node
		boolean isSimple = atomicEntry.getWhereClause() == null && !node.isStructType;

		// examine the select entries
		for (Iterator<LeafSelectEntry> iter = selectEntries.iterator(); isSimple && iter.hasNext();) {
			AtomicEntryReference atomicEntryReference = iter.next().getAtomicEntryReference();

			// check if the atomic entry is identical to the one under examination
			if (atomicEntryReference.getAtomicEntry().equals(atomicEntry)) {
				// check if it actually selects an attribute
				isSimple = !(atomicEntryReference instanceof AtomicAttrReference);
			}
		}

		// examine the with entries
		for (Iterator<WithEntry> iter = withEntries.iterator(); isSimple && iter.hasNext();) {
			WithEntry withEntry = iter.next();

			// case analysis
			if (withEntry instanceof AttrComparison) {
				AttrComparison attrComparison = (AttrComparison) withEntry;
				TypeAttrReference leftAttrReference = attrComparison.getLeftAttr();
				TypeAttrReference rightAttrReference = attrComparison.getRightAttr();

				// check if one of the attribute selections is happening on
				// the atomic entry under investigation
				isSimple = !(leftAttrReference.getAtomicEntry().equals(atomicEntry) || rightAttrReference.getAtomicEntry().equals(
						atomicEntry));

			} else if (withEntry instanceof LinksPredicate) {
				// check if the atomic entry is involved in this Links predicate
				isSimple = !(((LinksPredicate) withEntry).getFromType().getAtomicEntry().equals(atomicEntry));

			} else if (withEntry instanceof AssocPredicate) {

				AssocPredicate assocPredicate = (AssocPredicate) withEntry;
				AtomicEntry leftAtomicEntry = assocPredicate.getFromType().getAtomicEntry();
				AtomicEntry rightAtomicEntry = assocPredicate.getToType().getAtomicEntry();

				boolean isLeft = leftAtomicEntry.equals(atomicEntry);
				boolean isRight = rightAtomicEntry.equals(atomicEntry);

				// only relevant if the atomic entry under investigation is on the left or right
				if (isLeft) {
					// we loose simplicity if the left and right atomic entry are both equal to the atomic entry
					// under investigation. Moreover, we do not want the other side to be a structure-typed atomic entry
					isSimple = !isRight && rightAtomicEntry.getTypeCategory().equals(SpiFqlFromTypeCategory.CLASS);
				} else if (isRight) {
					// idem on other side
					isSimple = leftAtomicEntry.getTypeCategory().equals(SpiFqlFromTypeCategory.CLASS);
				}
			}
		}

		return isSimple;
	}

	/* (2) ---- Graph break-up algorithm ---- */

	/**
	 * The graph break-up algorithm produces an updated version of the
	 * internalQuery where each leaf query has potentially been taken apart by
	 * cloning and the introduction of alias comparisons. It completes the node
	 * data such that the spreader can do its work.
	 */
	private void breakGraph(InternalQuery internalQuery, Map<AtomicEntry, Node> nodeMap) {

		try {
			// this structure is used to avoid duplicate changes on shared internal queries
			Set<NestedQuery> seenQueries = new HashSet<NestedQuery>();

			this.breakGraphInternalQuery(internalQuery, nodeMap, seenQueries);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_BREAKING_UP_ACCORDING_TO_GRAPH,
						"\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Works recursively down until a leaf query is reached. We return true if
	 * the internal query was actually a leaf query and can be kept together
	 */
	private boolean breakGraphInternalQuery(InternalQuery internalQuery, Map<AtomicEntry, Node> nodeMap, Set<NestedQuery> seenQueries) {

		// we use this boolean to inform whether we have a leaf query which is kept together
		boolean queryKeptTogether = false;

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			// go recursively down
			for (InternalQuery operand : operands) {
				this.breakGraphInternalQuery(operand, nodeMap, seenQueries);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			// go recursively down
			this.breakGraphInternalQuery(nodeQuery.getFirstFromEntry(), nodeMap, seenQueries);
			this.breakGraphInternalQuery(nodeQuery.getSecondFromEntry(), nodeMap, seenQueries);

		} else if (internalQuery instanceof EmptyQuery) {
			// do not do anything

		} else if (internalQuery instanceof LeafQuery) {
			// deal with leaf queries
			queryKeptTogether = this.breakGraphLeafQuery((LeafQuery) internalQuery, nodeMap, seenQueries);

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		return queryKeptTogether;
	}

	/**
	 * Perform the graph breaking algorithm on the leaf query
	 */
	private boolean breakGraphLeafQuery(LeafQuery leafQuery, Map<AtomicEntry, Node> nodeMap, Set<NestedQuery> seenQueries) {

		// get the atomic entries of the leaf query
		List<AtomicEntry> atomicEntries = leafQuery.getFromEntries();

		// break up the graph and register if the leaf query was kept together.
		// We use this boolean to keep track whether this leaf query can be kept
		// together after applying spreading.
		boolean queryKeptTogether = this.breakGraphForLeafQuery(leafQuery, atomicEntries, nodeMap);

		// fetch the with entries and and do recursive work on link predicates
		for (WithEntry withEntry : leafQuery.getWithEntries()) {

			// we are only interested in link predicates
			if (withEntry instanceof LinksPredicate) {
				LinksPredicate linksPredicate = (LinksPredicate) withEntry;

				// get the nested query
				NestedQuery nestedQuery = linksPredicate.getNestedQuery();

				// work recursively down if this is not already done
				if (seenQueries.add(nestedQuery)) {

					// get the internal query which is nested
					InternalQuery internalQuery = nestedQuery.getInternalQuery();

					boolean nestedQueryKeptTogether = this.breakGraphInternalQuery(internalQuery, nodeMap, seenQueries);

					// by default, nested queries are reset. However, if the nested query and the encompassing
					// query are "kept together" and will remain leaf queries, *and* they are handled in the same FQL
					// we can set the reset flag to false
					if (queryKeptTogether && nestedQueryKeptTogether) {

						SpiFacilityQueryLanguage thisFQLProcessor = leafQuery.getFqlProcessor();

						// note that if the nested query can be kept together, it is at least a leaf query
						SpiFacilityQueryLanguage nestedFQLProcessor = ((LeafQuery) internalQuery).getFqlProcessor();

						// reset is false if the both processors are equal
						boolean reset = !thisFQLProcessor.getFacilityId().equals(nestedFQLProcessor.getFacilityId());

						nestedQuery.setReset(reset);
					}
				}
			}
		}

		// return whether this query is kept together
		return queryKeptTogether;
	}

	/**
	 * We need this record for the results searching for a largest graph
	 */
	public static final class GraphSearchResult {

		// the graph is simply kept as a list of nodes
		public List<Node> graph;

		// the graph size is measured by the number of edges (!)
		public int graphSize;

		// the graph type is either dirtyDominant, nonDirtyDominant, Remnant, or Singular
		// As an invariant we have that the graphType of all nodes in the graph is identical
		// to this graph type
		public GraphType graphType;
	}

	/**
	 * Given a node and an edge, we obtain the other node for that edge. Throws
	 * a bug exception if the node does not participate in the edge.
	 */
	private Node obtainConnectedNodeInEdge(Node node, Edge edge) {

		Node connectedNode;
		if (node.equals(edge.fromNode)) {
			connectedNode = edge.toNode;
		} else if (node.equals(edge.toNode)) {
			connectedNode = edge.fromNode;
		} else {
			throw new BugException(BugMessages.PROVIDED_NODE_WAS_NOT_PARTICIPATING_IN_EDGE);
		}
		return connectedNode;
	}

	/**
	 * This method recursively breaks down a leaf query by introducing cloned
	 * atomic entries, nodes and extra type comparisons. The set of atomic
	 * entries which is still to be processed is kept in the
	 * unAssignedAtomicEntries list. We first start searching for the two
	 * special graph types (dirtyDominant and nonDirtyDominant) and if that
	 * leads to no result, we look for pairs of remnant graph types
	 */
	@SuppressWarnings("null")
	private boolean breakGraphForLeafQuery(LeafQuery leafQuery, List<AtomicEntry> unAssignedAtomicEntries, Map<AtomicEntry, Node> nodeMap) {

		// record the largest subgraph as a list of nodes
		List<Node> subGraph = new ArrayList<Node>();

		// the initial size of the graph (in number of edges) is 0
		int graphSize = -1;

		// the initial type of the graph is null
		GraphType graphType = null;

		// we keep the start node of the largest non-remnant graph (if foudn)
		Node startNodeOfGraph = null;

		// walk over all unassigned atomic entries and try to find a largest non-remnant graph
		for (AtomicEntry unAssignedAtomicEntry : unAssignedAtomicEntries) {
			// we try to build a graph starting from each unassigned atomic entry
			Node startNode = nodeMap.get(unAssignedAtomicEntry);

			GraphSearchResult graphResult = null;

			// we only start looking for a graph with non-structure-type nodes
			if (!startNode.isStructType) {
				graphResult = this.findLargestNonRemnantGraph(startNode);
			}

			if (graphResult != null) {
				// if we actually found a graph, check if it is larger than current largest
				boolean betterGraph = graphResult.graphSize > graphSize;
				if (betterGraph) {
					// we have found a better graph, so take it over
					subGraph = graphResult.graph;
					graphSize = graphResult.graphSize;
					graphType = graphResult.graphType;
					startNodeOfGraph = startNode;
				}
			}
		}

		// boolean for keeping track on whether the query will be broken
		boolean queryKeptTogether;

		if (graphType != null) {
			// we found a largest non-remnant graph

			// detach the sub-graph within the leafQuery
			List<AtomicEntry> newUnAssignedAtomicEntries = this.detachSubGraphFromLeafQuery(leafQuery, nodeMap, subGraph, graphType);

			if (graphType.equals(GraphType.SINGULAR)) {
				// in the case of a singular graph, the query is kept together if the start node is not of "mixed" nature
				queryKeptTogether = !startNodeOfGraph.nodeCategory.equals(NodeCategory.MIXED);
			} else {
				// in the case of a non-singular graphType, the query is definitely kept together whenever no unAssignedAtomicEntries are left over
				queryKeptTogether = newUnAssignedAtomicEntries.isEmpty();
			}

			// if we have no unAssignedAtomicEntries left, we have reached the base case
			if (!newUnAssignedAtomicEntries.isEmpty()) {
				// otherwise, we have to recursively keep processing the unassigned atomic entries and the query is not kept together anymore
				this.breakGraphForLeafQuery(leafQuery, newUnAssignedAtomicEntries, nodeMap);
			}

		} else {
			// no largest non-remnant graph found, so now search for remnant graphs
			queryKeptTogether = this.breakUpAndLookForRemnantGraph(leafQuery, unAssignedAtomicEntries, nodeMap);
		}

		// return whether the query was broken or not
		return queryKeptTogether;
	}

	/**
	 * This method searches a largest non remnant graph based on the provided
	 * startNode. This can only be done whenever the start node is NONDIRTY or
	 * DIRTY, but not MIXED. The algorithmic description is provided in the MQL
	 * design document. If no largest graph was found, the method returns null.
	 */
	private GraphSearchResult findLargestNonRemnantGraph(Node startNode) {

		// for the result
		GraphSearchResult result = null;

		NodeCategory startNodeCategory = startNode.nodeCategory;

		if (!startNodeCategory.equals(NodeCategory.MIXED)) {

			// we need this to avoid duplicatively adding nodes (a graph is encoded as a list)
			Set<Node> seenNodes = new HashSet<Node>();

			// to keep the result graph
			List<Node> graph = new ArrayList<Node>();

			// this set keeps track of the which edges have been processed
			Set<Edge> seenEdges = new HashSet<Edge>();

			boolean nonDirty = startNodeCategory.equals(NodeCategory.NONDIRTY);

			// recursively walk the edges and construct a result graph (if possible)
			int numberOfEdgesInGraph = this.walkGraphEdges(startNode, seenNodes, graph, seenEdges, nonDirty);

			// construct result, but only if any nodes where ever added at all.
			if (graph.size() > 0) {
				// we still have to add the startNode (not considered in the recursive call to walkGraphEdges) if
				// it was not added before (because of a cycle)
				this.addConnectedNode(seenNodes, graph, startNode);

				// build the actual result
				result = new GraphSearchResult();
				result.graph = graph;
				result.graphSize = numberOfEdgesInGraph;
				if (numberOfEdgesInGraph == 0) {
					//                    throw new IllegalArgumentException();
					result.graphType = GraphType.SINGULAR;
				} else {
					switch (startNodeCategory) {
					case DIRTY:
						result.graphType = GraphType.DIRTYDOMINANT;
						break;
					case NONDIRTY:
						result.graphType = GraphType.NONDIRTYDOMINANT;
						break;
					default:
						throw new BugException(BugMessages.UNEXPECTED_NODE_CATEGORY, startNodeCategory);
					}
				}
			}
		}
		return result;
	}

	/**
	 * This is a recursive method which collects the nodes which can be part of
	 * the resulting graph. It does this by walking over all edges starting from
	 * a given node. The method returns the size of the constructed graph in
	 * terms of its edges.
	 */
	private int walkGraphEdges(Node node, Set<Node> seenNodes, List<Node> graph, Set<Edge> seenEdges, boolean nonDirtyOnly) {

		int numberOfEdgesInGraph = 0;

		// scan all edges for possible graph construction
		for (Edge connectedAssocEdge : node.connectedAssocEdges) {

			// we only process an edge if has not been seen before, but do not count the edge unless the node is added as well
			if (seenEdges.add(connectedAssocEdge)) {

				// and also determine the connected node (on the other side)
				Node connectedNode = this.obtainConnectedNodeInEdge(node, connectedAssocEdge);

				// if the connectedNode refers to a structure type, we always
				// include it and go recursively down
				if (connectedNode.isStructType) {

					throw new IllegalArgumentException();
					// add the node, but not the edge
					//                    this.addConnectedNode( seenNodes, graph, connectedNode );
					//
					//                    // continue recursively
					//                    this.walkGraphEdges( connectedNode, seenNodes, graph, seenEdges, nonDirtyOnly );

				} else {
					// check if we have storage on the side of the node
					boolean storageOnNodeSide = (node.equals(connectedAssocEdge.fromNode) ? connectedAssocEdge.fromNodeDominant
							: !connectedAssocEdge.fromNodeDominant);

					if (storageOnNodeSide) {
						// This is the case where storage is on the node's side (not the connected node's side)
						switch (connectedNode.nodeCategory) {
						case DIRTY:
							// the connected node is DIRTY
							if (!nonDirtyOnly) {
								// the original node is also DIRTY, so add the connection
								this.addConnectedNode(seenNodes, graph, connectedNode);
								// add the edge (to register its true size)
								numberOfEdgesInGraph++;

								// continue recursively
								numberOfEdgesInGraph += this.walkGraphEdges(connectedNode, seenNodes, graph, seenEdges, nonDirtyOnly);
							} else {
								// the connected node is NON-DIRTY, so, we only add if the connected node is simple and we do not process recursively
								if (connectedNode.simpleNode) {
									this.addConnectedNode(seenNodes, graph, connectedNode);
									// add the edge (to register its true size)
									numberOfEdgesInGraph++;
								}
							}

							break;
						case NONDIRTY:
							// the connected node is NON-DIRTY. In that case, we definitely have to add the edge
							this.addConnectedNode(seenNodes, graph, connectedNode);
							// add the edge (to register its true size)
							numberOfEdgesInGraph++;

							// But we only continue recursively whenever the originating node is nonDirty too
							if (nonDirtyOnly) {
								numberOfEdgesInGraph += this.walkGraphEdges(connectedNode, seenNodes, graph, seenEdges, nonDirtyOnly);
							}

							break;
						case MIXED:
							// the connected node is MIXED

							if (!nonDirtyOnly) {
								// whenever the connected node is DIRTY, we add the edge, but do not walk recursively
								this.addConnectedNode(seenNodes, graph, connectedNode);
								// add the edge (to register its true size)
								numberOfEdgesInGraph++;

							} else {
								// whenever the connected node is NON-DIRTY, we only add if it is simple
								if (connectedNode.simpleNode) {
									this.addConnectedNode(seenNodes, graph, connectedNode);
									// add the edge (to register its true size)
									numberOfEdgesInGraph++;
								}
							}

							break;
						default:
							throw new BugException(BugMessages.UNEXPECTED_NODE_CATEGORY, connectedNode.nodeCategory);
						}
					} else {
						// whenever we do not have storage on the node's side, we *have* to have a node of the same type as
						// the current node, otherwise, we have reached a boundary for the graph
						boolean nodeCategoryConformsMode = (nonDirtyOnly ? connectedNode.nodeCategory.equals(NodeCategory.NONDIRTY)
								: connectedNode.nodeCategory.equals(NodeCategory.DIRTY));

						// only add and process recursively whenever the connected node is of the same kind
						if (nodeCategoryConformsMode) {
							// add node to found graph
							this.addConnectedNode(seenNodes, graph, connectedNode);
							// add the edge (to register its true size)
							numberOfEdgesInGraph++;

							// continue recursively
							numberOfEdgesInGraph += this.walkGraphEdges(connectedNode, seenNodes, graph, seenEdges, nonDirtyOnly);
						}
					}
				}
			}
		}

		return numberOfEdgesInGraph;
	}

	/**
	 * Adds the connected node to the graph
	 */
	private void addConnectedNode(Set<Node> seenNodes, List<Node> graph, Node connectedNode) {

		// set the node as seen if not already seen
		if (seenNodes.add(connectedNode)) {
			// add the node to the graph if it was not seen before
			graph.add(connectedNode);
		}
	}

	/**
	 * This method constructs remnant graphs from the remaining
	 * unAssignedAtomicEntries. It does this by pairwise combining
	 */
	private boolean breakUpAndLookForRemnantGraph(LeafQuery leafQuery, List<AtomicEntry> unAssignedAtomicEntries,
			Map<AtomicEntry, Node> nodeMap) {

		// take the first atomic entry and associated atomic entry which exists in the list of
		// entries still to be done. All possibly attached structure type nodes are also included.
		// These will be the new sub-graph.
		List<Node> subGraph = new ArrayList<Node>();

		// determine the first non-structure typed atomic entry
		Node firstUnassignedNode = null;

		// we iterate and get this first non-structure typed atomic entry
		Iterator<AtomicEntry> unAssignedAtomicEntryIterator = unAssignedAtomicEntries.iterator();
		for (; firstUnassignedNode == null && unAssignedAtomicEntryIterator.hasNext();) {
			Node node = nodeMap.get(unAssignedAtomicEntryIterator.next());
			if (!node.isStructType) {
				// if we do not have a structure typed node, we set the secondUnassignedNode
				firstUnassignedNode = node;
				// the first unassigned node is definitely part of the subgraph
				subGraph.add(firstUnassignedNode);
			}
		}

		if (firstUnassignedNode == null) {
			// impossible
			throw new BugException(BugMessages.COULD_NOT_OBTAIN_CLASS_BASED_NODE_IN_REMNANT_GRAPH);
		}

		// look for attached nodes and register a non-structure typed node (if it exists - not the case when
		// all remaining nodes are structure typed). However, all structure-typed attached nodes, should be 
		// added and recursively processed
		Node secondUnassignedNode = null;

		for (Iterator<Edge> iterator = firstUnassignedNode.connectedAssocEdges.iterator(); secondUnassignedNode == null
				&& iterator.hasNext();) {
			Edge connectedAssocEdge = iterator.next();

			// the connected node
			Node connectedNode = this.obtainConnectedNodeInEdge(firstUnassignedNode, connectedAssocEdge);

			if (!connectedNode.isStructType) {
				// if we do not have a structure typed node, we set the secondUnassignedNode
				secondUnassignedNode = connectedNode;
				// and add it to the graph
				subGraph.add(secondUnassignedNode);
			}
		}

		// We now determine the graph type, which can be remnant or singular at this point
		GraphType graphType;
		if (secondUnassignedNode == null || firstUnassignedNode.equals(secondUnassignedNode)) {
			graphType = GraphType.SINGULAR;
			// Collect all structure-typed attached nodes for the firstUnassignedNode
			this.addAttachedStructureTypeNodes(firstUnassignedNode, subGraph, new HashSet<Node>());
		} else {
			graphType = GraphType.REMNANT;
			// Collect all structure-typed attached nodes for both participating nodes
			Set<Node> seenNodes = new HashSet<Node>();
			this.addAttachedStructureTypeNodes(firstUnassignedNode, subGraph, seenNodes);
			this.addAttachedStructureTypeNodes(secondUnassignedNode, subGraph, seenNodes);
		}

		// detach the sub-graph within the leafQuery and set its graph type
		List<AtomicEntry> newUnAssignedAtomicEntries = this.detachSubGraphFromLeafQuery(leafQuery, nodeMap, subGraph, graphType);

		boolean queryKeptTogether;
		if (graphType.equals(GraphType.SINGULAR)) {
			// in the case of a singular graph, the query is kept together if the firstUnassignedNode node is not of "mixed" nature
			queryKeptTogether = !firstUnassignedNode.nodeCategory.equals(NodeCategory.MIXED);
		} else {
			// in the case of a non-singular graphType, the query is definitely kept together whenever no unAssignedAtomicEntries are left over
			queryKeptTogether = newUnAssignedAtomicEntries.isEmpty();
		}

		// if we have no unAssignedAtomicEntries left, we have reached the base case
		if (!newUnAssignedAtomicEntries.isEmpty()) {
			// otherwise, we have to recursively keep processing the unassigned atomic entries
			this.breakUpAndLookForRemnantGraph(leafQuery, newUnAssignedAtomicEntries, nodeMap);
		}

		return queryKeptTogether;
	}

	/**
	 * This method recursively adds all connected structure typed nodes to the
	 * node in the subgraph.
	 */
	private void addAttachedStructureTypeNodes(Node node, List<Node> subGraph, Set<Node> seenNodes) {

		for (Edge connectedAssocEdge : node.connectedAssocEdges) {

			Node connectedNode = this.obtainConnectedNodeInEdge(node, connectedAssocEdge);

			// only look for structure typed nodes, which have not been seen before
			if (connectedNode.isStructType && seenNodes.add(connectedNode)) {
				// add it to the graph
				subGraph.add(connectedNode);
				// go recursively down
				this.addAttachedStructureTypeNodes(connectedNode, subGraph, seenNodes);
			}
		}
	}

	/**
	 * This method effectively separates the subgraph from the original. The
	 * basis for this is that nodes from the original will not have its
	 * graphType registered. For each separation, the node belonging to the
	 * subgraph is cloned and compared to the original with a type comparison.
	 * It returns a new list of atomic entries which are still unassigned.
	 */
	private List<AtomicEntry> detachSubGraphFromLeafQuery(LeafQuery leafQuery, Map<AtomicEntry, Node> nodeMap, List<Node> subGraph,
			GraphType graphType) {

		// we need both the atomicEntries and withEntries
		List<AtomicEntry> atomicEntries = leafQuery.getFromEntries();
		List<WithEntry> withEntries = leafQuery.getWithEntries();

		// first we assign the graphType to the subGraph nodes
		for (Node node : subGraph) {
			node.graphType = graphType;
		}

		// Then we define the new list of unAssignedAtomicEnttries. It includes atomic
		// entries left in the leaf query who do not yet have been given a graph type.
		// In the actual graph separation algorithm, this list of unAssignedAtomicEntries
		// may get larger (because of cloning entries)
		List<AtomicEntry> unAssignedAtomicEntries = new ArrayList<AtomicEntry>();
		for (AtomicEntry entry : atomicEntries) {
			Node entryNode = nodeMap.get(entry);
			if (entryNode.graphType == null) {
				unAssignedAtomicEntries.add(entry);
			}
		}

		// for each node of the subGraph, we check all neighboring nodes and for each which
		// is not assigned, we simply detach it by cloning the original node, adapting and 
		// introducing the appropriate type comparison, and finally, redirecting the assoc
		// predicate and edge. Moreover, we extend the node map for the cloned atomic entry
		for (Node node : subGraph) {

			for (Iterator<Edge> edgesIter = node.connectedAssocEdges.iterator(); edgesIter.hasNext();) {
				Edge connectingEdge = edgesIter.next();

				// obtain the connected node
				Node connectedNode = this.obtainConnectedNodeInEdge(node, connectingEdge);

				// only if the connectingNode is not yet assigned
				if (connectedNode.graphType == null) {

					// we first clone the original
					Node clonedNode = this.cloneNodeAndRedirectEdge(node, connectingEdge);

					// we remove the edge from the original node
					edgesIter.remove();

					// add the cloned atomic as one which is unassigned
					unAssignedAtomicEntries.add(clonedNode.atomicEntry);

					// and also add to the leaf query
					atomicEntries.add(clonedNode.atomicEntry);

					// put in the node map
					nodeMap.put(clonedNode.atomicEntry, clonedNode);

					// add the type comparison
					withEntries.add(new TypeComparison(new AtomicEntryReference(node.atomicEntry), new AtomicEntryReference(
							clonedNode.atomicEntry)));
				}
			}
		}

		return unAssignedAtomicEntries;
	}

	/**
	 * We clone the original node, and redirect the edge and association
	 * predicate to it.
	 */
	private Node cloneNodeAndRedirectEdge(Node originalNode, Edge edgeForNode) {

		// clone the original atomic entry
		AtomicEntry clonedAtomicEntry = this.mqlAuxServices.cloneAtomicEntry(originalNode.atomicEntry);

		// construct the cloned node
		Node clonedNode = new Node(clonedAtomicEntry);

		/*
		 * redirect the association predicate
		 */

		// check if the connected node is on the from position
		boolean originalNodeOnFromPosition = originalNode.equals(edgeForNode.fromNode);

		// get the right atomic entry reference first
		AtomicEntryReference atomicEntryReferenceOfOriginalNode = (originalNodeOnFromPosition ? edgeForNode.assocPredicate.getFromType()
				: edgeForNode.assocPredicate.getToType());

		// reset the reference of the original node to the cloned atomic entry
		atomicEntryReferenceOfOriginalNode.setAtomicEntry(clonedAtomicEntry);

		/*
		 * redirect the edge
		 */

		// redirect the connected side of the edge to the clone
		if (originalNodeOnFromPosition) {
			edgeForNode.fromNode = clonedNode;

		} else {
			edgeForNode.toNode = clonedNode;
		}

		// add the edge also to the clonedNode (it is removed from the originally connected node)
		clonedNode.connectedAssocEdges.add(edgeForNode);

		// the cloned node takes over the category and the simplification properties,
		// but *not* the graph type (as this is still to be computed)
		clonedNode.nodeCategory = originalNode.nodeCategory;
		clonedNode.simpleNode = originalNode.simpleNode;

		// return result
		return clonedNode;
	}

	/* (4) ---- Spreading the split query ---- */

	/**
	 * The details of the spreader are described in the MQL design document. It
	 * exploits the graph type assignments in the nodes belonging to each of the
	 * atomic entries in the leaf queries.
	 */
	private InternalQuery spread(InternalQuery internalQuery, Map<AtomicEntry, Node> nodeMap) throws QueryExecutionException {

		InternalQuery newInternalQuery = null;

		try {

			// this structure is used to avoid duplicate changes on shared internal queries
			Set<NestedQuery> seenQueries = new HashSet<NestedQuery>();

			// select entry map required because nested select entries may disappear and be replaced
			Map<SelectEntry, SelectEntry> selectEntryMap = new HashMap<SelectEntry, SelectEntry>();

			newInternalQuery = this.spreadInternalQuery(internalQuery, nodeMap, seenQueries, selectEntryMap);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_QUERY_SPREADING,
						"\n", (newInternalQuery == null ? "NULL query" : newInternalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return newInternalQuery;
	}

	/**
	 * Spreads the internal query by recursively going down to leaf queries
	 */
	private InternalQuery spreadInternalQuery(InternalQuery internalQuery, Map<AtomicEntry, Node> nodeMap, Set<NestedQuery> seenQueries,
			Map<SelectEntry, SelectEntry> selectEntryMap) throws QueryExecutionException {

		// for keeping the result
		InternalQuery spreadQuery = null;
		AliasName aliasName = internalQuery.getAliasName();

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();
			List<InternalQuery> newOperands = new ArrayList<InternalQuery>(operands.size());

			// go recursively down
			for (InternalQuery operand : operands) {
				newOperands.add(this.spreadInternalQuery(operand, nodeMap, seenQueries, selectEntryMap));
			}

			spreadQuery = new ResultUnion(aliasName, newOperands);

		} else if (internalQuery instanceof NodeQuery) {
			// get the data from the node query
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			List<ComparisonWithEntry> withEntries = nodeQuery.getWithEntries();
			List<NodeSelectEntry> selectEntries = nodeQuery.getSelectEntries();

			// go recursively down
			InternalQuery newFirstFromEntry = this.spreadInternalQuery(nodeQuery.getFirstFromEntry(), nodeMap, seenQueries, selectEntryMap);
			InternalQuery newSecondFromEntry = this.spreadInternalQuery(nodeQuery.getSecondFromEntry(), nodeMap, seenQueries,
					selectEntryMap);

			// update with the select entry map
			this.mqlAuxServices.redirectTypeReferencesForNodeQuery(selectEntries, withEntries, selectEntryMap);

			spreadQuery = NodeQuery.construct(aliasName, newFirstFromEntry, newSecondFromEntry, withEntries, selectEntries);

		} else if (internalQuery instanceof EmptyQuery) {
			spreadQuery = internalQuery;

		} else if (internalQuery instanceof LeafQuery) {
			// deal with leaf queries
			spreadQuery = this.spreadLeafQuery((LeafQuery) internalQuery, nodeMap, seenQueries, selectEntryMap);

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		return spreadQuery;
	}

	/**
	 * This is the interesting case for the spreader. We apply the spreading
	 * algorithm as detailed in the MQL design document.
	 */
	private InternalQuery spreadLeafQuery(LeafQuery leafQuery, Map<AtomicEntry, Node> nodeMap, Set<NestedQuery> seenQueries,
			Map<SelectEntry, SelectEntry> selectEntryMap) throws QueryExecutionException {

		// deal with nested queries if they exist
		this.spreadNestedQueryInLeafQuery(leafQuery.getWithEntries(), nodeMap, seenQueries);

		// for the result
		InternalQuery resultQuery = null;

		// the first atomic entry's node contains the graph type indicating what
		// kind of spreading we have to apply
		GraphType graphType = nodeMap.get(leafQuery.getFromEntries().iterator().next()).graphType;

		switch (graphType) {
		case DIRTYDOMINANT:
			resultQuery = this.spreadNonRemnantLeafQuery(true, leafQuery, nodeMap);
			break;
		case NONDIRTYDOMINANT:
			resultQuery = this.spreadNonRemnantLeafQuery(false, leafQuery, nodeMap);
			break;
		case SINGULAR:
			resultQuery = this.spreadSingularLeafQuery(leafQuery, nodeMap);
			break;
		case REMNANT:
			resultQuery = this.spreadRemnantLeafQuery(leafQuery, nodeMap, selectEntryMap);
			break;
		default:
			throw new BugException(BugMessages.UNASSIGNED_GRAPH_TYPE);
		}

		// return the result
		return resultQuery;
	}

	/**
	 * This method adapts the leaf query to type Q1 when dirtyDominant is false
	 * and Q2 when dirtyDominant is true. In doing so, it changes the scopes
	 * appropriately depending on the alias's function in the spread query. See
	 * the MQL design document for details.
	 */
	private LeafQuery spreadNonRemnantLeafQuery(boolean dirtyDominant, LeafQuery leafQuery, Map<AtomicEntry, Node> nodeMap)
			throws QueryExecutionException {

		// calculate the new scope of each atomic entry
		List<AtomicEntry> atomicEntries = leafQuery.getFromEntries();
		//        String facilityId = leafQuery.getFqlProcessor( ).getFacilityId( );

		for (AtomicEntry atomicEntry : atomicEntries) {
			Node nodeForAtomicEntry = nodeMap.get(atomicEntry);

			// we empty the scope structure-typed nodes because they are adjusted afterwards
			if (nodeForAtomicEntry.isStructType) {
				atomicEntry.setScope(null, null, true);
			} else {
				if (dirtyDominant) {
					// we are constructing the scopes for query Q2
					if (nodeForAtomicEntry.nodeCategory.equals(NodeCategory.DIRTY)) {
						// the node is DIRTY only, so we do not have to adapt anything here
					} else {
						// The node is NON-DIRTY or MIXED, but the graph is dirty dominant.
						// This implies we that its scope has to be a dependent scope with respect to the association
						Set<URI> dependentScope = this.calculateDependentScopes(nodeForAtomicEntry);
						// This scope is always inclusive
						atomicEntry.setScope(dependentScope, null, true);
					}

				} else {
					// we are constructing the scopes for query Q1
					if (nodeForAtomicEntry.nodeCategory.equals(NodeCategory.NONDIRTY)) {
						// the node is NON-DIRTY, so we do not have to adapt anything here
					} else {
						// all other nodes are by necessity simplified (by virtue of the break-up algorithm). Moreover,
						// the scope of Q1 is kept as the original (unadapted)
						if (!(nodeForAtomicEntry.simpleNode)) {
							// sanity check
							throw new BugException(BugMessages.NON_SIMPLIFIED_NODE_IN_CLUSTER_OF_NONDIRTY_NODES);
						}
					}
				}
			}
		}

		// set the FQL processor
		if (dirtyDominant) {
			// dirty dominance means that the query is calculated in the memory processor
			leafQuery.setFqlProcessor(this.memFQL);
		}

		return leafQuery;
	}

	/**
	 * This method calculates the "dependent" scopes (see MQL design document)
	 * from the other side of each edge to the originalTargetNode, where all
	 * dependent scope results have to at least also exist in the
	 * originalTargetScope. The starting scope for each node on the other side
	 * is its true dirty scope.
	 */
	private Set<URI> calculateDependentScopes(Node originalTargetNode) throws QueryExecutionException {

		// the result scope
		Set<URI> resultScope = new HashSet<URI>();

		// for each edge we obtain the connected node and calculate the dependScope into the originalTargetNode 
		for (Edge connectingEdge : originalTargetNode.connectedAssocEdges) {

			// obtain the node on the other side
			Node connectedNode = this.obtainConnectedNodeInEdge(originalTargetNode, connectingEdge);

			// obtain the right association end integer
			//            int assocEndOfConnectedNode = ( connectedNode.equals( connectingEdge.fromNode ) ? connectingEdge.assocPredicate.getFromAssocEnd( ) : connectingEdge.assocPredicate.getToAssocEnd( ) );

			// calculate the dependent scope starting with the trueDirtyScope of the other side
			//            Set<PRI> dependentScope = this.calculateDependentScope( connectedNode.trueDirtyScope, connectedNode.atomicEntry, assocEndOfConnectedNode, connectingEdge.assocPredicate.getAssocMRI( ) );
			Set<URI> dependentScope = this.calculateDependentScope(connectedNode.trueDirtyScope, connectedNode.atomicEntry,connectingEdge.assocPredicate.getAssocMRI());

			Set<URI> targetScope = originalTargetNode.atomicEntry.getScope();
			dependentScope = this.mqlAuxServices.intersectScopes(targetScope, true, dependentScope, true);
			
			// calculate union with result scope
			resultScope = this.mqlAuxServices.unionScopes(resultScope, true, dependentScope, true);
		}

		return resultScope;
	}

	/**
	 * This method calculates the set of partition PRIs which a link (as
	 * instance of the assoc in assocPredicate) points to. Moreover, the link
	 * originates from all instances of the types in the atomic entry. Moreover,
	 * the instances of the types are only taken from the partitions in the
	 * baseDirtyScope, of which we know that they are always dirty (and thus
	 * client-specific). We only obtain the dependent scoped partitions which
	 * belong to the provided facility ID
	 */
	//    private Set<PRI> calculateDependentScope( Set<PRI> baseDirtyScope, AtomicEntry atomicEntry, int assocEndNumber, MRI assocMRI ) throws MQLExecutionException {
	private Set<URI> calculateDependentScope(Set<URI> baseDirtyScope, AtomicEntry atomicEntry, URI assocMRI) throws QueryExecutionException {

		// collects the result partitions
		Set<URI> dependentScope = new HashSet<URI>();

		// resolve the association from the meta-model
		//        RefObject associationOrAttribute = (RefObject) this.conn.getElement( assocMRI );
		EReference associationOrAttribute = this.emfHelper.getReference(assocMRI);

		// we obtain the workspaceSet for the connection
		//        WorkspaceSet workspaceSet = this.conn.getSession( ).getWorkspaceSet( );

		// the element set is the set of fixed set atomic entries, or null if it was not a fixed set
		Set<URI> fixedElementSet = (atomicEntry instanceof AtomicEntryFixedSet ? ((AtomicEntryFixedSet) atomicEntry).getElements() : null);

		// we walk over the partitions in the baseScope (which are all loaded and dirty)
		for (URI pri : baseDirtyScope) {
			// get the actual model partition
			Resource mp = (this.emfHelper.getResource(pri));

			// walk over all elements in the partition
			List<EObject> elementsInResource = this.emfHelper.getElementsInResource(mp);
			for (EObject element : elementsInResource) {

				// an element is only relevant if there is no fixed set, or
				// if there is a fixed set, the element is contained in it
				boolean elementIsRelevant = fixedElementSet == null || fixedElementSet.contains(EcoreUtil.getURI(element));

				if (elementIsRelevant) {
					// get the MRI type of the element
					URI elementType = EcoreUtil.getURI(element.eClass());

					// check if the type is one of the atomic entry types. Always true for Reflect::Element
					boolean isOfType = atomicEntry.isReflectElement();
					for (Iterator<URI> iter = atomicEntry.getClassMRIs().iterator(); !isOfType && iter.hasNext();) {
						URI atomicEntryMri = iter.next();
						isOfType = atomicEntryMri.equals(elementType);
					}

					// if the instance is also type correct, check for links
					if (isOfType) {
						// obtain all the model elements connected to the element within the association
						Object referencedObject = element.eGet(associationOrAttribute);

						List<EObject> connectedElements = null;
						if (referencedObject instanceof List) {
							connectedElements = (List<EObject>) referencedObject;
						} else if (referencedObject instanceof EObject) {
							connectedElements = Collections.singletonList((EObject) referencedObject);
						} else if (referencedObject == null) {
							connectedElements = Collections.emptyList();
						} else {
							throw new IllegalArgumentException();
						}

						// collect the pris for the other side
						for (int i = 0, n = connectedElements.size(); i < n; i++) {
							EObject connectedElement = connectedElements.get(i);
							// get the partition
							if(connectedElement.eResource() != null) {
							    URI dependentPRI = connectedElement.eResource().getURI();
							    dependentScope.add(dependentPRI);
							}
						}
					}
				}
			}
		}

		return dependentScope;
	}

	/**
	 * This methods assumes that only one (non-structure-typed) atomic entry
	 * exists and simply interprets where it has to be executed
	 */
	private InternalQuery spreadSingularLeafQuery(LeafQuery leafQuery, Map<AtomicEntry, Node> nodeMap) throws QueryExecutionException {

		InternalQuery resultQuery = leafQuery;

		// first, obtain the one non-structure-typed atomic entry
		Node node = null;
		List<AtomicEntry> atomicEntries = leafQuery.getFromEntries();
		for (Iterator<AtomicEntry> iter = atomicEntries.iterator(); node == null && iter.hasNext();) {
			node = nodeMap.get(iter.next());
			if (node.isStructType) {
				// keep searching
				node = null;
			}
		}

		// sanity check
		if (node == null) {
			throw new BugException(BugMessages.SINGULAR_QUERY_WITH_ONLY_STRUCTURE_TYPED_ATOMIC_ENTRIES);
		}

		// depending on its category we do different things
		switch (node.nodeCategory) {
		case DIRTY:
			// the one node indicates a DIRTY graph, so we adapt the FQL processor
			leafQuery.setFqlProcessor(this.memFQL);
			break;
		case NONDIRTY:
			// the one node indicates a NON-DIRTY graph, so nothing to change
			break;
		case MIXED:
			// we have a mixed scenario, therefore we make a (flat) clone of the leaf query
			LeafQuery memoryLeafQuery = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, new HashMap<AtomicEntry, AtomicEntry>());

			// the cloned query is executed in memory, thus
			memoryLeafQuery.setFqlProcessor(this.memFQL);

			// and the scope of the memory version is the true dirty scope
			List<AtomicEntry> clonedAtomicEntries = memoryLeafQuery.getFromEntries();
			for (AtomicEntry atomicEntry : clonedAtomicEntries) {
				atomicEntry.setScope(node.trueDirtyScope, null, true);
			}

			// the original query is executed on the facility. We only need to calculate the new scope and set it
			AtomicEntry facilityAtomicEntry = node.atomicEntry;
			Set<URI> newFacilityScope = this.mqlAuxServices.intersectScopes(facilityAtomicEntry.getScope(), facilityAtomicEntry
					.isScopeInclusive(), this.relevantPartitionPRIs, false);
			facilityAtomicEntry.setScope(newFacilityScope, null, facilityAtomicEntry.isScopeInclusive());

			// construct the pairUnion
			resultQuery = this.constructUnion(leafQuery.getAliasName(), leafQuery, memoryLeafQuery, null);

			break;
		default:
			throw new BugException(BugMessages.UNEXPECTED_NODE_CATEGORY, node.nodeCategory);
		}

		return resultQuery;
	}

	/**
	 * Given two or three original queries, this function constructs a union of
	 * those queries. (Convenience method)
	 */
	private ResultUnion constructUnion(AliasName originalAliasName, InternalQuery query1, InternalQuery query2, InternalQuery query3) {

		// put the operands together
		int size = (query3 == null ? 2 : 3);
		List<InternalQuery> newOperands = new ArrayList<InternalQuery>(size);
		newOperands.add(query1);
		newOperands.add(query2);

		// if we have a third query
		if (query3 != null) {
			newOperands.add(query3);
		}

		ResultUnion resultQuery = new ResultUnion(new AliasName(originalAliasName), newOperands);

		return resultQuery;
	}

	/**
	 * This case always assumes two (non-structure-typed) atomic entries with an
	 * assoc predicate, which was not covered by the other types of graphs. It
	 * will apply the spreading algorithm according to the table in the MQL
	 * design document (see also
	 * {@link #spreadRemnantWithDominance(Node, Node, LeafQuery, AssocPredicate)}
	 * ). In order to do this, we make a choice of dominant and sub-dominant
	 * nodes and try if we can apply the correct spreading.
	 */
	private InternalQuery spreadRemnantLeafQuery(LeafQuery leafQuery, Map<AtomicEntry, Node> nodeMap,
			Map<SelectEntry, SelectEntry> selectEntryMap) throws QueryExecutionException {

		// obtain two nodes, which are not structure types, which have to exist for this leaf query

		// first obtain the two non-structure type nodes
		Node node1 = null;
		Node node2 = null;
		boolean node1IsDominant = false;

		for (AtomicEntry atomicEntry : leafQuery.getFromEntries()) {
			Node node = nodeMap.get(atomicEntry);
			// we are only interested in non-structure types
			if (!node.isStructType) {
				if (node1 == null) {
					// set the first node if not done yet
					node1 = node;
				} else if (node2 == null) {
					// set the second node if not done yet
					node2 = node;
				} else {
					// sanity check
					throw new BugException(BugMessages.EXPECTING_TWO_NON_STRUCTURE_TYPED_NODES);
				}
			}
		}

		if (node1 == null || node2 == null) {
			throw new BugException(BugMessages.NON_ASSIGNED_NODES_WHILE_SPREADING);
		}

		// now obtain the edge between these two nodes
		Edge edgeBetweenTwoNodes = null;
		for (Iterator<Edge> iter = node1.connectedAssocEdges.iterator(); edgeBetweenTwoNodes == null && iter.hasNext();) {

			// get the edge
			Edge connectedAssocEdge = iter.next();

			// get the connected node
			Node connectedNode = this.obtainConnectedNodeInEdge(node1, connectedAssocEdge);

			// we are only interested in non-structure typed nodes 
			if (!connectedNode.isStructType) {
				// set the edge
				edgeBetweenTwoNodes = connectedAssocEdge;
				// sanity check on the node
				if (node2 != connectedNode) {
					throw new BugException(BugMessages.DIFFERENT_CONNECTED_NODE_IN_REMNANT_GRAPH);
				}

				// set dominance of node 1
				node1IsDominant = (node1.equals(connectedAssocEdge.fromNode) ? connectedAssocEdge.fromNodeDominant
						: !connectedAssocEdge.fromNodeDominant);
			}
		}

		// sanity check
		if (edgeBetweenTwoNodes == null) {
			throw new BugException(BugMessages.MISSING_EDGE_IN_REMANT_QUERY);
		}

		// this keeps the result
		InternalQuery resultQuery = null;

		// we act differently depending on whether node 1 is dominant here or not
		if (node1IsDominant) {
			resultQuery = this.spreadRemnantWithDominance(node1, node2, leafQuery, edgeBetweenTwoNodes, selectEntryMap);
		} else {
			resultQuery = this.spreadRemnantWithDominance(node2, node1, leafQuery, edgeBetweenTwoNodes, selectEntryMap);
		}

		// if we still did not obtain a result, we have a problem :-(
		if (resultQuery == null) {
			throw new BugException(BugMessages.NO_QUERY_FOUND_DURING_SPREADING_OF_REMNANT_GRAPH);
		}

		return resultQuery;
	}

	/**
	 * Spreads a remnant query for a dominant and subDominant node. We make an
	 * extensive case analysis to find the right spreading case, according to
	 * the following table:
	 * <ul>
	 * <li>3a: MIXED (dominant) and MIXED (non-simple) => Q1, Q2, Q3
	 * <li>3b: MIXED (dominant) and MIXED (simple) => Q1', Q2
	 * <li>4a: NONDIRTY (dominant) and MIXED (non-simple) => Q1, Q3
	 * <li>5a: NONDIRTY (dominant) and DIRTY (non-simple) => Q3
	 * <li>7: MIXED (dominant) and NONDIRTY => Q1, Q2
	 * <li>9b: MIXED (dominant) and DIRTY (simple) => Q1, Q2
	 * <li>9a: MIXED (dominant) and DIRTY (non-simple) => Q2, Q3
	 * </ul>
	 * The other possibilities have been dealt with in the other spreading
	 * scenarios. If such a case is found, this method returns null.
	 */
	private InternalQuery spreadRemnantWithDominance(Node dominantNode, Node subDominantNode, LeafQuery leafQuery,
			Edge edgeBetweenTwoNodes, Map<SelectEntry, SelectEntry> selectEntryMap) throws QueryExecutionException {

		// for the result
		InternalQuery resultQuery = null;

		// get the alias of the base query
		AliasName aliasName = leafQuery.getAliasName();

		// do a case analysis on the dominant node first
		switch (dominantNode.nodeCategory) {
		case MIXED:
			// with a mixed dominant node, we have to deal with the other types: cases 3a, 3b, 7, 9a, 9b
			switch (subDominantNode.nodeCategory) {
			case MIXED:
				// cases 3a and 3b
				if (subDominantNode.simpleNode) {
					// case 3b: Q1', Q2

					// make a shallow clone for Q2
					Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap = new HashMap<AtomicEntry, AtomicEntry>();
					LeafQuery clonedLeafQuery = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, clonedAtomicEntryMap);

					// construct Q1' (based on the leaf query)
					this.constructQ1(true, dominantNode, subDominantNode, null);

					// construct Q2 (based on the clonedAtomicEntryMap clonedLeafQuery)
					this.constructQ2(dominantNode, subDominantNode, clonedLeafQuery, edgeBetweenTwoNodes, clonedAtomicEntryMap);

					// construct result (leafQuery upfront)
					resultQuery = this.constructUnion(aliasName, leafQuery, clonedLeafQuery, null);

				} else {
					// case 3a: Q1, Q2, Q3

					// make a shallow clone for Q1
					Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap1 = new HashMap<AtomicEntry, AtomicEntry>();
					LeafQuery clonedLeafQuery1 = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, clonedAtomicEntryMap1);

					// make a shallow clone for Q2
					Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap2 = new HashMap<AtomicEntry, AtomicEntry>();
					LeafQuery clonedLeafQuery2 = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, clonedAtomicEntryMap2);

					// construct Q1 (based on clonedAtomicEntryMap1)
					this.constructQ1(false, dominantNode, subDominantNode, clonedAtomicEntryMap1);

					// construct Q2 (based on clonedAtomicEntryMap2 and clonedLeafQuery2)
					this.constructQ2(dominantNode, subDominantNode, clonedLeafQuery2, edgeBetweenTwoNodes, clonedAtomicEntryMap2);

					// construct Q3 (based on leafQuery)
					NodeQuery q3 = this.constructQ3(dominantNode, subDominantNode, leafQuery, edgeBetweenTwoNodes, selectEntryMap);

					// construct result (q3 upfront)
					resultQuery = this.constructUnion(aliasName, q3, clonedLeafQuery1, clonedLeafQuery2);
				}
				break;
			case NONDIRTY:
				// case 7: Q1, Q2

			{
				// make a clone for Q2
				Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap = new HashMap<AtomicEntry, AtomicEntry>();
				LeafQuery clonedLeafQuery = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, clonedAtomicEntryMap);

				// construct Q1 (based on leaf query)
				this.constructQ1(false, dominantNode, subDominantNode, null);

				// construct Q2 (based on clonedAtomicEntryMap and clonedLeafQuery)
				this.constructQ2(dominantNode, subDominantNode, clonedLeafQuery, edgeBetweenTwoNodes, clonedAtomicEntryMap);

				// construct result (leaf query upfront)
				resultQuery = this.constructUnion(aliasName, leafQuery, clonedLeafQuery, null);
			}
				break;
			case DIRTY:
				// cases 9a and 9b
				if (subDominantNode.simpleNode) {
					// case 9b: Q1', Q2

					// make a clone for Q2
					Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap = new HashMap<AtomicEntry, AtomicEntry>();
					LeafQuery clonedLeafQuery = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, clonedAtomicEntryMap);

					// construct Q1' (based on leaf query)
					this.constructQ1(true, dominantNode, subDominantNode, null);

					// construct Q2 (based on clonedAtomicEntryMap and clonedLeafQuery)
					this.constructQ2(dominantNode, subDominantNode, clonedLeafQuery, edgeBetweenTwoNodes, clonedAtomicEntryMap);

					// construct result (leaf query upfront)
					resultQuery = this.constructUnion(aliasName, leafQuery, clonedLeafQuery, null);

				} else {
					// case 9a: Q2, Q3

					// make a clone for Q2
					Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap = new HashMap<AtomicEntry, AtomicEntry>();
					LeafQuery clonedLeafQuery = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, clonedAtomicEntryMap);

					// construct Q2 (based on cloendAtomicEntryMap and clonedLeafQuery)
					this.constructQ2(dominantNode, subDominantNode, clonedLeafQuery, edgeBetweenTwoNodes, clonedAtomicEntryMap);

					// construct Q3 (based on leafQuery)
					NodeQuery q3 = this.constructQ3(dominantNode, subDominantNode, leafQuery, edgeBetweenTwoNodes, selectEntryMap);

					// construct result (q3 upfront)
					resultQuery = this.constructUnion(aliasName, q3, clonedLeafQuery, null);

				}
				break;
			default:
				throw new BugException(BugMessages.UNKNOWN_ATOMIC_ENTRY_CATEGORY, subDominantNode.nodeCategory);
			}
			break;
		case NONDIRTY:
			// with a NONDIRTY dominant node, we have only two cases to consider: cases 4a and 5a
			if (subDominantNode.nodeCategory.equals(NodeCategory.MIXED) && !subDominantNode.simpleNode) {
				// case 4a: Q1, Q3

				// make a clone for Q1
				Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap = new HashMap<AtomicEntry, AtomicEntry>();
				LeafQuery clonedLeafQuery = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false, clonedAtomicEntryMap);

				// construct Q1 (based on clonedAtomicEntryMap)
				this.constructQ1(false, dominantNode, subDominantNode, clonedAtomicEntryMap);

				// construct Q3 (based on leafQuery)
				NodeQuery q3 = this.constructQ3(dominantNode, subDominantNode, leafQuery, edgeBetweenTwoNodes, selectEntryMap);

				// construct result (q3 upfront)
				resultQuery = this.constructUnion(aliasName, q3, clonedLeafQuery, null);

			} else if (subDominantNode.nodeCategory.equals(NodeCategory.DIRTY) && !subDominantNode.simpleNode) {
				// case 5a: Q3

				resultQuery = this.constructQ3(dominantNode, subDominantNode, leafQuery, edgeBetweenTwoNodes, selectEntryMap);
			}
			break;
		case DIRTY:
			// no such case exists
			throw new BugException(BugMessages.NO_DIRTY_DOMINANT_SCENARIO_IN_REMNANT_SITUATIONS);
		default:
			throw new BugException(BugMessages.UNKNOWN_ATOMIC_ENTRY_CATEGORY, dominantNode.nodeCategory);
		}
		return resultQuery;
	}

	/**
	 * This method constructs queries Q1 and Q1' according to the spreading
	 * algorithm. This query works on the original query, expects the dominant
	 * node always be executed outside the true-non-dirty set and the
	 * sub-dominant as well, except if we have a simplified case. If the
	 * atomicEntryMap is not null, the nodes atomic entries have to be mapped
	 * first (to obtain cloned atomic entries if necessary).
	 */
	private void constructQ1(boolean simplified, Node dominantNode, Node subDominantNode, Map<AtomicEntry, AtomicEntry> clonedAtomicEntryMap) {

		// determine the entries
		AtomicEntry dominantAtomicEntry = (clonedAtomicEntryMap == null ? dominantNode.atomicEntry : clonedAtomicEntryMap
				.get(dominantNode.atomicEntry));
		AtomicEntry subDominantAtomicEntry = (clonedAtomicEntryMap == null ? subDominantNode.atomicEntry : clonedAtomicEntryMap
				.get(subDominantNode.atomicEntry));

		// for the dominant atomic entry, we always work outside the true dirty partitions
		Set<URI> nonDominantDirtyScope = this.mqlAuxServices.intersectScopes(dominantAtomicEntry.getScope(), dominantAtomicEntry
				.isScopeInclusive(), this.relevantPartitionPRIs, false);
		dominantAtomicEntry.setScope(nonDominantDirtyScope, null, dominantAtomicEntry.isScopeInclusive());

		// if we have the non-simplified case, the sub-dominant atomic entry is handled like the dominant case
		if (!simplified) {
			Set<URI> nonDirtySubDominantScope = this.mqlAuxServices.intersectScopes(subDominantAtomicEntry.getScope(),
					subDominantAtomicEntry.isScopeInclusive(), this.relevantPartitionPRIs, false);
			subDominantAtomicEntry.setScope(nonDirtySubDominantScope, null, subDominantAtomicEntry.isScopeInclusive());
		} // otherwise, it is untouched
	}

	/**
	 * This method constructs query Q2 according to the spreading algorithm.
	 * This query works on the memory FQL, expects the dominant node always be
	 * executed in the true-non-dirty set and the sub-dominant node has its
	 * scope as the calculated dependent scope. If the atomicEntryMap is not
	 * null, the nodes atomic entries have to be mapped first (to obtain cloned
	 * atomic entries if necessary).
	 */
	private void constructQ2(Node dominantNode, Node subDominantNode, LeafQuery leafQuery, Edge edgeBetweenTwoNodes,
			Map<AtomicEntry, AtomicEntry> atomicEntryMap) throws QueryExecutionException {

		String facilityID = leafQuery.getFqlProcessor().getFacilityId();

		// we set the bql processor
		leafQuery.setFqlProcessor(this.memFQL);

		// determine the entries
		AtomicEntry dominantAtomicEntry = (atomicEntryMap == null ? dominantNode.atomicEntry : atomicEntryMap.get(dominantNode.atomicEntry));
		AtomicEntry subDominantAtomicEntry = (atomicEntryMap == null ? subDominantNode.atomicEntry : atomicEntryMap
				.get(subDominantNode.atomicEntry));

		// for the dominant atomic entry, we always work within the true dirty partitions
		dominantAtomicEntry.setScope(dominantNode.trueDirtyScope, null, true);

		// obtain the right association end integer
		//        int assocEndOfConnectedNode = ( dominantNode.equals( edgeBetweenTwoNodes.fromNode ) ? edgeBetweenTwoNodes.assocPredicate.getFromAssocEnd( ) : edgeBetweenTwoNodes.assocPredicate.getToAssocEnd( ) );

		// for the subdominant atomic entry, we always work on the dependent partitions for the association
		Set<URI> dependentScope = this.calculateDependentScope(dominantNode.trueDirtyScope, dominantAtomicEntry,
				edgeBetweenTwoNodes.assocPredicate.getAssocMRI());
		subDominantAtomicEntry.setScope(dependentScope, null, true);
	}

	/**
	 * This method constructs query Q3 according to the spreading algorithm. The
	 * assoc predicate is the one predicate which we have to isolate in query
	 * Q31.
	 */
	private NodeQuery constructQ3(Node dominantNode, Node subDominantNode, LeafQuery leafQuery, Edge edgeBetweenTwoNodes,
			Map<SelectEntry, SelectEntry> selectEntryMap) {

		AssocPredicate assocPredicate = edgeBetweenTwoNodes.assocPredicate;

		// get the relevant material from the leaf query
		AliasName aliasName = leafQuery.getAliasName();
		SpiFacilityQueryLanguage fqlProcessor = leafQuery.getFqlProcessor();
		AtomicEntry dominantAtomicEntry = dominantNode.atomicEntry;
		AtomicEntry subDominantAtomicEntry = subDominantNode.atomicEntry;
		List<WithEntry> withEntries = leafQuery.getWithEntries();
		List<LeafSelectEntry> leafSelectEntries = leafQuery.getSelectEntries();

		// we maintain a map from atomic entry references to their selections.
		Map<AtomicEntryReference, LeafSelectEntry> atomicEntryToLeafSelectEntryMap = new HashMap<AtomicEntryReference, LeafSelectEntry>();

		// we definitely include those which are selected (this may include structure-typed atomic entries)
		for (LeafSelectEntry leafSelectEntry : leafSelectEntries) {
			AtomicEntryReference atomicEntryRef = leafSelectEntry.getAtomicEntryReference();
			// construct new leaf select entries
			atomicEntryToLeafSelectEntryMap.put(atomicEntryRef, new LeafSelectEntry(atomicEntryRef));
		}

		// we construct the references for the dominant and subdominant nodes
		AtomicEntryReference dominantAtomicEntryRef = new AtomicEntryReference(dominantAtomicEntry);
		AtomicEntryReference subDominantAtomicEntryRef = new AtomicEntryReference(subDominantAtomicEntry);

		// we gradually build up the comparison entries for the encompassing node query
		List<ComparisonWithEntry> comparisonWithEntries = new ArrayList<ComparisonWithEntry>();

		// Make the clone of the sub-dominant atomic entry with the appropriate (true dirty) scope and *no* where conditions. 
		// Notice that the cloned sub-dominant atomic entry does not include its connected structure-typed atomic entries
		AtomicEntry subDominantClonedAtomicEntry = null;

		// case distinction for fixed set or not
		if (subDominantAtomicEntry instanceof AtomicEntryFixedSet) {
			Set<URI> subDominantElements = ((AtomicEntryFixedSet) subDominantAtomicEntry).getElements();
			subDominantClonedAtomicEntry = AtomicEntryFixedSet.newAtomicEntryFixedSetWithClonedElements(new AliasName(
					subDominantAtomicEntry.getAliasName()), subDominantAtomicEntry.getClassMRIs(), subDominantAtomicEntry.getClassNames(),
					subDominantElements, subDominantAtomicEntry.isReflectElement(), subDominantNode.trueDirtyScope, null, true);
		} else {
			subDominantClonedAtomicEntry = new AtomicEntry(new AliasName(subDominantAtomicEntry.getAliasName()), subDominantAtomicEntry
					.getClassMRIs(), subDominantAtomicEntry.getClassNames(), subDominantAtomicEntry.getTypeCategory(),
					subDominantAtomicEntry.isReflectElement(), subDominantNode.trueDirtyScope, null, true);
		}

		// we construct a type reference for the cloned atomic entry
		AtomicEntryReference subDominantClonedAtomicEntryRef = new AtomicEntryReference(subDominantClonedAtomicEntry);

		// we have to put both the original and the cloned atomic entry in the
		// selectEntryMap because they will definitely be selected in either q31 or q32
		LeafSelectEntry subDominantClonedSelectEntry = new LeafSelectEntry(subDominantClonedAtomicEntryRef);
		LeafSelectEntry subDominantSelectEntry = new LeafSelectEntry(subDominantAtomicEntryRef);

		atomicEntryToLeafSelectEntryMap.put(subDominantClonedAtomicEntryRef, subDominantClonedSelectEntry);
		atomicEntryToLeafSelectEntryMap.put(subDominantAtomicEntryRef, subDominantSelectEntry);

		// we can already construct the type comparison which equalizes the original and its cloned atomic entry
		TypeReference leftReference = new VirtualAtomicEntryReference(subDominantSelectEntry);
		TypeReference rightReference = new VirtualAtomicEntryReference(subDominantClonedSelectEntry);
		TypeComparison typeComparison = new TypeComparison(leftReference, rightReference);
		comparisonWithEntries.add(typeComparison);

		// now set the scope of the dominant atomic entry
		Set<URI> nonDirtyScope = this.mqlAuxServices.intersectScopes(dominantAtomicEntry.getScope(),
				dominantAtomicEntry.isScopeInclusive(), this.relevantPartitionPRIs, false);
		dominantAtomicEntry.setScope(nonDirtyScope, null, dominantAtomicEntry.isScopeInclusive());

		// we need these to build the from-entries of q31 and q32
		List<AtomicEntry> fromEntriesQuery31 = new ArrayList<AtomicEntry>();
		List<AtomicEntry> fromEntriesQuery32 = new ArrayList<AtomicEntry>();

		// for q31, we need at least the dominant and cloned subdominant atomic entries
		fromEntriesQuery31.add(dominantAtomicEntry);
		fromEntriesQuery31.add(subDominantClonedAtomicEntry);

		// for q32, we only need the (non-cloned) subdominant atomic entry
		fromEntriesQuery32.add(subDominantAtomicEntry);

		// we need these for the with-entries of q31 and q32
		List<WithEntry> withEntriesQuery31 = new ArrayList<WithEntry>();
		List<WithEntry> withEntriesQuery32 = new ArrayList<WithEntry>();

		// And we add all structure-typed atomic entries and their connecting association predicates for the dominant node. 
		Set<AtomicEntry> seenAtomicEntries = new HashSet<AtomicEntry>();
		seenAtomicEntries.add(dominantAtomicEntry);
		this.addStructureTypedAtomicEntries(dominantNode, withEntries, withEntriesQuery31, fromEntriesQuery31, seenAtomicEntries);

		// Idem for the subdominant node (for q32)
		seenAtomicEntries = new HashSet<AtomicEntry>();
		seenAtomicEntries.add(subDominantAtomicEntry);
		this.addStructureTypedAtomicEntries(subDominantNode, withEntries, withEntriesQuery32, fromEntriesQuery32, seenAtomicEntries);

		// Construct the remaining with entries for the queries q31 and q32. In
		// q31, none should be left that mention the subdominant entry. 
		// Those are either moved to q32 or the encompassing node query
		for (WithEntry entry : withEntries) {
			// case analysis
			if (entry instanceof AssocPredicate) {
				AssocPredicate assocPred = (AssocPredicate) entry;

				// get the two type references
				TypeReference fromAssocTypeRef = assocPred.getFromType();
				TypeReference toAssocTypeRef = assocPred.getToType();

				// check if the subdominant is involved
				if (fromAssocTypeRef.equals(subDominantAtomicEntryRef)) {
					// if we have left involvement, check if we have right involvement to move the assoc to query32
					if (toAssocTypeRef.equals(subDominantAtomicEntryRef)) {
						withEntriesQuery32.add(assocPred);
					} else {
						// otherwise, we are dealing with *the* one assoc predicate, which is not included anywhere. Sanity check!
						if (!(assocPred.equals(assocPredicate))) {
							throw new BugException(BugMessages.FOUND_ASSOC_PREDICATE_IN_REMNANT_GRAPH);
						}
					}
				} else if (toAssocTypeRef.equals(subDominantAtomicEntryRef)) {
					// if we have right involvement (and no left involvement), we have to be dealing with the one assoc predicate again. Sanity check!
					if (!(assocPred.equals(assocPredicate))) {
						throw new BugException(BugMessages.FOUND_ASSOC_PREDICATE_IN_REMNANT_GRAPH);
					}
				} else {
					// Otherwise, we have references to the dominant node only and add them to query31
					withEntriesQuery31.add(assocPred);
				}
			} else if (entry instanceof LinksPredicate) {
				TypeReference linkedRef = ((LinksPredicate) entry).getFromType();

				if (linkedRef.equals(dominantAtomicEntryRef)) {
					// if dominant involved, move to query31
					withEntriesQuery31.add(entry);
				} else if (linkedRef.equals(subDominantAtomicEntryRef)) {
					// if sub-dominant involved, move to query32
					withEntriesQuery32.add(entry);
				} else {
					// impossible
					throw new BugException(BugMessages.ALIAS_IN_REMNANT_GRAPH_WITHOUT_DOMINANCE);
				}
			} else if (entry instanceof ComparisonWithEntry) {
				// the with-comparison entries are moved up
				ComparisonWithEntry comparisonWithEntry = (ComparisonWithEntry) entry;

				// get the old atomicEntryRefs
				AtomicEntryReference oldLeftAtomicEntryRef = (AtomicEntryReference) comparisonWithEntry.getLeftTypeReference();
				AtomicEntryReference oldRightAtomicEntryRef = (AtomicEntryReference) comparisonWithEntry.getRightTypeReference();

				// add the old type references to the selectEntryMap, but only if they are not already there
				if (!(atomicEntryToLeafSelectEntryMap.containsKey(oldLeftAtomicEntryRef))) {
					atomicEntryToLeafSelectEntryMap.put(oldLeftAtomicEntryRef, new LeafSelectEntry(oldLeftAtomicEntryRef));
				}

				if (!(atomicEntryToLeafSelectEntryMap.containsKey(oldRightAtomicEntryRef))) {
					atomicEntryToLeafSelectEntryMap.put(oldRightAtomicEntryRef, new LeafSelectEntry(oldRightAtomicEntryRef));
				}

				// construct the new type refs (getting the select entries from the map)
				TypeReference newLeftTypeRef = this.mqlAuxServices.constructVirtualAtomicEntryReference(atomicEntryToLeafSelectEntryMap
						.get(oldLeftAtomicEntryRef));
				TypeReference newRightTypeRef = this.mqlAuxServices.constructVirtualAtomicEntryReference(atomicEntryToLeafSelectEntryMap
						.get(oldRightAtomicEntryRef));

				// construct the new with entry
				comparisonWithEntry.setLeftType(newLeftTypeRef);
				comparisonWithEntry.setRightType(newRightTypeRef);

				comparisonWithEntries.add(comparisonWithEntry);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, entry.getClass().getCanonicalName(), "JoinWhereEntry"); //$NON-NLS-1$
			}
		}

		// adapt *the* one association predicate by checking if the from type is the dominant alias
		if (assocPredicate.getFromType().equals(dominantAtomicEntryRef)) {
			// set the to-type as the cloned one if so
			assocPredicate.setToType(subDominantClonedAtomicEntryRef);
		} else {
			// set the left type as the cloned one otherwise
			assocPredicate.setFromType(subDominantClonedAtomicEntryRef);
		}

		// add it explicitly to the first query
		withEntriesQuery31.add(assocPredicate);

		// Construct the select entries by getting the selections on the dominant and cloned entry
		List<LeafSelectEntry> selectEntriesQuery31 = new ArrayList<LeafSelectEntry>();
		for (LeafSelectEntry leafSelectEntry : atomicEntryToLeafSelectEntryMap.values()) {
			AtomicEntry leafSelectAtomicEntry = leafSelectEntry.getAtomicEntryReference().getAtomicEntry();
			// check if the entry refers to an atomic entry in q31
			if (fromEntriesQuery31.contains(leafSelectAtomicEntry)) {
				selectEntriesQuery31.add(leafSelectEntry);
			}
		}

		// Now construct query31
		LeafQuery query31 = LeafQuery.construct(new AliasName(aliasName), fromEntriesQuery31, withEntriesQuery31, selectEntriesQuery31,
				fqlProcessor);

		// the scope of the sub-dominant atomic entry is true dirty
		subDominantAtomicEntry.setScope(subDominantNode.trueDirtyScope, null, true);

		// Construct the select entries for query q32 by getting the selections on the sub dominant entry
		List<LeafSelectEntry> selectEntriesQuery32 = new ArrayList<LeafSelectEntry>();
		for (LeafSelectEntry leafSelectEntry : atomicEntryToLeafSelectEntryMap.values()) {
			AtomicEntry leafSelectAtomicEntry = leafSelectEntry.getAtomicEntryReference().getAtomicEntry();
			// check if the entry refers to an atomic entry in q32
			if (fromEntriesQuery32.contains(leafSelectAtomicEntry)) {
				selectEntriesQuery32.add(leafSelectEntry);
			}
		}

		// Noq construct query32 (in memory)
		LeafQuery query32 = LeafQuery.construct(new AliasName(aliasName), fromEntriesQuery32, withEntriesQuery32, selectEntriesQuery32,
				this.memFQL);

		/* Construct the result query */

		// construct the select entries
		List<NodeSelectEntry> newSelectEntries = new ArrayList<NodeSelectEntry>(leafSelectEntries.size());

		// walk over the original select entries in that order
		for (LeafSelectEntry leafSelectEntry : leafSelectEntries) {

			// get the appropriate leaf select entry
			LeafSelectEntry newLeafSelectEntry = atomicEntryToLeafSelectEntryMap.get(leafSelectEntry.getAtomicEntryReference());
			newLeafSelectEntry.setOriginalUserDefinedName(leafSelectEntry.getOriginalUserDefinedName());

			// construct the node select entry
			NodeSelectEntry nodeSelectEntry = new NodeSelectEntry(this.mqlAuxServices
					.constructVirtualAtomicEntryReference(newLeafSelectEntry));

			// register in the selectEntryMap
			selectEntryMap.put(leafSelectEntry, nodeSelectEntry);

			// add the constructed NodeSelectEntry
			newSelectEntries.add(nodeSelectEntry);
		}

		// construct and return result
		return NodeQuery.construct(aliasName, query31, query32, comparisonWithEntries, newSelectEntries);
	}

	/**
	 * Adds all structure-typed atomic entries connected to the provided node,
	 * as well as their causing assoc predicates. These are added in
	 * newFromEntries and newWithEntries respectively. The assocPredicates that
	 * are relevant are taken out of the withEntries list.
	 */
	private void addStructureTypedAtomicEntries(Node node, List<WithEntry> oldWithEntries, List<WithEntry> newWithEntries,
			List<AtomicEntry> newFromEntries, Set<AtomicEntry> seenAtomicEntries) {

		for (Edge connectedEdge : node.connectedAssocEdges) {

			// get the associated predicate
			AssocPredicate connectingAssocPredicate = connectedEdge.assocPredicate;

			Node connectedNode = null;

			if (node.equals(connectedEdge.fromNode)) {
				connectedNode = connectedEdge.toNode;
			} else {
				connectedNode = connectedEdge.fromNode;
			}

			// we are only interested in structure-typed connected nodes, which we have not seen before
			if (seenAtomicEntries.add(connectedNode.atomicEntry) && connectedNode.isStructType) {

				// we add the assoc predicate to the newWithEntries
				newWithEntries.add(connectingAssocPredicate);
				// we add the connected atomic entry to the newFromEntries
				newFromEntries.add(connectedNode.atomicEntry);
				// we remove the assoc predicate from the old with entries
				boolean removed = oldWithEntries.remove(connectingAssocPredicate);

				// sanity check
				if (!removed) {
					throw new BugException(BugMessages.NO_CONNECTING_ASSOC_PREDICATE_IN_WITH_ENTRIES);
				}

				// go recursively deeper
				this.addStructureTypedAtomicEntries(connectedNode, oldWithEntries, newWithEntries, newFromEntries, seenAtomicEntries);
			}
		}
	}

	/**
	 * Spreads possible nested queries in link predicates
	 */
	private void spreadNestedQueryInLeafQuery(List<WithEntry> withEntries, Map<AtomicEntry, Node> nodeMap, Set<NestedQuery> seenQueries)
			throws QueryExecutionException {

		// just walk over all with entries
		for (WithEntry withEntry : withEntries) {
			// case analysis: we are only interested in link predicates
			if (withEntry instanceof LinksPredicate) {
				LinksPredicate linksPredicate = (LinksPredicate) withEntry;

				// get the nested query
				NestedQuery nestedQuery = linksPredicate.getNestedQuery();

				// work recursively down if this is not already done
				if (seenQueries.add(nestedQuery)) {
					// construct new empty typeRefToVirtualTypeRefMap
					InternalQuery internalQuery = this.spreadInternalQuery(nestedQuery.getInternalQuery(), nodeMap, seenQueries,
							new HashMap<SelectEntry, SelectEntry>());
					// set the new query
					nestedQuery.setInternalQuery(internalQuery);
				}
			}
		}
	}

	/**
	 * Removes all unnecessary transient partitions in scopes of non-memory FQL
	 * processors.
	 */
	private void removeScopedTransientPartitionsInFacilityQueries(InternalQuery internalQuery) {

		try {
			// for avoiding duplicate calculations of shared nested queries
			Set<NestedQuery> seenQueries = new HashSet<NestedQuery>();

			// collect the atomic entries
			this.removeScopedTransientPartitionsInFacilityQueriesForInternalQuery(internalQuery, seenQueries);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_REMOVING_TRANSIENT_PARTITIONS,
						"\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Visits the internal query structure and removes all transient partitions
	 * from atomic entry scopes, whenever the atomic entry is <b>not</b>
	 * executed in the memory FQL processor
	 */
	private void removeScopedTransientPartitionsInFacilityQueriesForInternalQuery(InternalQuery internalQuery, Set<NestedQuery> seenQueries) {

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			// go recursively down
			for (InternalQuery operand : operands) {
				this.removeScopedTransientPartitionsInFacilityQueriesForInternalQuery(operand, seenQueries);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			// go recursively down
			this.removeScopedTransientPartitionsInFacilityQueriesForInternalQuery(nodeQuery.getFirstFromEntry(), seenQueries);
			this.removeScopedTransientPartitionsInFacilityQueriesForInternalQuery(nodeQuery.getSecondFromEntry(), seenQueries);

		} else if (internalQuery instanceof EmptyQuery) {
			// do not do anything

		} else if (internalQuery instanceof LeafQuery) {
			// deal with leaf queries
			LeafQuery leafQuery = (LeafQuery) internalQuery;

			// get its facility-type
			String bqpFacilityId = leafQuery.getFqlProcessor().getFacilityId();

			// only if the FQL is not the memory FQL processor, we have to remove transient partitions
			if (!bqpFacilityId.equals(this.memFQL.getFacilityId())) {

				// for each atomic entry
				for (AtomicEntry atomicEntry : leafQuery.getFromEntries()) {
					// get the scope
					Set<URI> scope = atomicEntry.getScope();

					for (Iterator<URI> iter = scope.iterator(); iter.hasNext();) {
						URI scopePRI = iter.next();

						//                        // remove any PRI which is a volatile partition
						//                        if ( scopePRI.isVolatilePartition( ) ) {
						//                            iter.remove( );
						//                        }
					}
				}
			}

			// look for possible nested queries in link predicates
			for (WithEntry withEntry : leafQuery.getWithEntries()) {

				// only deal with link predicates
				if (withEntry instanceof LinksPredicate) {
					NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

					// if not seen before
					if (seenQueries.add(nestedQuery)) {
						this.removeScopedTransientPartitionsInFacilityQueriesForInternalQuery(nestedQuery.getInternalQuery(), seenQueries);
					}
				}
			}

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}
	}

	/**
	 * We adapt the relevantPartitions to the entire set of loaded partitions
	 * (i.e., beyond the dirty partitions) if all of the scopes are entirely
	 * inside the loaded partitions.
	 */
	private void defineRelevantPartitions(InternalQuery internalQuery) {

		// We first determine the (client-specific) loaded partitions
		Set<URI> csLoadedPartitionPRIs = new HashSet<URI>();
		Set<Resource> csLoadedPartitions = new HashSet<Resource>();

		for (Resource partition : this.emfHelper.getLoadedResources()) {
			csLoadedPartitions.add(partition);
			csLoadedPartitionPRIs.add(partition.getURI());
		}
		//        for ( SpiModelPartition partition : this.conn.getSession( ).getCompoundClientSpecWorkspace( ).getPartitionManager( ).getLoadedPartitions( ) ) {
		//            if ( csLoadedPartitionPRIs.add( partition.getPri( ) ) ) {
		//                // Only add a partition from the CompoundClientSpecWorkspace to the set if it has not already been added
		//                // when iterating over the SessionWorkspace (private copies take precedence !)
		//                csLoadedPartitions.add( (CoreModelPartition) partition );
		//            }
		//        }

		// trace some information the current loaded and dirty partitions
		if (logger.isTraced(LogSeverity.DEBUG)) {
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_CURRENT_DIRTY_PARTITIONS);
			if (this.relevantPartitionPRIs != null) {
				for (URI dirtyPartition : this.relevantPartitionPRIs) {
					logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_DIRTY_PARTITION, dirtyPartition);
				}
			}
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_CURRENT_LOADED_PARTITIONS);
			for (URI loadedPartition : csLoadedPartitionPRIs) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_LOADED_PARTITION, loadedPartition.toString());
			}
		}

		// for avoiding duplicate calculations of shared nested queries
		Set<NestedQuery> seenQueries = new HashSet<NestedQuery>();

		// search if the condition applies
		boolean allScopesInLoadedPartitions = this.hasAllScopesInsideCSLoadedPartitions(internalQuery, seenQueries, csLoadedPartitionPRIs,
				true);

		if (allScopesInLoadedPartitions) {
			// If all scopes are inside the loaded partitions, we reset the relevant partitions to the loaded partitions.
			// This guarantees that such a query is purely executed in-memory

			if (logger.isTraced(LogSeverity.INFO)) {
				logger
						.trace(
								LogSeverity.INFO,
								FQLTraceMessages.MQL_PROCESSOR_THE_RELEVANT_PARTITIONS_FOR_SCHEDULING_ARE_UPGRADED_FROM_THE_DIRTY_PARTITIONS_TO_THE_LOADED_PARTITIONS);
			}

			this.relevantPartitionPRIs = csLoadedPartitionPRIs;
			this.relevantPartitions = csLoadedPartitions;

			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_CURRENT_LOADED_PARTITIONS);
				for (URI loadedPartition : csLoadedPartitionPRIs) {
					logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_LOADED_PARTITION, loadedPartition);
				}
			}

		} else {
			// otherwise, the relevant partitions are only the dirty ones and the transient ones which are not empty
			this.relevantPartitions = new HashSet<Resource>();
			this.relevantPartitionPRIs = new HashSet<URI>();

			for (Resource partition : csLoadedPartitions) {
				URI pri = partition.getURI();

				if (!partition.isTrackingModification() || partition.isModified()) {
					// we definitely include all dirty partitions, which are not volatile
					this.relevantPartitions.add(partition);
					this.relevantPartitionPRIs.add(pri);
				}
				//                else if ( partition.getPri( ).isVolatilePartition( ) ) {
				//                    // we also include volatile partitions, but only if they are not empty
				//                    if ( !partition.isEmpty( ) ) {
				//                        this.relevantPartitions.add( partition );
				//                        this.relevantPartitionPRIs.add( pri );
				//                    }
				//                }
			}

			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_CURRENT_DIRTY_AND_NON_EMPTY_TRANSIENT_PARTITIONS);
				for (URI dirtyPartition : this.relevantPartitionPRIs) {
					logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_DIRTY_OR_NOT_EMPTY_TRANSIENT_PARTITION, dirtyPartition);
				}
			}
		}
	}

	/**
	 * This method walks over the entire query and returns true if all scopes
	 * for all atomic entries are entirely contained in the current
	 * client-specific loaded partition space.
	 */
	private boolean hasAllScopesInsideCSLoadedPartitions(InternalQuery internalQuery, Set<NestedQuery> seenQueries,
			Set<URI> csLoadedPartitionPRIs, boolean allScopesInLoadedPartitions) {

		// case analysis
		if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			// go recursively down
			for (Iterator<InternalQuery> iter = operands.iterator(); allScopesInLoadedPartitions && iter.hasNext();) {
				allScopesInLoadedPartitions = this.hasAllScopesInsideCSLoadedPartitions(iter.next(), seenQueries, csLoadedPartitionPRIs,
						allScopesInLoadedPartitions);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			// go recursively down
			allScopesInLoadedPartitions = this.hasAllScopesInsideCSLoadedPartitions(nodeQuery.getFirstFromEntry(), seenQueries,
					csLoadedPartitionPRIs, allScopesInLoadedPartitions);
			if (allScopesInLoadedPartitions) {
				allScopesInLoadedPartitions = this.hasAllScopesInsideCSLoadedPartitions(nodeQuery.getSecondFromEntry(), seenQueries,
						csLoadedPartitionPRIs, allScopesInLoadedPartitions);
			}

		} else if (internalQuery instanceof EmptyQuery) {
			// do not do anything

		} else if (internalQuery instanceof LeafQuery) {
			// deal with leaf queries
			LeafQuery leafQuery = (LeafQuery) internalQuery;

			// collect the atomic entries
			for (Iterator<AtomicEntry> atomicEntryIter = leafQuery.getFromEntries().iterator(); allScopesInLoadedPartitions
					&& atomicEntryIter.hasNext();) {
				AtomicEntry atomicEntry = atomicEntryIter.next();

				// get the scope
				Set<URI> scope = atomicEntry.getScope();
				boolean included = atomicEntry.isScopeInclusive();

				// check if the scope is included in the loaded partition set
				boolean scopeInLoadedPartition = included;
				for (Iterator<URI> scopeIterator = scope.iterator(); scopeInLoadedPartition && scopeIterator.hasNext();) {
					scopeInLoadedPartition = scopeInLoadedPartition && csLoadedPartitionPRIs.contains(scopeIterator.next());
				}
				allScopesInLoadedPartitions = (scopeInLoadedPartition ? allScopesInLoadedPartitions : false);

			}

			// only if condition not invalidated
			if (allScopesInLoadedPartitions) {

				// look for possible nested queries in link predicates
				for (WithEntry withEntry : leafQuery.getWithEntries()) {

					// case analysis
					if (withEntry instanceof LinksPredicate) {
						// for LinksPredicates, we need to work recursively deeper
						NestedQuery nestedQuery = ((LinksPredicate) withEntry).getNestedQuery();

						// if not seen before
						if (seenQueries.add(nestedQuery)) {
							allScopesInLoadedPartitions = this.hasAllScopesInsideCSLoadedPartitions(nestedQuery.getInternalQuery(),
									seenQueries, csLoadedPartitionPRIs, allScopesInLoadedPartitions);
						}
					}
				}
			}
		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		return allScopesInLoadedPartitions;
	}

}
