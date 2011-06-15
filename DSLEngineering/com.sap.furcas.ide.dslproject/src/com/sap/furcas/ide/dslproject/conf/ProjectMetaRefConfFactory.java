package com.sap.furcas.ide.dslproject.conf;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;

/**
 * Maintains a compile time mapping between id and implementing classes of IProjectMetaRefConf.
 * 
 * @author C5107456
 */
public class ProjectMetaRefConfFactory {


    private static final String ECORE_METAMODEL_CONF = "ecoreMetamodel";

    /**
     * Gets the config.
     * 
     * @param project
     *            the project
     * 
     * @return a config or null if none is configured
     * 
     * @throws CoreException
     *             if the project contains no or unknown Ids for what configuration class to use.
     */
    public static IProjectMetaRefConf getConfig(IProject project) throws CoreException {
        String value = ProjectPropertiesStorageHelper.getProperty(project, Constants.PROJECT_METAREF_PROPERTY);
        //check ecore confs
        if (ECORE_METAMODEL_CONF.equals(value)) {
            return EcoreMetaProjectConf.getConfigurationFromProject(project);
        } else if (value == null || value.trim().equals("")) {
            return null;
        } else {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus("Project property "
                    + Constants.PROJECT_METAREF_PROPERTY + " contained unknown value " + value, Activator.PLUGIN_ID));
        }
    }

    /**
     * configures the project using this configuration, and makes sure this configuration class can be retrieved again using the
     * getConfig method.
     * 
     * @param project
     *            the project
     * @param conf
     *            the conf
     * 
     * @throws CoreException
     *             if an unknown implementation of IProjectMetaRefConf is passed
     */
    public static void configure(IProject project, IProjectMetaRefConf conf) throws CoreException {
        //check ecore confs
        if (conf instanceof EcoreMetaProjectConf) {
            ProjectPropertiesStorageHelper.setProperty(project, Constants.PROJECT_METAREF_PROPERTY, ECORE_METAMODEL_CONF);
        } else {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus("Unknown IProjectMetaRefConf implementation: "
                    + conf.getClass().getName(), Activator.PLUGIN_ID));
        }
        conf.configureProject(project);
    }

    /**
     * for cleanup of project properties.
     * 
     * @param project
     *            the project
     * 
     * @throws CoreException
     *             the core exception
     */
    public static void removeConfiguration(IProject project) throws CoreException {
        ProjectPropertiesStorageHelper.removeProperties(project, Constants.PROJECT_METAREF_PROPERTY);

    }

}
