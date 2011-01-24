/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: InvalidLiteralExp.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invalid Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getReason <em>Reason</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getThrowable <em>Throwable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInvalidLiteralExp()
 * @model
 * @generated
 */
public interface InvalidLiteralExp
		extends LiteralExp {

	/**
	 * Returns the value of the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' attribute.
	 * @see #setObject(Object)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInvalidLiteralExp_Object()
	 * @model dataType="org.eclipse.ocl.examples.pivot.Object" ordered="false"
	 * @generated
	 */
	Object getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getObject <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' attribute.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(Object value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInvalidLiteralExp_Expression()
	 * @model ordered="false"
	 * @generated
	 */
	OclExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reason</em>' attribute.
	 * @see #setReason(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInvalidLiteralExp_Reason()
	 * @model dataType="org.eclipse.ocl.examples.pivot.String" ordered="false"
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getReason <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reason</em>' attribute.
	 * @see #getReason()
	 * @generated
	 */
	void setReason(String value);

	/**
	 * Returns the value of the '<em><b>Throwable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throwable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throwable</em>' attribute.
	 * @see #setThrowable(Throwable)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInvalidLiteralExp_Throwable()
	 * @model dataType="org.eclipse.ocl.examples.pivot.Throwable" ordered="false"
	 * @generated
	 */
	Throwable getThrowable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.InvalidLiteralExp#getThrowable <em>Throwable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throwable</em>' attribute.
	 * @see #getThrowable()
	 * @generated
	 */
	void setThrowable(Throwable value);
} // InvalidLiteralExp
