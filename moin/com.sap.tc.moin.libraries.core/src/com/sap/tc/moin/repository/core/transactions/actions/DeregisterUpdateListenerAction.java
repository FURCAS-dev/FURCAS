package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class DeregisterUpdateListenerAction extends AbstractAction {

    private final UpdateListener listener;

    private final EventFilter eventFilterTree;

    public DeregisterUpdateListenerAction( CoreConnection connection, UpdateListener listener, EventFilter eventFilterTree ) {

        super( connection );
        this.listener = listener;
        this.eventFilterTree = eventFilterTree;
    }

    @Override
    public void execute( ) throws UnrecoverableExecutionException, RecoverableExecutionException {

        connection.getSession( ).getEventRegistry( ).deregister( listener );
        connection.getRegisteredListeners( ).remove( listener );
    }

    @Override
    public void revert( ) throws UnrecoverableExecutionException {

        connection.getSession( ).getEventRegistry( ).registerUpdateListener( listener, eventFilterTree );
        connection.getRegisteredListeners( ).add( listener );
    }

}
