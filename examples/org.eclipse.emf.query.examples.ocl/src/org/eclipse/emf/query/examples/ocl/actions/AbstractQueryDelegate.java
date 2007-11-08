/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.examples.ocl.actions;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.examples.extlibrary.presentation.EXTLibraryEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionDelegate;


/**
 * This action delegate queries the user for the name of a class. Then it uses
 * the OCL Query APIs to find the class and selects it in the editor.
 */
abstract class AbstractQueryDelegate
	extends ActionDelegate
	implements IEditorActionDelegate {

	/**
	 * The shell this action is hosted in.
	 */
	private Shell shell = null;

	/**
	 * The active editor
	 */
	private EXTLibraryEditor editor = null;

	/**
	 * Selected {@link EObject}s.
	 */
	private Collection<EObject> selectedEObjects = Collections.emptySet();

	/**
	 * Initializes me.
	 */
	protected AbstractQueryDelegate() {
		super();
	}
	
	/**
	 * Retrieves the user's selection.  If the actual selection is empty,
	 * then I return, instead, the roots of all resources in the current
	 * editor's resource set.
	 * 
	 * @return a collection of selected {@link EObject}s
	 */
	protected Collection<EObject> getSelectedObjects() {
		Collection<EObject> result = selectedEObjects;
		
		if (editor != null && (result == null || result.isEmpty())) {
			result = new java.util.ArrayList<EObject>();
			ResourceSet rset = editor.getEditingDomain().getResourceSet();
			
			for (Iterator<Resource> outer = rset.getResources().iterator(); outer.hasNext();) {
				Resource res = outer.next();
				
				if (res.isLoaded()) {
					result.addAll(res.getContents());
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Obtains the shell to use for opening dialogs.
	 * 
	 * @return my shell
	 */
	protected Shell getShell() {
		return shell;
	}
	
	/**
	 * Selects the specified <code>objects</code> in the current editor.
	 * 
	 * @param objects the objects to select (may be empty)
	 */
	protected void selectInEditor(Collection<?> objects) {
		editor.setSelectionToViewer(objects);
	}

	/**
	 * Gets all of the {@link EObject}s in the current selection, if any.
	 */
	@Override
	public void selectionChanged(IAction action, final ISelection selection) {
		selectedEObjects = Collections.emptySet();
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			selectedEObjects = new java.util.ArrayList<EObject>();
			
			for (Iterator<?> iter = structuredSelection.iterator(); iter.hasNext();) {
				Object next = iter.next();
				
				if (next instanceof EObject) {
					selectedEObjects.add((EObject) next);
				}
			}
		}
		
		action.setEnabled(!selectedEObjects.isEmpty());
	}

	/**
	 * Get the active library editor and its host shell.
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editor = (EXTLibraryEditor) targetEditor;
		
		if (targetEditor != null) {
			this.shell = targetEditor.getSite().getShell();
		}
	}
}
