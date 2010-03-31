/*
 * (C) Copyright 2002-2006 SAP AG. All rights reserved. Created 10.07.2006,
 * 16:47:46 Author D039596
 */
package com.sap.tc.moin.test.fw.ide;

import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sap.ide.dii05.lib.api.namereservation.NameReservationCategory;
import com.sap.ide.dii05.lib.api.util.DiiLibraryException;
import com.sap.ide.dii05.lib.api.util.DiiModelService;
import com.sap.ide.dii05.lib.internal.DiiLibraryPlugin;
import com.sap.ide.dii05.lib.internal.StatusWithResult;
import com.sap.ide.dii05.lib.internal.commands.UpdateComponentModelChildrenUiJob;
import com.sap.ide.dii05.lib.internal.namereservation.DiiNameReservationServiceImpl;
import com.sap.ide.dii05.lib.internal.util.JdkUtil;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.ui.internal.DiiUiPlugin;
import com.sap.ide.dii05.ui.internal.devconf.wizard.LoginUIElement;
import com.sap.ide.dii05.ui.internal.devconf.wizard.WizardHelper;
import com.sap.ide.dii05.ui.internal.preference.DevConfPreferencePage;
import com.sap.ide.dii05.ui.internal.sld.SldContext;
import com.sap.ide.dii05.util.DiiConstants;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.ide.dii05.util.api.job.SuspendedException;
import com.sap.ide.dii05.util.api.log.LogManager;
import com.sap.ide.dii05.util.api.misc.DiiUtilException;
import com.sap.ide.login.manage.AuthorizationData;
import com.sap.ide.login.manage.LoginManager;
import com.sap.ide.login.ping.IPingStatus;

/**
 * The class is intendently not public, because it should only be used in
 * DiTrackUtil.
 * <p>
 * Remark: Coding is copied from Dii05.
 */
@SuppressWarnings( "nls" )
class DevConfImportUtil {

    /**
     * set the URL for landscape Directory. If these preference is not setted,
     * then import od sevelopment configuration of SLD is not possible
     */
    public static void setLandscapeDirectoryUrl( String url ) {

        DevConfPreferencePage.setDevConfPoolURL( url );
    }

    /**
     * UI free import of development configuration from Landscape Directory
     * 
     * @param remoteName internal name of remote development Configuration
     * @param uiName name of development configuration, that can be shown in UI
     * @param loginData user and password pair
     */
    public static IStatus importDevelopmentConfiguration( final String remoteName, final String uiName, final AuthorizationData loginData ) {

        if ( !LoginManager.getManager( ).getOnlineStatus( SldContext.getSingelton( ) ).isOnline( ) ) {
            IStatus onlinestatus = SldContext.getSingelton( ).setOnline( loginData, new NullProgressMonitor( ) );
            if ( !onlinestatus.isOK( ) ) {
                return onlinestatus;
            }
        }
        final WizardHelper helper = new WizardHelper( new LoginUIElement( ) );
        helper.setName( uiName );
        JdiJob job = new JdiJob( "Importing Development Configuration", JdiJob.DO_NOT_WRAP_IN_WORKSPACE_RUNNABLE ) {

            @Override
            protected IStatus doInWorkerThread( IProgressMonitor monitor ) {

                try {
                    IStatus status = helper.setStream( SldContext.getSingelton( ).getDevConfStream( remoteName ) );
                    if ( !status.isOK( ) ) {
                        LogManager.log( status );
                    }
                } catch ( Exception e ) {
                    return LogManager.createCaughtStatus( e, "Reading Configuration InputStream failed", helper );
                }
                IPingStatus pingStatus = helper.canGetOnline( loginData, new NullProgressMonitor( ) );
                if ( !pingStatus.isOK( ) ) {
                    return pingStatus;
                }
                IStatus status = helper.addDevConf( new NullProgressMonitor( ), true, null );
                if ( status.getSeverity( ) != IStatus.ERROR ) {
                    helper.persistLoginData( );
                }
                return status;
            }
        };
        try {
            JobUtil.syncExec( job, new NullProgressMonitor( ) );
        } catch ( SuspendedException e1 ) {
            return e1.getStatus( );
        } catch ( DiiUtilException e1 ) {
            return e1.getStatus( );
        } catch ( OperationCanceledException e1 ) {
            return Status.CANCEL_STATUS;
        }
        final JdiJob changeDtrClientJob = new JdiJob( "Set active DTR client", false ) {

            @Override
            protected IStatus doInWorkerThread( IProgressMonitor monitor1 ) {

                helper.changeDtrClient( );
                return Status.OK_STATUS;
            }

        };
        UpdateComponentModelChildrenUiJob updateJob = new UpdateComponentModelChildrenUiJob( null, DiiModelService.getComponentModel( ), DiiLibraryPlugin.getPlugin( ).getDevConfManager( ).getDevConfFolders( ) );
        updateJob.addJobChangeListener( new JobChangeAdapter( ) {

            @Override
            public void done( IJobChangeEvent event ) {

                changeDtrClientJob.schedule( );
                // look for default JDK prefs
                adaptJdkSettings( );

            }

            private void adaptJdkSettings( ) {

                IPreferenceStore preferenceStore = DiiUiPlugin.getPlugin( ).getPreferenceStore( );
                String defaultJdk = preferenceStore.getString( JdkUtil.DEFAULT_JDK );
                String defaultSourceCompliance = preferenceStore.getString( JdkUtil.DEFAULT_SOURCE_COMPLIANCE_JDK );
                String defaultTargetCompliance = preferenceStore.getString( JdkUtil.DEFAULT_TARGET_COMPLIANCE_JDK );
                if ( !DiiConstants.EMPTY_STRING.equals( defaultJdk ) || !DiiConstants.EMPTY_STRING.equals( defaultSourceCompliance ) || !DiiConstants.EMPTY_STRING.equals( defaultTargetCompliance ) ) {
                    List developmentConfigurations = DiiModelService.getComponentModel( ).getDevelopmentConfigurations( );
                    String jdiRoot = helper.getLocalRoot( );
                    jdiRoot = jdiRoot.substring( 0, jdiRoot.length( ) - 1 );
                    if ( jdiRoot == null ) {
                        return;
                    }
                    IDevelopmentConfiguration devconf = DiiLibraryPlugin.getPlugin( ).getDevConfManager( ).findDevelopmentConfiguration( jdiRoot );
                    if ( devconf != null ) {
                        Properties props = new Properties( );
                        if ( !DiiConstants.EMPTY_STRING.equals( defaultJdk ) ) {
                            props.setProperty( JdkUtil.JDK_PATH_KEY, defaultJdk );
                        }
                        if ( !DiiConstants.EMPTY_STRING.equals( defaultSourceCompliance ) ) {
                            props.setProperty( JdkUtil.JDK_SOURCE_COMPLIANCE_KEY, defaultSourceCompliance );
                        }
                        if ( !DiiConstants.EMPTY_STRING.equals( defaultTargetCompliance ) ) {
                            props.setProperty( JdkUtil.JDK_TARGET_COMPLIANCE_KEY, defaultTargetCompliance );
                        }
                        JdkUtil.saveProperties( props, devconf );
                    }
                }
            }

        } );
        try {
            JobUtil.syncExec( updateJob, null );
        } catch ( SuspendedException e1 ) {
            return e1.getStatus( );
        } catch ( DiiUtilException e1 ) {
            return e1.getStatus( );
        } catch ( OperationCanceledException e1 ) {
            return Status.CANCEL_STATUS;
        }
        new JdiJob( "Reading DC Prefixes", false ) {

            @Override
            protected IStatus doInWorkerThread( IProgressMonitor monitor ) {

                try {
                    if ( helper.getLocalRoot( ) != null ) {
                        IDevelopmentConfiguration config = DiiLibraryPlugin.getPlugin( ).getDevConfManager( ).findDevelopmentConfiguration( new File( helper.getLocalRoot( ) ).getCanonicalPath( ) );
                        if ( config != null ) {
                            DiiNameReservationServiceImpl.getPrefixes( NameReservationCategory.DEVELOPMENT_COMPONENT, config );
                            DiiNameReservationServiceImpl.getPrefixes( NameReservationCategory.PACKAGE, config );
                        }
                    }
                } catch ( DiiLibraryException e ) {
                    LogManager.log( e.getStatus( ) );
                } catch ( IOException e ) {
                    LogManager.log( new Status( IStatus.WARNING, DiiUiPlugin.PLUGIN_ID, 0, "Could not cache DC prefixes", e ) );
                }
                monitor.done( );
                return Status.OK_STATUS;
            }

        }.schedule( );
        IDevelopmentConfiguration result = findConfiguration( helper );
        if ( result != null ) {
            StatusWithResult statusWithResult = new StatusWithResult( 0, "OK", null );
            statusWithResult.setResult( result );
            return statusWithResult;
        }
        return new Status( IStatus.ERROR, DiiUiPlugin.PLUGIN_ID, 0, "configuration import failed", null );
    }

