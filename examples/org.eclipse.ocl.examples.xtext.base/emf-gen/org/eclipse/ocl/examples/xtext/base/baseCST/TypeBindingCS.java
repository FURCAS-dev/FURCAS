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
 * $Id: TypeBindingCS.java,v 1.1 2010/05/16 19:18:01 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Binding CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeParameter <em>Type Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeArgument <em>Type Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypeBindingCS()
 * @model
 * @generated
 */
public interface TypeBindingCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Type Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameter</em>' reference.
	 * @see #setTypeParameter(TypeParameterCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypeBindingCS_TypeParameter()
	 * @model resolveProxies="false"
	 * @generated
	 */
	TypeParameterCS getTypeParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeParameter <em>Type Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Parameter</em>' reference.
	 * @see #getTypeParameter()
	 * @generated
	 */
	void setTypeParameter(TypeParameterCS value);

	/**
	 * Returns the value of the '<em><b>Type Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Argument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Argument</em>' reference.
	 * @see #setTypeArgument(ClassifierCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypeBindingCS_TypeArgument()
	 * @model resolveProxies="false"
	 * @generated
	 */
	ClassifierCS getTypeArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS#getTypeArgument <em>Type Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Argument</em>' reference.
	 * @see #getTypeArgument()
	 * @generated
	 */
	void setTypeArgument(ClassifierCS value);

} // TypeBindingCS
