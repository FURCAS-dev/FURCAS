/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ConstraintCS.java,v 1.2 2010/05/03 05:44:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprString <em>Expr String</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprValue <em>Expr Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getConstraintCS()
 * @model
 * @generated
 */
public interface ConstraintCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see #setStereotype(String)
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getConstraintCS_Stereotype()
	 * @model
	 * @generated
	 */
	String getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(String value);

	/**
	 * Returns the value of the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr String</em>' attribute.
	 * @see #setExprString(String)
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getConstraintCS_ExprString()
	 * @model
	 * @generated
	 */
	String getExprString();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprString <em>Expr String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr String</em>' attribute.
	 * @see #getExprString()
	 * @generated
	 */
	void setExprString(String value);

	/**
	 * Returns the value of the '<em><b>Expr Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr Value</em>' containment reference.
	 * @see #setExprValue(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getConstraintCS_ExprValue()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getExprValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS#getExprValue <em>Expr Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr Value</em>' containment reference.
	 * @see #getExprValue()
	 * @generated
	 */
	void setExprValue(ExpCS value);

} // ConstraintCS
