/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.ecore.opposites;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;


/**
 * Uses {@link OppositeEndFinder#getAllInstancesSeenBy(EClass, org.eclipse.emf.common.notify.Notifier)} to perform
 * an extent lookup.
 */
public class ExtentMap implements Map<EClass, Set<EObject>> {
    private OppositeEndFinder oppositeEndFinder;
    private EObject context;

    public ExtentMap(EObject context, OppositeEndFinder oppositeEndFinder) {
        this.context = context;
        this.oppositeEndFinder = oppositeEndFinder;
    }

    /**
     * Lazily computes the extent of the specified class <code>key</code> based on a forward lookup on the
     * {@link OppositeEndFinder} passed to this map during construction.
     * 
     * @param key
     *            a class in the model
     */
    public Set<EObject> get(Object cls) {
        return oppositeEndFinder.getAllInstancesSeenBy((EClass) cls, context);
    }

    public int size() {
        throw new UnsupportedOperationException("size() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("isEmpty() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("containsKey() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("containsValue() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public Set<EObject> put(EClass key, Set<EObject> value) {
        throw new UnsupportedOperationException("put() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public Set<EObject> remove(Object key) {
        throw new UnsupportedOperationException("remove() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public void putAll(Map<? extends EClass, ? extends Set<EObject>> m) {
        throw new UnsupportedOperationException("putAll() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public void clear() {
        throw new UnsupportedOperationException("clear() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public Set<EClass> keySet() {
        throw new UnsupportedOperationException("keySet() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public Collection<Set<EObject>> values() {
        throw new UnsupportedOperationException("values() not supported on ExtentMap"); //$NON-NLS-1$
    }

    public Set<java.util.Map.Entry<EClass, Set<EObject>>> entrySet() {
        throw new UnsupportedOperationException("entrySet() not supported on ExtentMap"); //$NON-NLS-1$
    }
}
