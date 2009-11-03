/*
 * Created on 02.03.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.preprocessor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.query.messages.FQLTraceMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.internal.AliasName;
import com.sap.tc.moin.repository.core.query.moinql.internal.AssocPredicate;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicEntry;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicEntryFixedSet;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicEntryReference;
import com.sap.tc.moin.repository.core.query.moinql.internal.AttrComparison;
import com.sap.tc.moin.repository.core.query.moinql.internal.EmptyQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.LeafQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.LinksPredicate;
import com.sap.tc.moin.repository.core.query.moinql.internal.NestedQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.NodeQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.ResultUnion;
import com.sap.tc.moin.repository.core.query.moinql.internal.TypeComparison;
import com.sap.tc.moin.repository.core.query.moinql.internal.WithEntry;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.mql.MQLPreprocessorException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlFromTypeCategory;

/**
 * @author D045917
 * @version 02.03.2006
 */
final public class MQLExpanderImpl implements MQLExpander {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_MQL, MQLExpanderImpl.class );

    private MQLAuxServices mqlAuxServices;

    public MQLExpanderImpl( MQLAuxServices transformationService ) {

        this.mqlAuxServices = transformationService;
    }

    /* -------------- */
    /* Public methods */
    /* -------------- */

    public InternalQuery expand( InternalQuery internalQuery ) throws MQLPreprocessorException {

        InternalQuery newInternalQuery = null;

        try {

            /*
             * First remove unnecessary type comparisons as they may hinder the
             * scheduler. Note that in some cases, the separateMultiAssociations
             * method below may reintroduce them.
             */
            this.mqlAuxServices.removeTypeComparisons( internalQuery );

            /*
             * The expander first splits the internal query
             */
            newInternalQuery = this.mqlAuxServices.split( internalQuery );

            /*
             * Then, whenever we have more than one association between the same
             * two atomic entries (in a leaf query), we clone the atomic entry
             * on one side and move one of the associations away (and introduce
             * a type comparison)
             */
            this.separateMultiAssocations( newInternalQuery );

        } finally {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_EXPANSIONS, "\n", ( newInternalQuery == null ? "NULL query" : newInternalQuery ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        return newInternalQuery;
    }

    /* ----------------- */
    /* Private methods */
    /* ----------------- */

    /**
     * Splits the internal into strongly connected components in terms of
     * association predicates. The result is again an internal query
     */
    private void separateMultiAssocations( InternalQuery internalQuery ) {

        try {
            // to avoid redoing the same nested query
            Set<NestedQuery> seenNestedQuery = new HashSet<NestedQuery>( );

            this.separateMultiAssocationsInternalQuery( internalQuery, seenNestedQuery );

        } finally {
            // trace the intermediate result
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_INTERNAL_QUERY_AFTER_STEERING_APPART_MULTIPLE_ASSOCIATIONS, "\n", ( internalQuery == null ? "NULL query" : internalQuery ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }

    /**
     * Main multi-assoc separation function (recursive)
     */
    private void separateMultiAssocationsInternalQuery( InternalQuery internalQuery, Set<NestedQuery> seenNestedQuery ) {

        // case analysis on the internal query
        if ( internalQuery instanceof LeafQuery ) {
            this.separateMultiAssocationsLeafQuery( (LeafQuery) internalQuery, seenNestedQuery );

        } else if ( internalQuery instanceof NodeQuery ) {
            // just go recursively down
            NodeQuery nodeQuery = (NodeQuery) internalQuery;

            this.separateMultiAssocationsInternalQuery( nodeQuery.getFirstFromEntry( ), seenNestedQuery );
            this.separateMultiAssocationsInternalQuery( nodeQuery.getSecondFromEntry( ), seenNestedQuery );

        } else if ( internalQuery instanceof ResultUnion ) {
            // obtain operands ...
            List<InternalQuery> operands = ( (ResultUnion) internalQuery ).getOperands( );

            for ( InternalQuery operand : operands ) {
                this.separateMultiAssocationsInternalQuery( operand, seenNestedQuery );
            }

        } else if ( internalQuery instanceof EmptyQuery ) {
            // nothing to do

        } else {
            throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, internalQuery.getClass( ).getCanonicalName( ), "InternalQuery" ); //$NON-NLS-1$
        }
    }

    /**
     * Alias removal happens by walking over the alias comparisons, constructing
     * a new alias which builds the intersection alias, removing the comparison,
     * removing the old aliases from the from-entries and finally replacing any
     * references to the old alias with the new alias
     */
    private void separateMultiAssocationsLeafQuery( LeafQuery leafQuery, Set<NestedQuery> seenNestedQuery ) {

        List<WithEntry> withEntries = leafQuery.getWithEntries( );

        // this map registers all unique pairs of atomic entries 
        Map<AtomicEntry, Set<AtomicEntry>> atomicEntryPairMap = new HashMap<AtomicEntry, Set<AtomicEntry>>( );

        // this lists records all assocPredicates which have to be separated
        Set<AssocPredicate> multiAssociations = new HashSet<AssocPredicate>( );

        // run through the withEntries and collect the association predicates, go recursive for nested queries
        for ( WithEntry withEntry : withEntries ) {

            // recursive for LinksPredicates
            if ( withEntry instanceof LinksPredicate ) {
                NestedQuery nestedQuery = ( (LinksPredicate) withEntry ).getNestedQuery( );

                // but only if not already seen
                if ( seenNestedQuery.add( nestedQuery ) ) {
                    this.separateMultiAssocationsInternalQuery( nestedQuery.getInternalQuery( ), seenNestedQuery );
                }
            } else if ( withEntry instanceof TypeComparison || withEntry instanceof AttrComparison ) {
                // do nothing
            } else if ( withEntry instanceof AssocPredicate ) {
                AssocPredicate assocPredicate = (AssocPredicate) withEntry;

                AtomicEntry leftAtomicEntry = assocPredicate.getFromType( ).getAtomicEntry( );
                AtomicEntry rightAtomicEntry = assocPredicate.getToType( ).getAtomicEntry( );

                // check if such a pair already exists
                if ( !this.checkAndManageAtomicEntryPairMap( atomicEntryPairMap, leftAtomicEntry, rightAtomicEntry, multiAssociations, assocPredicate ) ) {
                    // we were not successful finding something for the leftAtomicEntry, so try from the right
                    if ( !this.checkAndManageAtomicEntryPairMap( atomicEntryPairMap, rightAtomicEntry, leftAtomicEntry, multiAssociations, assocPredicate ) ) {
                        // the combination was not there at all, so add it in both directions
                        Set<AtomicEntry> mappedEntries = new HashSet<AtomicEntry>( );
                        mappedEntries.add( rightAtomicEntry );
                        atomicEntryPairMap.put( leftAtomicEntry, mappedEntries );
                        mappedEntries = new HashSet<AtomicEntry>( );
                        mappedEntries.add( leftAtomicEntry );
                        atomicEntryPairMap.put( rightAtomicEntry, mappedEntries );
                    }
                }

            } else {
                throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, withEntry.getClass( ).getCanonicalName( ), "JoinWhereEntry" ); //$NON-NLS-1$
            }
        }

        // Now, we use the assoc predicate list to actually separate multi associations if they exist

        // we need the list of atomic entries, because we may the set of atomic entries
        List<AtomicEntry> leafAtomicEntries = leafQuery.getFromEntries( );
        for ( AssocPredicate multiAssocPredicate : multiAssociations ) {
            AtomicEntryReference toAtomicEntryReference = multiAssocPredicate.getToType( );

            // get the data from the original toAtomicEntry
            AtomicEntry toAtomicEntry = toAtomicEntryReference.getAtomicEntry( );
            List<MRI> classMRIs = toAtomicEntry.getClassMRIs( );
            SpiFqlFromTypeCategory modelElementCategory = toAtomicEntry.getTypeCategory( );
            Set<PRI> scope = toAtomicEntry.getScope( );
            Set<CRI> containedScope = toAtomicEntry.getContainerScope( );
            boolean including = toAtomicEntry.isScopeInclusive( );
            List<String> classNames = toAtomicEntry.getClassNames( );
            boolean isReflectElement = toAtomicEntry.isReflectElement( );

            // the alias name is different
            AliasName newAliasName = new AliasName( toAtomicEntry.getAliasName( ) );

            // construct a new atomic entry
            AtomicEntry newAtomicEntry = null;

            // careful to distinguish
            if ( toAtomicEntry instanceof AtomicEntryFixedSet ) {
                // fixed set
                Set<MRI> elements = ( (AtomicEntryFixedSet) toAtomicEntry ).getElements( );
                newAtomicEntry = AtomicEntryFixedSet.newAtomicEntryFixedSetWithClonedElements( newAliasName, classMRIs, classNames, elements, isReflectElement, scope, containedScope, including );
            } else {
                // normal
                newAtomicEntry = new AtomicEntry( newAliasName, classMRIs, classNames, modelElementCategory, isReflectElement, scope, containedScope, including );
            }

            // add the a type comparison
            AtomicEntryReference newLeftAtomicEntryRef = new AtomicEntryReference( toAtomicEntry );
            AtomicEntryReference newRightAtomicEntryRef = new AtomicEntryReference( newAtomicEntry );
            TypeComparison typeComparison = new TypeComparison( newLeftAtomicEntryRef, newRightAtomicEntryRef );
            withEntries.add( typeComparison );

            // redirect the assocPredicate
            toAtomicEntryReference.setAtomicEntry( newAtomicEntry );

            // add the atomic entry itself
            leafAtomicEntries.add( newAtomicEntry );
        }

    }

    /**
     * Returns true if the mappedEntries also contain the right atomic entry,
     * otherwise, it manages the atomicEntryPairMap
     */
    private boolean checkAndManageAtomicEntryPairMap( Map<AtomicEntry, Set<AtomicEntry>> atomicEntryPairMap, AtomicEntry leftAtomicEntry, AtomicEntry rightAtomicEntry, Set<AssocPredicate> multiAssociations, AssocPredicate assocPredicate ) {

        Set<AtomicEntry> mappedEntries = atomicEntryPairMap.get( leftAtomicEntry );
        if ( mappedEntries != null ) {
            // check if the right is in there
            if ( mappedEntries.contains( rightAtomicEntry ) ) {
                // register for separation
                multiAssociations.add( assocPredicate );
            } else {
                // pair not there yet, so first add the right entry 
                mappedEntries.add( rightAtomicEntry );
                // we have to make sure the other direction is also registered
                mappedEntries = atomicEntryPairMap.get( rightAtomicEntry );
                if ( mappedEntries != null ) {
                    // we have a match for the other direction, so add the left entry
                    mappedEntries.add( leftAtomicEntry );
                } else {
                    // other direction is new, so add entry altogether
                    mappedEntries = new HashSet<AtomicEntry>( );
                    mappedEntries.add( leftAtomicEntry );
                    atomicEntryPairMap.put( rightAtomicEntry, mappedEntries );
                }
            }

            return true;
        }

        // if we did not have a chance to determine a pair from the left, return false
        return false;
    }

}
