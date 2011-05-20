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
 * $Id: EditTests.java,v 1.8 2011/05/20 15:27:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.osgi.util.NLS;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class EditTests extends XtextTestCase
{	
	public static void assertResourceErrors(String prefix, Resource resource, String... messages) {
		Map<String, Integer> expected = new HashMap<String, Integer>();
		for (String message : messages) {
			Integer count = expected.get(message);
			count = count == null ? 1 : count + 1;
			expected.put(message, count);
		}
		StringBuffer s1 = null;
		for (Resource.Diagnostic error : resource.getErrors()) {
			String actual = error.getMessage();
			Integer expectedCount = expected.get(actual);
			if ((expectedCount == null) || (expectedCount <= 0)) {
				if (s1 == null) {
					s1 = new StringBuffer();
					s1.append("\nUnexpected errors");
				}
				s1.append("\n");
				s1.append(actual);
			}
			else {
				expected.put(actual, expectedCount-1);
			}
		}
		StringBuffer s2 = null;
		for (String key : expected.keySet()) {
			Integer count = expected.get(key);
			while (count-- > 0) {
				if (s2 == null) {
					s2 = new StringBuffer();
					s2.append("\nMissing errors");
				}
				s2.append("\n");
				s2.append(key);
			}
		}
		if (s1 == null) {
			if (s2 == null) {
				return;
			}
			else {
				fail(s2.toString());
			}
		}
		else {
			if (s2 == null) {
				fail(s1.toString());
			}
			else {
				fail(s1.toString() + s2.toString());
			}
		}
	}

	protected TypeManager typeManager = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		typeManager = new TypeManager();
	}

	@Override
	protected void tearDown() throws Exception {
		if (typeManager != null) {
			typeManager.dispose();
			typeManager = null;
		}
		StandardLibraryContribution.REGISTRY.put(TypeManager.DEFAULT_OCL_STDLIB_URI, null);
		super.tearDown();
	}

	protected Resource getEcoreFromCS(String testDocument, URI ecoreURI) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(xtextURI, null);
