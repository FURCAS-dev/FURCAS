/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *
 * </copyright>
 *
 * $Id: IterateExpCSImpl.java,v 1.3 2008/11/30 22:11:37 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.IterateExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IterateExpCSImpl
		extends LoopExpCSImpl
		implements IterateExpCS {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterateExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.ITERATE_EXP_CS;
	}

} //IterateExpCSImpl
