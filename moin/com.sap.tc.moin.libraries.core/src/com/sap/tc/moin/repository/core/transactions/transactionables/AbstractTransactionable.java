package com.sap.tc.moin.repository.core.transactions.transactionables;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.transactions.AbstractTransactionObject;
import com.sap.tc.moin.repository.transactions.Transactionable;

public abstract class AbstractTransactionable extends AbstractTransactionObject implements Transactionable {

    protected AbstractTransactionable( CoreConnection aConnection ) {

        super( aConnection );
    }

    protected AbstractTransactionable( CoreConnection aConnection, WorkspaceSet workspaceSet ) {

        super( aConnection, workspaceSet );
    }
}
