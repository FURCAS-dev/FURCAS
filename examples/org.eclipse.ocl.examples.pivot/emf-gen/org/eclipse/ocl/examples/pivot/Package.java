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
 * $Id: Package.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A package is a container for types and other packages.
 * Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNestedPackages <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getOwnedPrecedences <em>Owned Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getOwnedTypes <em>Owned Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage()
 * @model
 * @generated
 */
public interface Package
		extends Namespace, TemplateableElement {

	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NsPrefix()
	 * @model dataType="org.eclipse.ocl.examples.pivot.String" ordered="false"
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Package#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns URI</em>' attribute.
	 * @see #setNsURI(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NsURI()
	 * @model dataType="org.eclipse.ocl.examples.pivot.String" ordered="false"
	 * @generated
	 */
	String getNsURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Package#getNsURI <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns URI</em>' attribute.
	 * @see #getNsURI()
	 * @generated
	 */
	void setNsURI(String value);

	/**
	 * Returns the value of the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Precedence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Precedences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Precedence</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_OwnedPrecedence()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Precedence> getOwnedPrecedences();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Precedence} and appends it to the '<em><b>Owned Precedence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Precedence}.
	 * @see #getOwnedPrecedences()
	 * @generated
	 */
	Precedence createOwnedPrecedence();

	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of contained packages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NestedPackage()
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestingPackage
	 * @model opposite="nestingPackage" containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<Package> getNestedPackages();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Package} and appends it to the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.Package} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Package}.
	 * @see #getNestedPackages()
	 * @generated
	 */
	Package createNestedPackage(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Package} and appends it to the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Package}.
	 * @see #getNestedPackages()
	 * @generated
	 */
	Package createNestedPackage();

	/**
	 * Returns the value of the '<em><b>Nesting Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getNestedPackages <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nesting Package</em>' container reference.
	 * @see #setNestingPackage(Package)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NestingPackage()
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestedPackages
	 * @model opposite="nestedPackage" transient="false" ordered="false"
	 * @generated
	 */
	Package getNestingPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nesting Package</em>' container reference.
	 * @see #getNestingPackage()
	 * @generated
	 */
	void setNestingPackage(Package value);

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Type}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Type#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of contained types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_OwnedType()
	 * @see org.eclipse.ocl.examples.pivot.Type#getPackage
	 * @model opposite="package" containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<Type> getOwnedTypes();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Type} and appends it to the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.Type} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Type}.
	 * @see #getOwnedTypes()
	 * @generated
	 */
	Type createOwnedType(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Type} and appends it to the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Type}.
	 * @see #getOwnedTypes()
	 * @generated
	 */
	Type createOwnedType();

} // Package
