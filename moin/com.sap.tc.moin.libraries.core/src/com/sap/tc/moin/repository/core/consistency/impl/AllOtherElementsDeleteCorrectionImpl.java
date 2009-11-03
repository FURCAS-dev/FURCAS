package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

public class AllOtherElementsDeleteCorrectionImpl extends AbstractElementDeleteCorrectionImpl implements ConsistencyCorrectionHandle {

    public static final String OPERATION_ID = "RemoveOtherElements"; //$NON-NLS-1$

    public AllOtherElementsDeleteCorrectionImpl( MRI mri ) {

        this.mri = mri;
    }

    public static void apply( CoreConnection connection, String id ) {

        MRI mri = getMri( connection, id );

        SynchronizationManager syncManager = connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( );

        synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {

            if ( !connection.isAlive( ) ) {
                throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISINVALID, connection.getId( ), connection.getLabel( ) );
            }

            // constructor needs to write
            syncManager.acquireMicroWriteLock( );
            try {
                List<DuplicateElementConsistencyViolation> duplicateElementViolations = connection.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( connection, mri.getLri( ), true );

                if ( duplicateElementViolations != null ) {
                    for ( DuplicateElementConsistencyViolation violation : duplicateElementViolations ) {
                        if ( !violation.getMri( ).equals( mri ) ) {
                            RefObject element = (RefObject) connection.getElement( violation.getMri( ) );
                            deleteSingleElement( connection, element );
                        }
                    }
                }

            } finally {
                syncManager.releaseMicroWriteLock( );
            }
        }
    }

    public String getDescription( ) {

        return this.getDescription( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );
    }

    public String getDescription( Locale locale ) {

        String localizedMessage = RepositoryCoreMessages.DUPLICATE_ELEMENT_DELETE_OTHERS_CORRECTION.getLocalizedMessage( locale );
        return new MessageFormat( localizedMessage, locale ).format( new Object[] { this.mri.getMofId( ), this.mri.getPri( ) } );
    }

    public String getId( ) {

        return super.getId( OPERATION_ID );
    }

    public static Collection<PRI> getAffectedPartitions( CoreConnection connection, String correctionId ) {

        MRI mri = getMri( connection, correctionId );

        List<DuplicateElementConsistencyViolation> duplicateElementViolations = connection.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( connection, mri.getLri( ), true );

        if ( ( duplicateElementViolations != null ) && ( duplicateElementViolations.size( ) > 1 ) ) {

            Collection<PRI> result = new ArrayList<PRI>( duplicateElementViolations.size( ) - 1 );
            for ( DuplicateElementConsistencyViolation violation : duplicateElementViolations ) {
                if ( !violation.getMri( ).equals( mri ) ) {
                    result.add( violation.getMri( ).getPri( ) );
                }
            }
            return result;
        }

        return Collections.emptyList( );
    }
}
