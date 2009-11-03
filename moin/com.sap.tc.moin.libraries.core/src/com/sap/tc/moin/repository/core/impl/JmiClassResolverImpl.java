package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.JmiClassResolver;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;

/**
 * This class provides an implementation of the {@link JmiClassResolver}
 * interface
 * <p>
 * Subclasses need to provide an implementation for the abstract method
 * {@link #getClassForName(String)}.
 */
public class JmiClassResolverImpl implements JmiClassResolver {

    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_JMI_CLASSLOADING, JmiClassResolverImpl.class );

    private final SpiMetamodelRegistry metaModelRegistry;


    public JmiClassResolverImpl( SpiMetamodelRegistry metaModelRegistry ) {

        this.metaModelRegistry = metaModelRegistry;
    }

    @SuppressWarnings( "unchecked" )
    public Class getClass( MofClass mofClass ) throws ClassNotFoundException {

        return getClassForMri( mofClass.get___Mri( ) );
    }

    @SuppressWarnings( "unchecked" )
    public Class getClass( MofPackage mofPackage ) throws ClassNotFoundException {

        return getClassForMri( mofPackage.get___Mri( ) );
    }

    @SuppressWarnings( "unchecked" )
    private Class getClassForMri( MRI mri ) {

        CRI cri = mri.getCri( );
        DeploymentExtension deploymentExtension = this.metaModelRegistry.getDeploymentExtension( cri );
        if ( deploymentExtension == null ) {
            logger.trace( MoinSeverity.ERROR, "JMI class resolving failed for element {0} - deployment extension not found in meta-model registry", mri ); //$NON-NLS-1$
            // TODO: verify error handling in JmiClassResolver
            return null;
        }

        String className = deploymentExtension.getMofIDClassNameMapping( ).get( mri.getMofId( ) );
        if ( className == null ) {
            logger.trace( MoinSeverity.ERROR, "JMI class resolving failed for element {0} - no class-name mapping found for Mof-ID", mri ); //$NON-NLS-1$
            // TODO: verify error handling in JmiClassResolver
            return null;
        }

        try {
            return deploymentExtension.getJmiClass( className );
        } catch ( ClassNotFoundException e ) {
            logger.trace( e, MoinSeverity.ERROR, "JMI class resolving failed for element {0} - class not found", mri ); //$NON-NLS-1$
            // TODO: verify error handling in JmiClassResolver
            return null;
        }
    }
}