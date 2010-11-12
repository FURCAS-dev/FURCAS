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
 * $Id: FeatureCallExp.java,v 1.6 2009/12/22 18:53:30 ewillink Exp $
 */
package org.eclipse.ocl.expressions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.FeatureCallExp#isMarkedPre <em>Marked Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getFeatureCallExp()
 * @model abstract="true"
 * @generated
 */
public interface FeatureCallExp<C>
		extends CallExp<C> {

	/**
	 * Returns the value of the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marked Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marked Pre</em>' attribute.
	 * @see #setMarkedPre(boolean)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getFeatureCallExp_MarkedPre()
	 * @model
	 * @generated
	 */
	boolean isMarkedPre();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.FeatureCallExp#isMarkedPre <em>Marked Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marked Pre</em>' attribute.
	 * @see #isMarkedPre()
	 * @generated
	 */
	void setMarkedPre(boolean value);

} // FeatureCallExp
