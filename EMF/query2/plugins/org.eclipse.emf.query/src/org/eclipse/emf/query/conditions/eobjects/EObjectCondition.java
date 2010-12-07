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

import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * A subclass and the counterpart of a <code>Condition</code> object to be
 * used on <code>EObject</code> arguments. It is the abstract base class for
 * all <code>EObjectCondition</code> objects. It provides the basic
 * functionality and support for <code>EObject</code> conditions and their
 * logical connectives to combine other <code>EObjectCondition</code> object
 * together. It answers whether a given <code>EObject</code> satisfies it or
 * not. An <code>EObjectCondition</code> object also answers whether the
 * contents/children of a given <code>EObject</code> argument are to be pruned
 * -never visited- or not, in other words, an EObjectCondition is consulted on
 * whether or not to apply it on the children of a given <code>EObject</code>,
 * if the answer is <code>false</code>, then this <code>EObject</code> will
 * not be applied on the children of that particular <code>EObject</code>. It
 * is important for clients to know that pruning is treated as a hint only and
 * is used solely to improve query performance and should not be relied on for
 * correctness of the EObjectCondition evaluation. An EObjectCondition could not
 * be consulted at all on pruning issue, and, its response -if it gets consulted-
 * might not be honoured by the query -especially when having an
 * EObjectCondition logically combined with another.
 * 
 * This class is intended to be subclassed by clients.
 * 
 * @see org.eclipse.emf.query.handlers.PruneHandler
 */
