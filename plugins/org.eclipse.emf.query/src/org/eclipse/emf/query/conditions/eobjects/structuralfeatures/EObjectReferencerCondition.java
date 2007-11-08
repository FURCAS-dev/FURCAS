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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * <p>
 * An <code>EObjectCondition</code> subclass that tests if a given
 * <code>EObject</code> references another <code>EObject.</code> 
 * </p>
 * <p>
 * For the purposes of this condition, a container or containment 
 * EReference is not considered a &quot;reference.&quot;
 * </p>
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
	@Override
	public boolean isSatisfied(EObject eObject) {
		boolean result = false;
		EReference eReference = null;
		Iterator<EReference> it = eObject.eClass().getEAllReferences().iterator();
		while (it.hasNext() && (result == false)) {
			eReference = it.next();
			
			// We don't consider containment or container EReferences
			//  as "referencers." Plus, the EReference must be set
			//  or else we don't inspect. This is a performance optimization.
			if ((!eReference.isContainment())
				&& (!eReference.isContainer())
				&& (eObject.eIsSet(eReference))) {
				Object value = eStructuralFeatureValueGetter.eGet(eObject,
					eReference, true);
				
				if (FeatureMapUtil.isMany(eObject, eReference)) {
					result = ((Collection<?>) value).contains(referencedEObject);
				} else {
					result = referencedEObject.equals(value);
				}
			}
		}
		return result;
	}

}