/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: OrderedSetType.java,v 1.5 2009/12/22 18:52:41 ewillink Exp $
 */
package org.eclipse.ocl.types;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Set Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.types.TypesPackage#getOrderedSetType()
 * @model
 * @generated
 */
public interface OrderedSetType<C, O>
		extends CollectionType<C, O> {

	String SINGLETON_NAME = "OrderedSet"; //$NON-NLS-1$

} // OrderedSetType
