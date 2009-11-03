package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * @author d020383
 */
public interface CoreConnection extends Connection {


    public CoreModelPartition getPartition( PRI pri );

    /**
     * @return Returns the session this Connection is assigned to.
     */
    public CoreSession getSession( );


    /**
     * Used to inform this connection that the given partition was modified "by"
     * (i.e. in the context of) this connection.
     * 
     * @param partition the partition which was modified by this connection
     */
    public void modifiedPartition( CoreModelPartition partition );

    /**
     * Removes the given parition from the list of dirty partitions.
     * 
     * @param partition
     */
    public void removeFromModifiedPartitions( CoreModelPartition partition );

    /**
     * Returns the {@link PartitionLockManager partition lock manager} of the
     * {@link DataArea data area} which is associated to this connection via the
     * {@link ClientSpec}.
     * 
     * @return the {@link PartitionLockManager partition lock manager} of the
     * {@link DataArea data area} which is associated to this connection via the
     * {@link ClientSpec}.
     */
    public PartitionLockManager getPartitionLockManager( );

    /**
     * Returns the DataArea used for newly created elements
     */
    public DataArea getTargetDataArea( );

    /**
     * Returns the default transient partition of this connection.
     * 
     * @return the default transient partition of this connection.
     */
    public CoreModelPartition getNullPartition( );

    /**
     * Returns a custom transient partition with the passed partitionName
     * 
     * @param partitionName the name of the partition to be created
     * @return the newly created TransientPartition
     */
    public CoreModelPartition getOrCreateTransientPartition( String partitionName );

    public CoreModelPartition getOrCreateTransientPartitionNonTransactional( String partitionName );

    /**
     * Returns the RefPackages of all top level packages
     * 
     * @return the RefPackages of all top level packages
     */
    public RefPackage[] getTopLevelPackages( );


    public SpiJmiHelper getCoreJmiHelper( );

    /**
     * Returns the connection's wrapper.
     */
    public ConnectionWrapper getWrapper( );

    /**
     * Returns a wrapper for the given model partition.
     */
    public ModelPartition getWrapperForModelPartition( ModelPartition partition );

    /**
     * Returns a wrapper for the given JMI object.
     */
    public <T extends RefBaseObject> T getWrapperForJmiObject( T refBaseObject );

    /**
     * Returns a wrapper for the given JmiList.
     */
    public AbstractConnectionAwareWrapper getWrapperForJmiList( JmiList jmiList );


    public AttributeValuesWrapper getWrapperForMultiValuedAttributesList( MultiValuedAttributesList object );

    /**
     * Tells if the element is new i.e. it is only existing in memory and hasn't
     * been stored in the persistence yet.
     * 
     * @param element the element to check if it is new or not.
     * @return <code>true</code> if the element is currently only existing in
     * memory and hasn't been stored in the persistence yet, <code>false</code>
     * otherwise.
     */
    public boolean isNewElement( CorePartitionable element );

    /**
     * Returns an unmodifiable, non-live snapshot of the new elements of this
     * connection.
     * 
     * @return an unmodifiable collection of the new elements of this
     * connection.
     * @see #isNewElement(CorePartitionable)
     * @see #addNewElement(CorePartitionable)
     * @see #removeNewElement(CorePartitionable)
     */
    public Collection<CorePartitionable> getNewElements( );

    /**
     * Removes all new elements from the connection.
     * 
     * @see #getNewElements()
     */
    public void clearNewElements( );

    /**
     * Adds an element to the {@link #getNewElements() new elements} of this
     * connection.
     * 
     * @param element the element to add to the new elements of this connection.
     * @see #removeNewElement(CorePartitionable)
     * @see #getNewElements()
     * @see #isNewElement(CorePartitionable)
     */
    public void addNewElement( CorePartitionable element );

    /**
     * Removes an element from the {@link #getNewElements() new elements} of
     * this connection.
     * 
     * @param element the element to remove from the new elements of this
     * connection.
     * @see #getNewElements()
     * @see #addNewElement(CorePartitionable)
     * @see #isNewElement(CorePartitionable)
     */
    public void removeNewElement( CorePartitionable element );

    /**
     * Returns the {@link PartitionChangeRecorder} of this connection.
     */
    public PartitionChangeRecorder getPartitionChangeRecorder( );

    /**
     * Returns the consistency violation event registry.
     * 
     * @return
     */
    public ConsistencyViolationRegistry getConsistencyViolationRegistry( );

    /**
     * Returns the same as {@link Connection#getPartitionsToBeSaved()}, but
     * without creating a new collection. Instead, the internal collection is
     * returned directly.
     */
    public Collection<CoreModelPartition> getDirtyPartitionsWithoutNullPartition( );

    /**
     * Returns the {@link CommandStack} instance of this connection.
     */
    public CoreCommandStack getCommandStack( );


    /**
     * Returns the listeners that are currently registered via this Connection.
     * 
     * @return the listeners that are currently registered via this Connection.
     */
    public Collection<EventListener> getRegisteredListeners( );

    /**
     * Only for usage by the wrapper (Use {@link Connection#close()})
     */
    public void closeInternal( );

    /**
     * closes the connection and nullifies its synchronization manager (whose
     * lifecycle is attached to that of the WorkspaceSet)
     */
    public void shutdown( );

    /**
     * Returns all transient partitions of this connection, not including the
     * null-partition and without creating a new result collection.
     */
    public Collection<CoreModelPartition> getTransientPartitionsInternal( );


    /**
     * @return the OclRegistryService
     */
    public CoreOclRegistryService getCoreOclRegistryService( );

    /**
     * For the real javadoc, see
     * {@link RefObjectUtil#addLinkTarget(RefObject, AssociationEnd, LRI)}.
     * 
     * @see RefObjectUtil#addLinkTarget(RefObject, AssociationEnd, LRI)
     */
    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target );

    /**
     * For the real javadoc, see
     * {@link RefObjectUtil#addLinkTarget(RefObject, AssociationEnd, LRI, int)}.
     * 
     * @see RefObjectUtil#addLinkTarget(RefObject, AssociationEnd, LRI, int)
     */
    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target, int position );

    /**
     * Specifies if is is allowed to call {@link Connection#save()} on this
     * connection.
     * 
     * @param allowed <code>false</code> if this connection cannot be saved.
     */
    public void setSaveAllowed( boolean allowed );

    /** Returns the factory for the Model Importer/Exporter. */
    public IeFactory getImportExportFactory( );

    /**
     * Returns all currently cached JMI wrappers of all data areas.
     */
    public Collection<Wrapper> getCachedJmiWrappers( );

    public void setMriReferenceOfJmiWrapperToSessionWorkspace( MRI mriOfWrapper );

    public void updateWrapperCaches( PRI pri, Workspace workspaceToHostTheReferencesAfterwards );

    public DeepCopyResultSet deepCopy( Map<MRI, CoreConnection> elementsToBeCopied, DeepCopyPolicyHandlerWrapper policyHandler, boolean includeExternalCompositeParents );

    public MultiValuedAttributesList getMultiValueAttributesList( CorePartitionable featured, String attributeMofId );


}
