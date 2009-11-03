package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.CoreEventRegistry;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.core.transactions.actions.RegisterNotifierAction;
import com.sap.tc.moin.repository.core.transactions.actions.ReverseAction;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.shared.util.Tuple.Triple;
import com.sap.tc.moin.repository.transactions.actions.Action;

public class DeregisterListenerMicroTransactionable extends AbstractMicroTransactionable {

    private final EventListener listener;

    private Triple<NotifierSimple, Integer, List<NotifierSimple>> preChange;

    private Triple<NotifierSimple, Integer, List<NotifierSimple>> change;

    private Triple<NotifierSimple, Integer, List<NotifierSimple>> preCommit;

    private Triple<NotifierSimple, Integer, List<NotifierSimple>> commit;

    private Triple<NotifierSimple, Integer, List<NotifierSimple>> update;

    public DeregisterListenerMicroTransactionable( CoreConnection connection, EventListener listener ) {

        super( connection );
        this.listener = listener;
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        preChange = addDoAction( getCoreEventRegistry( ).getPreChangeNotifiers( ) );
        change = addDoAction( getCoreEventRegistry( ).getChangeNotifiers( ) );
        preCommit = addDoAction( getCoreEventRegistry( ).getPreCommitNotifiers( ) );
        commit = addDoAction( getCoreEventRegistry( ).getCommitNotifiers( ) );
        update = addDoAction( getCoreEventRegistry( ).getUpdateNotifiers( ) );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        addUndoAction( preChange );
        addUndoAction( change );
        addUndoAction( preCommit );
        addUndoAction( commit );
        addUndoAction( update );
    }

    private Triple<NotifierSimple, Integer, List<NotifierSimple>> addDoAction( List<NotifierSimple> notifiers ) {

        int index = getIndexOfListener( notifiers, listener );
        if ( index != -1 ) {
            NotifierSimple notifier = notifiers.get( index );
            Action action = new ReverseAction( new RegisterNotifierAction( connection, notifier, notifiers, index ) );
            getOrCreateDoActions( ).add( action );
            return new Triple<NotifierSimple, Integer, List<NotifierSimple>>( notifier, index, notifiers );
        }
        return null;
    }

    private void addUndoAction( Triple<NotifierSimple, Integer, List<NotifierSimple>> triple ) {

        if ( triple == null ) {
            return;
        }

        NotifierSimple notifier = triple.getA( );
        Integer index = triple.getB( );
        List<NotifierSimple> notifiers = triple.getC( );

        getOrCreateUndoActions( ).add( new RegisterNotifierAction( connection, notifier, notifiers, index ) );
    }

    private static int getIndexOfListener( List<NotifierSimple> notifiers, EventListener listener ) {

        for ( int i = 0; i < notifiers.size( ); i++ ) {
            if ( notifiers.get( i ).getListener( ) == listener ) {
                return i;
            }
        }
        return -1;
    }

    public final CoreEventRegistry getCoreEventRegistry( ) {

        return (CoreEventRegistry) connection.getSession( ).getEventRegistry( );
    }
}