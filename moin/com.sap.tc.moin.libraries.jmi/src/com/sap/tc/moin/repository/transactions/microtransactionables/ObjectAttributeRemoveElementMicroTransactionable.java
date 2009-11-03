package com.sap.tc.moin.repository.transactions.microtransactionables;

import java.util.List;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;

public interface ObjectAttributeRemoveElementMicroTransactionable extends MicroTransactionable {

    public boolean attributeChanged( );

    public List getElementsRemoved( );
}
