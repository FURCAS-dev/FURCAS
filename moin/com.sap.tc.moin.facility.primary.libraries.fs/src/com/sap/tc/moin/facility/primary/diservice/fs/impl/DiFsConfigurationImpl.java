package com.sap.tc.moin.facility.primary.diservice.fs.impl;

import com.sap.tc.moin.facility.primary.diservice.impl.DiConfigurationImpl;
import com.sap.tc.moin.facility.primary.diservice.impl.DiDevelopmentComponentImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;

public class DiFsConfigurationImpl extends DiConfigurationImpl {

    /** ******************** Construction *********************************** */

    public DiFsConfigurationImpl( IpiDiConfigurationProvider moinDiConfigurationProvider, DataAreaDescriptor dataAreaDescriptor, ResourceIdentifierFactory riFactory ) {

        super( moinDiConfigurationProvider, dataAreaDescriptor, riFactory );
    }

    /** ****** Scenario-specific parts of DiConfigurationImpl *************** */

    @Override
    public DiDevelopmentComponentImpl getOrCreateMoinDcDefinition( IpiDiDcDefinitionProvider dcDefinitionProvider ) {

        String modelContainerName = dcDefinitionProvider.getFullDcName( );
        DiDevelopmentComponentImpl dc = _moinDcDefinitions.get( modelContainerName );
        if ( dc == null ) {
            // newly created DC which was not yet registered			
            CRI cri = _riFactory.createCri( _dataAreaDescriptor.getDataAreaName( ), modelContainerName );
            // In environments with file system we need to create the scenario-specific development component implementation:
            dc = new DiFsDevelopmentComponentImpl( dcDefinitionProvider, cri, this );
            _moinDcDefinitions.put( modelContainerName, dc );
        }
        return dc;
    }

    public void invalidateMoinDcDefinition( DiDevelopmentComponentImpl dc ) {

        // Remove from cache:
        String fullDcName = dc.getModelContainerName( );
        _moinDcDefinitions.remove( fullDcName );

        // Invalid objects MUST NOT point to other objects (could prevent garbage collection of other objects ...)
        dc.invalidate( );

    }

    @Override
    public void refreshInternalCaches( ) {

        // Reset the cache with DcDefinitions and retrieve them again
        // (Remark: also the cached DcDefinition-Providers could be out-dated --> we retrieve everything from scratch)
        _moinDcDefinitions = null;
        synchronizedGetMoinDcDefinitions( );
    }
}
