package com.sap.tc.moin.repository.transactions.microtransactionables;

import com.sap.tc.moin.repository.transactions.MicroTransactionable;

public interface ReferenceChangeMicroTransactionable extends MicroTransactionable {

    public boolean referenceChanged( );
}
