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
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.modelregistry.standalone.ModelFileResolver;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaProjectHandle;

public class TestFileHandles extends ModelRegistryTestCase
{
	public TestFileHandles(String name) {
		super(name);
	}
	
	public void testEmptyProject() throws IOException {
		String projectName = "emptyProject";
		JavaProjectHandle projectHandle = getProjectFileHandle(projectName);
		File registryFile = projectHandle.getRegistryFile();
		ModelFileResolver modelResolver = new ModelFileResolver(projectHandle, registryFile);
		URI uri = modelResolver.getURI("XYZZY");
		assertNull("Null URI expected", uri);
	}
	
	public void testModelNameAccessor() throws IOException {
		ModelFileResolver modelResolver = getModelFileResolver("testProject", "phantomFolder");
		URI uri = modelResolver.getURI("ambiguousAccessor");
		assertNotNull("Non-null uri expected for model:/name/accessor", uri);
		assertEquals("Incorrect URI", "model:/name/accessor", uri.toString());
		return;
	}
	
	public void testURIAccessor() throws IOException, URISyntaxException {
		ModelFileResolver modelResolver = getModelFileResolver("testProject", "phantomFolder");
		URI uri = modelResolver.getURI(new java.net.URI("ambiguousAccessor"));
		assertNotNull("Non-null uri expected for uri:/accessor", uri);
		assertEquals("Incorrect URI", "uri:/accessor", uri.toString());
		return;
	}
	
	public void testMissingAccessor() throws IOException {
		ModelFileResolver modelResolver = getModelFileResolver("testProject", "phantomFolder");
		URI uri = modelResolver.getURI("missingAccessor");
		assertNull("Null URI expected", uri);
		return;
	}
	
	public void testMissingProject() throws IOException {
		String projectName = "missingProject";
		JavaProjectHandle projectHandle = getProjectFileHandle(projectName);
		assertNull("Null ProjectFileHandle expected", projectHandle);
	}
	
	
	public void testProjectRelativeEcoreAccessor() throws Exception {
		ModelFileResolver modelResolver = getModelFileResolver("testProject", "phantomFolder");
		URI uri = modelResolver.getURI("ecoreRelativeFileAccessor");
		assertNotNull("Non-null uri expected", uri);
		Resource resource = modelResolver.getResource(uri, true);
		assertNotNull("Non-null resource expected", resource);
		List<EObject> contents = resource.getContents();
		assertEquals("Single package", 1, contents.size());
		EPackage ePackage = (EPackage) contents.get(0);
		assertEquals("Package name", "miniecore", ePackage.getName());
		assertEquals("Single class", 1, ePackage.getEClassifiers().size());
		EClass eClass = (EClass) ePackage.getEClassifiers().get(0);
		assertEquals("Class name", "MiniEcore", eClass.getName());
		return;
	}
	
/*	public void testProjectRelativeEmofAccessor() throws Exception {
		ModelFileResolver modelResolver = getModelFileResolver("testProject", "phantomFolder");
		URI uri = modelResolver.getURI("emofRelativeFileAccessor");
		assertNotNull("Non-null uri expected", uri);
		Resource resource = modelResolver.getResource(uri, true);
		assertNotNull("Non-null resource expected", resource);
		List<EObject> contents = resource.getContents();
		assertEquals("Single package", 1, contents.size());
		EPackage ePackage = (EPackage) contents.get(0);
		assertEquals("Package name", "miniemof", ePackage.getName());
		assertEquals("Single class", 1, ePackage.getEClassifiers().size());
		EClass eClass = (EClass) ePackage.getEClassifiers().get(0);
		assertEquals("Class name", "MiniEmof", eClass.getName());
		assertEquals("Single property", 1, eClass.getEStructuralFeatures().size());
		EStructuralFeature eStructuralFeature = (EStructuralFeature) eClass.getEStructuralFeatures().get(0);
		assertEquals("Property name", "miniEmof", eStructuralFeature.getName());
		assertEquals("Property lower", 0, eStructuralFeature.getLowerBound());
		assertEquals("Property upper", -1, eStructuralFeature.getUpperBound());
		return;
	} */
	
	public void testUnregisteredAccessor() throws IOException {
		String projectName = "testProject";
		JavaProjectHandle projectHandle = getProjectFileHandle(projectName);
		projectHandle.setRegistryName(".settings/missingaccessor.modelregistry");
		setExpectedError("Unregistered accessor namespace 'MissingAccessor' used in '" + projectHandle.getRegistryURI() + "'");
		File contextFile = new File(projectHandle.getFile(), "phantomFolder");
		ModelFileResolver modelResolver = new ModelFileResolver(projectHandle, contextFile);
		URI uri = modelResolver.getURI("missingAccessor");
		assertNull("Null URI expected", uri);
		return;
	}
}
