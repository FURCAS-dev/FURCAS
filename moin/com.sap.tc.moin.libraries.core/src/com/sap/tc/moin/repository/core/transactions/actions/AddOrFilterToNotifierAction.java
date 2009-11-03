package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class AddOrFilterToNotifierAction extends AbstractAction {

    private final NotifierSimple notifier;

    private final EventFilter eventFilter;

    public AddOrFilterToNotifierAction( CoreConnection connection, NotifierSimple notifier, EventFilter eventFilter ) {

        super( connection );
        this.notifier = notifier;
        this.eventFilter = eventFilter;
    }

    @Override
    public void execute( ) throws UnrecoverableExecutionException, RecoverableExecutionException {

        notifier._filter = new OrFilter( eventFilter, notifier.getFilter( ) );
    }

    @Override
    public void revert( ) throws UnrecoverableExecutionException {

        notifier._filter = ( (OrFilter) notifier._filter ).getOperands( ).get( 1 );
    }

}
