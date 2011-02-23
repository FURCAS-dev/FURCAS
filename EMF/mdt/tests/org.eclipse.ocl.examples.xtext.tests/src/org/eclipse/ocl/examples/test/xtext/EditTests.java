/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EditTests.java,v 1.1 2011/02/19 18:50:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class EditTests extends XtextTestCase
{	
	protected TypeManager typeManager = null;
	
	@Override
	protected void tearDown() throws Exception {
		typeManager = null;
		StandardLibraryContribution.REGISTRY.put(TypeManager.DEFAULT_OCL_STDLIB_URI, null);
		super.tearDown();
	}

	protected Resource getEcoreFromCS(String testDocument, URI ecoreURI) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(xtextURI, null);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		Resource pivotResource = savePivotFromCS(typeManager, xtextResource, null);
		return savePivotAsEcore(typeManager, pivotResource, ecoreURI);
	}

	public void testEdit_Rename_ecore() throws Exception {
		String testDocument = 
			"module m1 \n" +
			"package p1 : p2 = 'p3' {\n" +
			"}\n";
		URI ecoreURI0 = getProjectFileURI("test0.ecore");
		Resource ecoreResource0 = getEcoreFromCS(testDocument, ecoreURI0);
		URI ecoreURI1 = getProjectFileURI("test1.ecore");
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI outputURI = getProjectFileURI("test.oclinecore");
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(outputURI, null);
		xtextResource.load(inputStream, null);
		Resource pivotResource = savePivotFromCS(typeManager, xtextResource, null);
		Resource ecoreResource1 = savePivotAsEcore(typeManager, pivotResource, ecoreURI1);
		assertSameModel(ecoreResource0, ecoreResource1);		
		//
		//	Inserting a leading space has no Ecore effect.
		//
		xtextResource.update(0, 0, " ");
		assertNoResourceErrors("Adding space", xtextResource);
		URI ecoreURI2 = getProjectFileURI("test2.ecore");
		Resource ecoreResource2 = savePivotAsEcore(typeManager, pivotResource, ecoreURI2);
		assertSameModel(ecoreResource0, ecoreResource2);		
		//
		//	Deleting the leading space has no Ecore effect.
		//
		xtextResource.update(0, 1, "");
		assertNoResourceErrors("Deleting space", xtextResource);
		URI ecoreURI3 = getProjectFileURI("test3.ecore");
		Resource ecoreResource3 = savePivotAsEcore(typeManager, pivotResource, ecoreURI3);
		assertSameModel(ecoreResource0, ecoreResource3);		
		//
		//	Changing "p1" to "pkg" renames the package.
		//
		int index = testDocument.indexOf("p1");
		xtextResource.update(index, 2, "pkg"); 
		assertNoResourceErrors("Renaming", xtextResource);
		URI ecoreURI4 = getProjectFileURI("test4.ecore");
		Resource ecoreResource4 = savePivotAsEcore(typeManager, pivotResource, ecoreURI4);
		((EPackage)ecoreResource0.getContents().get(0)).setName("pkg");
		assertSameModel(ecoreResource0, ecoreResource4);		
	}	
}
