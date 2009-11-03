package com.sap.tc.moin.repository.core.consistency.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.DuplicateParentConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.shared.util.Utilities.CalculatedMofIdAppl;

public class DuplicateParentConsistencyViolationImpl extends ConsistencyViolationImpl implements DuplicateParentConsistencyViolation {

    private EndStorageLink usedLink;

    private EndStorageLink link;

    public DuplicateParentConsistencyViolationImpl( ConsistencyViolationRegistryImpl eventRegistry, EndStorageLink duplicateLink, EndStorageLink usedLink ) {

        super( eventRegistry );
        this.usedLink = usedLink;
        this.link = duplicateLink;
    }

    @Override
    protected String calculateId( ) {

        return Utilities.getUtilities( ).calculateMofId( CalculatedMofIdAppl.MOIN_INTERNAL, this.getClass( ).getName( ), new String[] { this.link.toString( ) } );
    }

    public EndStorageLink getLink( ) {

        return this.link;
    }

    public EndStorageLink getUsedLink( ) {

        return this.usedLink;
    }

    public MRI getAffectedElement( ) {

        return this.link.getStorageEnd( ).getMri( );
    }

    @Override
    public ConsistencyCorrectionHandle[] getCorrectionHandles( CoreConnection connection ) {

        String fromName = this.getElementName( link.getStorageEnd( ).getMri( ), connection );
        fromName = ( fromName != null ) ? this.shortenString( fromName ) : link.getStorageEnd( ).getMri( ).toString( );

        String toName = this.getElementName( link.getOtherEnd( ).getLri( ), connection );
        toName = ( toName != null ) ? this.shortenString( toName ) : link.getOtherEnd( ).getLri( ).getMofId( );

        return new ConsistencyCorrectionHandle[] { new LinkDeleteCorrectionImpl( this.link, fromName, toName ) };
    }

    @Override
    public String getDescription( CoreConnection connection, Locale locale ) {

        String elementName = this.getElementName( this.getChildLri( ), connection );
        elementName = this.shortenString( ( elementName != null ) ? elementName : this.getChildLri( ).getMofId( ) );
        String parentName = this.getElementName( this.getParent( ), connection );
        parentName = this.shortenString( ( parentName != null ) ? parentName : this.getParent( ).getMofId( ) );

        String rawMessage = RepositoryCoreMessages.DUPLICATE_PARENT_CONSISTENCY_VIOLATION.getLocalizedMessage( locale );
        return MessageFormat.format( rawMessage, elementName, parentName );
    }

    @Override
    public boolean validate( CoreConnection connection ) {

        LRI childLri = this.getChildLri( );

        CorePartitionable componentElement = (CorePartitionable) connection.getElement( childLri );

        List<EndStorageLink> compositeParentLinks = connection.getSession( ).getWorkspaceSet( ).getLogicalLinkManager( ).getCompositeParentLinks( connection.getSession( ), componentElement );

        return ( compositeParentLinks.size( ) > 1 ) && ( compositeParentLinks.contains( this.link ) );
    }

    public void deleteLink( EndStorageLink linkToDelete ) {

        if ( this.link.equals( linkToDelete ) ) {
            this.registry.notifyResolvedConsistencyViolation( this );
        }
    }

    /**
     * Do not evaluate text and id for equal
     */
    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof DuplicateParentConsistencyViolationImpl ) {
            DuplicateParentConsistencyViolationImpl otherEvent = (DuplicateParentConsistencyViolationImpl) obj;
            return this.link.equals( otherEvent.getLink( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        int hashCode = super.hashCode( );
        return 31 * hashCode + this.link.hashCode( );
    }

    @Override
    public String toString( ) {

        return "Duplicate parent link: " + this.link.toString( ) + "\nUsed Parent: " + this.getUsedParent( ) + "\nId: " + this.getId( ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    public LRI getChildLri( ) {

        return this.link.getEnd( this.link.getComponentEnd( ) ).getLri( );
    }

    public LRI getParent( ) {

        return this.link.getEnd( this.link.getCompositeEnd( ) ).getLri( );
    }

    public LRI getUsedParent( ) {

        return this.usedLink.getEnd( this.link.getCompositeEnd( ) ).getLri( );
    }

    public void setUsedLink( EndStorageLink usedLink ) {

        this.usedLink = usedLink;
    }

}
