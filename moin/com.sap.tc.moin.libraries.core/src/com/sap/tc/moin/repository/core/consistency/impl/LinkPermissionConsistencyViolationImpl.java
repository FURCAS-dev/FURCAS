package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.LinkPermissionConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;

public class LinkPermissionConsistencyViolationImpl extends LinkConsistencyViolationImpl implements LinkPermissionConsistencyViolation, LinkConsistencyViolation {

    private MRI deniedEndMri;

    public LinkPermissionConsistencyViolationImpl( ConsistencyViolationRegistryImpl eventRegistry, EndStorageLink link, MRI deniedEnd ) {

        super( eventRegistry, link );
        this.missingEnd = deniedEnd.getLri( );
        this.deniedEndMri = deniedEnd;
    }

    @Override
    public String getDescription( CoreConnection connection, Locale locale ) {

        String elementName = this.getElementName( this.affectedLink.getStorageEnd( ).getMri( ), connection );
        elementName = ( elementName != null ) ? this.shortenString( elementName ) : ""; //$NON-NLS-1$        

        String rawMessage = RepositoryCoreMessages.LINK_PERMISSION_CONSISTENCY_VIOLATION.getLocalizedMessage( locale );
        return MessageFormat.format( rawMessage, this.getAllowedEnd( ).getPri( ), this.deniedEndMri.getPri( ) );
    }

    @Override
    public ConsistencyCorrectionHandle[] getCorrectionHandles( CoreConnection connection ) {

        return new ConsistencyCorrectionHandle[] {};
    }

    @Override
    public boolean validate( CoreConnection connection ) {

        boolean valid = !this.registry.checkDcDependency( connection, this.getAffectedElement( ).getPri( ), this.getDeniedEnd( ) );

        if ( !valid ) {
            this.registry.notifyResolvedConsistencyViolation( this );
        }

        return valid;
    }

    public MRI getAllowedEnd( ) {

        return this.affectedLink.getStorageEnd( ).getMri( );
//        if ( this.affectedLink.getEnd( 0 ).getLri( ).equals( this.missingEnd ) ) {
//            return this.affectedLink.getEnd( 1 ).getMri( );
//        } else {
//            return this.affectedLink.getEnd( 0 ).getMri( );
//        }
    }

    public MRI getDeniedEnd( ) {

        return this.deniedEndMri;
    }

    @Override
    public int hashCode( ) {

        return super.hashCode( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof LinkPermissionConsistencyViolationImpl ) {
            return super.equals( obj );
        }
        return false;
    }

    @Override
    public String toString( ) {

        return "Forbidden link: " + this.affectedLink.toString( ) + "\nId: " + this.getId( ); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
