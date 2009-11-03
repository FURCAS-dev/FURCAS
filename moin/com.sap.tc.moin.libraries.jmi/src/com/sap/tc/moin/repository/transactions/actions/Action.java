package com.sap.tc.moin.repository.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public interface Action {

    public void execute( ) throws JmiException, NullPointerException, UnrecoverableExecutionException, RecoverableExecutionException;

    public void revert( ) throws JmiException, NullPointerException, UnrecoverableExecutionException;
}
