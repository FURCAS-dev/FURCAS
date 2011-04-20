/*******************************************************************************
 * Copyright (c) 2008,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.delegate.OCLInvocationDelegateFactory;
import org.eclipse.ocl.examples.pivot.delegate.OCLSettingDelegateFactory;
import org.eclipse.ocl.examples.pivot.delegate.OCLValidationDelegateFactory;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagedAdapter;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceSetAdapter;
import org.eclipse.ocl.examples.test.xtext.DiffToText;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.oclinecore.OCLinEcoreStandaloneSetup;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs.OCLinEcorePivot2CS;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;

public class XtextTestCase extends TestCase
{	
	private static final class TestCaseAppender extends ConsoleAppender {

		public TestCaseAppender() {
			super(new SimpleLayout(), SYSTEM_OUT); 
			setName("TestHarness");
		}
		
		@Override
		public void append(LoggingEvent event) {
			if (event.getLevel().isGreaterOrEqual(Level.INFO)) {
				String renderedMessage = event.getRenderedMessage();
				ThrowableInformation throwableInformation = event.getThrowableInformation();
				Throwable throwable = throwableInformation != null ? throwableInformation.getThrowable() : null;
				throw new Error(renderedMessage, throwable);
			}
//			super.append(event);
		}
	}

	public static void assertNoDiagnosticErrors(String message, XtextResource xtextResource) {
		List<Diagnostic> diagnostics = xtextResource.validateConcreteSyntax();
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

	public static void assertNoResourceErrors(String prefix, Resource resource) {
		String message = PivotUtil.getResourceErrorsString(resource, prefix);
		if (message != null)
			fail(message);
	}

	public static void assertNoUnresolvedProxies(String message, Resource resource) {
		Map<EObject, Collection<Setting>> unresolvedProxies = UnresolvedProxyCrossReferencer.find(resource);
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

	protected void assertNoValidationErrors(String string, Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(string, eObject);
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

	protected void assertPivotIsValid(URI pivotURI) {
		ResourceSet reloadResourceSet = new ResourceSetImpl();
		reloadResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pivot", new EcoreResourceFactoryImpl());
		Resource reloadedPivotResource = reloadResourceSet.getResource(pivotURI, true);
		TypeManager typeManager = new TypeManager();
		for (TreeIterator<EObject> tit = reloadedPivotResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				typeManager.installPackageMoniker((org.eclipse.ocl.examples.pivot.Package) eObject);
			}
			
		}
		assertNoValidationErrors("Pivot reload validation problems", reloadedPivotResource);
	}
	
	public static void assertSameModel(Resource expectedResource, Resource actualResource) throws IOException, InterruptedException {
		Map<String,Object> options = new HashMap<String,Object>();
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
//		options.put(MatchOptions.OPTION_DISTINCT_METAMODELS, Boolean.TRUE);
        MatchModel match = MatchService.doResourceMatch(actualResource, expectedResource, options);
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
	
	/**
	 * Install a platform:/resource/project... mapping for all folders in
	 * $WORKSPACE_LOC/* if defined, or $user.dir/../* otherwise.
	 */
	public static void configurePlatformResources() {
		if (!eclipseIsRunning()) {
			String urlString = System.getProperty("WORKSPACE_LOC");
			File workspaceLoc;
			if (urlString != null) {
				workspaceLoc = new File(urlString);
			}
			else {
				workspaceLoc = new File(System.getProperty("user.dir")).getParentFile();
			}
			File[] files = workspaceLoc.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					String name = file.getName();
					EcorePlugin.getPlatformResourceMap().put(name, URI.createFileURI(file.toString() + "/"));
				}
			}
		}
	}

	public static boolean eclipseIsRunning() {
		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform");
			Method isRunningMethod = platformClass.getDeclaredMethod("isRunning");
			return Boolean.TRUE.equals(isRunningMethod.invoke(null));
		} catch (Exception e) {
		}
		return false;
	}

	protected static boolean hasCorrespondingCS(MonikeredElement pivotElement) {
		if (!isValidPivot(pivotElement)) {
			return false;
		}
		if (pivotElement instanceof ExpressionInOcl) {
			return false;
		}
		if ((pivotElement instanceof Variable) && (pivotElement.eContainer() instanceof ExpressionInOcl)) {
			return false;
		}
		if ((pivotElement instanceof Variable) && (pivotElement.eContainer() instanceof LoopExp)
				&& Character.isDigit((((Variable)pivotElement).getName().charAt(0)))) {
			return false;
		}
//		if (pivotElement instanceof TemplateBinding) {
//			return false;
//		}
//		if ((pivotElement instanceof TemplateableElement) && (((TemplateableElement)pivotElement).getTemplateBindings().size() > 0)) {
//			return false;
//		}
		return true;
	}

