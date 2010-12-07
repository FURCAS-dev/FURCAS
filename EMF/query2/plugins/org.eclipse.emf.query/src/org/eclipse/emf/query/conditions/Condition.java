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

package org.eclipse.emf.query.conditions;

/**
 * An abstract base class for all <code>Condition</code> objects. It provides
 * the basic functionality and support for conditions and their logical
 * connectives that are used to combine <code>Condition</code> objects
 * together. It answers whether a given <code>Object</code> satisfies it or
 * not.
 * 
 * This class is intended to be subclassed by clients.
 *  
 */
public abstract class Condition {

	/**
	 * A constant <code>Condition</code> object used to indicate an always
	 * satisfied condition
	 */
	public static final Condition TRUE = new Condition() {

		@Override
		public boolean isSatisfied(Object object) {
			return true;
		}
	};

	/**
	 * A constant <code>Condition</code> object used to indicate a never
	 * satisfied condition
	 */
	public static final Condition FALSE = new Condition() {

		@Override
		public boolean isSatisfied(Object object) {
			return false;
		}
	};

	/**
	 * A simple constructor.
	 */
	protected Condition() {
		//protected
	}

	private static abstract class CompoundCondition
		extends Condition {

		Condition condition;

		CompoundCondition(Condition condition) {
			this.condition = condition;
		}
	}

	private class Or
		extends CompoundCondition {

		Or(Condition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(Object object) {
			return Condition.this.isSatisfied(object)
				|| condition.isSatisfied(object);
		}
	}

	private class And
		extends CompoundCondition {

		And(Condition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(Object object) {
			return Condition.this.isSatisfied(object)
				&& condition.isSatisfied(object);
		}
	}

	private class XOr
		extends CompoundCondition {

		XOr(Condition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(Object object) {
			return Condition.this.isSatisfied(object)
				^ condition.isSatisfied(object);
		}
	}

	private class Implies
		extends CompoundCondition {

		Implies(Condition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(Object object) {
			return (!(Condition.this.isSatisfied(object)))
				|| condition.isSatisfied(object);
		}
	}

	private class Equivalent
		extends CompoundCondition {

		Equivalent(Condition condition) {
			super(condition);
		}

		@Override
		public boolean isSatisfied(Object object) {
			return Condition.this.isSatisfied(object) == condition
				.isSatisfied(object);
		}
	}

	/**
	 * This operation acts like a logical AND between this
	 * <code>Condition</code> and the argument <code>Condition</code>. The
	 * returned <code>Condition</code> is a newly created
	 * <code>Condition</code> which is satisfied only if both its constituent
	 * <code>Condition</code> s are.
	 * <p>
	 * Please note that the newly compounded <code>Condition</code> will
	 * evaluate this <code>Condition</code> first, and if the result is
	 * <code>true</code>, it will evaluate the argument
	 * <code>Condition</code> ANDing both results as its own final result.
	 * This means that the argument <code>Condition</code> could be
	 * short-circuited and might not be evaluated at all.
	 * </p>
	 * 
	 * @param condition
	 *            a <code>Condition</code> to be ANDed with this one.
	 * @return a new compounded <code>Condition</code> object that represents
	 *         the ANDing of this <code>Condition</code> with the argument
	 *         <code>Condition</code>.
	 */
	public Condition AND(Condition condition) {
		return new And(condition);
	}

	/**
	 * This operation acts like a logical OR between this <code>Condition</code>
	 * and the argument <code>Condition</code>. The returned
	 * <code>Condition</code> is a newly created <code>Condition</code>
	 * which is satisfied if either of its constituent <code>Condition</code>
	 * s is. Please note that the newly compounded <code>Condition</code> will
	 * evaluate this <code>Condition</code> first, and if the result is
	 * <code>true</code>, it won't evaluate the argument
	 * <code>Condition</code> and it will return <code>true</code> as its
	 * final result, if, on the other hand the evaluation of the first
	 * <code>Condition</code> is <code>false</code>, the argument
	 * <code>Condition</code> will be evaluated and its returned result will
	 * be ORed with this one's and the resulting boolean will be returned as the
	 * compounded <code>Condition</code> own final result. This means that the
	 * argument <code>Condition</code> could be short-circuited and might not
	 * be evaluated at all.
	 * 
	 * @param condition
	 *            a <code>Condition</code> to be ORed with this one.
	 * @return a new compounded <code>Condition</code> object that represents
	 *         the ORing of this <code>Condition</code> with the argument
	 *         <code>Condition</code>.
	 */
	public Condition OR(Condition condition) {
		return new Or(condition);
	}

	/**
	 * This operation acts like a logical XOR between this
	 * <code>Condition</code> and the argument <code>Condition</code>. The
	 * returned <code>Condition</code> is a newly created
	 * <code>Condition</code> which is satisfied if XORing its constituent
	 * <code>Condition</code> s is.
	 * 
	 * @param condition
	 *            a <code>Condition</code> to be XORed with this one.
	 * @return a new compounded <code>Condition</code> object that represents
	 *         the XORing of this <code>Condition</code> with the argument
	 *         <code>Condition</code>.
	 */
	public Condition XOR(Condition condition) {
		return new XOr(condition);
	}

	/**
	 * This operation acts like a logical Implies (if-then)/(->) between this
	 * <code>Condition</code> and the argument <code>Condition</code>. The
	 * returned <code>Condition</code> is a newly created
	 * <code>Condition</code> which is satisfied if the result of this
	 * <code>Condition</code>'s evaluation is <code>false</code>, in which
	 * case the argument <code>Condition</code> will not be evaluated at all,
	 * or, if the both its constituent <code>Condition</code> s evaluate to
	 * <code>true</code>.
	 * 
	 * @param condition
	 *            a <code>Condition</code> to be used in the Imply relation
	 *            with this one.
	 * @return a new compounded <code>Condition</code> object that represents
	 *         the Imply logical relation between this <code>Condition</code>
	 *         and the argument <code>Condition</code>.
	 */
	public Condition IMPLIES(Condition condition) {
		return new Implies(condition); //i.e., == NOT(this).OR(condition);
	}

	/**
	 * This operation acts like a logical Equivalent (if-and-only-if)/( <->)
	 * between this <code>Condition</code> and the argument
	 * <code>Condition</code>. The returned <code>Condition</code> is a
	 * newly created <code>Condition</code> which is satisfied if the result
	 * of both its constituent <code>Condition</code> s evaluate to the same
	 * value.(both are <code>true</code>, or both are <code>false</code>)
	 * 
	 * @param condition
	 *            a <code>Condition</code> to be used in the Equivalent
	 *            relation with this one.
	 * @return a new compounded <code>Condition</code> object that represents
	 *         the Equivalent logical relation between this
	 *         <code>Condition</code> and the argument <code>Condition</code>.
	 */
	public Condition EQUIVALENT(Condition condition) {
		return new Equivalent(condition);
	}

	/**
	 * This operation is the evaluation operation of this <code>Condition</code>
	 * in regard to the argument Object. In other words, the operation answers
	 * whether the argument Object satisfied this <code>Condition</code> or
	 * not.
	 * 
	 * @param object
	 *            an Object to check if it satisfies this <code>Condition</code>
	 * @return <code>true</code> if the argument Object satisfies this
	 *         <code>Condition</code>,<code>false</code> otherwise.
	 *  
	 */
	public abstract boolean isSatisfied(Object object);
}