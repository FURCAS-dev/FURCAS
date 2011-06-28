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
 * $Id: IndexExpCS.java,v 1.3 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS#getFirstIndexes <em>First Indexes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS#getSecondIndexes <em>Second Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getIndexExpCS()
 * @model
 * @generated
 */
public interface IndexExpCS extends DecoratedNamedExpCS
{
	/**
	 * Returns the value of the '<em><b>First Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Indexes</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getIndexExpCS_FirstIndexes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ExpCS> getFirstIndexes();

	/**
	 * Returns the value of the '<em><b>Second Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Indexes</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getIndexExpCS_SecondIndexes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpCS> getSecondIndexes();

} // IndexExpCS
