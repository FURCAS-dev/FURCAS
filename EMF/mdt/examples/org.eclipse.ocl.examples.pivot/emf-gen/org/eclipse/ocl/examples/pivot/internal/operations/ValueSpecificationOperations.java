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
 * $Id: ValueSpecificationOperations.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.operations;

import java.math.BigInteger;

import org.eclipse.ocl.examples.pivot.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Value Specification</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ValueSpecification#isComputable() <em>Is Computable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ValueSpecification#integerValue() <em>Integer Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ValueSpecification#booleanValue() <em>Boolean Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ValueSpecification#stringValue() <em>String Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ValueSpecification#unlimitedValue() <em>Unlimited Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ValueSpecification#isNull() <em>Is Null</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueSpecificationOperations
		extends MonikeredElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueSpecificationOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isComputable() determines whether a value specification can be computed in a model. This operation cannot be fully defined in OCL. A conforming implementation is expected to deliver true for this operation for all value specifications that it can compute, and to compute all of those for which the operation is true. A conforming implementation is expected to be able to compute the value of all literals.
	 * result = false
	 * @param valueSpecification The receiving '<em><b>Value Specification</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean isComputable(ValueSpecification valueSpecification) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query integerValue() gives a single Integer value when one can be computed.
	 * result = Set{}
	 * @param valueSpecification The receiving '<em><b>Value Specification</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static BigInteger integerValue(ValueSpecification valueSpecification) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query booleanValue() gives a single Boolean value when one can be computed.
	 * result = Set{}
	 * @param valueSpecification The receiving '<em><b>Value Specification</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean booleanValue(ValueSpecification valueSpecification) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query stringValue() gives a single String value when one can be computed.
	 * result = Set{}
	 * @param valueSpecification The receiving '<em><b>Value Specification</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static String stringValue(ValueSpecification valueSpecification) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query unlimitedValue() gives a single UnlimitedNatural value when one can be computed.
	 * result = Set{}
	 * @param valueSpecification The receiving '<em><b>Value Specification</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static BigInteger unlimitedValue(
			ValueSpecification valueSpecification) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isNull() returns true when it can be computed that the value is null.
	 * result = false
	 * @param valueSpecification The receiving '<em><b>Value Specification</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean isNull(ValueSpecification valueSpecification) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} // ValueSpecificationOperations