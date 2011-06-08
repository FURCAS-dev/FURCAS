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
package com.sap.furcas.runtime.common.util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;


public class FileResourceHelper {
    
    public static ResourceSet loadResourceSet(File... fileArr) throws MetaModelLookupException {
        ResourceSet resourceSet = new ResourceSetImpl();
        return loadResourceSet(resourceSet, fileArr);
    }
    
    public static ResourceSet loadResourceSet(ResourceSet resourceSet, File... fileArr) throws MetaModelLookupException {
        for (File file : fileArr) {
            java.net.URI uri = file.toURI();
            java.net.URI normUri = uri.normalize();

            loadResourceFromUri(resourceSet, normUri.toString());
        }
        return resourceSet;
    }

    private static void loadResourceFromUri(ResourceSet resourceSet, String uri) throws MetaModelLookupException {
        Resource resource = resourceSet.createResource(URI.createURI(uri));

        try {
            resource.load(null);
            checkForErrors(resource);
        } catch (IOException e) {
            throw new MetaModelLookupException("Unable to parse ecore xmi for file uri " + uri + " : " + e.getMessage(), e);
        }
        EList<EObject> list = resource.getContents();
        for (EObject object : list) {
            if (object instanceof EPackage) {
                EPackage new_package = (EPackage) object;
                EPackage.Registry.INSTANCE.put(new_package.getNsURI(), new_package);
            }
        }
    }

    private static void checkForErrors(Resource resource) {
        if (resource.getErrors().size() > 0) {
            StringBuilder buff = new StringBuilder();
            for (Diagnostic err : resource.getErrors()) {
                buff.append(err.getMessage() + "\n");
            }
            throw new RuntimeException("Loaded resource contains errors: \n" + buff.toString());
        }
    }
    
    public static Set<URI> getResourceSetAsScope(ResourceSet resourceSet) {
        Set<URI> referenceScope = new HashSet<URI>();
        for (Resource resource : resourceSet.getResources()) {
            referenceScope.add(resource.getURI());
        }
        return referenceScope;
    }
}
