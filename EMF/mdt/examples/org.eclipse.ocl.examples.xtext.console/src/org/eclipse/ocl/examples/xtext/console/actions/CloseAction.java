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
 * $Id: CloseAction.java,v 1.1 2011/03/11 20:23:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.console.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ocl.examples.xtext.console.OCLConsole;
import org.eclipse.ocl.examples.xtext.console.messages.OCLInterpreterMessages;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * An action that closes the Interactive OCL console.
 */
public class CloseAction extends Action {
	private final String tip;
	
	/**
	 * Initializes me.
	 */
	public CloseAction() {
		super(
			OCLInterpreterMessages.console_closeAction_label,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
				ISharedImages.IMG_TOOL_DELETE));
		
		tip = OCLInterpreterMessages.console_closeAction_tip;
	}
	
	@Override
    public String getToolTipText() {
		return tip;
	}
	
	@Override
    public void run() {
		OCLConsole.getInstance().close();
	}
}