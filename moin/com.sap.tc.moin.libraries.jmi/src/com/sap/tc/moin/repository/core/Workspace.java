/*
 * Created on 09.02.2005
 */
package com.sap.tc.moin.repository.core;

import java.util.Collection;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.SpiWorkspace;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;

/**
 * A workspace holds the contents of a set of model partitions in memory. A
 * workspace becomes responsible for a partition by explicitly assigning the
 * partition to a workspace. This would typically happen, e.g., upon loading a
 * partition into a workspace from a
 * {@link SpiPersistence#loadPartition(SpiWorkspace, PRI) persistent store}. The
 * workspace is no longer responsible for a partition if the partition is
 * evicted again.
 * <p>
 * Adding model elements and links to a workspace requires that the element or
 * link belongs to a partition for which this workspace is responsible. Other
 * requests will cause an exception to be thrown. If a model element changes
 * partition assignments later, this rule has to be enforced. It may require a
 * relocation of the model element or the link to another workspace.
 * <p>
 * The partitions within one workspace must all have distinct values for
 * {@link ModelPartition#getSCVAbsoluteMRI()}. Note, that this allows for two
 * partitions in a workspace that return equal results for
 * {@link ModelPartition#getUri()}which is the SCV-relative URI of the
 * partition.
 * <p>
 * If a refinement partition is part of a workspace, then the refined partition
 * is only reachable via the refinement partition but is not itself contained in
 * the partitions association.
 * <p>
 * Operations on a Workspace require a valid
 * {@link com.sap.tc.moin.repository.core.impl.ConnectionImpl}attached to the
 * calling Thread (presumably implemented as a ThreadLocal).
 * <p>
 * 
 * @author d043530
 */
public interface Workspace extends SpiWorkspace, ReferenceKeeper {

    /**
     * Constant to be used if a link was not added via a
     * {@link com.sap.tc.moin.repository.mmi.model.Reference}.
     */
    public static int LINK_NOT_ADDED_VIA_REFERENCE = -1;

    /**
     * Constant to be used if a link was added via an
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute}.
     */
    public static int LINK_ADDED_VIA_ATTRIBUTE = 1;

    /**
     * Constant to be used if a link was not added at a certain index.
     */
    public static int LINK_NOT_ADDED_AT_INDEX = -1;

    public WorkspaceSet getWorkspaceSet( );

    public CorePartitionable resolveElementMri( CoreSession session, MRI mri );

    /**
     * Creates a new MOF ID.
     * 
     * @param forPartition The partition in which the element is created
     * @return the created MOF ID
     */
    public String createMofId( CoreModelPartition forPartition );

    public MemoryLinkManager getMemoryLinkManager( );

    public QueryLinkManager getQueryLinkManager( );

    public CoreInstanceManager getInstanceManager( );

    public CorePartitionManager getPartitionManager( );

    public CorePartitionFactory getPartitionFactory( );

    /**
     * Returns true, if the Workspace is alive, otherwise null
     * 
     * @return true, if the Workspace is alive, otherwise null
     */
    public boolean isAlive( );

    /**
     * Returns true, if the Workspace is shared
     * 
     * @return true, if the Workspace is shared
     */
    public boolean isShared( );

    /**
     * Destroys this {@link Workspace} and all its components.
     */
    public void destroy( );

    public boolean isMetamodelWorkspace( );

    /**
     * Notifies this workspace that the partition with the given PRI changed.
     * 
     * @param pri the partition which changed
     * @param delta the detailed information of the partition modifications
     */
    public void partitionChanged( PRI pri, SpiPartitionDelta delta );

    public JmiInstantiator getJmiInstantiator( );

    public Collection<MriReference> getHostedMriReferences( );
}
