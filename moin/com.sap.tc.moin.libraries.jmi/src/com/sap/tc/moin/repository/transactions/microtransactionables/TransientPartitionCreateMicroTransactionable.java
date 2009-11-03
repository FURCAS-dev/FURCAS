package com.sap.tc.moin.repository.transactions.microtransactionables;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;

public interface TransientPartitionCreateMicroTransactionable extends MicroTransactionable {

    public ModelPartition getPartitionCreated( );
}
