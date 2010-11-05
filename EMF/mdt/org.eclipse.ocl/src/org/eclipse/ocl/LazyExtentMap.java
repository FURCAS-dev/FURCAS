/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: LazyExtentMap.java,v 1.2 2007/10/11 23:05:04 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * A self-populating map that lazily creates the extent of a class when asked
 * for it.
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
 * class extents to the OCL engine, and it only does look-up by key.
 * Moreover, this isn't strictly a violation of any contract because there is
 * no way to distinguish this behaviour from concurrent updates.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class LazyExtentMap<CLS, E> implements Map<CLS, Set<E>> {

	private final Map<CLS, Set<E>> delegate =
		new java.util.HashMap<CLS, Set<E>>();
	private Collection<EObject> roots;
	
	/**
	 * Initializes me with the context element of an OCL
	 * expression evaluation.  I discover the scope of the model from this
     * element.
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
	 * Lazily computes the extent of the specified class <code>key</code>.
	 * 
	 * @param key a class in the model
	 */
	public Set<E> get(Object key) {
		// TODO: Optimize by parsing ahead of time to find all EClasses that we will query
		Set<E> result = delegate.get(key);
		
		if (result == null) {
			@SuppressWarnings("unchecked")
			CLS cls = (CLS) key;
			
			result = new java.util.HashSet<E>();
			delegate.put(cls, result);
			
			for (Iterator<Notifier> iter = EcoreUtil.getAllContents(roots); iter.hasNext();) {
				@SuppressWarnings("unchecked")
				E next = (E) iter.next();
				
				if (isInstance(cls, next)) {
					result.add(next);
				}
			}
		}
		
		return result;
	}

    /**
     * Implemented by subclasses to determine whether the specified element
     * is an instance of the specified class, according to the metamodel
     * semantics implemented by the environment that created this extent map.
     * 
     * @param cls a class in the model
     * @param element a potential run-time (M0) instance of that class
     * @return <code>true</code> if this element is an instance of the given
     *    class; <code>false</code> otherwise
     */
	protected abstract boolean isInstance(CLS cls, E element);
	
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
	public Set<Map.Entry<CLS, Set<E>>> entrySet() {
		return delegate.entrySet();
	}
	@Override
    public boolean equals(Object obj) {
		return delegate.equals(obj);
	}
	@Override
    public int hashCode() {
		return delegate.hashCode();
	}
	public boolean isEmpty() {
		return delegate.isEmpty();
	}
	public Set<CLS> keySet() {
		return delegate.keySet();
	}
	public Set<E> put(CLS key, Set<E> value) {
		return delegate.put(key, value);
	}
	public void putAll(Map<? extends CLS, ? extends Set<E>> t) {
		delegate.putAll(t);
	}
	public Set<E> remove(Object key) {
		return delegate.remove(key);
	}
	public int size() {
		return delegate.size();
	}
	@Override
    public String toString() {
		return delegate.toString();
	}
	public Collection<Set<E>> values() {
		return delegate.values();
	}
}
