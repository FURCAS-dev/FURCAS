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
 * $Id: IterateExp.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.IterateExp#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIterateExp()
 * @model
 * @generated
 */
public interface IterateExp extends LoopExp
{
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(Variable)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIterateExp_Result()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Variable getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.IterateExp#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Variable value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Variable} and sets the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * @see #getResult()
	 * @generated
	 */
	Variable createResult();

} // IterateExp
