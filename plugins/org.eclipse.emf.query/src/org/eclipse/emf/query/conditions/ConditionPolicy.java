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

import java.util.Collection;

/**
 * An abstract base class for <code>ConditionPolicy</code> objects.
 * <code>ConditionPolicy</code> objects are used to help a given
 * <code>Condition</code> decide on how it should be evaluated as a whole
 * whenever it is applied over multiple argument objects, since the
 * <code>Condition</code> could evaluate to <code>true</code> on some of
 * these objects and <code>false</code> on others. Clients can use the
 * supplied <code>ConditionPolicy</code> objects or write their own subclasses
 * to handle complex cases.
 */
public abstract class ConditionPolicy {

	/**
	 * A simple constructor
	 */
	protected ConditionPolicy() {
		//protected
	}

	/**
	 * Answers on how the argument <code>Condition</code> evaluates as a whole
	 * on the argument objects collection.
	 * 
	 * @param condition
	 *            The <code>Condition</code> to be evaluated over the objects
	 * @param objects
	 *            The collection of objects to be passed to the
	 *            <code>Condition</code> argument for evaluation
	 * @return boolean <code>true</code> indicating that the
	 *         <code>Condition</code> evaluated successfully on the argument
	 *         objects -in accordance to this <code>ConditionPolicy</code>,
	 *         <code>false</code> otherwise
	 */
	public abstract boolean isSatisfied(Condition condition, Collection<?> objects);

	/**
	 * Answers whether the argument conditions evaluate -collectively- to
	 * <code>true</code> or <code>false</code> when applied to the argument
	 * object.
	 * 
	 * @param conditions
	 *            an array of <code>Condition</code> objects to be evaluated
	 *            -collectively in accordance to this
	 *            <code>ConditionPolicy</code>- on the argument object.
	 * @param object
	 *            The object to be tested by the <code>Condition</code>
	 *            objects
	 * @return boolean <code>true</code> indicating that the argument
	 *         <code>Condition</code> objects evaluated successfully -in
	 *         accordance to this <code>ConditionPolicy</code>- on the
	 *         argument object, <code>false</code> otherwise
	 */
	public abstract boolean isSatisfied(Condition[] conditions, Object object);

	/**
	 * Answers whether the argument conditions evaluates to <code>true</code>
	 * or <code>false</code> when applied to the argument object. This is the
	 * simplest case of evaluation since it only involves one
	 * <code>Condition</code> and one object to test.
	 * 
	 * @param condition
	 *            The <code>Condition</code> to be evaluated over the object.
	 * @param object
	 *            The object to be tested by the <code>Condition</code> object
	 * @return boolean <code>true</code> indicating that the argument
	 *         <code>Condition</code> object evaluated successfully -in
	 *         accordance to this <code>ConditionPolicy</code>- on the
	 *         argument object, <code>false</code> otherwise
	 */
	public boolean isSatisfied(Condition condition, Object object) {
		return condition.isSatisfied(object);
	}

	/**
	 * A utility <code>ConditionPolicy</code> object to be used when the
	 * client deems that the resultant evaluation is <code>true</code> if and
	 * only if: the <code>Condition</code> object evaluates to
	 * <code>true</code> on all the argument objects, or, when the client
	 * wants that all the <code>Condition</code> objects evaluate to
	 * <code>true</code> on the argument object
	 */
	public static final ConditionPolicy ALL = new ConditionPolicy() {

		@Override
		public boolean isSatisfied(Condition condition, Collection<?> objects) {
			for (Object o : objects) {
				if (condition.isSatisfied(o) == false) {
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean isSatisfied(Condition[] conditions, Object object) {
			for (Condition c : conditions) {
				if (c.isSatisfied(object) == false) {
					return false;
				}
			}
			return true;
		}
	};

	/**
	 * A utility <code>ConditionPolicy</code> object to be used when the
	 * client deems that the resultant evaluation is <code>true</code> if and
	 * only if: the <code>Condition</code> object evaluates to
	 * <code>true</code> on any of the argument objects, or, when the client
	 * wants that any of the <code>Condition</code> objects to evaluate to
	 * <code>true</code> on the argument object
	 */
	public static final ConditionPolicy ANY = new ConditionPolicy() {

		@Override
		public boolean isSatisfied(Condition condition, Collection<?> objects) {
			for (Object o : objects) {
				if (condition.isSatisfied(o)) {
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean isSatisfied(Condition[] conditions, Object object) {
			for (Condition c : conditions) {
				if (c.isSatisfied(object)) {
					return true;
				}
			}
			return false;
		}
	};
}