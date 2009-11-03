package com.sap.tc.moin.repository.runtimehost.deployment;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.RuntimehostMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetaModelInfo;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;

/**
 * Central registry for meta-models.
 * <p>
 * This class hosts access to meta-model information at runtime. It implements
 * both the {@link MetaModelCatalog} interface which is exposed in the public
 * API (and provides a simple list of deployed meta-models) and the
 * {@link SpiMetamodelRegistry} interface which defines the internal contract
 * between the MOIN core and the runtimehost (wrt meta-model access).
 * <p>
 * The platform-specific meta-model receiver implementations should re-use this
 * class fulfilling these 2 contracts.
 * <p>
 * Note that this is a dedicated registry for meta-model access - it does not
 * serve as registry for loaded deployment units - which are not keyed by
 * {@link CRI} and specific to the actual runtime (Eclipse plug-ins, Java EE
 * applications, ...). TODO: make this class final and implement a composite
 * pattern in {@link IdeMetamodelRegistries}.
 */
public class MetamodelRegistryImpl implements MetaModelCatalog, SpiMetamodelRegistry {

    // MOIN logger
    private static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_METAMODELS, MetamodelRegistryImpl.class );

    protected Map<CRI, SpiMetaModelInfo> deployedMetamodels = new LinkedHashMap<CRI, SpiMetaModelInfo>( );

    public synchronized Collection<MetaModelInfo> getMetaModelList( ) {

        return Collections.unmodifiableCollection( (Collection<? extends MetaModelInfo>) this.deployedMetamodels.values( ) );
    }

    private SpiMetaModelInfo getMetaModelInfo( CRI container ) {

        return this.deployedMetamodels.get( container );
    }

    /**
     * @see com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry#getDeploymentExtension(com.sap.tc.moin.repository.CRI)
     */
    public DeploymentExtension getDeploymentExtension( CRI cri ) {

        SpiMetaModelInfo metaModelInfo = getMetaModelInfo( cri );

        if ( metaModelInfo != null ) {
            return metaModelInfo.getMmExtensionInstance( );
        }

        // meta-model not found
        if ( _log.isTraced( MoinSeverity.WARNING ) ) {
            _log.trace( MoinSeverity.WARNING, RuntimehostMessages.METAMODEL_NOT_FOUND, new Object[] { cri } );
        }

        return null;
    }

    public boolean isDeployed( CRI cri ) {

        return this.deployedMetamodels.containsKey( cri );
    }

    /**
     * @see com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry#getMetaModelVersion(com.sap.tc.moin.repository.CRI)
     */
    public MetaModelVersion getMetaModelVersion( CRI cri ) {

        SpiMetaModelInfo metaModelInfo = getMetaModelInfo( cri );

        if ( metaModelInfo != null ) {
            return metaModelInfo.getDeployedMetaModelVersion( );
        }

        // meta-model not found
        if ( _log.isTraced( MoinSeverity.WARNING ) ) {
            _log.trace( MoinSeverity.WARNING, RuntimehostMessages.METAMODEL_NOT_FOUND, new Object[] { cri } );
        }

        return null;
    }

    /**
     * Registers all meta-model provided by the specified info object
     * collection.
     * 
     * @see #registerMetaModel(SpiMetaModelInfo)
     */
    public void registerAllMetaModels( Collection<? extends SpiMetaModelInfo> metaModelInfos ) {

        for ( SpiMetaModelInfo metaModelInfo : metaModelInfos ) {
            registerMetaModel( metaModelInfo );
        }
    }

    /**
     * Registers the meta-model provided by the specified info object. First,
     * the JMI classes of the meta-model are registered in the
     * MetaModelRegistry. If successful, the meta-model info object is added to
     * the map of deployed meta-models.
     * 
     * @param metaModelInfo
     * @return a previously deployed meta-model info, if any
     */
    public SpiMetaModelInfo registerMetaModel( SpiMetaModelInfo metaModelInfo ) {

        if ( this.deployedMetamodels == null ) {
            this.deployedMetamodels = new HashMap<CRI, SpiMetaModelInfo>( );
        }

        return this.deployedMetamodels.put( metaModelInfo.getContainer( ), metaModelInfo );
    }

    public void unregisterMetaModel( SpiMetaModelInfo metaModelInfo ) {

        if ( this.deployedMetamodels == null ) {
            return;
        }

        this.deployedMetamodels.remove( metaModelInfo.getContainer( ) );
    }

    /**
     * @see com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry#getLocalizedString(CRI,
     * Locale, String)
     */
    public String getLocalizedString( CRI cri, Locale locale, String resourceKey ) {

        // get the corresponding meta-model info object first
        SpiMetaModelInfo metaModelInfo = this.getMetaModelInfo( cri );

        if ( metaModelInfo == null ) {

            if ( _log.isTraced( MoinSeverity.WARNING ) ) {
                _log.trace( MoinSeverity.WARNING, RuntimehostMessages.METAMODEL_NOT_FOUND, new Object[] { cri } );
            }
            return null;
        }

        // get the corresponding deployment extension and its classloader
        DeploymentExtension deploymentExtension = metaModelInfo.getMmExtensionInstance( );
        ClassLoader loader = deploymentExtension.getClass( ).getClassLoader( );

        String bundleName = metaModelInfo.getMetaModelResourceBundleName( );
        ResourceBundle resourceBundle = null;
        try {
            // instantiate the meta-model resource bundle with the corresponding classloader
            resourceBundle = ResourceBundle.getBundle( bundleName, locale, loader );
        } catch ( MissingResourceException e ) {

            if ( _log.isTraced( MoinSeverity.WARNING ) ) {
                _log.trace( e, MoinSeverity.WARNING, RuntimehostMessages.UNRESOLVED_TEXT_LOCALIZATION, new Object[] { bundleName, cri } );
            }
            return null;
        }

        // try to resolve the specified resource key
        try {
            return resourceBundle.getString( resourceKey );
        } catch ( MissingResourceException e ) {

            if ( _log.isTraced( MoinSeverity.WARNING ) ) {
                _log.trace( e, MoinSeverity.WARNING, RuntimehostMessages.UNRESOLVED_TEXT_LOCALIZATION2, new Object[] { resourceKey, cri } );
            }
            return null;
        }
    }
}