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
 * $Id: SerializeTests.java,v 1.15 2011/05/12 06:23:50 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.uml.UML2Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class SerializeTests extends XtextTestCase
{
	public XtextResource doSerialize(String stem) throws Exception {
		//
		//	Load as Ecore
		//
		String inputName = stem + ".ecore";
		URI inputURI = getProjectFileURI(inputName);
		Resource ecoreResource = loadEcore(inputURI);
		//
		//	Ecore to Pivot
		//		
		TypeManager typeManager = new TypeManager();
		Resource pivotResource = getPivotFromEcore(typeManager, ecoreResource);
		//
		//	Pivot to CS
		//		
		String outputName = stem + ".serialized.oclinecore";
		URI outputURI = getProjectFileURI(outputName);
		XtextResource xtextResource = savePivotAsCS(typeManager, pivotResource, outputURI);
		resourceSet.getResources().clear();
		BaseCSResource xtextResource2 = (BaseCSResource) resourceSet.getResource(outputURI, true);
		assertNoResourceErrors("Reload failed", xtextResource2);
		assertNoUnresolvedProxies("unresolved reload proxies", xtextResource2);
		//
		//	CS to Pivot
		//	
		String pivotName2 = stem + "2.ecore.pivot";
		URI pivotURI2 = getProjectFileURI(pivotName2);
		Resource pivotResource2 = savePivotFromCS(typeManager, xtextResource2, pivotURI2);
		//
		//	Pivot to Ecore
		//		
		String inputName2 = stem + "2.ecore";
		URI ecoreURI2 = getProjectFileURI(inputName2);
		Resource ecoreResource2 = savePivotAsEcore(typeManager, pivotResource2, ecoreURI2, true);
		//
		//
		//
//		assertSameModel(pivotResource, pivotResource2);
		assertSameModel(ecoreResource, ecoreResource2);		
		return xtextResource;
	}
	
	public XtextResource doSerializeUML(String stem) throws Exception {
		UMLPackage.eINSTANCE.getClass();
		//
		//	Load as Ecore
		//
		String inputName = stem + ".uml";
		URI inputURI = getProjectFileURI(inputName);
		Resource umlResource = loadUML(inputURI);
		//
		//	Ecore to Pivot
		//		
		TypeManager typeManager = new TypeManager();
		Resource pivotResource = getPivotFromUML(typeManager, umlResource);
		//
		//	Pivot to CS
		//		
		String outputName = stem + ".serialized.oclinecore";
		URI outputURI = getProjectFileURI(outputName);
		XtextResource xtextResource = savePivotAsCS(typeManager, pivotResource, outputURI);
		resourceSet.getResources().clear();
		BaseCSResource xtextResource2 = (BaseCSResource) resourceSet.getResource(outputURI, true);
		assertNoResourceErrors("Reload failed", xtextResource2);
		assertNoUnresolvedProxies("unresolved reload proxies", xtextResource2);
		//
		//	CS to Pivot
		//	
		String pivotName2 = stem + "2.ecore.pivot";
		URI pivotURI2 = getProjectFileURI(pivotName2);
		Resource pivotResource2 = savePivotFromCS(typeManager, xtextResource2, pivotURI2);
		//
		//	Pivot to Ecore
		//		
		String inputName2 = stem + "2.ecore";
		URI ecoreURI2 = getProjectFileURI(inputName2);
		Resource ecoreResource2 = savePivotAsEcore(typeManager, pivotResource2, ecoreURI2, true);
		//
		//
		//
//		assertSameModel(pivotResource, pivotResource2);
		assertSameModel(umlResource, ecoreResource2);		
		return xtextResource;
	}

	protected Resource getPivotFromUML(TypeManager typeManager, Resource umlResource) {
		UML2Ecore2Pivot uml2Ecore2Pivot = UML2Ecore2Pivot.getAdapter(umlResource, typeManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = uml2Ecore2Pivot.getPivotRoot();
		Resource pivotResource = pivotRoot.eResource();
		assertNoResourceErrors("Normalisation failed", pivotResource);
		assertNoValidationErrors("Normalisation invalid", pivotResource);
		return pivotResource;
	}

	protected Resource loadUML(URI inputURI) {
//		ResourceSet resourceSet = typeManager.getExternalResourceSet();
		assertNull(UML2Ecore2Pivot.initialize(resourceSet));
		Resource umlResource = resourceSet.getResource(inputURI, true);
		mapOwnURI(umlResource);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", umlResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		return umlResource;
	}
	
	public void testBug320689Serialize() throws Exception {
		doSerialize("Bug320689");
	}
	
	public void testLoad_Bug323741Serialize() throws Exception {
		doSerialize("Bug323741");
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

	public void testKeysSerialize() throws Exception {
		doSerialize("Keys");
	}

	//	public void testMarkupSerialize() throws Exception {
//		doSerialize("Markup");
//	}

//	public void test_model_uml_Serialize() throws Exception {
//		doSerializeUML("model");
//	}

	public void test_Fruit_uml_Serialize() throws Exception {
		doSerializeUML("Fruit");
	}

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

	public void testRoyalAndLoyalSerialize() throws Exception {
		doSerialize("RoyalAndLoyal");
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
