/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query.newimpl;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class URIProperty<T> extends AbstractProperty<T>{
	
	public URIProperty(Class<T> descriptorClass, String propertyName) {
		super(descriptorClass,propertyName);
	}
	
	public AbstractPredicate<T> equals(URI expected) {
		return new URIEquals<T>(this, expected);
	}
	
	public static abstract class URIComparism<T> extends AbstractPredicate<T> {
		private URIProperty<T> property;

		public URIComparism(URIProperty<T> property) {
			this.property = property;
		}
		
		public URIProperty<T> getProperty() {
			return property;
		}
	}
	
	public static class URIEquals<T> extends URIComparism<T> {

		private URI expected;

		public URIEquals(URIProperty<T> property, URI expected) {
			super(property);
			this.expected = expected;
		}
		
		public URI getExpected() {
			return expected;
		}
	}
}
