package com.sap.tc.moin.repository.core.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.links.QueryLinkManagerImpl;
import com.sap.tc.moin.repository.core.links.SessionMemoryLinkManagerImpl;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;

public class SessionWorkspaceImpl extends WorkspaceImpl implements SessionWorkspace {

    private CoreSession session = null;

    private Map<DataAreaDescriptor, SpiStage> stages;

    private QueryLinkManager queryLinkManager = null;

    private boolean hasPrivateCopies = false;

    public SessionWorkspaceImpl( WorkspaceSet workspaceSet, Collection<SpiStage> allStages ) {

        super( workspaceSet );
        this.queryLinkManager = new QueryLinkManagerImpl( this );
        this.memoryLinkManager = new SessionMemoryLinkManagerImpl( this );
        this.stages = new HashMap<DataAreaDescriptor, SpiStage>( );
        for ( SpiStage stage : allStages ) {
            this.stages.put( stage.getDataAreaDescriptor( ), stage );
        }
    }

    void setSession( CoreSession session ) {

        if ( this.session == null ) {
            this.session = session;
        } else {
            throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.SESSIONCANONLYBESETONCE );
        }
    }

    @Override
    public void partitionChanged( PRI pri, SpiPartitionDelta delta ) {

        super.partitionChanged( pri, delta ); // makes sure that the pri is not null
        if ( delta != null ) {
            for ( SpiLink link : delta.getAddedLinks( ) ) {
                // We have to check whether a link has been added in a not yet used partition (distributed end storage).
                int end = link.getEndNumberOfStorageEnd( );
                EndStorageLink endStorageLink = (EndStorageLink) link;
                RefObject metaObject = endStorageLink.getMetaObject( );
                EndAndMetaObject endAndMetaObject = this.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( end, metaObject );
                this.queryLinkManager.updateCaches( endStorageLink.getOtherEnd( ).getLri( ), endAndMetaObject, null );
            }
        }
    }

    @Override
    public QueryLinkManager getQueryLinkManager( ) {

        return this.queryLinkManager;
    }

    @Override
    public void destroy( ) {

        super.destroy( );
        this.session = null;
        this.queryLinkManager = null;
    }

    @Override
    public CoreSession getSession( ) {

        return this.session;
    }

    @Override
    protected void toStringInternal( StringBuilder sb ) {

        super.toStringInternal( sb );
        sb.append( ", session = " + this.session ); //$NON-NLS-1$
    }


    public boolean isShared( ) {

        return false;
    }

    public SpiStage getStage( DataAreaDescriptor dataAreaDescriptor ) {

        return this.stages.get( dataAreaDescriptor );
    }

    public void setHasPrivateCopies( boolean hasPrivateCopies ) {

        this.hasPrivateCopies = hasPrivateCopies;
    }

    public boolean hasPrivateCopies( ) {

        return hasPrivateCopies;
    }
}