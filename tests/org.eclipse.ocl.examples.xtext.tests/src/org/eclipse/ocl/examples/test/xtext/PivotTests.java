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
 * $Id: PivotTests.java,v 1.3 2011/02/11 20:11:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs.OCLinEcorePivot2CS;

/**
 * Tests.
 */
public class PivotTests extends XtextTestCase
{

//	private static final Logger logger = Logger.getLogger(PivotTests.class);

	public static class Checker extends CS2Pivot
	{
		private Checker(CS2Pivot aConverter) {
			super(aConverter);
		}

		public void assertContainedBy(CS2Pivot thatConverter) {
			List<String> theseMonikers = new ArrayList<String>(moniker2PivotMap.keySet());
			List<String> thoseMonikers = new ArrayList<String>(thatConverter.getMonikers());
			Collections.sort(theseMonikers);
			Collections.sort(thoseMonikers);
			for (String moniker : moniker2PivotMap.keySet()) {
				MonikeredElement thisPivotElement = getPivotElement(moniker);
				MonikeredElement thatPivotElement = thatConverter.getPivotElement(moniker);
				if (isValidPivot(thisPivotElement) && isValidPivot(thatPivotElement)) {
					assertEquals("Preserved pivot", thisPivotElement, thatPivotElement);
				}
			}
		}

		public void assertSameContents() {
			Collection<? extends Resource> csResources = cs2pivotResourceMap.keySet();
			for (Resource csResource : csResources) {
				for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
					ElementCS csElement = (ElementCS) tit.next();
					if (csElement instanceof MonikeredElementCS) { //&& !(csElement instanceof TemplateBindingCS) && !(csElement instanceof TemplateParameterSubstitutionCS)) {
						MonikeredElementCS csMonikeredElement = (MonikeredElementCS)csElement;
						if (hasCorrespondingPivot(csMonikeredElement)) {
							String csMoniker = csMonikeredElement.getMoniker();
							MonikeredElement actualPivotElement = (MonikeredElement) csMonikeredElement.getPivot();
							if (actualPivotElement == null) {
								@SuppressWarnings("unused")
								MonikeredElement pivotElement = getPivotElement(csMoniker);
								fail("Missing pivot for '" + csMoniker + "'");
							}
							else {
								String actualPivotMoniker = actualPivotElement.getMoniker();
								assertEquals("Moniker mismatch", csMoniker, actualPivotMoniker);
								MonikeredElement expectedPivotElement = moniker2PivotMap.get(csMoniker);
								assertEquals("Element mismatch", expectedPivotElement, actualPivotElement);
							}
						}
					}
				}
			}
			Collection<? extends Resource> pivotResources = cs2pivotResourceMap.values();
			Map<String, MonikeredElementCS> moniker2CSMap = computeMoniker2CSMap(csResources);
			for (Resource pivotResource : pivotResources) {
				for (TreeIterator<EObject> tit = pivotResource.getAllContents(); tit.hasNext(); ) {
					Element pivotElement = (Element) tit.next();
					if (pivotElement instanceof MonikeredElement) { //&& !(pivotElement instanceof TemplateSignature) && !(pivotElement instanceof TemplateParameterSubstitution) && !(pivotElement instanceof TemplateParameter)) {
						MonikeredElement pivotNameableElement = (MonikeredElement)pivotElement;
						if (hasCorrespondingCS(pivotNameableElement)) {
							String pivotMoniker = pivotNameableElement.getMoniker();
							MonikeredElementCS csNameableElement = moniker2CSMap.get(pivotMoniker);
							MonikeredElement pivotCSElement = (MonikeredElement) csNameableElement.getPivot();
							if (pivotCSElement == null) {
								fail("Missing pivot for '" + pivotElement + "'");
							}
							else {
								assertEquals("Moniker mismatch", pivotMoniker, csNameableElement.getMoniker());
								assertEquals("Element mismatch", pivotElement, pivotCSElement);
							}
						}
					}
				}
			}
		}

		public List<EObject> getRoots() {
			List<EObject> roots = new ArrayList<EObject>();
			for (Map.Entry<? extends Resource, ? extends Resource> entry : cs2pivotResourceMap.entrySet()) {
				roots.addAll(entry.getKey().getContents());
				roots.addAll(entry.getValue().getContents());
			}
			return roots;
		}
	}

