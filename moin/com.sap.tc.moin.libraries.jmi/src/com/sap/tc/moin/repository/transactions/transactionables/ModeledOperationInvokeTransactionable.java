package com.sap.tc.moin.repository.transactions.transactionables;

import com.sap.tc.moin.repository.transactions.Transactionable;

public interface ModeledOperationInvokeTransactionable extends Transactionable {

    public Object getReturnValue( );
}
