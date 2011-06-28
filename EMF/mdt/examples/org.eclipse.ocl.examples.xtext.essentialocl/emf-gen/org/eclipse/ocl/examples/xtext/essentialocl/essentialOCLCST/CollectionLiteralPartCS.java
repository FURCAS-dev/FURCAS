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
 * $Id: CollectionLiteralPartCS.java,v 1.3 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getLastExpressionCS <em>Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getCollectionLiteralPartCS()
 * @model
 * @generated
 */
public interface CollectionLiteralPartCS extends MonikeredElementCS {
	/**
	 * Returns the value of the '<em><b>Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression CS</em>' containment reference.
	 * @see #setExpressionCS(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getCollectionLiteralPartCS_ExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression CS</em>' containment reference.
	 * @see #getExpressionCS()
	 * @generated
	 */
	void setExpressionCS(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Last Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Expression CS</em>' containment reference.
	 * @see #setLastExpressionCS(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getCollectionLiteralPartCS_LastExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getLastExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getLastExpressionCS <em>Last Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Expression CS</em>' containment reference.
	 * @see #getLastExpressionCS()
	 * @generated
	 */
	void setLastExpressionCS(ExpCS value);

} // CollectionLiteralPartCS
