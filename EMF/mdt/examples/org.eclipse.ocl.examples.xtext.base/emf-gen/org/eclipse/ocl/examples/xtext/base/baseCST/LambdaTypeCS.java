/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: LambdaTypeCS.java,v 1.1 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lambda Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS#getOwnedContextType <em>Owned Context Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS#getOwnedParameterType <em>Owned Parameter Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS#getOwnedResultType <em>Owned Result Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getLambdaTypeCS()
 * @model
 * @generated
 */
public interface LambdaTypeCS extends NamedElementCS, TypedRefCS, TemplateableElementCS
{
	/**
	 * Returns the value of the '<em><b>Owned Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Context Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Context Type</em>' containment reference.
	 * @see #setOwnedContextType(TypedRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getLambdaTypeCS_OwnedContextType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedContextType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS#getOwnedContextType <em>Owned Context Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Context Type</em>' containment reference.
	 * @see #getOwnedContextType()
	 * @generated
	 */
	void setOwnedContextType(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parameter Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameter Type</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getLambdaTypeCS_OwnedParameterType()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedParameterType();

	/**
	 * Returns the value of the '<em><b>Owned Result Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Result Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Result Type</em>' containment reference.
	 * @see #setOwnedResultType(TypedRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getLambdaTypeCS_OwnedResultType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedResultType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS#getOwnedResultType <em>Owned Result Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Result Type</em>' containment reference.
	 * @see #getOwnedResultType()
	 * @generated
	 */
	void setOwnedResultType(TypedRefCS value);

} // LambdaTypeCS
