/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: AbstractConversion.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public abstract class AbstractConversion extends EcoreUtil
{	// extends EcoreUtil solely to gain access to protected GEN_MODEL_PACKAGE_NS_URI
	protected static <T> T basicGet(EObject eObject, EAttribute eFeature, Class<T> resultClass) {
		if (!eObject.eIsSet(eFeature)) {
			return null;
		}
		@SuppressWarnings("unchecked")
		T result = (T) eObject.eGet(eFeature);
		return result;
	}

	public static EPackage getEPackage(EObject eObject) {
		for (; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof EPackage) {
				return (EPackage)eObject;
			}
		}
		return null;
	}

	public static boolean isId(String name) {
		int n = name.length();
		if (n == 0)
			return false;
		if (!Character.isJavaIdentifierStart(name.charAt(0)))
			return false;
		for (int i = 1; i < n; i++)
			if (!Character.isJavaIdentifierPart(name.charAt(i)))
				return false;
		return true;
	}

	public <T> void refreshList(List<? super T> oldElements, List<? extends T> newElements) {
		PivotUtil.refreshList(oldElements, newElements);
	}

	protected <T> void refreshSet(List<? super T> oldElements, Collection<? extends T> newElements) {
		PivotUtil.refreshSet(oldElements, newElements);
	}
}