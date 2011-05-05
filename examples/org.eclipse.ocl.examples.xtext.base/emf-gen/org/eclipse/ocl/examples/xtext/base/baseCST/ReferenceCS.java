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
 * $Id: ReferenceCS.java,v 1.3 2011/05/05 17:53:02 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Property;


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
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(Property)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getReferenceCS_Opposite()
	 * @model
	 * @generated
	 */
	Property getOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(Property value);

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getReferenceCS_Keys()
	 * @model
	 * @generated
	 */
	EList<Property> getKeys();

} // ReferenceCS
