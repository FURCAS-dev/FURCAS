/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ClassUtils.java,v 1.1 2010/03/11 13:54:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.utils;

public class ClassUtils
{	
	/**
	 * Return object cast to objectClass.
	 * @param object to cast.
	 * @param objectClass to cast to.
	 * @return cast object or null
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T asClassOrNull(Object object, Class<T> objectClass) {
		if (object == null)
			return null;
		if (!objectClass.isAssignableFrom(object.getClass()))
			return null;
		return (T) object;
	}
	
	/**
	 * Return object cast to T without a check.
	 * <p>
	 * This enables type-checking to be suppressed on a single expression term
	 * avoiding the need for suppressing unchecked warnings throughout the rest
	 * of an invoking method.
	 * <p>
	 * Use as: asClassUnchecked(object, (ArbitrarilyComplicatedType)null)
	 *
	 * @param <T> required type
	 * @param object to cast
	 * @param requiredClassObject dummy argument: use null
	 * @return cast type
	 */
	@SuppressWarnings("unchecked")
	public static <T> T asClassUnchecked(Object object, T requiredClassObject) {
		return (T) object;
	}
	
	/**
	 * Return object cast to T without a check.
	 * <p>
	 * This enables type-checking to suppressed on a single expression term
	 * avoiding the need for suppressing unchecked warnings throughout the rest
	 * of an invoking method.
	 * <p>
	 * Use as: ArbitrarilyComplicatedType castObject = asClassUnchecked(object);
	 *
	 * @param <T> required type
	 * @param object to cast
	 * @return cast type
	 */
	@SuppressWarnings("unchecked")
	public static <T> T asClassUnchecked(Object object) {
		return (T) object;
	}

	/**
	 * Return true if left and right are equal, avoiding an NPE by first using
	 * left==right before attempting left.equals(right).
	 * @param left
	 * @param right
	 * @return true if equals
	 */
	public static boolean equals(Object left, Object right) {
		if (left == right) {
			return true;
		}
		if (left == null) {
			return false;
		}
		return left.equals(right);
	}
	
	/**
	 * Return anObject cast to aClass if type-safe or null otherwise.
	 * @param anObject for which cast required
	 * @param aClass the type to which cast required
	 * @return the non-null cast of anObject if safe
	 */
	@SuppressWarnings("unchecked")
	public static <T> T isInstanceOf(Object anObject, Class<T> aClass) {
		if (anObject == null)
			return null;
		Class<?> objectClass = anObject.getClass();
		if (aClass.isAssignableFrom(objectClass))
			return (T) anObject;
		else
			return null;
	}
}
