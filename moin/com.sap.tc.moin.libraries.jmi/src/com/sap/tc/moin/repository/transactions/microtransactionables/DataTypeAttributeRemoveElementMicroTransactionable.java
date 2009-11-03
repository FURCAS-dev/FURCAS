package com.sap.tc.moin.repository.transactions.microtransactionables;

import java.util.List;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;

public interface DataTypeAttributeRemoveElementMicroTransactionable extends MicroTransactionable {

    public boolean attributeChanged( );

    public List getElementsWithIndexRemoved( );
}
