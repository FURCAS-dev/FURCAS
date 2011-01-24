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
 * $Id: ReferenceCS.java,v 1.2 2011/01/24 20:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getReferenceCS()
 * @model
 * @generated
 */
public interface ReferenceCS extends StructuralFeatureCS {
	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' containment reference.
	 * @see #setOpposite(ReferenceCSRef)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getReferenceCS_Opposite()
	 * @model containment="true"
	 * @generated
	 */
	ReferenceCSRef getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getOpposite <em>Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' containment reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(ReferenceCSRef value);

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getReferenceCS_Keys()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeCSRef> getKeys();

} // ReferenceCS
