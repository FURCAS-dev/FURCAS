/*******************************************************************************
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.modelregistry;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.examples.modelregistry.standalone.ModelFileResolver;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaProjectHandle;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaModelRegistryEnvironment;

public abstract class ModelRegistryTestCase extends TestCase
{
	public class TestEnvironment extends JavaModelRegistryEnvironment
	{
		@Override public void logTheError(String string, Throwable e) {
			if ((expectedErrors != null) && expectedErrors.contains(string))
				expectedErrors.remove(string);
			else {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				pw.println(string);
				if (e != null)
					e.printStackTrace(pw);
				fail(sw.toString());
			}
		}		
	}
	
	/**
	 * The TestModelFileResolver initialises the test ResourceSEt to use
	 * Ecore and EMOF content types and suppresses all extensions.
	 */
	public static class TestModelFileResolver extends ModelFileResolver
	{
		private TestModelFileResolver(JavaProjectHandle projectHandle, File file) throws IOException {
			super(projectHandle, file);
		}

		@Override
		protected ResourceSet initialiseResourceSet(ResourceSet resourceSet) {
			super.initialiseResourceSet(resourceSet);
			Map<String, Object> contentTypeToFactoryMap = resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap();
			EList<ContentHandler> contentHandlers = resourceSet.getURIConverter().getContentHandlers();
			Resource.Factory ecoreResourceFactory = new XMIResourceFactoryImpl();
			Resource.Factory emofResourceFactory = new EMOFResourceFactoryImpl();
			contentTypeToFactoryMap.put(EcorePackage.eCONTENT_TYPE, ecoreResourceFactory);
			contentHandlers.add(new RootXMLContentHandlerImpl(EcorePackage.eCONTENT_TYPE, null, RootXMLContentHandlerImpl.XMI_KIND, EcorePackage.eNS_URI, null));
			contentTypeToFactoryMap.put(EMOFExtendedMetaData.CONTENT_TYPE, emofResourceFactory);
			contentHandlers.add(new RootXMLContentHandlerImpl(EMOFExtendedMetaData.CONTENT_TYPE, null,
				RootXMLContentHandlerImpl.XMI_KIND, EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0, null));
			contentHandlers.add(new RootXMLContentHandlerImpl(EMOFExtendedMetaData.CONTENT_TYPE, null,
				RootXMLContentHandlerImpl.XMI_KIND, EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI, null));
			return resourceSet;
		}

		@Override
		protected void initialiseResourceFactoryRegistry(Registry resourceFactoryRegistry) {
		}
	}

	protected List<String> expectedErrors = null;
		
	protected JavaProjectHandle getProjectFileHandle(String projectName) throws IOException {
		URL projectURL = ModelRegistryTestCase.class.getResource(projectName);
		if ((projectURL != null) && Platform.isRunning()) {
			try {
				projectURL = FileLocator.resolve(projectURL);
			} catch (IOException e) {
				TestCase.fail(e.getMessage());
				return null;
			}
		}	
		if (projectURL == null)
			return null;
		URI uri = URI.createURI(projectURL.toString());
		String projectFileName = uri.toFileString();
		File projectFile = new File(projectFileName);
		return new JavaProjectHandle(projectFile, null);
	}

	protected ModelFileResolver getModelFileResolver(String projectName, String resourceName) throws IOException {
		JavaProjectHandle projectHandle = getProjectFileHandle(projectName);
		File contextFile = new File(projectHandle.getFile(), resourceName);
		return new TestModelFileResolver(projectHandle, contextFile);
	}

	protected void setExpectedError(String string) {
		if (expectedErrors == null)
			expectedErrors = new ArrayList<String>();
		expectedErrors.add(string);
	}
	
	public ModelRegistryTestCase(String name) {
		super(name);
	}

	@Override protected void setUp() throws Exception {
		new TestEnvironment();
		super.setUp();
	}

	@Override protected void tearDown() throws Exception {
		if ((expectedErrors != null) && !expectedErrors.isEmpty())
			fail("Missing error: '" + expectedErrors.get(0) + "'");
		super.tearDown();
	}

}
