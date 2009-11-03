package com.sap.tc.moin.repository.core.query.moinql.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.query.messages.FQLTraceMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.engine.MQLInterpreterImpl.PositionRecord;
import com.sap.tc.moin.repository.core.query.moinql.internal.AssocPredicate;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicAttrReference;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicEntry;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicEntryFixedSet;
import com.sap.tc.moin.repository.core.query.moinql.internal.AtomicEntryReference;
import com.sap.tc.moin.repository.core.query.moinql.internal.AttrComparison;
import com.sap.tc.moin.repository.core.query.moinql.internal.LeafQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.LeafSelectEntry;
import com.sap.tc.moin.repository.core.query.moinql.internal.LikeComparison;
import com.sap.tc.moin.repository.core.query.moinql.internal.LinksPredicate;
import com.sap.tc.moin.repository.core.query.moinql.internal.NaryWhereClause;
import com.sap.tc.moin.repository.core.query.moinql.internal.NestedQuery;
import com.sap.tc.moin.repository.core.query.moinql.internal.NumericComparison;
import com.sap.tc.moin.repository.core.query.moinql.internal.SelectEntry;
import com.sap.tc.moin.repository.core.query.moinql.internal.TypeComparison;
import com.sap.tc.moin.repository.core.query.moinql.internal.TypeReference;
import com.sap.tc.moin.repository.core.query.moinql.internal.WhereClause;
import com.sap.tc.moin.repository.core.query.moinql.internal.WithEntry;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiAnd;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiAttributeExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiAttributeInModelElement;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiAttributeToAttributeComparisonExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiBasicQueryProcessor;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiLike;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiModelElementClusterExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiModelElementExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiMultiplicityType;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiOr;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiPartitionExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiSelectExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiSelectList;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiSimpleComparisonExpression;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlFromTypeCategory;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryResultSet;

/**
 * Translates FQL queries into BQL
 */
