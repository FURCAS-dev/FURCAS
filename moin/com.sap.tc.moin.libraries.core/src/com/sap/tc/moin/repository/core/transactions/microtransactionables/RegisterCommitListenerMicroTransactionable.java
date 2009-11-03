package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.CommitNotifier;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

public class RegisterCommitListenerMicroTransactionable extends RegisterListenerMicroTransactionable {

    public RegisterCommitListenerMicroTransactionable( CoreConnection connection, CommitListener listener, EventFilter eventFilter ) {

        super( connection, listener, eventFilter );
    }

    @Override
    protected List<NotifierSimple> getNotifiers( ) {

        return getCoreEventRegistry( ).getCommitNotifiers( );
    }

    @Override
    protected NotifierSimple createNotifier( ) {

        return new CommitNotifier( getCoreEventRegistry( ).getListenerHelper( ), listener, eventFilter );
    }

}
