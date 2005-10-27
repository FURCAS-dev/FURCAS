/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.emf.ocl.internal.parser;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * A self-populating map that lazily creates the extent of an {@link EClass}
 * when asked for it.
 * <p>
 * <b>Note</b> that this implementation violates the contract of the
 * {@link Map} API as follows:
 * <ul>
 *   <li>the {@link Map#entrySet()} method does not return entries
 *       for any keys that have not already been queried via the
 *       {@link Map#get(java.lang.Object)} method</li>
 *   <li>concomitant to the above item, the {@link Map#keySet()}
 *       and {@link Map#values()} methods also are not complete</li>
 * </ul>
 * In practice, this does not matter because this map is only used for providing
 * {@link EClass} extents to the OCL engine, and it only does look-up by key.
 * Moreover, this isn't strictly a violation of any contract because there is
 * no way to distinguish this behaviour from concurrent updates.
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public class LazyExtentMap
	implements Map {

	private final Map delegate = new java.util.HashMap();
	private Collection roots;
	
	/**
	 * Initializes me with the context element of a metamodel OCL
	 * expression evaluation.
	 * 
	 * @param context my context element
	 */
	public LazyExtentMap(EObject context) {
		super();
		
		context = EcoreUtil.getRootContainer(context);
		
		if (context.eResource() != null) {
			// the extent is in the resource
			roots = context.eResource().getContents();
		} else {
			// can only search this object tree
			roots = Collections.singleton(context);
		}
	}

	/**
	 * Lazily computes the extent of the specified {@link EClass}
	 * <code>key</code>.
	 * 
	 * @param key an {@link EClass}
	 */
	public Object get(Object key) {
		// TODO: Optimize by parsing ahead of time to find all EClasses that we will query
		Object result = delegate.get(key);
		
		if ((result == null) && (key instanceof EClass)) {
			EClass eclass = (EClass) key;
			
			Set extent = new java.util.HashSet();
			delegate.put(eclass, extent);
			result = extent;
			
			for (Iterator iter = EcoreUtil.getAllContents(roots); iter.hasNext();) {
				Object next = iter.next();
				
				if (eclass.isInstance(next)) {
					extent.add(next);
				}
			}
		}
		
		return result;
	}

	//
	// Strictly delegating methods
	//
	
	public void clear() {
		delegate.clear();
	}
	public boolean containsKey(Object key) {
		return delegate.containsKey(key);
	}
	public boolean containsValue(Object value) {
		return delegate.containsValue(value);
	}
	public Set entrySet() {
		return delegate.entrySet();
	}
	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}
	public int hashCode() {
		return delegate.hashCode();
	}
	public boolean isEmpty() {
		return delegate.isEmpty();
	}
	public Set keySet() {
		return delegate.keySet();
	}
	public Object put(Object key, Object value) {
		return delegate.put(key, value);
	}
	public void putAll(Map t) {
		delegate.putAll(t);
	}
	public Object remove(Object key) {
		return delegate.remove(key);
	}
	public int size() {
		return delegate.size();
	}
	public String toString() {
		return delegate.toString();
	}
	public Collection values() {
		return delegate.values();
	}
}
