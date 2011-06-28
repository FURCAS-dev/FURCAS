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
 * $Id: ClassCS.java,v 1.3 2011/01/24 20:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedSuperType <em>Owned Super Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedOperation <em>Owned Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedProperty <em>Owned Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedMetaType <em>Owned Meta Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassCS()
 * @model
 * @generated
 */
public interface ClassCS extends ClassifierCS, NamespaceCS {
	/**
	 * Returns the value of the '<em><b>Owned Super Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Super Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Super Type</em>' containment reference list.
	 * @see #isSetOwnedSuperType()
	 * @see #unsetOwnedSuperType()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassCS_OwnedSuperType()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedSuperType();

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedSuperType <em>Owned Super Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOwnedSuperType()
	 * @see #getOwnedSuperType()
	 * @generated
	 */
	void unsetOwnedSuperType();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedSuperType <em>Owned Super Type</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Owned Super Type</em>' containment reference list is set.
	 * @see #unsetOwnedSuperType()
	 * @see #getOwnedSuperType()
	 * @generated
	 */
	boolean isSetOwnedSuperType();

	/**
	 * Returns the value of the '<em><b>Owned Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operation</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassCS_OwnedOperation()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<OperationCS> getOwnedOperation();

	/**
	 * Returns the value of the '<em><b>Owned Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Property</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassCS_OwnedProperty()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<StructuralFeatureCS> getOwnedProperty();

	/**
	 * Returns the value of the '<em><b>Owned Meta Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Meta Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Meta Type</em>' containment reference.
	 * @see #setOwnedMetaType(TypedRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassCS_OwnedMetaType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedMetaType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS#getOwnedMetaType <em>Owned Meta Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Meta Type</em>' containment reference.
	 * @see #getOwnedMetaType()
	 * @generated
	 */
	void setOwnedMetaType(TypedRefCS value);

} // ClassCS
