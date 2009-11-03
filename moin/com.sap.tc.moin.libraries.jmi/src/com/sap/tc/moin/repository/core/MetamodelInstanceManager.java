package com.sap.tc.moin.repository.core;

public interface MetamodelInstanceManager extends CoreInstanceManager {

    public CorePartitionable getInstance( String mofId );

    public void injectInstance( CorePartitionable element );
}
