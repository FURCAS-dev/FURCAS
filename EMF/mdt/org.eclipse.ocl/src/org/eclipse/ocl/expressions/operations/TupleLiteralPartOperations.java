/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: TupleLiteralPartOperations.java,v 1.4 2009/06/25 19:23:52 ewillink Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tuple Literal Part</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#getName() <em>Get Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#getType() <em>Get Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#setName(java.lang.String) <em>Set Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#setType(java.lang.Object) <em>Set Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.Visitable#accept(org.eclipse.ocl.utilities.Visitor) <em>Accept</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralPart#checkValueType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Value Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleLiteralPartOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleLiteralPartOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, P> String getName(TupleLiteralPart<C, P> tupleLiteralPart) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, P> C getType(TupleLiteralPart<C, P> tupleLiteralPart) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, P> void setName(TupleLiteralPart<C, P> tupleLiteralPart,
			String name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, P> void setType(TupleLiteralPart<C, P> tupleLiteralPart,
			C type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, P, T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(
			TupleLiteralPart<C, P> tupleLiteralPart, U v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * attribute.type = value.type
	 * @param tupleLiteralPart The receiving '<em><b>Tuple Literal Part</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static <C, P> boolean checkValueType(
			TupleLiteralPart<C, P> tupleLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		String message = null;
		Environment<?, C, ?, P, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
			.getValidationEnvironment(tupleLiteralPart, context);

		if (env != null) {
			P attribute = tupleLiteralPart.getAttribute();
			OCLExpression<C> value = tupleLiteralPart.getValue();
			C type = (value == null)
				? null
				: value.getType();

			if ((attribute != null) && (type != null)) {
				C attrType = env.getUMLReflection().getOCLType(attribute);

				if (attrType != null) {
					if (!TypeUtil.exactTypeMatch(env, attrType, type)) {
						result = false;
						String tupleLiteral = null;
						if (tupleLiteralPart.eContainer() instanceof TupleLiteralExp<?, ?>) {
							tupleLiteral = tupleLiteralPart.eContainer()
								.toString();
						}
						message = OCLMessages.bind(
							OCLMessages.TuplePartType_ERROR_, tupleLiteralPart
								.getName(), tupleLiteral);
					}
				}
			}
		}

		if (!result) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
					ExpressionsValidator.DIAGNOSTIC_SOURCE,
					ExpressionsValidator.TUPLE_LITERAL_PART__VALUE_TYPE,
					message, new Object[]{tupleLiteralPart}));
			}
		}
		return result;
	}

} // TupleLiteralPartOperations