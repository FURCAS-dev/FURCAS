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
 * $Id: OCLstdlibTests.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;

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

//	private static final Logger logger = Logger.getLogger(OCLstdlibTests.class);

	/**
	 * Checks that the local oclstdlib.oclstdlib is the same as the pre-compiled
	 * Java implementation.
	 * 
	 * FIXME check the library/model version instead.
	 */
	public void testOCLstdlib() throws IOException, InterruptedException {
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
					fileClass = ((Feature)fileElement).getImplementation().getClass().getCanonicalName();
				}
				if (javaClass == null) {
					javaClass = ((Feature)javaElement).getImplementation().getClass().getCanonicalName();
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
}
