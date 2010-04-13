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
public class StringProperty<T> extends AbstractProperty<T>{
	
	public StringProperty(Class<T> descriptorClass, String propertyName) {
		super(descriptorClass,propertyName);
	}
	
	public AbstractPredicate<T> equals(String toMatch) {
		return new StringEquals<T>(this, toMatch);
	}
	
	public AbstractPredicate<T> startsWith(String toMatch) {
		return new StringStartsWith<T>(this, toMatch);
	}
	
	public AbstractPredicate<T> matches(String toMatch) {
		return new StringMatches<T>(this, toMatch);
	}
	
	public abstract static class StringComparism<T> extends AbstractPredicate<T> {
		private StringProperty<T> prop;
		private String expectation;
		
		public StringComparism(StringProperty<T> prop, String expectation) {
			super();
			this.prop = prop;
			this.expectation = expectation;
		}
		
		public String getExpectation() {
			return expectation;
		}
		
		public StringProperty<T> getProp() {
			return prop;
		}
	}
	
	public static class StringEquals<T> extends StringComparism<T> {
		public StringEquals(StringProperty<T> prop, String expectation) {
			super(prop, expectation);
		}
	}
	public static class StringStartsWith<T> extends StringComparism<T> {
		public StringStartsWith(StringProperty<T> prop, String expectation) {
			super(prop, expectation);
		}
	}
	public static class StringMatches<T> extends StringComparism<T> {
		public StringMatches(StringProperty<T> prop, String expectation) {
			super(prop, expectation);
		}
	}
}
