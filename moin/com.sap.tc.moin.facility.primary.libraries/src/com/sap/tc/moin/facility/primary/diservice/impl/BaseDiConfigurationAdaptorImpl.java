package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

public class BaseDiConfigurationAdaptorImpl implements IpiDiConfigurationProvider {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, BaseDiConfigurationAdaptorImpl.class );

    protected String _moinDiConfigurationName;

    protected Scenario _scenario;

    protected List<IpiDiDcDefinitionProvider> _moinDiDcDefinitions;

    /** **************************** Construction *************************** */

    protected BaseDiConfigurationAdaptorImpl( Scenario scenario, String configurationName, List<IpiDiDcDefinitionProvider> moinDiDcDefinitions ) {

        super( );

        // Check preconditions:
        if ( scenario == null ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "BaseDiConfigurationAdaptorImpl", "scenario", "null" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        if ( configurationName == null || configurationName.length( ) == 0 ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "BaseDiConfigurationAdaptorImpl", "configurationName", configurationName ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        if ( moinDiDcDefinitions == null || moinDiDcDefinitions.size( ) == 0 ) {
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( "BaseDiConfigurationAdaptorImpl", "moinDiDcDefinitions", moinDiDcDefinitions ); //$NON-NLS-1$ //$NON-NLS-2$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        _scenario = scenario;
        _moinDiConfigurationName = configurationName;
        _moinDiDcDefinitions = moinDiDcDefinitions;
    }

    static public BaseDiConfigurationAdaptorImpl getInstance( Scenario scenario, String configurationName, ArrayList<IpiDiDcDefinitionProvider> dcs ) {

        return new BaseDiConfigurationAdaptorImpl( scenario, configurationName, dcs );
    }

    /** **************** API: IpiDiConfigurationProvider ***************** */

    public Scenario getScenario( ) {

        return _scenario;
    }

    public String getConfigurationName( ) {

        return _moinDiConfigurationName;
    }

    public List<IpiDiDcDefinitionProvider> getMoinDiDcDefinitions( ) {

        return Collections.unmodifiableList( _moinDiDcDefinitions );
    }

}
