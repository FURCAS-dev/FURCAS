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
 * $Id: AssociationClass.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.AssociationClass#getUnownedAttributes <em>Unowned Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAssociationClass()
 * @model
 * @generated
 */
public interface AssociationClass
		extends org.eclipse.ocl.examples.pivot.Class {

	/**
	 * Returns the value of the '<em><b>Unowned Attribute</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Property#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unowned Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unowned Attribute</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAssociationClass_UnownedAttribute()
	 * @see org.eclipse.ocl.examples.pivot.Property#getAssociation
	 * @model opposite="association" ordered="false"
	 * @generated
	 */
	EList<Property> getUnownedAttributes();

} // AssociationClass
