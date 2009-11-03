package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.InstanceDeleteMicroTransactionable;

public class InstanceDeleteMicroTransactionableImpl extends AbstractInstanceDeleteMicroTransactionableImpl implements InstanceDeleteMicroTransactionable {

    public InstanceDeleteMicroTransactionableImpl( CoreConnection aConnection, RefObject aRefObject ) {

        super( aConnection, aRefObject );
    }

    @Override
    protected void addAllComponentChildren( CorePartitionable instanceToDelete, List<CorePartitionable> instancesToDeleteTmp ) {

        instancesToDeleteTmp.addAll( getAllComponentChildrenRecursive( instanceToDelete ) );
    }
}
