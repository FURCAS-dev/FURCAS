package com.sap.tc.moin.repository.core.consistency.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateParentConsistencyViolation;
import com.sap.tc.moin.repository.consistency.LinkPermissionConsistencyViolation;
import com.sap.tc.moin.repository.core.ConsistencyThread;
import com.sap.tc.moin.repository.core.ConsistencyViolationEvent;
import com.sap.tc.moin.repository.core.Core;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.impl.WorkspaceSetImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;

/**
 * Consistency violation registry implementation. The implementation serves as
 * registry for the inconsistency listeners as well as registry for the
 * inconsistency events that occur while MOIN is running. The registry holds a
 * table for each type of inconsistencies and a table that keeps the listeners.
 * 
 * @author d026715
 */
@SuppressWarnings( "nls" )
public final class ConsistencyViolationRegistryImpl implements ConsistencyViolationRegistry {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CONSISTENCY, ConsistencyViolationRegistryImpl.class );

    private final DuplicateElementViolationTable duplicateElementViolations = new DuplicateElementViolationTable( );

    private final LinkViolationTable<DanglingLinkConsistencyViolationImpl> danglingLinkViolations = new LinkViolationTable<DanglingLinkConsistencyViolationImpl>( );

    private final LinkViolationTable<LinkPermissionConsistencyViolationImpl> linkPermissionViolations = new LinkViolationTable<LinkPermissionConsistencyViolationImpl>( );

    private final DuplicateParentViolationTable duplicateParentViolations = new DuplicateParentViolationTable( );

    private final Set<ConsistencyListener> listeners = Collections.synchronizedSet( new LinkedHashSet<ConsistencyListener>( ) );

    private ConsistencyListener defaultListener = null;

    // cache of all listeners
    private ConsistencyListener[] allListeners = null;

    private final Object listenerMutex = new Object( );

    private final Map<String, ConsistencyViolation> consistencyViolationsById = new LinkedHashMap<String, ConsistencyViolation>( );

    private final ConsistencyThread violationQueue;

    private final Map<PRI, Counter> inconsistentPartitions = new LinkedHashMap<PRI, Counter>( );

    private final UsedElementsTable usedElements = new UsedElementsTable( );

    private ConsistencyViolationBuffer notificationBuffer = null;

    private final Counter notificationBufferMonitor = new Counter( 0 );

    private final CoreSession session;

    private boolean shutdown = false;

    private final WeakReference<Moin> moin;

    public ConsistencyViolationRegistryImpl( CoreSession theSession ) {

        this.session = theSession;
        this.violationQueue = theSession.getMoin( ).getConsistencyThread( );
        this.moin = new WeakReference<Moin>( theSession.getMoin( ) );
    }

    public boolean listenersRegistered( ) {

        synchronized ( this.listenerMutex ) {
            return ( !this.listeners.isEmpty( ) );
        }
    }

    public void setDefaultListener( ConsistencyListener listener ) {

        synchronized ( this.listenerMutex ) {
            this.defaultListener = listener;
            this.allListeners = null;
        }
    }

    public ConsistencyListener getDefaultListener( ) {

        synchronized ( this.listenerMutex ) {
            return this.defaultListener;
        }
    }

    public synchronized void addListener( ConsistencyListener listener ) {

        synchronized ( this.listenerMutex ) {
            this.listeners.add( listener );
            this.allListeners = null;
        }
    }

    public synchronized void removeListener( ConsistencyListener listener ) {

        synchronized ( this.listenerMutex ) {
            this.listeners.remove( listener );
            this.allListeners = null;
        }
    }

    public void applyCorrection( String correctionId, CoreConnection connection ) {

        if ( correctionId != null ) {
            if ( correctionId.startsWith( ElementDeleteCorrectionImpl.OPERATION_ID ) ) {
                ElementDeleteCorrectionImpl.apply( connection, correctionId );
            } else if ( correctionId.startsWith( AllOtherElementsDeleteCorrectionImpl.OPERATION_ID ) ) {
                AllOtherElementsDeleteCorrectionImpl.apply( connection, correctionId );
            } else if ( correctionId.startsWith( LinkDeleteCorrectionImpl.OPERATION_ID ) ) {
                LinkDeleteCorrectionImpl.apply( connection, correctionId );
            } else if ( correctionId.startsWith( AllDanglingLinksOfPartitionDeleteCorrectionImpl.OPERATION_ID ) ) {
                AllDanglingLinksOfPartitionDeleteCorrectionImpl.apply( connection, correctionId );
            } else {
                throw new MoinIllegalArgumentException( CoreConsistencyMessages.UNKNOWNCORRECTIONID );
            }
        }
    }

    public synchronized MRI notifyDuplicateElementInconsistency( List<MRI> mris ) {

        Map<MRI, DuplicateElementConsistencyViolation> existingViolations = this.duplicateElementViolations.get( mris.get( 0 ).getLri( ) );
        if ( existingViolations != null ) {
            // there are already inconsistencies
            for ( MRI mri : mris ) {
                // second parameter (used mri) is not needed, can be determined
                // internally
                this.notifyDuplicateElementInconsistency( mri, null );
            }
            // get the used mri from the first existing violation
            return existingViolations.values( ).iterator( ).next( ).getUsedElementsMri( );
        } else {
            // use the first mri
            if ( mris.size( ) > 1 ) {
                MRI usedMri = mris.get( 0 );
                MRI secondMri = mris.get( 1 );
                // notify first violation
                this.notifyDuplicateElementInconsistency( secondMri, usedMri );
                // notify next violations
                if ( mris.size( ) > 2 ) {
                    for ( int i = 2; i < mris.size( ); i++ ) {
                        this.notifyDuplicateElementInconsistency( mris.get( i ), usedMri );
                    }
                }
                return usedMri;
            } else {
                throw new MoinIllegalStateException( CoreConsistencyMessages.INCONSISTENCYONLYONEMRI );
            }
        }
    }

    public synchronized MRI notifyDuplicateElementInconsistency( MRI newMri, MRI existingMri ) {

        MRI usedMri = null;

        // check existing violations by LRI
        Map<MRI, DuplicateElementConsistencyViolation> existingViolations = this.duplicateElementViolations.getExistingViolations( newMri.getLri( ) );

        if ( existingViolations != null ) {
            usedMri = this.getUsedDuplicateElement( newMri.getLri( ) );

            DuplicateElementConsistencyViolation newViolation = new DuplicateElementConsistencyViolationImpl( this, newMri );
            existingViolations.put( newMri, newViolation );
            this.consistencyViolationsById.put( newViolation.getId( ), newViolation );
            this.addNewViolationToNotificationQueue( newViolation );
        } else {
            // no inconsistencies so far
            // create two violations - one for the already existing element and
            // one for the new duplicate   

            // set used element first to avoid concurrency problems with the new consistency violation instances
            usedMri = this.usedElements.setUsedElement( existingMri );

            DuplicateElementConsistencyViolation newViolation = new DuplicateElementConsistencyViolationImpl( this, existingMri );
            this.duplicateElementViolations.put( newMri.getLri( ), newViolation );
            this.consistencyViolationsById.put( newViolation.getId( ), newViolation );
            this.addNewViolationToNotificationQueue( newViolation );

            newViolation = new DuplicateElementConsistencyViolationImpl( this, newMri );
            this.duplicateElementViolations.put( newMri.getLri( ), newViolation );
            this.consistencyViolationsById.put( newViolation.getId( ), newViolation );
            this.addNewViolationToNotificationQueue( newViolation );
        }

        // return used mri
        return usedMri;

    }

    public synchronized void notifyDanglingLinkInconsistency( LRI missingElementsLri, EndStorageLink link ) {

        // check if event already occurred
        if ( this.danglingLinkViolations.get( link ) == null ) {
            DanglingLinkConsistencyViolationImpl violation = new DanglingLinkConsistencyViolationImpl( this, link, missingElementsLri );
            this.consistencyViolationsById.put( violation.getId( ), violation );
            this.danglingLinkViolations.put( link, violation );
            this.addNewViolationToNotificationQueue( violation );
        }
    }

    public synchronized void notifyLinkPermissionInconsistency( MRI deniedEnd, EndStorageLink link ) {

        // check if event already occurred
        if ( this.linkPermissionViolations.get( link ) == null ) {
            LinkPermissionConsistencyViolationImpl violation = new LinkPermissionConsistencyViolationImpl( this, link, deniedEnd );
            this.consistencyViolationsById.put( violation.getId( ), violation );
            this.linkPermissionViolations.put( link, violation );
            this.addNewViolationToNotificationQueue( violation );
        }
    }

    public synchronized EndStorageLink notifyDuplicateParentLinkInconsistency( MRI mriOfChildElement, List<EndStorageLink> parentLinks ) {

        EndStorageLink usedLink = null;

        // iterate the links and register the inconsistency
        for ( EndStorageLink parentLink : parentLinks ) {
            DuplicateParentConsistencyViolationImpl existingViolation = this.duplicateParentViolations.get( parentLink );

            if ( existingViolation == null ) {
                DuplicateParentConsistencyViolationImpl newViolation = new DuplicateParentConsistencyViolationImpl( this, parentLink, parentLink );

                // use the first link
                usedLink = parentLink;

                // put into tables
                this.duplicateParentViolations.put( parentLink, newViolation );
                this.consistencyViolationsById.put( newViolation.getId( ), newViolation );

                // do the notification
                this.addNewViolationToNotificationQueue( newViolation );
            } else {
                if ( usedLink == null ) {
                    usedLink = existingViolation.getUsedLink( );
                }
            }
        }

        return usedLink;
    }

    private void addNewViolationToNotificationQueue( ConsistencyViolation violation ) {

        if ( this.notificationBuffer != null ) {
            this.notificationBuffer.addNewViolation( violation );
        } else {
            ConsistencyViolationEvent event = new NewConsistencyViolationEvent( (ConsistencyViolationImpl) violation, this );
            this.addConsistencyViolationEventToExternalNotificationQueue( event );
        }

        // register violation per partition
        this.registerInconsistencyOfPartition( violation.getAffectedElement( ).getPri( ) );

        logger.trace( MoinSeverity.DEBUG, "New consistency violation added to the queue:\n {0}", new Object[] { violation } );
    }

    private void addConsistencyViolationEventToExternalNotificationQueue( ConsistencyViolationEvent event ) {

        this.violationQueue.addNewEvent( event );
    }

    /**
     * Notifies all listener for new consistency violations. Called by
     * {@link ConsistencyViolationEvent#notifyExternalListeners()}.
     */
    public void notifyNewViolationsExtern( ConsistencyViolation[] events ) {

        // TODO: we need either a service connection or another
        // connection per session!
        CoreConnection newConnection = this.createConnection( );

        // only notify if connection is alive
        if ( !this.isShutdown( ) && ( newConnection != null ) && newConnection.isAlive( ) ) {
            for ( ConsistencyListener listener : this.getListenersToNotify( ) ) {
                try {
                    listener.onConsistencyViolation( events, newConnection.getWrapper( ) );
                    logger.trace( MoinSeverity.DEBUG, "New consistency violations send to listener [{0}].", listener.getClass( ).getName( ) );
                } catch ( Throwable ex ) {
                    logger.trace( ex, MoinSeverity.ERROR, "Exception in consistency violation listener.", new Object[] {} );
                }
            }
        }

        if ( newConnection != null ) {
            newConnection.close( );
        }

        logger.trace( MoinSeverity.DEBUG, "New consistency violations notified by the queue:\n {0}", new Object[] { events } );
    }

    /**
     * Collects all listeners that are to be notified. - there is always the
     * session as listener that triggers JMX - if addition, there is the default
     * listener or the list of additional listeners
     * 
     * @return
     */
    private ConsistencyListener[] getListenersToNotify( ) {

        synchronized ( this.listenerMutex ) {
            if ( this.allListeners == null ) {

                // calculate the number of listeners:
                // if there are semantic listeners, the default listeners is not
                // called
                int size = 1; // JMX listener
                if ( this.defaultListener != null ) {
                    if ( this.listeners.isEmpty( ) ) {
                        size++;
                    } else {
                        size += this.listeners.size( );
                    }
                } else {
                    size += this.listeners.size( );
                }
                this.allListeners = new ConsistencyListener[size];
                this.allListeners[0] = (ConsistencyListener) this.session;
                if ( this.defaultListener != null ) {
                    if ( this.listeners.isEmpty( ) ) {
                        // add default listener
                        this.allListeners[1] = this.defaultListener;
                    } else {
                        // add semantic listeners
                        int i = 1;
                        for ( ConsistencyListener listener : this.listeners ) {
                            this.allListeners[i++] = listener;
                        }
                    }
                } else {
                    // add semantic listeners
                    int i = 1;
                    for ( ConsistencyListener listener : this.listeners ) {
                        this.allListeners[i++] = listener;
                    }
                }
            }
            return this.allListeners;
        }

    }

    public synchronized ConsistencyViolation getConsistencyViolation( String id ) {

        return this.consistencyViolationsById.get( id );
    }

    public synchronized Collection<ConsistencyViolation> getAllConsistencyViolations( ) {

        return new ArrayList<ConsistencyViolation>( this.consistencyViolationsById.values( ) );
    }


    /**
     * Removes a dangling link violation from the registry and adds an event to
     * the notification queue.
     * 
     * @param violation
     */
    public void notifyResolvedConsistencyViolation( DanglingLinkConsistencyViolation violation ) {

        // remove from table
        this.consistencyViolationsById.remove( violation.getId( ) );
        this.danglingLinkViolations.remove( ( (DanglingLinkConsistencyViolationImpl) violation ).getAffectedLink( ) );
        this.addResolvedViolationToNotificationQueue( violation );
    }

    /**
     * Removes a link permission violation from the registry and adds an event
     * to the notification queue.
     * 
     * @param violation
     */
    public void notifyResolvedConsistencyViolation( LinkPermissionConsistencyViolation violation ) {

        // remove from table
        this.consistencyViolationsById.remove( violation.getId( ) );
        this.linkPermissionViolations.remove( ( (LinkPermissionConsistencyViolationImpl) violation ).getAffectedLink( ) );
        this.addResolvedViolationToNotificationQueue( violation );
    }

    /**
     * Removes a duplicate parent violation from the registry and adds an event
     * to the notification queue.
     * 
     * @param violation
     */
    public void notifyResolvedConsistencyViolation( DuplicateParentConsistencyViolation duplicateParentViolation ) {

        DuplicateParentConsistencyViolationImpl violation = (DuplicateParentConsistencyViolationImpl) duplicateParentViolation;

        this.addResolvedViolationToNotificationQueue( violation );
        this.consistencyViolationsById.remove( violation.getId( ) );
        this.duplicateParentViolations.remove( violation.getLink( ) );
        if ( this.duplicateParentViolations.size( violation.getChildLri( ) ) == 1 ) {
            DuplicateParentConsistencyViolationImpl lastViolation = this.duplicateParentViolations.get( violation.getChildLri( ) ).iterator( ).next( );

            this.notifyResolvedConsistencyViolation( lastViolation );
        } else if ( this.duplicateParentViolations.size( violation.getChildLri( ) ) > 1 ) {
            if ( violation.getUsedLink( ).equals( violation.getUsedLink( ) ) ) {
                // reset used parents
                DuplicateParentConsistencyViolationImpl remainingViolation = this.duplicateParentViolations.get( violation.getChildLri( ) ).iterator( ).next( );
                EndStorageLink usedLink = remainingViolation.getLink( );
                for ( DuplicateParentConsistencyViolationImpl violationToUpdate : this.duplicateParentViolations.get( violation.getChildLri( ) ) ) {
                    violationToUpdate.setUsedLink( usedLink );
                }
            }
        }
    }

    /**
     * Removes a duplicate element violation from the registry and adds an event
     * to the notification queue.
     * 
     * @param violation Resolved violation
     * @return MRI of the element currently used
     */
    public MRI notifyResolvedConsistencyViolation( DuplicateElementConsistencyViolation violation ) {

        if ( this.consistencyViolationsById.get( violation.getId( ) ) != null ) {
            // standard
            this.consistencyViolationsById.remove( violation.getId( ) );
            this.duplicateElementViolations.remove( violation );
            this.addResolvedViolationToNotificationQueue( violation );

            LRI lri = violation.getMri( ).getLri( );
            MRI usedMri = this.usedElements.getUsedElement( lri );
            // special handling if only two duplicate element violations are
            // left
            if ( this.duplicateElementViolations.size( lri ) == 1 ) {
                DuplicateElementConsistencyViolation secondViolation = this.duplicateElementViolations.get( lri ).values( ).iterator( ).next( );
                this.duplicateElementViolations.remove( secondViolation );
                this.consistencyViolationsById.remove( secondViolation.getId( ) );
                this.addResolvedViolationToNotificationQueue( secondViolation );
            }
            return usedMri;
        }
        return null;
    }

    /**
     * Adds a resolved consistency violation to the notification queue.
     * 
     * @param violation Resolved inconsistency
     */
    private void addResolvedViolationToNotificationQueue( ConsistencyViolation violation ) {

        if ( this.notificationBuffer != null ) {
            this.notificationBuffer.addResolvedViolation( violation );
        } else {
            ConsistencyViolationEvent event = new ResolvedConsistencyViolationEvent( (ConsistencyViolationImpl) violation, this );
            this.addConsistencyViolationEventToExternalNotificationQueue( event );
        }

        this.unregisterInconsistencyOfPartition( violation.getAffectedElement( ).getPri( ) );

        logger.trace( MoinSeverity.DEBUG, "Resolved consistency violation added to the queue:\n {0}", new Object[] { violation } );
    }

    /**
     * Notifies all listener for resolved consistency violations. Called by
     * {@link ConsistencyViolationEvent#notifyExternalListeners()}.
     */
    public void notifyResolvedViolationsExtern( ConsistencyViolation[] events ) {

        // TODO: we need either a service connection or another
        // connection per session!
        CoreConnection newConnection = this.createConnection( );

        // only notify if the connection is alive
        if ( !this.isShutdown( ) && ( newConnection != null ) && newConnection.isAlive( ) ) {
            for ( ConsistencyListener listener : this.getListenersToNotify( ) ) {
                try {
                    listener.onConsistencyResolution( events, newConnection.getWrapper( ) );
                    logger.trace( MoinSeverity.DEBUG, "Resolved consistency violations send to listener [{0}].", listener.getClass( ).getName( ) );
                } catch ( Throwable ex ) {
                    logger.trace( ex, MoinSeverity.ERROR, "Exception in consistency violation listener {0}.", new Object[] { listener.getClass( ).getName( ) } );
                }
            }
        }

        if ( newConnection != null ) {
            newConnection.close( );
        }

        logger.trace( MoinSeverity.DEBUG, "Resolved consistency violations notified by the queue:\n {0}", new Object[] { events } );
    }

    private CoreConnection createConnection( ) {

        Moin thisMoin = this.getMoin( );

        // TODO: this is by far to slow !
        if ( thisMoin != null ) {
            Session newSession = thisMoin.createSession( this.session.getCompoundClientSpec( ) );

            return (CoreConnection) newSession.createConnection( );
        } else {
            return null;
        }
    }

    /**
     * Checks the consistency of a container.
     * 
     * @param dataArea
     * @param containerName
     * @param currentConnection
     */
    public void performConsistencyCheck( DataAreaDescriptor dataArea, String containerName, CoreConnection currentConnection ) {

        CRI cri = this.getSession( ).getMoin( ).createCri( dataArea.getFacilityId( ), dataArea.getDataAreaName( ), containerName );
        Collection<PRI> partitions = currentConnection.getSession( ).getInnerPartitions( cri );
        for ( PRI pri : partitions ) {
            this.performConsistencyCheck( pri, currentConnection );
        }
    }

    public void performDcDependencyCheck( PRI pri, CoreConnection connection ) {

        CoreModelPartition partition = getExistingPartition( connection, pri );
        if ( partition != null ) {
            this.checkLinkConsistency( connection, partition, false, true );
        }
    }

    private CoreModelPartition getExistingPartition( CoreConnection connection, PRI pri ) {

        if ( pri == null ) {
            if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                logger.trace( MoinSeverity.WARNING, "Could not perform consistency check for because PRI is null" );
            }
            return null;
        }
        CoreModelPartition modelPartition = connection.getPartition( pri );
        if ( modelPartition == null ) {
            if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                logger.trace( MoinSeverity.WARNING, "Could not perform consistency check for partition " + pri + " because partition could not be found" ); //$NON-NLS-2$
            }
        }
        return modelPartition;

    }

    public void performConsistencyCheck( PRI pri, CoreConnection connection ) {

        CoreModelPartition modelPartition = getExistingPartition( connection, pri );
        if ( modelPartition != null ) {

            this.enableBulkNotification( );

            // retrigger already registered violations
            // necessary if listeners need another notification
            this.triggerEventsForExistingViolations( );

            this.checkLinkConsistency( connection, modelPartition, true, false );

            Collection<Partitionable> elements = modelPartition.getElements( );

            // iterate all element to find duplicates that are not reflected in
            // memory
            for ( Partitionable partitionable : elements ) {
                LRI lri = partitionable.get___Mri( ).getLri( );
                // resolve element - duplicate element inconsistencies are
                // registered then
                ( (WorkspaceSetImpl) connection.getSession( ).getWorkspaceSet( ) ).resolveLriPersisted( connection.getSession( ), lri );
            }

            // refresh violations to merge with memory state
            // check if duplicate elements found on persistence have been deleted in
            // memory
            this.refreshDuplicateElementViolations( connection );

            this.finishBulkNotification( );
        }
    }

    // Return visible container and the container itself of the given partition in a HashSet
    // for faster contains queries 
    private HashSet<CRI> getVisibleContainers( CoreConnection connection, PRI pri ) {

        CoreSession coreSession = connection.getSession( );
        SpiClientSpec clientSpec = (SpiClientSpec) coreSession.getCompoundClientSpec( ).getClientSpec( pri.getDataAreaDescriptor( ) );
        SpiLifecycleManagement lifecycleManagement = ( (SpiFacility) connection.getSession( ).getMoin( ).getFacilityById( pri.getDataAreaDescriptor( ).getFacilityId( ) ) ).getLifecycleManagement( );

        Collection<CRI> visibleContainers = lifecycleManagement.getVisibleContainers( clientSpec, pri.getCri( ) );
        HashSet<CRI> criSet = new HashSet<CRI>( visibleContainers );
        criSet.add( pri.getCri( ) );
        return criSet;
    }

    private void checkLinkConsistency( CoreConnection currentConnection, CoreModelPartition partition, boolean checkDuplicateParents, boolean checkDcDependency ) {

        Collection<SpiLink> links = partition.getLinks( );
        PRI pri = partition.getPri( );
        // TODO: As soon we have fine granular Public Parts, this must be 
        // extended to visible partitions!
        HashSet<CRI> visibleContainers = null;
        if ( checkDcDependency ) {
            visibleContainers = getVisibleContainers( currentConnection, pri );
        }

        // iterate all links and check other ends for inconsistencies
        for ( SpiLink link : links ) {
            EndStorageLink endStorageLink = (EndStorageLink) link;

            LRI otherEnd = endStorageLink.getOtherEnd( ).getLri( );

            // try to resolve MRI of other end            
            MRI resolvedOtherEnd = endStorageLink.getOtherEnd( ).getMri( currentConnection.getSession( ) );

            if ( resolvedOtherEnd == null ) {
                this.notifyDanglingLinkInconsistency( otherEnd, endStorageLink );
            } else {
                if ( checkDcDependency ) {
                    boolean linkBackedByContainerUsage = visibleContainers.contains( resolvedOtherEnd.getCri( ) );

                    if ( !linkBackedByContainerUsage ) {
                        //we need a closer look, could still be that the link is allowed anyway (e.g. linkage into metamodel)
                        if ( !this.checkDcDependency( currentConnection, pri, resolvedOtherEnd ) ) {
                            this.notifyLinkPermissionInconsistency( resolvedOtherEnd, endStorageLink );
                        }
                    } else {
                        LinkPermissionConsistencyViolation violation = this.checkRegisteredLinkPermissionViolations( endStorageLink, currentConnection );
                        if ( violation != null ) {
                            this.notifyResolvedConsistencyViolation( violation );
                        }
                    }
                }

                // check duplicate parents
                if ( checkDuplicateParents && ( endStorageLink.getCompositeEnd( ) > -1 ) ) {
                    CorePartitionable componentElement = (CorePartitionable) currentConnection.getElement( resolvedOtherEnd );
                    if ( componentElement != null ) {
                        currentConnection.getSession( ).getWorkspaceSet( ).getLogicalLinkManager( ).getCompositeParentLink( currentConnection.getSession( ), componentElement );
                    } else {
                        if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                            logger.trace( MoinSeverity.WARNING, "Could not perform link consistency check for element " + resolvedOtherEnd + " because it could not be found" );
                        }
                    }
                }

            }

        }
    }

    /**
     * Triggers the violation for already registered consistency violation
     * events.
     */
    private void triggerEventsForExistingViolations( ) {

        for ( ConsistencyViolation violation : this.consistencyViolationsById.values( ) ) {
            this.addNewViolationToNotificationQueue( violation );
        }
    }

    public boolean checkDcDependency( CoreConnection currentConnection, PRI pri, MRI resolvedOtherEnd ) {

        CoreSession coreSession = currentConnection.getSession( );
        Core core = coreSession.getWorkspaceSet( ).getMoin( ).getCore( );
        SpiClientSpec clientSpec = (SpiClientSpec) coreSession.getCompoundClientSpec( ).getClientSpec( pri.getDataAreaDescriptor( ) );

        // check permissions
        SpiLifecycleManagement lifecycleManagement = ( (SpiFacility) coreSession.getMoin( ).getFacilityById( pri.getDataAreaDescriptor( ).getFacilityId( ) ) ).getLifecycleManagement( );


        boolean linkBackedByContainerUsage = core.isLinkAllowed( lifecycleManagement, pri, resolvedOtherEnd.getPri( ), clientSpec, clientSpec );
        return linkBackedByContainerUsage;
    }

    public List<DuplicateElementConsistencyViolation> checkRegisteredDuplicateElement( LRI lri ) {

        return this.checkRegisteredDuplicateElement( null, lri, false );
    }

    public List<DuplicateElementConsistencyViolation> checkRegisteredDuplicateElement( CoreConnection currentConnection, LRI lri, boolean checkPersistence ) {

        if ( lri != null ) {
            if ( checkPersistence ) {
                ( (WorkspaceSetImpl) currentConnection.getSession( ).getWorkspaceSet( ) ).resolveLriPersisted( currentConnection.getSession( ), lri );
            }
            Map<MRI, DuplicateElementConsistencyViolation> duplicates = this.duplicateElementViolations.get( lri );
            if ( duplicates != null ) {
                List<DuplicateElementConsistencyViolation> result = new ArrayList<DuplicateElementConsistencyViolation>( duplicates.size( ) );
                result.addAll( duplicates.values( ) );
                return result;
            }
        }

        return null;
    }

    public DuplicateElementConsistencyViolation checkRegisteredDuplicateElement( MRI mri ) {

        if ( mri != null ) {
            Map<MRI, DuplicateElementConsistencyViolation> violations = this.duplicateElementViolations.get( mri.getLri( ) );
            if ( violations != null ) {
                return violations.get( mri );
            }
        }

        return null;
    }

    public MRI getUsedDuplicateElement( LRI lri ) {

        return this.usedElements.getUsedElement( lri );
    }

    public MRI setNewUsedDuplicateElement( MRI elementToBeUsed ) {

        return this.usedElements.resetUsedElement( elementToBeUsed );

    }

    public DanglingLinkConsistencyViolation checkRegisteredDanglingLink( EndStorageLink link, boolean checkPersistence, CoreConnection connection ) {

        if ( checkPersistence ) {

            if ( ( (WorkspaceSetImpl) connection.getSession( ).getWorkspaceSet( ) ).resolveLriPersisted( connection.getSession( ), link.getOtherEnd( ).getLri( ) ) == null ) {
                if ( connection.getElement( link.getOtherEnd( ).getLri( ) ) == null ) {
                    this.notifyDanglingLinkInconsistency( link.getOtherEnd( ).getLri( ), link );
                }
            }
        }

        return this.danglingLinkViolations.get( link );
    }

    public List<DanglingLinkConsistencyViolation> checkDanglingLinksOfPartition( PRI partition ) {

        List<DanglingLinkConsistencyViolation> result = new ArrayList<DanglingLinkConsistencyViolation>( );

        if ( this.inconsistentPartitions.containsKey( partition ) ) {

            Collection<DanglingLinkConsistencyViolationImpl> allDanglingLinks = this.danglingLinkViolations.getAllViolations( );

            // Pretty expensive - not yet optimized since it is not called so
            // often
            if ( allDanglingLinks != null ) {
                for ( DanglingLinkConsistencyViolationImpl violation : allDanglingLinks ) {
                    if ( violation.getAffectedElement( ).getPri( ).equals( partition ) ) {
                        result.add( violation );
                    }

                }
            }
        }
        return result;
    }

    public LinkPermissionConsistencyViolation checkRegisteredLinkPermissionViolations( EndStorageLink link, CoreConnection connection ) {

        return this.linkPermissionViolations.get( link );
    }

    public ConsistencyViolation checkLinkConsistency( EndStorageLink link, CoreSession session ) {

        if ( link.getOtherEnd( ).getWithoutException( session ) == null ) {
            this.notifyDanglingLinkInconsistency( link.getOtherEnd( ).getLri( ), link );
        }
        return this.danglingLinkViolations.get( link );
    }

    public void elementCreated( LRI lri ) {

        // handle dangling links
        Collection<DanglingLinkConsistencyViolationImpl> existingViolations = this.danglingLinkViolations.get( lri );

        if ( existingViolations != null ) {
            for ( DanglingLinkConsistencyViolationImpl existingViolation : existingViolations ) {
                existingViolation.elementCreated( lri );
            }
        }
    }

    public void elementDeleted( MRI mri ) {

        DuplicateElementConsistencyViolationImpl existingViolation = (DuplicateElementConsistencyViolationImpl) this.duplicateElementViolations.get( mri );

        if ( existingViolation != null ) {
            existingViolation.elementDeleted( mri );
        }
    }

    public void elementRelocated( CoreConnection connection, PRI pri, MRI oldMri ) {

        DuplicateElementConsistencyViolationImpl existingViolation = (DuplicateElementConsistencyViolationImpl) this.duplicateElementViolations.get( oldMri );
        MRI newMri = pri.createMri( oldMri.getMofId( ) );
        if ( existingViolation != null ) {
            MRI usedMri = this.notifyResolvedConsistencyViolation( existingViolation );

            // check strange situation: duplicate element is copied over the other one
            if ( !newMri.equals( usedMri ) ) {
                this.notifyDuplicateElementInconsistency( newMri, usedMri );
            }
        }


        //resolve existing violations
        Collection<LinkPermissionConsistencyViolationImpl> violations = this.linkPermissionViolations.get( oldMri.getLri( ) );
        if ( violations != null ) {
            for ( LinkPermissionConsistencyViolationImpl violation : violations ) {
                EndStorageLink link = violation.getAffectedLink( );
                if ( violation.getDeniedEnd( ).equals( oldMri ) ) {
                    MRI mriOfOtherEnd = link.getOtherEnd( ).getMri( connection.getSession( ) );
                    if ( checkDcDependency( connection, pri, mriOfOtherEnd ) ) {
                        notifyResolvedConsistencyViolation( violation );
                    }
                }
            }
        }

        //add new violations
        CoreSession session = connection.getSession( );
        WorkspaceSet workspaceSet = session.getWorkspaceSet( );
        CoreMoin moin = workspaceSet.getMoin( );
        Core core = moin.getCore( );

        if ( core.isSavablePartition( pri ) ) {
            //only repartitioning to a "real" (i.e. it can be saved) partition requires checking
            //if the element was repartitioned to a transient or null partition, no need to check here
            //because before save they have to be repartitioned to "real" partitions anyway and
            //then they are checked
            LogicalLinkManager logicalLinkManager = workspaceSet.getLogicalLinkManager( );
            List<EndStorageLink> linksForElement = logicalLinkManager.getLinksForElement( session, (CorePartitionable) connection.getElement( newMri ) );
            for ( EndStorageLink link : linksForElement ) {
                checkAndNotifyLinkPermissionInconsistency( connection, link );
            }
        }
    }

    public void linkDeleted( EndStorageLink link ) {

        DanglingLinkConsistencyViolationImpl existingDanglingLinkViolation = this.danglingLinkViolations.get( link );

        if ( existingDanglingLinkViolation != null ) {
            existingDanglingLinkViolation.deleteLink( link );
        }

        DuplicateParentConsistencyViolationImpl existingDuplicateParentViolation = this.duplicateParentViolations.get( link );
        if ( existingDuplicateParentViolation != null ) {
            existingDuplicateParentViolation.deleteLink( link );
        }

        LinkPermissionConsistencyViolationImpl linkPermissionConsistencyViolation = this.linkPermissionViolations.get( link );
        if ( linkPermissionConsistencyViolation != null ) {
            this.notifyResolvedConsistencyViolation( linkPermissionConsistencyViolation );
        }
    }

    public void linkAdded( CoreConnection connection, EndStorageLink link ) {

        checkAndNotifyLinkPermissionInconsistency( connection, link );
    }

    private void checkAndNotifyLinkPermissionInconsistency( CoreConnection connection, EndStorageLink link ) {

        MRI mriOfOtherEnd = link.getOtherEnd( ).getMri( connection.getSession( ) );
        if ( mriOfOtherEnd != null ) {
            if ( !checkDcDependency( connection, link.getStorageEndMri( ).getPri( ), mriOfOtherEnd ) ) {
                notifyLinkPermissionInconsistency( mriOfOtherEnd, link );
            }
        }
        //TODO else: check and notify dangling link ???
    }



    /**
     * Validates all registered duplicate element violations. This is used by
     * the explicit inconsistency check.
     * 
     * @param connection
     */
    public void refreshDuplicateElementViolations( CoreConnection connection ) {

        List<ConsistencyViolation> violations = new ArrayList<ConsistencyViolation>( this.consistencyViolationsById.values( ) );
        for ( ConsistencyViolation violation : violations ) {
            if ( violation instanceof DuplicateElementConsistencyViolation ) {
                ( (ConsistencyViolationImpl) violation ).validate( connection );
            }
        }
    }

    /**
     * 
     */
    public boolean duplicatesExisting( boolean checkPersistence ) {

        return !this.duplicateElementViolations.isEmpty( );
    }

    /**
     * Checks if partition is in the list of inconsistent partitions.
     */
    public boolean isPartitionInconsistent( PRI pri ) {

        Counter counter = this.inconsistentPartitions.get( pri );
        if ( counter != null ) {
            return counter.isGreaterThanZero( );
        } else {
            return false;
        }
    }

    /**
     * Checks if partition is in the list of inconsistent partitions.
     */
    public boolean isPartitionInconsistent( PRI pri, Class<? extends ConsistencyViolation> violationType ) {

        // this method can be optimized in case of performance problems

        if ( this.isPartitionInconsistent( pri ) ) {

            Collection<ConsistencyViolation> allConsistencyViolations = this.getAllConsistencyViolations( );
            for ( ConsistencyViolation consistencyViolation : allConsistencyViolations ) {
                if ( violationType.isAssignableFrom( consistencyViolation.getClass( ) ) ) {
                    PRI violationPri = consistencyViolation.getAffectedElement( ).getPri( );
                    if ( violationPri.equals( pri ) ) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    /**
     * Returns all registered listeners that have been registered using
     * {@link #addListener(ConsistencyListener)}. This does not include the
     * {@link #defaultListener}.
     * 
     * @return collection of listeners
     */
    public Collection<ConsistencyListener> getAllConsistencyListeners( ) {

        return Collections.unmodifiableCollection( this.listeners );
    }

    public void shutdown( ) {

        this.shutdown = true;
    }

    public boolean isShutdown( ) {

        return this.shutdown;
    }

    /**
     * Helper class for storing duplicate element violations.
     * 
     * @author d026715
     */
    private static final class DuplicateElementViolationTable {

        private Map<LRI, Map<MRI, DuplicateElementConsistencyViolation>> violationsByLri = null;

        private Map<LRI, Map<MRI, DuplicateElementConsistencyViolation>> getTable( ) {

            if ( this.violationsByLri == null ) {
                this.violationsByLri = new LinkedHashMap<LRI, Map<MRI, DuplicateElementConsistencyViolation>>( 1 );
            }
            return this.violationsByLri;
        }

        public synchronized boolean isEmpty( ) {

            return this.violationsByLri == null;
        }

        public synchronized int size( LRI lri ) {

            Map<MRI, DuplicateElementConsistencyViolation> violations = this.get( lri );
            if ( violations != null ) {
                return violations.size( );
            } else {
                return 0;
            }
        }

        public synchronized Map<MRI, DuplicateElementConsistencyViolation> get( LRI lri ) {

            if ( this.violationsByLri != null ) {
                return this.violationsByLri.get( lri );
            } else {
                return null;
            }
        }

        public synchronized DuplicateElementConsistencyViolation get( MRI mri ) {

            Map<MRI, DuplicateElementConsistencyViolation> violations = this.get( mri.getLri( ) );
            if ( violations != null ) {
                return violations.get( mri );
            } else {
                return null;
            }
        }

        public synchronized void remove( DuplicateElementConsistencyViolation violation ) {

            Map<MRI, DuplicateElementConsistencyViolation> violations = this.violationsByLri.get( violation.getMri( ).getLri( ) );
            if ( violations != null ) {
                violations.remove( violation.getMri( ) );
                if ( violations.isEmpty( ) ) {
                    this.violationsByLri.remove( violation.getMri( ).getLri( ) );
                    if ( this.violationsByLri.isEmpty( ) ) {
                        this.violationsByLri = null;
                    }
                }
            }
        }

        public synchronized Map<MRI, DuplicateElementConsistencyViolation> getExistingViolations( LRI lri ) {

            if ( this.violationsByLri != null ) {
                return this.violationsByLri.get( lri );
            }
            return null;
        }

        public synchronized void put( LRI lri, DuplicateElementConsistencyViolation violation ) {

            Map<MRI, DuplicateElementConsistencyViolation> violationsByKey = this.getTable( ).get( lri );
            if ( violationsByKey == null ) {
                violationsByKey = new LinkedHashMap<MRI, DuplicateElementConsistencyViolation>( );
                this.violationsByLri.put( lri, violationsByKey );
            }
            violationsByKey.put( violation.getMri( ), violation );
        }
    }

    /**
     * Waits until the {@link ConsistencyViolationNotifThread} as processed all
     * events. The method is only used by the test cases to avoid timing
     * problems.
     */
    public void processNotificationQueue( ) {

        this.violationQueue.waitForQueue( );
    }

    /**
     * Collects inconsistent partitions. Inconsistent partitions cannot be
     * evicted.
     * 
     * @param pri
     */
    public void registerInconsistencyOfPartition( PRI pri ) {

        synchronized ( this.inconsistentPartitions ) {
            Counter numberOfInconsistencies = this.inconsistentPartitions.get( pri );
            if ( numberOfInconsistencies != null ) {
                numberOfInconsistencies.increase( );
            } else {
                this.inconsistentPartitions.put( pri, new Counter( 1 ) );
            }
        }
    }

    /**
     * Removes a partition from the list of inconsistent partitions.
     * 
     * @param pri
     */
    public void unregisterInconsistencyOfPartition( PRI pri ) {

        synchronized ( this.inconsistentPartitions ) {
            Counter numberOfInconsistencies = this.inconsistentPartitions.get( pri );
            if ( numberOfInconsistencies != null ) {
                if ( numberOfInconsistencies.decrease( ) <= 0 ) {
                    this.inconsistentPartitions.remove( pri );
                }
            }
        }
    }

    /**
     * Starts the bulk notification mode. As long as there is at least one
     * "client" that wants to use bulk notification, all inconsistencies are
     * collected in {@link #notificationBuffer}.
     */
    public boolean enableBulkNotification( ) {

        synchronized ( this.notificationBufferMonitor ) {
            this.notificationBufferMonitor.increase( );
            if ( this.notificationBuffer != null ) {
                return false;
            } else {
                this.notificationBuffer = new ConsistencyViolationBuffer( );
                return true;
            }
        }
    }

    /**
     * Stops the bulk notification mode. All collected inconsistencies are
     * wrapped into a bulk event and put to the notification queue.
     */
    public boolean finishBulkNotification( ) {

        synchronized ( this.notificationBufferMonitor ) {
            this.notificationBufferMonitor.decrease( );
            if ( this.notificationBuffer == null ) {
                return false;
            } else {
                ConsistencyViolationEvent event = this.notificationBuffer.getBulkViolationEvent( this );
                if ( event != null ) {
                    this.addConsistencyViolationEventToExternalNotificationQueue( event );
                }

                if ( this.notificationBufferMonitor.isGreaterThanZero( ) ) {
                    // someone still needs the bulk notification
                    this.notificationBuffer = new ConsistencyViolationBuffer( );
                } else {
                    // disable bulk notification
                    this.notificationBuffer = null;
                }
                return true;
            }
        }
    }

    public CoreSession getSession( ) {

        return this.session;
    }

    protected Moin getMoin( ) {

        return this.moin.get( );
    }

    /**
     * Helper class for storing dangling link violations or link permission
     * violations. It contains two table that always contain the same number of
     * elements: Violations by Link and violations by LRI of the dangling end.
     * 
     * @author d026715
     */
    private final static class LinkViolationTable<T extends LinkConsistencyViolation> {

        private Map<EndStorageLink, T> violationsByLink;

        private Map<LRI, Collection<T>> violationsByLri;

        public synchronized void put( EndStorageLink link, T violation ) {

            if ( this.violationsByLink == null ) {
                this.violationsByLink = new LinkedHashMap<EndStorageLink, T>( );
                this.violationsByLri = new LinkedHashMap<LRI, Collection<T>>( );
            }
            this.violationsByLink.put( link, violation );

            Collection<T> violationsForLri = this.violationsByLri.get( link.getOtherEnd( ).getLri( ) );
            if ( violationsForLri == null ) {
                violationsForLri = new ArrayList<T>( 1 );
                this.violationsByLri.put( link.getOtherEnd( ).getLri( ), violationsForLri );
            }

            violationsForLri.add( violation );
        }

        public synchronized T get( EndStorageLink link ) {

            if ( this.violationsByLink != null ) {
                return this.violationsByLink.get( link );
            } else {
                return null;
            }
        }

        public synchronized Collection<T> get( LRI lri ) {

            if ( this.violationsByLri != null ) {
                Collection<T> violationsForLri = this.violationsByLri.get( lri );
                if ( violationsForLri != null ) {
                    return new ArrayList<T>( violationsForLri );
                }
            }
            return null;
        }

        public synchronized Collection<T> getAllViolations( ) {

            if ( this.violationsByLink == null ) {
                return null;
            }

            return this.violationsByLink.values( );
        }

        public synchronized void remove( EndStorageLink link ) {

            if ( this.violationsByLink != null ) {
                this.violationsByLink.remove( link );
                // TODO improve algorithm
                Collection<T> violationsForLri = this.violationsByLri.get( link.getOtherEnd( ).getLri( ) );
                if ( violationsForLri != null ) {

                    for ( Iterator<T> iter = violationsForLri.iterator( ); iter.hasNext( ); ) {
                        T violation = iter.next( );
                        if ( violation.getAffectedLink( ).equals( link ) ) {
                            iter.remove( );
                        }
                    }

                    if ( violationsForLri.isEmpty( ) ) {
                        this.violationsByLri.remove( link.getOtherEnd( ).getLri( ) );
                    }
                }

                if ( this.violationsByLink.isEmpty( ) ) {
                    this.violationsByLink = null;
                    this.violationsByLri = null;
                }
            }
        }

        public synchronized void remove( LRI lri ) {

            if ( this.violationsByLri != null ) {
                Collection<T> violations = this.violationsByLri.remove( lri );

                for ( T violation : violations ) {
                    this.violationsByLink.remove( violation.getAffectedLink( ) );
                }

                if ( this.violationsByLri.isEmpty( ) ) {
                    this.violationsByLink = null;
                    this.violationsByLri = null;
                }
            }
        }
    }

    private static final class Counter {

        private int counter = 0;

        public Counter( int i ) {

            this.counter = i;
        }

        public int increase( ) {

            return this.counter++;
        }

        public int decrease( ) {

            if ( this.counter > 0 ) {
                return counter--;
            } else {
                return 0;
            }
        }

        public boolean isGreaterThanZero( ) {

            return this.counter > 0;
        }
    }

    /**
     * Helper class for storing duplicate parent link violations. It contains
     * two tables that always contain the same number of elements: Violations by
     * Link and violations by LRI of the dangling end.
     * 
     * @author d026715
     */
    private final static class DuplicateParentViolationTable {

        private Map<EndStorageLink, DuplicateParentConsistencyViolationImpl> violationsByLink;

        private Map<LRI, Collection<DuplicateParentConsistencyViolationImpl>> violationsByChild;

        public synchronized void put( EndStorageLink link, DuplicateParentConsistencyViolationImpl violation ) {

            if ( this.violationsByLink == null ) {
                this.violationsByLink = new LinkedHashMap<EndStorageLink, DuplicateParentConsistencyViolationImpl>( );
            }
            this.violationsByLink.put( link, violation );

            if ( this.violationsByChild == null ) {
                this.violationsByChild = new LinkedHashMap<LRI, Collection<DuplicateParentConsistencyViolationImpl>>( );
            }

            Collection<DuplicateParentConsistencyViolationImpl> foundViolations = this.violationsByChild.get( violation.getChildLri( ) );
            if ( foundViolations == null ) {
                foundViolations = new ArrayList<DuplicateParentConsistencyViolationImpl>( );
                this.violationsByChild.put( violation.getChildLri( ), foundViolations );
            }

            foundViolations.add( violation );
        }

        public synchronized DuplicateParentConsistencyViolationImpl get( EndStorageLink link ) {

            if ( this.violationsByLink != null ) {
                return this.violationsByLink.get( link );
            } else {
                return null;
            }
        }

        public synchronized Collection<DuplicateParentConsistencyViolationImpl> get( LRI child ) {

            return this.violationsByChild.get( child );
        }

        public synchronized Collection<DuplicateParentConsistencyViolationImpl> getAllViolations( ) {

            return this.violationsByLink.values( );
        }

        public synchronized void remove( EndStorageLink link ) {

            if ( this.violationsByLink != null ) {
                DuplicateParentConsistencyViolationImpl removedViolation = this.violationsByLink.remove( link );

                if ( this.violationsByLink.isEmpty( ) ) {
                    this.violationsByLink = null;
                }

                Collection<DuplicateParentConsistencyViolationImpl> foundViolations = this.violationsByChild.get( removedViolation.getChildLri( ) );
                if ( foundViolations.size( ) > 1 ) {
                    foundViolations.remove( removedViolation );
                } else {
                    this.violationsByChild.remove( removedViolation.getChildLri( ) );
                    if ( this.violationsByChild.isEmpty( ) ) {
                        this.violationsByChild = null;
                    }
                }

            }

        }

        public synchronized int size( LRI child ) {

            if ( this.violationsByChild != null ) {
                Collection<DuplicateParentConsistencyViolationImpl> foundViolations = this.violationsByChild.get( child );
                if ( foundViolations != null ) {
                    return foundViolations.size( );
                }
            }
            return 0;
        }
    }

    private static final class UsedElementsTable {

        HashMap<LRI, MRI> elementsMap = new HashMap<LRI, MRI>( );

        /**
         * Sets a new used element without overwriting an existing one.
         * 
         * @param mri
         * @return existing used element
         */
        MRI setUsedElement( MRI mri ) {

            MRI elementUsedBefore = null;
            if ( mri != null ) {
                elementUsedBefore = this.elementsMap.get( mri.getLri( ) );
                if ( elementUsedBefore == null ) {
                    this.elementsMap.put( mri.getLri( ), mri );
                }
            }
            return elementUsedBefore;
        }

        /**
         * Set the used element. Overwrites an existing used element.
         * 
         * @param mri
         * @return existing used element
         */
        MRI resetUsedElement( MRI mri ) {

            MRI elementUsedBefore = null;
            if ( mri != null ) {
                elementUsedBefore = this.elementsMap.get( mri.getLri( ) );
                this.elementsMap.put( mri.getLri( ), mri );
            }
            return elementUsedBefore;
        }

        public MRI getUsedElement( LRI lri ) {

            return this.elementsMap.get( lri );
        }

    }

    public Collection<PRI> getAffectedPartitions( CoreConnection connection, String correctionId ) {

        if ( correctionId != null ) {
            if ( correctionId.startsWith( ElementDeleteCorrectionImpl.OPERATION_ID ) ) {
                return ElementDeleteCorrectionImpl.getAffectedPartitions( connection, correctionId );
            } else if ( correctionId.startsWith( AllOtherElementsDeleteCorrectionImpl.OPERATION_ID ) ) {
                return AllOtherElementsDeleteCorrectionImpl.getAffectedPartitions( connection, correctionId );
            } else if ( correctionId.startsWith( LinkDeleteCorrectionImpl.OPERATION_ID ) ) {
                return LinkDeleteCorrectionImpl.getAffectedPartitions( connection, correctionId );
            } else if ( correctionId.startsWith( AllDanglingLinksOfPartitionDeleteCorrectionImpl.OPERATION_ID ) ) {
                return AllDanglingLinksOfPartitionDeleteCorrectionImpl.getAffectedPartitions( connection, correctionId );
            } else {
                throw new MoinIllegalArgumentException( CoreConsistencyMessages.UNKNOWNCORRECTIONID );
            }
        } else {
            return null;
        }
    }


}
