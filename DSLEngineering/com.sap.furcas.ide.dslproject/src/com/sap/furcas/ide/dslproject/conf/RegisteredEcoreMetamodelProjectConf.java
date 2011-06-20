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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.ide.dslproject.builder.BuildHelper;
import com.sap.furcas.runtime.common.util.FileResourceHelper;

/**
 * This configuration will be used, if the wizard is used to create a FURCAS project using an already existing metamodel.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */
public class RegisteredEcoreMetamodelProjectConf extends EcoreMetaProjectConf {

    private final String metamodelURIs;

    public RegisteredEcoreMetamodelProjectConf(IProject referencedProject, String metamodelURIs, boolean autoResolve) {
        super(referencedProject, autoResolve);
        this.metamodelURIs = metamodelURIs;
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
        String[] uris = metamodelURIs.split(",");
        for (String uri : uris) {
            URI createURI = URI.createURI(uri);
            newURIs.add(createURI);
            resourceSet.getResources().add(resourceSet.getResource(createURI, true));
        }
        if (autoResolve) {
            addAllCrossReferences(resourceSet);
            newURIs.addAll(FileResourceHelper.getResourceSetAsScope(resourceSet));
        }
        return new ReferenceScopeBean(resourceSet, newURIs);
    }

    @Override
    public void configureProject(IProject project) throws CoreException {
        super.configureProject(project);
        ProjectPropertiesStorageHelper.setProperty(project, "metamodels", metamodelURIs);
    }

}
