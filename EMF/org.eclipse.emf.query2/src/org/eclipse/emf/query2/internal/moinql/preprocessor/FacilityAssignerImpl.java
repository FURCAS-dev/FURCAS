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
 * Created on 02.03.2006
 */
package org.eclipse.emf.query2.internal.moinql.preprocessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.query2.QueryPreprocessorException;
import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.ast.AliasName;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntry;
import org.eclipse.emf.query2.internal.moinql.ast.EmptyQuery;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LeafQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LinksPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.NestedQuery;
import org.eclipse.emf.query2.internal.moinql.ast.NodeQuery;
import org.eclipse.emf.query2.internal.moinql.ast.ResultUnion;
import org.eclipse.emf.query2.internal.moinql.ast.WithEntry;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;


/**
 * This implementation assigns all known FQLs to the leaf queries. For each
 * known FQL, it duplicates the leaf query and inserts it in a union
 */
final public class FacilityAssignerImpl implements FacilityAssigner {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(FacilityAssignerImpl.class);

	//	private Collection<SpiFacilityQueryLanguage> fqlProcessors;

	//	private int numberOfFqls;

	private AuxServices mqlAuxServices;

	public FacilityAssignerImpl(AuxServices transformationService) {
		//		public MQLFacilityAssignerImpl(Collection<SpiFacilityQueryLanguage> fqlProcessors, MQLAuxServices transformationService) {

		//		this.fqlProcessors = fqlProcessors;
		//		this.numberOfFqls = fqlProcessors.size();
		this.mqlAuxServices = transformationService;
	}

	/* ---------------- */
	/* Public methods */
	/* ---------------- */

	public InternalQuery assign(InternalQuery internalQuery, Collection<SpiFacilityQueryLanguage> fqlProcessors)
			throws QueryPreprocessorException {

		assert fqlProcessors != null;

		InternalQuery newInternalQuery = null;

		try {

			// to avoid redoing the same nested query
			Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>();

			// Adapt the internal query and assign the FQLs
			newInternalQuery = this.assignInternalQuery(internalQuery, seenNestedQuery, fqlProcessors);

		} finally {
			// trace the intermediate result
			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_FACILITY_ASSIGNMENT,
						"\n", (newInternalQuery == null ? "NULL query" : newInternalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return newInternalQuery;
	}

	/* ----------------- */
	/* Private methods */
	/* ----------------- */

	/**
	 * Assigns the FQLs to all internal-queries which are leaf nodes, or
	 * recursively down for all the others. Split in unions if necessary
	 */
	private InternalQuery assignInternalQuery(InternalQuery internalQuery, Set<NestedQuery> seenNestedQuery,
			Collection<SpiFacilityQueryLanguage> fqlProcessors) {

		InternalQuery result = internalQuery;

		// case analysis
		if (internalQuery instanceof LeafQuery) {
			LeafQuery leafQuery = (LeafQuery) internalQuery;

			int numberOfFqls = fqlProcessors.size();

			if (numberOfFqls < 1) {
				throw new BugException(BugMessages.NO_FQL_IN_POOL);
			} else if (numberOfFqls == 1) {
				// assign the leaf query
				this.assignLeafQuery(leafQuery, fqlProcessors.iterator().next(), seenNestedQuery, fqlProcessors);

			} else {
				// more than one facility connected, so we have to spread the query

				// Construct union results
				List<InternalQuery> memberLeafQueries = new ArrayList<InternalQuery>(numberOfFqls);
				Iterator<SpiFacilityQueryLanguage> fqlIterator = fqlProcessors.iterator();

				// assign the original leaf query
				this.assignLeafQuery(leafQuery, fqlIterator.next(), seenNestedQuery, fqlProcessors);

				// add the original leaf query as the first member leaf query
				memberLeafQueries.add(leafQuery);

				// now handle the remaining FQLs
				for (; fqlIterator.hasNext();) {
					// make a clone for each facility
					LeafQuery clonedLeafQuery = (LeafQuery) this.mqlAuxServices.clone(leafQuery, false,
							new HashMap<AtomicEntry, AtomicEntry>());

					// assign the FQL processor
					this.assignLeafQuery(clonedLeafQuery, fqlIterator.next(), seenNestedQuery, fqlProcessors);

					// finally add to the memberLeafQuery
					memberLeafQueries.add(clonedLeafQuery);
				}

				// construct the union
				result = new ResultUnion(new AliasName(leafQuery.getAliasName()), memberLeafQueries);
			}

		} else if (internalQuery instanceof ResultUnion) {
			List<InternalQuery> operands = ((ResultUnion) internalQuery).getOperands();

			// recursively for all operands of the union
			for (InternalQuery query : operands) {
				this.assignInternalQuery(query, seenNestedQuery, fqlProcessors);
			}

		} else if (internalQuery instanceof NodeQuery) {
			NodeQuery nodeQuery = (NodeQuery) internalQuery;

			InternalQuery firstFromEntry = nodeQuery.getFirstFromEntry();
			InternalQuery secondFromEntry = nodeQuery.getSecondFromEntry();

			// recursively for the from Entries, which are always internal queries themselves
			this.assignInternalQuery(firstFromEntry, seenNestedQuery, fqlProcessors);
			this.assignInternalQuery(secondFromEntry, seenNestedQuery, fqlProcessors);

		} else if (internalQuery instanceof EmptyQuery) {
			// nothing to be done
		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass().getCanonicalName(), "InternalQuery"); //$NON-NLS-1$
		}

		return result;
	}

	/**
	 * Assigns the FQL to the leaf query and goes recursively deeper for with
	 * links predicates
	 */
	private void assignLeafQuery(LeafQuery leafQuery, SpiFacilityQueryLanguage fql, Set<NestedQuery> seenNestedQuery,
			Collection<SpiFacilityQueryLanguage> fqlProcessors) {

		leafQuery.setFqlProcessor(fql);

		// recursively for the with entries, as they may contain nested queries
		for (WithEntry withEntry : leafQuery.getWithEntries()) {
			if (withEntry instanceof LinksPredicate) {
				LinksPredicate linksPredicate = (LinksPredicate) withEntry;
				NestedQuery nestedQuery = linksPredicate.getNestedQuery();

				// but only if not already seen
				if (seenNestedQuery.add(nestedQuery)) {
					InternalQuery resultQuery = this.assignInternalQuery(nestedQuery.getInternalQuery(), seenNestedQuery, fqlProcessors);
					nestedQuery.setInternalQuery(resultQuery);
				}
			}
		}
	}
}
