package com.sap.tc.moin.repository.core;

import java.util.List;

import com.sap.tc.moin.repository.LRI;

public interface DistributedLinkContainer {

    public List<EndStorageLink> getLinksForMetaObject( String metaObjectMofId, CorePartitionable elementAtEnd );

    public List<EndStorageLink> getLinksForElement( CorePartitionable element );

    public void addLink( LRI lriOfElement, EndStorageLink link );

    public void removeLink( LRI lriOfElement, EndStorageLink link );

    public void clear( );

    public void trimToSize( );
}
