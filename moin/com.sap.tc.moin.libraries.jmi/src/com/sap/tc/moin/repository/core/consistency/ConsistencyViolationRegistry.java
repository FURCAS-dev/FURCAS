package com.sap.tc.moin.repository.core.consistency;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateParentConsistencyViolation;
import com.sap.tc.moin.repository.consistency.LinkPermissionConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;

/**
 * Internal interface for the consistency violation registry. This interface is
 * used by the MOIN core for the notification of inconsistencies.
 * 
 * @author d026715
 */
public interface ConsistencyViolationRegistry {

    /**
     * Separator for correction key. Inconsistency corrections are stored as
     * strings that are parsed if the correction is applied.
     */
    public static final String OPERATION_SEPARATOR = "|"; //$NON-NLS-1$

    /**
     * Register dangling link inconsistency.
     * 
     * @param missingElementsLri LRI of the missing element
     * @param link Dangling link
     */
    public void notifyDanglingLinkInconsistency( LRI missingElementsLri, EndStorageLink link );

    /**
     * Register duplicate element inconsistency.
     * 
     * @param mris MRIs of the elements found
     * @return MRI MRI that is used
     */
    public MRI notifyDuplicateElementInconsistency( List<MRI> mris );

    /**
     * Register duplicate element inconsistency.
     * 
     * @param newMri MRI of the new element
     * @param exsitingMri MRI of existing element
     * @return MRI MRI that is used
     */
    public MRI notifyDuplicateElementInconsistency( MRI newMri, MRI existingMri );

    /**
     * Register duplicate parent link inconsistency.
     * 
     * @param mri MRI of the child element
     * @param parentLinks Parent links found.
     * @return EndStorageLink Link to be used
     */
    public EndStorageLink notifyDuplicateParentLinkInconsistency( MRI mri, List<EndStorageLink> parentLinks );

    /**
     * Register link permission inconsistency.
     * 
     * @param deniedEnd the end which is denied to be linked
     * @param link the violating link
     */
    public void notifyLinkPermissionInconsistency( MRI deniedEnd, EndStorageLink link );

    /**
     * Notify resolved duplicate element consistency violation.
     * 
     * @param event
     * @param connection
     */
    public MRI notifyResolvedConsistencyViolation( DuplicateElementConsistencyViolation event );

    /**
     * Notify resolved duplicate parent consistency violation.
     * 
     * @param event
     * @param connection
     */
    public void notifyResolvedConsistencyViolation( DuplicateParentConsistencyViolation event );

    /**
     * Notify resolved dangling link consistency violation.
     * 
     * @param event
     * @param connection
     */
    public void notifyResolvedConsistencyViolation( DanglingLinkConsistencyViolation event );

    /**
     * Notify resolved link permission consistency violation.
     * 
     * @param event
     * @param connection
     */
    public void notifyResolvedConsistencyViolation( LinkPermissionConsistencyViolation event );

    /**
     * Sets the element that is to be used in case of duplicate elements.
     * 
     * @param elementToBeUsed
     * @return element used previously
     */
    public MRI setNewUsedDuplicateElement( MRI elementToBeUsed );

    /**
     * If a new element has been created, the event registry might have to be
     * updated. Use case: import of a partition containing missing elements.
     * 
     * @param lri
     */
    public void elementCreated( LRI lri );

    /**
     * If an element has been deleted, the event registry might have to be
     * updated. Use case: deletion of a duplicate element.
     * 
     * @param mri
     */
    public void elementDeleted( MRI mri );

    /**
     * Called if an element is moved from one partition to another.
     * 
     * @param pri
     * @param oldMri
     */
    public void elementRelocated( CoreConnection connection, PRI pri, MRI oldMri );

    /**
     * If a link has been deleted, the event registry might have to be updated.
     * 
     * @param link
     */
    public void linkDeleted( EndStorageLink link );

    /**
     * If a link has been added, the event registry might have to be updated.
     * 
     * @param link
     * @param connection
     */
    public void linkAdded( CoreConnection connection, EndStorageLink link );

    /**
     * Returns if an element is registered as duplicate. The method also checks
     * duplicates on the persistence.
     * 
     * @param currentConnection The current connection
     * @param lri LRI of element to check
     * @param checkPersistence Check persistence
     * @return List violation instances of existing duplicates
     */
    public List<DuplicateElementConsistencyViolation> checkRegisteredDuplicateElement( CoreConnection currentConnection, LRI lri, boolean checkPersistence );

