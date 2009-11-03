/*
 * Created on 09.02.2005
 */
package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.model.ModelElement;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;


public interface MoinReference {

    /**
     * Nulls the {@link #isCached()} reference. This is a prerequisite to
     * entitle the referenced instance to garbage collection. Note, however,
     * that this operation does not remove the instance from the workspace at
     * the same time. The caller is responsible for this. The ReferenceManager
     * is not notified on this. The caller (the ReferenceManager himself) is
     * responsible for unregistering this Reference as a cached Reference
     */
    public void uncache( );


    public CorePartitionable get( CoreSession session );


    public CorePartitionable getWithoutException( CoreSession session );


    public PRI getPri( CoreSession session );

    /**
     * Returns the MRI pointing to the model element that is the target of this
     * reference.
     * <p>
     * If resolving should be necessary, the given session is used.
     */
    public MRI getMri( CoreSession session );

    /**
     * Returns the LRI pointing to the model element that is the target of this
     * reference.
     */
    public LRI getLri( );

    /**
     * Returns the MOF ID of the model element that is the target of this
     * reference.
     */
    public String getMofId( );

    /**
     * Tells if this reference is already cached. Note, that a reference may
     * also be reverted from being cached into an uncached reference. This can
     * happen, e.g., when a partition is unloaded / evicted.
     */
    public boolean isCached( );

    /**
     * Obtains the type of the model element referenced.
     */
    public ModelElement getType( CoreSession session );
}