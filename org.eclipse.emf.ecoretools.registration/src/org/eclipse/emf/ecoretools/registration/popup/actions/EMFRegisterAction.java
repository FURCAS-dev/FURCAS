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
 * $Id: EMFRegisterAction.java,v 1.3 2008/05/12 21:51:37 lbigearde Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.registration.popup.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecoretools.registration.Messages;
import org.eclipse.emf.ecoretools.registration.RegistrationPlugin;
import org.eclipse.emf.ecoretools.registration.view.RegisteredPackageView;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Action on the RegisteredPackageView that register a Ns uri and the
 * corresponding children
 * 
 */
public class EMFRegisterAction implements IObjectActionDelegate {

	/** The current selection */
	protected StructuredSelection currentSelection;

	/** A List of Ecore files */
	protected ArrayList<IFile> ecoreFiles;

	/**
	 * Constructor
	 */
	public EMFRegisterAction() {
		ecoreFiles = new ArrayList<IFile>();
	}

	/** 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// Do nothing
	}

	/** 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		// Do nothing
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			// The selection could be a set of Ecore files
			currentSelection = (StructuredSelection) selection;
			Iterator<?> it = currentSelection.iterator();

			ecoreFiles.clear(); // remove the previous selection, else the old
								// selected packages will be re-registered
			while (it.hasNext()) {
				ecoreFiles.add((IFile) it.next());
			}
		}
	}

	/**
	 * refresh the view with the current content of the registry
	 */
	protected void displayRegisteredPackages() {
		try {
			RegisteredPackageView view;
			view = (RegisteredPackageView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(RegisteredPackageView.ID);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(view);
			view.refresh();
		} catch (PartInitException e) {
			RegistrationPlugin.getDefault().getLog().log(
					new Status(IStatus.WARNING, "org.eclipse.emf.ecoretools.registration", IStatus.OK, Messages.EMFRegisterAction_UnableToOpenView + RegisteredPackageView.ID + "\"", e)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
}
