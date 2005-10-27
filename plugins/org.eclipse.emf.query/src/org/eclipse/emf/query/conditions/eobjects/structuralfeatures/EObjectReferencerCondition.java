/******************************************************************************
 * Copyright (c) 2002, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.query.conditions.eobjects.structuralfeatures;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * An <code>EObjectCondition</code> subclass that tests if a given
 * <code>EObject</code> references another <code>EObject</code>
 */
public class EObjectReferencerCondition
	extends EObjectCondition {

	private EObject referencedEObject;

	private IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;

	/**
	 * A constructor, initializes this <code>EObjectReferencerCondition</code>
	 * with the passed arguments. It default to using PruneHandler.NEVER
	 * 
	 * @param referencedEObject
	 *            The <code>EObject</code> to search for
	 * @param eStructuralFeatureValueGetter
	 *            the referencing <code>EReference</code> value getter
	 */
	public EObjectReferencerCondition(EObject referencedEObject,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(referencedEObject, eStructuralFeatureValueGetter,
			PruneHandler.NEVER);
	}
	
	/**
	 * <p>
	 * A constructor, initializes this <code>EObjectReferencerCondition</code>
	 * with the passed arguments. It default to using PruneHandler.NEVER
	 * </p>
	 * <p>
	 * The default {@link EStructuralFeatureValueGetter} will be used when accessing the
	 *  values of the EReferences.
	 * </p>
	 * 
	 * @param referencedEObject
	 *            The <code>EObject</code> to search for
	 */
	public EObjectReferencerCondition(EObject referencedEObject) {
		this(referencedEObject, EStructuralFeatureValueGetter.getInstance(),
			PruneHandler.NEVER);
	}

	/**
	 * * A constructor, initializes this <code>EObjectReferencerCondition</code>
	 * with the passed arguments. It default to using PruneHandler.NEVER
	 * 
	 * @param referencedEObject
	 *            The <code>EObject</code> to search for
	 * @param eStructuralFeatureValueGetter
	 *            the referencing <code>EReference</code> value getter
	 * @param pruneHandler
	 *            The <code>PruneHandler</code>
	 */
	public EObjectReferencerCondition(EObject referencedEObject,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		PruneHandler pruneHandler) {
		super(pruneHandler);
		this.referencedEObject = referencedEObject;
		this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
	}

	/**
	 * Checks the argument eObject if it has any non-containment
	 * <code>EReference</code> whose value is equal to/contains the
	 * referencedEObject that this <code>EObjectReferencerCondition</code> is
	 * initialized with.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isSatisfied(EObject eObject) {
		boolean result = false;
		EReference eReference = null;
		Iterator it = eObject.eClass().getEAllReferences().iterator();
		while (it.hasNext() && (result == false)) {
			eReference = (EReference) it.next();
			if ((eReference.isContainment() == false)
				&& (eObject.eIsSet(eReference))) {
				Object value = eStructuralFeatureValueGetter.eGet(eObject,
					eReference, true);
				if (eReference.isMany()) {
					result = ((Collection) value).contains(referencedEObject);
				} else {
					result = referencedEObject.equals(value);
				}
			}
		}
		return result;
	}

}