/*	public static class Damager extends Checker
	{
		private Damager(CS2Pivot aConverter) {
			super(aConverter);
		}
		
		public List<MonikeredElement> chooseVictims() {
			List<String> pivotKeys = new ArrayList<String>(moniker2PivotMap.keySet());
			List<MonikeredElement> pivotElements = new ArrayList<MonikeredElement>();
			Collections.sort(pivotKeys);
			int iMax = pivotKeys.size();
			int stepSize = Math.max((int) Math.sqrt(iMax), 1);
			for (int i = iMax-1; i > 0; i -= stepSize) {
//				String moniker = pivotKeys.remove(i);
				String moniker = pivotKeys.get(i);
				MonikeredElement pivotElement = moniker2PivotMap.get(moniker);
				pivotElements.add(pivotElement);
			}
			return pivotElements;
		}

		public void removeAll(Collection<? extends MonikeredElement> pivotElements) {
			Collection<EObject> roots = getRoots();
			Map<EObject, Collection<EStructuralFeature.Setting>> xrefMap = EcoreUtil.CrossReferencer.find(roots);
			for (MonikeredElement pivotElement : pivotElements) {
				String moniker = pivotElement.getMoniker();
				logger.trace("Damage " + pivotElement.eClass().getName() + " : " + moniker); //$NON-NLS-1$
				moniker2PivotMap.remove(moniker);
				EObject eContainer = pivotElement.eContainer();
				if (eContainer != null) {
					EStructuralFeature eContainingFeature = pivotElement.eContainingFeature();
					if (eContainingFeature.isMany()) {
						((List<?>) eContainer.eGet(eContainingFeature)).remove(pivotElement);
					}
					else {
						eContainer.eSet(eContainingFeature, null);
					}
				}
				for (EStructuralFeature.Setting setting : xrefMap.get(pivotElement)) {
					setting.unset();	// Invalid -- must reinstate Xtext proxies
				}
			}
		}
	} */

	public void assertHasMonikers(Collection<? extends Resource> pivotResources) {
		for (Resource pivotResource : pivotResources) {
			for (TreeIterator<EObject> tit = pivotResource.getAllContents(); tit.hasNext(); ) {
				Element pivotElement = (Element) tit.next();
				if (pivotElement instanceof MonikeredElement) {
					assertTrue(((MonikeredElement)pivotElement).hasMoniker());
				}
			}
		}
	}

	public void assertHasNoMonikers(Collection<? extends Resource> pivotResources) {
		for (Resource pivotResource : pivotResources) {
			for (TreeIterator<EObject> tit = pivotResource.getAllContents(); tit.hasNext(); ) {
				Element pivotElement = (Element) tit.next();
				if (pivotElement instanceof MonikeredElement) {
					assertFalse(((MonikeredElement)pivotElement).hasMoniker());
				}
			}
		}
	}

/*	public CS2Pivot createPivot(Map<? extends Resource,? extends Resource> cs2pivotResourceMap) {
		Collection<? extends Resource> pivotResources = cs2pivotResourceMap.values();
		CS2Pivot converter = new CS2Pivot(cs2pivotResourceMap);
		assertHasNoMonikers(pivotResources);
		converter.updateDeclarers();
		assertHasNoMonikers(pivotResources);
		converter.updateDefiners();
		assertHasNoMonikers(pivotResources);
		converter.updateSpecializations();
		assertHasNoMonikers(pivotResources);
		converter.updateResolvers();
		assertHasNoMonikers(pivotResources);
		return converter;
	} */

	public BaseCSResource doLoadOCLstdlib(String stem, String extension) throws IOException {
		resourceSet = new ResourceSetImpl();
		TypeManager typeManager =  new TypeManager.NoDefaultLibrary();
//		CS2PivotResourceSetAdapter.getAdapter(resourceSet, typeManager);
//		long startTime = System.currentTimeMillis();
//		System.out.println("Start at " + startTime);
		String inputName = stem + "." + extension;
		String outputName = stem + "." + extension + ".xmi";
		String output2Name = stem + ".saved." + extension;
		URI inputURI = getProjectFileURI(inputName);
		URI outputURI = getProjectFileURI(outputName);
		URI output2URI = getProjectFileURI(output2Name);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " getResource()");
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(inputURI, true);
		TypeManagerResourceAdapter.getAdapter(xtextResource, typeManager);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " gotResource()");
		assertNoResourceErrors("Load failed", xtextResource);
		assertNoCSErrors("Load failed", xtextResource);
