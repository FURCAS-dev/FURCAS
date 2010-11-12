/*******************************************************************************
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.modelregistry;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.modelregistry.standalone.ModelFileResolver;

public class TestContents extends ModelRegistryTestCase
{
	public TestContents(String name) {
		super(name);
	}
	
	public void testProjectRelativeEmofAccessor() throws Exception {
		ModelFileResolver modelResolver = getModelFileResolver("testProject", "phantomFolder");
		URI uri = modelResolver.getURI("emofRelativeFileAccessor");
		assertNotNull("Non-null uri expected for emofRelativeFileAccessor", uri);
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
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeatures().get(0);
		assertEquals("Property name", "miniEmof", eStructuralFeature.getName());
		assertEquals("Property lower", 1, eStructuralFeature.getLowerBound());
		assertEquals("Property upper", -1, eStructuralFeature.getUpperBound());
		return;
	}

	/*
	 * This test behaves differently according to whether the EMOF to Ecore mapping
	 * is installed. It is therefore unsuitable as a model registry test.
	 * FIXME Move this to somewhere dependent on EMOF and Model Registry
	public void testProjectRelativeXmlEmofAccessor() throws Exception {
		ModelFileResolver modelResolver = getModelFileResolver("testProject", "phantomFolder");
		URI uri = modelResolver.getURI("xmlEmofRelativeFileAccessor");
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
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeatures().get(0);
		assertEquals("Property name", "miniEmof", eStructuralFeature.getName());
		assertEquals("Property lower", 1, eStructuralFeature.getLowerBound());
		assertEquals("Property upper", -1, eStructuralFeature.getUpperBound());
		return;
	} */
}
