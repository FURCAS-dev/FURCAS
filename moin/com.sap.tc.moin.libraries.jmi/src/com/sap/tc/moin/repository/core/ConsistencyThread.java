package com.sap.tc.moin.repository.core;

public interface ConsistencyThread {

    public void addNewEvent( ConsistencyViolationEvent event );

    public void waitForQueue( );

    public void requestShutdown( );
}
