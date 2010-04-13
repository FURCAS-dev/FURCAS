/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query.newimpl;

import org.eclipse.emf.emfindex.ResourceDescriptor;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceDescriptorProperty<T> extends AbstractProperty<T> {

	public ResourceDescriptorProperty(Class<T> descriptorClass, String propertyName) {
		super(descriptorClass, propertyName);
	}
	
	public AbstractPredicate<T> equals(ResourceDescriptor descr) {
		return new ResourceDescriptorEquals<T>(this,descr);
	}
	
	public AbstractPredicate<T> in(QueryImpl<ResourceDescriptor> expected) {
		return new ResourceDescriptorIn<T>(this,expected);
	}
	
	public abstract static class ResourceDescriptorComparism<T> extends AbstractPredicate<T> {
		private ResourceDescriptorProperty<T> property;

		public ResourceDescriptorComparism(ResourceDescriptorProperty<T> property) {
			super();
			this.property = property;
		}
		public ResourceDescriptorProperty<T> getProperty() {
			return property;
		}
	}
	
	public static class ResourceDescriptorEquals<T> extends ResourceDescriptorComparism<T> {

		private ResourceDescriptor expected;

		public ResourceDescriptorEquals(ResourceDescriptorProperty<T> property, ResourceDescriptor expected) {
			super(property);
			this.expected = expected;
		}
		
		public ResourceDescriptor getExpected() {
			return expected;
		}
		
	}
	
	public static class ResourceDescriptorIn<T> extends ResourceDescriptorComparism<T> {
		
		private QueryImpl<ResourceDescriptor> expected;
		
		public ResourceDescriptorIn(ResourceDescriptorProperty<T> property, QueryImpl<ResourceDescriptor> expected) {
			super(property);
			this.expected = expected;
		}
		
		public QueryImpl<ResourceDescriptor> getExpected() {
			return expected;
		}
		
	}

}
