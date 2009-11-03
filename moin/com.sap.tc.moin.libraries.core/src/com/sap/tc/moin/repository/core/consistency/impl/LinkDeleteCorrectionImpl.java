package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.LriReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.microtransactionables.ConsistencyLinkDeleteMicroTransactionable;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

public class LinkDeleteCorrectionImpl implements ConsistencyCorrectionHandle {

    public static final String OPERATION_ID = "RemoveLink"; //$NON-NLS-1$

    private EndStorageLink link;

    private Object[] messageParams;

    public LinkDeleteCorrectionImpl( EndStorageLink link, String fromName, String toName ) {

        this.link = link;
        this.messageParams = new Object[] { fromName, toName };
    }

    public String getDescription( ) {

        return this.getDescription( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );
    }

    public String getDescription( Locale locale ) {

        String localizedMessage = RepositoryCoreMessages.DANGLING_LINK_LINK_DELETE_CORRECTION.getLocalizedMessage( locale );
        return new MessageFormat( localizedMessage, locale ).format( this.messageParams );
    }

    public static void apply( CoreConnection connection, String id ) {

        SynchronizationManager syncManager = connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( );

        // do the correction
        synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {
            if ( !connection.isAlive( ) ) {
                throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISINVALID, connection.getId( ), connection.getLabel( ) );
            }

            // constructor needs to write
            syncManager.acquireMicroWriteLock( );
            try {
                EndStorageLink link = getLink( connection, id );
                // trigger microtransaction here
                TransactionManager txManager = connection.getSession( ).getTransactionManager( );
                ConsistencyLinkDeleteMicroTransactionable idmtx = connection.getSession( ).getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( ).createConsistencyCorrectionLinkDeleteMicroTransactionable( connection, link );

                txManager.runInMicroTransaction( idmtx );
            } finally {
                syncManager.releaseMicroWriteLock( );
            }
        }
    }

    private static EndStorageLink getLink( CoreConnection connection, String id ) {

        String[] idParts = id.split( "\\|", 5 ); //$NON-NLS-1$
        if ( idParts.length < 5 ) {
            throw new MoinIllegalArgumentException( CoreConsistencyMessages.ILLEGALCORRECTIONID, id );
        }

        MRI storageEndMri = connection.getSession( ).getMoin( ).createMri( idParts[1] );
        LRI otherEndLri = connection.getSession( ).getMoin( ).createLri( idParts[2] );
        MRI typeMri = connection.getSession( ).getMoin( ).createMri( idParts[3] );

        Object type = connection.getElement( typeMri );
        byte storageEndNumber = Byte.parseByte( idParts[4] );

        CorePartitionable storageEnd = (CorePartitionable) connection.getElement( storageEndMri );

        MriReference storageEndRef = connection.getSession( ).getWorkspaceSet( ).getReferenceManager( ).getMriReference( storageEnd, storageEnd.get___Workspace( ) );

        LriReference otherEndRef = connection.getSession( ).getWorkspaceSet( ).getReferenceManager( ).getLriReference( otherEndLri );

        EndStorageLink link;
        if ( type instanceof Association ) {
            link = connection.getSession( ).getWorkspaceSet( ).getLinkFactory( ).createEndStorageLink( connection.getSession( ), storageEndNumber, (Association) type, storageEndRef, otherEndRef );
        } else {
            link = connection.getSession( ).getWorkspaceSet( ).getLinkFactory( ).createEndStorageLink( connection.getSession( ), storageEndNumber, (Attribute) type, storageEndRef, otherEndRef );
        }

        return link;
    }

    public String getId( ) {

        return OPERATION_ID + ConsistencyViolationRegistry.OPERATION_SEPARATOR + this.link.getStorageEnd( ).getMri( ) + ConsistencyViolationRegistry.OPERATION_SEPARATOR + link.getOtherEnd( ).getLri( ) + ConsistencyViolationRegistry.OPERATION_SEPARATOR
               + ( (Partitionable) this.link.getMetaObject( ) ).get___Mri( ) + ConsistencyViolationRegistry.OPERATION_SEPARATOR + this.link.getEndNumberOfStorageEnd( );
    }

    public static Collection<PRI> getAffectedPartitions( CoreConnection connection, String correctionId ) {

        EndStorageLink affectedLink = getLink( connection, correctionId );
        Collection<PRI> result = new ArrayList<PRI>( 1 );
        result.add( affectedLink.getStorageEndMri( ).getPri( ) );
        return result;
    }
}
