/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: ObjectAdapter.java,v 1.2 2008/12/04 14:58:21 dsciamma Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.utils;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;

/**
 * Provides a single static method to adapt a given object in an EObject
 * 
 * Creation 19 sept. 06
 * 
 * @author alfredo
 * 
 */
public final class ObjectAdapter {

	private ObjectAdapter() {
		// Instantiation forbidden
	}

	/**
	 * Returns the EObject associated with the given object. Returns
	 * <code>null</code> if no such object can be found.
	 * 
	 * 
	 * @param object
	 *            The object to look up its associated EObject
	 * @return the EObject associated to the given object, or <code>null</code>
	 *         if this object does not have any.
	 */
	public static EObject adaptObject(Object object) {
		return (EObject) adaptObject(object, EObject.class);
	}
	
	public static Object adaptObject(Object object, Class<?> adaptedClass) {
		if (object == null) {
			return null;
		} else if (adaptedClass.isInstance(object)) {
			return object;
		} else if (object instanceof IAdaptable) {
			// Try IAdaptable
			IAdaptable adapted = (IAdaptable) object;
			Object adaptedObject = adapted.getAdapter(adaptedClass);
			if (adaptedObject != null) {
				return adaptedObject;
			}
		} else {
			// Try registered adapter
			Object adapted = Platform.getAdapterManager().getAdapter(object, adaptedClass);
			if (adapted != null) {
				return adapted;
			}
		}
		return null;
	}
}
