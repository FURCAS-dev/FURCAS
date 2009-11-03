/*
 * Created on 27.02.2006
 */
package com.sap.tc.moin.repository.core.query.fql.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.query.messages.FQLTraceMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.engine.CoreQueryClientScope;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiAbstractBasicQueryProcessor;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiSelectExpression;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryResultSet;

/**
 * This implementation of
 * {@link com.sap.tc.moin.query.basicquery.spi.SpiBasicQueryProcessor} does not
 * require that the model elements which are relevant for the search are loaded
 * in memory. Link traversal during the execution of the query can lead to
 * partition loading.
 */
public final class BasicQueryProcessorMemoryImpl extends SpiAbstractBasicQueryProcessor {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_FQL_MEMORY, BasicQueryProcessorMemoryImpl.class );

    /**
     * This is the ID used for the in-memory BQL of the CORE
     */
    private static final String MEMORY_ID = "_MEMORY_"; //$NON-NLS-1$

    public BasicQueryProcessorMemoryImpl( ) {

        super( MEMORY_ID );
    }

    /**
     * Executes a BQL query in memory. This implementation requires that the
     * partitionScope is inclusive. If a partition in the scope is not loaded,
     * it will be loaded by this BQL processor.
     */
    @Override
    public SpiFqlQueryResultSet execute( SpiFacilityQueryClientScope queryClientScope, SpiSelectExpression selectExpression, int maxResultSetSize, int numberOfRequestedRows ) {

        CoreConnection connection = ( (CoreQueryClientScope) queryClientScope ).getConnection( );

        long timeStamp = System.nanoTime( );
        this.checkQueryConsistency( selectExpression );
        long time = 0;
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            time = ( System.nanoTime( ) - timeStamp ) / 1000000;
            logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_VERIFICATION_FINISHED, time );
        }

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_MEMORY_ENGINE_CONSTRUCTS_CLUSTER );
        }

        if ( !queryClientScope.isPartitionScopeInclusive( ) ) {
            throw new MQLBugException( MQLBugMessages.UNEXPECTED_NON_INCLUSIVE_SCOPE_FOR_MEMORY_SCENARIO );
        }

        Set<PRI> pris = queryClientScope.getPartitionsScope( );
        ClusterEvaluator clusterEvaluator = new ClusterEvaluator( connection, pris.toArray( new PRI[pris.size( )] ) );
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_MEMORY_ENGINE_EVALUATES_CLUSTER );
        }
        SpiFqlQueryResultSet basicQueryResultSet = clusterEvaluator.evaluateCluster( selectExpression, maxResultSetSize, numberOfRequestedRows );
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_BQL_MEMORY_EXECUTION_DONE );
        }

        return basicQueryResultSet;
    }

    /**
     * For a given fromObject, obtains all elements, associated with the it via
     * the associationMRI (and indicated association end number), where we
     * restrict the result set to the provided set of partitions. Storage can be
     * on either side.
     */
    public static RefObject[] getLinkedObjects( CoreConnection connection, RefObject fromObject, MRI assocMRI, int endNumberOfFromObject, Set<PRI> priScope, Set<MRI> mrisOfTypes, Set<MRI> elements ) {

        List<RefObject> result;

        // sanity checks
        if ( endNumberOfFromObject != 0 && endNumberOfFromObject != 1 ) {
            throw new MQLBugException( MQLBugMessages.UNEXPECTED_ASSOCIATION_END_NUMBER, endNumberOfFromObject );
        }
        RefObject metaObject = (RefObject) connection.getElement( assocMRI );
        if ( metaObject == null ) {
            throw new MQLBugException( MQLBugMessages.LINK_TYPE_NOT_JMI_OBJECT, assocMRI );
        }

        // first check if we have storage on the start side.
        boolean startAtStorageEnd;
        if ( metaObject instanceof Attribute ) {
            startAtStorageEnd = endNumberOfFromObject != 1;
        } else if ( metaObject instanceof Association ) {
            SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
            List<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( connection.getSession( ), (Association) metaObject );
            startAtStorageEnd = jmiHelper.isEndStored( connection.getSession( ), associationEnds.get( endNumberOfFromObject ) );
        } else {
            throw new MQLBugException( MQLBugMessages.LINK_TYPE_NOT_ATTRIBUTE_OR_ASSOCIATION, assocMRI );
        }

        // get refObjects on "other side"
        Workspace workspace = ( (CorePartitionable) fromObject ).get___Workspace( );
        EndAndMetaObject endAndMetaObject = workspace.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( endNumberOfFromObject, metaObject );

        if ( startAtStorageEnd ) {
            // start at storage end
            result = getLinkedObjectsAndFilterByPartitions( connection, workspace, (CorePartitionable) fromObject, endAndMetaObject, true, priScope, mrisOfTypes, elements );
        } else {
            // start at non-storage end
            result = new ArrayList<RefObject>( );
            for ( PRI pri : priScope ) {
                // get workspace of partition in scope
                Workspace partitionWorkspace = connection.getPartition( pri ).getWorkspace( );

                // set this pri as the scope to be considered
                Set<PRI> priAsScope = Collections.singleton( pri );

                // accumulate results for each pri in the scope
                result.addAll( getLinkedObjectsAndFilterByPartitions( connection, partitionWorkspace, (CorePartitionable) fromObject, endAndMetaObject, false, priAsScope, mrisOfTypes, elements ) );
            }
        }

        return result.toArray( new RefObject[result.size( )] );
    }

    /**
     * For the given fromObject, obtain all linked refObjects, where we know
     * that the fromObject is handled by the provided workspace.
     */
    private static List<RefObject> getLinkedObjectsAndFilterByPartitions( CoreConnection connection, Workspace workspace, CorePartitionable fromObject, EndAndMetaObject endAndMetaObject, boolean startAtStorageEnd, Set<PRI> priScope, Set<MRI> mrisOfTypes, Set<MRI> elements ) {

        List<RefObject> result = new ArrayList<RefObject>( );
        if ( startAtStorageEnd ) {
            Collection<EndStorageLink> linksForEndAndMetaObject = workspace.getMemoryLinkManager( ).getLinksForEndAndMetaObject( connection.getSession( ), endAndMetaObject, fromObject );
            if ( linksForEndAndMetaObject != null ) {
                for ( EndStorageLink link : linksForEndAndMetaObject ) {
                    try {
                        RefObject objectOnOtherSide = (RefObject) link.getOtherEnd( ).get( connection.getSession( ) );

                        if ( isInPartitionsOfTypeAndInElements( objectOnOtherSide, priScope, mrisOfTypes, elements ) ) {
                            result.add( objectOnOtherSide );
                        }
                    } catch ( UnresolvableException ue ) {
                        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                            logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.UNABLE_TO_RESOLVE_OBJECT_LINKED_BY_VIA_ASSOCIATION, link.getOtherEndLri( ), link.getStorageEndMri( ), link.getMetaObjectMri( ) );
                        }
                    }
                }
            }
        } else {
            Collection<EndStorageLink> distributedEndStorageLinksForEndAndMetaObject = workspace.getMemoryLinkManager( ).getDistributedEndStorageLinksForEndAndMetaObject( connection, endAndMetaObject.getMetaObjectMofId( ), fromObject, priScope );
            if ( distributedEndStorageLinksForEndAndMetaObject != null ) {
                for ( EndStorageLink link : distributedEndStorageLinksForEndAndMetaObject ) {
                    RefObject objectOnOtherSide = (RefObject) link.getStorageEnd( ).get( connection.getSession( ) );

                    if ( isInPartitionsOfTypeAndInElements( objectOnOtherSide, priScope, mrisOfTypes, elements ) ) {
                        result.add( objectOnOtherSide );
                    }
                }
            }
        }

        return result;
    }

    /**
     * Checks if the provide object is in the element set if it is provided or
     * not empty, otherwise, check if it has the right type and finally, check
     * if it is in scope.
     */
    public static boolean isInPartitionsOfTypeAndInElements( RefObject object, Set<PRI> priScope, Set<MRI> mrisOfTypes, Set<MRI> elements ) {

        MRI refObjectMri = ( (Partitionable) object ).get___Mri( );
        // we keep the element if it exists in the fixed element set
        boolean toBeKept = elements == null || elements.isEmpty( ) || elements.contains( refObjectMri );

        // if not, we have to verify the type 
        if ( toBeKept ) {
            MRI refObjectTypeMri = ( (Partitionable) object.refMetaObject( ) ).get___Mri( );

            // don't forget Reflect::Element
            toBeKept = mrisOfTypes == null || mrisOfTypes.isEmpty( ) || mrisOfTypes.contains( refObjectTypeMri );

            if ( toBeKept ) {
                // if of correct type, then check for partition in scope
                PRI pri = ( (Partitionable) object ).get___Partition( ).getPri( );
                toBeKept = ( priScope != null ? priScope.contains( pri ) : false );
            }
        }

        return toBeKept;
    }

    /**
     * gets the objects of all provided types within the provided priScope. If a
     * fixed element set is provided, only return objects from that set.
     */
    public static RefObject[] getObjectsOfTypeInPartitions( Connection connection, Set<PRI> priScope, Set<MRI> mrisOfTypes, Set<MRI> elements ) {

        List<RefObject> result = new ArrayList<RefObject>( );

        // filter for the partition, the types, and the element set
        for ( PRI pri : priScope ) {
            // potentially load the partition 
            CoreModelPartition modelPartition = (CoreModelPartition) connection.getPartition( pri );

            // SANITY CHECK
            if ( modelPartition == null ) {
                throw new MQLBugException( MQLBugMessages.PRI_DOES_NOT_EXIST, pri );
            }

            Collection<Partitionable> possibleResultElements;

            // if we have a fixed set of provided elements, the possible result elements are only those which
            // are also in the set of fixed elements
            if ( elements != null && elements.size( ) > 0 ) {
                possibleResultElements = new HashSet<Partitionable>( );
                for ( MRI elementMri : elements ) {
                    // only add if PRI is identical
                    if ( elementMri.getPri( ).equals( pri ) ) {
                        possibleResultElements.add( connection.getElement( elementMri ) );
                    }
                }
            } else {
                possibleResultElements = modelPartition.getElements( );
            }

            // for all possible elements, only consider the refObjects, which have the "right" type.
            for ( Partitionable object : possibleResultElements ) {
                if ( object instanceof RefObject ) {
                    RefObject refObject = (RefObject) object;

                    // check for the type (unless we are dealing with Reflect::Element)
                    MRI mriOfType = ( (Partitionable) refObject.refMetaObject( ) ).get___Mri( );
                    if ( mrisOfTypes == null || mrisOfTypes.isEmpty( ) || mrisOfTypes.contains( mriOfType ) ) {
                        result.add( refObject );
                    }
                }
            }
        }

        return result.toArray( new RefObject[result.size( )] );
    }

}
