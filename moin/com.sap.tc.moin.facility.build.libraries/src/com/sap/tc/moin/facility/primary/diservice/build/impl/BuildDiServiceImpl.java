package com.sap.tc.moin.facility.primary.diservice.build.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.sap.tc.moin.facility.primary.diservice.fs.impl.DiFsServiceImpl;
import com.sap.tc.moin.facility.primary.diservice.impl.DiConfigurationImpl;
import com.sap.tc.moin.facility.primary.diservice.impl.DiDevelopmentComponentImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.build.IpiBuildDiService;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

/**
 * @author d021091
 */
public class BuildDiServiceImpl extends DiFsServiceImpl implements IpiBuildDiService {

    /** ******************** Internals ************************************** */

    private HashMap<String, DiConfigurationImpl> _diConfigurations = new HashMap<String, DiConfigurationImpl>( );

    /** ******************** Construction *********************************** */

    /**
     * Private default constructor - this is a singleton.
     */
    public BuildDiServiceImpl( ) {

        super( );
    }

    /** ******************** IpiBuildDiService ****************************** */

    public ClientSpec getClientSpec( IpiDiConfigurationProvider diConfigurationProvider ) {

        // Determine the parts needed for the creation of the clientSpec:
        // Mapping: clientSpecId --> dataAreaName
        String clientSpecId = diConfigurationProvider.getConfigurationName( );
        String dataAreaName = clientSpecId;
        DataAreaDescriptor dataAreaDescriptor = _dataAreaDescriptorFactory.createDataAreaDescriptor( dataAreaName );

        // Get the client-spec: 
        SpiClientSpec clientSpec = getOrCreateClientSpec( clientSpecId, dataAreaName, DONT_CREATE_CLIENT_SPEC );
        if ( clientSpec == null ) {

            // Create the client-spec:
            clientSpec = getOrCreateClientSpec( clientSpecId, dataAreaName, DO_CREATE_CLIENT_SPEC );
            if ( clientSpec == null ) {
                return null; // clientSpec could not be created
            }

            // Initialization of Persistence:
            // In Build-Scenario we assume that we do not get intermediate changes on the configuration.
            // --> It is sufficient to initialize the Persistence only once, i.e. when the client spec is created.
            DiConfigurationImpl diConfiguration = createAndCheckDiConfiguration( diConfigurationProvider, dataAreaDescriptor );
            Collection<DiDevelopmentComponentImpl> moinDcs = getAndCheckDiMoinDcDefinitions( diConfiguration );
            Collection<DiDevelopmentComponentImpl> notRegisteredMoinDcs = initializeFsPersistence( moinDcs, _dataAreaManager.getDataAreaByName( dataAreaName ).getDescriptor( ) );
            _diConfigurations.put( clientSpecId, diConfiguration );
        }

        return clientSpec;
    }

    /** ************************** DiFsServiceImpl **************************** */

    @Override
    protected DiConfigurationImpl getAndCheckDiConfiguration( SpiClientSpec clientSpec ) {

        return _diConfigurations.get( clientSpec.getClientId( ) );

    }

    @Override
    protected DiDevelopmentComponentImpl getAndCheckDiMoinDcDefinition( DiConfigurationImpl diConfiguration, CRI cri ) {

        // In Build-Scenario DiService does not perform caching, there is no need for refresh --> no checks necessary
        return diConfiguration.getMoinDcDefinition( cri.getContainerName( ) );
    }

    @Override
    protected Collection<DiDevelopmentComponentImpl> getAndCheckDiMoinDcDefinitions( DiConfigurationImpl diConfiguration ) {

        // In Build-Scenario DiService does not perform caching, there is no need for refresh --> no checks necessary
        return diConfiguration.synchronizedGetMoinDcDefinitions( );
    }

    @Override
    public boolean isLinkBackedByContainerUsage( PRI usingPri, PRI usedPri, SpiClientSpec clientSpecOfUsingPri, SpiClientSpec clientSpecOfUsedPri ) {

        // BuildDiService does not analyze the DcToPpReferences, but it assumes that: 
        // - DiBuildInfrastructure has only synced PP-archives which are visible for the DC which should be build
        // - and that MoinBuildInfrastructure has only provided those DCs with their archives via diConfigurationProvider.
        // --> Only the visible partitions are registered on Persistence.
        // Additionally, during DC-build new model elements and references are only created in the DC, which is build,
        // the references can only go to partitions inside this DC or to the partitions which are visible for the DC.
        return true;
    }

    @Override
    public Collection<CRI> getVisibleContainers( SpiClientSpec clientSpec, CRI cri ) {

        // We currently do not have a requirement to support this method,
        // therefore the respectively needed IpiDiDcDefinitionProvider-methods
        // are not implemented in Build-scenario.
        throw new UnsupportedOperationException( );
    }

    @Override
    public Collection<PRI> getOuterPartitions( SpiClientSpec clientSpec, CRI cri, List<PartitionOperation> dirtyPartitions ) {

        // We currently do not have a requirement to support this method,
        // therefore the respectively needed IpiDiDcDefinitionProvider-methods
        // are not implemented in Build-scenario.
        throw new UnsupportedOperationException( );
    }

}
