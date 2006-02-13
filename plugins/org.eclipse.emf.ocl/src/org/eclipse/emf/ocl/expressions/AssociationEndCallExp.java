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

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.EReference;

/**
 * @author Edith Schonberg (edith)
 */
public interface AssociationEndCallExp extends NavigationCallExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	public EReference getReferredAssociationEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.AssociationEndCallExp#getReferredAssociationEnd <em>Referred Association End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Association End</em>' reference.
	 * @see #getReferredAssociationEnd()
	 * @generated
	 */
	void setReferredAssociationEnd(EReference value);

}
