package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

public class ElementDeleteCorrectionImpl extends AbstractElementDeleteCorrectionImpl implements ConsistencyCorrectionHandle {

    public static final String OPERATION_ID = "RemoveElement"; //$NON-NLS-1$

    public ElementDeleteCorrectionImpl( MRI mri ) {

        this.mri = mri;
    }

    public static void apply( CoreConnection connection, String id ) {

        MRI mri = getMri( connection, id );

        SynchronizationManager syncManager = connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( );

        synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {
            if ( !connection.isAlive( ) ) {
                throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISINVALID, connection.getId( ), connection.getLabel( ) );
            }

            syncManager.acquireMicroWriteLock( );
            try {
                RefObject element = (RefObject) connection.getElement( mri );

                if ( element != null ) {
                    deleteSingleElement( connection, element );
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

        String localizedMessage = RepositoryCoreMessages.DUPLICATE_ELEMENT_ELEMENT_DELETE_CORRECTION.getLocalizedMessage( locale );
        return new MessageFormat( localizedMessage, locale ).format( new Object[] { this.mri.getMofId( ), this.mri.getPri( ) } );
    }

    public String getId( ) {

        return super.getId( OPERATION_ID );
    }

    @Override
    public String toString( ) {

        return "Element to delete: " + mri.toString( ); //$NON-NLS-1$
    }

    public static Collection<PRI> getAffectedPartitions( CoreConnection connection, String correctionId ) {

        MRI mri = getMri( connection, correctionId );

        Collection<PRI> result = new ArrayList<PRI>( 1 );
        result.add( mri.getPri( ) );

        return result;
    }
}
