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
public abstract class AbstractProperty<T> {
	private Class<T> descriptorClass;
	private String propertyName;
	
	public AbstractProperty(Class<T> descriptorClass, String propertyName) {
		this.descriptorClass = descriptorClass;
		this.propertyName = propertyName;
	}
	
	public Class<T> getDescriptorClass() {
		return descriptorClass;
	}

	public String getPropertyName() {
		return propertyName;
	}
	
}
