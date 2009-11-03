package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;

/**
 * A link manager which takes into account both the persistent state of links as
 * well as the current dirty state in memory.
 * 
 * @author d044711
 */
public interface QueryLinkManager extends EndStorageLinkManager {

    /**
     * @param endAndMetaObject the combined key which specifies the end number
     * "from" where navigation starts and the corresponding metaObject
     * (attribute/association) on whose behalf the elements are connected.
     * @param elementAtEnd the element at the "fromEnd" of the given
     * EndAndMetaObject for which the associated (by the "metaObject" of the
     * given EndAndMetaObject) elements are requested.
     * @return
     */
    public Collection<EndStorageLink> getLinksForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );

    public Collection<EndStorageLink> getLinksForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd, boolean ignorePersistence );

    public Collection<PRI> getReferringPartitions( CoreSession session, MRI element );

    public void updateCaches( LRI lriOfOtherEnd, EndAndMetaObject endAndMetaObject, Iterator iterator );

    public void elementRelocated( MRI oldMri, CoreModelPartition newPartition );
}
