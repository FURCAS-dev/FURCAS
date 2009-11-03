package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.LriReference;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.spi.core.SpiSession;

public class LriReferenceImpl extends AbstractReferenceImpl implements LriReference {

    protected final LRI lri;

    public LriReferenceImpl( LRI lri, boolean cacheable ) {

        super( null /* partitionable */, cacheable );
        this.lri = lri;
    }

    @Override
    protected CorePartitionable resolve( CoreSession session ) {

        CorePartitionable result = this.resolveWithoutException( session );
        if ( result == null ) {
            // handle inconsistency
            throw new UnresolvableException( JmiCoreMessages.LRINOTRESOLVED, this.lri );
        }
        return result;
    }

    @Override
    protected CorePartitionable resolveWithoutException( CoreSession session ) {

        WorkspaceSet workspaceSet = determineWorkspaceSetForSession( session );
        CorePartitionable result = workspaceSet.resolveLri( session, this.lri );
        return result;
    }

    public PRI getPri( CoreSession session ) {

        MRI mri = this.getMri( session );
        if ( mri != null ) {
            return mri.getPri( );
        }
        return null;
    }

    public MRI getMri( SpiSession session ) {

        return this.getMri( (CoreSession) session );
    }

    public MRI getMri( CoreSession session ) {

        WorkspaceSet workspaceSet = determineWorkspaceSetForSession( session );
        MRI result = workspaceSet.getMriForLri( session, lri );
        return result;
    }

    private WorkspaceSet determineWorkspaceSetForSession( CoreSession session ) {

        if ( session != null ) {
            return session.getWorkspaceSet( );
        }
        throw new MoinIllegalStateException( CoreImplMessages.LRIHASTOBERESOLVEDINSCOPEOFSESSION, this.lri );
    }

    public String getMofId( ) {

        return this.lri.getMofId( );
    }

    public LRI getLri( ) {

        return this.lri;
    }

    public void uncache( ) {

        this.resolved = null;
    }

    @Override
    public int hashCode( ) {

        return this.lri.hashCode( );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( this == obj ) {
            result = true;
        } else if ( obj instanceof LriReferenceImpl ) {
            result = this.lri.equals( ( (LriReferenceImpl) obj ).lri );
        }
        return result;
    }

    @Override
    public String toString( ) {

        if ( resolved != null ) {
            return resolved.toString( );
        }
        return this.lri.toString( );
    }
}