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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.builder.BuildHelper;
import com.sap.furcas.runtime.common.util.FileResourceHelper;

/**
 * This configuration will be used, if the wizard is used to create a FURCAS project using a new metamodel.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */
public class LocalEcoreMetamodelProjectConf extends EcoreMetaProjectConf {

    private final String modelPath;

    public LocalEcoreMetamodelProjectConf(IProject referencedProject, String modelPath, boolean autoResolve) {
        super(referencedProject, autoResolve);
        this.modelPath = modelPath;
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
        newURIs.add(URI.createURI(EcorePackage.eINSTANCE.getNsURI()));

        if (autoResolve) {
            addAllCrossReferences(resourceSet);
            newURIs.addAll(FileResourceHelper.getResourceSetAsScope(resourceSet));
        }
        return new ReferenceScopeBean(resourceSet, newURIs);
    }

    @Override
    public void configureProject(IProject project) throws CoreException {
        super.configureProject(project);
        ProjectPropertiesStorageHelper.setProperty(project, "modelPath", modelPath);
    }

}
