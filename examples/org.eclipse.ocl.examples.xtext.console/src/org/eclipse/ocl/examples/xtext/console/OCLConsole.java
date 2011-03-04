/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - rework of LPG OCL Console for Xtext
 *
 * </copyright>
 *
 * $Id: OCLConsole.java,v 1.1 2011/03/04 22:18:03 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.console;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.xtext.console.messages.OCLInterpreterMessages;
import org.eclipse.ui.console.AbstractConsole;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;


/**
 * The Interactive OCL console.
 */
public class OCLConsole
	extends AbstractConsole {

	private static OCLConsole instance;
	private OCLConsolePage page;
	
	/**
	 * Initializes me.
	 */
	private OCLConsole() {
		super(
			OCLInterpreterMessages.console_title,
			ImageDescriptor.createFromURL(
				XtextConsolePlugin.getDefault().getBundle().getEntry(
					"/icons/ocl.gif"))); //$NON-NLS-1$
	}

	/**
	 * Obtains the singleton instance.  It is created, if necessary.
	 * 
	 * @return the singleton console instance
	 */
	public static OCLConsole getInstance() {
		if (instance == null) {
			instance = new OCLConsole();
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] {instance});
		}
		
		return instance;
	}
	
	public IPageBookViewPage createPage(IConsoleView view) {
		page = new OCLConsolePage();
		return page;
	}
	
	public void setTargetMetamodel(TargetMetamodel metamodel) {
//	    page.setTargetMetamodel(metamodel);
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
