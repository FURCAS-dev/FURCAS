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
 * $Id: Operation.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An operation is owned by a class and may be invoked in the context of objects that are instances of that class. It is a typed element and a multiplicity element.
 * Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getRaisedExceptions <em>Raised Exception</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getOwnedParameters <em>Owned Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation
		extends TypedElement, Feature, MultiplicityElement, Namespace, ParameterableElement, TemplateableElement {

	/**
	 * Returns the value of the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedence</em>' reference.
	 * @see #setPrecedence(Precedence)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_Precedence()
	 * @model ordered="false"
	 * @generated
	 */
	Precedence getPrecedence();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Operation#getPrecedence <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' reference.
	 * @see #getPrecedence()
	 * @generated
	 */
	void setPrecedence(Precedence value);

	/**
	 * Returns the value of the '<em><b>Raised Exception</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exceptions that are declared as possible during an invocation of the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Raised Exception</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_RaisedException()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Type> getRaisedExceptions();

	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters to the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_OwnedParameter()
	 * @see org.eclipse.ocl.examples.pivot.Parameter#getOperation
	 * @model opposite="operation" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getOwnedParameters();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Parameter} and appends it to the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Parameter}.
	 * @see #getOwnedParameters()
	 * @generated
	 */
	Parameter createOwnedParameter();

	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Class#getOwnedOperations <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class that owns the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass_(org.eclipse.ocl.examples.pivot.Class)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_Class()
	 * @see org.eclipse.ocl.examples.pivot.Class#getOwnedOperations
	 * @model opposite="ownedOperation" transient="false" ordered="false"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Operation#getClass_ <em>Class</em>}' container reference.
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
	 * self.ownedParameter->size() = 1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateTestConstraint(DiagnosticChain diagnostics,
			Map<Object, Object> context);

} // Operation
