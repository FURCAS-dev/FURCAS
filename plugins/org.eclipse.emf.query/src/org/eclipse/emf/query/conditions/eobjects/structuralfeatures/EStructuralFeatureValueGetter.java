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

package org.eclipse.emf.query.conditions.eobjects.structuralfeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;

/**
 * A default implementation of the <code>IEStructuralFeatureValueGetter</code>
 * interface. It behaves as though the argument eObject passed to it require no
 * preparation or modification before or after invoking its methods and
 * therefore it accesses the methods of the argument eObject passed to it
 * directly.
 */
public class EStructuralFeatureValueGetter
	implements IEStructuralFeatureValueGetter {
	
	private static final EStructuralFeatureValueGetter INSTANCE = new EStructuralFeatureValueGetter();
	public static IEStructuralFeatureValueGetter getInstance() {return INSTANCE;}
	
	/**
	 * @deprecated Use the singleton provided by {@link #getInstance()}.
	 */
	@Deprecated
	public EStructuralFeatureValueGetter() {
		super();
	}

	private List<EObject> getFilteredContents(EObject eObject, EObjectCondition filterCondition) {
		Iterator<EObject> it = eObject.eContents().iterator();
		if (it.hasNext()) {
			EObject eContainedEObject = null;
			List<EObject> list = new ArrayList<EObject>();
			do {
				eContainedEObject = it.next();
				if (filterCondition.isSatisfied(eContainedEObject)) {
					list.add(eContainedEObject);
				}
			} while (it.hasNext());
			return list;
		}
		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter#eContents(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.query.conditions.eobjects.EObjectCondition)
	 */
	public List<EObject> eContents(EObject eObject, EObjectCondition filterCondition) {
		return (filterCondition == null) ? eObject.eContents()
			: getFilteredContents(eObject, filterCondition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter#eGet(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EStructuralFeature, boolean)
	 */
	public Object eGet(EObject eObject, EStructuralFeature eFeature,
		boolean resolve) {
		return eObject.eGet(eFeature, resolve);
	}

	/**
	 * Does nothing. Returns the same eObject passed.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter#resolve(org.eclipse.emf.ecore.EObject)
	 */
	public EObject resolve(EObject eObject) {
		return eObject;
	}

}