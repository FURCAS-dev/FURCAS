/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
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
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.StandardDocumentScopeAdapter;

public class XtextTestCase extends TestCase
{	
	public static void assertNoDiagnosticErrors(String message, List<Diagnostic> diagnostics) {
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

	public static void assertNoResourceErrors(String message, List<Resource.Diagnostic> errors) {
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

	public static void assertNoUnresolvedProxies(String message, Map<EObject, Collection<Setting>> unresolvedProxies) {
		if (unresolvedProxies.size() > 0) {
			StringBuffer s = new StringBuffer();
			s.append(unresolvedProxies.size());
			s.append(" ");	
			s.append(message);
			for (Map.Entry<EObject, Collection<Setting>> unresolvedProxy : unresolvedProxies.entrySet()) {
				s.append("\n");	
				BasicEObjectImpl key = (BasicEObjectImpl) unresolvedProxy.getKey();
				s.append(key.eProxyURI());
				for (Setting setting : unresolvedProxy.getValue()) {
					s.append("\n\t");
					EObject eObject = setting.getEObject();
					s.append(eObject.toString());
				}
			}
			fail(s.toString());
		}
	}

	protected void assertNoValidationErrors(String string, EObject eObject) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuffer s = new StringBuffer();
		s.append(children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
			s.append(child.getMessage());
		}
		fail(s.toString());
	}
	
	public static void assertSameModel(Resource resource1, Resource resource2) throws IOException, InterruptedException {
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

	protected File getProjectFile() {
		String projectName = getProjectName();
		URL projectURL = getTestResource(projectName);	
		assertNotNull(projectURL);
		return new File(projectURL.getFile());
	}
	
	protected URI getProjectFileURI(String referenceName) {
		File projectFile = getProjectFile();
		return URI.createFileURI(projectFile.toString() + "/" + referenceName);
	}
	
	protected String getProjectName() {
		return getClass().getPackage().getName().replace('.', '/') + "/models";
	}

	protected URL getTestResource(String resourceName) {
		URL projectURL = getClass().getClassLoader().getResource(resourceName);
		if ((projectURL != null) && Platform.isRunning()) {
			try {
				projectURL = FileLocator.resolve(projectURL);
			} catch (IOException e) {
				TestCase.fail(e.getMessage());
				return null;
			}
		}
		return projectURL;
	}
	
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

	@Override
	protected void tearDown() throws Exception {
		resourceSet.getResources().clear();
		resourceSet = null;
		super.tearDown();
	}
}
