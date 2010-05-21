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
 * $Id: RoundTripTests.java,v 1.3 2010/05/21 20:24:54 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.Ecore2OCLinEcore;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.OCLinEcore2Ecore;

/**
 * Test that an Ecore file can be loaded as OCLinEcore than saved back as Ecore.
 */
public class RoundTripTests extends XtextTestCase
{
	public void doRoundTripFromEcore(String stem) throws IOException, InterruptedException {
		String inputName = stem + ".ecore";
		String middleName = stem + ".converted.oclinecore";
		String outputName = stem + ".regenerated.ecore";
		URI inputURI = getProjectFileURI(inputName);
		URI middleURI = getProjectFileURI(middleName);
		URI outputURI = getProjectFileURI(outputName);
		Resource leftResource = resourceSet.getResource(inputURI, true);
		OCLinEcoreDocumentCS csDocument = Ecore2OCLinEcore.importFromEcore(resourceSet, null, leftResource);
		assertNoResourceErrors("From Ecore errors", csDocument.eResource().getErrors());
//		List<PackageCS> csObjects = new ArrayList<PackageCS>();
//		csObjects.addAll(csDocument.getPackages());
		Resource middleResource = resourceSet.createResource(middleURI);
//		middleResource.getContents().addAll(csObjects);
		middleResource.getContents().add(csDocument);
		middleResource.save(null);
		OCLinEcore2Ecore cs2e = new OCLinEcore2Ecore(resourceSet, middleResource, outputURI);
		Resource rightResource = cs2e.exportToEcore();
		assertNoResourceErrors("To Ecore errors", rightResource.getErrors());
		rightResource.save(null);
		resourceSet.getResources().add(rightResource);
    	assertSameModel(leftResource, rightResource);
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
		assertNoResourceErrors("Load failed", leftResource.getErrors());
		OCLinEcore2Ecore cs2e = new OCLinEcore2Ecore(resourceSet, leftResource, middleURI);
		Resource middleResource = cs2e.exportToEcore();
		assertEquals("To Ecore errors", 0, middleResource.getErrors().size());
		middleResource.save(null);
		resourceSet.getResources().add(middleResource);
		OCLinEcoreDocumentCS csDocument = Ecore2OCLinEcore.importFromEcore(resourceSet, null, middleResource);
		assertNoResourceErrors("From Ecore errors", csDocument.eResource().getErrors());
		Resource rightResource = resourceSet.createResource(outputURI);
//		middleResource.getContents().addAll(csObjects);
		rightResource.getContents().add(csDocument);
		rightResource.save(null);
		OCLinEcore2Ecore cs2e2 = new OCLinEcore2Ecore(resourceSet, rightResource, output2URI);
		Resource right2Resource = cs2e2.exportToEcore();
		assertNoResourceErrors("To Ecore errors", rightResource.getErrors());
		right2Resource.save(null);
		resourceSet.getResources().add(right2Resource);
    	assertSameModel(middleResource, right2Resource);
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

	public void testTypes_oclinecore() throws IOException, InterruptedException {
//		BaseScopeProvider.LOOKUP.setState(true);		// FIXME CCE if this line commented out
		doRoundTripFromOclInEcore("Types");
	}

	public void testXMLNamespaceRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("XMLNamespace");
	}	

	public void testXMLTypeRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("XMLType");
	}
}
