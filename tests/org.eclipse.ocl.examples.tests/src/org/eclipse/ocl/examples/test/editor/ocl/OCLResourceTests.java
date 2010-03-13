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
 * $Id: OCLResourceTests.java,v 1.1 2010/03/13 18:11:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.editor.ocl.ui.OCLTextEditor;
import org.eclipse.ocl.examples.editor.ui.imp.CommonParseController;
import org.eclipse.ocl.examples.editor.ui.imp.CommonParseResult;
import org.eclipse.ocl.examples.test.editor.EcoreTestFile;
import org.eclipse.ocl.examples.test.editor.OCLTestFile;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;


public class OCLResourceTests extends AbstractOCLEditorTestCase
{
	/**
	 * FIXME UniversalEditor's ResourceChangeListener ignores DELETED.
	 *
	public void testOpenAndDelete() throws CoreException, ExecutionException, BadLocationException {
		IFile file = createMinimalTestFile();
		IFileEditorInput editorInput = new FileEditorInput(file);
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
	} */
	
	/**
	 * Test that a class invariant body expression can be pasted saved and reloaded.
	 */
	public void testEditInvariantExpression() throws CoreException, ExecutionException, BadLocationException, IOException {
		final String invariantName = "testInvariant";
		final String oldInvariantExpression = "true <> false";
		final String newInvariantExpression = "-- a prefix\nfalse <> true\n-- a suffix";
		IFile ecoreFile = project.getFile(getName() + " .ecore");
		IFile oclFile = project.getFile(getName() + " .ocl");
		EcoreTestFile ecoreTestFile = new EcoreTestFile(ecoreFile);
		OCLTestFile oclTestFile = new OCLTestFile(oclFile, ecoreTestFile);
		EPackage initPackage = ecoreTestFile.createEPackage(null, "testPackage");
		EClass initClass = ecoreTestFile.createEClass(initPackage, "testClass");
		oclTestFile.createInvariant(initClass, invariantName, oldInvariantExpression);
		IFileEditorInput editorInput = oclTestFile.getEditorInput();
		OCLTextEditor editor = (OCLTextEditor) workbenchPage.openEditor(editorInput, getEditorId());
		try {
			assertNotNull("Editor is open", workbenchPage.findEditor(editorInput));
			IDocumentProvider documentProvider = editor.getDocumentProvider();
			IDocument document = documentProvider.getDocument(editorInput);
			CommonParseController parseController = (CommonParseController) editor.getParseController();
			//
			CommonParseResult oldParseResult = parseController.parseWithoutCaching(document.get(), monitor);
			OCLTestFile.InvariantChecker oldChecker = oclTestFile.createInvariantChecker(oldParseResult, initClass);		
			oldChecker.checkConstraints("Before Edit", invariantName);
			oldChecker.checkConstraint("Before Edit", invariantName, oldInvariantExpression);
			//
			int start = checkPresent("Before Edit", document, oldInvariantExpression);
			checkAbsent("Before Edit", document, newInvariantExpression);
			//
			document.replace(start, oldInvariantExpression.length(), newInvariantExpression);
			//
			CommonParseResult newParseResult = parseController.parseWithoutCaching(document.get(), monitor);
			OCLTestFile.InvariantChecker newChecker = oclTestFile.createInvariantChecker(newParseResult, initClass);		
			newChecker.checkConstraints("Before Edit", invariantName);
			newChecker.checkConstraint("Before Edit", invariantName, newInvariantExpression);
			//
			editor.doSave(monitor);
			String reloadText = oclTestFile.reload();
			//
			CommonParseResult reloadParseResult = parseController.parseWithoutCaching(reloadText, monitor);
			OCLTestFile.InvariantChecker reloadChecker = oclTestFile.createInvariantChecker(reloadParseResult, initClass);		
			reloadChecker.checkConstraints("After Reload", invariantName);
			reloadChecker.checkConstraint("After Reload", invariantName, newInvariantExpression);
		} finally {
			workbenchPage.closeEditor(editor, false);
		}
	}
}
