/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DelegatedBehavior.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

/**
 * @since 3.0
 */
public interface DelegatedBehavior<E, R, F>
{
	F getDefaultFactory();
	
	R getDefaultRegistry();
	
	EPackage getEPackage(E eObject);
	
	List<F> getFactories(E eObject);
	
	F getFactory(E eObject);
	
	Class<? extends F> getFactoryClass();

	String getName();
	
	Class<? extends R> getRegistryClass();

	void setDelegates(EPackage ePackage, List<String> delegateURIs);
}