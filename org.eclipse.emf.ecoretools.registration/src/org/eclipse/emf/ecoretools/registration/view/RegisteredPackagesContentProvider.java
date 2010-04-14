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
 * $Id: RegisteredPackagesContentProvider.java,v 1.3 2008/05/12 21:52:32 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.registration.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecoretools.registration.EMFRegistryHelper;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * ContentProvider for the tree of registered packages
 */
public class RegisteredPackagesContentProvider implements ITreeContentProvider {

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing to do
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// Nothing to do
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object arg0) {
		EPackage p = (EPackage) arg0;
		Set<String> uris = EMFRegistryHelper.getRegisteredChildren(p.getNsURI());
		List<EPackage> children = new ArrayList<EPackage>();
		for (String s : uris) {
			Object o = Registry.INSTANCE.get(s);
			if (o instanceof EPackage)
				children.add((EPackage) o);
		}
		return children.toArray();
	}

	/**
	 * Tells if the given element has children
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object arg0) {
		EPackage p = (EPackage) arg0;
		// a good guess about if we have children or not is if we have
		// subpackages
		// a better evaluation should get only valid children , ie. registered
		// children as in getChildren method
		return !p.getESubpackages().isEmpty();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object arg0) {
		EPackage result = null;
		EPackage p = (EPackage) arg0;
		if (p.eContainer() != null) {
			String nsURI = ((EPackage) p.eContainer()).getNsURI();
			if (EMFRegistryHelper.isRegistered(nsURI)) {
				result = (EPackage) p.eContainer();
			}
		}
		return result;
	}

	/**
	 * Element for the Table from the registered instances
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object parent) {
		ArrayList<EPackage> table = new ArrayList<EPackage>();
		for (String uri : Registry.INSTANCE.keySet()) {
			Object obj = Registry.INSTANCE.get(uri);
			if (obj instanceof EPackage) {
				// EPackage p = (EPackage) obj;
				// add only root packages
				if (getParent(obj) == null)
					table.add((EPackage) obj);
			}
		}
		return table.toArray();
	}

}
