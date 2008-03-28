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
 * $Id: CollectionRange.java,v 1.5 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionRange#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionRange#getLast <em>Last</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionRange()
 * @model
 * @generated
 */
public interface CollectionRange<C> extends CollectionLiteralPart<C> {
	/**
     * Returns the value of the '<em><b>First</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>First</em>' containment reference.
     * @see #setFirst(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionRange_First()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<C> getFirst();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.CollectionRange#getFirst <em>First</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>First</em>' containment reference.
     * @see #getFirst()
     * @generated
     */
	void setFirst(OCLExpression<C> value);

	/**
     * Returns the value of the '<em><b>Last</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Last</em>' containment reference.
     * @see #setLast(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionRange_Last()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<C> getLast();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.CollectionRange#getLast <em>Last</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last</em>' containment reference.
     * @see #getLast()
     * @generated
     */
	void setLast(OCLExpression<C> value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = first.type.commonSuperType(last.type)
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkRangeType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CollectionRange
