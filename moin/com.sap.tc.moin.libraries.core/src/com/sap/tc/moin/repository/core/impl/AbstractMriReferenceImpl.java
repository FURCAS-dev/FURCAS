package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.spi.core.SpiSession;

public abstract class AbstractMriReferenceImpl extends AbstractReferenceImpl implements MriReference {

    protected MRI mri;

    public AbstractMriReferenceImpl( CorePartitionable partitionable, MRI mri, boolean cacheable ) {

        super( partitionable, cacheable );
        if ( ( partitionable != null ) && cacheable ) {
            this.mri = null;
        } else {
            this.mri = mri;
        }
    }



    public MRI getMri( CoreSession session ) {

        return getMri( );
    }

    public MRI getMri( SpiSession session ) {

        return getMri( (CoreSession) session );
    }

    protected abstract CoreMoin getMoin( );


    @Override
    protected final CorePartitionable resolve( CoreSession session ) {

        CorePartitionable result = this.resolveWithoutException( session );
        if ( result == null ) {
            // handle inconsistency
            throw new UnresolvableException( JmiCoreMessages.MRINOTRESOLVED, this.mri );

        }
        return result;
    }

    @Override
    protected CorePartitionable resolveWithoutException( CoreSession session ) {

        WorkspaceSet workspaceSet = null;

        if ( session != null ) {
            workspaceSet = session.getWorkspaceSet( );
        } else if ( this.mri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
            workspaceSet = getMoin( ).getMetamodelWorkspace( ).getWorkspaceSet( );
        } else {
            throw new MoinIllegalStateException( CoreImplMessages.AMRIHASTOBERESOLVEDINSCOPEOFSESSION, this.mri );
        }

        CorePartitionable result = workspaceSet.resolveMri( session, this.mri );
        if ( result != null ) {
            if ( cacheable ) {
                this.resolved = result;
                this.mri = null;
            }
        }
        return result;
    }

    public final PRI getPri( ) {

        return this.getMri( ).getPri( );
    }

    public PRI getPri( CoreSession session ) {

        return getPri( );
    }

    public final MRI getMri( ) {

        if ( resolved != null ) {
            return this.resolved.get___Mri( );
        }
        return this.mri;
    }

    public final LRI getLri( ) {

        return this.getMri( ).getLri( );
    }

    public final String getMofId( ) {

        if ( resolved != null ) {
            return resolved.refMofId( );
        }
        return this.getMri( ).getMofId( );
    }

    public final void uncache( ) {

        if ( resolved != null ) {
            this.mri = this.resolved.get___Mri( );
            this.resolved = null;
        }
    }

    public final void elementRelocated( CoreModelPartition newPartition ) {

        if ( resolved == null && !getPri( ).equals( newPartition.getPri( ) ) ) {
            this.mri = newPartition.getPri( ).createMri( getMofId( ) );
        }
    }

    @Override
    public final int hashCode( ) {

        return this.getMri( ).hashCode( );
    }

    @Override
    public final boolean equals( Object obj ) {

        boolean result = false;
        if ( this == obj ) {
            result = true;
        } else if ( obj instanceof MriReference ) {
            result = this.getMri( ).equals( ( (MriReference) obj ).getMri( ) );
        }
        return result;
    }

    @Override
    public final String toString( ) {

        return this.getMri( ).toString( );
    }

    public final CorePartitionable getIfResolved( ) {

        return this.resolved;
    }
}
