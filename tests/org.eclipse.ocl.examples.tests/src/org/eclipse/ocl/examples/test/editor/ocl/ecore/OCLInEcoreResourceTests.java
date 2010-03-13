/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLInEcoreResourceTests.java,v 1.2 2010/03/13 18:11:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl.ecore;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreEditor;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreParseController;
import org.eclipse.ocl.examples.test.editor.OCLInEcoreTestFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class OCLInEcoreResourceTests extends AbstractOCLInEcoreEditorTestCase
{	

	/**
	 * Test that an editor can be opened on an empty file and that the editor closes
	 * when that file is deleted.
	 */
	public void testDeleteFileClosesEditor() throws CoreException, ExecutionException, BadLocationException, IOException {
		IFile file = project.getFile(getName() + " .ecore");
		OCLInEcoreTestFile testFile = new OCLInEcoreTestFile(file);
		IFileEditorInput editorInput = testFile.getEditorInput();
		IEditorPart editor = workbenchPage.openEditor(editorInput, getEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			file.delete(true, monitor);
			runAsyncMessages(editor.getSite().getShell().getDisplay(), "Delete File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}
	
	/**
	 * Test that an editor displays a class invariant and that both Ecore and
	 * text change when the invariant expression is pasted and then saved.
	 */
	public void testEditInvariantExpression() throws CoreException, ExecutionException, BadLocationException, IOException {
		final String invariantName = "testInvariant";
		final String oldInvariantExpression = "true <> false";
		final String newInvariantExpression = "-- a prefix\nfalse <> true\n-- a suffix";
		IFile file = project.getFile(getName() + " .ecore");
		OCLInEcoreTestFile testFile = new OCLInEcoreTestFile(file);
		EPackage initPackage = testFile.createEPackageWithDelegates(null, "testPackage");
		EClass initClass = testFile.createEClass(initPackage, "testClass");
		testFile.createInvariant(initClass, invariantName, oldInvariantExpression);
		IFileEditorInput editorInput = testFile.getEditorInput();
		OCLInEcoreEditor editor = (OCLInEcoreEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			EClass eClass = testFile.getEClass(editor.getResourceSet(), initClass);
			assertNotNull("Constrained Class exists", eClass);
			checkConstraints("Before Edit", eClass, invariantName);
			checkConstraint("Before Edit", eClass, invariantName, oldInvariantExpression);
			OCLInEcoreParseController parseController = editor.getParseController();
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			IDocument document = documentProvider.getDocument(editorInput);
			//
			int start = checkPresent("Before Edit", document, oldInvariantExpression);
			checkAbsent("Before Edit", document, newInvariantExpression);
			//
			document.replace(start, oldInvariantExpression.length(), newInvariantExpression);
			parseController.parseWithoutCaching(document.get(), monitor);
			//
			checkConstraints("After Edit", eClass, invariantName);
			checkConstraint("After Edit", eClass, invariantName, newInvariantExpression);
			checkAbsent("After Edit", document, oldInvariantExpression);
			checkPresent("After Edit", document, newInvariantExpression);
			//
			editor.doSave(monitor);
			ResourceSet resourceSet = testFile.reload();
			EClass reloadClass = testFile.getEClass(resourceSet, initClass);
			assertNotNull("Constrained Class reloaded", reloadClass);
			checkConstraints("After Reload", reloadClass, invariantName);
			checkConstraint("After Reload", reloadClass, invariantName, newInvariantExpression);
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}
	
	/**
	 * Test that an editor displays a class invariant and that only the
	 * text change when the invariant expression is pasted with a syntax error
	 * and then saved.
	 */
	public void testEditInvariantExpressionToError() throws CoreException, ExecutionException, BadLocationException, IOException {
		final String invariantName = "testInvariant";
		final String oldInvariantExpression = "true <> false";
		final String newInvariantExpression = "false <==> true";
		IFile file = project.getFile(getName() + " .ecore");
		OCLInEcoreTestFile testFile = new OCLInEcoreTestFile(file);
		EPackage initPackage = testFile.createEPackageWithDelegates(null, "testPackage");
		EClass initClass = testFile.createEClass(initPackage, "testClass");
		testFile.createInvariant(initClass, invariantName, oldInvariantExpression);
		IFileEditorInput editorInput = testFile.getEditorInput();
		OCLInEcoreEditor editor = (OCLInEcoreEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			EClass eClass = testFile.getEClass(editor.getResourceSet(), initClass);
			assertNotNull("Constrained Class exists", eClass);
			checkConstraints("Before Edit", eClass, invariantName);
			checkConstraint("Before Edit", eClass, invariantName, oldInvariantExpression);
			OCLInEcoreParseController parseController = editor.getParseController();
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			IDocument document = documentProvider.getDocument(editorInput);
			//
			int start = checkPresent("Before Edit", document, oldInvariantExpression);
			checkAbsent("Before Edit", document, newInvariantExpression);
			//
			document.replace(start, oldInvariantExpression.length(), newInvariantExpression);
			parseController.parseWithoutCaching(document.get(), monitor);
			//
			checkConstraints("After Edit", eClass, invariantName);
			checkConstraint("After Edit", eClass, invariantName, oldInvariantExpression);
			checkAbsent("After Edit", document, oldInvariantExpression);
			checkPresent("After Edit", document, newInvariantExpression);
			//
			editor.doSave(monitor);
			ResourceSet resourceSet = testFile.reload();
			EClass reloadClass = testFile.getEClass(resourceSet, initClass);
			assertNotNull("Constrained Class reloaded", reloadClass);
			checkConstraints("After Reload", reloadClass, invariantName);
			checkConstraint("After Reload", reloadClass, invariantName, oldInvariantExpression);
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}
	
	/**
	 * Test that an editor displays a class invariant and that both Ecore and
	 * text change when the invariant name is pasted and then saved.
	 */
	public void testEditInvariantName() throws CoreException, ExecutionException, BadLocationException, IOException {
		final String oldInvariantName = "oldTestInvariant";
		final String newInvariantName = "changedTestInvariant";
		final String invariantExpression = "true <> false";
		IFile file = project.getFile(getName() + " .ecore");
		OCLInEcoreTestFile testFile = new OCLInEcoreTestFile(file);
		EPackage initPackage = testFile.createEPackageWithDelegates(null, "testPackage");
		EClass initClass = testFile.createEClass(initPackage, "testClass");
		testFile.createInvariant(initClass, oldInvariantName, invariantExpression);
		IFileEditorInput editorInput = testFile.getEditorInput();
		OCLInEcoreEditor editor = (OCLInEcoreEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			EClass eClass = testFile.getEClass(editor.getResourceSet(), initClass);
			assertNotNull("Constrained Class exists", eClass);
			checkConstraints("Before Edit", eClass, oldInvariantName);
			List<String> oldConstraints = EcoreUtil.getConstraints(eClass);
			checkPresent("Before Edit", oldConstraints, oldInvariantName);
			checkAbsent("Before Edit", oldConstraints, newInvariantName);
			OCLInEcoreParseController parseController = editor.getParseController();
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			IDocument document = documentProvider.getDocument(editorInput);
			//
			int start = checkPresent("Before Edit", document, oldInvariantName);
			checkAbsent("Before Edit", document, newInvariantName);
			checkPresent("Before Edit", document, invariantExpression);
			//
			document.replace(start, oldInvariantName.length(), newInvariantName);
			parseController.parseWithoutCaching(document.get(), monitor);
			//
			checkConstraints("After Edit", eClass, newInvariantName);
			List<String> newConstraints = EcoreUtil.getConstraints(eClass);
			checkAbsent("After Edit", newConstraints, oldInvariantName);
			checkPresent("After Edit", newConstraints, newInvariantName);
			checkAbsent("After Edit", document, oldInvariantName);
			checkPresent("After Edit", document, newInvariantName);
			checkPresent("After Edit", document, invariantExpression);
			//
			editor.doSave(monitor);
			ResourceSet resourceSet = testFile.reload();
			EClass reloadClass = testFile.getEClass(resourceSet, initClass);
			assertNotNull("Constrained Class reloaded", reloadClass);
			checkConstraints("After Reload", reloadClass, newInvariantName);
			List<String> reloadConstraints = EcoreUtil.getConstraints(reloadClass);
			checkAbsent("After Reload", reloadConstraints, oldInvariantName);
			checkPresent("After Reload", reloadConstraints, newInvariantName);
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}
}
