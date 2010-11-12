/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: ShowEcoreConsoleDelegate.java,v 1.1 2007/04/30 12:39:31 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.actions;

import org.eclipse.emf.ocl.examples.interpreter.console.OCLConsole;
import org.eclipse.emf.ocl.examples.interpreter.console.TargetMetamodel;


/**
 * Action delegate that ensures that the OCL Console is active and set to
 * target the Ecore metamodel.
 */
public class ShowEcoreConsoleDelegate
	extends ShowConsoleDelegate {
	
	/**
	 * Initializes me.
	 */
	public ShowEcoreConsoleDelegate() {
		super();
	}
	
	@Override
    protected void consoleOpened(OCLConsole console) {
	    console.setTargetMetamodel(TargetMetamodel.Ecore);
	}

}
