/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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

package org.eclipse.emf.ocl.examples.interpreter.actions;

import org.eclipse.emf.ocl.examples.interpreter.console.OCLConsoleFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.console.IConsoleFactory;


/**
 * Action delegate that ensures that the console view is active, with the
 * Interact OCL console active within it.
 */
public class ShowConsoleDelegate
	extends ActionDelegate implements IEditorActionDelegate {

	private IConsoleFactory factory = new OCLConsoleFactory();
	
	/**
	 * Initializes me.
	 */
	public ShowConsoleDelegate() {
		super();
	}

	public void run(IAction action) {
		factory.openConsole();
	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// not interesting
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// not interesting
	}

}
