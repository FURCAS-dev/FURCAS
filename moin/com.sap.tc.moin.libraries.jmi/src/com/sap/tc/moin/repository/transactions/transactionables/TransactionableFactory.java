package com.sap.tc.moin.repository.transactions.transactionables;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.core.CoreConnection;

public interface TransactionableFactory {

    public ModeledOperationInvokeTransactionable createModeledOperationInvokeTransactionable( CoreConnection connection, boolean wrapperCall, RefFeatured featured, Operation operation, int operationId, List<? extends Object> args );
}
