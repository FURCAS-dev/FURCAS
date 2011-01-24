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
 * $Id: MonikeredElementCS.java,v 1.2 2011/01/24 20:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monikered Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS#getMoniker <em>Moniker</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getMonikeredElementCS()
 * @model abstract="true"
 * @generated
 */
public interface MonikeredElementCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moniker</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moniker</em>' attribute.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getMonikeredElementCS_Moniker()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	String getMoniker();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasMoniker();

} // NameableElementCS
