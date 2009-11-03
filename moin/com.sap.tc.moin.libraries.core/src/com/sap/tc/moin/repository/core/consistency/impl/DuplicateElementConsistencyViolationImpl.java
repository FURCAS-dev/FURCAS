package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.Utilities.CalculatedMofIdAppl;

public class DuplicateElementConsistencyViolationImpl extends ConsistencyViolationImpl implements DuplicateElementConsistencyViolation {

    private MRI mri;

    public DuplicateElementConsistencyViolationImpl( ConsistencyViolationRegistryImpl eventRegistry, MRI mri ) {

        super( eventRegistry );
        this.mri = mri;
    }

    @Override
    protected String calculateId( ) {

        return Utilities.getUtilities( ).calculateMofId( CalculatedMofIdAppl.MOIN_INTERNAL, this.getClass( ).getName( ), new String[] { this.mri.toString( ) } );
    }



    public MRI getMri( ) {

        return this.mri;
    }

    public MRI getUsedElementsMri( ) {

        return this.registry.getUsedDuplicateElement( this.mri.getLri( ) );
    }

    public MRI getAffectedElement( ) {

        return this.getMri( );
    }


    @Override
    public ConsistencyCorrectionHandle[] getCorrectionHandles( CoreConnection connection ) {

        return new ConsistencyCorrectionHandle[] { new ElementDeleteCorrectionImpl( this.mri ), new AllOtherElementsDeleteCorrectionImpl( this.mri ) };
    }

    @Override
    public String getDescription( CoreConnection connection, Locale locale ) {

        String elementName = this.getElementName( this.mri, connection );

        String rawMessage = RepositoryCoreMessages.DUPLICATE_ELEMENT_CONSISTENCY_VIOLATION.getLocalizedMessage( locale );
        return MessageFormat.format( rawMessage, ( elementName != null ) ? elementName : "", this.mri ); //$NON-NLS-1$
    }

    @Override
    public boolean validate( CoreConnection connection ) {

        // does the duplicate element still exist ?
        if ( connection.getElement( this.mri ) == null ) {
            this.registry.notifyResolvedConsistencyViolation( this );
            return false;
        }

        return true;
    }

    public void elementDeleted( MRI mri ) {

        this.registry.notifyResolvedConsistencyViolation( this );
    }

    /**
     * Do not evaluate text and id for equal
     */
    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof DuplicateElementConsistencyViolationImpl ) {
            DuplicateElementConsistencyViolationImpl otherEvent = (DuplicateElementConsistencyViolationImpl) obj;
            return this.mri.equals( otherEvent.getMri( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        int hashCode = super.hashCode( );
        return 31 * hashCode + this.mri.hashCode( );
    }

    @Override
    public String toString( ) {

        return "Duplicate element: " + this.mri.toString( ) + "\nUsed Element: " + this.getUsedElementsMri( ) + "\nId: " + this.getId( ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

}
