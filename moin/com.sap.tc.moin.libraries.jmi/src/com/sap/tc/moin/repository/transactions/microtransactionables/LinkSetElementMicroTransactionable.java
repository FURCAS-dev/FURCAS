package com.sap.tc.moin.repository.transactions.microtransactionables;

import com.sap.tc.moin.repository.transactions.MicroTransactionable;

public interface LinkSetElementMicroTransactionable extends MicroTransactionable {

    public Object getElementReplaced( );
}
