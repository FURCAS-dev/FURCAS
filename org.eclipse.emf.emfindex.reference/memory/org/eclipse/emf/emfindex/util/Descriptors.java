/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.emfindex.EObjectDescriptor;


/**
 * @author Sven Efftinge
 *
 */
public class Descriptors {
	
	/**
	 * @param the descriptor from which a proxy should be created
	 * @return an EMF proxy
	 */
	public static EObject createProxy(EObjectDescriptor desc) {
		EObject proxy = desc.getEClass().getEPackage().getEFactoryInstance().create(desc.getEClass());
		((InternalEObject)proxy).eSetProxyURI(desc.getFragmentURI());
		return proxy;
	}
}
