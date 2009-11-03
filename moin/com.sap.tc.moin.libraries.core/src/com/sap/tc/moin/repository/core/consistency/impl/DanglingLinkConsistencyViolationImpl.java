package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;

public class DanglingLinkConsistencyViolationImpl extends LinkConsistencyViolationImpl implements DanglingLinkConsistencyViolation, LinkConsistencyViolation {

    public DanglingLinkConsistencyViolationImpl( ConsistencyViolationRegistryImpl eventRegistry, EndStorageLink link, LRI missingEnd ) {

        super( eventRegistry, link );

        this.missingEnd = missingEnd;
    }

    public LRI getMissingElement( ) {

        return this.missingEnd;
    }

    public LRI getExistingEnd( ) {

        if ( this.affectedLink.getEnd( 0 ).getLri( ).equals( this.missingEnd ) ) {
            return this.affectedLink.getEnd( 1 ).getLri( );
        } else {
            return this.affectedLink.getEnd( 0 ).getLri( );
        }
    }

    /**
     * Listener for link deletion. If the defective link is deleted, the
     * inconsistency is solved.
     * 
     * @param link
     * @param connection
     */
    public void deleteLink( EndStorageLink link ) {

        if ( this.affectedLink.equals( link ) ) {
            this.registry.notifyResolvedConsistencyViolation( this );
        }
    }

    /**
     * Listener for element creation. If the missing target element is created,
     * the inconsistency is resolved.
     * 
     * @param lri
     * @param connection
     */
    public void elementCreated( LRI lri ) {

        if ( lri.equals( this.missingEnd ) ) {
            this.registry.notifyResolvedConsistencyViolation( this );
        }
    }

    /**
     * Returns "End {4} of link of type {2} is missing. Source\: {0} ({3})
     * Target\: {1} Link type\: {5}."
     */
    @Override
    public String getDescription( CoreConnection connection, Locale locale ) {

        String associationName = null;
        Object linkType = this.affectedLink.getMetaObject( );
        MRI mriOfType = ( (Partitionable) linkType ).get___Mri( );
        if ( linkType instanceof AssociationInternal ) {
            associationName = ( (AssociationInternal) linkType ).getQualifiedName( connection ).toString( );
        } else if ( linkType instanceof AttributeInternal ) {
            associationName = ( (AttributeInternal) linkType ).getQualifiedName( connection ).toString( );
        }

        // try to get a human readable name of the element
        String elementName = this.getElementName( this.affectedLink.getStorageEnd( ).getMri( ), connection );
        elementName = ( elementName != null ) ? this.shortenString( elementName ) : ""; //$NON-NLS-1$

        int missingEndNumber = this.affectedLink.getEndNumberOfOtherEnd( );

        String rawMessage = RepositoryCoreMessages.DANGLING_LINK_CONSISTENCY_VIOLATION.getLocalizedMessage( locale );
        return MessageFormat.format( rawMessage, Integer.valueOf( missingEndNumber ), elementName, this.affectedLink.getStorageEnd( ).getMri( ).getMofId( ), this.missingEnd.getMofId( ), associationName, mriOfType );
    }

    @Override
    public boolean validate( CoreConnection connection ) {

        boolean result = ( connection.getElement( this.missingEnd ) == null );
        if ( result ) {
            // check if link has been deleted
            MRI storageEnd = this.affectedLink.getStorageEnd( ).getMri( );
            CoreModelPartition partition = connection.getPartition( storageEnd.getPri( ) );
            result = partition.getLinks( ).contains( this.affectedLink );
        }
        if ( !result ) {
            this.registry.notifyResolvedConsistencyViolation( this );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return super.hashCode( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof DanglingLinkConsistencyViolationImpl ) {
            return super.equals( obj );
        }
        return false;
    }

    @Override
    public String toString( ) {

        return "Dangling link: " + this.affectedLink.toString( ) + "\nId: " + this.getId( ); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
