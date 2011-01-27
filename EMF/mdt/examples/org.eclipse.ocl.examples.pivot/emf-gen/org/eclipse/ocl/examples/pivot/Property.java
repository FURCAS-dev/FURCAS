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
 * $Id: Property.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A property is a typed element that represents an attribute of a class.
 * Property specializes ParameterableElement to specify that a property can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isID <em>Is ID</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isResolveProxies <em>Is Resolve Proxies</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#isVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Property#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty()
 * @model
 * @generated
 */
public interface Property
		extends TypedElement, Feature, MultiplicityElement, ParameterableElement {

	/**
	 * Returns the value of the '<em><b>Is Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If isReadOnly is true, the attribute may not be written to after initialization.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Read Only</em>' attribute.
	 * @see #setIsReadOnly(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsReadOnly()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isReadOnly <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setIsReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A string that is evaluated to give a default value for the attribute when an object of the owning class is instantiated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Default()
	 * @model dataType="org.eclipse.ocl.examples.pivot.String" ordered="false"
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If isComposite is true, the object containing the attribute is a container for the object or value contained in the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see #setIsComposite(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsComposite()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isComposite <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Composite</em>' attribute.
	 * @see #isComposite()
	 * @generated
	 */
	void setIsComposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If isDerived is true, the value of the attribute is derived from information elsewhere.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsDerived()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Two attributes attr1 and attr2 of two objects o1 and o2 (which may be the same object) may be paired with each other so that o1.attr1 refers to o2 if and only if o2.attr2 refers to o1. In such a case attr1 is the opposite of attr2 and attr2 is the opposite of attr1.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(Property)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Opposite()
	 * @model ordered="false"
	 * @generated
	 */
	Property getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(Property value);

	/**
	 * Returns the value of the '<em><b>Association</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttributes <em>Unowned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' reference.
	 * @see #setAssociation(AssociationClass)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Association()
	 * @see org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttributes
	 * @model opposite="unownedAttribute" ordered="false"
	 * @generated
	 */
	AssociationClass getAssociation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getAssociation <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(AssociationClass value);

	/**
	 * Returns the value of the '<em><b>Is ID</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is ID</em>' attribute.
	 * @see #setIsID(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsID()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isID();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isID <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is ID</em>' attribute.
	 * @see #isID()
	 * @generated
	 */
	void setIsID(boolean value);

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Keys()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Property> getKeys();

	/**
	 * Returns the value of the '<em><b>Is Resolve Proxies</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolve Proxies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Resolve Proxies</em>' attribute.
	 * @see #setIsResolveProxies(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsResolveProxies()
	 * @model default="true" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isResolveProxies();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isResolveProxies <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Resolve Proxies</em>' attribute.
	 * @see #isResolveProxies()
	 * @generated
	 */
	void setIsResolveProxies(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Transient</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Transient</em>' attribute.
	 * @see #setIsTransient(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsTransient()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isTransient <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setIsTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unsettable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsettable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unsettable</em>' attribute.
	 * @see #setIsUnsettable(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsUnsettable()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isUnsettable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isUnsettable <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unsettable</em>' attribute.
	 * @see #isUnsettable()
	 * @generated
	 */
	void setIsUnsettable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Volatile</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volatile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Volatile</em>' attribute.
	 * @see #setIsVolatile(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_IsVolatile()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isVolatile();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#isVolatile <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Volatile</em>' attribute.
	 * @see #isVolatile()
	 * @generated
	 */
	void setIsVolatile(boolean value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Class#getOwnedAttributes <em>Owned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class that owns the property, and of which the property is an attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass_(org.eclipse.ocl.examples.pivot.Class)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProperty_Class()
	 * @see org.eclipse.ocl.examples.pivot.Class#getOwnedAttributes
	 * @model opposite="ownedAttribute" transient="false" ordered="false"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Property#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass_(org.eclipse.ocl.examples.pivot.Class value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A binding of a property template parameter representing an attribute must be to an attribute.
	 * (isAttribute(self) and (templateParameterSubstitution->notEmpty())
	 *   implies (templateParameterSubstitution->forAll(ts | isAttribute(ts.formal)))
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateBindingToAttribute(DiagnosticChain diagnostics,
			Map<Object, Object> context);

} // Property
