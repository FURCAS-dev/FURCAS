package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.core.events.framework.simple.PostEventNotifier;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

public class RegisterChangeListenerMicroTransactionable extends RegisterListenerMicroTransactionable {

    public RegisterChangeListenerMicroTransactionable( CoreConnection connection, ChangeListener listener, EventFilter eventFilter ) {

        super( connection, listener, eventFilter );
    }

    @Override
    protected List<NotifierSimple> getNotifiers( ) {

        return getCoreEventRegistry( ).getChangeNotifiers( );
    }

    @Override
    protected NotifierSimple createNotifier( ) {

        return new PostEventNotifier( getCoreEventRegistry( ).getListenerHelper( ), listener, eventFilter );
    }
}
