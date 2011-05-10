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
 * $Id: LoadExpressionAction.java,v 1.2 2011/05/07 16:41:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.console.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.examples.xtext.console.OCLConsolePage;
import org.eclipse.ocl.examples.xtext.console.OCLResource;
import org.eclipse.ocl.examples.xtext.console.messages.ConsoleMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * An action that loads the last-evaluated OCL expression to an XMI file.
 */
public class LoadExpressionAction extends Action
{
    protected final OCLConsolePage consolePage;
	private final String tip;
	
	/**
	 * Initializes me.
	 */
	public LoadExpressionAction(OCLConsolePage consolePage) {
		super(
			ConsoleMessages.LoadAction_Label,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
				ISharedImages.IMG_OBJ_FILE));
		this.consolePage = consolePage;
		tip = ConsoleMessages.LoadAction_Tip;
	}
	
	@Override
    public String getToolTipText() {
		return tip;
	}
	
	@Override
    public void run() {
		Shell shell = consolePage.getControl().getShell();
		
		FileDialog dlg = new FileDialog(shell, SWT.OPEN);
		dlg.setFilterExtensions(new String[] {"*.xmi"}); //$NON-NLS-1$
		dlg.setText(ConsoleMessages.LoadAction_Title);
		
		String file = dlg.open();
		if (file != null) {
			try {
				String text = OCLResource.load(file);
				
				if (text != null) {
					consolePage.getEditorDocument().set(text);
				} else {
					MessageDialog.openWarning(
						shell,
						ConsoleMessages.LoadActionWarning_Title,
						ConsoleMessages.LoadActionWarning_NoExpression);
				}
			} catch (Exception e) {
				MessageDialog.openError(
					shell,
					ConsoleMessages.LoadActionError_Title,
					e.getLocalizedMessage());
			}
		}
	}
}