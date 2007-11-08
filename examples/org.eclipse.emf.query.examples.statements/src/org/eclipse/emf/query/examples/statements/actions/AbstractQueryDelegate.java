/**
 * <copyright>
 *
 * Copyright (c) 2003, 2007 IBM Corporation and others.
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

package org.eclipse.emf.query.examples.statements.actions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.presentation.EXTLibraryEditor;
import org.eclipse.emf.query.examples.statements.internal.l10n.QueryStatementsMessages;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

/**
 * This action delegate queries the user for the name of a class. Then it uses
 * the query APIs to find the class and selects it in the editor.
 * 
 * @see IEditorActionDelegate
 */
public abstract class AbstractQueryDelegate
	implements IEditorActionDelegate, IActionDelegate2 {

	/**
	 * Error message to display when an exception occurred
	 */
	protected static final String MESSAGE_EXCEPTION = QueryStatementsMessages.message_exception;

	/**
	 * The shell this action is hosted in
	 */
	protected Shell shell = null;

	/**
	 * The active editor
	 */
	protected EXTLibraryEditor editor = null;

	/**
	 * Selected EObjects
	 */
	protected Collection<EObject> selectedEObjects = null;

	/**
	 * The InputDialog title
	 */
	protected String title;

	/**
	 * The InputDialog message
	 */
	protected String message;

	/**
	 * The message to output when query result set is empty
	 */
	protected String notFoundMessage;

	/**
	 * Constructor
	 */
	public AbstractQueryDelegate(String titleIn, String messageIn, String notFoundMessageIn) {
		title = titleIn;
		message = messageIn;
		notFoundMessage = notFoundMessageIn;
	}

	/**
	 * Perform a query that returns a set of objects.
	 * 
	 * @param value
	 *            The value used to drive the query
	 * @return The set of objects returned by the query
	 */
	protected abstract Collection<EObject> performQuery(Object value)
		throws Exception;

	/*
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, final ISelection selection) {
		this.selectedEObjects = null;
		try {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				this.selectedEObjects = new java.util.ArrayList<EObject>();
				for (Object next : structuredSelection.toList()) {
					if (next instanceof EObject) {
						selectedEObjects.add((EObject) next);
					}
				}
			}
		} catch (Exception e) {
			// Exceptions are not expected
			MessageDialog.openInformation(shell, title, MESSAGE_EXCEPTION);
			throw new RuntimeException(e);
		} finally {
			action.setEnabled((null != selectedEObjects));
		}
	}

	/*
	 * @see org.eclipse.ui.IActionDelegate2#dispose()
	 */
	public void dispose() {
		//No-op
	}

	/*
	 * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editor = (EXTLibraryEditor) targetEditor;
		if ( targetEditor != null ) {
			this.shell = targetEditor.getSite().getShell();
		}
	}

	/*
	 * @see org.eclipse.ui.IActionDelegate2#init(org.eclipse.jface.action.IAction)
	 */
	public void init(IAction action) {
		// No-op
	}

	/*
	 * @see org.eclipse.ui.IActionDelegate2#runWithEvent(org.eclipse.jface.action.IAction,
	 *      org.eclipse.swt.widgets.Event)
	 */
	public void runWithEvent(IAction action, Event event) {
		run(action);
	}
}
