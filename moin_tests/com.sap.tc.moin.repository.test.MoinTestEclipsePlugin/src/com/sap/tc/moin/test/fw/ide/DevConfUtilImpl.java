package com.sap.tc.moin.test.fw.ide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.lib.api.util.DiiModelService;
import com.sap.ide.dii05.model.api.IComponentModel;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;


@SuppressWarnings( "nls" )
public class DevConfUtilImpl implements DevConfUtil {

    /** *********** Internals *********************************************** */

    private IdeRuntimeTestHelper _ideTestHelper;

    /** *********** Construction ******************************************** */

    public DevConfUtilImpl( IdeRuntimeTestHelper ideRuntimeTestHelper ) {

        _ideTestHelper = ideRuntimeTestHelper;
    }

    /** *********** API ***************************************************** */

// The DevConfigFile (devConfigTemplateFileName) must be located in the folder PLUGIN_RESOURCES_FOLDER of the current plugin.
    // It can be created in the Di Perspective in NWDS by creating a local DevConfig from scratch and then exporting the DevConfig.
    public IDevelopmentConfiguration importDevConfigFromFile( String idOfPluginContainingTemplates, String devConfigTemplateFileName, String devConfigName ) throws Exception {

        String pluginRelativePath = _ideTestHelper.getFileUtil( ).PLUGIN_RESOURCES_FOLDER + devConfigTemplateFileName;
        InputStream in = _ideTestHelper.getFileUtil( ).getInputStreamForFileInSamePlugin( idOfPluginContainingTemplates, pluginRelativePath );
        // - DevConfig destination folder structure:
        IDevelopmentConfiguration localDefaultDevConfig = getLocalConfiguration( );
        String localDevConfigPath = localDefaultDevConfig.getLocalRoot( );
        String[] splittedPath = localDevConfigPath.split( _ideTestHelper.getDevConfUtil( ).LOCAL_DEV_CONFIG_ROOT_FOLDER );
        String newDevConfigPath = splittedPath[0] + devConfigName;
        if ( !( new File( newDevConfigPath ) ).mkdirs( ) ) {
            File ppFolder = new File( newDevConfigPath );
            if ( !ppFolder.exists( ) ) {
                throw new IllegalStateException( "Path for DevConfig could not be created: " + newDevConfigPath );
            }
        }
        // - DevConfig destination file:
        String newDevConfigDefinitionFilePath = newDevConfigPath + File.separator + devConfigTemplateFileName;
        File newDevConfigFile = new File( newDevConfigDefinitionFilePath );
        OutputStream out = new FileOutputStream( newDevConfigFile );
        _ideTestHelper.getFileUtil( ).copyFile( in, out );

        // Import the DevConfig by Dii05:
        JdiJob jdiJob = DiiCommandFactory.forDevelopmentConfiguration( ).create_ImportDevelopmentConfigurationJob( newDevConfigDefinitionFilePath );
        IStatus status = JobUtil.syncExec( jdiJob, IdeRuntimeTestHelper.NO_PROGRESS_MONITOR );
        if ( !status.isOK( ) ) {
            throw new Exception( "The test local development configuration could not be imported from file: " + devConfigName );
        }

        int importId = -1;
        IDevelopmentConfiguration devConfig = null;
        for ( IDevelopmentConfiguration devConf : getDevelopmentConfigurations( devConfigName ) ) {
            if ( Integer.valueOf( devConf.getImportId( ) ) > importId ) {
                importId = Integer.valueOf( devConf.getImportId( ) );
                devConfig = devConf;
            }
        }

        if ( devConfig == null ) {
            throw new Exception( "Test DevelopmentConfiguation could not be retrieved from Dii05: " + devConfigName );
        }

        return devConfig;
    }

    public IDevelopmentConfiguration getDevelopmentConfiguration( final String devConfigName ) {

        // Look up the list of all available development configurations (imported or local):
        List<IDevelopmentConfiguration> devConfList = DiiModelService.getComponentModel( ).getDevelopmentConfigurations( );
        for ( IDevelopmentConfiguration availableDevConf : devConfList ) {
            // ImportID is unique over all imports of same or different DevConfigs
            if ( devConfigName.equals( availableDevConf.getName( ) ) ) {
                return availableDevConf;
            }
        }
        return null; // not found
    }

    public List<IDevelopmentConfiguration> getDevelopmentConfigurations( final String devConfigName ) {

        // Look up the list of all available development configurations (imported or local):
        List<IDevelopmentConfiguration> devConfList = DiiModelService.getComponentModel( ).getDevelopmentConfigurations( );
        List<IDevelopmentConfiguration> result = new ArrayList<IDevelopmentConfiguration>( );
        for ( IDevelopmentConfiguration availableDevConf : devConfList ) {
            // ImportID is unique over all imports of same or different DevConfigs
            if ( devConfigName.equals( availableDevConf.getName( ) ) ) {
                result.add( availableDevConf );
            }
        }
        return result;
    }

    /**
     * Returns the instance for first found local configuration (this is
     * realized the same way in MIE Dc-Framework).
     */
    @SuppressWarnings( "unchecked" )
    public IDevelopmentConfiguration getLocalConfiguration( ) throws CoreException {

        IComponentModel model = DiiModelService.getComponentModel( );
        List<IDevelopmentConfiguration> configs = model.getDevelopmentConfigurations( );
        for ( IDevelopmentConfiguration configuration : configs ) {
            if ( _ideTestHelper.getDevConfUtil( ).NAME_OF_LOCAL_DEV_CONFIG.equals( configuration.getName( ) ) ) {
                return configuration;
            }
        }

        String msg = "Could not find the configuration '" + _ideTestHelper.getDevConfUtil( ).NAME_OF_LOCAL_DEV_CONFIG + "' for local DCs. " + "Check if you have installed the Archive Pool (AP) Feature.";
        IStatus status = new Status( IStatus.ERROR, "com.sap.tc.moin.testfw.epi", msg );
        throw new CoreException( status );
    }



}
