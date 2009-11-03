package com.sap.tc.moin.repository.core.links;

import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;

public final class SessionMemoryLinkManagerImpl extends MemoryLinkManagerImpl {

    public SessionMemoryLinkManagerImpl( SessionWorkspace workspace ) {

        super( workspace );
    }

    @Override
    public SessionWorkspace getWorkspace( ) {

        return (SessionWorkspace) super.getWorkspace( );
    }

    @Override
    public void evictLinksStoredInPartition( CoreModelPartition partition ) {

        for ( EndStorageLink evictedLink : partition.evictLinks( ) ) {
            informConsistencyRegistryAboutRemoval( evictedLink );
            updateQueryLinkManager( evictedLink, null );
        }
    }

    private void updateQueryLinkManager( EndStorageLink evictedLink, IteratorKnowingCollection<EndStorageLink> iterator ) {

        this.getWorkspace( ).getQueryLinkManager( ).updateCaches( evictedLink.getOtherEnd( ).getLri( ), getEndAndMetaObjectForLink( evictedLink ), iterator );
    }

    private void informConsistencyRegistryAboutRemoval( EndStorageLink link ) {

        this.getWorkspace( ).getSession( ).getConsistencyViolationRegistry( ).linkDeleted( link );
    }
}