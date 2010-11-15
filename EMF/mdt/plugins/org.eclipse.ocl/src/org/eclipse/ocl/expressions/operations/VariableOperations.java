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
 * $Id: VariableOperations.java,v 1.3 2008/10/12 01:09:49 cdamus Exp $
 */
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Variable</b></em>' model objects.
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
 *   <li>{@link org.eclipse.ocl.expressions.Variable#checkInitType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Init Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, PM> String getName(Variable<C, PM> variable) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, PM> C getType(Variable<C, PM> variable) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, PM> void setName(Variable<C, PM> variable, String name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, PM> void setType(Variable<C, PM> variable, C type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <C, PM, T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(
			Variable<C, PM> variable, U v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * initExpression->notEmpty() implies initExpression.type.conformsTo (type)
	 * @param variable The receiving '<em><b>Variable</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static <C, PM> boolean checkInitType(Variable<C, PM> variable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		String message = null;
		Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
			.getValidationEnvironment(variable, context);

		if (env != null) {
			OCLExpression<C> init = variable.getInitExpression();
			C type = variable.getType();

			if ((init != null) && (init.getType() != null) && (type != null)) {
				if (!TypeUtil.compatibleTypeMatch(env, init.getType(), type)) {
					result = false;
					message = OCLMessages.bind(
						OCLMessages.TypeConformanceInit_ERROR_, variable
						.getName());
				}
			}
		}

		if (!result) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
					ExpressionsValidator.DIAGNOSTIC_SOURCE,
					ExpressionsValidator.VARIABLE__INIT_TYPE, message,
					new Object[]{variable}));
			}
		}
		return result;
	}

} // VariableOperations