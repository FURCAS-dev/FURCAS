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
 * $Id: LoadTests.java,v 1.1 2010/05/03 20:01:59 ewillink Exp $
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
	public void doLoad(String stem) throws IOException {
		String inputName = stem;
		String outputName = stem + ".xmi";
		URI inputURI = getProjectFileURI(inputName);
		URI outputURI = getProjectFileURI(outputName);
		Resource xtextResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Load failed", xtextResource.getErrors());
		Map<EObject, Collection<Setting>> unresolved = UnresolvedProxyCrossReferencer.find(xtextResource);
		assertEquals("Unresolved proxies", 0, unresolved.size());
		Resource xmiResource = resourceSet.createResource(outputURI);
		xmiResource.getContents().addAll(xtextResource.getContents());
		xmiResource.save(null);
	}

//	public void testLoad_RoyalAndLoyal_ecore() throws IOException, InterruptedException {
//		doLoad("Copy of RoyalAndLoyal.ecore");
//	}	

	public void testLoad_Imports_ecore() throws IOException, InterruptedException {
		doLoad("Imports.ecore");
	}	

	public void testLoad_Imports_ocl() throws IOException, InterruptedException {
		doLoad("Imports.ocl");
	}	

	public void testLoad_RoyalAndLoyal_ocl() throws IOException, InterruptedException {
		doLoad("RoyalAndLoyal.ocl");
	}	

	public void testLoad_oclstdlib_oclstdlib() throws IOException, InterruptedException {
		doLoad("oclstdlib.oclstdlib");
	}	

	public void testLoad_play_oclinecore() throws IOException, InterruptedException {
		doLoad("play.oclinecore");
	}	
}
