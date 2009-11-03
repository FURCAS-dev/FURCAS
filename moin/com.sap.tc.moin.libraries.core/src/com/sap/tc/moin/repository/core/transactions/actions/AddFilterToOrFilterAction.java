package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class AddFilterToOrFilterAction extends AbstractAction {

    private final OrFilter orFilter;

    private final EventFilter eventFilter;

    public AddFilterToOrFilterAction( CoreConnection connection, OrFilter orFilter, EventFilter eventFilter ) {

        super( connection );
        this.orFilter = orFilter;
        this.eventFilter = eventFilter;
    }

    @Override
    public void execute( ) throws UnrecoverableExecutionException, RecoverableExecutionException {

        orFilter.getOperands( ).add( eventFilter );
    }

    @Override
    public void revert( ) throws UnrecoverableExecutionException {

        orFilter.getOperands( ).remove( orFilter.getOperands( ).size( ) - 1 );
    }

}
