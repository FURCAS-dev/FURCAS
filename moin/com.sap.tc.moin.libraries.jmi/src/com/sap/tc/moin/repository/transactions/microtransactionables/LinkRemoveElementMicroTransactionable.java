package com.sap.tc.moin.repository.transactions.microtransactionables;

import java.util.List;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;

public interface LinkRemoveElementMicroTransactionable extends MicroTransactionable {

    public boolean linkSetChanged( );

    public List getElementsRemoved( );
}
