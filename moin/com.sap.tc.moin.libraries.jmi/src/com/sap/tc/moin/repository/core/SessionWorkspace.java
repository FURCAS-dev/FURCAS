package com.sap.tc.moin.repository.core;


public interface SessionWorkspace extends Workspace {

    public QueryLinkManager getQueryLinkManager( );

    public CoreSession getSession( );

    public boolean hasPrivateCopies( );

    public void setHasPrivateCopies( boolean hasPrivateCopies );
}
