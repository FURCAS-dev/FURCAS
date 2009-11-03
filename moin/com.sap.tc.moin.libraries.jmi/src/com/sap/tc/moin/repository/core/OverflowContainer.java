package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.LRI;

public interface OverflowContainer {

    public void add( EndStorageLink link );

    public void remove( EndStorageLink link );

    public Collection<EndStorageLink> getOverflowLinks( LRI lriOfElement, EndAndMetaObject endAndMetaObject );

    public Collection<EndStorageLink> getAllOverflowLinks( LRI lriOfElement );

    public List<EndStorageLink> getCompositeParentLinks( LRI lriOfElement );
}
