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
 * $Id: OCLInEcoreResourceTests.java,v 1.3 2010/03/22 01:27:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl.ecore;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.examples.test.editor.OCLInEcoreTestFile;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class OCLInEcoreResourceTests extends AbstractOCLInEcoreEditorTestCase
{	
	@Override
	protected void checkTextASTSelection(Object astNode, CSTNode cstNode) {
		Object expectedConstrainedElement = getConstraint((EObject) cstNode.getAst()).getConstrainedElements().get(0);
		Object actualConstrainedElement = getConstrainedElement((EObject) astNode);
		assertSame(expectedConstrainedElement, actualConstrainedElement);
	}

	@Override
	protected OCLInEcoreTestFile createEcoreTestFile(IFile ecoreFile) {
		return new OCLInEcoreTestFile(ecoreFile);
	}

	@Override
	protected OCLInEcoreTestFile createOCLTestFile(OCLInEcoreTestFile ecoreTestFile) {
		return ecoreTestFile;
	}

	private ENamedElement getConstrainedElement(EObject ast) {
		for (EObject eObject = ast; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ENamedElement) {
				return (ENamedElement) eObject;
			}
		}
		return null;
	}

	private Constraint getConstraint(EObject ast) {
		for (EObject eObject = ast; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Constraint) {
				return (Constraint) eObject;
			}
		}
		return null;
	}

	/**
	 * Test that an editor can be opened on an empty file and that the editor closes
	 * when that file is deleted.
	 */
	public void testDeleteFileClosesEditor() throws CoreException, ExecutionException, BadLocationException, IOException {
		ecoreFile.delete(true, monitor);
		runAsyncMessages(editor.getSite().getShell().getDisplay(), "Delete File");
		assertTrue("File does not exist", !ecoreFile.exists());
		assertNull("Editor is closed", page.findEditor(editorInput));
	}
	
	/**
	 * Test that a class invariant body expression can be added in two parts with an intervening syntax error, saved and reloaded.
	 */
	public void testCreateInvariantExpression() throws CoreException, ExecutionException, BadLocationException, IOException {
		EClass eClass = ecoreTestFile.getEClass(editor.getResourceSet(), initClass);
		assertNotNull("Constrained Class exists", eClass);
		OCLInEcoreTestFile.InvariantChecker oldChecker = ecoreTestFile.createInvariantChecker(eClass);		
		oldChecker.checkConstraints("Before Edit", oldInvariantName);
		oldChecker.checkConstraint("Before Edit", oldInvariantName, oldInvariantExpression);
		//
		int start = checkPresent("Before Edit", document, oldInvariantExpression)+oldInvariantExpression.length();
		checkAbsent("Before Edit", document, newInvariantExpression);
		//
		document.replace(start, 0, newInvariantPart1);
		display.readAndDispatch();
		parse(document.get());
		document.replace(start+newInvariantPart1.length(), 0, newInvariantPart2);
		display.readAndDispatch();
		parse(document.get());
		//
		OCLInEcoreTestFile.InvariantChecker newChecker = ecoreTestFile.createInvariantChecker(eClass);		
		newChecker.checkConstraints("After Edit", oldInvariantName, newInvariantName);
		newChecker.checkConstraint("After Edit", oldInvariantName, oldInvariantExpression);
		newChecker.checkConstraint("After Edit", newInvariantName, newInvariantExpression);
		checkPresent("After Edit", document, oldInvariantExpression);
		checkPresent("After Edit", document, newInvariantExpression);
		//
		editor.doSave(monitor);
		ResourceSet resourceSet = ecoreTestFile.reload();
		EClass reloadClass = ecoreTestFile.getEClass(resourceSet, initClass);
		assertNotNull("Constrained Class reloaded", reloadClass);
		OCLInEcoreTestFile.InvariantChecker reloadChecker = ecoreTestFile.createInvariantChecker(reloadClass);		
		reloadChecker.checkConstraints("After Reload", oldInvariantName, newInvariantName);
		reloadChecker.checkConstraint("After Reload", oldInvariantName, oldInvariantExpression);
		reloadChecker.checkConstraint("After Reload", newInvariantName, newInvariantExpression);
	}
	
	/**
	 * Test that an editor displays a class invariant and that both Ecore and
	 * text change when the invariant expression is pasted and then saved.
	 */
	public void testEditInvariantExpression() throws CoreException, ExecutionException, BadLocationException, IOException {
		EClass eClass = ecoreTestFile.getEClass(editor.getResourceSet(), initClass);
		assertNotNull("Constrained Class exists", eClass);
		OCLInEcoreTestFile.InvariantChecker oldChecker = ecoreTestFile.createInvariantChecker(eClass);		
		oldChecker.checkConstraints("Before Edit", oldInvariantName);
		oldChecker.checkConstraint("Before Edit", oldInvariantName, oldInvariantExpression);
		//
		int start = checkPresent("Before Edit", document, oldInvariantExpression);
		checkAbsent("Before Edit", document, newInvariantExpression);
		//
		document.replace(start, oldInvariantExpression.length(), newInvariantExpression);
		parse(document.get());
		//
		OCLInEcoreTestFile.InvariantChecker newChecker = ecoreTestFile.createInvariantChecker(eClass);		
		newChecker.checkConstraints("After Edit", oldInvariantName);
		newChecker.checkConstraint("After Edit", oldInvariantName, newInvariantExpression);
		checkAbsent("After Edit", document, oldInvariantExpression);
		checkPresent("After Edit", document, newInvariantExpression);
		//
		editor.doSave(monitor);
		ResourceSet resourceSet = ecoreTestFile.reload();
		EClass reloadClass = ecoreTestFile.getEClass(resourceSet, initClass);
		assertNotNull("Constrained Class reloaded", reloadClass);

		OCLInEcoreTestFile.InvariantChecker reloadChecker = ecoreTestFile.createInvariantChecker(reloadClass);		
		reloadChecker.checkConstraints("After Reload", oldInvariantName);
		reloadChecker.checkConstraint("After Reload", oldInvariantName, newInvariantExpression);
	}
	
	/**
	 * Test that an editor displays a class invariant and that only the
	 * text change when the invariant expression is pasted with a syntax error
	 * and then saved.
	 */
	public void testEditInvariantExpressionToError() throws CoreException, ExecutionException, BadLocationException, IOException {
		EClass eClass = ecoreTestFile.getEClass(editor.getResourceSet(), initClass);
		assertNotNull("Constrained Class exists", eClass);
		OCLInEcoreTestFile.InvariantChecker oldChecker = ecoreTestFile.createInvariantChecker(eClass);		
		oldChecker.checkConstraints("Before Edit", oldInvariantName);
		oldChecker.checkConstraint("Before Edit", oldInvariantName, oldInvariantExpression);
		//
		int start = checkPresent("Before Edit", document, oldInvariantExpression);
		checkAbsent("Before Edit", document, newInvariantExpression);
		//
		document.replace(start, oldInvariantExpression.length(), newInvariantExpression);
		parse(document.get());
		//
		OCLInEcoreTestFile.InvariantChecker newChecker = ecoreTestFile.createInvariantChecker(eClass);		
		newChecker.checkConstraints("After Edit", oldInvariantName);
		newChecker.checkConstraint("After Edit", oldInvariantName, newInvariantExpression);
		checkAbsent("After Edit", document, oldInvariantExpression);
		checkPresent("After Edit", document, newInvariantExpression);
		//
		editor.doSave(monitor);
		ResourceSet resourceSet = ecoreTestFile.reload();
		EClass reloadClass = ecoreTestFile.getEClass(resourceSet, initClass);
		assertNotNull("Constrained Class reloaded", reloadClass);
		OCLInEcoreTestFile.InvariantChecker reloadChecker = ecoreTestFile.createInvariantChecker(reloadClass);		
		reloadChecker.checkConstraints("After Reload", oldInvariantName);
		reloadChecker.checkConstraint("After Reload", oldInvariantName, newInvariantExpression);
	}
	
	/**
	 * Test that an editor displays a class invariant and that both Ecore and
	 * text change when the invariant name is pasted and then saved.
	 */
	public void testEditInvariantName() throws CoreException, ExecutionException, BadLocationException, IOException {
		EClass eClass = ecoreTestFile.getEClass(editor.getResourceSet(), initClass);
		assertNotNull("Constrained Class exists", eClass);
		OCLInEcoreTestFile.InvariantChecker oldChecker = ecoreTestFile.createInvariantChecker(eClass);		
		oldChecker.checkConstraints("Before Edit", oldInvariantName);
		List<String> oldConstraints = EcoreUtil.getConstraints(eClass);
		checkPresent("Before Edit", oldConstraints, oldInvariantName);
		checkAbsent("Before Edit", oldConstraints, newInvariantName);
		IDocumentProvider documentProvider = editor.getDocumentProvider();
		IDocument document = documentProvider.getDocument(editorInput);
		//
		int start = checkPresent("Before Edit", document, oldInvariantName);
		checkAbsent("Before Edit", document, newInvariantName);
		checkPresent("Before Edit", document, oldInvariantExpression);
		//
		document.replace(start, oldInvariantName.length(), newInvariantName);
		parse(document.get());
		//
		OCLInEcoreTestFile.InvariantChecker newChecker = ecoreTestFile.createInvariantChecker(eClass);		
		newChecker.checkConstraints("After Edit", newInvariantName);
		List<String> newConstraints = EcoreUtil.getConstraints(eClass);
		checkAbsent("After Edit", newConstraints, oldInvariantName);
		checkPresent("After Edit", newConstraints, newInvariantName);
		checkAbsent("After Edit", document, oldInvariantName);
		checkPresent("After Edit", document, newInvariantName);
		checkPresent("After Edit", document, oldInvariantExpression);
		//
		editor.doSave(monitor);
		ResourceSet resourceSet = ecoreTestFile.reload();
		EClass reloadClass = ecoreTestFile.getEClass(resourceSet, initClass);
		assertNotNull("Constrained Class reloaded", reloadClass);
		OCLInEcoreTestFile.InvariantChecker reloadChecker = ecoreTestFile.createInvariantChecker(reloadClass);		
		reloadChecker.checkConstraints("After Reload", newInvariantName);
		List<String> reloadConstraints = EcoreUtil.getConstraints(reloadClass);
		checkAbsent("After Reload", reloadConstraints, oldInvariantName);
		checkPresent("After Reload", reloadConstraints, newInvariantName);
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
