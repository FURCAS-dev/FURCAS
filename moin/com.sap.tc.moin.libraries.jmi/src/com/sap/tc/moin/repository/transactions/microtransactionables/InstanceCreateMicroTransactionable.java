package com.sap.tc.moin.repository.transactions.microtransactionables;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;

public interface InstanceCreateMicroTransactionable extends MicroTransactionable {

    public RefObject getInstanceCreated( );
}
