package com.sap.tc.moin.repository.core.transactions.actions;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class RegisterNotifierAction extends AbstractAction {

    private final NotifierSimple notifier;

    private final List<NotifierSimple> notifiers;

    private final int index;

    public RegisterNotifierAction( CoreConnection connection, NotifierSimple notifier, List<NotifierSimple> notifiers, int index ) {

        super( connection );
        this.notifier = notifier;
        this.notifiers = notifiers;
        this.index = index;
    }

    @Override
    public void execute( ) throws UnrecoverableExecutionException, RecoverableExecutionException {

        notifiers.add( index, notifier );
        connection.getRegisteredListeners( ).add( notifier.getListener( ) );
    }

    @Override
    public void revert( ) throws UnrecoverableExecutionException {

        NotifierSimple removed = notifiers.remove( index );
        assert removed == notifier;
        connection.getRegisteredListeners( ).remove( notifier.getListener( ) );
    }

}
