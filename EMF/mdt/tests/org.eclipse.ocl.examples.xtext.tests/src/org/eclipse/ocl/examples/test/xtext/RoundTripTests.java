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
 * $Id: RoundTripTests.java,v 1.5 2011/01/27 07:05:41 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.uml.Pivot2UML;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Test that an Ecore file can be loaded as OCLinEcore than saved back as Ecore.
 */
public class RoundTripTests extends XtextTestCase
{
	public void doRoundTripFromEcore(String stem) throws IOException, InterruptedException {
		String inputName = stem + ".ecore";
		String pivotName = stem + ".ecore.pivot";
		String outputName = stem + ".regenerated.ecore";
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = getProjectFileURI(pivotName);
		URI outputURI = getProjectFileURI(outputName);
		Resource inputResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Ecore load", inputResource);
		assertNoValidationErrors("Ecore load", inputResource);
		
		TypeManager typeManager = new TypeManager();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(inputResource, typeManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = ecore2Pivot.getPivotRoot();
		Resource pivotResource = pivotRoot.eResource();
		pivotResource.setURI(pivotURI);
		assertNoResourceErrors("Ecore2Pivot failed", pivotResource);
		pivotResource.save(null);
		assertNoValidationErrors("Ecore2Pivot invalid", pivotResource);
		
		List<? extends EObject> outputObjects = new ArrayList<EObject>(Pivot2Ecore.createResource(typeManager, pivotResource));
		outputObjects.remove(EcoreUtils.getNamedElement((List<? extends ENamedElement>)outputObjects, PivotConstants.ORPHANAGE_NAME));
		if (outputObjects.size() == 1) {
			outputObjects = ((EPackage)outputObjects.get(0)).getESubpackages();
		}
		Resource outputResource = resourceSet.createResource(outputURI);
		outputResource.getContents().addAll(outputObjects);
		assertNoResourceErrors("Ecore2Pivot failed", outputResource);
		outputResource.save(null);
		assertNoValidationErrors("Ecore2Pivot invalid", outputResource);
		
//		RootPackageCS csDocument = null; // FIXME Ecore2OCLinEcore.importFromEcore(resourceSet, null, leftResource);
//		assertNoResourceErrors("From Ecore errors", csDocument.eResource());
//		List<PackageCS> csObjects = new ArrayList<PackageCS>();
//		csObjects.addAll(csDocument.getPackages());
//		Resource middleResource = resourceSet.createResource(middleURI);
//		middleResource.getContents().addAll(csObjects);
//		middleResource.getContents().add(csDocument);
//		middleResource.save(null);
//		OCLinEcore2Ecore cs2e = new OCLinEcore2Ecore(resourceSet, middleResource, outputURI);
//		Resource rightResource = cs2e.exportToEcore();
//		assertNoResourceErrors("To Ecore errors", rightResource);
//		rightResource.save(null);
//		resourceSet.getResources().add(rightResource);
		assertSameModel(inputResource, outputResource);
	}

	public void doRoundTripFromOclInEcore(String stem) throws IOException, InterruptedException {
		String inputName = stem + ".oclinecore";
		String middleName = stem + ".converted.ecore";
		String outputName = stem + ".regenerated.oclinecore";
		String output2Name = stem + ".reconverted.ecore";
		URI inputURI = getProjectFileURI(inputName);
		URI middleURI = getProjectFileURI(middleName);
		URI outputURI = getProjectFileURI(outputName);
		URI output2URI = getProjectFileURI(output2Name);
		Resource leftResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Load failed", leftResource);
//		OCLinEcore2Ecore cs2e = new OCLinEcore2Ecore(resourceSet, leftResource, middleURI);
//		Resource middleResource = cs2e.exportToEcore();
//		assertEquals("To Ecore errors", 0, middleResource.getErrors().size());
//		middleResource.save(null);
//		resourceSet.getResources().add(middleResource);
		RootPackageCS csDocument = null; // FIXME Ecore2OCLinEcore.importFromEcore(resourceSet, null, middleResource);
		assertNoResourceErrors("From Ecore errors", csDocument.eResource());
		Resource rightResource = resourceSet.createResource(outputURI);
//		middleResource.getContents().addAll(csObjects);
		rightResource.getContents().add(csDocument);
		rightResource.save(null);
//		OCLinEcore2Ecore cs2e2 = new OCLinEcore2Ecore(resourceSet, rightResource, output2URI);
//		Resource right2Resource = cs2e2.exportToEcore();
		assertNoResourceErrors("To Ecore errors", rightResource);
//		right2Resource.save(null);
//		resourceSet.getResources().add(right2Resource);
//    	assertSameModel(middleResource, right2Resource);
	}
	
	public void doRoundTripFromUml(String stem) throws IOException, InterruptedException {
//		Environment.Registry.INSTANCE.registerEnvironment(
//			new UMLEnvironmentFactory().createEnvironment());
		ResourceSet resourceSet = new ResourceSetImpl();
		assertNull(org.eclipse.ocl.uml.OCL.initialize(resourceSet));
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
//		assertNull(org.eclipse.ocl.uml.OCL.initialize(null));		
//		org.eclipse.uml2.uml.Package umlMetamodel = (org.eclipse.uml2.uml.Package) resourceSet.getResource(
//			URI.createURI(UMLResource.UML_METAMODEL_URI),
//			true).getContents().get(0);
//		org.eclipse.uml2.uml.Package umlPrimitiveTypes = (org.eclipse.uml2.uml.Package) resourceSet.getResource(
//			URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI),
//			true).getContents().get(0);
//		org.eclipse.uml2.uml.Package ecorePrimitiveTypes = (org.eclipse.uml2.uml.Package) resourceSet.getResource(
//			URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI),
//			true).getContents().get(0);
		String inputName = stem + ".uml";
		String pivotName = stem + ".pivot";
		String outputName = stem + ".regenerated.uml";
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = getProjectFileURI(pivotName);
		URI outputURI = getProjectFileURI(outputName);
		Resource inputResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("UML load", inputResource);
		assertNoValidationErrors("UML load", inputResource);
		
		TypeManager pivotManager = new TypeManager();
		UML2Pivot uml2Pivot = UML2Pivot.getAdapter(inputResource, pivotManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = uml2Pivot.getPivotRoot();
		Resource pivotResource = pivotRoot.eResource();
		pivotResource.setURI(pivotURI);
		assertNoResourceErrors("UML2Pivot failed", pivotResource);
		pivotResource.save(null);
		assertNoValidationErrors("UML2Pivot invalid", pivotResource);
		
		List<? extends EObject> outputObjects = new ArrayList<EObject>(Pivot2UML.createResource(pivotManager, pivotResource));
		outputObjects.remove(getNamedElement((List<? extends org.eclipse.uml2.uml.NamedElement>)outputObjects, "orphanage"));
		if (outputObjects.size() == 1) {
			outputObjects = ((org.eclipse.uml2.uml.Package)outputObjects.get(0)).getNestedPackages();
		}
		Resource outputResource = resourceSet.createResource(outputURI);
		outputResource.getContents().addAll(outputObjects);
		assertNoResourceErrors("UML2Pivot failed", outputResource);
		outputResource.save(null);
		assertNoValidationErrors("UML2Pivot invalid", outputResource);
		assertSameModel(inputResource, outputResource);
	}

	public static <T extends org.eclipse.uml2.uml.NamedElement> T getNamedElement(Collection<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}

	public void testCompanyRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Company");
	}

	public void testEcoreRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Ecore");
	}

