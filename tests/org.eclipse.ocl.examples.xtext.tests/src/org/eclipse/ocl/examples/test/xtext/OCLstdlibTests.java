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
 * $Id: OCLstdlibTests.java,v 1.5 2011/04/25 09:49:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;

import com.google.common.collect.Iterables;

/**
 * Tests.
 */
public class OCLstdlibTests extends XtextTestCase
{
	public static class MonikeredComparator implements Comparator<MonikeredElement>
	{
		public int compare(MonikeredElement o1, MonikeredElement o2) {
			return o1.getMoniker().compareTo(o2.getMoniker());
		}
	}

	/**
	 * Checks that the local oclstdlib.oclstdlib is the same as the pre-compiled
	 * Java implementation.
	 * 
	 * FIXME check the library/model version instead.
	 */
	public void testOCLstdlib() throws Exception {
		//
		//	Load oclstdlib.oclstdlib as a file.
		//
		URI libraryURI = getProjectFileURI("oclstdlib.oclstdlib");
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(libraryURI, true);
		assertNoResourceErrors("Load failed", xtextResource);
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, null);
		adapter.refreshPivotMappings();
		Resource fileResource = adapter.getPivotResource(xtextResource);
		assertNoResourceErrors("File Model", fileResource);
		assertNoUnresolvedProxies("File Model", fileResource);
		assertNoValidationErrors("File Model", fileResource);
		//
		//	Load 'oclstdlib.oclstdlib' as pre-code-generated Java.
		//
		Resource javaResource = OCLstdlib.INSTANCE;
//		PivotAliasCreator.refreshPackageAliases(javaResource);
		assertNoResourceErrors("Java Model", javaResource);
		assertNoUnresolvedProxies("Java Model", javaResource);
		assertNoValidationErrors("Java Model", javaResource);
		//
		//	Check similar content
		//
		Map<String,MonikeredElement> fileMoniker2PivotMap = new TypeManager().computeMoniker2PivotMap(Collections.singletonList(fileResource));
//		for (String moniker : fileMoniker2PivotMap.keySet()) {
//			System.out.println("File : " + moniker);
//		}
		Map<String,MonikeredElement> javaMoniker2PivotMap = new TypeManager().computeMoniker2PivotMap(Collections.singletonList(javaResource));
//		for (String moniker : javaMoniker2PivotMap.keySet()) {
//			System.out.println("Java : " + moniker);
//		}
//		assertEquals(fileMoniker2PivotMap.size(), javaMoniker2PivotMap.size());
		for (String moniker : fileMoniker2PivotMap.keySet()) {
			MonikeredElement fileElement = fileMoniker2PivotMap.get(moniker);
			MonikeredElement javaElement = javaMoniker2PivotMap.get(moniker);
			assertNotNull("Missing java element for '" + moniker + "'", javaElement);
			assertEquals(fileElement.getClass(), javaElement.getClass());
			if (fileElement instanceof TypedElement) {
				Type fileType = ((TypedElement)fileElement).getType();
				Type javaType = ((TypedElement)javaElement).getType();
				assertEquals(fileType.getClass(), javaType.getClass());
				assertEquals(fileType.getMoniker(), javaType.getMoniker());
			}
			if (fileElement instanceof Feature) {
				String fileClass = ((Feature)fileElement).getImplementationClass();
				String javaClass = ((Feature)javaElement).getImplementationClass();
				if (fileClass == null) {
					CallableImplementation implementation = ((Feature)fileElement).getImplementation();
					if (implementation != null) {
						fileClass = implementation.getClass().getCanonicalName();
					}
				}
				if (javaClass == null) {
					CallableImplementation implementation = ((Feature)javaElement).getImplementation();
					if (implementation != null) {
						javaClass = implementation.getClass().getCanonicalName();
					}
				}
				assertEquals(fileClass, javaClass);
			}
			if (fileElement instanceof org.eclipse.ocl.examples.pivot.Class) {
				List<MonikeredElement> fileTypes = new ArrayList<MonikeredElement>(((org.eclipse.ocl.examples.pivot.Class)fileElement).getSuperClasses());
				List<MonikeredElement> javaTypes = new ArrayList<MonikeredElement>(((org.eclipse.ocl.examples.pivot.Class)javaElement).getSuperClasses());
				Collections.sort(fileTypes, new MonikeredComparator());
				Collections.sort(javaTypes, new MonikeredComparator());
				assertEquals(fileTypes.size(), javaTypes.size());
				for (int i = 0; i < fileTypes.size(); i++) {
					MonikeredElement fileType = fileTypes.get(i);
					MonikeredElement javaType = javaTypes.get(i);
					assertEquals(fileType.getMoniker(), javaType.getMoniker());
				}
			}
		}
	}
	
	public void testOkAssignPrecedences() {
		Collection<org.eclipse.ocl.examples.pivot.Package> rootPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		org.eclipse.ocl.examples.pivot.Package root1 = PivotFactory.eINSTANCE.createPackage();
		Precedence p1a = createPrecedence(root1, "A", AssociativityKind.LEFT);
		Precedence p1b = createPrecedence(root1, "B", AssociativityKind.LEFT);
		Precedence p1c = createPrecedence(root1, "D", AssociativityKind.LEFT);
		rootPackages.add(root1);
		org.eclipse.ocl.examples.pivot.Package root2 = PivotFactory.eINSTANCE.createPackage();
		Precedence p2a = createPrecedence(root2, "B", AssociativityKind.LEFT);
		Precedence p2b = createPrecedence(root2, "C", AssociativityKind.LEFT);
		Precedence p2c = createPrecedence(root2, "D", AssociativityKind.LEFT);
		rootPackages.add(root2);
		List<String> errors = new TypeManager().compilePrecedences(rootPackages);
		assertEquals(0, p1a.getOrder().intValue());
		assertEquals(1, p1b.getOrder().intValue());
		assertEquals(3, p1c.getOrder().intValue());
		assertEquals(1, p2a.getOrder().intValue());
		assertEquals(2, p2b.getOrder().intValue());
		assertEquals(3, p2c.getOrder().intValue());
		assertEquals(0, errors.size());
	}
	
	public void testBadOrderingAssignPrecedences() {
		Collection<org.eclipse.ocl.examples.pivot.Package> rootPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		org.eclipse.ocl.examples.pivot.Package root1 = PivotFactory.eINSTANCE.createPackage();
		Precedence p1a = createPrecedence(root1, "A", AssociativityKind.LEFT);
		Precedence p1b = createPrecedence(root1, "B", AssociativityKind.LEFT);
		rootPackages.add(root1);
		org.eclipse.ocl.examples.pivot.Package root2 = PivotFactory.eINSTANCE.createPackage();
		Precedence p2a = createPrecedence(root2, "B", AssociativityKind.LEFT);
		Precedence p2b = createPrecedence(root2, "A", AssociativityKind.LEFT);
		rootPackages.add(root2);
		List<String> errors = new TypeManager().compilePrecedences(rootPackages);
		assertEquals(0, p1a.getOrder().intValue());
		assertEquals(1, p1b.getOrder().intValue());
		assertEquals(1, p2a.getOrder().intValue());
		assertEquals(0, p2b.getOrder().intValue());
		assertEquals(1, errors.size());
	}
	
	public void testBadAssociativityAssignPrecedences() {
		Collection<org.eclipse.ocl.examples.pivot.Package> rootPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		org.eclipse.ocl.examples.pivot.Package root1 = PivotFactory.eINSTANCE.createPackage();
		Precedence p1a = createPrecedence(root1, "A", AssociativityKind.LEFT);
		rootPackages.add(root1);
		org.eclipse.ocl.examples.pivot.Package root2 = PivotFactory.eINSTANCE.createPackage();
		Precedence p2a = createPrecedence(root2, "A", AssociativityKind.RIGHT);
		rootPackages.add(root2);
		List<String> errors = new TypeManager().compilePrecedences(rootPackages);
		assertEquals(0, p1a.getOrder().intValue());
		assertEquals(0, p2a.getOrder().intValue());
		assertEquals(1, errors.size());
	}

	protected void doLoadFromString(String fileName, String testFile) throws Exception {
		URI libraryURI = getProjectFileURI(fileName);
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.createResource(libraryURI);
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes());
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Load failed", xtextResource);
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, null);
//FIXME		adapter.refreshPivotMappings();
		Resource fileResource = adapter.getPivotResource(xtextResource);
		assertNoResourceErrors("File Model", fileResource);
		assertNoUnresolvedProxies("File Model", fileResource);
		assertNoValidationErrors("File Model", fileResource);
	}

	@Override
	protected void tearDown() throws Exception {
		unloadCS(resourceSet);
		TypeManagerResourceSetAdapter adapter = TypeManagerResourceSetAdapter.findAdapter(resourceSet);
		if (adapter != null) {
			TypeManager typeManager = adapter.getTypeManager();
			if (typeManager != null) {
				typeManager.dispose();
			}
		}
		super.tearDown();
	}
	
	public void testAmbiguousInternalAssignPrecedences() {
		Collection<org.eclipse.ocl.examples.pivot.Package> rootPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		org.eclipse.ocl.examples.pivot.Package root1 = PivotFactory.eINSTANCE.createPackage();
		Precedence p1a = createPrecedence(root1, "A", AssociativityKind.LEFT);
		Precedence p1b = createPrecedence(root1, "B", AssociativityKind.LEFT);
		Precedence p1c = createPrecedence(root1, "D", AssociativityKind.LEFT);
		rootPackages.add(root1);
		org.eclipse.ocl.examples.pivot.Package root2 = PivotFactory.eINSTANCE.createPackage();
		Precedence p2a = createPrecedence(root2, "A", AssociativityKind.LEFT);
		Precedence p2b = createPrecedence(root2, "C", AssociativityKind.LEFT);
		Precedence p2c = createPrecedence(root2, "D", AssociativityKind.LEFT);
		rootPackages.add(root2);
		List<String> errors = new TypeManager().compilePrecedences(rootPackages);
		assertEquals(0, p1a.getOrder().intValue());
		assertEquals(2, p1b.getOrder().intValue());
		assertEquals(3, p1c.getOrder().intValue());
		assertEquals(0, p2a.getOrder().intValue());
		assertEquals(1, p2b.getOrder().intValue());
		assertEquals(3, p2c.getOrder().intValue());
		assertEquals(1, errors.size());
	}
	
	public void testAmbiguousTailAssignPrecedences() {
		Collection<org.eclipse.ocl.examples.pivot.Package> rootPackages = new ArrayList<org.eclipse.ocl.examples.pivot.Package>();
		org.eclipse.ocl.examples.pivot.Package root1 = PivotFactory.eINSTANCE.createPackage();
		Precedence p1a = createPrecedence(root1, "A", AssociativityKind.LEFT);
		Precedence p1b = createPrecedence(root1, "B", AssociativityKind.LEFT);
		rootPackages.add(root1);
		org.eclipse.ocl.examples.pivot.Package root2 = PivotFactory.eINSTANCE.createPackage();
		Precedence p2a = createPrecedence(root2, "A", AssociativityKind.LEFT);
		Precedence p2b = createPrecedence(root2, "C", AssociativityKind.LEFT);
		rootPackages.add(root2);
		List<String> errors = new TypeManager().compilePrecedences(rootPackages);
		assertEquals(0, p1a.getOrder().intValue());
		assertEquals(2, p1b.getOrder().intValue());
		assertEquals(0, p2a.getOrder().intValue());
		assertEquals(1, p2b.getOrder().intValue());
		assertEquals(1, errors.size());
	}

	protected Precedence createPrecedence(org.eclipse.ocl.examples.pivot.Package root1, String name, AssociativityKind associativity) {
		Precedence precedence = PivotFactory.eINSTANCE.createPrecedence();
		precedence.setName(name);
		precedence.setAssociativity(associativity);
		root1.getOwnedPrecedences().add(precedence);
		return precedence;
	}
	
	
	public void testLoadAsString() throws Exception {
		String testFile =
			"library lib {\n"+
			"    type OclAny : AnyType {\n"+
			"    	operation a(elem : Boolean) : Integer {\n"+
			"           post a: elem;\n"+
			"       }\n"+
			"    }\n"+
			"    type Classifier<T> : ClassifierType conformsTo OclAny {}\n"+
			"    type Boolean : PrimitiveType conformsTo OclAny {}\n"+
			"    type Integer : PrimitiveType conformsTo Real {}\n"+
			"    type Real : PrimitiveType conformsTo OclAny {}\n"+
			"    type OclInvalid : InvalidType {}\n"+
			"    type UnlimitedNatural : PrimitiveType conformsTo Integer {}\n"+
			"}\n";		
		doLoadFromString("string.oclstdlib", testFile);
	}
	
	public void testImport() throws Exception {
		String testFile =
			"import 'minimal.oclstdlib'\n"+
			"import 'minimal.oclstdlib'\n"+
			"library lib {\n"+
			"    type OclAny : AnyType {\n"+
			"    	operation a(elem : Boolean) : Integer {\n"+
			"           post a: elem;\n"+
			"       }\n"+
			"    }\n"+
			"}\n";		
		doLoadFromString("string.oclstdlib", testFile);
// FIXME		doLoadFromString("string.oclstdlib", testFile);
		TypeManagerResourceSetAdapter adapter = TypeManagerResourceSetAdapter.findAdapter(resourceSet);
		TypeManager typeManager = adapter.getTypeManager();
		AnyType oclAnyType = typeManager.getOclAnyType();
		Iterable<Operation> ownedOperations = typeManager.getLocalOperations(oclAnyType, null);
		assertEquals(1, Iterables.size(ownedOperations));
		unloadPivot(typeManager);
	}
}