public class BQLTranslator {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_MQL, BQLTranslator.class );

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
    public SpiSelectExpression leafQuery2bql( LeafQuery leafQuery, Map<SelectEntry, PositionRecord> positionMap ) {

        SpiSelectExpression result = null;

        try {
            result = this.toSelectExpression( leafQuery, positionMap );
        } finally {
            // trace the intermediate result
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_TRANSLATION_PRODUCED_QUERY, ( result == null ? "NULL query" : result ) ); //$NON-NLS-1$
            }
        }

        return result;
    }

    /**
     * Converts a leafQuery into a BQL SelectExpression.
     */
    private SpiSelectExpression toSelectExpression( LeafQuery leafQuery, Map<SelectEntry, PositionRecord> positionMap ) {

        // get the relevant query parts
        List<LeafSelectEntry> selectEntries = leafQuery.getSelectEntries( );
        List<AtomicEntry> fromEntries = leafQuery.getFromEntries( );
        List<WithEntry> withEntries = leafQuery.getWithEntries( );
        SpiBasicQueryProcessor bqlProcessor = (SpiBasicQueryProcessor) ( leafQuery.getFqlProcessor( ) );

        // the fromEntries are copied into a list (on which the algorithm will work)
        List<AtomicEntry> atomicEntries = new ArrayList<AtomicEntry>( fromEntries.size( ) );
        atomicEntries.addAll( fromEntries );

        // the head atomic entry for top-level query parts is simply the first from entry
        AtomicEntry headAtomicEntry = atomicEntries.remove( 0 );

        // we maintain a Map which maps aliases to AtomicEntries
        Map<String, SpiModelElementExpression> aliasToModelElement = new HashMap<String, SpiModelElementExpression>( fromEntries.size( ) );

        // convert the actual internal query
        SpiModelElementClusterExpression modelElementCluster = this.toModelElementCluster( headAtomicEntry, atomicEntries, withEntries, aliasToModelElement, bqlProcessor );

        // calculate the select lists and fill the positionMap
        SpiSelectList[] selectLists = this.toSelectLists( selectEntries, aliasToModelElement, positionMap );

        // construct result

        return new SpiSelectExpression( modelElementCluster, selectLists );
    }

    /**
     * Construct the select lists as well as the mappings from aliases and
     * attribute names to their respective indices
     */
    private SpiSelectList[] toSelectLists( List<LeafSelectEntry> selectEntries, Map<String, SpiModelElementExpression> aliasToModelElement, Map<SelectEntry, PositionRecord> positionMap ) {

        // the selectList result structure
        List<SpiSelectList> selectLists = new ArrayList<SpiSelectList>( );

        // we maintain a hashmap of aliases and its select list
        Map<AtomicEntry, SpiSelectList> aliasSelectLists = new HashMap<AtomicEntry, SpiSelectList>( );

        // we keep a separate counter for the number of result sets
        int resultSetCounter = 0;

        // for each selectEntry, construct a new selectList if required
        for ( LeafSelectEntry selectEntry : selectEntries ) {
            // get the type reference of the select entry
            TypeReference typeRef = selectEntry.getTypeReference( );

            // we also need the atomic entry of the reference
            AtomicEntry atomicEntry = typeRef.getAtomicEntry( );

            // construct a positionRecord and add it the positionMap
            PositionRecord positionRecord = new PositionRecord( );
            positionMap.put( selectEntry, positionRecord );

            // we have to manage the select list for *this* select entry
            SpiSelectList selectList = null;

            // Add a select list if the reference is a AtomicEntryReference
            if ( typeRef instanceof AtomicEntryReference ) {
                if ( aliasSelectLists.containsKey( atomicEntry ) ) {
                    // we already have a select list, so get it
                    selectList = aliasSelectLists.get( atomicEntry );
                    // set the alias position
                    positionRecord.aliasPosition = selectLists.indexOf( selectList );
                } else {
                    // if the select list has not been constructed

                    // make the selectList
                    selectList = new SpiSelectList( aliasToModelElement.get( atomicEntry.getAliasName( ).toString( ) ) );
                    // add the result
                    selectLists.add( resultSetCounter, selectList );
                    // add the position data for aliases
                    positionRecord.aliasPosition = resultSetCounter;

                    // add to the hashMap
                    aliasSelectLists.put( atomicEntry, selectList );

                    // increase the counter;
                    resultSetCounter++;
                }

            } else {
                throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, typeRef.getClass( ).getCanonicalName( ), "TypeReference" ); //$NON-NLS-1$
            }

            // Add the attribute if we are dealing with an AtomicAttrReference
            if ( typeRef instanceof AtomicAttrReference ) {
                AtomicAttrReference typeAttrRef = (AtomicAttrReference) typeRef;

                // get the relevant features
                boolean isMultiValued = typeAttrRef.isMultiValued( );
                String attrName = typeAttrRef.getAttrName( );
                SpiFqlPrimitiveType attrType = typeAttrRef.getAttrType( );

                // check if we have a multi-valued attribute reference
                SpiMultiplicityType multiValued = ( isMultiValued ? SpiMultiplicityType.ATTRIBUTE_MULTI_VALUED : SpiMultiplicityType.ATTRIBUTE_SINGLE_VALUED );

                // add the attribute to the select list
                selectList.addAttributeDefinition( attrName, attrType, multiValued );

                // the index for the attribute is determined via the constructed
                // selectList
                int attributeIndex = selectList.getNumberOfAttributeDefinitions( ) - 1;

                // complete the positionRecord
                positionRecord.attributePosition = attributeIndex;
                positionRecord.multivalued = isMultiValued;
            }
        }

        // construct the result
        SpiSelectList[] result = selectLists.toArray( new SpiSelectList[selectLists.size( )] );

        return result;
    }

    /**
     * Constructs a model element cluster. The head atomic entry becomes the
     * head element. The other atomic Entries, the other
     * ModelElementExpressions. WithEntries lead to the different link forms
     */
    SpiModelElementClusterExpression toModelElementCluster( AtomicEntry headAtomicEntry, List<AtomicEntry> atomicEntries, List<WithEntry> withEntries, Map<String, SpiModelElementExpression> aliasToModelElement, SpiBasicQueryProcessor bqlProcessor ) {

        // register the with entries, which are AttrComparisons, for later insertion
        Map<String, List<AttrComparison>> attrComparisons = new HashMap<String, List<AttrComparison>>( );

        for ( WithEntry withEntry : withEntries ) {
            if ( withEntry instanceof AttrComparison ) {
                AttrComparison attrComparison = (AttrComparison) withEntry;
                // we always use the *left* attribute as the basis for inclusion
                // this decision is __arbitrary__
                String leftAliasName = attrComparison.getLeftAttr( ).getAtomicEntry( ).getAliasName( ).toString( );
                if ( attrComparisons.containsKey( leftAliasName ) ) {
                    attrComparisons.get( leftAliasName ).add( attrComparison );
                } else {
                    List<AttrComparison> attrComparisonsList = new ArrayList<AttrComparison>( );
                    attrComparisonsList.add( attrComparison );
                    attrComparisons.put( leftAliasName, attrComparisonsList );
                }
            }
        }

        // construct a headModelElementExpression out of the head Atomic Entry
        String headAlias = headAtomicEntry.getAliasName( ).toString( );
        SpiModelElementExpression headModelElementExpression = this.toModelElementExpression( headAtomicEntry );
        headModelElementExpression.setAlias( headAlias );
        aliasToModelElement.put( headAlias, headModelElementExpression );

        // construct the cluster
        SpiModelElementClusterExpression cluster = new SpiModelElementClusterExpression( headModelElementExpression );

        // we then construct modelElementExpressions out of the atomic entries
        for ( Iterator<AtomicEntry> iter = atomicEntries.iterator( ); iter.hasNext( ); ) {
            AtomicEntry atomicEntry = iter.next( );
            String entryAlias = atomicEntry.getAliasName( ).toString( );
            SpiModelElementExpression modelElementExpression = this.toModelElementExpression( atomicEntry );
            modelElementExpression.setAlias( entryAlias );
            aliasToModelElement.put( entryAlias, modelElementExpression );
            cluster.addModelElementExpressionToCluster( modelElementExpression );
        }

        // now, we have to extend each model element expression potentially with
        // extra attribute expressions to cater for attribute comparisons
        this.addAttributeComparisons( headModelElementExpression, attrComparisons.get( headAlias ), aliasToModelElement );

        List<SpiModelElementExpression> modelElementExpressions = cluster.getAdditionalModelElementExpressions( );
        for ( SpiModelElementExpression modelElementExpression : modelElementExpressions ) {
            // add the assigned AttrComparisons for each model element expression
            this.addAttributeComparisons( modelElementExpression, attrComparisons.get( modelElementExpression.getAlias( ) ), aliasToModelElement );
        }

        // finally, we have to process the Assoc and Link predicates in the with
        // entries and add them to the cluster
        for ( WithEntry withEntry : withEntries ) {
            this.addLinkToCluster( cluster, withEntry, aliasToModelElement, bqlProcessor );
        }

        return cluster;
    }

    /**
     * For a an atomic entry, we can construct a ModelElementExpression.
     */
    private SpiModelElementExpression toModelElementExpression( AtomicEntry atomicEntry ) {

        // first, convert the local where clause to a local attribute expression
        SpiAttributeExpression attributeExpression = this.toAttributeExpression( atomicEntry.getWhereClause( ) );

        // to keep the result
        SpiModelElementExpression result = null;

        // the kind of model element expression to construct depends on the
        // nature of the atomic entry
        if ( atomicEntry instanceof AtomicEntryFixedSet ) {
            Set<MRI> elements = ( (AtomicEntryFixedSet) atomicEntry ).getElements( );
            MRI[] elementsAsArray = elements.toArray( new MRI[elements.size( )] );

            // construct result
            result = new SpiModelElementExpression( elementsAsArray );

        } else {
            // the types are directly available
            List<MRI> types = atomicEntry.getClassMRIs( );
            MRI[] typesAsArray = null;

            // however, if we have Reflect::Element, we enter the empty type set
            if ( atomicEntry.isReflectElement( ) ) {
                typesAsArray = new MRI[0];
            } else {
                typesAsArray = types.toArray( new MRI[types.size( )] );
            }

            // construct partition expression
            SpiPartitionExpression partitionExpression = null;

            Set<PRI> scope = atomicEntry.getScope( );
            PRI[] scopeAsArray = null;
            if ( scope == null ) {
                scopeAsArray = new PRI[0];
            } else {
                scopeAsArray = new PRI[scope.size( )];
                scope.toArray( scopeAsArray );
            }

            if ( atomicEntry.isScopeInclusive( ) ) {
                partitionExpression = new SpiPartitionExpression( scopeAsArray, true );
            } else if ( scope != null && scopeAsArray.length > 0 ) {
                partitionExpression = new SpiPartitionExpression( scopeAsArray, false );
            }

            // the category
            SpiFqlFromTypeCategory modelElementCategory = atomicEntry.getTypeCategory( );

            // construct result
            result = new SpiModelElementExpression( typesAsArray, modelElementCategory, partitionExpression );
        }

        // attach the attribute expression
        result.setAttributeExpression( attributeExpression );

        return result;
    }

    /**
     * A WhereClause can be translated into an AttributeExpression
     */
    private SpiAttributeExpression toAttributeExpression( WhereClause whereClause ) {

        SpiAttributeExpression result = null;

        // first check if we actually have a where clause in the first place
        if ( whereClause != null ) {

            if ( whereClause instanceof NaryWhereClause ) {
                NaryWhereClause naryWhereClause = (NaryWhereClause) whereClause;
                List<WhereClause> nestedWhereClauses = naryWhereClause.getNestedClauses( );

                // translate recursively for all nested where clauses
                List<SpiAttributeExpression> anExpressionList = new ArrayList<SpiAttributeExpression>( nestedWhereClauses.size( ) );

                for ( WhereClause nestedClause : nestedWhereClauses ) {
                    anExpressionList.add( this.toAttributeExpression( nestedClause ) );
                }

                // construct the result and consider whether we have an OR or AND clause
                if ( naryWhereClause.isOrConnected( ) ) {
                    result = new SpiOr( anExpressionList );
                } else {
                    result = new SpiAnd( anExpressionList );
                }

            } else if ( whereClause instanceof LikeComparison ) {
                LikeComparison likeComparison = (LikeComparison) whereClause;
                result = new SpiLike( likeComparison.getAttrName( ), likeComparison.isNegated( ), likeComparison.getLikePattern( ) );

            } else if ( whereClause instanceof NumericComparison ) {
                NumericComparison numericComparison = (NumericComparison) whereClause;
                String attrName = numericComparison.getAttrName( );
                SpiFqlPrimitiveType attrType = numericComparison.getAttrType( );
                Object operand = numericComparison.getOperandValue( );
                result = new SpiSimpleComparisonExpression( attrName, attrType, numericComparison.getOperation( ), operand );

            } else {
                throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, whereClause.getClass( ).getCanonicalName( ), "WhereClause" ); //$NON-NLS-1$
            }
        }

        return result;
    }

    /**
     * This method alters the attribute expression of the modelElementExpression
     * if additional attrComparisons exist. It requires the aliasToModelElement
     * structure for this
     */
    private void addAttributeComparisons( SpiModelElementExpression modelElementExpression, List<AttrComparison> attrComparisons, Map<String, SpiModelElementExpression> aliasToModelElement ) {

        SpiAttributeExpression attrExpression = modelElementExpression.getAttributeExpression( );

        // only change something if attrComparisons are not empty
        if ( attrComparisons != null && attrComparisons.size( ) > 0 ) {
            // collect all constructed attribute expressions
            List<SpiAttributeExpression> attributeExpressions = new ArrayList<SpiAttributeExpression>( attrComparisons.size( ) );

            for ( Iterator<AttrComparison> iter = attrComparisons.iterator( ); iter.hasNext( ); ) {
                // obtain all the relevant features
                AttrComparison attrComp = iter.next( );
                String leftAttrName = attrComp.getLeftAttr( ).getAttrName( );
                String rightAliasName = attrComp.getRightAttr( ).getAtomicEntry( ).getAliasName( ).toString( );
                String rightAttrName = attrComp.getRightAttr( ).getAttrName( );
                SpiModelElementExpression rightModelElementExpr = aliasToModelElement.get( rightAliasName );

                // construct AttributeInModelElement
                SpiAttributeInModelElement attrInModelElement = new SpiAttributeInModelElement( rightModelElementExpr, rightAttrName );

                // construct attributeExpr
                SpiAttributeExpression newAttrExpr = new SpiAttributeToAttributeComparisonExpression( leftAttrName, attrComp.getLeftAttr( ).getAttrType( ), attrComp.getOperation( ), attrInModelElement );

                // add in the list
                attributeExpressions.add( newAttrExpr );
            }

            // reconstruct the attrExpressions
            SpiAttributeExpression resultAttrExpression = null;

            if ( attrExpression == null && attributeExpressions.size( ) == 1 ) {
                // special case
                resultAttrExpression = attributeExpressions.get( 0 );
            } else {
                // otherwise we always construct a conjunction

                if ( attrExpression != null ) {
                    // add the previous attribute expression to the list
                    attributeExpressions.add( attrExpression );
                    // construct result as a logical AND
                    resultAttrExpression = new SpiAnd( attributeExpressions );
                }

            }

            // assign result
            modelElementExpression.setAttributeExpression( resultAttrExpression );
        }
    }

    /**
     * WithEntries, which are assoc or link predicates, can be added to the
     * cluster
     */
    @SuppressWarnings( "null" )
    private void addLinkToCluster( SpiModelElementClusterExpression cluster, WithEntry withEntry, Map<String, SpiModelElementExpression> aliasToModelElement, SpiBasicQueryProcessor bqlProcessor ) {

        // case analysis on the type of the JoinWhereEntry

        if ( withEntry instanceof TypeComparison ) {
            // currently not supported
            throw new MQLBugException( MQLBugMessages.TYPE_COMPARISON_NOT_SUPPORTED );
        } else if ( withEntry instanceof AttrComparison ) {
            // already dealt with
        } else if ( withEntry instanceof AssocPredicate ) {
            AssocPredicate assocPredicate = (AssocPredicate) withEntry;

            // the fromModelElement is the "left" side and the toLinkable is the
            // "right" side
            String leftAliasName = assocPredicate.getFromType( ).getAtomicEntry( ).getAliasName( ).toString( );
            String rightAliasName = assocPredicate.getToType( ).getAtomicEntry( ).getAliasName( ).toString( );
            SpiModelElementExpression fromModelElementExpression = aliasToModelElement.get( leftAliasName );
            SpiModelElementExpression toModelElementExpression = aliasToModelElement.get( rightAliasName );

            // set the other features of the link expression
            MRI linkMRI = assocPredicate.getAssocMRI( );
            SpiFqlAssociationCategory assocCatogory = assocPredicate.getAssocCategory( );
            byte storageEnd = (byte) ( assocPredicate.hasStorageAtFromEnd( ) ? assocPredicate.getFromAssocEnd( ) : assocPredicate.getToAssocEnd( ) );
            byte assocEnd = (byte) assocPredicate.getToAssocEnd( );

            // add it
            cluster.addClusterInternalLink( linkMRI, assocCatogory, assocEnd, storageEnd, fromModelElementExpression, toModelElementExpression );

        } else if ( withEntry instanceof LinksPredicate ) {
            LinksPredicate linksPredicate = (LinksPredicate) withEntry;

            // obtain the relevant LinkExpression features (except the nested query)
            String aliasName = linksPredicate.getFromType( ).getAtomicEntry( ).getAliasName( ).toString( );
            SpiModelElementExpression fromModelElementExpression = aliasToModelElement.get( aliasName );
            MRI linkMRI = linksPredicate.getAssocMRI( );
            SpiFqlAssociationCategory assocCategory = linksPredicate.getAssocCategory( );

            byte storageEnd = (byte) ( linksPredicate.hasStorageAtToEnd( ) ? linksPredicate.getToAssocEnd( ) : ( linksPredicate.getToAssocEnd( ) == 0 ? 1 : 0 ) );
            byte assocEnd = (byte) linksPredicate.getToAssocEnd( );
            boolean isLinked = !linksPredicate.isNegated( );

            // deal with the nested query to produce the link expression
            NestedQuery nestedQuery = linksPredicate.getNestedQuery( );

            if ( nestedQuery.getResultSet( ) != null ) {
                SpiFqlQueryResultSet resultSet = nestedQuery.getResultSet( );
                // unwrap the nested result set
                int resultSetSize = ( resultSet == null ? 0 : resultSet.getSize( ) );
                MRI[] MRIs = new MRI[resultSetSize];
                for ( int i = 0; i < resultSetSize; i++ ) {
                    MRIs[i] = resultSet.getMri( i, 0 );
                }

                // immediately build the result
                cluster.addMriSetLink( isLinked, linkMRI, assocCategory, assocEnd, storageEnd, fromModelElementExpression, MRIs );
            } else if ( nestedQuery.getInternalQuery( ) instanceof LeafQuery ) {
                // we are not given an intermediate result set, so translate the
                // nested query (which has to be a leaf query) recursively
                LeafQuery nestedLeafQuery = (LeafQuery) nestedQuery.getInternalQuery( );

                // first check if the basic query processor of the nested query
                // is identical to that of the encompassing query
                SpiBasicQueryProcessor nestedBqlProcessor = (SpiBasicQueryProcessor) ( nestedLeafQuery.getFqlProcessor( ) );
                String facilityId = bqlProcessor.getFacilityId( );
                String nestedFacilityId = nestedBqlProcessor.getFacilityId( );
                if ( !( facilityId.equals( nestedFacilityId ) ) ) {
                    throw new MQLBugException( MQLBugMessages.INCOMPATIBLE_FQL_IN_LEAF_QUERIES, facilityId, nestedFacilityId );
                }

                // get the relevant query parts
                List<LeafSelectEntry> selectEntries = nestedLeafQuery.getSelectEntries( );
                List<AtomicEntry> fromEntries = nestedLeafQuery.getFromEntries( );
                List<WithEntry> withEntries = nestedLeafQuery.getWithEntries( );

                // copy the from entries
                List<AtomicEntry> atomicEntries = new ArrayList<AtomicEntry>( fromEntries.size( ) );
                atomicEntries.addAll( fromEntries );

                // the head atomic entry for top-level query parts is decided by
                // the first select entry
                AtomicEntry headAtomicEntry = selectEntries.get( 0 ).getAtomicEntryReference( ).getAtomicEntry( );

                // remove it from the atomicEntries
                atomicEntries.remove( headAtomicEntry );

                // we maintain a new Map which maps aliases to AtomicEntries
                Map<String, SpiModelElementExpression> newAliasToModelElement = new HashMap<String, SpiModelElementExpression>( fromEntries.size( ) );

                // convert the nested query
                SpiModelElementClusterExpression nestedCluster = this.toModelElementCluster( headAtomicEntry, atomicEntries, withEntries, newAliasToModelElement, nestedBqlProcessor );

                // build result
                cluster.addClusterExternalLink( isLinked, linkMRI, assocCategory, assocEnd, storageEnd, fromModelElementExpression, nestedCluster );
            } else {
                throw new MQLBugException( MQLBugMessages.UNEXPECTED_UNEVALUATED_NESTED_QUERY );
            }

        } else {
            throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, withEntry.getClass( ).getCanonicalName( ), "JoinWhereEntry" ); //$NON-NLS-1$
        }

    }

}
