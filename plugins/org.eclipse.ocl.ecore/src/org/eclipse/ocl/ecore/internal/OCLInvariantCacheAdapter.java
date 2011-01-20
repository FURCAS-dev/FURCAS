/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.ecore.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * Caches the OCL invariants of an {@link EClassifier}. Adding this cache
 * doesn't {@link Notification#isTouch() "change"} the Ecore object to which it
 * is attached.
 * 
 * @author Axel Uhl
 * @since 3.1
 */
public class OCLInvariantCacheAdapter
		extends AdapterImpl {
	@Override
	public boolean isAdapterForType(Object type) {
		return type == OCLInvariantCacheAdapter.class;
	}

	private final Map<String, OCLExpression> invariants = new HashMap<String, OCLExpression>();
	
	public OCLInvariantCacheAdapter() {
	}
	
	public void put(String constraintName, OCLExpression expression) {
		invariants.put(constraintName, expression);
	}
	
	/**
	 * Returns the {@link OCLExpression} representing the abstract syntax of the constraint named
	 * <code>constraintName</code> if previously cached using {@link #put(String, OCLExpression)};
	 * <code>null</code> otherwise.
	 */
	public OCLExpression get(String constraintName) {
		return invariants.get(constraintName);
	}
	
	/**
	 * Removes any cache entry for the constraint named <code>constraintName</code> and
	 * returns any expression previously cached under that constraint name if any, or
	 * <code>null</code> otherwise.
	 */
	public OCLExpression remove(String constraintName) {
		return invariants.remove(constraintName);
	}
}
