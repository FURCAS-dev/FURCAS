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
 * $Id: MonikerTests.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Moniker;
import org.eclipse.ocl.examples.pivot.ecore.EcoreAliasCreator;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;

/**
 * Tests.
 */
public class MonikerTests extends XtextTestCase
{
	/**
	 * Check that all CS elements that should have monikers do, and that
	 * there are no duplicates. Return a map of moniker to CS.
	 */
	public Map<String, MonikeredElementCS> checkCSMonikers(Resource csResource) {
		Map<String, MonikeredElementCS> monikerMap = new HashMap<String, MonikeredElementCS>();
		for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
			ElementCS csElement = (ElementCS) tit.next();
			if (csElement instanceof MonikeredElementCS) {
				MonikeredElementCS csMonikeredElement = (MonikeredElementCS) csElement;
				if (hasUniqueMoniker(csMonikeredElement)) {
					String moniker = csMonikeredElement.getMoniker();
					ElementCS oldElement = monikerMap.get(moniker);
					if (oldElement != null) {
						fail("Duplicate moniker " + moniker + " for " + csElement.eClass().getName());
					}
					monikerMap.put(moniker, csMonikeredElement);
//					System.out.println(csMonikeredElement.eClass().getName() + " : " + moniker);
//					String signature = Ecore2Moniker.toSignature(eElement);
//					System.out.println(eObject.eClass().getName() + " : " + signature);
				}
			}
		}
		return monikerMap;
	}

	/**
	 * Check that ever monikered CS element references the same pivot element as
	 * the CS element that defines the moniker.
	 */
	public void checkCShasPivots(Resource csResource, Map<String, MonikeredElementCS> csMonikerMap) {
		for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof MonikeredElementCS) {
				MonikeredElementCS csElement = (MonikeredElementCS) eObject;
				if (hasCorrespondingPivot(csElement)) {
					String moniker = csElement.getMoniker();
					MonikeredElementCS oldElement = csMonikerMap.get(moniker);
					Element oldPivot = oldElement != null ? oldElement.getPivot() : null;
					Element newPivot = csElement.getPivot();
					if (isValidPivot(oldPivot) && isValidPivot(newPivot)) {
						assertEquals("Inconsistent pivot for " + moniker, newPivot, oldPivot);
					}
				}
			}
		}
	}

	/**
	 * Check that the pivot moniker for the pivot of every monikered CS element
	 * is the same as the CS moniker.
	 */
	public void checkCSandPivotMonikers(Map<String, MonikeredElementCS> csMonikerMap) {
		List<String> csMonikers = new ArrayList<String>(csMonikerMap.keySet());
		Collections.sort(csMonikers);
		for (String csMoniker : csMonikers) {
			MonikeredElementCS csElement = csMonikerMap.get(csMoniker);
			if (hasCorrespondingPivot(csElement)) {
//				System.out.println(csElement.eClass().getName() + " : " + csMoniker);
				MonikeredElement pivot = (MonikeredElement) csElement.getPivot();
				String pivotMoniker = pivot.getMoniker();
				assertEquals("Pivot moniker for CS:", csMoniker, pivotMoniker);
			}
			else {
//				System.out.println("[" + csElement.eClass().getName() + "] : " + csMoniker);				
			}
		}
	}
	/**
	 * Check that all pivot elements that should have monikers do, and that
	 * there are no duplicates. Return a map of moniker to pivot.
	 */
	public Map<String, MonikeredElement> checkPivotMonikers(ResourceSet pivotResourceSet) {
		Map<String, MonikeredElement> monikerMap = new HashMap<String, MonikeredElement>();
		for (Resource pivotResource : pivotResourceSet.getResources()) {
			for (TreeIterator<EObject> tit = pivotResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof MonikeredElement) {
					MonikeredElement pivotElement = (MonikeredElement) eObject;
					if (hasCorrespondingCS(pivotElement)) {
						String moniker = pivotElement.getMoniker();
						MonikeredElement oldElement = monikerMap.get(moniker);
						if (oldElement != null) {
							fail("Duplicate moniker " + moniker + " for " + pivotElement.eClass().getName());
						}
						monikerMap.put(moniker, pivotElement);
//						System.out.println(eObject.eClass().getName() + " : " + moniker);
		//				String signature = Ecore2Moniker.toSignature(eElement);
		//				System.out.println(eObject.eClass().getName() + " : " + signature);
					}
				}
			}
		}
		return monikerMap;
	}

	public void doMonikerTestEcore(String stem) throws IOException {
		//
		//	Load the Ecore resource and check for load failures and proxy resolution
		//
		String inputName = stem + ".ecore";
		URI inputURI = getProjectFileURI(inputName);
		Resource ecoreResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Load failed", ecoreResource);
		assertNoUnresolvedProxies("Unresolved proxies", ecoreResource);
		//
		//	Create and check Ecore monikers for uniqueness
		//
		EcoreAliasCreator.refreshPackageAliases(ecoreResource);
		Map<String, EModelElement> monikerMap = new HashMap<String, EModelElement>();
		for (TreeIterator<EObject> tit = ecoreResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof EModelElement) {
				EModelElement eElement = (EModelElement) eObject;
				String moniker = Ecore2Moniker.toString(eElement);
				EModelElement oldElement = monikerMap.get(moniker);
				if (oldElement != null) {
					fail("Duplicate moniker " + moniker + " for " + eElement.eClass().getName());
				}
				monikerMap.put(moniker, eElement);
//				System.out.println(eObject.eClass().getName() + " : " + moniker);
//				String signature = Ecore2Moniker.toSignature(eElement);
//				System.out.println(eObject.eClass().getName() + " : " + signature);
			}
		}
	}

	public void doMonikerTestOCLstdlib(String stem) throws IOException {
		//
		//	Load the CS resource and check for load failures
		//
		String inputName = stem + ".oclstdlib";
		String pivotName = stem + ".pivot";
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = getProjectFileURI(pivotName);
		BaseCSResource csResource = (BaseCSResource) resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Load failed", csResource);
		assertNoUnresolvedProxies("Unresolved proxies", csResource);
		assertNoValidationErrors("CS validation problems", csResource);
		//
		//	Get the pivot resource and check for load failures
		//
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(csResource, null);
		Resource pivotResource = adapter.getPivotResource(csResource);		
		assertNoValidationErrors("Pivot validation problems", pivotResource);
		pivotResource.setURI(pivotURI);
		pivotResource.save(null);
		//
		//	Check CS-Pivot moniker consistency
		//
		Map<String, MonikeredElementCS> csMonikerMap = checkCSMonikers(csResource);
		checkCShasPivots(csResource, csMonikerMap);
		checkCSandPivotMonikers(csMonikerMap);
		TypeManager typeManager = adapter.getTypeManager();
		Map<String, MonikeredElement> pivotMonikerMap = checkPivotMonikers(typeManager.getPivotResourceSet());
		{
			StringBuffer s = null;
			for (String m : csMonikerMap.keySet()) {
				if (!pivotMonikerMap.containsKey(m)) {
					MonikeredElementCS csElement = csMonikerMap.get(m);
					if (hasCorrespondingPivot(csElement)) {
						if (s == null) {
							s = new StringBuffer();
						}
						s.append("\n    " + m);
					}
				}
			}
			if (s != null) {
				fail("Extra CS monikers" + s.toString());
			}
		}
		{
			StringBuffer s = null;
			for (String m : pivotMonikerMap.keySet()) {
				if (!csMonikerMap.containsKey(m)) {
					MonikeredElement pivotElement = pivotMonikerMap.get(m);
					if (hasCorrespondingCS(pivotElement)) {
						if (s == null) {
							s = new StringBuffer();
						}
						s.append("\n    " + pivotElement.eClass().getName() + " : " + m);
					}
				}
			}
			if (s != null) {
				fail("Extra Pivot monikers" + s.toString());
			}
		}
//		assertEquals(csMonikerMap.size(), pivotMonikerMap.size());
	}

	public void testMoniker_Ecore_ecore() throws IOException, InterruptedException {
		doMonikerTestEcore("Ecore");			// Diverse declarations
	}

	public void testMoniker_OCL_ecore() throws IOException, InterruptedException {
		doMonikerTestEcore("OCL");				// Diverse generics
	}

	public void testMoniker_OCLEcore_ecore() throws IOException, InterruptedException {
		doMonikerTestEcore("OCLEcore");
	}

//	public void testMoniker_midi_oclstdlib() throws IOException, InterruptedException {
//		BaseScopeProvider.LOOKUP.setState(true);
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
//		doMonikerTestOCLstdlib("midi");
//	}

//	public void testMoniker_mini_oclstdlib() throws IOException, InterruptedException {
//		BaseScopeProvider.LOOKUP.setState(true);
//		doMonikerTestOCLstdlib("mini");
//	}

	public void testMoniker_oclstdlib_oclstdlib() throws IOException, InterruptedException {
//		BaseScopeProvider.LOOKUP.setState(true);
		doMonikerTestOCLstdlib("oclstdlib");
	}

//	public void testMoniker_OCL_2_3_oclstdlib() throws IOException, InterruptedException {
//		BaseScopeProvider.LOOKUP.setState(true);
//		doMonikerTestOCLstdlib("OCL-2.3x");
//	}
}
