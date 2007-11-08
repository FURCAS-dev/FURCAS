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

package org.eclipse.emf.query.conditions.eobjects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * A <code>EObjectCondition</code> that tests whether the argument eObject
 * instance equals a given eObject.
 * <p>
 * To look for <code>null</code> values in scalar {@link EReference}s, use the
 * special {@link #IS_NULL} shared condition instance.  Simply initializing
 * an <code>EObjectInstanceCondition</code> with <code>null</code> will not
 * work.
 * </p>
 */
public class EObjectInstanceCondition
	extends EObjectTypeRelationCondition {

    /**
     * A special object-instance condition checking that a value is
     * <code>null</code>.
     * 
     * @since 1.1
     */
    public static final EObjectInstanceCondition IS_NULL = new EObjectInstanceCondition(null) {
        
        @Override
		public boolean isSatisfied(Object object) {
            return object == null;
        }};

	private EObject eObject;

	/**
	 * A simple constructor that allows callers to initialize the
	 * <code>EObject</code> instance to use for equality testing by this
	 * <code>EObjectInstanceCondition</code>. This constructor uses
	 * PruneHandler.NEVER
	 * 
	 * @param eObject
	 *            the <code>EObject</code> to use in equality testing
	 */
	public EObjectInstanceCondition(EObject eObject) {
		this(eObject, PruneHandler.NEVER);
	}

	/**
	 * A constructor that allows callers to initialize this
	 * <code>EObjectInstanceCondition</code>
	 * 
	 * @param eObject
	 *            the <code>EObject</code> to use in equality testing
	 * @param pruneHandler
	 *            the <code>PruneHandler</code> to use
	 */
	public EObjectInstanceCondition(EObject eObject, PruneHandler pruneHandler) {
		super(eObject == null? EcorePackage.Literals.EOBJECT : eObject.eClass(),
		    pruneHandler);
		this.eObject = eObject;
	}

	/**
	 * Tests whether the argument <code>EObject</code> instance equals this
	 * <code>EObjectInstanceCondition</code>'s own <code>EObject</code>
	 * instance.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObj) {
		return getEObject().equals(eObj);
	}

	/**
	 * A getter function for the <code>EObject</code> instance used by this
	 * <code>EObjectInstanceCondition</code>
	 * 
	 * @return <code>EObject</code> the given object instance which we test
	 *         equality for
	 */
	protected final EObject getEObject() {
		return eObject;
	}

}