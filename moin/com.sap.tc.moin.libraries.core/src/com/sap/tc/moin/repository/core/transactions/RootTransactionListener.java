package com.sap.tc.moin.repository.core.transactions;

import com.sap.tc.moin.repository.transactions.TransactionRecord;

public interface RootTransactionListener {

    public void rootTransactionStarted( AbstractTransaction tx );

    public void rootTransactionCancelled( AbstractTransaction tx );

    public void rootTransactionEnded( TransactionRecord record );
}
