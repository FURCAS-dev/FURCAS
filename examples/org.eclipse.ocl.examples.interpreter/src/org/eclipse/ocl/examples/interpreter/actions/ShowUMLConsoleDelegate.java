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
 * $Id: ShowUMLConsoleDelegate.java,v 1.1 2010/03/11 10:13:27 ewillink Exp $
 */

package org.eclipse.ocl.examples.interpreter.actions;

import org.eclipse.ocl.examples.interpreter.console.OCLConsole;
import org.eclipse.ocl.examples.interpreter.console.TargetMetamodel;


/**
 * Action delegate that ensures that the OCL Console is active and set to
 * target the UML metamodel.
 */
public class ShowUMLConsoleDelegate
	extends ShowConsoleDelegate {
	
	/**
	 * Initializes me.
	 */
	public ShowUMLConsoleDelegate() {
		super();
	}
	
	@Override
    protected void consoleOpened(OCLConsole console) {
	    console.setTargetMetamodel(TargetMetamodel.UML);
	}

}
