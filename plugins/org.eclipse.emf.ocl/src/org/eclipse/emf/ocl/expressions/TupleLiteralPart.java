/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: TupleLiteralPart.java,v 1.1 2006/04/04 18:09:06 cdamus Exp $
 */
package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ocl.uml.TypedElement;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.TupleLiteralPart#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.TupleLiteralPart#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getTupleLiteralPart()
 * @model
 * @generated
 */
public interface TupleLiteralPart extends TypedElement, Visitable, TypedASTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OCLExpression)
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getTupleLiteralPart_Value()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.TupleLiteralPart#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EStructuralFeature)
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getTupleLiteralPart_Attribute()
	 * @model
	 * @generated
	 */
	EStructuralFeature getAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.TupleLiteralPart#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EStructuralFeature value);

} // TupleLiteralPart
