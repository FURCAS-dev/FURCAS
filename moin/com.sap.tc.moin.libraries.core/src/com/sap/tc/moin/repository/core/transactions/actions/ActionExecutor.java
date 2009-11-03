package com.sap.tc.moin.repository.core.transactions.actions;

import java.util.ArrayList;
import java.util.List;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;

public class ActionExecutor {

    /**
     * Executes one single {@link Action}.
     */
    public static void executeAction( Action anAction ) throws JmiException, NullPointerException, UnrecoverableExecutionException, RecoverableExecutionException {

        anAction.execute( );
    }

    /**
     * Reverts one single {@link Action}.
     */
    public static void revertAction( Action anAction ) throws JmiException, NullPointerException, UnrecoverableExecutionException {

        anAction.revert( );
    }

    /**
     * Reverses a list of {@link Action}s.
     */
    public static List<Action> reverseActionList( List<Action> theActions ) {

        List<Action> reversedActions = new ArrayList<Action>( );
        for ( int i = theActions.size( ) - 1; i >= 0; i-- ) {
            reversedActions.add( theActions.get( i ) );
        }
        return reversedActions;
    }
}
