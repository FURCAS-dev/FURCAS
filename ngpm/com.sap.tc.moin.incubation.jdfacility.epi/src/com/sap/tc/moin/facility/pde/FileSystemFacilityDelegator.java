package com.sap.tc.moin.facility.pde;

import java.util.Collection;

import com.sap.tc.moin.facility.filesystem.FileSystemFacility;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiCoreQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiExternalSaveLocking;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;
import com.sap.tc.moin.repository.spi.facility.SpiInternalDistributedDirtyLocking;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.facility.SpiMQLQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsFacility;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsMetaModelManager;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.util.SpiDelegator;


public class FileSystemFacilityDelegator extends SpiDelegator<FileSystemFacility> implements Facility, SpiFsFacility, SpiFacilityLifecycle, IpiFsFacilityForTest {

    public FileSystemFacilityDelegator( FileSystemFacility facility ) {

        super( facility );
    }

    public void finalizeStartup( ) {

        getDelegatedInstance( ).finalizeStartup( );
    }

    public void initialize( ) {

        getDelegatedInstance( ).initialize( );
    }

    public void tearDown( ) {

        getDelegatedInstance( ).tearDown( );
    }

    public SpiFsMetaModelManager getFsMetaModelManager( ) {

        return getDelegatedInstance( ).getFsMetaModelManager( );
    }

    public SpiCoreQueryService getCoreQueryService( ) {

        return getDelegatedInstance( ).getCoreQueryService( );
    }

    public DataArea getDataAreaByName( String name ) {

        return getDelegatedInstance( ).getDataAreaByName( name );
    }

    public Collection<String> getDataAreaNames( ) {

        return getDelegatedInstance( ).getDataAreaNames( );
    }

    public SpiExternalSaveLocking getExternalSaveLocking( ) {

        return getDelegatedInstance( ).getExternalSaveLocking( );
    }

    public String getId( ) {

        return getDelegatedInstance( ).getId( );
    }

    public SpiInternalDistributedDirtyLocking getInternalDistributedDirtyLocking( DataArea dataArea ) {

        return getDelegatedInstance( ).getInternalDistributedDirtyLocking( dataArea );
    }

    public SpiLifecycleManagement getLifecycleManagement( ) {

        return getDelegatedInstance( ).getLifecycleManagement( );
    }

    public SpiClientSpec getMetamodelClientSpec( ) throws SpiFacilityException {

        return getDelegatedInstance( ).getMetamodelClientSpec( );
    }

    public DataArea getMetamodelDataArea( ) {

        return getDelegatedInstance( ).getMetamodelDataArea( );
    }

    public SpiPersistence getModelPersistence( ) {

        return getDelegatedInstance( ).getModelPersistence( );
    }

    public SpiMofRomInjectionService getMofRomInjectionService( ) {

        return getDelegatedInstance( ).getMofRomInjectionService( );
    }

    public SpiMQLQueryService getMQLQueryService( ) {

        return getDelegatedInstance( ).getMQLQueryService( );
    }

    public SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return getDelegatedInstance( ).getPartitionSerializationManager( );
    }

    public ResourceIdentifierFactory getRIFactory( ) {

        return getDelegatedInstance( ).getRIFactory( );
    }

    public ClientSpec getTransientClientSpec( ) throws SpiFacilityException {

        return getDelegatedInstance( ).getTransientClientSpec( );
    }

    public DataArea getTransientDataArea( ) {

        return getDelegatedInstance( ).getTransientDataArea( );
    }

    public IpiFsResourceManagement getResourceManagement( ) {

        return getDelegatedInstance( ).getResourceManagement( );
    }

    @Override
    public boolean equals( Object obj ) {

        return getDelegatedInstance( ).equals( obj );
    }

    @Override
    public int hashCode( ) {

        return getDelegatedInstance( ).hashCode( );
    }

    @Override
    public SpiCustomContentSelectionManagement getCustomContentSelectionManagement( ) {

        return getDelegatedInstance( ).getCustomContentSelectionManagement( );
    }
}
