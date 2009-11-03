package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.CoreEventRegistry;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.core.transactions.actions.AddFilterToOrFilterAction;
import com.sap.tc.moin.repository.core.transactions.actions.AddOrFilterToNotifierAction;
import com.sap.tc.moin.repository.core.transactions.actions.RegisterNotifierAction;
import com.sap.tc.moin.repository.core.transactions.actions.ReverseAction;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.transactions.actions.Action;

public abstract class RegisterListenerMicroTransactionable extends AbstractMicroTransactionable {

    protected final EventListener listener;

    protected final EventFilter eventFilter;

    protected Action action;

    public RegisterListenerMicroTransactionable( CoreConnection connection, EventListener listener, EventFilter eventFilter ) {

        super( connection );
        this.listener = listener;
        this.eventFilter = eventFilter;
    }

    abstract protected NotifierSimple createNotifier( );

    abstract protected List<NotifierSimple> getNotifiers( );

    @Override
    public void computeDoActionsAndDoEvents( ) {

        List<NotifierSimple> notifiers = getNotifiers( );
        // first check if the listener has already been registered.
        // If yes, then combine the old filter and the new filter with "Or"
        NotifierSimple notifierInList = null;
        for ( int i = 0; i < notifiers.size( ); i++ ) {
            NotifierSimple notifierLoop = notifiers.get( i );
            if ( notifierLoop.getListener( ) == listener ) {
                notifierInList = notifierLoop;
                break;
            }
        }

        if ( notifierInList == null ) {
            action = new RegisterNotifierAction( connection, createNotifier( ), notifiers, notifiers.size( ) );
        } else {
            EventFilter filterInList = notifierInList.getFilter( );
            if ( filterInList instanceof OrFilter ) {
                action = new AddFilterToOrFilterAction( connection, (OrFilter) filterInList, eventFilter );
            } else {
                action = new AddOrFilterToNotifierAction( connection, notifierInList, eventFilter );
            }
        }

        getOrCreateDoActions( ).add( action );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        getOrCreateUndoActions( ).add( new ReverseAction( action ) );
    }

    public final CoreEventRegistry getCoreEventRegistry( ) {

        return (CoreEventRegistry) connection.getSession( ).getEventRegistry( );
    }
}