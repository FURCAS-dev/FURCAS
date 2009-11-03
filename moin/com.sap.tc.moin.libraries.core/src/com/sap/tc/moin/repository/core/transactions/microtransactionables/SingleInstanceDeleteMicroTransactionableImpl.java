package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.transactions.microtransactionables.SingleInstanceDeleteMicroTransactionable;

public class SingleInstanceDeleteMicroTransactionableImpl extends AbstractInstanceDeleteMicroTransactionableImpl implements SingleInstanceDeleteMicroTransactionable {

    public SingleInstanceDeleteMicroTransactionableImpl( CoreConnection aConnection, RefObject aRefObject ) {

        super( aConnection, aRefObject );
    }

    @Override
    protected void addAllComponentChildren( CorePartitionable instanceToDelete, List<CorePartitionable> instancesToDeleteTmp ) {

        // no not add component children
    }

    @Override
    protected EndStorageLink checkLink( EndStorageLink linkToCheck ) {

        // since the component children are not read, inconsistencies must be checked on the persistence.
        // Otherwise the inconsistencies are not visible and lead to incorrect link deletions.
        return checkLink( linkToCheck, true );
    }
}
