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
 * $Id: EMFRegistryHelper.java,v 1.2 2008/04/28 15:47:42 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.registration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Helper that provides operations dealing with EMF Registry
 * 
 */
public class EMFRegistryHelper {

	/**
	 * checks if this URI is in the registry
	 * 
	 * @param uri
	 * @return true if this URI is in the registry
	 */
	public static boolean isRegistered(URI uri) {
		return isRegistered(uri.toString());
	}

	/**
	 * checks if this URI is in the registry
	 * 
	 * @param uri
	 * @return true if this URI is in the registry
	 */
	public static boolean isRegistered(String uri) {
		Iterator<String> it = Registry.INSTANCE.keySet().iterator();
		while (it.hasNext()) {
			String regentry = it.next();
			if (regentry.equals(uri.toString()))
				return true;
		}
		return false;
	}

	/**
	 * checks if this URI is in the registry due to a Register action on an
	 * Ecore file ignores EPackage from generated java
	 * 
	 * @param uri
	 * @return true if this URI is in the registry
	 */
	public static boolean isDynamicallyRegistered(String uri) {
		EPackage pack = (EPackage) Registry.INSTANCE.get(uri);
		if (pack == null)
			return false;
		if (pack.getClass() == EPackageImpl.class) { // if this is exactly an
														// EPackage then this
														// comes from a files,
														// otherwise it comes
														// from generated java
			return true;
		} else
			return false;
	}

	/**
	 * the list of registered children packages
	 * 
	 * @param uri
	 * @return list of URI string of the valid children
	 */
	public static Set<String> getRegisteredChildren(String uri) {
		HashSet<String> result = new HashSet<String>();
		Object obj = Registry.INSTANCE.get(uri);
		// get only valid children , ie. registered children
		if (obj instanceof EPackage) {
			EPackage p = (EPackage) obj;
			Iterator<EPackage> subPackageIt = p.getESubpackages().iterator();
			while (subPackageIt.hasNext()) {
				EPackage subPackage = subPackageIt.next();
				if (EMFRegistryHelper.isRegistered(subPackage.getNsURI())) {
					result.add(subPackage.getNsURI());
				}
			}
		}
		return result;
	}

	/**
	 * the list of all registered children packages,including granchildren
	 * 
	 * @param uri
	 * @return list of URI string of the valid children
	 */
	public static Set<String> getAllRegisteredChildren(String uri) {
		HashSet<String> result = new HashSet<String>();
		Object obj = Registry.INSTANCE.get(uri);
		// get only valid children , ie. registered children
		if (obj instanceof EPackage) {
			EPackage p = (EPackage) obj;
			Iterator<EPackage> subPackageIt = p.getESubpackages().iterator();
			while (subPackageIt.hasNext()) {
				EPackage subPackage = subPackageIt.next();
				if (EMFRegistryHelper.isRegistered(subPackage.getNsURI())) {
					result.add(subPackage.getNsURI());
					// also add the grandchildren ...
					result.addAll(getAllRegisteredChildren(subPackage.getNsURI()));
				}
			}
		}
		return result;
	}

	/**
	 * add the EPackage in the registry only if it isn't already in the main
	 * registry
	 * 
	 * @param registry :
	 *            eventually used to add in a local ResourceSet registry or in
	 *            the main registry via Registry.INSTANCE
	 * @param pack
	 */
	public static void safeRegisterPackages(Registry registry, EPackage pack) {
		if (pack.getNsURI() != null && !pack.getNsURI().equals("") && !Registry.INSTANCE.containsKey(pack.getNsURI()) && !registry.containsKey(pack.getNsURI())) { //$NON-NLS-1$
			// only if not already registered in main Registry
			registry.put(pack.getNsURI(), pack);

			EList<EPackage> l = pack.getESubpackages();

			if (l != null) {
				Iterator<EPackage> it = l.iterator();
				while (it.hasNext()) {
					safeRegisterPackages(registry, it.next());
				}
			}
		}
	}

	/**
	 * Retrieves the resource associated to the given URI in the registry
	 * 
	 * @param uri
	 * @return Resource
	 */
	static public Resource getResource(URI uri) {
		EPackage p = EPackage.Registry.INSTANCE.getEPackage(uri.toString());
		if (p != null)
			return p.eResource();
		return null;
	}
}