    private static IDevelopmentConfiguration findConfiguration( WizardHelper helper ) {

        String jdiRoot = helper.getLocalRoot( );
        if ( jdiRoot == null ) {
            return null;
        }
        jdiRoot = jdiRoot.substring( 0, jdiRoot.length( ) - 1 );
        return DiiLibraryPlugin.getPlugin( ).getDevConfManager( ).findDevelopmentConfiguration( jdiRoot );
    }

    public static IDevelopmentConfiguration importDevConfiguration( DiiContext context ) throws Exception {

        DevConfImportUtil.setLandscapeDirectoryUrl( context.getSldUrl( ) );
        final AuthorizationData data = new AuthorizationData( context.getUserName( ), context.getPassword( ), null );
        IStatus importState = DevConfImportUtil.importDevelopmentConfiguration( context.getConfigurationName( ), context.getConfigurationName( ), data );
        if ( !importState.isOK( ) ) {
            Throwable exception = importState.getException( );
            throw new Exception( exception );
        }
        if ( importState instanceof StatusWithResult ) {
            context.setDevelopmentConfiguration( (IDevelopmentConfiguration) ( (StatusWithResult) importState ).getResult( ) );
            return context.getDevelopmentConfiguration( );
        }
        return null;
    }

    /**
     * Import Devlopment Configuration from SLD SLD should be configured by
     * setLandscapeDirectoryUrl()
     * 
     * @param internalName - name of dev configuration on SLD
     * @param displayName - name to be displayed in UI
     * @param user , password - user identification data
     * @param keyStore - have to be null if no SSL is configured for the servers
     */
    public static IDevelopmentConfiguration importDevConfiguration( String internalName, String displayName, String user, String password, KeyStore keyStore ) {

        final AuthorizationData data = new AuthorizationData( user, password, keyStore );
        IStatus importState = DevConfImportUtil.importDevelopmentConfiguration( internalName, displayName, data );
        if ( !importState.isOK( ) ) {
            System.err.println( importState );
            return null;
        }
        List devConfigurations = DiiLibraryPlugin.getPlugin( ).getComponentModel( ).getDevelopmentConfigurations( );

        for ( Iterator iter = devConfigurations.iterator( ); iter.hasNext( ); ) {
            IDevelopmentConfiguration config = (IDevelopmentConfiguration) iter.next( );
            if ( internalName.equals( config.getSlLocation( ) ) && config.isLocal( ) ) {
                return config;
            }
        }
        return null;
    }

}
