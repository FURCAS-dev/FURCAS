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
 * $Id: Element.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element is a constituent of a model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Element#getOwnedComments <em>Owned Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement()
 * @model abstract="true" superTypes="org.eclipse.ocl.examples.pivot.Visitable"
 * @extends PivotObject
 * @generated
 */
public interface Element
		extends PivotObject, Visitable {

	/**
	 * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Comment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Comments owned by this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Comment</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getElement_OwnedComment()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<Comment> getOwnedComments();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Comment} and appends it to the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Comment}.
	 * @see #getOwnedComments()
	 * @generated
	 */
	Comment createOwnedComment();

} // Element
