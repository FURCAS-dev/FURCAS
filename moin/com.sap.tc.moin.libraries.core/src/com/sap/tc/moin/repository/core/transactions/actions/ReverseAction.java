package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;

public class ReverseAction implements Action {

    private final Action action;

    public ReverseAction( Action action ) {

        this.action = action;
    }

    public void execute( ) throws JmiException, NullPointerException, UnrecoverableExecutionException, RecoverableExecutionException {

        action.revert( );
    }

    public void revert( ) throws JmiException, NullPointerException, UnrecoverableExecutionException {

        action.execute( );
    }

}
