package com.sap.tc.moin.repository.core.consistency.impl;


/**
 * Abstract link consistency violation. Offers the basic functionality for link
 * consistency problems.
 */
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.Utilities.CalculatedMofIdAppl;

public abstract class LinkConsistencyViolationImpl extends ConsistencyViolationImpl {

    protected EndStorageLink affectedLink;

    protected LRI missingEnd;

    public LinkConsistencyViolationImpl( ConsistencyViolationRegistryImpl eventRegistry, EndStorageLink affectedLink ) {

        super( eventRegistry );
        this.affectedLink = affectedLink;
    }

    @Override
    protected String calculateId( ) {

        return Utilities.getUtilities( ).calculateMofId( CalculatedMofIdAppl.MOIN_INTERNAL, this.getClass( ).getName( ), new String[] { this.affectedLink.toString( ) } );
    }



    public MRI getAffectedElement( ) {

        return this.affectedLink.getStorageEnd( ).getMri( );
//        if ( this.affectedLink.getEnd( 0 ).getLri( ).equals( this.missingEnd ) ) {
//            return this.affectedLink.getEnd( 1 ).getMri( );
//        } else {
//            return this.affectedLink.getEnd( 0 ).getMri( );
//        }
    }

    public EndStorageLink getAffectedLink( ) {

        return this.affectedLink;
    }

    @Override
    public ConsistencyCorrectionHandle[] getCorrectionHandles( CoreConnection connection ) {

        String fromName = this.getElementName( affectedLink.getStorageEnd( ).getMri( ), connection );
        fromName = ( fromName != null ) ? this.shortenString( fromName ) : affectedLink.getStorageEnd( ).getMri( ).toString( );

        String toName = this.affectedLink.getOtherEnd( ).getLri( ).getMofId( );

        return new ConsistencyCorrectionHandle[] { new LinkDeleteCorrectionImpl( this.affectedLink, fromName, toName ), new AllDanglingLinksOfPartitionDeleteCorrectionImpl( this.getAffectedElement( ).getPri( ) ) };
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof LinkConsistencyViolationImpl ) {
            LinkConsistencyViolationImpl otherEvent = (LinkConsistencyViolationImpl) obj;
            if ( super.equals( obj ) ) {
                return this.affectedLink.equals( otherEvent.affectedLink );
            }
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        int hashCode = super.hashCode( );
        return 31 * hashCode + this.affectedLink.hashCode( );
    }

    @Override
    public String toString( ) {

        return "Defective link: " + this.affectedLink.toString( ) + "\nId: " + this.getId( ); //$NON-NLS-1$ //$NON-NLS-2$
    }

}