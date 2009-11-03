package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.PriReference;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.WorkspaceSet;

public final class PriReferenceImpl implements PriReference {

    /**
     * The {@link PRI} of the referenced model partition. This field is
     * <code>null</code> if the reference is resolved and <code>!= null</code>
     * otherwise.
     */
    private final PRI pri;

    /**
     * The Java references to the model partition representing the resolved
     * reference target. If <code>null</code>, this reference hasn't been
     * resolved yet.
     */
    private CoreModelPartition resolved;

    /**
     * The enclosing {@link WorkspaceSet}.
     */
    private final WorkspaceSet workspaceSet;

    PriReferenceImpl( CoreModelPartition partition, WorkspaceSet workspaceSet ) {

        this( partition.getPri( ), workspaceSet );
        this.resolved = partition;

    }


    public PriReferenceImpl( PRI pri, WorkspaceSet workspaceSet ) {

        this.pri = pri;
        this.workspaceSet = workspaceSet;
    }

    public WorkspaceSet getWorkspaceSet( ) {

        return workspaceSet;
    }

    public PRI getPri( ) {

        return pri;
    }

    @Override
    public int hashCode( ) {

        return this.pri.hashCode( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof PriReferenceImpl ) {
            return this.pri.equals( ( (PriReferenceImpl) obj ).pri );
        }
        return false;
    }

    @Override
    public String toString( ) {

        return pri.toString( );
    }

    public boolean isCached( ) {

        return resolved != null;
    }

    public void uncache( ) {

        resolved = null;
    }

    public CoreModelPartition get( CoreConnection connection ) {

        CoreModelPartition result = this.getWithoutException( connection );
        if ( result == null ) {
            throw new UnresolvableException( JmiCoreMessages.PRINOTRESOLVED, pri );
        }
        return result;
    }

    public CoreModelPartition getIfResolved( ) {

        return resolved;
    }

    public CoreModelPartition getWithoutException( CoreConnection connection ) {

        CoreModelPartition result = ( resolved != null ? resolved : resolve( connection.getSession( ) ) );
        if ( result != null ) {
            result.updateEvictionTimestamp( );
        }
        return result;
    }

    private CoreModelPartition resolve( CoreSession session ) {

        resolved = workspaceSet.resolvePri( session, pri );
        return resolved;
    }
}
