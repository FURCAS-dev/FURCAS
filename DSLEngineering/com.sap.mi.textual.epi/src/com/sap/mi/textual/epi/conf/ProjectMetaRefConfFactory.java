package com.sap.mi.textual.epi.conf;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;
import com.sap.mi.textual.epi.Activator;
import com.sap.mi.textual.epi.Constants;


/**
 * Maintains a compile time mapping between id and implementing classes of IProjectMetaRefConf.
 * 
 * @author C5107456
 */
public class ProjectMetaRefConfFactory {
	
	/** The Constant DEPLOYED_METAMODEL_CONF. */
	private static final String DEPLOYED_METAMODEL_CONF = "deployedMetamodel";
	
	/** The Constant OPEN_MOF14_METAMODEL_CONF. */
	private static final String OPEN_MOF14_METAMODEL_CONF = "openMof14Metamodel";

	/**
	 * Gets the config.
	 * 
	 * @param project the project
	 * 
	 * @return a config or null if none is configured
	 * 
	 * @throws CoreException if the project contains no or unknown Ids for what configuration class to use.
	 */
	public static IProjectMetaRefConf getConfig(IProject project) throws CoreException {
		String value = ProjectPropertiesStorageHelper.getProperty(project, Constants.PROJECT_METAREF_PROPERTY);
		if (DEPLOYED_METAMODEL_CONF.equals(value)) {
			return DeployedMetaProjectConf.getConfigurationFromProject(project);
		} else if(OPEN_MOF14_METAMODEL_CONF.equals(value)) {
			return OpenMOF14MetaProjectConf.getConfigurationFromProject(project);
//	      } else if(ECORE_METAMODEL_CONF.equals(value)) {
//	            return EcoreMetaProjectConf.getConfigurationFromProject(project);
		} else if (value == null || value.trim().equals("")) {
			return null;
		} else {
			throw new CoreException(EclipseExceptionHelper.getErrorStatus( "Project property " + Constants.PROJECT_METAREF_PROPERTY + " contained unknown value " + value,  Activator.PLUGIN_ID));
		}
	}

	/**
	 * configures the project using this configuration, and makes sure this configuration class can be retrieved again using the getConfig method.
	 * 
	 * @param project the project
	 * @param conf the conf
	 * 
	 * @throws CoreException if an unknown implementation of IProjectMetaRefConf is passed
	 */
	public static void configure(IProject project, IProjectMetaRefConf conf) throws CoreException {
		if (conf instanceof DeployedMetaProjectConf) {
			ProjectPropertiesStorageHelper.setProperty(project, Constants.PROJECT_METAREF_PROPERTY, DEPLOYED_METAMODEL_CONF);
		} else if (conf instanceof OpenMOF14MetaProjectConf) {
		    ProjectPropertiesStorageHelper.setProperty(project, Constants.PROJECT_METAREF_PROPERTY, OPEN_MOF14_METAMODEL_CONF);
//		} else if (conf instanceof EcoreMetaProjectConf) {
//		    ProjectPropertiesStorageHelper.setProperty(project, Constants.PROJECT_METAREF_PROPERTY, ECORE_METAMODEL_CONF);
		} else {
		    throw new CoreException(EclipseExceptionHelper.getErrorStatus( "Unknown IProjectMetaRefConf implementation: " + conf.getClass().getName(), Activator.PLUGIN_ID));
		}
		conf.configureProject(project);
	}
	
	/**
	 * for cleanup of project properties.
	 * 
	 * @param project the project
	 * 
	 * @throws CoreException the core exception
	 */
	public static void removeConfiguration(IProject project) throws CoreException {
		ProjectPropertiesStorageHelper.removeProperties(project, Constants.PROJECT_METAREF_PROPERTY);
		
	}
	
}
