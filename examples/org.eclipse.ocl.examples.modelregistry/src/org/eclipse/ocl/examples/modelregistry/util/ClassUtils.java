/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.modelregistry.util;

/**
 * ClassUtils provides simple tools that should be part of the java.lang.Class.
 */
public class ClassUtils
{
	@SuppressWarnings("unchecked")
	public static <T> T asClass(Object object, Class<T> requiredClass) {
		if (object == null)
			return null;
		if (requiredClass == null)
			return null;
		Class<?> objectClass = object.getClass();
		if (requiredClass.isAssignableFrom(objectClass))
			return (T) object;
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T asClassChecked(Object object, Class<T> requiredClass) {
		if (object == null)
			return null;
		if (requiredClass == null)
			return null;
		Class<?> objectClass = object.getClass();
		if (requiredClass.isAssignableFrom(objectClass))
			return (T) object;
		else
			throw new ClassCastException("Cannot cast " + objectClass.getName() + " to " + requiredClass.getName());
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T asClassUnchecked(Object object, T requiredClassObject) {
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClass(T object) {
		if (object == null)
			return null;
		return (Class<T>) object.getClass();
	}
}
