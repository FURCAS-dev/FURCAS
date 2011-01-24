/**
 * <copyright>
 *
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * $Id: ObjectUtil.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.common.utils.ClassUtils;

/**
 * Certain generic utility operations on objects.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ObjectUtil {

	/**
	 * Disposes of the specified <tt>object</tt>.  If, in particular, it is
	 * an {@link EObject}, then it and all of its contents will have their
	 * adapter-lists cleared.
	 * 
	 * @param object an object to dispose
	 * 
	 * @since 1.2
	 */
	public static void dispose(Object object) {
	    if (object instanceof EObject) {
	        EObject eObject = (EObject) object;
	        
            eObject.eAdapters().clear();
            for (Iterator<EObject> iter = EcoreUtil.getAllContents(eObject,
                false); iter.hasNext();) {
                iter.next().eAdapters().clear();
            }
	    } else if (object instanceof Collection<?>) {
	        for (Object next : ((Collection<?>) object)) {
	            dispose(next);
	        }
	    }
	}

	public static <T extends NamedElement> T getNamedElement(Collection<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}
}
