package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MemoryLinkManager;

public class EndStorageLinkAddAction extends AbstractAction {

    private MRI featuredMri = null;

    private final String attributeOrAssociationEndMofId;

    private final EndStorageLink link;

    private int index = -1;

    public EndStorageLinkAddAction( CoreConnection aConnection, MRI aFeaturedMri, String anAttributeOrAssociationEndMofId, EndStorageLink aLink, int anIndex ) {

        super( aConnection );
        featuredMri = aFeaturedMri;
        attributeOrAssociationEndMofId = anAttributeOrAssociationEndMofId;
        link = aLink;
        index = anIndex;
    }

    @Override
    public void execute( ) throws JmiException {

        assert !( link.getStorageEnd( ).get( connection.getSession( ) ).get___Workspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        getPartitionChangeRecorder( ).linkAdded( link );
        MemoryLinkManager linkManager = link.getMemoryLinkManager( connection );
        linkManager.addLink( connection, attributeOrAssociationEndMofId, link, index );
        connection.getConsistencyViolationRegistry( ).linkAdded( connection, link );
    }

    @Override
    public void revert( ) throws JmiException {

        getPartitionChangeRecorder( ).undoLinkAdded( link );
        MemoryLinkManager linkManager = link.getMemoryLinkManager( connection );
        linkManager.removeLinkOnRevert( connection, attributeOrAssociationEndMofId, link );
        connection.getConsistencyViolationRegistry( ).linkDeleted( link );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof EndStorageLinkAddAction ) ) {
            return false;
        } else {
            EndStorageLinkAddAction action = (EndStorageLinkAddAction) obj;
            result = featuredMri.equals( action.featuredMri ) && attributeOrAssociationEndMofId == action.attributeOrAssociationEndMofId && link.equals( action.link ) && index == action.index; // $JL-STRING$ MOF IDs are interned
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return 41 * ( featuredMri.hashCode( ) + attributeOrAssociationEndMofId.hashCode( ) + link.hashCode( ) + index );
    }
}