/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Ed Willink - Bug 254919; Initial API and implementation
 *
 * </copyright>
 *
 * $Id: GenericFruitTestSuite.java,v 1.2 2010/04/25 06:50:19 ewillink Exp $
 */

package org.eclipse.ocl.tests;

import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Generic extended test framework for tests using the Fruit meta-model.
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class GenericFruitTestSuite<E extends EObject, PK extends E, T extends E, C extends T, CLS extends C, DT extends C, PT extends C, ET extends DT, O extends E, PM extends E, P extends E, PA extends P, PR extends P, EL, S, COA, SSA, CT>
	extends GenericTestSuite<E, PK, T, C, CLS, DT, PT, ET, O, PM, P, PA, PR, EL, S, COA, SSA, CT> {
    
    protected static interface InitEnvironment {
    	void init();
    }

	/**
	 * Set this true to suppress a failure from modifying the fruitPackage
	 */
	protected boolean expectModified = false;

	public PK fruitPackage;

	protected abstract void initFruitPackage();
	
	@Override
    protected void setUp() {
		super.setUp();
		initFruitPackage();
		if (environment instanceof InitEnvironment) {
			((InitEnvironment)environment).init();
		}
	}

	@Override
    protected void tearDown()
		throws Exception {
		final Resource resource = fruitPackage.eResource();
		final boolean isModified = resource.isModified();
		final boolean expectIsModified = expectModified;
		//
		//	Unload any resources that a test may have loaded.
		//
		for (ListIterator<Resource> i = resourceSet.getResources().listIterator(); i.hasNext(); ) {
			Resource res = i.next();
			if (((res == resource) && isModified)) {
				i.remove();
				res.unload();
                res.eAdapters().clear();
			}				
		}

		assertTrue(isModified == expectIsModified);	    
		super.tearDown();
	}
}
