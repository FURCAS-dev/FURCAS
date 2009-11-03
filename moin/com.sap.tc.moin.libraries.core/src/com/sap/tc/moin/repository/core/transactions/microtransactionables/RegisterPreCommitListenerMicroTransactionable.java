package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.NotifierSimple;
import com.sap.tc.moin.repository.core.events.framework.simple.PreCommitNotifier;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

public class RegisterPreCommitListenerMicroTransactionable extends RegisterListenerMicroTransactionable {

    public RegisterPreCommitListenerMicroTransactionable( CoreConnection connection, PreCommitListener listener, EventFilter eventFilter ) {

        super( connection, listener, eventFilter );
    }

    @Override
    protected List<NotifierSimple> getNotifiers( ) {

        return getCoreEventRegistry( ).getPreCommitNotifiers( );
    }

    @Override
    protected NotifierSimple createNotifier( ) {

        return new PreCommitNotifier( getCoreEventRegistry( ).getListenerHelper( ), listener, eventFilter );
    }

}
