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
 * $Id: UnlimitedNaturalLiteralExp.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unlimited Natural Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol <em>Unlimited Natural Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getUnlimitedNaturalLiteralExp()
 * @model
 * @generated
 */
public interface UnlimitedNaturalLiteralExp
		extends NumericLiteralExp {

	/**
	 * Returns the value of the '<em><b>Unlimited Natural Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unlimited Natural Symbol</em>' attribute.
	 * @see #setUnlimitedNaturalSymbol(BigInteger)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getUnlimitedNaturalLiteralExp_UnlimitedNaturalSymbol()
	 * @model dataType="org.eclipse.ocl.examples.pivot.UnlimitedNatural" required="true" ordered="false"
	 * @generated
	 */
	BigInteger getUnlimitedNaturalSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp#getUnlimitedNaturalSymbol <em>Unlimited Natural Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unlimited Natural Symbol</em>' attribute.
	 * @see #getUnlimitedNaturalSymbol()
	 * @generated
	 */
	void setUnlimitedNaturalSymbol(BigInteger value);

} // UnlimitedNaturalLiteralExp
