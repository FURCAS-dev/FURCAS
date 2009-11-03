package com.sap.tc.moin.repository.core;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public interface WorkspaceSet {

    public static final String OCL_PACKAGE_NAME = "OCL"; //$NON-NLS-1$

    public ReferenceManager getReferenceManager( );

    public SynchronizationManager getSynchronizationManager( );

    public CorePartitionable resolveMri( CoreSession session, MRI mri );

    public CorePartitionable resolveLri( CoreSession session, LRI lri );

    /**
     * Convenience method. Same as calling
     * {@link #resolvePri(CoreSession, PRI, boolean)} with
     * "includeDeletedInMemory = false".
     * 
     * @param pri the PRI to be resolved to the corresponding model partition.
     * @return
     */
    public CoreModelPartition resolvePri( CoreSession session, PRI pri );

    /**
     * Resolves a PRI to a model partition. If a model partition with the given
     * PRI cannot be found in the client specific workspace of the current
     * connection, it is tried to resolve the PRI from the persistence.
     * 
     * @param pri the PRI to be resolved to the corresponding model partition.
     * @param includeDeletedInMemory if set to <code>true</code>, the model
     * partition for the given PRI will be returned, even if it is marked as
     * {@link CoreModelPartition#isDeleted() deleted}. If set to
     * <code>false</code>, <code>null</code> is returned.
     * @return
     */
    public CoreModelPartition resolvePri( CoreSession session, PRI pri, boolean includeDeletedInMemory );

    public boolean priExists( CoreSession session, PRI pri );

    public boolean mriExists( CoreSession session, MRI mri );

    public boolean lriExists( CoreSession session, LRI lri );

    public CompoundDataArea getCompoundDataArea( );

    public LogicalLinkManager getLogicalLinkManager( );

    public EndAndMetaObjectPool getEndAndMetaObjectPool( );

    public SpiSession createSession( SpiCompoundClientSpec compoundClientSpec );

    public int getNumberOfSessions( );

    public Collection<CoreSession> getSessions( );

    public void removeSession( Session session );

    public CoreMoin getMoin( );

    public WrapperManager getWrapperManager( );

    public Collection<SharedWorkspace> getSharedWorkspaces( );

    public PartitionLockManager getLockManager( );

    public EndStorageLinkFactory getLinkFactory( );

    public Collection<SessionWorkspace> getClientSpecificWorkspaces( );

    public Collection<CoreSession> getSessionsForClientId( String clientId );

    /**
     * Gets the mri for the given lri without loading the partition.
     * 
     * @param connection
     * @param lri
     * @return
     */
    public MRI getMriForLri( CoreSession session, LRI lri );

    public CorePartitionable resolveLriInMemory( CoreSession session, LRI lri );

    public Collection<CorePartitionable> resolveLriInMemoryIncludingInconsistencies( CoreSession session, LRI lri );

    RefPackage[] getPackages( String modelContainerName, String... qualifiedName );

    // FIXME: to be removed:
    public ExtentManager getExtentManager( );

    public Workspace getWorkspace( SpiStage stage, Session session );

    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( CompoundClientSpec compoundClientSpec );

    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( String clientId );

    public Collection<CompoundClientSpecWorkspace> getCompoundClientSpecWorkspaces( );
}