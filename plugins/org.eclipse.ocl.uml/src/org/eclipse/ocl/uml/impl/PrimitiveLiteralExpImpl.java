/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 IBM Corporation, Zeligsoft Inc., and others.
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
 * $Id: PrimitiveLiteralExpImpl.java,v 1.4 2008/10/12 01:12:32 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.uml.PrimitiveLiteralExp;
import org.eclipse.ocl.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PrimitiveLiteralExpImpl
		extends LiteralExpImpl
		implements PrimitiveLiteralExp {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLPackage.Literals.PRIMITIVE_LITERAL_EXP;
	}

} //PrimitiveLiteralExpImpl
