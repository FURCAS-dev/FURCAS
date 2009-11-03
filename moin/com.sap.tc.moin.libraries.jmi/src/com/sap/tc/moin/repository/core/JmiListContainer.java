package com.sap.tc.moin.repository.core;

import java.util.Map;

import com.sap.tc.moin.repository.LRI;


public interface JmiListContainer {

    public void registerJmiList( EndAndMetaObject endAndMetaObject, LRI fromEndLri, JmiList jmiList );

    public JmiList findJmiList( EndAndMetaObject endAndMetaObject, LRI fromEndLri );

    public void invalidateJmiLists( );

    public Map<EndAndMetaObject, JmiList> getRegisteredJmiLists( LRI fromEndLri );

    public void invalidateAndRemoveJmiLists( LRI fromEndLri );
}
