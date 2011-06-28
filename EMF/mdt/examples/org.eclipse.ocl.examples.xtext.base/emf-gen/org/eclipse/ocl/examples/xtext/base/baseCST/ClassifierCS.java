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
 * $Id: ClassifierCS.java,v 1.4 2011/01/24 20:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassifierCS()
 * @model abstract="true"
 * @generated
 */
public interface ClassifierCS extends NamedElementCS, TypeCS, TemplateableElementCS, ParameterableElementCS {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(PackageCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassifierCS_Owner()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS#getOwnedType
	 * @model opposite="ownedType" transient="false"
	 * @generated
	 */
	PackageCS getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(PackageCS value);

	/**
	 * Returns the value of the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Class Name</em>' attribute.
	 * @see #setInstanceClassName(String)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassifierCS_InstanceClassName()
	 * @model unsettable="true" suppressedIsSetVisibility="true" suppressedUnsetVisibility="true"
	 * @generated
	 */
	String getInstanceClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getInstanceClassName <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Class Name</em>' attribute.
	 * @see #getInstanceClassName()
	 * @generated
	 */
	void setInstanceClassName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Constraint</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassifierCS_OwnedConstraint()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedConstraint();

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassifierCS_Qualifier()
	 * @model
	 * @generated
	 */
	EList<String> getQualifier();

} // ClassifierCS
