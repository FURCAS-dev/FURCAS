package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;

/**
 * @author d021091
 */

// only algorithm to evaluate configuration
// --> using ConfigurationProvider
// --> ProjectHandler realizes more performant impl for ConfigurationProvider
// and uses ConfigurationHandler to evaluate the configuration provided by the
// ConfigurationProvider
// hot_todo: handle stages so that that dcDefinitions for different stages are available, corresponding to the respective clientSpec: on this layer or completely in configurationProvider layer
// --> one configuration per clientSpec
public abstract class DiConfigurationImpl {

    /** ******************** Internals ************************************** */

    protected IpiDiConfigurationProvider _moinDiConfigurationProvider;

    // We can only use the data area descriptor, because during initialization flow the DiConfiguration is created before the data area is created.
    protected DataAreaDescriptor _dataAreaDescriptor;

    protected ResourceIdentifierFactory _riFactory;

    // Cache of DC-definitions, for fast access, filled on demand:
    // Map: modelContainerName --> DiDevelopmentComponent
    protected Map<String, DiDevelopmentComponentImpl> _moinDcDefinitions;

    /** ******************** Construction *********************************** */

    protected DiConfigurationImpl( IpiDiConfigurationProvider moinDiConfigurationProvider, DataAreaDescriptor dataAreaDescriptor, ResourceIdentifierFactory riFactory ) {

        _moinDiConfigurationProvider = moinDiConfigurationProvider;

        // We can only use the data area descriptor, because during initialization flow the DiConfiguration is created before the data area is created.
        _dataAreaDescriptor = dataAreaDescriptor;

        _riFactory = riFactory;

        // Direct Initialization:
        synchronizedGetMoinDcDefinitions( );
    }

    /** ************************* API ************************************* */

    synchronized public Collection<DiDevelopmentComponentImpl> synchronizedGetMoinDcDefinitions( ) {

        if ( _moinDcDefinitions == null ) {
            // The MOIN-DcDefinitions are determined on demand
            _moinDcDefinitions = Collections.synchronizedMap( new HashMap<String, DiDevelopmentComponentImpl>( ) );
            Collection<IpiDiDcDefinitionProvider> dcDefinitions = _moinDiConfigurationProvider.getMoinDiDcDefinitions( );
            for ( IpiDiDcDefinitionProvider dcDefinition : dcDefinitions ) {
                DiDevelopmentComponentImpl moinDc = getOrCreateMoinDcDefinition( dcDefinition );
                _moinDcDefinitions.put( moinDc.getModelContainerName( ), moinDc );
            }
        }
        return getMoinDcDefinitions( );
    }

    public Collection<DiDevelopmentComponentImpl> getMoinDcDefinitions( ) {

        return Collections.unmodifiableCollection( _moinDcDefinitions.values( ) );
    }

    public DiDevelopmentComponentImpl getMoinDcDefinition( String modelContainerName ) {

        return _moinDcDefinitions.get( modelContainerName );
    }

    public IpiDiConfigurationProvider.Scenario getScenario( ) {

        return _moinDiConfigurationProvider.getScenario( );
    }

    public IpiDiConfigurationProvider getDiConfigurationProvider( ) {

        return _moinDiConfigurationProvider;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return _dataAreaDescriptor;
    }

    public abstract void refreshInternalCaches( );

    // Method is reasonable when one/more DcDefinitions have changed and
    // Provider can deliver the newest contents
    synchronized public void resetInternalCaches( ) {

        _moinDcDefinitions = Collections.synchronizedMap( new HashMap<String, DiDevelopmentComponentImpl>( ) );
    }

    /** ********** Methods which are probably scenario dependent ************ */

    // might be overwritten by sub class
    // this allows caching of those objects ...
    protected abstract DiDevelopmentComponentImpl getOrCreateMoinDcDefinition( IpiDiDcDefinitionProvider dcDefinition );

    /** ******************** Internals ************************************** */

}
