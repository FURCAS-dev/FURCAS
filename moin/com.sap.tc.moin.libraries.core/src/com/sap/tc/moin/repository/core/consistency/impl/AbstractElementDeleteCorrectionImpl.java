package com.sap.tc.moin.repository.core.consistency.impl;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.microtransactionables.SingleInstanceDeleteMicroTransactionable;

public class AbstractElementDeleteCorrectionImpl {

    protected MRI mri;

    protected static void deleteSingleElement( CoreConnection connection, RefObject element ) {

        // trigger microtransaction here
        TransactionManager txManager = connection.getSession( ).getTransactionManager( );
        SingleInstanceDeleteMicroTransactionable idmtx = connection.getSession( ).getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( ).createConsistencyCorrectionElementDeleteMicroTransactionable( connection, element );

        txManager.runInMicroTransaction( idmtx );
    }

    protected static MRI getMri( CoreConnection connection, String id ) {

        String[] idParts = id.split( "\\|", 2 ); //$NON-NLS-1$
        if ( idParts.length < 2 ) {
            throw new MoinIllegalArgumentException( CoreConsistencyMessages.ILLEGALCORRECTIONID, id );
        }
        return connection.getSession( ).getMoin( ).createMri( idParts[1] );
    }

    public AbstractElementDeleteCorrectionImpl( ) {

        super( );
    }

    public String getId( String operationId ) {

        return operationId + ConsistencyViolationRegistry.OPERATION_SEPARATOR + this.mri;
    }

}
