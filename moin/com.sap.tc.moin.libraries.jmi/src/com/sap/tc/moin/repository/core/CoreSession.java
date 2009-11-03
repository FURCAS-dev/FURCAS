/*
 * Created on 09.02.2005
 */
package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.ocl.service.OclService;
import com.sap.tc.moin.repository.shared.util.Notifyee;
import com.sap.tc.moin.repository.shared.util.NotifyingWeakHashMap;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.transactions.TransactionManager;

/**
 * Sessions are isolated with regard to their user-specific workspace contents.
 * All sessions that share a common {@link Workspace} will immediately see
 * modifications to that {@link Workspace} which supposedly can only be due to a
 * change of the active state in DTR or CBS.
 * 
 * @author d043530
 */
public interface CoreSession extends SpiSession {

    /**
     * @return Returns the workspace.
     */
    public SessionWorkspace getWorkspace( );

    /**
     * By calling this method a client, a {@link NotifyingWeakHashMap.Notifyee},
     * can register for being notified as soon as the {@link Connection} is
     * removed or garbage collected. If this happens the method
     * <code>notifyOnObjectRemoved</code> of the provided Notifyee is called and
     * the context object which has been provided when registering is passed
     * along.
     * 
     * @param connection the Connection for which to register
     * @param context the context which should be passed with the notification
     * call. This context object usually should identify the Connection. As the
     * Connection no longer exists in this case, just an alternative context can
     * be provided
     * @param notifyee the one to notify on the removal
     */
    public void registerForConnectionCloseEvent( Connection connection, Object context, Notifyee notifyee );

    /**
     * @return the CoreCompoundClientSpec this session is based on.
     */
    public SpiCompoundClientSpec getCompoundClientSpec( );

    /**
     * @return the {@link TransactionManager} instance.
     */
    public TransactionManager getTransactionManager( );

    /**
     * @return the OCL service
     */
    public OclService getOclService( );

    /**
     * @return the Core OclRegistry service
     */
    public CoreOclRegistryService getCoreOclRegistryService( );

    /**
     * Returns the root interface for the access to MOIN
     * 
     * @return the root interface for the access to MOIN
     */
    public CoreMoin getMoin( );

    /**
     * Returns the session's wrapper.
     */
    public SessionWrapper getWrapper( );

    public WorkspaceSet getWorkspaceSet( );

    /**
     * Returns consistency violation registry.
     * 
     * @return
     */
    public ConsistencyViolationRegistry getConsistencyViolationRegistry( );

    /**
     * Returns the connections owned by this Session
     * 
     * @return the connections owned by this Session
     */
    public Set<CoreConnection> getConnections( );

    /**
     * Closes the session. This call is for internal use only and only allowed
     * if the session has no connections open. Otherwise, an
     * IllegalStateException is thrown.
     */
    public void close( ) throws IllegalStateException;

    /**
     * Returns the cache for "getPartitionsInContainer"
     * 
     * @return the cache for "getPartitionsInContainer"
     */
    public Map<CRI, Collection<PRI>> getCachePartitionsInContainer( );

    public List<CoreModelPartition> getPartitionsToConsiderMemoryState( );

    public CorePartitionable getElement( MRI mri );

    public CorePartitionable getElement( LRI lri );

    public RefPackage getPackage( String modelContainerName, String... qualifiedName );

    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( );

    /**
     * Creates a private copy of the specified partition in the
     * {@link SessionWorkspace}. The created copy is returned.
     */
    public CoreModelPartition createPrivateCopyOfPartition( PRI pri );

    public Object getWrapperCacheLock( );

    public void updateWrapperCaches( PRI pri, Workspace workspaceToHostTheReferencesAfterwards );
}