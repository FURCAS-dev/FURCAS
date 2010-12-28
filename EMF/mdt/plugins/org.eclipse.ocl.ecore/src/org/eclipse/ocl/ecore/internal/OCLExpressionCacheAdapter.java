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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.ocl.ecore.OCLExpression;


/**
 * Caches a single OCL expression in an adapter that can be attached, e.g., to an Ecore object
 * without {@link Notification#isTouch() "modifying"} the object to which the adapter gets attached.
 * 
 * @author Axel Uhl
 * @since 3.1
 */
public class OCLExpressionCacheAdapter
		extends AdapterImpl {
	private final OCLExpression expression;
	
	public OCLExpressionCacheAdapter(OCLExpression expression) {
		super();
		this.expression = expression;
	}

	public OCLExpression getExpression() {
		return expression;
	}
}
