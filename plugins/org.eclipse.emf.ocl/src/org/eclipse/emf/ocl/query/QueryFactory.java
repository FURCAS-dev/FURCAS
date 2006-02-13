/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.query;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.query.QueryPackage
 * @generated
 */
public interface QueryFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueryFactory eINSTANCE = org.eclipse.emf.ocl.query.internal.impl.QueryFactoryImpl.init();

	/**
	 * Creates an OCL query from the specified OCL expression string, for the
	 * given OCL classifier context.
	 * <p>
	 * This method offers the convenience of creating the package and context
	 * declaration and other boilerplate components of the query on the caller's
	 * behalf; the specified expression must be only the bare expression without
	 * even the <tt>inv:</tt> keyword.  e.g.,
	 * <pre>
	 *     self.color &lt;&gt; Color::red
	 * </pre>
	 * instead of:
	 * <pre>
	 *     package com::examples::fruit
	 *     context Pomegranate
	 *     inv: self.color &lt;&gt; Color::red
	 *     endpackage
	 * </pre>
	 * </p>
	 * 
	 * @param expr the bare OCL expression text
	 * @param context the OCL classifier context
	 * @return the compiled OCL query object
	 * 
	 * @throws IllegalArgumentException if the OCL expression string
	 *     is malformed or the <code>context</code> is <code>null</code>
	 * 
	 * @generated NOT
	 */
	Query createQuery(String expr, EClassifier context);

	/**
	 * Returns a new object of class '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query</em>'.
	 * @generated
	 */
	Query createQuery();

	/**
	 * Creates a query from an {@link OCLExpression} (constraint or query).
	 * The query is validated according to OCL well-formedness rules.
	 * 
	 * @param expr the ocl expression
	 * @return the new query instance, if the OCL expression is valid
	 * 
	 * @throws IllegalArgumentException in case of well-formedness problems
	 * 
	 * @generated NOT
	 */
	Query createQuery(OCLExpression expr);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QueryPackage getQueryPackage();

} //QueryFactory