    /**
     * Returns if an element is registered as duplicate. The method only returns
     * duplicate element violations that occurred while loading partitions. If a
     * duplicate element is located in a partition that has not yet been loaded,
     * it will not be returned.
     * 
     * @param lri LRI of element to check
     * @return List violation instances of existing duplicates
     */
    public List<DuplicateElementConsistencyViolation> checkRegisteredDuplicateElement( LRI lri );

    /**
     * Returns if an element specified by a MRI is registered as duplicate.
     * 
     * @param mri
     * @return Violation instance for the given MRI.
     */
    public DuplicateElementConsistencyViolation checkRegisteredDuplicateElement( MRI mri );

    /**
     * Returns if the given link is registered as dangling link.
     * 
     * @param newParam
     * @param checkPersistence
     * @return
     */
    public DanglingLinkConsistencyViolation checkRegisteredDanglingLink( EndStorageLink newParam, boolean checkPersistence, CoreConnection connection );

    /**
     * Returns all dangling link consistency violations for a given partition.
     * 
     * @param partition
     */
    public List<DanglingLinkConsistencyViolation> checkDanglingLinksOfPartition( PRI partition );

    /**
     * Checks if the link is dangling. Only the LRI of the other end is checked.
     * 
     * @param link
     * @return consistency violation if the link is dangling.
     */
    public ConsistencyViolation checkLinkConsistency( EndStorageLink link, CoreSession session );

    /**
     * Checks if any duplicate element consistency violations exist.
     * 
     * @param checkPersistence Check consistency on persistence
     * @return
     */
    public boolean duplicatesExisting( boolean checkPersistence );

    /**
     * Checks if the given partition contains inconsistencies.
     * 
     * @param pri Partition
     * @return
     */
    public boolean isPartitionInconsistent( PRI pri );

    /**
     * Checks if the given partition contains inconsistencies.
     * 
     * @param pri Partition
     * @param violationType Type of the violation
     * @return
     */
    public boolean isPartitionInconsistent( PRI pri, Class<? extends ConsistencyViolation> violationType );

    /**
     * Starts bulk notification. External listener will only be triggered if
     * {@link #finishBulkNotification(CoreConnection)} is called.
     * 
     * @return
     */
    public boolean enableBulkNotification( );

    /**
     * Ends bulk notification mode and triggers the notification of external
     * listeners.
     * 
     * @param connection A connection
     * @return
     */
    public boolean finishBulkNotification( );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#addListener(ConsistencyListener)}
     * @param listener
     */
    public void addListener( ConsistencyListener listener );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#performConsistencyCheck(PRI)}
     * @param partition Partition to be checked
     * @param connection
     */
    public void performConsistencyCheck( PRI partition, CoreConnection connection );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#performDcDependencyCheck(PRI)}
     * @param partition
     * @param connection
     */
    public void performDcDependencyCheck( PRI partition, CoreConnection connection );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#removeListener(ConsistencyListener)}
     * @param listener
     */
    public void removeListener( ConsistencyListener listener );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#applyCorrection(String)}
     * @param correctionId
     * @param connection
     */
    public void applyCorrection( String correctionId, CoreConnection connection );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#getAllConsistencyViolations()}
     * @return
     */
    public Collection<ConsistencyViolation> getAllConsistencyViolations( );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#getConsistencyViolation(String)}
     * @param id
     * @return
     */
    public ConsistencyViolation getConsistencyViolation( String id );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#getDefaultListener()}
     * @return
     */
    public ConsistencyListener getDefaultListener( );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#listenersRegistered()}
     * @return
     */
    public boolean listenersRegistered( );

    /**
     * @see {@link ConsistencyViolationListenerRegistry#setDefaultListener(ConsistencyListener)}
     * @param listener
     */
    public void setDefaultListener( ConsistencyListener listener );

    /**
     * Returns the session to which the consistency violation registry is
     * attached.
     * 
     * @return
     */
    public CoreSession getSession( );

    /**
     * Returns the affected partitions for a given correction id.
     * 
     * @param correctionId
     * @return
     */
    public Collection<PRI> getAffectedPartitions( CoreConnection connection, String correctionId );


}
