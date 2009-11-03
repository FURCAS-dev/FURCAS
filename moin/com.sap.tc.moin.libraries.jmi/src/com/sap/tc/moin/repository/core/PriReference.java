package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.PRI;

public interface PriReference {

    /**
     * Returns the enclosing {@link WorkspaceSet}.
     */
    public WorkspaceSet getWorkspaceSet( );

    /**
     * Tells if this reference is already cached. Note, that a reference may
     * also be reverted from being cached into an uncached reference. This can
     * happen, e.g., when the partition is unloaded / evicted.
     */
    public boolean isCached( );

    /**
     * Nulls the {@link #isCached()} reference. This is a prerequisite to
     * entitle the referenced instance to garbage collection. Note, however,
     * that this operation does not remove the partition from the workspace at
     * the same time. The caller is responsible for this. The ReferenceManager
     * is notified on this in order to unregister this Reference as a cached
     * Reference.
     */
    public void uncache( );

    /**
     * Obtains the resolved partition that is the target of this reference. If
     * this reference is not cached at the time this operation is invoked, it is
     * resolved first.
     */
    public CoreModelPartition get( CoreConnection connection );

    /**
     * Determines the PRI of the partition to which this reference points.
     */
    public PRI getPri( );

    public CoreModelPartition getWithoutException( CoreConnection connection );

    /**
     * Returns then referenced CoreModelPartition if the PriReference is cached,
     * and null otherwise.
     */
    public CoreModelPartition getIfResolved( );

}