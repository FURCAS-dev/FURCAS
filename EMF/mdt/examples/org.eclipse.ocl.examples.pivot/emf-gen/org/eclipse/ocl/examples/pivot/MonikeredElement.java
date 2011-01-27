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
 * $Id: MonikeredElement.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monikered Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MonikeredElement#getMoniker <em>Moniker</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMonikeredElement()
 * @model abstract="true"
 * @generated
 */
public interface MonikeredElement
		extends Element {

	/**
	 * Returns the value of the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moniker</em>' attribute.
	 * @see #setMoniker(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMonikeredElement_Moniker()
	 * @model dataType="org.eclipse.ocl.examples.pivot.String" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getMoniker();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MonikeredElement#getMoniker <em>Moniker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moniker</em>' attribute.
	 * @see #getMoniker()
	 * @generated
	 */
	void setMoniker(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean hasMoniker();

} // NameableElement
