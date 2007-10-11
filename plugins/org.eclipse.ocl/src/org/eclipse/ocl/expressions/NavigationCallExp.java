/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: NavigationCallExp.java,v 1.4 2007/10/11 23:05:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.NavigationCallExp#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getNavigationCallExp()
 * @model abstract="true"
 * @generated
 */
public interface NavigationCallExp<C, P> extends FeatureCallExp<C> {
	/**
     * Returns the value of the '<em><b>Qualifier</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.expressions.OCLExpression}&lt;C>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Qualifier</em>' containment reference list.
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getNavigationCallExp_Qualifier()
     * @model containment="true"
     * @generated
     */
	EList<OCLExpression<C>> getQualifier();

	/**
     * Returns the value of the '<em><b>Navigation Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigation Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Navigation Source</em>' reference.
     * @see #setNavigationSource(Object)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getNavigationCallExp_NavigationSource()
     * @model kind="reference"
     * @generated
     */
	P getNavigationSource();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Navigation Source</em>' reference.
     * @see #getNavigationSource()
     * @generated
     */
	void setNavigationSource(P value);

} // NavigationCallExp
