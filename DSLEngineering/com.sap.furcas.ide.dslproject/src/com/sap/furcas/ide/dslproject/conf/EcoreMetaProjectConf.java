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

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.ide.dslproject.builder.BuildHelper;
import com.sap.furcas.runtime.common.util.FileResourceHelper;
import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;

/**
 * Configures a project to use an ecore metamodel as reference.
 * 
 *  @author Frederik Petersen (D054528)
 */
public final class EcoreMetaProjectConf implements IProjectMetaRefConf {

    /** The referenced project. */
    private final IProject referencedProject;
    private final String metamodelURIs;
    private final String modelPath;
    private final boolean autoResolve;

    /**
     * Instantiates a new ecore meta project conf.
     * 
     * @param referencedProject
     *            the referenced project
     * 
     * @throws CoreException
     *             the core exception
     */
    public EcoreMetaProjectConf(IProject referencedProject, String modelPath, String metamodelURIs, boolean autoResolve) {
        this.referencedProject = referencedProject;
        this.metamodelURIs = metamodelURIs;
        this.modelPath = modelPath;
        this.autoResolve = autoResolve;
    }

    /**
     * Gets the configuration from project.
     * 
     * @param project
     *            the project
     * 
     * @return the configuration from project
     * 
     * @throws CoreException
     *             the core exception
     */
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
        return new EcoreMetaProjectConf(referencedProject, modelPath, metamodelURIs, autoResolve);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#configureProject(org.eclipse.core.resources.IProject)
     */
    @Override
    public void configureProject(IProject project) throws CoreException {
        ProjectPropertiesStorageHelper.setProperty(project, Constants.REFERRED_PROJECT_NAME_KEY, referencedProject.getName());
        ProjectPropertiesStorageHelper.setProperty(project, "metamodels", metamodelURIs+",http://www.eclipse.org/emf/2002/Ecore");
        ProjectPropertiesStorageHelper.setProperty(project, "modelPath", modelPath);
        ProjectPropertiesStorageHelper.setProperty(project, "autoResolve", Boolean.toString(autoResolve));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#getMetaLookUpForProject()
     */
    @Override
    public ReferenceScopeBean getMetaLookUpForProject() {
        HashSet<URI> newURIs = null;
        newURIs = new HashSet<URI>();
        ResourceSet resourceSet = BuildHelper.getResourceSetForProject(referencedProject);
        if (!modelPath.matches("")) {
            resourceSet = new ResourceSetImpl();
            String uri = URI.createPlatformResourceURI(modelPath, true).toString();
            Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(modelPath, true));
            Map<Object, Object> options = new HashMap<Object, Object>();
            options.put(XMLResource.OPTION_ENCODING, "UTF-8");
            try {
                resource.load(options);
                newURIs.add(resource.getURI());
            } catch (IOException e) {
                Activator.logger.logError("Error loading resource: " + resource.getURI(), e);
            }
            EList<EObject> list = resource.getContents();
            for (EObject object : list) {
                if (object instanceof EPackage) {
                    EPackage new_package = (EPackage) object;
                    EPackage.Registry.INSTANCE.put(uri, new_package);
                }
            }

        } else {
            String[] uris = metamodelURIs.split(",");
            for (String uri : uris) {
                URI createURI = URI.createURI(uri);
                newURIs.add(createURI);
                resourceSet.getResources().add(resourceSet.getResource(createURI, true));
            }
        }
        if (autoResolve) {
            addAllCrossReferences(resourceSet);
            newURIs.addAll(FileResourceHelper.getResourceSetAsScope(resourceSet));
        }
        return new ReferenceScopeBean(resourceSet, newURIs);
    }

    private void addAllCrossReferences(ResourceSet resourceSet) {
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

    /**
     * Gets the ref project name.
     * 
     * @return the ref project name
     */
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
