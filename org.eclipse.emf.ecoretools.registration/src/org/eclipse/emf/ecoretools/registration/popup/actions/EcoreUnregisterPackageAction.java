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
 * $Id: EcoreUnregisterPackageAction.java,v 1.3 2008/05/12 21:51:17 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.registration.popup.actions;

import java.util.Iterator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecoretools.registration.EMFRegistryHelper;
import org.eclipse.emf.ecoretools.registration.view.RegisteredPackageView;
import org.eclipse.jface.action.Action;

/**
 * 
 * Action on the RegisteredPackageView that unregisters a Ns uri and the
 * corresponding children
 * 
 */
public class EcoreUnregisterPackageAction extends Action {

	/**
	 * view associated to the action
	 */
	private RegisteredPackageView view;

	/**
	 * Constructor
	 * 
	 * @param view
	 *            associated to the action
	 * @param text
	 *            text passed to the action
	 */
	public EcoreUnregisterPackageAction(RegisteredPackageView view, String text) {
		super(text);
		this.view = view;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < view.getSelectedPackages().length; i++) {
			EPackage p = view.getSelectedPackages()[i];
			// remove all children and gran children ...
			Iterator<String> it = EMFRegistryHelper.getAllRegisteredChildren(p.getNsURI()).iterator();
			while (it.hasNext()) {
				Registry.INSTANCE.remove(it.next());
			}

			// remove it
			Registry.INSTANCE.remove(p.getNsURI());

		}

		view.refresh();
	}
}
