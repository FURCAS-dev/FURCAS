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
 * $Id: OCLInEcoreResourceTests.java,v 1.1 2010/03/13 13:17:23 ewillink Exp $
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
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreEditor;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreParseController;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class OCLInEcoreResourceTests extends AbstractOCLInEcoreEditorTestCase
{	
	protected void checkAbsent(String when, IDocument document, String what) {
		int index = document.get().indexOf(what);
		if (index >= 0) {
			fail(when + " - '" + what + "' found");
		}
	}
	
	protected void checkAbsent(String when, List<String> strings, String what) {
		if (strings.contains(what)) {
			fail(when + " - '" + what + "' found");
		}
	}
	
	protected void checkConstraint(String when, EClass eClass, String which, String what) {
		String expression = EcoreUtil.getAnnotation(eClass, OCLDelegateDomain.OCL_DELEGATE_URI, which);
		assertEquals(when, what, expression);
	}
	
	protected void checkConstraints(String when, EClass eClass, String... whiches) {
		List<String> constraints = EcoreUtil.getConstraints(eClass);		
		assertEquals(when + " - cionstraint count", whiches.length, constraints.size());
		for (String which : whiches) {
			checkPresent(when, constraints, which);
		}
	}

	protected int checkPresent(String when, IDocument document, String what) {
		int index = document.get().indexOf(what);
		if (index < 0) {
			fail(when + " - '" + what + "' not found");
		}
		return index;
	}
	
	protected void checkPresent(String when, List<String> strings, String what) {
		if (!strings.contains(what)) {
			fail(when + " - '" + what + "' not found");
		}
	}

	/**
	 * Test that an editor can be opened on an empty file and that the editor closes
	 * when that file is deleted.
	 */
	public void testDeleteFileClosesEditor() throws CoreException, ExecutionException, BadLocationException, IOException {
		IFile file = project.getFile(getName() + " .ecore");
		EcoreTestFile testFile = new EcoreTestFile(file);
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
		EcoreTestFile testFile = new EcoreTestFile(file);
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
		EcoreTestFile testFile = new EcoreTestFile(file);
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
		EcoreTestFile testFile = new EcoreTestFile(file);
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
	
/*
	public void testOpenAndRename() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			file.move(file.getFullPath().addFileExtension(".rename"), true, monitor);
			runAsyncMessages(editor.getDisplay(), "Move File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}

	public void testOpenEditAndDeleteAndKeep() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			final Display display = editor.getDisplay();
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			document.replace(0, 0, " ");
			runAsyncMessages(display, "Typing");
			
			assertTrue("Edited isDirty", editor.isDirty());
			assertTrue("Edited isDirtyPage", editor.isDirtyPage());
			textPageManager.refresh();
	
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertNotNull("Editor is still open", workbenchPage.findEditor(editorInput));
			assertTrue("File does not exist", !file.exists());
			display.asyncExec(new ButtonPress(display, IDialogConstants.OK_LABEL));
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "Save");
			assertFalse("Saved isNotDirty", editor.isDirty());
			assertFalse("Saved isNotDirtyPage", editor.isDirtyPage());
			assertTrue("File exists", file.exists());
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}

	public void testOpenEditAndDeleteAndLose() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			final Display display = editor.getDisplay();
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			document.replace(0, 0, " ");
			runAsyncMessages(display, "Typing");
			
			assertTrue("Edited isDirty", editor.isDirty());
			assertTrue("Edited isDirtyPage", editor.isDirtyPage());
			textPageManager.refresh();
	
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertNotNull("Editor is still open", workbenchPage.findEditor(editorInput));
			assertTrue("Deleted isDirty", editor.isDirty());
			assertTrue("Deleted isDirtyPage", editor.isDirtyPage());
			assertTrue("File does not exist", !file.exists());
			display.asyncExec(new ButtonPress(display, IDialogConstants.CANCEL_LABEL));
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "NonSave");
			assertTrue("Unsaved isDirty", editor.isDirty());
			assertTrue("Unsaved isDirtyPage", editor.isDirtyPage());
			display.asyncExec(new ButtonPress(display, IDialogConstants.OK_LABEL));
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "Save");
			assertFalse("Saved isNotDirty", editor.isDirty());
			assertFalse("Saved isNotDirtyPage", editor.isDirtyPage());
			assertTrue("File exists", file.exists());
			file.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertTrue("File does not exist", !file.exists());
			assertNull("Editor is closed", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}

	public void testOpenEditAndRename() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
		QVTcMultiEditor editor = (QVTcMultiEditor) workbenchPage.openEditor(editorInput, getMultiEditorId());
		try {
			final Display display = editor.getDisplay();
			TextPageManager textPageManager = (TextPageManager) editor.getActivePageManager();
			assertEquals("Page managers", 4, editor.getPageManagers().size());
			
			ITextEditorWithUndoContext textEditor = textPageManager.getEditor();
			IDocumentProvider documentProvider = textEditor.getDocumentProvider();
			AbstractDocument document = (AbstractDocument) documentProvider.getDocument(editorInput);
			document.replace(0, 0, " ");
			runAsyncMessages(display, "Typing");
			
			assertTrue("Edited isDirty", editor.isDirty());
			assertTrue("Edited isDirtyPage", editor.isDirtyPage());
			assertEquals("Edited title", file.getName(), editor.getTitle());
			textPageManager.refresh();
	
			file.move(file.getFullPath().addFileExtension("rename"), true, monitor);
			runAsyncMessages(editor.getDisplay(), "Move File");
			String newName = file.getName() + ".rename";
			assertEquals("Moved title", newName, editor.getTitle());
			assertNotNull("Editor is still open", workbenchPage.findEditor(editorInput));
			assertTrue("File does not exist", !file.exists());
			editor.doSave(monitor);
			runAsyncMessages(editor.getDisplay(), "Save");
			assertFalse("Saved isNotDirty", editor.isDirty());
			assertFalse("Saved isNotDirtyPage", editor.isDirtyPage());
			assertFalse("Old file does not exist", file.exists());
			IFile newFile = (IFile) file.getParent().findMember(newName);		
			assertTrue("New file exists", newFile.exists());
			newFile.delete(true, monitor);
			runAsyncMessages(display, "Delete File");
			assertFalse("New file does not exist", newFile.exists());
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	} */
}
