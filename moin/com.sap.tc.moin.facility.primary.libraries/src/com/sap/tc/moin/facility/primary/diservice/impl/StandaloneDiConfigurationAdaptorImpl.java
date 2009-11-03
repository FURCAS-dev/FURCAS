package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * The stand-alone DC-configuration adaptor provides an configuration adaptor
 * for DCs with the test-model-DC-type "com.sap.tc.moin.nwdi.dctype" (defined in
 * MIE DC-type-framework moin-ide/mi.dcfwk). This adaptor is responsible for the
 * path-handling for all DCs in the configuration (see constructor).
 * <p>
 * Caution:
 * <p>
 * This adaptor can only be used in connection with the
 * StandaloneDiDcDefinitionAdaptorImpl.
 * 
 * @author d021091
 */

public class StandaloneDiConfigurationAdaptorImpl extends BaseDiConfigurationAdaptorImpl {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, StandaloneDiConfigurationAdaptorImpl.class );

    protected String _configurationRootPath;

    private static final String PATH_SEPARATOR = "/"; //$NON-NLS-1$

    /** **************************** Construction *************************** */

    private StandaloneDiConfigurationAdaptorImpl( Scenario scenario, String configurationName, List<IpiDiDcDefinitionProvider> moinDiDcDefinitions, String configurationRootPath ) {

        super( scenario, configurationName, moinDiDcDefinitions );

        _configurationRootPath = configurationRootPath;

        // Initialize the dcDefinitionAdaptors with the dc-root-path:
        // (based on a primitive rule for the composition of the paths, see
        // below)
        for ( int i = 0; i < moinDiDcDefinitions.size( ); i++ ) {
            IpiDiDcDefinitionProvider dcProvider = moinDiDcDefinitions.get( i );
            if ( !( dcProvider instanceof StandaloneDiDcDefinitionAdaptorImpl ) ) {
                // Message: The DC-provider-object must be an instance of class "{0}", but it is an instance of class "{1}" 
                MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.WRONG_DC_PROVIDER_CLASS, StandaloneDiDcDefinitionAdaptorImpl.class.toString( ), dcProvider.getClass( ).toString( ) );
                LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
                throw e;
            }
            StandaloneDiDcDefinitionAdaptorImpl dc = (StandaloneDiDcDefinitionAdaptorImpl) dcProvider;
            // ok, this looks a bit different as usual in file system ... does
            // no matter ...
            String dcRootPath = _configurationRootPath + PATH_SEPARATOR + dc.getDcVendor( ) + PATH_SEPARATOR + dc.getDcName( );
            dc.setDcRootPath( dcRootPath );
        }
    }

    static public StandaloneDiConfigurationAdaptorImpl getInstance( Scenario scenario, String configurationName, List<IpiDiDcDefinitionProvider> dcs, String configurationRootPath ) {

        return new StandaloneDiConfigurationAdaptorImpl( scenario, configurationName, dcs, configurationRootPath );
    }

}
