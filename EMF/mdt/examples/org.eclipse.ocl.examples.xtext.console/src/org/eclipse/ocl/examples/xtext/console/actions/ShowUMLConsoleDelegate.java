/**
 * <copyright>
 *
 * Copyright (c) 2007,2011 IBM Corporation and others.
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
 * $Id: ShowUMLConsoleDelegate.java,v 1.1 2011/03/04 22:18:25 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.console.actions;

import org.eclipse.ocl.examples.xtext.console.OCLConsole;
import org.eclipse.ocl.examples.xtext.console.TargetMetamodel;


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
