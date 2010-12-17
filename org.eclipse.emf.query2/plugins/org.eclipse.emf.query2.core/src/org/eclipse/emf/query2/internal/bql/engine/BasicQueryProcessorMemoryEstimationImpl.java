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
package org.eclipse.emf.query2.internal.bql.engine;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query2.internal.bql.api.SpiAbstractBasicQueryProcessor;
import org.eclipse.emf.query2.internal.bql.api.SpiBasicQueryProcessor;
import org.eclipse.emf.query2.internal.bql.api.SpiClusterExternalLinkExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiClusterInternalLinkExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementClusterExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiModelElementExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiMriSetLinkExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiPartitionExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectExpression;
import org.eclipse.emf.query2.internal.bql.api.SpiSelectList;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.index.IndexQueryService;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryClientScope;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.ast.QueryResultSetImpl;
import org.eclipse.emf.query2.internal.moinql.engine.CoreQueryClientScope;
import org.eclipse.emf.query2.internal.shared.BugException;
import org.eclipse.emf.query2.internal.shared.EmfHelper;

/**
 * @author D045917
 */
public class BasicQueryProcessorMemoryEstimationImpl extends SpiAbstractBasicQueryProcessor {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(BasicQueryProcessorMemoryEstimationImpl.class);

	// we need a memory FQL
	private SpiBasicQueryProcessor memFQL;

	/**
	 * We keep an instance of the slim index query service
	 */
	protected Index index;

	/**
	 * Pass the slim index query service
	 */
	public BasicQueryProcessorMemoryEstimationImpl(Index index) {

		super("VZE"); //$NON-NLS-1$
		this.index = index;
		// wraps a memory FQL
		this.memFQL = new BasicQueryProcessorMemoryImpl();
	}

