/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: LoadTests.java,v 1.10 2010/08/17 08:35:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTests extends XtextTestCase
{	
	public void doLoad(String stem, String extension) throws IOException {
//		long startTime = System.currentTimeMillis();
//		System.out.println("Start at " + startTime);
		String inputName = stem + "." + extension;
		String outputName = stem + "." + extension + ".xmi";
		String output2Name = stem + ".saved." + extension;
		URI inputURI = getProjectFileURI(inputName);
		URI outputURI = getProjectFileURI(outputName);
		URI output2URI = getProjectFileURI(output2Name);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " getResource()");
		Resource xtextResource = resourceSet.getResource(inputURI, true);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " gotResource()");
		assertNoResourceErrors("Load failed", xtextResource.getErrors());
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolveProxies()");
		Map<EObject, Collection<Setting>> unresolved = UnresolvedProxyCrossReferencer.find(xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolvedProxies()");
		assertNoUnresolvedProxies("Unresolved proxies", unresolved);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		xtextResource.setURI(output2URI);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		xtextResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
		assertNoResourceErrors("Save failed", xtextResource.getErrors());
		Resource xmiResource = resourceSet.createResource(outputURI);
		xmiResource.getContents().addAll(xtextResource.getContents());
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		xmiResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
		assertNoResourceErrors("Save failed", xmiResource.getErrors());
	}
	
	public void testLoad_Bug321171_oclinecore() throws IOException, InterruptedException {
		doLoad("Bug321171", "oclinecore");
	}
	
	public void testLoad_Bug321903_oclinecore() throws IOException, InterruptedException {
		doLoad("Bug321903", "oclinecore");
	}	
	
	public void testLoad_Ecore_ecore() throws IOException, InterruptedException {
		doLoad("Ecore", "ecore");
	}	

	public void testLoad_Imports_ecore() throws IOException, InterruptedException {
		doLoad("Imports", "ecore");
	}	

	public void testLoad_Imports_ocl() throws IOException, InterruptedException {
		doLoad("Imports", "ocl");
	}	

	public void testLoad_Names_ecore() throws IOException, InterruptedException {
		doLoad("Names", "ecore");
	}	

	public void testLoad_Names_ocl() throws IOException, InterruptedException {
		doLoad("Names", "ocl");
	}	

	public void testLoad_Names_oclinecore() throws IOException, InterruptedException {
		doLoad("Names", "oclinecore");
	}	

	public void testLoad_RoyalAndLoyal_ecore() throws IOException, InterruptedException {
		doLoad("RoyalAndLoyal", "ecore");
	}	

	public void testLoad_RoyalAndLoyal_ocl() throws IOException, InterruptedException {
		doLoad("RoyalAndLoyal", "ocl");
	}	

	public void testLoad_oclstdlib_oclstdlib() throws IOException, InterruptedException {
		doLoad("oclstdlib", "oclstdlib");
	}	

	public void testLoad_OCL_ecore() throws IOException, InterruptedException {
		doLoad("OCL", "ecore");
	}	

	public void testLoad_Types_oclinecore() throws IOException, InterruptedException {
		doLoad("Types", "oclinecore");
	}	
}
