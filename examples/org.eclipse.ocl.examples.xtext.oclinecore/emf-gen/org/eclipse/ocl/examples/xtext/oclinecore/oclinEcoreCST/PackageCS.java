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
 * $Id: PackageCS.java,v 1.2 2010/04/16 18:05:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getSubpackages <em>Subpackages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getPackageCS()
 * @model
 * @generated
 */
public interface PackageCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Classifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifiers</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getPackageCS_Classifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassifierCS> getClassifiers();

	/**
	 * Returns the value of the '<em><b>Subpackages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subpackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpackages</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getPackageCS_Subpackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageCS> getSubpackages();

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getPackageCS_Prefix()
	 * @model
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getPackageCS_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // PackageCS
