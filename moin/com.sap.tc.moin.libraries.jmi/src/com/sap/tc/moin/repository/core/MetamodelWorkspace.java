package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;

public interface MetamodelWorkspace extends SharedWorkspace {

    public CorePartitionable getMetamodelElement( String mofId );

    public MetamodelInstanceManager getInstanceManager( );

    public SpiDataArea getMetamodelDataArea( );

    public CorePartitionable resolveElementMri( MRI mri );

    public QueryLinkManager getQueryLinkManager( );

    public MetamodelMriReference getMetamodelMriReference( CorePartitionable partitionable, MRI mri );

    public MetamodelLriReference getMetamodelLriReference( LRI lri );
}
