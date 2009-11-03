package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.core.events.framework.simple.PreEventNotifier;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

public class RegisterPreChangeListenerMicroTransactionable extends RegisterListenerMicroTransactionable {

    public RegisterPreChangeListenerMicroTransactionable( CoreConnection connection, PreChangeListener listener, EventFilter eventFilter ) {

        super( connection, listener, eventFilter );
    }

    @Override
    protected List<NotifierSimple> getNotifiers( ) {

        return getCoreEventRegistry( ).getPreChangeNotifiers( );
    }

    @Override
    protected NotifierSimple createNotifier( ) {

        return new PreEventNotifier( getCoreEventRegistry( ).getListenerHelper( ), listener, eventFilter );
    }

}
