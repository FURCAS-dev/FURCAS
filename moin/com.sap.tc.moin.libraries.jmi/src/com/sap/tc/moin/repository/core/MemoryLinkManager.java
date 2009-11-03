/*
 * Created on 21.09.2006
 */
package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;
import com.sap.tc.moin.repository.spi.core.SpiLinkManager;

/**
 * A link manager which only handles links that are currently loaded in the
 * repository. Persistent links (if not loaded yet) are not taken into account.
 * 
 * @author d044711
 */
public interface MemoryLinkManager extends EndStorageLinkManager, SpiLinkManager {

    public Collection<EndStorageLink> getLinksForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, MRI elementAtEnd );

    public void evictLinksStoredInPartition( CoreModelPartition partition );

    public void evictLinksAndInvalidateJmiLists( CoreModelPartition partition );

    public Collection<EndStorageLink> getDistributedEndStorageLinksForEndAndMetaObject( CoreConnection connection, String metaObjectMofId, CorePartitionable elementAtEnd, Set<PRI> scope );

    public boolean isAssociationLinkExisting( CoreConnection connection, EndStorageLink endStorageLink );

    public MoinReference createMoinReferenceForOtherEnd( PRI storageEndPri, CorePartitionable otherEnd );

    public MoinReference createMoinReferenceForOtherEnd( LRI otherEnd );

    public void removeLink( CoreConnection connection, String attributeOrAssociationEndMofId, EndStorageLink link, IteratorKnowingCollection<EndStorageLink> iterator );

    public void addLink( CoreConnection connection, String attributeOrAssociationEndMofId, EndStorageLink link, int index );

    public void removeLinkOnRevert( CoreConnection connection, String attributeOrAssociationEndMofId, EndStorageLink link );

    public EndStorageLink createLink( CoreSession session, byte storageEnd, CorePartitionable elementAtStoredEnd, LRI lri, Association association );

    public void replaceLogicalLinkMultiplicityOne( CoreConnection connection, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, Association assocation );
}
