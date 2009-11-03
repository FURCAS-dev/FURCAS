/*
 * Created on 02.03.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.preprocessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.core.query.messages.FQLTraceMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.internal.AliasName;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicEntry;
import com.sap.tc.moin.repository.core.query.moinql.internal.EmptyQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.LeafQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.LinksPredicate;
import com.sap.tc.moin.repository.core.query.moinql.internal.NestedQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.NodeQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.ResultUnion;
import com.sap.tc.moin.repository.core.query.moinql.internal.WithEntry;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.mql.MQLPreprocessorException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFacilityQueryLanguage;

/**
 * This implementation assigns all known FQLs to the leaf queries. For each
 * known FQL, it duplicates the leaf query and inserts it in a union
 */
final public class MQLFacilityAssignerImpl implements MQLFacilityAssigner {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_MQL, MQLFacilityAssignerImpl.class );

    private Collection<SpiFacilityQueryLanguage> fqlProcessors;

    private int numberOfFqls;

    private MQLAuxServices mqlAuxServices;

    public MQLFacilityAssignerImpl( Collection<SpiFacilityQueryLanguage> fqlProcessors, MQLAuxServices transformationService ) {

        this.fqlProcessors = fqlProcessors;
        this.numberOfFqls = fqlProcessors.size( );
        this.mqlAuxServices = transformationService;
    }

    /* ---------------- */
    /* Public methods */
    /* ---------------- */

    public InternalQuery assign( InternalQuery internalQuery ) throws MQLPreprocessorException {

        InternalQuery newInternalQuery = null;

        try {

            // to avoid redoing the same nested query
            Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>( );

            // Adapt the internal query and assign the FQLs
            newInternalQuery = assignInternalQuery( internalQuery, seenNestedQuery );

        } finally {
            // trace the intermediate result
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_FACILITY_ASSIGNMENT, "\n", ( newInternalQuery == null ? "NULL query" : newInternalQuery ) ); //$NON-NLS-1$ //$NON-NLS-2$
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
    private InternalQuery assignInternalQuery( InternalQuery internalQuery, Set<NestedQuery> seenNestedQuery ) {

        InternalQuery result = internalQuery;

        // case analysis
        if ( internalQuery instanceof LeafQuery ) {
            LeafQuery leafQuery = (LeafQuery) internalQuery;

            if ( this.numberOfFqls < 1 ) {
                throw new MQLBugException( MQLBugMessages.NO_FQL_IN_POOL );
            } else if ( this.numberOfFqls == 1 ) {
                // assign the leaf query
                this.assignLeafQuery( leafQuery, this.fqlProcessors.iterator( ).next( ), seenNestedQuery );

            } else {
                // more than one facility connected, so we have to spread the query

                // Construct union results
                List<InternalQuery> memberLeafQueries = new ArrayList<InternalQuery>( this.numberOfFqls );
                Iterator<SpiFacilityQueryLanguage> fqlIterator = this.fqlProcessors.iterator( );

                // assign the original leaf query
                this.assignLeafQuery( leafQuery, fqlIterator.next( ), seenNestedQuery );

                // add the original leaf query as the first member leaf query
                memberLeafQueries.add( leafQuery );

                // now handle the remaining FQLs
                for ( ; fqlIterator.hasNext( ); ) {
                    // make a clone for each facility
                    LeafQuery clonedLeafQuery = (LeafQuery) this.mqlAuxServices.clone( leafQuery, false, new HashMap<AtomicEntry, AtomicEntry>( ) );

                    // assign the FQL processor
                    this.assignLeafQuery( clonedLeafQuery, fqlIterator.next( ), seenNestedQuery );

                    // finally add to the memberLeafQuery
                    memberLeafQueries.add( clonedLeafQuery );
                }

                // construct the union
                result = new ResultUnion( new AliasName( leafQuery.getAliasName( ) ), memberLeafQueries );
            }

        } else if ( internalQuery instanceof ResultUnion ) {
            List<InternalQuery> operands = ( (ResultUnion) internalQuery ).getOperands( );

            // recursively for all operands of the union
            for ( InternalQuery query : operands ) {
                assignInternalQuery( query, seenNestedQuery );
            }

        } else if ( internalQuery instanceof NodeQuery ) {
            NodeQuery nodeQuery = (NodeQuery) internalQuery;

            InternalQuery firstFromEntry = nodeQuery.getFirstFromEntry( );
            InternalQuery secondFromEntry = nodeQuery.getSecondFromEntry( );

            // recursively for the from Entries, which are always internal queries themselves
            assignInternalQuery( firstFromEntry, seenNestedQuery );
            assignInternalQuery( secondFromEntry, seenNestedQuery );

        } else if ( internalQuery instanceof EmptyQuery ) {
            // nothing to be done
        } else {
            throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass( ).getCanonicalName( ), "InternalQuery" ); //$NON-NLS-1$
        }

        return result;
    }

    /**
     * Assigns the FQL to the leaf query and goes recursively deeper for with
     * links predicates
     */
    private void assignLeafQuery( LeafQuery leafQuery, SpiFacilityQueryLanguage fql, Set<NestedQuery> seenNestedQuery ) {

        leafQuery.setFqlProcessor( fql );

        // recursively for the with entries, as they may contain nested queries
        for ( WithEntry withEntry : leafQuery.getWithEntries( ) ) {
            if ( withEntry instanceof LinksPredicate ) {
                LinksPredicate linksPredicate = (LinksPredicate) withEntry;
                NestedQuery nestedQuery = linksPredicate.getNestedQuery( );

                // but only if not already seen
                if ( seenNestedQuery.add( nestedQuery ) ) {
                    InternalQuery resultQuery = assignInternalQuery( nestedQuery.getInternalQuery( ), seenNestedQuery );
                    nestedQuery.setInternalQuery( resultQuery );
                }
            }
        }
    }
}
