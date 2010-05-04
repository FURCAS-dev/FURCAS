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
 * $Id: SerializeTests.java,v 1.2 2010/05/04 21:37:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.Ecore2OCLinEcore;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class SerializeTests extends XtextTestCase
{
	public OCLinEcoreDocumentCS doSerialize(String stem) throws IOException {
		String inputName = stem + ".ecore";
		String outputName = stem + ".oclinecore";
		URI inputURI = getProjectFileURI(inputName);
		URI outputURI = getProjectFileURI(outputName);
		Resource ecoreResource = resourceSet.getResource(inputURI, true);
//		List<String> conversionErrors = new ArrayList<String>();
		OCLinEcoreDocumentCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Conversion failed", eResource.getErrors());
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
		xtextResource.getContents().add(documentCS);
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
		assertNoDiagnosticErrors("Concrete Syntax valiation failed", diagnostics);
		xtextResource.save(null);
		
		resourceSet.getResources().clear();
		XtextResource reloadedResource = (XtextResource) resourceSet.getResource(outputURI, true);
		assertNoResourceErrors("Reload failed", reloadedResource.getErrors());
		
		
		return documentCS;
	}

	public void testCompanySerialize() throws IOException, InterruptedException {
		doSerialize("Company");
	}

// FIXME fails due to Bug 286558
	public void testEcoreSerialize() throws IOException, InterruptedException {
		doSerialize("Ecore");
	}

	public void testImportsSerialize() throws IOException, InterruptedException {
		OCLinEcoreDocumentCS documentCS = doSerialize("Imports");
		List<ImportCS> imports = documentCS.getImports();
		assertEquals("One import", 1, imports.size());
	}

	public void testOCLinEcoreCSTSerialize() throws IOException, InterruptedException {
		doSerialize("OCLinEcoreCST");
	}

	public void testOCLstdlibSerialize() throws IOException, InterruptedException {
		doSerialize("OCLstdlib");
	}

// FIXME fails due to Bug 286558
	public void testOCLSerialize() throws IOException, InterruptedException {
		doSerialize("OCL");
	}

//	public void testTestSerialize() throws IOException, InterruptedException {
//		doRoundTrip("Test");
//		doSerialize("Test");
//	}

	public void testQVTSerialize() throws IOException, InterruptedException {
		doSerialize("QVT");
	}	

	public void testXMLNamespaceSerialize() throws IOException, InterruptedException {
		doSerialize("XMLNamespace");
	}	

	public void testXMLTypeSerialize() throws IOException, InterruptedException {
		doSerialize("XMLType");
	}
}
