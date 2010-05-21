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
 * $Id: LoadTests.java,v 1.7 2010/05/21 21:23:31 ewillink Exp $
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
		String inputName = stem + "." + extension;
		String outputName = stem + "." + extension + ".xmi";
		String output2Name = stem + ".saved." + extension;
		URI inputURI = getProjectFileURI(inputName);
		URI outputURI = getProjectFileURI(outputName);
		URI output2URI = getProjectFileURI(output2Name);
		Resource xtextResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Load failed", xtextResource.getErrors());
		Map<EObject, Collection<Setting>> unresolved = UnresolvedProxyCrossReferencer.find(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", unresolved);
		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
		xtextResource.setURI(output2URI);
		xtextResource.save(null);
		assertNoResourceErrors("Save failed", xtextResource.getErrors());
		Resource xmiResource = resourceSet.createResource(outputURI);
		xmiResource.getContents().addAll(xtextResource.getContents());
		xmiResource.save(null);
		assertNoResourceErrors("Save failed", xmiResource.getErrors());
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

	public void testLoad_play_oclinecore() throws IOException, InterruptedException {
		doLoad("play", "oclinecore");
	}	

	public void testLoad_Types_oclinecore() throws IOException, InterruptedException {
		doLoad("Types", "oclinecore");
	}	
}
