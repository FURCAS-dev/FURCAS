/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: DelegatingPackageRegistry.java,v 1.1 2006/05/25 15:36:46 cdamus Exp $
 */
package org.eclipse.emf.ocl.examples.interpreter.console;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;

/**
 * A package registry that delegates to multiple other registries (in order),
 * also delegating the {@link Map#values()} API in addition to package look-up.
 * This is safe to use with the {@link EcoreEnvironmentFactory} because Ecore
 * environments only iterate the values of a registry.
 *
 * @author Christian W. Damus (cdamus)
 */
public class DelegatingPackageRegistry extends EPackageRegistryImpl {
	private static final long serialVersionUID = -7606528898701523821L;

	private final List delegates;
	
	public DelegatingPackageRegistry(EPackage.Registry delegate) {
		delegates = new BasicEList(1);
		delegates.add(delegate);
	}
	
	public DelegatingPackageRegistry(EPackage.Registry delegate1, EPackage.Registry delegate2) {
		delegates = new BasicEList(2);
		delegates.add(delegate1);
		delegates.add(delegate2);
	}
	
	public DelegatingPackageRegistry(List delegates) {
		this.delegates = new BasicEList(delegates);
	}
	
	public Collection values() {
		Collection result = new java.util.ArrayList();
		
		Set keys = new java.util.HashSet(keySet());
		result.addAll(super.values());
		
		for (Iterator i = delegates.iterator(); i.hasNext();) {
			EPackage.Registry next = (EPackage.Registry) i.next();
			
			// get values from the delegates for the keys that we do not yet have
			for (Iterator j = next.keySet().iterator(); j.hasNext();) {
				String key = (String) j.next();
				
				if (!keys.contains(key)) {
					result.add(next.get(key));
				}
			}
		}
		
		return result;
	}
	
	protected EFactory delegatedGetEFactory(String nsURI) {
		EFactory result = null;
		
		for (Iterator i = delegates.iterator(); (result == null) && i.hasNext();) {
			EPackage.Registry next = (EPackage.Registry) i.next();
			
			result = next.getEFactory(nsURI);
		}
		
		return result;
	}
	
	protected EPackage delegatedGetEPackage(String nsURI) {
		EPackage result = null;
		
		for (Iterator i = delegates.iterator(); (result == null) && i.hasNext();) {
			EPackage.Registry next = (EPackage.Registry) i.next();
			
			result = next.getEPackage(nsURI);
		}
		
		return result;
	}
}