	@Override
	public SpiFqlQueryResultSet execute(EmfHelper _emfHelper, SpiFacilityQueryClientScope queryClientScope,
			SpiSelectExpression selectExpression, int maxResultSetSize, int numberOfRequestedRows) {

		// verify consistency of query and client scope
		this.verifyConsistencyOfQuery(queryClientScope, selectExpression);

		// obtain connection from client scope
		//        CoreConnection conn = ( (CoreQueryClientScope) queryClientScope ).getConnection( );

		// (1) check if we have a simple query of the nature refAllOfType/refAllOfClass
		if (this.isVerySimpleQuery(selectExpression)) {
			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO,
						FQLTraceMessages.MQL_PROCESSOR_BQL_QUERY_OF_NATURE_REFALLOFTYPE_REFALLOFCLASS_FAST_SLIM_INDEX_EXECUTION_POSSIBLE);
			}
			return this.executeVerySimpleQuery(selectExpression);
		}

		// perform scope estimation for provided BQL
		long timeStamp = System.nanoTime();

		long time;

		// (2) estimate and reduce the scope per modelElementExpression in the selectExpression
		this.estimate(selectExpression.getModelElementClusterExpression());

		// (3) collect the new global and included scope over all modelElementExpressions
		Set<URI> globalScope = this.collectPartitionFromReducedScope(selectExpression.getModelElementClusterExpression());

		if (logger.isTraced(LogSeverity.INFO)) {
			time = (System.nanoTime() - timeStamp) / 1000000;
			logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_BQL_ESTIMATION_FINISHED_IN, time);
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_ESTIMATION_PRODUCED_FOLLOWING_QUERY, selectExpression);
			}
		}

		// go now through the partition list and load them all if not already done
		loadScopeResources(_emfHelper, globalScope);

		timeStamp = System.nanoTime();

		// adapt the query client scope
		CoreQueryClientScope newQueryClientScope = new CoreQueryClientScope(globalScope, true);

		// now actually execute the query with the regular memory FQL processor
		SpiFqlQueryResultSet resultSet = this.memFQL.execute(_emfHelper, newQueryClientScope, selectExpression, maxResultSetSize,
				numberOfRequestedRows);

		if (logger.isTraced(LogSeverity.INFO)) {
			time = (System.nanoTime() - timeStamp) / 1000000;
			logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_BQL_IN_MEMORY_EXECUTION_FINISHED, time);
		}

		return resultSet;
	}

	private void loadScopeResources(EmfHelper _emfHelper, Set<URI> globalScope) {
		long timeStamp;
		long time;
		for (URI pri : globalScope) {
			// load the PRI
			timeStamp = System.nanoTime();
			_emfHelper.getResource(pri);
			// trace
			if (logger.isTraced(LogSeverity.DEBUG)) {
				time = (System.nanoTime() - timeStamp) / 1000000;
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_LOADING_PARTITION_TIME, pri, time);
			}
		}
	}

	/**
	 * Checks the consistency of the query and returns a connection from the query client scope
	 */
	private void verifyConsistencyOfQuery(SpiFacilityQueryClientScope queryClientScope, SpiSelectExpression selectExpression) {

		// check if the BQL query is consistent
		long timeStamp = System.nanoTime();
		this.checkQueryConsistency(selectExpression);
		long time = 0;

		if (logger.isTraced(LogSeverity.DEBUG)) {
			time = (System.nanoTime() - timeStamp) / 1000000;
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_VERIFICATION_FINISHED, time);
		}

		// only global scope permitted
		if (!(!queryClientScope.isPartitionScopeInclusive() && queryClientScope.getPartitionsScope().isEmpty())) {
			throw new BugException(BugMessages.NON_RESTRICTED_SCOPE_FOR_FQL_QUERY);
		}
	}

	/**
	 * Checks if the query is of the nature refAllOfKind/refAllOfClass. This also includes queries with fixed elements and/or partition
	 * scopes as long as only one fromType is involved.
	 */
	private boolean isVerySimpleQuery(SpiSelectExpression selectExpression) {

		SpiSelectList[] selectLists = selectExpression.getSelectLists();

		// not more than one selection
		if (selectLists.length != 1) {
			return false;
		}

		// not of attribute kind
		if (selectLists[0].getNumberOfAttributeDefinitions() > 0) {
			return false;
		}

		SpiModelElementClusterExpression mece = selectExpression.getModelElementClusterExpression();

		// not more than one from-type
		if (mece.getTotalNumberOfModelElementExpressions() != 1) {
			return false;
		}

		// no mri set links
		if (mece.getMriSetLinks() != null && !mece.getMriSetLinks().isEmpty()) {
			return false;
		}

		// no external links
		if (mece.getClusterExternalLinks() != null && mece.getClusterExternalLinks().size() > 0) {
			return false;
		}

		SpiModelElementExpression mee = mece.getHeaderModelElementExpression();

		// no attribute expressions
		if (mee.getAttributeExpression() != null) {
			return false;
		}

		return true;
	}

	/**
	 * Assumes that {@link #isVerySimpleQuery(SpiSelectExpression)} holds and then executes the query without loading anything in memory
	 */
	@SuppressWarnings("unchecked")
	private SpiFqlQueryResultSet executeVerySimpleQuery(SpiSelectExpression selectExpression) {

		// we start out with the empty result set
		SpiSelectList[] selectLists = selectExpression.getSelectLists();
		int[] numberOfSelectedAttributesPerList = new int[selectLists.length];
		for (int i = 0; i < selectLists.length; i++) {
			numberOfSelectedAttributesPerList[i] = selectLists[i].getNumberOfAttributeDefinitions();
		}

		// obtain the scope properties
		SpiPartitionExpression pe = selectExpression.getModelElementClusterExpression().getHeaderModelElementExpression()
				.getPartitionExpression();
		boolean included = (pe == null ? false : pe.isIncludeList());
		Set<URI> pris = (pe == null ? Collections.EMPTY_SET : pe.getPartitionSet());

		// obtain possible fixed elements
		Collection<URI> elements = selectExpression.getModelElementClusterExpression().getHeaderModelElementExpression().getElementsSet();

		// for the result
		SpiFqlQueryResultSet resultSet = new QueryResultSetImpl(numberOfSelectedAttributesPerList);

		if (elements == null || elements.size() == 0) {
			// if we have no fixed elements, we calculate the regular instances 

			// first get the types
			URI[] types = selectExpression.getModelElementClusterExpression().getHeaderModelElementExpression().getTypes();

			CoreQueryClientScope queryClientScope = new CoreQueryClientScope(pris, included);

			try {
				// obtain the instances from the index
				elements = IndexQueryService.getInstances(this.index, queryClientScope, types);
			} catch (IllegalArgumentException e) {
				// this can only happen whenever we have Reflect::Element with and exclusive scope
				throw new SpiFacilityQueryServiceException(e, SpiFacilityQueryServiceException.ERROR_CODE_REFLECT_ELEMENT,
						ApiMessages.MUST_RESTRICT_SCOPE_FOR_ELEMENT);
			}

			// construct the result
			for (URI mri : elements) {
				int resultPos = resultSet.addEmptyEntry();
				resultSet.setMri(resultPos, 0, mri);
			}

		} else {
			// follow scope restrictions 
			if (included) {
				// run over the elements and if included in the scope, add them to the result set
				for (URI mri : elements) {
					if (pris.contains(mri.trimFragment())) {
						int resultPos = resultSet.addEmptyEntry();
						resultSet.setMri(resultPos, 0, mri);
					}
				}
			} else {
				// run over the elements and if not included in the scope, add them to the result set
				for (URI mri : elements) {
					if (!pris.contains(mri.trimFragment())) {
						int resultPos = resultSet.addEmptyEntry();
						resultSet.setMri(resultPos, 0, mri);
					}
				}
			}
		}

		return resultSet;
	}

	/**
	 * Adjust estimated scope of incoming BQL
	 */
	protected void estimate(SpiModelElementClusterExpression meClusterExpression) {

		/*
		 * Phase 1) turn each model element expression into an inclusion scope. Scopes of structure types are explicitly not considered.
		 */

		long timeStamp = System.nanoTime();
		this.adaptScopeForInstancesOfTypes(meClusterExpression);
		long time = 0;

		if (logger.isTraced(LogSeverity.DEBUG)) {
			time = (System.nanoTime() - timeStamp) / 1000000;
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INSTANCE_ESTIMATION_IN, time);
		}

		/*
		 * Phase 2) reduce the inclusion scope between two non-structure typed model element expressions whenever no cross-linking exists
		 * between a partition and all other partitions Phase 3) collect all available inclusion scopes to determine the new estimationSet.
		 * Observe that no exclusion scopes exist. Finally, collect the partitions in which fixed elements are considered
		 */
		timeStamp = System.nanoTime();
		this.adaptScopeForCrossPartitionLinks(meClusterExpression);

		if (logger.isTraced(LogSeverity.DEBUG)) {
			time = (System.nanoTime() - timeStamp) / 1000000;
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_CROSS_LINK_ESTIMATION, time);
		}

	}

	/**
	 * Provide global scope in which the query can be executed
	 */
	private Set<URI> collectPartitionFromReducedScope(SpiModelElementClusterExpression meClusterExpression) {

		// this set is build up to keep track of the estimation.
		Set<URI> estimationSet = new HashSet<URI>();
		long timeStamp = System.nanoTime();
		this.collectEstimationSet(estimationSet, meClusterExpression);

		if (logger.isTraced(LogSeverity.DEBUG)) {
			long time = (System.nanoTime() - timeStamp) / 1000000;
			logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_COLLECTION_ESTIMATION, time);
		}

		// we return the new global estimation
		return estimationSet;
	}

	/**
	 * Turn each model element expression into an inclusion scope. Scopes of structure types are explicitly eliminated.
	 */
	private void adaptScopeForInstancesOfTypes(SpiModelElementClusterExpression meClusterExpression) {

		// handle the head model element expression
		SpiModelElementExpression mee = meClusterExpression.getHeaderModelElementExpression();
		this.adaptScopeForInstancesOfTypesInMee(mee);

		// handle the other mees
		List<SpiModelElementExpression> mees = meClusterExpression.getAdditionalModelElementExpressions();
		for (SpiModelElementExpression meeInList : mees) {
			this.adaptScopeForInstancesOfTypesInMee(meeInList);
		}

		// go into externally linked clusters
		List<SpiClusterExternalLinkExpression> externalLinkExpressions = meClusterExpression.getClusterExternalLinks();
		for (SpiClusterExternalLinkExpression clusterExternalLinkExpression : externalLinkExpressions) {
			SpiModelElementClusterExpression nestedMeClusterExpression = clusterExternalLinkExpression.getLinkTarget();
			// go recursively down
			this.adaptScopeForInstancesOfTypes(nestedMeClusterExpression);
		}
	}

	/**
	 * If possible, an inclusion scope is calculated based on 1) a possibly existing scope 2) the involved partitions for the provided
	 * types. Structure Types are not given a scope; If no types are provided, we expect an existing inclusion scope which is fine and thus
	 * can also be ignored here
	 */
	private void adaptScopeForInstancesOfTypesInMee(SpiModelElementExpression mee) {

		// obtain the category
		SpiFqlFromTypeCategory meeCategory = mee.getModelElementCategory();

		// we only do something if we have a model element (no structure type) and not a fixed element set
		// note that in the global estimation, we ignore structure types in the collection process
		if (meeCategory.equals(SpiFqlFromTypeCategory.CLASS) && !mee.hasElements()) {
			CoreQueryClientScope newClientScope = new CoreQueryClientScope(mee.getScope(), mee.scopeIsIncluded());

			Set<URI> newScope = IndexQueryService.getPartitionsOfInstances(this.index, newClientScope, mee.getTypes());
			SpiPartitionExpression newPartitionExp = new SpiPartitionExpression(newScope.toArray(new URI[newScope.size()]), true);
			mee.setPartitionExpression(newPartitionExp);
		}
	}

	/**
	 * Reduce the inclusion scope between two non-structure typed model element expressions whenever no cross-linking exists between a
	 * partition and all other partitions
	 */
	private void adaptScopeForCrossPartitionLinks(SpiModelElementClusterExpression meClusterExpression) {

		// first handle all cluster internal links (which cannot be negated)
		List<SpiClusterInternalLinkExpression> internalLinks = meClusterExpression.getClusterInternalLinks();

		for (SpiClusterInternalLinkExpression clusterInternalLinkExpression : internalLinks) {
			SpiModelElementExpression me1 = clusterInternalLinkExpression.getFromModelElementExpression();
			SpiModelElementExpression me2 = clusterInternalLinkExpression.getLinkTarget();
			// we can only try to reduce the scope in the case of CLASS-based me expressions
			if (me1.getModelElementCategory().equals(SpiFqlFromTypeCategory.CLASS)
					&& me2.getModelElementCategory().equals(SpiFqlFromTypeCategory.CLASS)) {
				//                boolean storageAtMe1 = clusterInternalLinkExpression.getStorageEnd( ) != clusterInternalLinkExpression.getAssociationEndOfLinkedObject( );
				//                if ( storageAtMe1 ) {
				this.adaptScopeForCrossPartitionLinksBetweenTwoMeExpressions(true, me1, me2, clusterInternalLinkExpression.getLinkType());
				//                } else {
				//                    this.adaptScopeForCrossPartitionLinksBetweenTwoMeExpressions( conn, true, me2, me1, clusterInternalLinkExpression.getLinkType( ) );
				//                }
			}
		}

		// then handle cluster external links and go recursively deeper
		List<SpiClusterExternalLinkExpression> externalLinks = meClusterExpression.getClusterExternalLinks();

		for (SpiClusterExternalLinkExpression clusterExternalLinkExpression : externalLinks) {
			SpiModelElementExpression me1 = clusterExternalLinkExpression.getFromModelElementExpression();
			SpiModelElementClusterExpression cluster = clusterExternalLinkExpression.getLinkTarget();
			SpiModelElementExpression me2 = cluster.getHeaderModelElementExpression();
			// we can only try to reduce the scope in the case of CLASS-based me expressions
			if (me1.getModelElementCategory().equals(SpiFqlFromTypeCategory.CLASS)
					&& me2.getModelElementCategory().equals(SpiFqlFromTypeCategory.CLASS)) {
				//                boolean storageAtMe1 = clusterExternalLinkExpression.getStorageEnd( ) != clusterExternalLinkExpression.getAssociationEndOfLinkedObject( );
				//                if ( storageAtMe1 ) {
				this.adaptScopeForCrossPartitionLinksBetweenTwoMeExpressions(clusterExternalLinkExpression.isLinked(), me1, me2,
						clusterExternalLinkExpression.getLinkType());
				//                } else {
				//                    this.adaptScopeForCrossPartitionLinksBetweenTwoMeExpressions( conn, clusterExternalLinkExpression.isLinked( ), me2, me1, clusterExternalLinkExpression.getLinkType( ) );
				//                }
			}

			// work recursively on the nested cluster
			this.adaptScopeForCrossPartitionLinks(cluster);
		}

		// then handle fixed MRI link sets
		List<SpiMriSetLinkExpression> mriSetLinkExpressions = meClusterExpression.getMriSetLinks();

		for (SpiMriSetLinkExpression mriSetLinkExpression : mriSetLinkExpressions) {

			SpiModelElementExpression me1 = mriSetLinkExpression.getFromModelElementExpression();

			// we can only try to reduce the scope in the case of CLASS-based me expressions
			if (me1.getModelElementCategory().equals(SpiFqlFromTypeCategory.CLASS)) {
				//                boolean storageAtMe1 = mriSetLinkExpression.getStorageEnd( ) != mriSetLinkExpression.getAssociationEndOfLinkedObject( );
				//                if ( storageAtMe1 ) {
				this.adaptScopeForCrossPartitionLinksBetweenMeAndSet(mriSetLinkExpression.isLinked(), true, me1, mriSetLinkExpression
						.getLinkTargetElementsSet(), mriSetLinkExpression.getLinkType());
				//                } else {
				//                    this.adaptScopeForCrossPartitionLinksBetweenMeAndSet( conn, mriSetLinkExpression.isLinked( ), false, me1, mriSetLinkExpression.getLinkTargetElementsSet( ), mriSetLinkExpression.getLinkType( ) );
				//                }
			}
		}
	}

	private void adaptScopeForCrossPartitionLinksBetweenMeAndSet(boolean linkExists, boolean meHasStorage, SpiModelElementExpression me,
			Set<URI> fixedElementSet, URI assocMri) {

		// we obtain the virtual partition scope on both sides (since we also
		// want to handle fixed element sets

		Set<URI> fromMeScope;
		Set<URI> toMeScope;

		if (meHasStorage) {
			if (me.hasElements()) {
				fromMeScope = new HashSet<URI>();
				for (URI el : me.getElementsSet()) {
					fromMeScope.add(el.trimFragment());
				}
			} else {
				fromMeScope = me.getScope();
			}

			toMeScope = new HashSet<URI>();
			for (URI el : fixedElementSet) {
				toMeScope.add(el.trimFragment());
			}

		} else {
			throw new IllegalArgumentException();
			//            if ( me.hasElements( ) ) {
			//                toMeScope = new HashSet<PRI>( );
			//                for ( MRI el : me.getElementsSet( ) ) {
			//                    toMeScope.add( el.getPri( ) );
			//                }
			//            } else {
			//                toMeScope = me.getScope( );
			//            }
			//
			//            fromMeScope = new HashSet<PRI>( );
			//            for ( MRI el : fixedElementSet ) {
			//                fromMeScope.add( el.getPri( ) );
			//            }
		}

		// We need two sets in which we maintain the new scopes
		Set<URI> resultingFromMeScope = new HashSet<URI>(fromMeScope.size());
		Set<URI> resultingToMeScope = new HashSet<URI>(toMeScope.size());

		this.adaptScopeForCrossPartitionLinksBasedOnScopes(linkExists, fromMeScope, resultingFromMeScope, toMeScope, resultingToMeScope,
				assocMri);

		// set the new scope
		if (meHasStorage) {
			if (me.hasElements()) {
				// more work when we are dealing with fixed elements
				Set<URI> elements = me.getElementsSet();
				for (Iterator<URI> iterator = elements.iterator(); iterator.hasNext();) {
					URI mri = iterator.next();
					if (!resultingFromMeScope.contains(mri.trimFragment())) {
						iterator.remove();
					}
				}
				me.setElements(elements);
			} else {
				SpiPartitionExpression pe = new SpiPartitionExpression(resultingFromMeScope.toArray(new URI[resultingFromMeScope.size()]),
						true);
				me.setPartitionExpression(pe);
			}

			// more work when we are dealing with fixed elements
			for (Iterator<URI> iterator = fixedElementSet.iterator(); iterator.hasNext();) {
				URI mri = iterator.next();
				if (!resultingToMeScope.contains(mri.trimFragment())) {
					iterator.remove();
				}
			}

		} else {
			throw new IllegalArgumentException();
			//            if ( me.hasElements( ) ) {
			//                // more work when we are dealing with fixed elements
			//                Set<MRI> elements = me.getElementsSet( );
			//                for ( Iterator<MRI> iterator = elements.iterator( ); iterator.hasNext( ); ) {
			//                    MRI mri = iterator.next( );
			//                    if ( !resultingToMeScope.contains( mri.getPri( ) ) ) {
			//                        iterator.remove( );
			//                    }
			//                }
			//                me.setElements( elements );
			//            } else {
			//                SpiPartitionExpression pe = new SpiPartitionExpression( resultingToMeScope.toArray( new PRI[resultingToMeScope.size( )] ), true );
			//                me.setPartitionExpression( pe );
			//            }
			//
			//            // more work when we are dealing with fixed elements
			//            for ( Iterator<MRI> iterator = fixedElementSet.iterator( ); iterator.hasNext( ); ) {
			//                MRI mri = iterator.next( );
			//                if ( !resultingFromMeScope.contains( mri.getPri( ) ) ) {
			//                    iterator.remove( );
			//                }
			//            }
		}
	}

	/**
	 * Storage is at fromMe. If linkExists, then we estimate between the two ModelElementExpressions for the existence of a link. Otherwise,
	 * we have little estimation possibilities. Note: handling of fixed element set and regular model element expressions (with PRI scope)
	 * is different because they are not alligned anymore in BQL. In FQL, this complication would not exist!
	 */
	private void adaptScopeForCrossPartitionLinksBetweenTwoMeExpressions(boolean linkExists, SpiModelElementExpression fromMe,
			SpiModelElementExpression toMe, URI assocMri) {

		boolean fromMeHasElements = fromMe.hasElements();
		boolean toMeHasElements = toMe.hasElements();

		// we obtain the virtual partition scope on both sides (since we also
		// want to handle fixed element sets)

		// for the From Element
		Set<URI> fromMeScope = fromMe.getScope();

		// REMARK: in BQL, the presence of fixed elements excludes the presence of scope and the other way around!

		if (fromMeHasElements) {
			fromMeScope = new HashSet<URI>();
			for (URI el : fromMe.getElementsSet()) {
				fromMeScope.add(el.trimFragment());
			}
		}

		// for the To Element
		Set<URI> toMeScope = toMe.getScope();

		if (toMeHasElements) {
			toMeScope = new HashSet<URI>();
			for (URI el : toMe.getElementsSet()) {
				toMeScope.add(el.trimFragment());
			}
		}

		// We need two sets in which we maintain the new scopes
		Set<URI> resultingFromMeScope = new HashSet<URI>(fromMeScope.size());
		Set<URI> resultingToMeScope = new HashSet<URI>(toMeScope.size());

		this.adaptScopeForCrossPartitionLinksBasedOnScopes(linkExists, fromMeScope, resultingFromMeScope, toMeScope, resultingToMeScope,
				assocMri);

		// set the new scope

		// for the From Element
		if (fromMeHasElements) {
			// more work when we are dealing with fixed elements
			Set<URI> elements = fromMe.getElementsSet();
			for (Iterator<URI> iterator = elements.iterator(); iterator.hasNext();) {
				URI mri = iterator.next();
				if (!resultingFromMeScope.contains(mri.trimFragment())) {
					iterator.remove();
				}
			}
			fromMe.setElements(elements);

		} else {
			// otherwise, just set new scope
			SpiPartitionExpression pe = new SpiPartitionExpression(resultingFromMeScope.toArray(new URI[resultingFromMeScope.size()]), true);
			fromMe.setPartitionExpression(pe);
		}

		// for the To Element
		if (toMeHasElements) {
			// more work when we are dealing with fixed elements
			Set<URI> elements = toMe.getElementsSet();
			for (Iterator<URI> iterator = elements.iterator(); iterator.hasNext();) {
				URI mri = iterator.next();
				if (!resultingToMeScope.contains(mri.trimFragment())) {
					iterator.remove();
				}
			}
			toMe.setElements(elements);
		} else {
			SpiPartitionExpression pe = new SpiPartitionExpression(resultingToMeScope.toArray(new URI[resultingToMeScope.size()]), true);
			toMe.setPartitionExpression(pe);
		}
	}

	/**
	 * We try to reduce the scope for two model element expressions based on whether the link is supposed to exist or whether it is not
	 * supposed to exist. The fromMe has storage on its side.
	 */
	private void adaptScopeForCrossPartitionLinksBasedOnScopes(boolean linkExists, Set<URI> fromMeScope, Set<URI> resultingFromMeScope,
			Set<URI> toMeScope, Set<URI> resultingToMeScope, URI assocMri) {

		// we start by entering the PRIs which exist in both scopes as we are
		// not able to make any statements about intra-partition links // FIXME thats not true anymore
		for (URI pri : fromMeScope) {
			if (toMeScope.contains(pri)) {
				resultingFromMeScope.add(pri);
				resultingToMeScope.add(pri);
			}
		}

		// for each fromMeScope partition, obtain all linked partitions and check if this partition exists
		// in the toMeScope. If the connected partition is not the one under consideration, then assume
		// the existence of a cross partition link for the fromPri as well as the connected PRI. Put the
		// fromPri in the resultingFromMeScope and the connectedPri in the resultingToMeScope
		for (URI fromPri : fromMeScope) {

			if (!linkExists && toMeScope.isEmpty()) {
				resultingFromMeScope.add(fromPri);
			} else {
				// obtain the cross-links from this PRI - don't ask for a negative "linkExists"
				CoreQueryClientScope queryClientScope = new CoreQueryClientScope();
				Set<URI> connectedPrisSet = (linkExists ? IndexQueryService.getLinkedPartitions(this.index, queryClientScope, fromPri,
						assocMri) : null);

				// run over the toMeScope
				for (URI toPri : toMeScope) {
					// ignore when dealing with a "shared" PRI
					if (!toPri.equals(fromPri)) {
						if (!linkExists || connectedPrisSet.contains(toPri)) {
							// if we have a positive statement, i.e. a link should exist and we have a cross partition link,
							// we keep the respective partitions in the respective scopes.

							// if we have a negative statement (i.e. we are looking for the absence of links), we cannot make 
							// any assumptions at all, so we need to keep all cross partition links, independent on whether 
							// isConnectedViaCrossPartitionLink is true

							resultingFromMeScope.add(fromPri);
							resultingToMeScope.add(toPri);
						}
					}
				}
			}
		}
	}

	/**
	 * Collect all available inclusion scopes to determine the new estimationSet. Observe that no exclusion scopes exist
	 */
	private void collectEstimationSet(Set<URI> estimationSet, SpiModelElementClusterExpression meClusterExpression) {

		// handle the head model element expression
		SpiModelElementExpression mee = meClusterExpression.getHeaderModelElementExpression();
		this.collectEstimationSetMee(estimationSet, mee);

		// handle the other mees
		List<SpiModelElementExpression> mees = meClusterExpression.getAdditionalModelElementExpressions();
		for (SpiModelElementExpression meeInList : mees) {
			this.collectEstimationSetMee(estimationSet, meeInList);
		}

		// go into externally linked clusters
		List<SpiClusterExternalLinkExpression> externalLinkExpressions = meClusterExpression.getClusterExternalLinks();
		for (SpiClusterExternalLinkExpression clusterExternalLinkExpression : externalLinkExpressions) {
			SpiModelElementClusterExpression nestedMeClusterExpression = clusterExternalLinkExpression.getLinkTarget();
			// go recursively down
			this.collectEstimationSet(estimationSet, nestedMeClusterExpression);
		}

		// go ino the fixed mri sets
		List<SpiMriSetLinkExpression> mriSetLinkExpressions = meClusterExpression.getMriSetLinks();
		for (SpiMriSetLinkExpression mriSetLinkExpression : mriSetLinkExpressions) {
			// observe that we do not make a distinction between negative and positive includes
			// if a fixed element set exists, include its partitions
			for (URI mri : mriSetLinkExpression.getLinkTargetElementsSet()) {
				estimationSet.add(mri.trimFragment());
			}
		}
	}

	/**
	 * Collect the inclusion scope for a model element expression
	 */
	private void collectEstimationSetMee(Set<URI> estimationSet, SpiModelElementExpression mee) {

		// we only collect for non-structure types, because they are always resolved within partition of regular objects to which they belong
		if (mee.getModelElementCategory().equals(SpiFqlFromTypeCategory.CLASS)) {

			// consider a possibly existing scope
			Set<URI> scope = mee.getScope(); // if no scope was calculated, this set is empty
			estimationSet.addAll(scope);
			// if a fixed element set exists, include its partitions
			Set<URI> elements = mee.getElementsSet();
			if (elements != null) {
				for (URI mri : elements) {
					estimationSet.add(mri.trimFragment());
				}
			}

		}
	}
}
