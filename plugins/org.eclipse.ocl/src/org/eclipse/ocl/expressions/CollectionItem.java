/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: CollectionItem.java,v 1.5 2008/03/28 20:33:34 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionItem#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionItem()
 * @model
 * @generated
 */
public interface CollectionItem<C> extends CollectionLiteralPart<C> {
	/**
     * Returns the value of the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Item</em>' containment reference.
     * @see #setItem(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionItem_Item()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<C> getItem();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.CollectionItem#getItem <em>Item</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item</em>' containment reference.
     * @see #getItem()
     * @generated
     */
	void setItem(OCLExpression<C> value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = item.type
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkItemType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CollectionItem
