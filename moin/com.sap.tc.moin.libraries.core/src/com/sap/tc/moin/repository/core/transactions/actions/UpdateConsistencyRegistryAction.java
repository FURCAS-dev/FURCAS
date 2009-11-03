package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;


public class UpdateConsistencyRegistryAction extends AbstractAction {

    private MRI usedMri = null;

    private MRI mriUsedBefore = null;

    protected UpdateConsistencyRegistryAction( CoreConnection connection, MRI mriToBeUsed ) {

        super( connection );
        usedMri = mriToBeUsed;
    }

    @Override
    public void execute( ) throws UnrecoverableExecutionException, RecoverableExecutionException {

        this.mriUsedBefore = this.connection.getConsistencyViolationRegistry( ).setNewUsedDuplicateElement( this.usedMri );

    }

    @Override
    public void revert( ) throws UnrecoverableExecutionException {

        if ( this.mriUsedBefore != null ) {
            this.connection.getConsistencyViolationRegistry( ).setNewUsedDuplicateElement( this.mriUsedBefore );
        }

    }

}
