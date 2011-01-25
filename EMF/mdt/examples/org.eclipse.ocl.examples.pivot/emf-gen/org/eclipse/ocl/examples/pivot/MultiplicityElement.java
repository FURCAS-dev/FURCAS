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
 * $Id: MultiplicityElement.java,v 1.2 2011/01/24 20:42:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A multiplicity element embeds this information to specify the allowable cardinalities for an instantiation of this element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#isOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMultiplicityElement()
 * @model abstract="true"
 * @generated
 */
public interface MultiplicityElement
		extends MonikeredElement {

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this element are sequentially ordered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMultiplicityElement_IsOrdered()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#isOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this element are unique.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMultiplicityElement_IsUnique()
	 * @model default="true" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#isUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the lower bound of the multiplicity interval.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(BigInteger)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMultiplicityElement_Lower()
	 * @model default="1" dataType="org.eclipse.ocl.examples.pivot.Integer" ordered="false"
	 * @generated
	 */
	BigInteger getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the upper bound of the multiplicity interval.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(BigInteger)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMultiplicityElement_Upper()
	 * @model default="1" dataType="org.eclipse.ocl.examples.pivot.UnlimitedNatural" ordered="false"
	 * @generated
	 */
	BigInteger getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MultiplicityElement#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(BigInteger value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The lower bound must be a non-negative integer literal.
	 * lowerBound()->notEmpty() implies lowerBound() >= 0
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateLowerGe0(DiagnosticChain diagnostics,
			Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The upper bound must be greater than or equal to the lower bound.
	 * (upperBound()->notEmpty() and lowerBound()->notEmpty()) implies upperBound() >= lowerBound()
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateUpperGeLower(DiagnosticChain diagnostics,
			Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query lowerBound() returns the lower bound of the multiplicity as an integer.
	 * result = if lower->notEmpty() then lower else 1 endif
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.Integer" required="true" ordered="false"
	 * @generated
	 */
	BigInteger lowerBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query upperBound() returns the upper bound of the multiplicity for a bounded multiplicity as an unlimited natural.
	 * result = if upper->notEmpty() then upper else 1 endif
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.UnlimitedNatural" required="true" ordered="false"
	 * @generated
	 */
	BigInteger upperBound();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isMultivalued() checks whether this multiplicity has an upper bound greater than one.
	 * upperBound()->notEmpty()
	 * result = upperBound() > 1
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isMultivalued();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query includesCardinality() checks whether the specified cardinality is valid for this multiplicity.
	 * upperBound()->notEmpty() and lowerBound()->notEmpty()
	 * result = (lowerBound() <= C) and (upperBound() >= C)
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false" CDataType="org.eclipse.ocl.examples.pivot.Integer" CRequired="true" COrdered="false"
	 * @generated
	 */
	boolean includesCardinality(BigInteger C);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query includesMultiplicity() checks whether this multiplicity includes all the cardinalities allowed by the specified multiplicity.
	 * self.upperBound()->notEmpty() and self.lowerBound()->notEmpty() and M.upperBound()->notEmpty() and M.lowerBound()->notEmpty()
	 * result = (self.lowerBound() <= M.lowerBound()) and (self.upperBound() >= M.upperBound())
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false" MRequired="true" MOrdered="false"
	 * @generated
	 */
	boolean includesMultiplicity(MultiplicityElement M);

} // MultiplicityElement
