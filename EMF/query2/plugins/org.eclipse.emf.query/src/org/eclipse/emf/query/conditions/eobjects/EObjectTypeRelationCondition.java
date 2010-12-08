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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query.handlers.PruneHandler;
import org.eclipse.emf.query.internal.util.TypeRelationChecker;

/**
 * An <code>EObjectCondition</code> specialization to be used for evaluating
 * the inheritance/type relationship of an <code>EObject</code> to another
 * using the EObjects' EClasses. For example it could be used to find if a given
 * <code>EObject</code> is a subtype/supertype of another <code>EObject</code>.
 * 
 * @see TypeRelation
 */
public class EObjectTypeRelationCondition
	extends EObjectCondition {

	/**
	 * A constant <code>EObjectTypeRelationCondition</code> object used to
	 * indicate that the type relationship is undefined and hence it is always
	 * satisfied.
	 */
	public static final EObjectTypeRelationCondition UNDEFINED =
		new EObjectTypeRelationCondition() {

		@Override
		public boolean isSatisfied(EObject eObject) {
			return true;
		}
	};

	private TypeRelationChecker typeRelationChecker;

	private EObjectTypeRelationCondition() {
		//private
	}

	/**
	 * A Simple constructor, it initializes the
	 * <code>EObjectTypeRelationCondition</code> with the given
	 * <code>EClass</code>. It defaults to using
	 * TypeRelation.SAMETYPE_LITERAL as its relationship of interest and
	 * PruneHandler.NEVER to handle pruning
	 * 
	 * @param type
	 *            The <code>EClass</code> the primary type to check against
	 */
	public EObjectTypeRelationCondition(EClass type) {
		this(type, TypeRelation.SAMETYPE_LITERAL);
	}

	/**
	 * A constructor, it initializes the
	 * <code>EObjectTypeRelationCondition</code> with the given
	 * <code>EClass</code>. It defaults to using
	 * TypeRelation.SAMETYPE_LITERAL as its relationship of interest.
	 * 
	 * @param type
	 *            The <code>EClass</code> the primary type to check against
	 * @param pruneHandler
	 *            The prune handler
	 */
	public EObjectTypeRelationCondition(EClass type, PruneHandler pruneHandler) {
		this(type, TypeRelation.SAMETYPE_LITERAL, pruneHandler);
	}

	/**
	 * A constructor, it initializes the
	 * <code>EObjectTypeRelationCondition</code> with the given
	 * <code>EClass</code> and the <code>TypeRelation</code> specified. It
	 * defaults to using PruneHandler.NEVER to handle pruning
	 * 
	 * @param type
	 *            The <code>EClass</code> the primary type to check against
	 * @param typeRelationKind
	 *            The relationship kind between the primary type argument and
	 *            other EObjects to test for when evaluating this
	 *            <code>EObjectTypeRelationCondition</code>.
	 */
	public EObjectTypeRelationCondition(EClass type,
		TypeRelation typeRelationKind) {
		this(type, typeRelationKind, PruneHandler.NEVER);
	}

	/**
	 * A constructor, it initializes the
	 * <code>EObjectTypeRelationCondition</code> with the given
	 * <code>EClass</code>, the <code>TypeRelation</code> and the
	 * PruneHandler specified.
	 * 
	 * @param type
	 *            The <code>EClass</code> the primary type to check against
	 * @param typeRelationKind
	 *            typeRelationKind The relationship kind between the primary
	 *            type argument and other EObjects to test for when evaluating
	 *            this <code>EObjectTypeRelationCondition</code>.
	 * @param pruneHandler
	 *            The prune handler
	 */
	public EObjectTypeRelationCondition(EClass type,
		TypeRelation typeRelationKind, PruneHandler pruneHandler) {
		super(pruneHandler);
		typeRelationChecker = TypeRelationChecker.getTypeRelationChecker(type,
			typeRelationKind);
	}

	/**
	 * Evaluates this <code>EObjectTypeRelationCondition</code>, basically it
	 * answers the following question: Is the passed eObject's
	 * <code>EClass</code> is a <code>TypeRelation</code> to this
	 * <code>EObjectTypeRelationCondition</code>'s primary type/
	 * <code>EClass</code>?
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		return typeRelationChecker.isTypeRelationOK(eObject.eClass());
	}

}