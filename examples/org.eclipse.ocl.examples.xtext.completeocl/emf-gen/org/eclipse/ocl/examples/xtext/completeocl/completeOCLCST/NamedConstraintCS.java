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
 * $Id: NamedConstraintCS.java,v 1.1 2010/04/13 06:38:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS#getConstraintName <em>Constraint Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getNamedConstraintCS()
 * @model
 * @generated
 */
public interface NamedConstraintCS extends ConstraintCS {
	/**
	 * Returns the value of the '<em><b>Constraint Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Name</em>' containment reference.
	 * @see #setConstraintName(SimpleNameCS)
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getNamedConstraintCS_ConstraintName()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getConstraintName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS#getConstraintName <em>Constraint Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Name</em>' containment reference.
	 * @see #getConstraintName()
	 * @generated
	 */
	void setConstraintName(SimpleNameCS value);

} // NamedConstraintCS