//		TypeManagerResourceAdapter.getAdapter(xtextResource, typeManager);
		xtextResource.load(inputStream, null);
		assertNoResourceErrors("Loading Xtext", xtextResource);
		TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(xtextResource, null);
		TypeManager typeManager = adapter.getTypeManager();
		Resource pivotResource = savePivotFromCS(typeManager, xtextResource, null);
		Resource ecoreResource = savePivotAsEcore(typeManager, pivotResource, ecoreURI, true);
		adapter.dispose();
		typeManager.dispose();
		return ecoreResource;
	}

	protected Resource doRename(EssentialOCLCSResource xtextResource, Resource pivotResource, String oldString, String newString, String... expectedErrors) throws IOException {
		String contextMessage = "Renaming '" + oldString + "' to '" + newString + "'";
//		System.out.println("-----------------" + contextMessage + "----------------");
		replace(xtextResource, oldString, newString); 
		assertResourceErrors(contextMessage, xtextResource, expectedErrors);
		assertNoResourceErrors(contextMessage, pivotResource);
		boolean validSave = expectedErrors.length == 0;
		if (validSave) {
			assertNoValidationErrors(contextMessage, pivotResource);
		}
		Resource ecoreResource = savePivotAsEcore(typeManager, pivotResource, null, validSave);
		assertNoResourceErrors(contextMessage, ecoreResource);
		return ecoreResource;
	}	

	protected void replace(EssentialOCLCSResource xtextResource, String oldString, String newString) {
		String xtextContent = xtextResource.getContents().get(0).toString();
		int index = xtextContent.indexOf(oldString);
		xtextResource.update(index, oldString.length(), newString);
	}	

	public void testEdit_Rename_ecore() throws Exception {
		String testDocument = 
			"module m1 \n" +
			"package p1 : p2 = 'p3' {\n" +
			"}\n";
		URI ecoreURI0 = getProjectFileURI("test0.ecore");
		Resource ecoreResource0 = getEcoreFromCS(testDocument, ecoreURI0);
		URI ecoreURI1 = getProjectFileURI("test1.ecore");
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI outputURI = getProjectFileURI("test.oclinecore");
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(outputURI, null);
		TypeManagerResourceAdapter.getAdapter(xtextResource, typeManager);
		xtextResource.load(inputStream, null);
		Resource pivotResource = savePivotFromCS(typeManager, xtextResource, null);
		Resource ecoreResource1 = savePivotAsEcore(typeManager, pivotResource, ecoreURI1, true);
		assertSameModel(ecoreResource0, ecoreResource1);		
		//
		//	Inserting a leading space has no Ecore effect.
		//
		xtextResource.update(0, 0, " ");
		assertNoResourceErrors("Adding space", xtextResource);
		URI ecoreURI2 = getProjectFileURI("test2.ecore");
		Resource ecoreResource2 = savePivotAsEcore(typeManager, pivotResource, ecoreURI2, true);
		assertSameModel(ecoreResource0, ecoreResource2);		
		//
		//	Deleting the leading space has no Ecore effect.
		//
		xtextResource.update(0, 1, "");
		assertNoResourceErrors("Deleting space", xtextResource);
		URI ecoreURI3 = getProjectFileURI("test3.ecore");
		Resource ecoreResource3 = savePivotAsEcore(typeManager, pivotResource, ecoreURI3, true);
		assertSameModel(ecoreResource0, ecoreResource3);		
		//
		//	Changing "p1" to "pkg" renames the package.
		//
		replace(xtextResource, "p1", "pkg"); 
		assertNoResourceErrors("Renaming", xtextResource);
		URI ecoreURI4 = getProjectFileURI("test4.ecore");
		Resource ecoreResource4 = savePivotAsEcore(typeManager, pivotResource, ecoreURI4, true);
		((EPackage)ecoreResource0.getContents().get(0)).setName("pkg");
		assertSameModel(ecoreResource0, ecoreResource4);		
	}	

	public void testEdit_Rename_Restore_ecore() throws Exception {
		String testDocument = 
			"package TestPackage : tp = 'TestPackage'\n" +
			"{\n" +
			"	class TestClass1 {\n" +
			"		property testProperty1 : Integer;\n" +
			"		operation testOperation(i : Integer) : Integer;\n" +
			"		invariant testInvariant: 1 = 0;\n" +
			"	}\n" +
			"	class TestClass2 {\n" +
			"		property testProperty2 : TestClass1;\n" +
			"		property testProperty3 : Integer[*];\n" +
			"		invariant testInvariant: testProperty2.testProperty1 = testProperty2.testOperation(123456);\n" +
			"	}\n" +
			"}\n";
		URI ecoreURI0 = getProjectFileURI("test0.ecore");
		Resource ecoreResource0 = getEcoreFromCS(testDocument, ecoreURI0);
		URI ecoreURI1 = getProjectFileURI("test1.ecore");
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI outputURI = getProjectFileURI("test.oclinecore");
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(outputURI, null);
		TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(xtextResource, typeManager);
		xtextResource.load(inputStream, null);
		Resource pivotResource = savePivotFromCS(typeManager, xtextResource, null);
		Resource ecoreResource1 = savePivotAsEcore(typeManager, pivotResource, ecoreURI1, true);
		assertSameModel(ecoreResource0, ecoreResource1);
		org.eclipse.ocl.examples.pivot.Class pivotTestClass1 = typeManager.getPrimaryClass("TestPackage!TestClass1");
		//
		//	Changing "TestClass1" to "Testing" renames a type and breaks the invariant.
		//
		doRename(xtextResource, pivotResource, "TestClass1", "Testing",
//			NLS.bind(OCLMessages.Unresolved_ERROR_, "Type", pivotTestClass1.getName()),
			NLS.bind(OCLMessages.UnresolvedType_ERROR_, pivotTestClass1.getName()));
		//
		//	Changing "Testing" back to "TestClass1" restores the type and the invariant.
		//
		assertSameModel(ecoreResource0, doRename(xtextResource, pivotResource, "Testing", "TestClass1"));
		pivotTestClass1 = typeManager.getPrimaryClass("TestPackage!TestClass1");
		//
		//	Changing "testProperty1" to "tProperty" renames the property and breaks the invariant.
		//
		doRename(xtextResource, pivotResource, "testProperty1", "tProperty",
			NLS.bind(OCLMessages.UnresolvedProperty_ERROR_, "testProperty1", pivotTestClass1 + ""));
		//
		//	Changing "tProperty" back to "testProperty" restores the property and the invariant.
		//
		assertSameModel(ecoreResource0, doRename(xtextResource, pivotResource, "tProperty", "testProperty1"));
		//
		//	Changing "testOperation" to "tOperation" renames the operation and breaks the invariant.
		//
		doRename(xtextResource, pivotResource, "testOperation", "tOperation",
			NLS.bind(OCLMessages.UnresolvedOperationCall_ERROR_, new Object[]{"testOperation", pivotTestClass1 + "", "UnlimitedNatural"}));
		//
		//	Changing "tOperation" back to "testOperation" restores the operation and the invariant.
		//
		assertSameModel(ecoreResource0, doRename(xtextResource, pivotResource, "tOperation", "testOperation"));
		//
		//	Changing "testOperation(i : Integer)" to "testOperation()" mismatches the operation signature and breaks the invariant.
		//
		doRename(xtextResource, pivotResource, "testOperation(i : Integer)", "testOperation()",
			NLS.bind(OCLMessages.UnresolvedOperationCall_ERROR_, new Object[]{"testOperation", pivotTestClass1 + "", "UnlimitedNatural"}));
		//
		//	Changing "testOperation()" back to "testOperation(i : Integer)" restores the operation and the invariant.
		//
		assertSameModel(ecoreResource0, doRename(xtextResource, pivotResource, "testOperation()", "testOperation(i : Integer)"));
		//
		//	Changing "testOperation(i : Integer)" to "testOperation(s : String)" mismatches the operation signature and breaks the invariant.
		//
		doRename(xtextResource, pivotResource, "testOperation(i : Integer)", "testOperation(s : String)",
			NLS.bind(OCLMessages.UnresolvedOperationCall_ERROR_, new Object[]{"testOperation", pivotTestClass1 + "", "UnlimitedNatural"}));
		//
		//	Changing "testOperation()" back to "testOperation(i : Integer)" restores the operation and the invariant.
		//
		assertSameModel(ecoreResource0, doRename(xtextResource, pivotResource, "testOperation(s : String)", "testOperation(i : Integer)"));
		//
		adapter.dispose();
	}

	public void testEdit_StaleReference_ecore() throws Exception {
		String testDocument = 
			"package TestPackage : tp = 'TestPackage'\n" +
			"{\n" +
			"	class TestClass1 {\n" +
			"		property testProperty1 : Integer;\n" +
			"		operation testOperation() : Integer;\n" +
			"		invariant testInvariant: 1 = 0;\n" +
			"	}\n" +
			"	class TestClass2 {\n" +
			"		property testProperty2 : TestClass1[*];\n" +
			"		invariant testInvariant: testProperty2->select(testOperation() = testProperty1)->isEmpty();\n" +
			"	}\n" +
			"}\n";
		URI ecoreURI0 = getProjectFileURI("test0.ecore");
//		System.out.println("*************load-reference*********************************************************");
		Resource ecoreResource0 = getEcoreFromCS(testDocument, ecoreURI0);
		URI ecoreURI1 = getProjectFileURI("test1.ecore");
		InputStream inputStream = new ByteArrayInputStream(testDocument.getBytes());
		URI outputURI = getProjectFileURI("test.oclinecore");
		EssentialOCLCSResource xtextResource = (EssentialOCLCSResource) resourceSet.createResource(outputURI, null);
		TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(xtextResource, typeManager);
//		System.out.println("*************load*********************************************************");
		xtextResource.load(inputStream, null);
		Resource pivotResource = savePivotFromCS(typeManager, xtextResource, null);
		Resource ecoreResource1 = savePivotAsEcore(typeManager, pivotResource, ecoreURI1, true);
		assertSameModel(ecoreResource0, ecoreResource1);
		org.eclipse.ocl.examples.pivot.Class pivotTestClass1 = typeManager.getPrimaryClass("TestPackage!TestClass1");
		//
		//	Changing "TestClass1" to "Testing" renames a type and breaks the referredProperty/referredOperation.
		//
		doRename(xtextResource, pivotResource, "TestClass1", "Testing",
			NLS.bind(OCLMessages.UnresolvedType_ERROR_, pivotTestClass1.getName()));
		//
		//	Changing "Testing" back to "TestClass1" restores the type and the referredProperty/referredOperation.
		//
		assertSameModel(ecoreResource0, doRename(xtextResource, pivotResource, "Testing", "TestClass1"));
		pivotTestClass1 = typeManager.getPrimaryClass("TestPackage!TestClass1");
		//
		//	Changing "TestClass1" to "Testing" renames a type and breaks the referredProperty/referredOperation.
		//
		doRename(xtextResource, pivotResource, "TestClass1", "Testing",
			NLS.bind(OCLMessages.UnresolvedType_ERROR_, pivotTestClass1.getName()));
		//
		//	Changing "Testing" back to "TestClass1" restores the type and the referredProperty/referredOperation.
		//
		assertSameModel(ecoreResource0, doRename(xtextResource, pivotResource, "Testing", "TestClass1"));
		pivotTestClass1 = typeManager.getPrimaryClass("TestPackage!TestClass1");
		//
		adapter.dispose();
	}
}