//		CSAliasCreator.refreshPackageAliases(xtextResource);
//		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource);
//		Resource pivotResource = adapter.getPivotResource(xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolveProxies()");
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
//		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
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
		xtextResource.getContents().addAll(xmiResource.getContents());
		return xtextResource;
	}

	protected void doPivotTestOCLstdlib(String stem) throws IOException {
		String pivotName = stem + ".pivot";
		URI pivotURI = getProjectFileURI(pivotName);
		BaseCSResource csResource = doLoadOCLstdlib(stem, "oclstdlib");
		//
		//	Create Pivot model from CS
		//
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.findAdapter(csResource);
		Resource pivotResource = adapter.getPivotResource(csResource);
		CS2Pivot creator = adapter.getConverter();
		//
		//	Check that Pivot model is ready for damage
		//
		new Checker(creator).assertContainedBy(creator);
		//
		//	Save Pivot Model for manual inspection
		//
		assertNoValidationErrors("Pivot validation problems", pivotResource);
		URI savedPivotURI = pivotResource.getURI();
		pivotResource.setURI(pivotURI);
		pivotResource.save(null);
		pivotResource.setURI(savedPivotURI);
		//
		//	Check CS and Pivot have consistent content
		//
		new Checker(creator).assertSameContents();
		//
		//	Update Pivot model from unchanged CS
		//
		CS2Pivot updater = new CS2Pivot(creator);
		updater.update();
		new Checker(creator).assertSameContents();
		//
		// Damage the Pivot model and update to repair.
		//
//		Damager damager = damagePivot(creator);
//		damager.assertContainedBy(updater);
//		damager.update();
//		damager.assertSameContents();
		//
		assertPivotIsValid(pivotURI);	
	}
	
	public void doPivotTestEcore(String stem) throws IOException {
		TypeManager typeManager = new TypeManager();
		ResourceSet pivotResourceSet = typeManager.getPivotResourceSet();
//		long startTime = System.currentTimeMillis();
//		System.out.println("Start at " + startTime);
//		String libraryName = "oclstdlib.pivot";
//		String libraryName = "oclstdlib.oclstdlib";
//		URI libraryURI = getProjectFileURI(libraryName);
//		BaseCSResource xtextLibraryResource = (BaseCSResource) resourceSet.getResource(libraryURI, true);
//		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.refreshPivotMappings(xtextLibraryResource, null);
//		Resource pivotResource = adapter.getPivotResource(xtextLibraryResource);
//		pivotResourceSet.getResource(libraryURI, true);
		String inputName = stem + ".ecore";
		String csName = stem + ".ecore.cs";
		URI inputURI = getProjectFileURI(inputName);
		URI csURI = getProjectFileURI(csName);
//		URI output2URI = getProjectFileURI(output2Name);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " getResource()");
		Resource ecoreResource = resourceSet.getResource(inputURI, true);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " gotResource()");
		assertNoResourceErrors("Load failed", ecoreResource);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " resolveProxies()");
		assertNoUnresolvedProxies("Unresolved proxies", ecoreResource);
//		EcoreAliasCreator.createPackageAliases(ecoreResource);
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, typeManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = ecore2Pivot.getPivotRoot();
		
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
//		assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
//		xtextResource.setURI(output2URI);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
//		xtextResource.save(null);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
//		assertNoResourceErrors("Save failed", xtextResource.getErrors());
		Resource pivotResource = pivotRoot.eResource();
//		CS2PivotAliasCreator.createPackageAliases(pivotResource);
//		Resource pivotResource = resourceSet.createResource(outputURI);
//		pivotResource.getContents().add(pivotRoot);
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " save()");
		for (Resource pResource : pivotResourceSet.getResources()) {
			URI uri = pResource.getURI();
			if (uri.isFile()) {
				pResource.save(null);
			}
			assertNoResourceErrors("Pivot Save failed", pResource);
		}
//		System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " saved()");
//		return pivotResource;
		ResourceSetImpl csResourceSet = new ResourceSetImpl();
		csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
		csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		Resource csResource = csResourceSet.createResource(csURI);
		Map<Resource, Resource> cs2PivotResourceMap = new HashMap<Resource, Resource>();
		cs2PivotResourceMap.put(csResource, pivotResource);
		Pivot2CS pivot2cs = new OCLinEcorePivot2CS(cs2PivotResourceMap, typeManager);
		pivot2cs.update();
		csResource.save(null);
	
	}
	
//	public Damager damagePivot(CS2Pivot aConverter) {
//		Damager damager = new Damager(aConverter);
//		List<MonikeredElement> pivotElements = damager.chooseVictims();
//		damager.removeAll(pivotElements);
//		return damager;
//	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("trace", new EcoreResourceFactoryImpl());
	}

//	public void testPivot_mini_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("mini");
//	}

//	public void testPivot_midi_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("midi");
//	}

	public void testPivot_oclstdlib_oclstdlib() throws IOException, InterruptedException {
		doPivotTestOCLstdlib("oclstdlib");
	}

//	public void testPivot_temp_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("temp");
//	}

//	public void testPivot_temp2_oclstdlib() throws IOException, InterruptedException {
//		doPivotTestOCLstdlib("temp2");
//	}

	public void testPivot_Ecore_ecore() throws IOException, InterruptedException {
		doPivotTestEcore("Ecore");
	}

	public void testPivot_Names_ecore() throws IOException, InterruptedException {
		doPivotTestEcore("Names");
	}
}
