package com.sap.tc.moin.facility.primary.ipi.diservice;

import java.util.List;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;


public class IpiDiConfigurationAdaptorFactoryImpl {

    // Test-Scenario is the same as IDE-scenario concerning evaluation of
    // moin-resource-folders (only place where the scenario is needed)
    // and in the current primitive implementation this does not matter
    // (see implementation of resource-folders in
    // IpiDiDcDefinitionTestAdaptorImpl)
    // return Scenario.IDE_SCENARIO;

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, IpiDiConfigurationAdaptorFactoryImpl.class );

    private static boolean INITIALIZE = true;

    private static Class[] STANDALONE_CONFIGURATION_PARAMETER_CLASSES = new Class[] { IpiDiConfigurationProvider.Scenario.class, String.class, List.class, String.class };

    private static Class[] STANDALONE_DC_DEFINITION_PARAMETER_CLASSES = new Class[] { String.class, String.class };

    private static Class[] MM_CONFIGURATION_PARAMETER_CLASSES = new Class[] { IpiDiConfigurationProvider.Scenario.class, String.class, List.class };

    private static Class[] SOURCE_MM_DC_DEFINITION_PARAMETER_CLASSES = new Class[] { String.class, String.class, String.class };

    private static Class[] ARCHIVE_MM_DC_DEFINITION_PARAMETER_CLASSES = new Class[] { String.class, String.class, List.class };

    /** ******************** IPI: Factory methods *************************** */

    public IpiDiConfigurationProvider getStandaloneDiConfigurationAdaptor( IpiDiConfigurationProvider.Scenario scenario, String configurationName, List<IpiDiDcDefinitionProvider> dcDefinitionProviders, String configurationRootPath ) throws IpiDiServiceException {

        Class adaptorClass = null;
        try {
            // We instantiate the class using the current class loader to avoid
            // class loading problems e.g. in Eclipse
            adaptorClass = Class.forName( "com.sap.tc.moin.facility.primary.diservice.impl.StandaloneDiConfigurationAdaptorImpl", INITIALIZE, this.getClass( ).getClassLoader( ) ); //$NON-NLS-1$
        } catch ( ClassNotFoundException e1 ) {
            // Message: "Internal error: configuration adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_CONFIGURATION_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        Object[] parameterValues = new Object[] { scenario, configurationName, dcDefinitionProviders, configurationRootPath };
        IpiDiConfigurationProvider diConfigurationAdaptor = null;
        try {
            diConfigurationAdaptor = (IpiDiConfigurationProvider) adaptorClass.getMethod( "getInstance", STANDALONE_CONFIGURATION_PARAMETER_CLASSES ).invoke( adaptorClass, parameterValues ); //$NON-NLS-1$
        } catch ( Exception e1 ) {
            // Message: "Internal error: configuration adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_CONFIGURATION_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        return diConfigurationAdaptor;
    }

    public IpiDiDcDefinitionProvider getStandaloneDiDcDefinitionAdaptor( String dcVendor, String dcName ) {

        Class adaptorClass = null;
        try {
            // We instantiate the class using the current class loader to avoid
            // class loading problems e.g. in Eclipse
            adaptorClass = Class.forName( "com.sap.tc.moin.facility.primary.diservice.impl.StandaloneDiDcDefinitionAdaptorImpl", INITIALIZE, this.getClass( ).getClassLoader( ) ); //$NON-NLS-1$
        } catch ( ClassNotFoundException e1 ) {
            // Message: "Internal error: development component adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        Object[] parameterValues = new Object[] { dcVendor, dcName };
        IpiDiDcDefinitionProvider diDcDefinitionAdaptor = null;
        try {
            diDcDefinitionAdaptor = (IpiDiDcDefinitionProvider) adaptorClass.getMethod( "getInstance", STANDALONE_DC_DEFINITION_PARAMETER_CLASSES ).invoke( adaptorClass, parameterValues ); //$NON-NLS-1$
        } catch ( Exception e1 ) {
            // Message: "Internal error: development component adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        return diDcDefinitionAdaptor;
    }

    public IpiDiConfigurationProvider getMetaModelDiConfigurationAdaptor( IpiDiConfigurationProvider.Scenario scenario, String configurationName, List<IpiDiDcDefinitionProvider> dcDefinitionProviders ) throws IpiDiServiceException {

        Class adaptorClass = null;
        try {
            // We instantiate the class using the current class loader to avoid
            // class loading problems e.g. in Eclipse
            adaptorClass = Class.forName( "com.sap.tc.moin.facility.primary.diservice.impl.MetaModelDiConfigurationAdaptorImpl", INITIALIZE, this.getClass( ).getClassLoader( ) ); //$NON-NLS-1$
        } catch ( ClassNotFoundException e1 ) {
            // Message: "Internal error: configuration adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_CONFIGURATION_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        Object[] parameterValues = new Object[] { scenario, configurationName, dcDefinitionProviders };
        IpiDiConfigurationProvider diConfigurationAdaptor = null;
        try {
            diConfigurationAdaptor = (IpiDiConfigurationProvider) adaptorClass.getMethod( "getInstance", MM_CONFIGURATION_PARAMETER_CLASSES ).invoke( adaptorClass, parameterValues ); //$NON-NLS-1$
        } catch ( Exception e1 ) {
            // Message: "Internal error: configuration adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_CONFIGURATION_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        return diConfigurationAdaptor;
    }

    public IpiDiDcDefinitionProvider getMetaModelDiDcDefinitionAdaptor( String dcVendor, String dcName, String dcRootPath ) {

        Class adaptorClass = null;
        try {
            // We instantiate the class using the current class loader to avoid
            // class loading problems e.g. in Eclipse
            adaptorClass = Class.forName( "com.sap.tc.moin.facility.primary.diservice.impl.MetaModelDiDcDefinitionAdaptorImpl", INITIALIZE, this.getClass( ).getClassLoader( ) ); //$NON-NLS-1$
        } catch ( ClassNotFoundException e1 ) {
            // Message: "Internal error: development component adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        Object[] parameterValues = new Object[] { dcVendor, dcName, dcRootPath };
        IpiDiDcDefinitionProvider diDcDefinitionAdaptor = null;
        try {
            diDcDefinitionAdaptor = (IpiDiDcDefinitionProvider) adaptorClass.getMethod( "getInstance", SOURCE_MM_DC_DEFINITION_PARAMETER_CLASSES ).invoke( adaptorClass, parameterValues ); //$NON-NLS-1$
        } catch ( Exception e1 ) {
            // Message: "Internal error: development component adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        return diDcDefinitionAdaptor;
    }

    public IpiDiDcDefinitionProvider getMetaModelDiDcDefinitionAdaptor( String dcVendor, String dcName, List<String> dcArchivePaths ) {

        Class adaptorClass = null;
        try {
            // We instantiate the class using the current class loader to avoid
            // class loading problems e.g. in Eclipse
            adaptorClass = Class.forName( "com.sap.tc.moin.facility.primary.diservice.impl.MetaModelDiDcDefinitionAdaptorImpl", INITIALIZE, this.getClass( ).getClassLoader( ) ); //$NON-NLS-1$
        } catch ( ClassNotFoundException e1 ) {
            // Message: "Internal error: development component adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        Object[] parameterValues = new Object[] { dcVendor, dcName, dcArchivePaths };
        IpiDiDcDefinitionProvider diDcDefinitionAdaptor = null;
        try {
            diDcDefinitionAdaptor = (IpiDiDcDefinitionProvider) adaptorClass.getMethod( "getInstance", ARCHIVE_MM_DC_DEFINITION_PARAMETER_CLASSES ).invoke( adaptorClass, parameterValues ); //$NON-NLS-1$
        } catch ( Exception e1 ) {
            // Message: "Internal error: development component adaptor could not be instantiated"
            IpiDiServiceException e = new IpiDiServiceException( e1, IpiDiServiceMessages.INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        return diDcDefinitionAdaptor;
    }

}
