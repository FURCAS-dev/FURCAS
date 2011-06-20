/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.dslproject.conf;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;

/**
 * Configures a project to use an ecore metamodel as reference.
 * 
 * @author Frederik Petersen (D054528)
 */
public abstract class EcoreMetaProjectConf implements IProjectMetaRefConf {

    protected final IProject referencedProject;
    protected final boolean autoResolve;

    public EcoreMetaProjectConf(IProject referencedProject, boolean autoResolve) {
        this.referencedProject = referencedProject;
        this.autoResolve = autoResolve;
    }

    public static EcoreMetaProjectConf getConfigurationFromProject(IProject project) throws CoreException {
        String projectName = ProjectPropertiesStorageHelper.getProperty(project, Constants.REFERRED_PROJECT_NAME_KEY);
        String metamodelURIs = ProjectPropertiesStorageHelper.getProperty(project, "metamodels");
        String modelPath = ProjectPropertiesStorageHelper.getProperty(project, "modelPath");
        boolean autoResolve = Boolean.parseBoolean(ProjectPropertiesStorageHelper.getProperty(project, "autoResolve"));

        if (projectName == null || projectName.trim().equals("")) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus("Project " + project.getName()
                    + " not configured for use with " + EcoreMetaProjectConf.class.getName(), Activator.PLUGIN_ID));
        }
        IProject referencedProject = project.getWorkspace().getRoot().getProject(projectName);
        if (referencedProject == null) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus("Referenced Project " + projectName
                    + " does not exist in Workspace.", Activator.PLUGIN_ID));
        }
        if (modelPath == null & metamodelURIs != null) {
            return new RegisteredEcoreMetamodelProjectConf(referencedProject, metamodelURIs, autoResolve);
        } else if (metamodelURIs == null & modelPath != null) {
            return new LocalEcoreMetamodelProjectConf(referencedProject, modelPath, autoResolve);
        } else {
            throw new CoreException(
                    EclipseExceptionHelper.getErrorStatus(
                            "The dslEngineering.properties file in Project "
                                    + project.getName()
                                    + " contains the properties metamodels and modelPath. However only one of these properties is allowed to exist. Please remove the empty one from the file.",
                            Activator.PLUGIN_ID));
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#configureProject(org.eclipse.core.resources.IProject)
     */
    @Override
    public void configureProject(IProject project) throws CoreException {
        ProjectPropertiesStorageHelper.setProperty(project, Constants.REFERRED_PROJECT_NAME_KEY, referencedProject.getName());
        ProjectPropertiesStorageHelper.setProperty(project, "autoResolve", Boolean.toString(autoResolve));
    }

    protected void addAllCrossReferences(ResourceSet resourceSet) {
        Set<Resource> externalResources = new HashSet<Resource>();
        Set<Resource> newResources = new HashSet<Resource>();
        Set<Resource> resourcesToCheckForCrossReferences = new HashSet<Resource>();

        resourcesToCheckForCrossReferences.addAll(resourceSet.getResources());
        do {
            for (EObject obj : EcoreUtil.ExternalCrossReferencer.find(resourcesToCheckForCrossReferences).keySet()) {
                Resource externalResource = obj.eResource();
                if (externalResource != null) {
                    externalResources.add(externalResource);
                    newResources.add(externalResource);
                }
            }
            resourcesToCheckForCrossReferences.clear();
            resourcesToCheckForCrossReferences.addAll(newResources);
            newResources.clear();
        } while (resourcesToCheckForCrossReferences.size() != 0);

        resourceSet.getResources().addAll(externalResources);
    }

    public String getRefProjectName() {
        return referencedProject.getName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EcoreMetaProjectConf) {
            EcoreMetaProjectConf other = (EcoreMetaProjectConf) obj;
            if (other.referencedProject.equals(this.referencedProject)) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return referencedProject.hashCode();
    }

}
