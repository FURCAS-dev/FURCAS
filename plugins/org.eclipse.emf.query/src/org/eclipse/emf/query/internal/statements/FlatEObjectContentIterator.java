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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.statements.IteratorKind;

/**
 * @author Yasser Lulu 
 */
public final class FlatEObjectContentIterator
	extends EObjectContentIterator {
	
	private static final long serialVersionUID = 964764750547412881L;
	
	private Iterator<? extends EObject> it;

	/**
	 * Initializes me with a single <code>eObject</code> to iterate.
	 * 
	 * @param eObject the eobject to iterate
	 */
	public FlatEObjectContentIterator(EObject eObject) {
		this(eObject, null);
	}

	/**
	 * Initializes me with a single <code>eObject</code> to iterate.
	 * 
	 * @param eObject the eobject to iterate
	 * @param eObjectStructuralFeatureValueGetter the value getter to apply
	 *     to it
	 */
	public FlatEObjectContentIterator(EObject eObject,
		IEStructuralFeatureValueGetter eObjectStructuralFeatureValueGetter) {
		super(eObject, null, eObjectStructuralFeatureValueGetter);
	}

	/**
	 * Initializes me with a multiple <code>eObjects</code> to iterate.
	 * 
	 * @param eObjects the eobjects to iterate
	 */
	public FlatEObjectContentIterator(Collection<? extends EObject> eObjects) {
		this(eObjects, null);
	}

	/**
	 * Initializes me with a multiple <code>eObjects</code> to iterate.
	 * 
	 * @param eObjects the eobjects to iterate
	 * @param eObjectStructuralFeatureValueGetter the value getter to apply
	 *     to them
	 */
	public FlatEObjectContentIterator(Collection<? extends EObject> eObjects,
		IEStructuralFeatureValueGetter eObjectStructuralFeatureValueGetter) {
		super(eObjects, null, eObjectStructuralFeatureValueGetter);
	}

	/**
	 * @see org.eclipse.emf.common.util.TreeIterator#prune()
	 */
	@Override
	public void prune() {
		//disable parent's
	}

	/**
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return getIterator().hasNext();
	}

	/**
	 * @see java.util.Iterator#next()
	 */
	@Override
	public EObject next() {
		return getIterator().next();
	}

	/**
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		getIterator().remove();
	}

	private Iterator<? extends EObject> getIterator() {
		if (it == null) {
			it = getChildren();
		}
		return it;
	}

	@Override
	public boolean canPrune() {
		return false;
	}

	/**
	 * Returns the kind of iterator that I am.
	 * 
	 * @return my iterator kind ({@link IteratorKind#FLAT_LITERAL})
	 */
	@Override
	public IteratorKind getIteratorKind() {
		return IteratorKind.FLAT_LITERAL;
	}

}
