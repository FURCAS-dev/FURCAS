package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;


public interface ConsistencyViolationEvent {

    public void notifyExternalListeners( );

    public CoreSession getSession( );

    public ConsistencyViolationRegistry getRegistry( );
}
