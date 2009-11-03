package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.microtransactionables.ConsistencyLinkDeleteMicroTransactionable;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

public class AllDanglingLinksOfPartitionDeleteCorrectionImpl implements ConsistencyCorrectionHandle {

    public static final String OPERATION_ID = "RemoveDanglingLinksOfPartition"; //$NON-NLS-1$

    private PRI pri;

    public AllDanglingLinksOfPartitionDeleteCorrectionImpl( PRI partition ) {

        this.pri = partition;
    }

    public String getDescription( ) {

        return this.getDescription( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );
    }

    public String getDescription( Locale locale ) {

        String localizedMessage = RepositoryCoreMessages.ALL_DANGLING_LINK_DELETE_CORRECTION.getLocalizedMessage( locale );
        return new MessageFormat( localizedMessage, locale ).format( new Object[] {} );
    }

    public static void apply( CoreConnection connection, String id ) {

        PRI partition = getPri( connection, id );


        SynchronizationManager syncManager = connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( );

        // do the correction
        synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {
            if ( !connection.isAlive( ) ) {
                throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISINVALID, connection.getId( ), connection.getLabel( ) );
            }

            // constructor needs to write
            syncManager.acquireMicroWriteLock( );
            try {


                CoreModelPartition modelPartition = connection.getPartition( partition );
                if ( modelPartition == null ) {
                    throw new MoinIllegalStateException( CoreConsistencyMessages.CORRECTIONINVALIDPARTITIONCOULDNOTBEDFOUND, id, partition );
                }
                connection.getConsistencyViolationRegistry( ).performConsistencyCheck( partition, connection );


                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = connection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( partition );

                // trigger microtransaction here
                TransactionManager txManager = connection.getSession( ).getTransactionManager( );

                for ( DanglingLinkConsistencyViolation violation : danglingLinksOfPartition ) {
                    ConsistencyLinkDeleteMicroTransactionable idmtx = connection.getSession( ).getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( ).createConsistencyCorrectionLinkDeleteMicroTransactionable( connection,
                                                                                                                                                                                                                          ( (DanglingLinkConsistencyViolationImpl) violation ).getAffectedLink( ) );

                    txManager.runInMicroTransaction( idmtx );
                }

            } finally {
                syncManager.releaseMicroWriteLock( );
            }
        }
    }

    protected static PRI getPri( CoreConnection connection, String id ) {

        String[] idParts = id.split( "\\|", 2 ); //$NON-NLS-1$
        if ( idParts.length < 2 ) {
            throw new MoinIllegalArgumentException( CoreConsistencyMessages.ILLEGALCORRECTIONID, id );
        }
        return connection.getSession( ).getMoin( ).createPri( idParts[1] );
    }

    public String getId( ) {

        return OPERATION_ID + ConsistencyViolationRegistry.OPERATION_SEPARATOR + this.pri;
    }

    public static Collection<PRI> getAffectedPartitions( CoreConnection connection, String correctionId ) {

        PRI pri = getPri( connection, correctionId );

        Collection<PRI> result = new ArrayList<PRI>( 0 );
        result.add( pri );
        return result;
    }
}
