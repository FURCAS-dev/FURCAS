package com.sap.tc.moin.repository.core.transactions.transactionables;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.transactions.transactionables.ModeledOperationInvokeTransactionable;
import com.sap.tc.moin.repository.transactions.transactionables.TransactionableFactory;

public class TransactionableFactoryImpl implements TransactionableFactory {

    public ModeledOperationInvokeTransactionable createModeledOperationInvokeTransactionable( CoreConnection connection, boolean wrapperCall, RefFeatured featured, Operation operation, int operationId, List<? extends Object> args ) {
        return new ModeledOperationInvokeTransactionableImpl( connection, wrapperCall, featured, operation, operationId, args );
    }
}
