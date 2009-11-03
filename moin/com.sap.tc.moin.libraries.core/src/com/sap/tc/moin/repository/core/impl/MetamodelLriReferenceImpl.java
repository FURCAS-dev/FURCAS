package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.MetamodelLriReference;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;

public final class MetamodelLriReferenceImpl extends LriReferenceImpl implements MetamodelLriReference {

    private MetamodelWorkspace metamodelWorkspace;

    public MetamodelLriReferenceImpl( LRI lri, MetamodelWorkspace metamodelWorkspace ) {

        super( lri, true /* cacheable */);
        this.metamodelWorkspace = metamodelWorkspace;
    }

    @Override
    protected CorePartitionable resolveWithoutException( CoreSession session ) {

        resolved = metamodelWorkspace.getMetamodelElement( lri.getMofId( ) );
        return resolved;
    }
}
