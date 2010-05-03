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
 * $Id: OCLinEcoreTests.java,v 1.1 2010/05/03 05:34:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.Ecore2OCLinEcore;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.OCLinEcore2Ecore;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.StandardDocumentScopeAdapter;
import org.eclipse.xtext.resource.XtextResource;



public class OCLinEcoreTests extends UtilityTestCase {

	public void assertNoDiagnosticErrors(String message, List<Diagnostic> diagnostics) {
		if (diagnostics.size() > 0) {
			StringBuffer s = new StringBuffer();
			s.append(message);
			for (Diagnostic diagnostic : diagnostics) {
				s.append("\n");
				s.append(diagnostic.toString());
			}
			fail(s.toString());
		}
	}

	public void assertNoResourceErrors(String message, List<Resource.Diagnostic> errors) {
		if (errors.size() > 0) {
			StringBuffer s = new StringBuffer();
			s.append(message);
			for (Resource.Diagnostic conversionError : errors) {
				s.append("\n");
				s.append(conversionError.getMessage());
			}
			fail(s.toString());
		}
	}

	protected void assertSameModel(Resource resource1, Resource resource2) throws IOException, InterruptedException {
        MatchModel match = MatchService.doResourceMatch(resource1, resource2, Collections.<String, Object> emptyMap());
        List<UnmatchElement> unmatchedElements = match.getUnmatchedElements();
        int unmatchedSize = unmatchedElements.size();
		if (unmatchedSize > 0) {
			StringBuffer s = new StringBuffer();
			s.append(unmatchedSize);
			s.append(" unmatched element(s)");
			for (UnmatchElement unmatchedElement : unmatchedElements) {
				s.append("\n");
				s.append(unmatchedElement.getSide());
				s.append(": ");
				EObject element = unmatchedElement.getElement();
				s.append(element.eClass().getName());
				s.append(": ");
				s.append(element.toString());
			}
			fail(s.toString());
		}
        DiffModel diff = DiffService.doDiff(match, false);
        int subchanges = diff.getSubchanges();
		if (subchanges > 0) {
			StringBuffer s = new StringBuffer();
			s.append(subchanges);
			s.append(" changes");
			DiffSwitch<Boolean> diffSwitch = new DiffToText(s);
			diffSwitch.doSwitch(diff);
//            System.out.println(ModelUtils.serialize(diff));
			fail(s.toString());
		}
	}
	
	protected ResourceSet resourceSet;
	
	@Override
	protected void setUp() throws Exception {
		CompleteOCLStandaloneSetup.doSetup();
		OCLinEcoreStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		super.setUp();
		resourceSet = new ResourceSetImpl();
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
		uriMap.putAll(EcorePlugin.computePlatformURIMap());
		URI platformOCLstdlibURI = URI.createURI(StandardDocumentScopeAdapter.OCLSTDLIB_URI);
		URI projectURI = getProjectFileURI("dummy");
		URI projectOCLstdlibURI = URI.createURI("oclstdlib.oclstdlib").resolve(projectURI);
		uriMap.put(platformOCLstdlibURI, projectOCLstdlibURI);
	}
	
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
    	assertSameModel(leftResource, rightResource);
	}
	
	public void doSerialize(String stem) throws IOException {
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
	}

	public void testCompanyRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("Company");
	}

	public void testCompanySerialize() throws IOException, InterruptedException {
		doSerialize("Company");
	}

	public void testEcoreRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("Ecore");
	}

// FIXME fails due to Bug 286558
	public void testEcoreSerialize() throws IOException, InterruptedException {
		doSerialize("Ecore");
	}

	public void testOCLinEcoreCSTRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCLinEcoreCST");
	}

	public void testOCLinEcoreCSTSerialize() throws IOException, InterruptedException {
		doSerialize("OCLinEcoreCST");
	}

	public void testOCLstdlibRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCLstdlib");
	}

	public void testOCLstdlibSerialize() throws IOException, InterruptedException {
		doSerialize("OCLstdlib");
	}

	public void testOCLRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCL");
	}

// FIXME fails due to Bug 286558
	public void testOCLSerialize() throws IOException, InterruptedException {
		doSerialize("OCL");
	}

	public void testOCLCSTRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("OCLCST");
	}

// FIXME fails due to Bug 308691
//	public void testOCLEcoreRoundTrip() throws IOException, InterruptedException {
//		doRoundTrip("OCLEcore");
//	}

//	public void testTestSerialize() throws IOException, InterruptedException {
//		doRoundTrip("Test");
//		doSerialize("Test");
//	}

	public void testQVTRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("QVT");
	}	

	public void testQVTSerialize() throws IOException, InterruptedException {
		doSerialize("QVT");
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

	public void testXMLNamespaceRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("XMLNamespace");
	}	

	public void testXMLNamespaceSerialize() throws IOException, InterruptedException {
		doSerialize("XMLNamespace");
	}	

	public void testXMLTypeRoundTrip() throws IOException, InterruptedException {
		doRoundTrip("XMLType");
	}

	public void testXMLTypeSerialize() throws IOException, InterruptedException {
		doSerialize("XMLType");
	}
}
