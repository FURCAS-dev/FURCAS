/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import org.eclipse.emf.emfindex.ecore.CustomEmfindexFactoryImpl;
import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

import com.google.inject.Singleton;

/**
 * Performs initialization before anything is instantiated by Guice.
 * 
 * @author koehnlein
 */
@Singleton
public class IndexInitializer {
	public IndexInitializer() {
		EmfindexPackage.eINSTANCE.setEFactoryInstance(new CustomEmfindexFactoryImpl());
	}
}
