package com.sap.tc.moin.repository.ide;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;

import com.sap.tc.moin.repository.admin.ide.IdeRuntimeHost;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentManager;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * IDE-specific entry point to MOIN. <br>
 * This class provides static access to MOIN. Use
 * 
 * <pre>
 * Moin moin = {@link #getMoinInstance MoinFactory.getMoinInstance()};
 * </pre>
 * 
 * to obtain an instance of {@link com.sap.tc.moin.repository.Moin}, from where
 * you have access to all features of MOIN.
 */
public class MoinFactory {

    private static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, MoinFactory.class );

    /**
     * The method returns the currently running IdeMoin instance. If MOIN is not
     * running, a new IdeMoin instance is started.
     * <p/>
     * Do not use this API in IDE scenarios. Please rely on the MI services
     * (e.g. <code>com.sap.mi.fwk.ConnectionManager</code>) for this purpose.
     * These services prevent deadlocks, race-conditions and handle (eclipse)
     * threading requirements appropriately.</br>
     * 
     * @return running IdeMoin instance.
     */
    public static IdeMoin getMoinInstance( ) {

        IdeRuntimeHost runtimeHost = getRuntimeHost( );
        if ( runtimeHost != null ) {
            return runtimeHost.getMoinInstance( );
        }
        return null;
    }

    /**
     * Obtains Metamodel Deployment Manager.
     * <p>
     * The Metamodel Deployment Manager helps administering the MOIN metamodels
     * - provides deployment relevant metamodel information (deployment status,
     * version, etc.). <br>
     * This is a convenience method and is equivalent to calling
     * <code>MoinFactory.getRuntimeHost().getMmDeploymentManager()</code>.
     * 
     * @return Metamodel Deployment Manager.
     */
    public static MmDeploymentManager getMmDeploymentManager( ) {

        IdeRuntimeHost runtimeHost = getRuntimeHost( );
        if ( runtimeHost != null ) {
            // This call starts MOIN, if not already started.
            runtimeHost.getMoinInstance( );

            return runtimeHost.getMmDeploymentManager( );
        }
        return null;

    }

    public static MetaModelCatalog getMetamodelCatalog( ) {

        IdeRuntimeHost runtimeHost = getRuntimeHost( );
        if ( runtimeHost != null ) {
            // This call starts MOIN, if not already started.
            runtimeHost.getMoinInstance( );

            return runtimeHost.getMetaModelCatalog( );
        }
        return null;
    }

    /**
     * Returns the metamodel generator. This generator is able to generate
     * artifacts that are necessary for a metamodel to be run from a development
     * platform as plugin project.
     * 
     * @return the metamodel generator
     * @deprecated not officially supported! Might be removed without further
     * notice!!
     */
    @Deprecated
    public static MmGenerator getMmGenerator( ) {

        IdeRuntimeHost runtimeHost = getRuntimeHost( );
        if ( runtimeHost != null ) {
            // This call starts MOIN, if not already started.
            runtimeHost.getMoinInstance( );

            return runtimeHost.getMmGenerator( );
        }
        return null;

    }

    /**
     * Obtains the main MOIN plug-in from the Eclipse framework.
     * 
     * @return the usable MOIN Runtime Host plug-in; otherwise null (no usable
     * plug-in is found).
     */
    private static IdeRuntimeHost getRuntimeHost( ) {

        String rth = System.getProperty( "com.sap.tc.moin.rthplugin" ); //$NON-NLS-1$
        if ( rth == null || rth.length( ) == 0 ) {
            rth = IdeRuntimeHost.PLUGIN_ID;
        }
        Plugin plugin = Platform.getPlugin( rth );
//        Plugin plugin = Platform.getPlugin( IdeRuntimeHost.PLUGIN_ID );
        if ( plugin != null ) {
            if ( plugin instanceof IdeRuntimeHost ) {
                return (IdeRuntimeHost) plugin;
            }
            _log.trace( MoinSeverity.FATAL, "[MoinFactory.getMoinFrame()] Moin runtime host plug-in not usable. Moin frame not initialized." ); //$NON-NLS-1$
            return null;

        }
        _log.trace( MoinSeverity.FATAL, "[MoinFactory.getMoinFrame()] Moin runtime host plug-in not found. Moin frame not initialized." ); //$NON-NLS-1$
        return null;

    }
}
