/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ClassDelegate.java,v 1.3 2010/04/08 06:24:00 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.environment;

import org.eclipse.ocl.examples.common.utils.ClassUtils;


/**
 * ClassDelegate captures a class name mentioned in an extension, but defers loading that
 * class until it is actually needed.
 */
public abstract class ClassDelegate<T> {
	protected final String className;
	protected final Class<T> clazz;
	private T instance = null;
	private boolean loaded = false;

	public ClassDelegate(String className, Class<T> clazz) {
		this.className = className;
		this.clazz = clazz;
	}

	public ClassDelegate(T instance) {
		this.className = instance.getClass().getName();
		this.clazz = ClassUtils.getClass(instance);
		this.instance = instance;
		this.loaded = true;
	}
	
	@SuppressWarnings("unchecked")
	public T load() {
		if ((instance == null) && !loaded) {
			loaded = true;
			try {
				Class<?> loadedClass = loadClass(className);
				if (!clazz.isAssignableFrom(loadedClass))
					throw new ClassCastException("model_content extension requires " + loadedClass.getName() + " to be assignable to " + clazz.getName());
				instance = (T) loadedClass.newInstance();
			} catch (Exception e) {
				ModelRegistryEnvironment.logError("Failed to load model content '" + className + "'", e);
			}
		}
		return instance;
	}

	protected abstract Class<?> loadClass(String className) throws ClassNotFoundException;
	
	@Override public String toString() {
		return className;
	}
}