/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.examples.interpreter.console;

import org.eclipse.emf.ocl.examples.interpreter.OclExamplePlugin;
import org.eclipse.emf.ocl.examples.interpreter.internal.l10n.OclInterpreterMessages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.AbstractConsole;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;


/**
 * The Interactive OCL console.
 */
public class OclConsole
	extends AbstractConsole {

	private static OclConsole instance;
	private OclConsolePage page;
	
	/**
	 * Initializes me.
	 */
	private OclConsole() {
		super(
			OclInterpreterMessages.console_title,
			ImageDescriptor.createFromURL(
				OclExamplePlugin.getDefault().getBundle().getEntry(
					"/icons/ocl.gif"))); //$NON-NLS-1$
	}

	/**
	 * Obtains the singleton instance.  It is created, if necessary.
	 * 
	 * @return the singleton console instance
	 */
	public static OclConsole getInstance() {
		if (instance == null) {
			instance = new OclConsole();
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] {instance});
		}
		
		return instance;
	}
	
	public IPageBookViewPage createPage(IConsoleView view) {
		page = new OclConsolePage();
		return page;
	}
	
	/**
	 * Closes me and clears the singleton instance reference, so that it will
	 * be reinitialized when another console is requested.
	 */
	void close() {
		try {
			ConsolePlugin.getDefault().getConsoleManager().removeConsoles(
				new IConsole[] {this});
			dispose();
		} finally {
			instance = null;
		}
	}
}
