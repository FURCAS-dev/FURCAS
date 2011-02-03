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
 * $Id: SerializeTests.java,v 1.11 2011/01/27 07:05:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs.OCLinEcorePivot2CS;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class SerializeTests extends XtextTestCase
{
	public XtextResource doSerialize(String stem) throws Exception {
		String inputName = stem + ".ecore";
		String pivotName = stem + ".ecore.pivot";
		String outputName = stem + ".serialized.oclinecore";
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = getProjectFileURI(pivotName);
		URI outputURI = getProjectFileURI(outputName);
		//
		//	Load as Ecore
		//
		Resource ecoreResource = resourceSet.getResource(inputURI, true);
		mapOwnURI(ecoreResource);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", ecoreResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		//
		//	Ecore to Pivot
		//		
		TypeManager typeManager = new TypeManager();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, typeManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = ecore2Pivot.getPivotRoot();
		Resource pivotResource = pivotRoot.eResource();
		assertNoResourceErrors("Normalisation failed", pivotResource);
		assertNoValidationErrors("Normalisation invalid", pivotResource);
		//
		//	Pivot to CS
		//		
		ResourceSet csResourceSet = resourceSet; //new ResourceSetImpl();
//		csResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("cs", new EcoreResourceFactoryImpl());
//		csResourceSet.getPackageRegistry().put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
//		Resource csResource = csResourceSet.createResource(uri);
//		URI oclinecoreURI = ecoreResource.getURI().appendFileExtension("oclinecore");
		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
		Map<Resource, Resource> cs2PivotResourceMap = new HashMap<Resource, Resource>();
		cs2PivotResourceMap.put(xtextResource, pivotResource);
		Pivot2CS pivot2cs = new OCLinEcorePivot2CS(cs2PivotResourceMap, typeManager);
		pivot2cs.update();
		assertNoResourceErrors("Conversion failed", xtextResource);
//		csResource.save(null);
		//
		//	CS save and reload
		//		
//		pivotResource.setURI(pivotURI);
		pivotResource.save(null);
		
		
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			xtextResource.save(null);
		}
		catch (Exception e) {
			e.printStackTrace();
			String xmiName = stem + ".serialized.oclinecore.xmi";
			URI xmiURI = getProjectFileURI(xmiName);
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(null);
			fail(e.toString());
		}
		resourceSet.getResources().clear();
		BaseCSResource xtextResource2 = (BaseCSResource) resourceSet.getResource(outputURI, true);
		assertNoResourceErrors("Reload failed", xtextResource2);
		assertNoUnresolvedProxies("unresolved reload proxies", xtextResource2);
		//
		//	CS to Pivot
		//	
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource2, typeManager);
		Resource pivotResource2 = adapter.getPivotResource(xtextResource2);
		assertNoUnresolvedProxies("Unresolved proxies", pivotResource2);
		String pivotName2 = stem + "2.ecore.pivot";
		URI pivotURI2 = getProjectFileURI(pivotName2);
		pivotResource2.setURI(pivotURI2);
		pivotResource2.save(null);
		//
		//	Pivot to Ecore
		//		
		List<? extends EObject> outputObjects = new ArrayList<EObject>(Pivot2Ecore.createResource(typeManager, pivotResource2));
		outputObjects.remove(EcoreUtils.getNamedElement((List<? extends ENamedElement>)outputObjects, PivotConstants.ORPHANAGE_NAME));
		if (outputObjects.size() == 1) {
			outputObjects = ((EPackage)outputObjects.get(0)).getESubpackages();
		}
		String inputName2 = stem + "2.ecore";
		URI inputURI2 = getProjectFileURI(inputName2);
		Resource ecoreResource2 = resourceSet.createResource(inputURI2);
		ecoreResource2.getContents().addAll(outputObjects);
		assertNoResourceErrors("Ecore2Pivot failed", ecoreResource2);
		ecoreResource2.save(null);
		assertNoValidationErrors("Ecore2Pivot invalid", ecoreResource2);
		//
		//
		//
//		assertSameModel(pivotResource, pivotResource2);
		assertSameModel(ecoreResource, ecoreResource2);
		
		return xtextResource;
	}

	/**
	 * Some example files have inconsistent self references so map the URI back to
	 * the resource.
	 */
	public void mapOwnURI(Resource resource) {
		List<EObject> contents = resource.getContents();
		if (contents.size() == 1) {
			EObject root = contents.get(0);
			if (root instanceof EPackage) {
				EPackage rootPackage = (EPackage) root;
				String nsURI = rootPackage.getNsURI();
				if (nsURI != null) {
					Map<URI, Resource> uriResourceMap = ((ResourceSetImpl)resourceSet).getURIResourceMap();
					if (uriResourceMap == null) {
						uriResourceMap = new HashMap<URI, Resource>();
						((ResourceSetImpl)resourceSet).setURIResourceMap(uriResourceMap);
					}
					uriResourceMap.put(URI.createURI(nsURI), resource);
				}
			}
		}
	}
	
	public void testBug320689Serialize() throws Exception {
		doSerialize("Bug320689");
	}

	public void testCompanySerialize() throws Exception {
//		Logger logger = Logger.getLogger(AbstractParseTreeConstructor.class);
//		logger.setLevel(Level.TRACE);
//		logger.addAppender(new ConsoleAppender(new SimpleLayout()));
//		BaseScopeProvider.LOOKUP.setState(true);
//		DocumentScopeAdapter.WORK.setState(true);
//		CS2PivotConversion.CONTINUATION.setState(true);
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		doSerialize("Company");
	}

// FIXME fails due to Bug 286558
	public void testEcoreSerialize() throws Exception {
		doSerialize("Ecore");
	}

	public void testImportsSerialize() throws Exception {
		XtextResource xtextResource = doSerialize("Imports");
		RootPackageCS documentCS = (RootPackageCS) xtextResource.getContents().get(0);
		List<ImportCS> imports = documentCS.getOwnedImport();
		assertEquals("One import", 1, imports.size());
	}

//	public void testMarkupSerialize() throws Exception {
//		doSerialize("Markup");
//	}

	public void testNamesSerialize() throws Exception {
		doSerialize("Names");
	}

	public void testOCLinEcoreCSTSerialize() throws Exception {
		doSerialize("OCLinEcoreCST");
	}

	public void testOCLstdlibSerialize() throws Exception {
		doSerialize("OCLstdlib");
	}

	public void testOCLSerialize() throws Exception {
		doSerialize("OCL");
	}

	public void testOCLCSTSerialize() throws Exception {
		doSerialize("OCLCST");
	}

	public void testOCLEcoreSerialize() throws Exception {
		doSerialize("OCLEcore");
	}

	public void testQVTSerialize() throws Exception {
		doSerialize("QVT");
	}	

	public void testXMLNamespaceSerialize() throws Exception {
		doSerialize("XMLNamespace");
	}	

	public void testXMLTypeSerialize() throws Exception {
		doSerialize("XMLType");
	}

	public void testOCLTestSerialize() throws Exception {
		doSerialize("OCLTest");
	}	
}
