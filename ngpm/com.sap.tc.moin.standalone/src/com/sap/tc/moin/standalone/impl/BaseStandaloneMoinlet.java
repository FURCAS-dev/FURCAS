package com.sap.tc.moin.standalone.impl;

import java.util.Collections;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationAdaptorFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.standalone.util.MoinArgumentsToolkit;

/**
 * Base standalone MOINlet. For now, this moinlet supports a single model DC
 * with src/ as moin folder.
 * 
 * @author D046220
 */
public abstract class BaseStandaloneMoinlet extends AbstractMoinlet {

    private String[] arguments;

    public abstract void executeFunctionality( String[] arguments, Moin moin, Connection conn, String dataArea );

    public void execute( Moin moin, CompoundClientSpec clientSpec ) {

        executeFunctionality( arguments, moin, createConnection( moin, clientSpec ), MoinBuildConstants.DEFAULT_DATA_AREA_NAME );
    }

    public IpiDiConfigurationProvider getDiConfigurationProvider( String[] arguments ) {

        this.arguments = arguments;

        IpiDiConfigurationAdaptorFactoryImpl diAdaptorFactory = new IpiDiConfigurationAdaptorFactoryImpl( );

        IpiDiDcDefinitionProvider dcProv = diAdaptorFactory.getStandaloneDiDcDefinitionAdaptor( "sap.com", getDcName( arguments ) );

        return diAdaptorFactory.getStandaloneDiConfigurationAdaptor( IpiDiConfigurationProvider.Scenario.BUILD_SCENARIO, MoinBuildConstants.DEFAULT_DATA_AREA_NAME, Collections.singletonList( dcProv ), MoinArgumentsToolkit.getArgumentValue( "-configurationRoot", arguments,
                                                                                                                                                                                                                                                "-configurationRoot parameter has to be provided." ) );
    }
}