public abstract class EObjectCondition
	extends Condition {

	/**
	 * A constant <code>EObjectCondition</code> object used to indicate an
	 * always satisfied condition
	 */
	public static final EObjectCondition E_TRUE = new EObjectCondition() {

		@Override
		public boolean isSatisfied(EObject object) {
			return true;
		}
	};

	/**
	 * A constant <code>EObjectCondition</code> object used to indicate a
	 * never satisfied condition
	 */
	public static final EObjectCondition E_FALSE = new EObjectCondition(
		PruneHandler.ALWAYS) {

		@Override
		public boolean isSatisfied(EObject object) {
			return false;
		}
	};

	private PruneHandler pruneHandler;

	/**
	 * A simple constructor. It defaults to using the PruneHandler.NEVER and
	 * matches any {@link EObject}.
	 * 
	 * @see org.eclipse.emf.query.handlers.PruneHandler
	 */
	public EObjectCondition() {
		this(PruneHandler.NEVER);
	}

	/**
	 * A constructor that takes in a <code>PruneHandler</code> instance to
	 * use for pruning.  This constructor will match any kind of {@link EObject},
	 * so it is only safe for conditions with <tt>E == EObject</tt>.
	 * 
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to use for pruning
	 * @see org.eclipse.emf.query.handlers.PruneHandler
	 */
	public EObjectCondition(PruneHandler pruneHandler) {
		this.pruneHandler = pruneHandler;
	}

	/**
	 * A getter for the PrunHandler
	 * 
	 * @return <code>PruneHandler</code> the prune handler used by this
	 *         <code>EObjectCondition</code>
	 */
	public final PruneHandler getPruneHandler() {
		return pruneHandler;
	}

	/**
	 * Answers whether or not we should apply this <code>EObjectCondition</code>
	 * on the children of the argument eObject. This call is forwarded to the
	 * installed <code>PruneHandler<code>.  
	 * @param eObject the <code>EObject</code> to check to see whether to visit its children or not  
	 * @return boolean <code>true</code> if we should prune and <code>false</code> otherwise
	 */
	public boolean shouldPrune(EObject eObject) {
		return pruneHandler.shouldPrune(eObject);
	}

	/**
	 * Overrides the parent's implementation by simply checking if the argument
	 * object is an instance of <code>EObject</code> first, and if so, it
	 * forwards the actual evaluation to the appropriate overloaded version. If
	 * the argument object does not conform to an <code>EObject</code> it will
	 * return <code>false</code> as a result.
	 * 
	 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
	 */
	@Override
	public boolean isSatisfied(Object object) {
		if (object instanceof EObject) {
			return isSatisfied((EObject) object);
		}
		return false;
	}

	/**
	 * Answers whether the argument eObject satisfies this
	 * <code>EObjectCondition</code>
	 * 
	 * @param eObject
	 *            the <code>EObject</code> to check
	 * @return boolean <code>true</code> if the argument eObject satisfies
	 *         this <code>EObjectCondition</code>
	 */
	public abstract boolean isSatisfied(EObject eObject);

	private static abstract class CompoundEObjectCondition
		extends EObjectCondition {

		EObjectCondition condition;

		CompoundEObjectCondition(EObjectCondition condition) {
			this.condition = condition;
		}
	}

	private class And
		extends CompoundEObjectCondition {

		And(EObjectCondition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(EObject eObject) {
			return EObjectCondition.this.isSatisfied(eObject)
				&& condition.isSatisfied(eObject);
		}

		/**
		 * Prunes if and only if either of the <code>and</code>ed conditions
		 * would prune.
		 */
		@Override
		public boolean shouldPrune(EObject eObject) {
			return EObjectCondition.this.shouldPrune(eObject)
				|| condition.shouldPrune(eObject);
		}
	}

	private class Or
		extends CompoundEObjectCondition {

		Or(EObjectCondition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(EObject eObject) {
			return EObjectCondition.this.isSatisfied(eObject)
				|| condition.isSatisfied(eObject);
		}

		/**
		 * Prunes if and only if both of the <code>or</code>ed conditions
		 * would prune.
		 */
		@Override
		public boolean shouldPrune(EObject eObject) {
			return EObjectCondition.this.shouldPrune(eObject)
				&& condition.shouldPrune(eObject);
		}
	}

	private class XOr
		extends CompoundEObjectCondition {

		XOr(EObjectCondition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(EObject eObject) {
			return EObjectCondition.this.isSatisfied(eObject)
				^ condition.isSatisfied(eObject);

		}

		/**
		 * Prunes if and only if both of the <code>xor</code>ed conditions
		 * would prune.
		 */
		@Override
		public boolean shouldPrune(EObject eObject) {
			return EObjectCondition.this.shouldPrune(eObject)
				&& condition.shouldPrune(eObject);
		}
	}

	private class Implies
		extends CompoundEObjectCondition {

		Implies(EObjectCondition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(EObject eObject) {
			return (!(EObjectCondition.this.isSatisfied(eObject)))
				|| condition.isSatisfied(eObject);
		}

		/**
		 * Never prunes.
		 */
		@Override
		public boolean shouldPrune(EObject eObject) {
			return false;
		}
	}

	private class Equivalent
		extends CompoundEObjectCondition {

		Equivalent(EObjectCondition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(EObject eObject) {
			return EObjectCondition.this.isSatisfied(eObject) == condition
				.isSatisfied(eObject);
		}

		/**
		 * Never prunes.
		 */
		@Override
		public boolean shouldPrune(EObject eObject) {
			return false;
		}
	}

	/**
	 * This operation acts like a logical AND between this
	 * <code>EObjectCondition</code> and the argument
	 * <code>EObjectCondition</code>. The returned
	 * <code>EObjectCondition</code> is a newly created
	 * <code>EObjectCondition</code> which is satisfied only if both its
	 * constituent <code>EObjectCondition</code> are. Please note that the
	 * newly compounded <code>Condition</code> will evaluate this
	 * <code>EObjectCondition</code> first, and if the result is
	 * <code>true</code>, it will evaluate the argument
	 * <code>EObjectCondition</code>: ANDing both results as its own final
	 * result. This means that the argument <code>EObjectCondition</code>
	 * could be short-circuited and might not be evaluated at all.
	 * 
	 * @param condition
	 *            a <code>EObjectCondition</code> to be ANDed with this one.
	 * 
	 * @return a new compounded <code>EObjectCondition</code> object that
	 *         represents the ANDing of this <code>EObjectCondition</code>
	 *         with the argument <code>EObjectCondition</code>.
	 */
	public EObjectCondition AND(EObjectCondition condition) {
		return new And(condition);
	}

	/**
	 * This operation acts like a logical OR between this
	 * <code>EObjectCondition</code> and the argument
	 * <code>EObjectCondition</code>. The returned
	 * <code>EObjectCondition</code> is a newly created
	 * <code>EObjectCondition</code> which is satisfied if either of its
	 * constituent <code>EObjectCondition</code> is. Please note that the
	 * newly compounded <code>EObjectCondition</code> will evaluate this
	 * <code>EObjectCondition</code> first, and if the result is
	 * <code>true</code>, it won't evaluate the argument
	 * <code>EObjectCondition</code> and it will return <code>true</code> as
	 * its final result, if, on the other hand the evaluation of the first
	 * <code>EObjectCondition</code> is <code>false</code>, the argument
	 * <code>EObjectCondition</code> will be evaluated and its returned result
	 * will be ORed with this one's and the resulting boolean will be returned
	 * as the compounded <code>EObjectCondition</code> own final result. This
	 * means that the argument <code>EObjectCondition</code> could be
	 * short-circuited and might not be evaluated at all.
	 * 
	 * @param condition
	 *            a <code>EObjectCondition</code> to be ORed with this one.
	 * 
	 * @return a new compounded <code>EObjectCondition</code> object that
	 *         represents the ORing of this <code>EObjectCondition</code> with
	 *         the argument <code>EObjectCondition</code>.
	 */
	public EObjectCondition OR(EObjectCondition condition) {
		return new Or(condition);
	}

	/**
	 * This operation acts like a logical XOR between this
	 * <code>EObjectCondition</code> and the argument
	 * <code>EObjectCondition</code>. The returned
	 * <code>EObjectCondition</code> is a newly created
	 * <code>EObjectCondition</code> which is satisfied if XORing its
	 * constituent <code>EObjectCondition</code> is.
	 * 
	 * @param condition
	 *            a <code>EObjectCondition</code> to be XORed with this one.
	 * 
	 * @return a new compounded <code>EObjectCondition</code> object that
	 *         represents the XORing of this <code>EObjectCondition</code>
	 *         with the argument <code>EObjectCondition</code>.
	 */
	public EObjectCondition XOR(EObjectCondition condition) {
		return new XOr(condition);
	}

	/**
	 * This operation acts like a logical Implies (if-then)/(->) between this
	 * <code>EObjectCondition</code> and the argument
	 * <code>EObjectCondition</code>. The returned
	 * <code>EObjectCondition</code> is a newly created
	 * <code>EObjectCondition</code> which is satisfied if the result of this
	 * <code>EObjectCondition</code>'s evaluation is <code>false</code>,
	 * in which case the argument <code>EObjectCondition</code> will not be
	 * evaluated at all, or, if the both its constituent
	 * <code>EObjectCondition</code> evaluate to <code>true</code>.
	 * 
	 * @param condition
	 *            a <code>EObjectCondition</code> to be used in the Imply
	 *            relation with this one.
	 * 
	 * @return a new compounded <code>EObjectCondition</code> object that
	 *         represents the Imply logical relation between this
	 *         <code>EObjectCondition</code> and the argument
	 *         <code>EObjectCondition</code>.
	 */
	public EObjectCondition IMPLIES(EObjectCondition condition) {
		return new Implies(condition); //== NOT(this).OR(condition);
	}

	/**
	 * This operation acts like a logical Equivalent (if-and-only-if)/( <->)
	 * between this <code>EObjectCondition</code> and the argument
	 * <code>EObjectCondition</code>. The returned
	 * <code>EObjectCondition</code> is a newly created <code>Condition</code>
	 * which is satisfied if the result of both its constituent
	 * EObjectConditions evaluate to the same value.(both are <code>true</code>,
	 * or both are <code>false</code>)
	 * 
	 * @param condition
	 *            a <code>EObjectCondition</code> to be used in the Equivalent
	 *            relation with this one.
	 * 
	 * @return a new compounded <code>EObjectCondition</code> object that
	 *         represents the Equivalent logical relation between this
	 *         <code>EObjectCondition</code> and the argument
	 *         <code>EObjectCondition</code>.
	 */
	public EObjectCondition EQUIVALENT(EObjectCondition condition) {
		return new Equivalent(condition);
	}

}
