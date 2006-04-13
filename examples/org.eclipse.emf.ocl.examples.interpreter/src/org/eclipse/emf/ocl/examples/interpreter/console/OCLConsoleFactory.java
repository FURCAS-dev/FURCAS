/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: OCLConsoleFactory.java,v 1.1 2006/04/13 12:30:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;

/**
 * Console factory for the Interactive OCL console, to enable it on any
 * editor that supports EObject selections.
 *
 * @author Christian W. Damus (cdamus)
 */
public class OCLConsoleFactory implements IConsoleFactory {
	public void openConsole() {
		OCLConsole console = OCLConsole.getInstance();
		
		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();
		
		// must do this twice due to a bug in the Console API
		mgr.showConsoleView(console);
		mgr.showConsoleView(console);
	}
}
