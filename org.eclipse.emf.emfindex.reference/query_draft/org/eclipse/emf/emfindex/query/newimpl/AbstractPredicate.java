/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query.newimpl;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractPredicate<T> {
	
	public AbstractPredicate<T> and(AbstractPredicate<T> predicate) {
		return new And<T>(this, predicate);
	}
	
	public AbstractPredicate<T> or(AbstractPredicate<T> predicate) {
		return new Or<T>(this, predicate);
	}
	
	public abstract static class BinaryOperation<T> extends AbstractPredicate<T>{
		
		private AbstractPredicate<T> left,right;
		
		public BinaryOperation(AbstractPredicate<T> left, AbstractPredicate<T> right) {
			this.left = left;
			this.right = right;
		}
		
		public AbstractPredicate<T> getLeft() {
			return left;
		}
		
		public AbstractPredicate<T> getRight() {
			return right;
		}
	}
	
	public static class Or<T> extends BinaryOperation<T>{
		public Or(AbstractPredicate<T> left, AbstractPredicate<T> right) {
			super(left, right);
		}
	}
	public static class And<T> extends BinaryOperation<T>{
		public And(AbstractPredicate<T> left, AbstractPredicate<T> right) {
			super(left, right);
		}
	}
	
	public static class Not<T> extends AbstractPredicate<T> {
		private AbstractPredicate<T> target;

		public Not(AbstractPredicate<T> target) {
			this.target = target;
		}
		
		public AbstractPredicate<T> getTarget() {
			return target;
		}
	}
}

