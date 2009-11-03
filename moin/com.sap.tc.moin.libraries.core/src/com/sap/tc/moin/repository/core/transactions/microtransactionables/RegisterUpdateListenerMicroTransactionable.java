package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.core.events.framework.simple.UpdateNotifier;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

public class RegisterUpdateListenerMicroTransactionable extends RegisterListenerMicroTransactionable {

    public RegisterUpdateListenerMicroTransactionable( CoreConnection connection, UpdateListener listener, EventFilter eventFilter ) {

        super( connection, listener, eventFilter );
    }

    @Override
    protected List<NotifierSimple> getNotifiers( ) {

        return getCoreEventRegistry( ).getUpdateNotifiers( );
    }

    @Override
    protected NotifierSimple createNotifier( ) {

        return new UpdateNotifier( getCoreEventRegistry( ).getListenerHelper( ), listener, eventFilter );
    }

}
