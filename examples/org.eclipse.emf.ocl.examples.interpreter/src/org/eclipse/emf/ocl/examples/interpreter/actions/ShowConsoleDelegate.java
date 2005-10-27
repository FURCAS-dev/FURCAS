/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.emf.ocl.examples.interpreter.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsoleManager;

import org.eclipse.emf.ocl.examples.interpreter.console.OclConsole;


/**
 * Action delegate that ensures that the console view is active, with the
 * Interact OCL console active within it.
 */
public class ShowConsoleDelegate
	extends ActionDelegate implements IEditorActionDelegate {

	/**
	 * Initializes me.
	 */
	public ShowConsoleDelegate() {
		super();
	}

	public void run(IAction action) {
		OclConsole console = OclConsole.getInstance();
		
		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();
		
		// must do this twice due to a bug in the Console API
		mgr.showConsoleView(console);
		mgr.showConsoleView(console);
	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// not interesting
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// not interesting
	}

}