	public void testImportsRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Imports");
	}

	public void testOCLinEcoreCSTRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("OCLinEcoreCST");
	}

	public void testOCLstdlibRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("OCLstdlib");
	}

	public void testOCLRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("OCL");
	}

	public void testOCLCSTRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("OCLCST");
	}

// FIXME fails due to Bug 308691
//	public void testOCLEcoreRoundTrip() throws IOException, InterruptedException {
//		URI ecorePluginURI = URI.createPlatformPluginURI("org.eclipse.emf.ecore/model/Ecore.ecore", false);
//		Map<URI, Resource> uriResourceMap = new HashMap<URI, Resource>();
//		uriResourceMap.put(ecorePluginURI, EcorePackage.eINSTANCE.eResource());
//		((ResourceSetImpl) resourceSet).setURIResourceMap(uriResourceMap);
//		doRoundTripFromEcore("OCLEcore");
//	}

	public void testQVTRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("QVT");
	}	

	public void testTypes_ecore() throws IOException, InterruptedException {
		doRoundTripFromEcore("Types");
	}

//	public void testTypes_oclinecore() throws IOException, InterruptedException {
//		BaseScopeProvider.LOOKUP.setState(true);		// FIXME CCE if this line commented out
//		doRoundTripFromOclInEcore("Types");
//	}

	public void testXMLNamespaceRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("XMLNamespace");
	}	

	public void testXMLTypeRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("XMLType");
	}

//	public void testMy_uml() throws IOException, InterruptedException {
//		doRoundTripFromUml("My");
//	}

//	public void testTriangle_uml() throws IOException, InterruptedException {
//		doRoundTripFromUml("Triangle");
//	}

//	public void testProfile_less_Ecore_metamodel_uml() throws IOException, InterruptedException {
//		doRoundTripFromUml("Profile-less-Ecore.metamodel");
//	}
}