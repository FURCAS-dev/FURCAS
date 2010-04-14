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
 * $Id: EcoreUnregisteringAction.java,v 1.3 2008/05/12 21:50:50 lbigearde Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.registration.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.registration.Messages;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;

/**
 * Action that unregister an ecore file It will unregister all the contained
 * packages
 */
public class EcoreUnregisteringAction extends EMFRegisterAction {

	/**
	 * Constructor
	 */
	public EcoreUnregisteringAction() {
		super();
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		String strURI = null;
		URI mmURI = null;
		Resource res = null;

		ResourceSet rs = new ResourceSetImpl();

		for (IFile ecoreFile : ecoreFiles) {
			strURI = "platform:/resource" + ecoreFile.getFullPath().toString(); //$NON-NLS-1$
			mmURI = URI.createURI(strURI);
			res = rs.getResource(mmURI, true);

			for (EObject eobj : res.getContents()) {
				if (eobj instanceof EPackage) {
					unregisterPackages((EPackage) eobj);
				}
			}
		}

		displayRegisteredPackages();

	}

	/**
	 * Unregister the package and its nested packages
	 * 
	 * @param pack
	 */
	private void unregisterPackages(EPackage pack) {
		if (pack.getNsURI() != null && !pack.getNsURI().equals("")) { //$NON-NLS-1$

			for (EPackage subpack : pack.getESubpackages()) {
				unregisterPackages(subpack);
			}

			Registry.INSTANCE.remove(pack.getNsURI());
		} else {
			Shell shell = new Shell();
			MessageDialog.openWarning(shell, Messages.EcoreUnregisteringAction_EPackageRegistration, NLS.bind(Messages.EcoreUnregisteringAction_CanNotBeUnregistered, pack.getName()));
		}
	}

}
