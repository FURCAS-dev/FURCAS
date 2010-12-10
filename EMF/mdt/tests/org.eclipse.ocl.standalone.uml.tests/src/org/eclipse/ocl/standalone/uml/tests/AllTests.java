/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 242236
 *
 * </copyright>
 *
 * $Id: AllTests.java,v 1.7 2009/08/25 20:45:17 ewillink Exp $
 */
package org.eclipse.ocl.standalone.uml.tests;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
//import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

@SuppressWarnings("nls")
public class AllTests extends TestCase {

    private static final String WORKSPACE_LOCATION = System.getProperty("workspace.location");
    private static final String PLATFORM_PLUGIN = "file:" + WORKSPACE_LOCATION + File.separator + "EMF" + File.separator + "mdt"
            + File.separator + "plugins" + File.separator;

    static {
        configureEMF();
    }

    public static Test suite() {
        TestSuite result = new TestSuite("All UML Tests");
        result.addTest(org.eclipse.ocl.uml.tests.AllTests.suite());
        return result;
    }

    private static void configureEMF() {
        //
        // configure resource factories
        //

        Map<String, Object> extMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
        extMap.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        extMap.put("uml", UMLResource.Factory.INSTANCE);

        //
        // configure EPackages
        //

        // Map<String, Object> pkgReg = EPackage.Registry.INSTANCE;
        // extra mapping for UML backward compatibility
        // pkgReg.put("http://www.eclipse.org/uml2/2.0.0/UML", UMLPackage.eINSTANCE);
        // force initialization and registration of various EPackages
        // org.eclipse.ocl.uml.UMLPackage.eINSTANCE.eClass();

        //
        // configure URI mappings
        //

        Map<URI, URI> uriMap = URIConverter.URI_MAP;

        uriMap.put(URI.createURI(PLATFORM_PLUGIN + "org.eclipse.ocl.ecore.tests/"),
                URI.createURI("file:" + WORKSPACE_LOCATION + "org.eclipse.ocl.ecore.tests/"));
        uriMap.put(URI.createURI(PLATFORM_PLUGIN + "org.eclipse.ocl.uml.tests/"),
                URI.createURI("file:" + WORKSPACE_LOCATION + "org.eclipse.ocl.uml.tests/"));
        uriMap.put(URI.createURI("http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore"),
                URI.createURI(PLATFORM_PLUGIN + "org.eclipse.ocl.ecore/model/oclstdlib.ecore"));
        uriMap.put(URI.createURI("http://www.eclipse.org/ocl/1.1.0/oclstdlib.uml"),
                URI.createURI(PLATFORM_PLUGIN + "org.eclipse.ocl.uml/model/oclstdlib.uml"));

        String umlResources = "jar:file:" + getUMLResourcesJar() + "!";
        uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), URI.createURI(umlResources + "/libraries/"));
        uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), URI.createURI(umlResources + "/metamodels/"));
        uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), URI.createURI(umlResources + "/profiles/"));
    }

    private static String getUMLResourcesJar() {
        File targetDir = new File(System.getProperty("eclipse.location"));
        File result = findFile(targetDir, new FilenameFilter() {

            public boolean accept(File dir, String name) {
                return name.startsWith("org.eclipse.uml2.uml.resources_") && name.endsWith(".jar");
            }
        });

        assertNotNull(result);
        return result.getAbsolutePath();
    }

    private static File findFile(File dir, FilenameFilter filter) {
        File[] contents = dir.listFiles(filter);
        if ((contents != null) && (contents.length > 0)) {
            return contents[0];
        }

        File[] subdirs = dir.listFiles(new FileFilter() {

            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subdirs != null) {
            for (File sub : subdirs) {
                File result = findFile(sub, filter);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }
}
