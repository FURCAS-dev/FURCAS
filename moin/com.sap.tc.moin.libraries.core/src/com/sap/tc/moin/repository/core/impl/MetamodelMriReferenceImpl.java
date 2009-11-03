package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.MetamodelMriReference;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;

public final class MetamodelMriReferenceImpl extends AbstractMriReferenceImpl implements MetamodelMriReference {

    private MetamodelWorkspace metamodelWorkspace;

    public MetamodelMriReferenceImpl( CorePartitionable partitionable, MRI mri, MetamodelWorkspace metamodelWorkspace ) {

        super( partitionable, mri, true /* cacheable */);
        this.metamodelWorkspace = metamodelWorkspace;
    }

    @Override
    protected CorePartitionable resolveWithoutException( CoreSession session ) {

        resolved = metamodelWorkspace.getMetamodelElement( mri.getMofId( ) );
        if ( resolved != null ) {
            mri = null;
        }
        return resolved;
    }

    @Override
    protected CoreMoin getMoin( ) {

        return metamodelWorkspace.getWorkspaceSet( ).getMoin( );
    }
}