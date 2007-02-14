/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: LiteralExpImpl.java,v 1.2 2007/02/14 14:45:39 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.LiteralExp;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class LiteralExpImpl extends OCLExpressionImpl implements LiteralExp {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private Object literalValue = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralExpImpl() {
		super();
	}

	/**
	 * The runtime value of the literal
	 * @param litValue
	 */
	public void setLiteralValue(Object litValue) {
		literalValue = litValue;
	}
	
	/**
	 * The runtime value of the literal
	 * @return the value
	 */
	public Object getLiteralValue() {
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.LITERAL_EXP;
	}

} //LiteralExpImpl
