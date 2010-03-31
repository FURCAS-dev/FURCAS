package com.sap.tc.moin.test.fw.ide;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;


@SuppressWarnings( "nls" )
public interface DevConfUtil {

    static final String NAME_OF_LOCAL_DEV_CONFIG = "LocalDevelopment"; //$NON-NLS-1$

    static final String LOCAL_DEV_CONFIG_ROOT_FOLDER = "LocalDevelopment"; //$NON-NLS-1$

    // The DevConfigFile (devConfigTemplateFileName) must be located in the folder PLUGIN_RESOURCES_FOLDER of the current plugin.
    // It can be created in the Di Perspective in NWDS by creating a local DevConfig from scratch and then exporting the DevConfig.
    IDevelopmentConfiguration importDevConfigFromFile( String idOfPluginContainingTemplates, String devConfigTemplateFileName, String devConfigName ) throws Exception;

    IDevelopmentConfiguration getDevelopmentConfiguration( String devConfigName );

    List<IDevelopmentConfiguration> getDevelopmentConfigurations( String devConfigName );

    /**
     * Returns the instance for first found local configuration (this is
     * realized the same way in MIE Dc-Framework).
     */
    @SuppressWarnings( "unchecked" )
    IDevelopmentConfiguration getLocalConfiguration( ) throws CoreException;

}
