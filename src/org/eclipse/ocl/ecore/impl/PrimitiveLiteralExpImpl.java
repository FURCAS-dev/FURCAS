/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrimitiveLiteralExpImpl.java,v 1.2 2007/10/11 23:04:40 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.PrimitiveLiteralExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PrimitiveLiteralExpImpl extends LiteralExpImpl implements PrimitiveLiteralExp {
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
        return EcorePackage.Literals.PRIMITIVE_LITERAL_EXP;
    }

} //PrimitiveLiteralExpImpl
