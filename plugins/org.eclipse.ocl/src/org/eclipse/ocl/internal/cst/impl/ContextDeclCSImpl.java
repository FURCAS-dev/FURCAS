/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: ContextDeclCSImpl.java,v 1.2 2007/02/14 14:46:04 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.ContextDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ContextDeclCSImpl extends CSTNodeImpl implements ContextDeclCS {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ContextDeclCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.CONTEXT_DECL_CS;
    }

} //ContextDeclCSImpl
