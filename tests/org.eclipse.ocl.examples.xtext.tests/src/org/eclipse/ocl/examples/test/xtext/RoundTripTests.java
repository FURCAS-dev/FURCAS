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
 * $Id: RoundTripTests.java,v 1.2 2010/05/06 17:34:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.List;

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
	public void doRoundTrip(String stem) throws IOException, InterruptedException {
		String inputName = stem + ".ecore";
		String middleName = stem + ".converted.xmi";
		String outputName = stem + ".regenerated.ecore";
		URI inputURI = getProjectFileURI(inputName);
		URI middleURI = getProjectFileURI(middleName);
		URI outputURI = getProjectFileURI(outputName);
		Resource leftResource = resourceSet.getResource(inputURI, true);
		OCLinEcoreDocumentCS csDocument = Ecore2OCLinEcore.importFromEcore(resourceSet, null, leftResource);
		List<Resource.Diagnostic> errors = csDocument.eResource().getErrors(); 
		assertEquals("From Ecore errors", 0, errors.size());
//		List<PackageCS> csObjects = new ArrayList<PackageCS>();
//		csObjects.addAll(csDocument.getPackages());
		Resource middleResource = resourceSet.createResource(middleURI);
//		middleResource.getContents().addAll(csObjects);
		middleResource.getContents().add(csDocument);
		middleResource.save(null);
		OCLinEcore2Ecore cs2e = new OCLinEcore2Ecore(resourceSet, middleResource, outputURI);
		Resource rightResource = cs2e.exportToEcore();
		assertEquals("To Ecore errors", 0, rightResource.getErrors().size());
		rightResource.save(null);
		resourceSet.getResources().add(rightResource);
    	assertSameModel(leftResource, rightResource);
	}

	public void testCompanyRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("Company");
	}

	public void testEcoreRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("Ecore");
	}

	public void testImportsRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("Imports");
	}

	public void testOCLinEcoreCSTRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCLinEcoreCST");
	}

	public void testOCLstdlibRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCLstdlib");
	}

	public void testOCLRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCL");
	}

	public void testOCLCSTRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCLCST");
	}

// FIXME fails due to Bug 308691
//	public void testOCLEcoreRoundTrip() throws IOException, InterruptedException {
//		doRoundTrip("OCLEcore");
//	}

	public void testQVTRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("QVT");
	}	

	public void testXMLNamespaceRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("XMLNamespace");
	}	

	public void testXMLTypeRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("XMLType");
	}
}
