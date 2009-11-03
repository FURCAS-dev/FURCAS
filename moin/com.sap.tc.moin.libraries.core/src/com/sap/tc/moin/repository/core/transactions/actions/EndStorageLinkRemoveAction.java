package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;

public class EndStorageLinkRemoveAction extends AbstractAction {

    private int index;

    private MRI featuredMri;

    private String attributeOrAssociationEndMofId;

    private EndStorageLink link;

    private IteratorKnowingCollection<EndStorageLink> iterator = null;

    public EndStorageLinkRemoveAction( CoreConnection aConnection, MRI aFeaturedMri, String anAttributeOrAssociationEndMofId, EndStorageLink aLink, int anIndex ) {

        super( aConnection );
        featuredMri = aFeaturedMri;
        attributeOrAssociationEndMofId = anAttributeOrAssociationEndMofId;
        link = aLink;
        index = anIndex;
    }

    public EndStorageLinkRemoveAction( CoreConnection aConnection, MRI aFeaturedMri, String anAttributeOrAssociationEndMofId, EndStorageLink aLink, int anIndex, IteratorKnowingCollection<EndStorageLink> anIterator ) {

        this( aConnection, aFeaturedMri, anAttributeOrAssociationEndMofId, aLink, anIndex );
        iterator = anIterator;
    }

    @Override
    public void execute( ) throws JmiException {

        assert link.getStorageEnd( ).get( connection.getSession( ) ).get___Workspace( ) instanceof SessionWorkspace : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        getPartitionChangeRecorder( ).linkRemoved( link );
        MemoryLinkManager linkManager = link.getMemoryLinkManager( connection );
        linkManager.removeLink( connection, attributeOrAssociationEndMofId, link, iterator );
        connection.getConsistencyViolationRegistry( ).linkDeleted( link );
        // the iterator can only be used once, so it needs to be nulled out here
        // note that if we would use the iterator more that once, e.g. in a second
        // do call or in a redo call of the surrounding transaction, we would get an
        // IllegalStateException from the iterator because an iterator remove would be
        // called without a previous call of the iterator method next. But calling
        // next before would clearly be an error :)
        // As a result, from a second call onwards, i.e. in a redo, the link is removed
        // via the link collection in the MemoryLinkManager.removeLink method above
        // (because iterator is null) and the iterator is not usable anymore from outside.
        // Calling any method of the iterator leads than to a ConcurrentModificationException.
        iterator = null;
    }

    @Override
    public void revert( ) throws JmiException {

        getPartitionChangeRecorder( ).undoLinkRemoved( link );
        MemoryLinkManager linkManager = link.getMemoryLinkManager( connection );
        linkManager.addLink( connection, attributeOrAssociationEndMofId, link, index );
        connection.getConsistencyViolationRegistry( ).linkAdded( connection, link );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof EndStorageLinkRemoveAction ) ) {
            return false;
        } else {
            EndStorageLinkRemoveAction action = (EndStorageLinkRemoveAction) obj;
            result = featuredMri.equals( action.featuredMri ) && attributeOrAssociationEndMofId == action.attributeOrAssociationEndMofId && link.equals( action.link ) && index == action.index; // $JL-STRING$ MOF IDs are interned
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return 41 * ( featuredMri.hashCode( ) + attributeOrAssociationEndMofId.hashCode( ) + link.hashCode( ) + index );
    }
}
