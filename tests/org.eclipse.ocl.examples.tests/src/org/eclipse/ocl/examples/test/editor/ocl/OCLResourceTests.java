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
 * $Id: OCLResourceTests.java,v 1.2 2010/03/22 01:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.examples.editor.ui.imp.CommonParseResult;
import org.eclipse.ocl.examples.test.editor.EcoreTestFileBase;
import org.eclipse.ocl.examples.test.editor.OCLForEcoreTestFile;

public class OCLResourceTests extends AbstractOCLEditorTestCase
{	
	@Override
	protected void checkTextASTSelection(Object astNode, CSTNode cstNode) {
		assertSame(cstNode.getAst(), astNode);
	}

	@Override
	protected EcoreTestFileBase createEcoreTestFile(IFile ecoreFile) {
		return new EcoreTestFileBase(ecoreFile);
	}

	@Override
	protected OCLForEcoreTestFile createOCLTestFile(EcoreTestFileBase ecoreTestFile) {
		IFile oclFile = project.getFile(getName() + " .ocl");
		return new OCLForEcoreTestFile(oclFile, ecoreTestFile);
	}
	
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
	 * Test that a class invariant body expression can be added in two parts with an intervening syntax error, saved and reloaded.
	 */
	public void testCreateInvariantExpression() throws CoreException, ExecutionException, BadLocationException, IOException {
		//
		CommonParseResult oldParseResult = parse(document.get());
		OCLForEcoreTestFile.InvariantChecker oldChecker = oclTestFile.createInvariantChecker(oldParseResult, initClass);		
		oldChecker.checkConstraints("Before Edit", oldInvariantName);
		oldChecker.checkConstraint("Before Edit", oldInvariantName, oldInvariantExpression);
		//
		int start = checkPresent("Before Edit", document, oldInvariantExpression)+oldInvariantExpression.length();
		checkAbsent("Before Edit", document, newInvariantExpression);
		//
		document.replace(start, 0, newInvariantPart1);
		display.readAndDispatch();
		CommonParseResult newParseResult = parse(document.get());
		document.replace(start+newInvariantPart1.length(), 0, newInvariantPart2);
		display.readAndDispatch();
		newParseResult = parse(document.get());
		//
		OCLForEcoreTestFile.InvariantChecker newChecker = oclTestFile.createInvariantChecker(newParseResult, initClass);		
		newChecker.checkConstraints("After Edit", oldInvariantName, newInvariantName);
		newChecker.checkConstraint("After Edit", oldInvariantName, oldInvariantExpression);
		newChecker.checkConstraint("After Edit", newInvariantName, newInvariantExpression);
		//
		editor.doSave(monitor);
		String reloadText = oclTestFile.reload();
		//
		CommonParseResult reloadParseResult = parse(reloadText);
		OCLForEcoreTestFile.InvariantChecker reloadChecker = oclTestFile.createInvariantChecker(reloadParseResult, initClass);		
		reloadChecker.checkConstraints("After Reload", oldInvariantName, newInvariantName);
		reloadChecker.checkConstraint("After Reload", oldInvariantName, oldInvariantExpression);
		reloadChecker.checkConstraint("After Reload", newInvariantName, newInvariantExpression);
	}

	/**
	 * Test that a class invariant body expression can be pasted saved and reloaded.
	 */
	public void testEditInvariantExpression() throws CoreException, ExecutionException, BadLocationException, IOException {
		//
		CommonParseResult oldParseResult = parse(document.get());
		OCLForEcoreTestFile.InvariantChecker oldChecker = oclTestFile.createInvariantChecker(oldParseResult, initClass);		
		oldChecker.checkConstraints("Before Edit", oldInvariantName);
		oldChecker.checkConstraint("Before Edit", oldInvariantName, oldInvariantExpression);
		//
		int start = checkPresent("Before Edit", document, oldInvariantExpression);
		checkAbsent("Before Edit", document, newInvariantExpression);
		//
		document.replace(start, oldInvariantExpression.length(), newInvariantExpression);
		//
		CommonParseResult newParseResult = parse(document.get());
		OCLForEcoreTestFile.InvariantChecker newChecker = oclTestFile.createInvariantChecker(newParseResult, initClass);		
		newChecker.checkConstraints("Before Edit", oldInvariantName);
		newChecker.checkConstraint("Before Edit", oldInvariantName, newInvariantExpression);
		//
		editor.doSave(monitor);
		String reloadText = oclTestFile.reload();
		//
		CommonParseResult reloadParseResult = parse(reloadText);
		OCLForEcoreTestFile.InvariantChecker reloadChecker = oclTestFile.createInvariantChecker(reloadParseResult, initClass);		
		reloadChecker.checkConstraints("After Reload", oldInvariantName);
		reloadChecker.checkConstraint("After Reload", oldInvariantName, newInvariantExpression);
	}
	
	/**
	 * Test that selections propagate.
	 */
	public void testSelect() throws CoreException, ExecutionException, BadLocationException, IOException, InterruptedException {
		//
		parse(document.get());
		doTestTextSelection(oldInvariantExpression, OperationCallExpCS.class);
		doTestTextSelection("false", BooleanLiteralExpCS.class);
	}
}
