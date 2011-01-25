/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: LazyModelManager.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.Type;

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
public abstract class LazyModelManager implements ModelManager {

	private final Map<Type, Set<EObject>> modelManager = new HashMap<Type, Set<EObject>>();
	private Collection<EObject> roots;
	
	/**
	 * Initializes me with the context element of an OCL
	 * expression evaluation.  I discover the scope of the model from this
     * element.
	 * 
	 * @param context my context element
	 */
	public LazyModelManager(EObject context) {		
		context = EcoreUtil.getRootContainer(context);		
		if (context.eResource() != null) {		
			roots = context.eResource().getContents(); // the extent is the resource
		} else {			
			roots = Collections.singleton(context); // can only search this object tree
		}
	}

	/**
	 * Lazily computes the extent of the specified class <code>key</code>.
	 * 
	 * @param key a class in the model
	 */
	public Set<EObject> get(Type type) {
		// TODO: Optimize by parsing ahead of time to find all EClasses that we will query
		Set<EObject> result = modelManager.get(type);		
		if (result == null) {
			result = new HashSet<EObject>();
			modelManager.put(type, result);			
			for (Iterator<EObject> iter = EcoreUtil.getAllContents(roots); iter.hasNext();) {
				EObject next = iter.next();				
				if (isInstance(type, next)) {
					result.add(next);
				}
			}
		}		
		// FIXME subclasses
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
	protected abstract boolean isInstance(Type type, EObject element);
	
	@Override
    public String toString() {
		return modelManager.toString();
	}
}
