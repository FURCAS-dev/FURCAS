/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.query.internal.statements;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query.statements.IQueryResult;

/**
 * 
 * @param <E> the kind of element provided by the result set
 * 
 * @author Yasser Lulu 
 */
public class QueryResultSet implements Set<EObject>, IQueryResult {
    private Set<EObject> eObjects;
    private Exception exception;
    private boolean cancelled;

    /**
     * Initializes me.
     */
    public QueryResultSet() {
        this(new HashSet<EObject>());
    }

    /**
     * Initializes me with the set of objects that I return.
     * 
     * @param eObjects my objects
     */
    public QueryResultSet(Set<? extends EObject> eObjects) {
        this(eObjects, null);
    }

    /**
     * Initializes me with the set of objects that I return and an exception
     * that was thrown while the query was processing.
     * 
     * @param eObjects my objects
     * @param exception the exception that was thrown
     */
    public QueryResultSet(Set<? extends EObject> eObjects, Exception exception) {
        this.eObjects = new HashSet<EObject>(eObjects);
        this.exception = exception;
    }

    public Set<EObject> getEObjects() {
        return eObjects;
    }

    void addEObject(EObject eObject) {
        eObjects.add(eObject);
    }

    void setException(Exception exception) {
        this.exception = exception;
    }

    public void clear() {
        eObjects = new HashSet<EObject>();
        exception = null;
    }

    /**
     * Obtains the exception, if any, that was thrown while the query was
     * processing.
     * 
     * @return the exception that was thrown
     */
    public Exception getException() {
        return exception;
    }

    public int size() {
        return eObjects.size();
    }

    public Iterator<EObject> iterator() {
        return eObjects.iterator();
    }

    /**
     * @see java.util.Collection#removeAll(java.util.Collection)
     */
    public boolean removeAll(Collection<?> c) {
        return eObjects.removeAll(c);
    }

    /**
     * @see java.util.Collection#add(java.lang.Object)
     */
    public boolean add(EObject o) {
        return eObjects.add(o);
    }
    
    /**
     * @see java.util.Collection#addAll(java.util.Collection)
     */
    public boolean addAll(Collection<? extends EObject> c) {
        return eObjects.addAll(c);
    }

    /**
     * @see java.util.Collection#contains(java.lang.Object)
     */
    public boolean contains(Object o) {
        return eObjects.contains(o);
    }

    /**
     * @see java.util.Collection#containsAll(java.util.Collection)
     */
    public boolean containsAll(Collection<?> c) {
        return eObjects.containsAll(c);
    }

    /**
     * @see java.util.Collection#isEmpty()
     */
    public boolean isEmpty() {
        return eObjects.isEmpty();
    }

    /**
     * @see java.util.Collection#remove(java.lang.Object)
     */
    public boolean remove(Object o) {
        return eObjects.remove(o);
    }

    /**
     * @see java.util.Collection#retainAll(java.util.Collection)
     */
    public boolean retainAll(Collection<?> c) {
        return eObjects.retainAll(c);
    }

    /**
     * @see java.util.Collection#toArray()
     */
    public Object[] toArray() {
        return eObjects.toArray();
    }

    /**
     * @see java.util.Collection#toArray(java.lang.Object[])
     */
    public <S> S[] toArray(S[] a) {
        return eObjects.toArray(a);
    }

    /**
     * Asks whether the query was canceled.
     * 
     * @return whether the query was canceled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancels the query.
     */
    public void cancel() {
        cancelled = true;
        clear();
    }
   
}
