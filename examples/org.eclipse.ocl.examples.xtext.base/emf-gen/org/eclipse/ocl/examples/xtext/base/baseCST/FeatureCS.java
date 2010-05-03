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
 * $Id: FeatureCS.java,v 1.1 2010/05/03 05:25:09 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsDefinition <em>Is Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getFeatureCS()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface FeatureCS extends TypedElementCS {
	/**
	 * Returns the value of the '<em><b>Is Static</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Static</em>' attribute.
	 * @see #setIsStatic(boolean)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getFeatureCS_IsStatic()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isIsStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Definition</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Definition</em>' attribute.
	 * @see #setIsDefinition(boolean)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getFeatureCS_IsDefinition()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS#isIsDefinition <em>Is Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Definition</em>' attribute.
	 * @see #isIsDefinition()
	 * @generated
	 */
	void setIsDefinition(boolean value);

} // FeatureCS