//	protected static boolean hasOptionalCS(MonikeredElement pivotElement) {
//		if ((pivotElement instanceof LetExp) && (pivotElement.eContainer() instanceof LetExp)) {
//			return false;
//		}
//		return true;
//	}

	protected static boolean hasCorrespondingPivot(MonikeredElementCS csElement) {
		if (csElement instanceof TupleTypeCS) {
			return true;
		}
		if (csElement instanceof TuplePartCS) {		// FIXME orphanage ambiguity
			return false;
		}
//		if (csElement instanceof TypeRefCS) {
//			return false;
//		}
		if (csElement instanceof InfixExpCS) {
			return false;
		}
		if (csElement instanceof NestedExpCS) {
			return false;
		}
		if (csElement instanceof PrefixExpCS) {
			return false;
		}
		if (csElement instanceof NavigatingArgCS) {
			return false;
		}
		if (csElement instanceof NavigatingExpCS) {
			return false;
		}
		if (csElement instanceof NavigationOperatorCS) {
			return false;
		}
		if (csElement instanceof CollectionTypeCS) {
			return false;
		}
		if (csElement instanceof TypeNameExpCS) {
			return false;
		}
		return true;
	}

	protected static boolean hasUniqueMoniker(MonikeredElementCS csElement) {
		if (csElement instanceof TupleTypeCS) {
			return false;
		}
		if (csElement instanceof TypeRefCS) {
			return false;
		}
		if (csElement instanceof InfixExpCS) {
			return false;
		}
		if (csElement instanceof NestedExpCS) {
			return false;
		}
		if (csElement instanceof PrefixExpCS) {
			return false;
		}
		if (csElement instanceof NavigatingExpCS) {
			return false;
		}
		if (csElement instanceof NavigationOperatorCS) {
			return false;
		}
		if (csElement instanceof CollectionTypeCS) {
			return false;
		}
		return true;
	}
	
	protected static boolean isValidPivot(Element pivotElement) {
		if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Package) {
			if ((pivotElement.eContainer() == null) && PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) pivotElement).getName())) {
				return false;
			}
		}
		if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Class) {
			EObject eContainer = pivotElement.eContainer();
			if ((eContainer instanceof org.eclipse.ocl.examples.pivot.Package) && (eContainer.eContainer() == null)
					&& PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) pivotElement).getName())
					&& PivotConstants.ORPHANAGE_NAME.equals(((NamedElement) eContainer).getName())) {
				return false;
			}
		}
		if ((pivotElement instanceof TemplateableElement) && (((TemplateableElement)pivotElement).getTemplateBindings().size() > 0)) {
			return false;
		}
		if (pivotElement instanceof LambdaType) {
			return false;
		}
		if (pivotElement instanceof TupleType) {
			return false;
		}
		if ((pivotElement instanceof Property) && (pivotElement.eContainer() instanceof TupleType)) {
			return false;
		}
		if ((pivotElement instanceof VariableExp) && (pivotElement.eContainer() instanceof OperationCallExp)) {
			return false;
		}
		return true;
	}

	public static void unloadCS(ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.findAdapter(resource);
			if (adapter != null) {
				adapter.dispose();
			}
		}
	}

	public static void unloadPivot(TypeManager typeManager) {
		List<TypeManagedAdapter> adapters = new ArrayList<TypeManagedAdapter>();
		for (Resource resource : typeManager.getPivotResourceSet().getResources()) {
			for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				for (Adapter adapter : eObject.eAdapters()) {
					if (adapter instanceof TypeManagedAdapter) {
						adapters.add((TypeManagedAdapter)adapter);
					}
				}
			}
		}
		for (TypeManagedAdapter adapter : adapters) {
			adapter.dispose();
		}
		typeManager.dispose();
	}
	
	protected ResourceSet resourceSet;
	protected Logger rootLogger = Logger.getRootLogger();
	protected TestCaseAppender testCaseAppender = new TestCaseAppender();

	protected XtextResource savePivotAsCS(TypeManager typeManager, Resource pivotResource, URI outputURI) throws IOException {
//		ResourceSet csResourceSet = resourceSet; //new ResourceSetImpl();
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
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(xtextResource.getContents());
			xmiResource.save(null);
			fail(e.toString());
		}
		return xtextResource;
	}

	protected Resource getPivotFromEcore(TypeManager typeManager, Resource ecoreResource) {
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, typeManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = ecore2Pivot.getPivotRoot();
		Resource pivotResource = pivotRoot.eResource();
		assertNoResourceErrors("Normalisation failed", pivotResource);
		assertNoValidationErrors("Normalisation invalid", pivotResource);
		return pivotResource;
	}

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

	protected Resource loadEcore(URI inputURI) {
		Resource ecoreResource = resourceSet.getResource(inputURI, true);
		mapOwnURI(ecoreResource);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", ecoreResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		return ecoreResource;
	}

	/**
	 * Some example files have inconsistent self references so map the URI back to
	 * the resource.
	 */
	protected void mapOwnURI(Resource resource) {
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

	protected Resource savePivotAsEcore(TypeManager typeManager, Resource pivotResource, URI ecoreURI) throws IOException {
		List<? extends EObject> outputObjects = new ArrayList<EObject>(Pivot2Ecore.createResource(typeManager, pivotResource));
		@SuppressWarnings("unchecked")
		List<? extends ENamedElement> castOutputObjects = (List<? extends ENamedElement>)outputObjects;
		outputObjects.remove(EcoreUtils.getNamedElement(castOutputObjects, PivotConstants.ORPHANAGE_NAME));
		EPackage rootPackage = null;
		if (outputObjects.size() == 1) {
			rootPackage = (EPackage)outputObjects.get(0);
			outputObjects = rootPackage.getESubpackages();
		}
		Resource ecoreResource = resourceSet.createResource(ecoreURI != null ? ecoreURI : URI.createURI("test.ecore"));
		ecoreResource.getContents().addAll(outputObjects);
		if (rootPackage != null) {
			rootPackage.getESubpackages().clear();
		}
		assertNoResourceErrors("Ecore2Pivot failed", ecoreResource);
		if (ecoreURI != null) {
			ecoreResource.save(null);
		}
		assertNoValidationErrors("Ecore2Pivot invalid", ecoreResource);
		return ecoreResource;
	}

	protected Resource savePivotFromCS(TypeManager typeManager, BaseCSResource xtextResource, URI pivotURI) throws IOException {
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, typeManager);
		Resource pivotResource = adapter.getPivotResource(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", pivotResource);
		if (pivotURI != null) {
			pivotResource.setURI(pivotURI);
			pivotResource.save(null);
		}
		return pivotResource;
	}
	
	@Override
	protected void setUp() throws Exception {
//		System.out.println("---------------Starting " + getName() + "---------------");
//		rootLogger.setLevel(Level.TRACE);
		rootLogger.addAppender(testCaseAppender);
//		rootLogger.removeAppender("default");
		CompleteOCLStandaloneSetup.doSetup();
		OCLinEcoreStandaloneSetup.doSetup();
		OCLstdlibStandaloneSetup.doSetup();
		super.setUp();
		resourceSet = new ResourceSetImpl();
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
		uriMap.putAll(EcorePlugin.computePlatformURIMap());
//		for (Map.Entry<URI,URI> entry : uriMap.entrySet()) {
//			System.out.println(entry.getKey() + " => " + entry.getValue());
//		}
//		URI platformOCLstdlibURI = URI.createURI(StandardDocumentScopeAdapter.OCLSTDLIB_URI);
//		URI projectURI = getProjectFileURI("dummy");
//		URI projectOCLstdlibURI = URI.createURI("oclstdlib.oclstdlib").resolve(projectURI);
//		uriMap.put(platformOCLstdlibURI, projectOCLstdlibURI);
		StandardLibraryContribution.REGISTRY.put(TypeManager.DEFAULT_OCL_STDLIB_URI, new OCLstdlib.Loader());

        String oclDelegateURI = OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT;
        EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
            new OCLInvocationDelegateFactory.Global());
        EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI,
            new OCLSettingDelegateFactory.Global());
        EValidator.ValidationDelegate.Registry.INSTANCE.put(oclDelegateURI,
            new OCLValidationDelegateFactory.Global());
	
	}

	@Override
	protected void tearDown() throws Exception {
		TypeManagerResourceSetAdapter rsAdapter = TypeManagerResourceSetAdapter.findAdapter(resourceSet);
		try {
			if (rsAdapter != null) {
				TypeManager typeManager = rsAdapter.getTypeManager();
				if (typeManager != null) {
					ResourceSet pivotResourceSet = typeManager.getPivotResourceSet();
					for (Resource resource : pivotResourceSet.getResources()) {
						for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
							EObject eObject = tit.next();
							for (Adapter adapter : eObject.eAdapters()) {
								assert !(adapter instanceof TypeManagedAdapter);
							}
						}
					}
				}
			}
			for (Resource resource : resourceSet.getResources()) {
				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					for (Adapter adapter : eObject.eAdapters()) {
						assert !(adapter instanceof TypeManagedAdapter);
					}
				}
			}		
			resourceSet.getResources().clear();
			resourceSet = null;
		} finally {
			if (resourceSet != null) {
				unloadCS(resourceSet);
			}
			if (rsAdapter != null) {
				unloadPivot(rsAdapter.getTypeManager());
			}
			super.tearDown();
		}
	}
}
