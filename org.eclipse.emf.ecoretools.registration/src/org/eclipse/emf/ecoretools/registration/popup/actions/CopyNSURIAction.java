/***********************************************************************
 * Copyright (c) 2007, 2008 INRIA and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    INRIA - initial API and implementation
 *
 * $Id: CopyNSURIAction.java,v 1.2 2008/04/28 15:47:42 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.registration.popup.actions;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.registration.view.RegisteredPackageView;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;

/**
 * This action will copy the selection NSURI (from then EMFRegisteredView) to
 * the clipboard
 */
public class CopyNSURIAction extends Action {

	/**
	 * view associated to the action
	 */
	private RegisteredPackageView view;

	/**
	 * Clipboard for the copy/paste action
	 */
	private Clipboard clipboard;

	/**
	 * Constructor
	 * 
	 * @param view
	 *            associated to the action
	 * @param clip
	 *            clipboard used for copy/paste action
	 * @param text
	 *            text passed to the action
	 */
	public CopyNSURIAction(RegisteredPackageView view, Clipboard clip, String text) {
		super(text);
		clipboard = clip;
		this.view = view;
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run() {
		String stringToClip = ""; //$NON-NLS-1$

		for (int i = 0; i < view.getSelectedPackages().length; i++) {
			EPackage p = view.getSelectedPackages()[i];

			if (i > 0) {
				stringToClip += "\n"; //$NON-NLS-1$
			}
			stringToClip += p.getNsURI();

		}
		clipboard.setContents(new Object[] { stringToClip }, new Transfer[] { TextTransfer.getInstance() });
	}
}
