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
import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.statements.IteratorKind;

/**
 * 
 * @author Yasser Lulu 
 */
public class EObjectContentIterator extends AbstractTreeIterator<EObject> {

	private static final long serialVersionUID = 4310034547053143619L;

	private static class EObjectAdapter extends EObjectImpl {
        private EList<EObject> list;
        EObjectAdapter(Collection<? extends EObject> collection) {
            list = new BasicEList<EObject>(collection);
        }
        @Override
		public final EList<EObject> eContents() {
            return list;
        }
    }

    private IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;
    private EObjectCondition filterCondition;
    private EObject rootEObject;

    /**
     * Initializes me with an <code>eObject</code> to iterate.
     * 
     * @param eObject the <code>EObject</code> whose contents are to be iterated
     */
    public EObjectContentIterator(EObject eObject) {
        this(eObject, null);
    }

    /**
     * Initializes me with an <code>eObject</code> to iterate and an initial
     * filter condition to eliminate objects from consideration in the query.
     * 
     * @param eObject the eobject to iterate
     * @param filterCondition filters the <code>eObject</code>'s contents
     */
    public EObjectContentIterator(
        EObject eObject,
        EObjectCondition filterCondition) {
        this(eObject, filterCondition, EStructuralFeatureValueGetter.getInstance());
    }

    /**
     * Initializes me with an <code>eObject</code> to iterate and an initial
     * filter condition to eliminate objects from consideration in the query.
     * 
     * @param eObject the eobject to iterate
     * @param filterCondition filters the <code>eObject</code>'s contents
     * @param eStructuralFeatureValueGetter the value getter to use in applying
     *     the filter condition
     */
    public EObjectContentIterator(
        EObject eObject,
        EObjectCondition filterCondition,
        IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
        super(eObject, false);
        this.filterCondition = filterCondition;
        this.rootEObject = eObject;
        this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
    }

    /**
     * Initializes me with an explicit collection of objects to iterate.
     * 
     * @param eObjects the collection to iterate
     */
    public EObjectContentIterator(Collection<? extends EObject> eObjects) {
        this(eObjects, null);
    }

    /**
     * Initializes me with an explicit collection of objects to iterate
     * and a filter to apply to the collection.
     * 
     * @param eObjects the collection to iterate
     * @param filterCondition an initial filter condition to eliminate objects
     *     from the collection from consideration by the query
     */
    public EObjectContentIterator(
        Collection<? extends EObject> eObjects,
        EObjectCondition filterCondition) {
        this(eObjects, filterCondition, EStructuralFeatureValueGetter.getInstance());
    }

    /**
     * Initializes me with an explicit collection of objects to iterate
     * and a filter to apply to the collection.
     * 
     * @param eObjects the collection to iterate
     * @param filterCondition an initial filter condition to eliminate objects
     *     from the collection from consideration by the query
     * @param eStructuralFeatureValueGetter the value getter to use in applying
     *     the filter condition
     */
    public EObjectContentIterator(
        Collection<? extends EObject> eObjects,
        EObjectCondition filterCondition,
        IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
        this(
            new EObjectAdapter(eObjects),
            filterCondition,
            eStructuralFeatureValueGetter);
    }

    /**
     * Obtains the iterator that iterates the contents.
     * 
     * @return the iterator
     */
    protected final Iterator<? extends EObject> getChildren() {
        return getChildren(rootEObject);
    }

    @Override
	protected final Iterator<? extends EObject> getChildren(Object obj) {
        return (obj == rootEObject)
            ? (obj instanceof EObjectAdapter)
            ? ((EObject)obj).eContents().iterator()
            : eStructuralFeatureValueGetter
                .eContents((EObject)obj, null)
                .iterator() : eStructuralFeatureValueGetter
                .eContents((EObject)obj, filterCondition)
                .iterator();
    }

    /**
     * Queries whether the content can be pruned.
     * 
     * @return <code>true</code> if we can prune; <code>false</code>, otherwise
     */
    public boolean canPrune() {
        return true;
    }

    /**
     * Obtains the kind of iterator.
     * 
     * @return the iterator kind ({@link IteratorKind#HIERARCHICAL_LITERAL})
     */
    public IteratorKind getIteratorKind() {
        return IteratorKind.HIERARCHICAL_LITERAL;
    }

}
