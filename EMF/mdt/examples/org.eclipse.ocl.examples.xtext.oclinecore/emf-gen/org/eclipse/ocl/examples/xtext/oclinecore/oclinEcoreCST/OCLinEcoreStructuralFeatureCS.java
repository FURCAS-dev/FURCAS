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
 * $Id: OCLinEcoreStructuralFeatureCS.java,v 1.2 2010/05/09 10:26:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS#getDefaultValueLiteral <em>Default Value Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getOCLinEcoreStructuralFeatureCS()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OCLinEcoreStructuralFeatureCS extends StructuralFeatureCS {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getOCLinEcoreStructuralFeatureCS_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getConstraints();

	/**
	 * Returns the value of the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value Literal</em>' attribute.
	 * @see #setDefaultValueLiteral(String)
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getOCLinEcoreStructuralFeatureCS_DefaultValueLiteral()
	 * @model
	 * @generated
	 */
	String getDefaultValueLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS#getDefaultValueLiteral <em>Default Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value Literal</em>' attribute.
	 * @see #getDefaultValueLiteral()
	 * @generated
	 */
	void setDefaultValueLiteral(String value);

} // StructuralFeatureCS
