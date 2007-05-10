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
 * $Id: TupleLiteralPart.java,v 1.3 2007/05/10 17:48:22 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralPart#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralPart#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTupleLiteralPart()
 * @model
 * @generated
 */
public interface TupleLiteralPart<C, P> extends TypedElement<C>, Visitable, TypedASTNode {
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
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTupleLiteralPart_Value()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpression<C> getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.TupleLiteralPart#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression<C> value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(Object)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTupleLiteralPart_Attribute()
	 * @model
	 * @generated
	 */
	P getAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.TupleLiteralPart#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(P value);

} // TupleLiteralPart
