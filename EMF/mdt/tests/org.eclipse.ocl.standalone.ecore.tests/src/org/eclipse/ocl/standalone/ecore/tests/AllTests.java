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
package org.eclipse.ocl.standalone.ecore.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;


public class AllTests extends TestCase {

    private static final String PLATFORM_PLUGIN = "platform:/plugin/"; //$NON-NLS-1$
    private static final String WORKSPACE_LOCATION =
        System.getProperty("workspace.location"); //$NON-NLS-1$
    
    static {
        configurePlatformProtocol();
        configureEMF();
        configureOCL();
    }
    
    public static Test suite() {
        TestSuite result = new TestSuite("All OCL Tests"); //$NON-NLS-1$
        
        result.addTest(org.eclipse.ocl.ecore.tests.AllTests.suite());
        
        return result;
    }
    
    private static void configureEMF() {
        //
        // configure resource factories
        //
        
        Map<String, Object> extMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
        extMap.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        extMap.put("ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$

        //
        // configure EPackages
        //
        
        // force initialization and registration of various EPackages
        org.eclipse.ocl.ecore.EcorePackage.eINSTANCE.eClass();
        
        //
        // configure URI mappings
        //
        
        Map<URI, URI> uriMap = URIConverter.URI_MAP;
        
        uriMap.put(URI.createURI(PLATFORM_PLUGIN + "org.eclipse.ocl.ecore.tests/"), //$NON-NLS-1$
            URI.createURI("file:" + WORKSPACE_LOCATION + "org.eclipse.ocl.ecore.tests/")); //$NON-NLS-1$ //$NON-NLS-2$
        uriMap.put(URI.createURI("http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore"), //$NON-NLS-1$
        	URI.createURI(PLATFORM_PLUGIN + "org.eclipse.ocl.ecore/model/oclstdlib.ecore")); //$NON-NLS-1$
    }
    
    private static void configureOCL() {
        Environment.Registry reg = Environment.Registry.INSTANCE;
        
        // register prototype environments
        EcoreEnvironment ecoreEnv = (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE
			.createEnvironment();
		reg.registerEnvironment(ecoreEnv);
        
        // register their standard library packages
		ecoreEnv.getOCLStandardLibrary();
    }
    
    private static void configurePlatformProtocol() {
        class PlatformURLConnection extends URLConnection {
            File file;
            
            PlatformURLConnection(URL url) {
                super(url);
            }
            
            @Override
            public void connect()
                throws IOException {
                
                if (file == null) {
                    String url = getURL().toString();
                    
                    if (url.startsWith(PLATFORM_PLUGIN)) {
                        String path = url.substring(PLATFORM_PLUGIN.length());
                        path = WORKSPACE_LOCATION + path;
                        
                        file = new File(path);
                    }
                }
                
                if (file == null || !file.exists()) {
                    throw new IOException("cannot connect to " + getURL()); //$NON-NLS-1$
                }
            }
            
            @Override
            public InputStream getInputStream()
                throws IOException {
                
                if (file == null) {
                    connect();
                }
                
                return new FileInputStream(file);
            }
        }
        
        URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
        
            public URLStreamHandler createURLStreamHandler(String protocol) {
                if ("platform".equalsIgnoreCase(protocol)) { //$NON-NLS-1$
                    return new URLStreamHandler() {
                    
                        @Override
                        protected URLConnection openConnection(URL u)
                            throws IOException {
                            
                            return new PlatformURLConnection(u);
                        }
                    
                    };
                }
                
                return null;
            }});
    }
}
