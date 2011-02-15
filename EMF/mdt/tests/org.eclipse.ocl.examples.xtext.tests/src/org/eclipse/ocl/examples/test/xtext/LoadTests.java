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
 * $Id: LoadTests.java,v 1.16 2011/02/11 20:11:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTests extends XtextTestCase
{	
	protected TypeManager typeManager = null;
	
	@Override
	protected void tearDown() throws Exception {
		typeManager = null;
		StandardLibraryContribution.REGISTRY.put(TypeManager.DEFAULT_OCL_STDLIB_URI, null);
		super.tearDown();
	}

	public void checkSignatures(Resource resource) {
		Map<String, NamedElementCS> sigMap = new HashMap<String, NamedElementCS>();
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			@SuppressWarnings("unused")
			String toString = eObject.toString();
			if (eObject instanceof NamedElementCS) {
				NamedElementCS namedElementCS = (NamedElementCS)eObject;
				String signature = namedElementCS.getMoniker();
				if (sigMap.containsKey(signature)) {
					System.out.println("Duplicate signature " + signature + " from "  + namedElementCS.eClass().getName());
					namedElementCS.getMoniker();
				}
				sigMap.put(signature, namedElementCS);
			}
			else if (eObject instanceof MonikeredElementCS) {
				MonikeredElementCS nameableElementCS = (MonikeredElementCS)eObject;
				String signature = nameableElementCS.getMoniker();
				System.out.println(signature + "                              -> " + nameableElementCS.eClass().getName()); // + " : " + value.toString());
			}
		}
		List<String> keys = new ArrayList<String>(sigMap.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			MonikeredElementCS value = sigMap.get(key);
			System.out.println(key + "                              => " + value.eClass().getName()); // + " : " + value.toString());
		}
	}	

	public Resource doLoad(String stem, String extension) throws IOException {
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
		assertNoResourceErrors("Load failed", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolveProxies()");
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
//FIXME		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		xtextResource.setURI(output2URI);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		xtextResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
		assertNoResourceErrors("Save failed", xtextResource);
		Resource xmiResource = resourceSet.createResource(outputURI);
		xmiResource.getContents().addAll(xtextResource.getContents());
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		xmiResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
		assertNoResourceErrors("Save failed", xmiResource);
		return xmiResource;
	}

	public Resource doLoad_Concrete(String stem, String extension) throws IOException {
		String inputName = stem + "." + extension;
		String cstName = inputName + ".xmi";
		String pivotName = inputName + ".pivot";
		String savedName = stem + ".saved." + extension;
		URI inputURI = getProjectFileURI(inputName);
		URI cstURI = getProjectFileURI(cstName);
		URI pivotURI = getProjectFileURI(pivotName);
		URI savedURI = getProjectFileURI(savedName);
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Load failed", xtextResource);
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, null);
		Resource pivotResource = adapter.getPivotResource(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
//FIXME		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
		xtextResource.setURI(savedURI);
		xtextResource.save(null);
		xtextResource.setURI(inputURI);
		assertNoResourceErrors("Save failed", xtextResource);
		saveAsXMI(xtextResource, cstURI);
		pivotResource.setURI(pivotURI);
		assertNoValidationErrors("Pivot validation errors", pivotResource.getContents().get(0));
		pivotResource.save(null);
		return pivotResource;
	}

	protected void saveAsXMI(Resource resource, URI xmiURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		Resource xmiResource = resourceSet.createResource(xmiURI);
		xmiResource.getContents().addAll(resource.getContents());
		Map<String, Object> options = new HashMap<String, Object>();
//		options.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		xmiResource.save(options);
		assertNoResourceErrors("Save failed", xmiResource);
		resource.getContents().addAll(xmiResource.getContents());
	}

	public void testLoad_Annotations_ecore() throws IOException, InterruptedException {
		doLoad("Annotations", "ecore");
	}

	public void testLoad_Annotations_oclinecore() throws IOException, InterruptedException {
		doLoad_Concrete("Annotations", "oclinecore");
	}

	public void testLoad_Ecore_ecore() throws IOException, InterruptedException {
		doLoad("Ecore", "ecore");
	}	

	public void testLoad_Expression_oclinecore() throws IOException, InterruptedException {
		typeManager = new TypeManager();
		typeManager.loadLibrary(OCLstdlib.INSTANCE);
		doLoad_Concrete("Expression", "oclinecore");
	}	

	public void testLoad_Imports_ecore() throws IOException, InterruptedException {
		doLoad("Imports", "ecore");
	}	

	public void testLoad_Names_ecore() throws IOException, InterruptedException {
		doLoad("Names", "ecore");
	}	

	public void testLoad_Names_oclinecore() throws IOException, InterruptedException {
		doLoad_Concrete("Names", "oclinecore");
	}	

	public void testLoad_RoyalAndLoyal_ecore() throws IOException, InterruptedException {
		doLoad("RoyalAndLoyal", "ecore");
	}	

	public void testLoad_oclstdlib_oclstdlib() throws IOException, InterruptedException {
//		StandardLibraryContribution.REGISTRY.put(TypeManager.DEFAULT_OCL_STDLIB_URI, StandardLibraryContribution.NULL);
		Resource resource = doLoad_Concrete("oclstdlib", "oclstdlib");
		checkSignatures(resource);
	}

	public void testLoad_OCL_ecore() throws IOException, InterruptedException {
		doLoad("OCL", "ecore");
	}	

	public void testLoad_Types_oclinecore() throws IOException, InterruptedException {
		doLoad_Concrete("Types", "oclinecore");
	}	
	
	public void testLoad_Bug321171_oclinecore() throws IOException, InterruptedException {
		doLoad_Concrete("Bug321171", "oclinecore");
	}

	public void testLoad_Bug321903_oclinecore() throws IOException, InterruptedException {
		doLoad_Concrete("Bug321903", "oclinecore");
	}	

	public void testLoad_Imports_ocl() throws IOException, InterruptedException {
		doLoad("Imports", "ocl");
	}	

	public void testLoad_Names_ocl() throws IOException, InterruptedException {
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		doLoad("Names", "ocl");
	}	

	public void testLoad_RoyalAndLoyal_ocl() throws IOException, InterruptedException {
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		doLoad("RoyalAndLoyal", "ocl");
	}	
}
