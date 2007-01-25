/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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

package org.eclipse.emf.ocl.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.types.OCLStandardLibrary;

/**
 * @deprecated Use the {@link org.eclipse.ocl.types.CollectionType} interface,
 * instead.  Note also, that the {@link OCLStandardLibrary#getCollection()}
 * method provides the <tt>Collection(T)</tt> generic instance of this metaclass.
 * 
 * @author Edith Schonberg (edith)
 */
public interface CollectionType extends EDataType, TypedASTNode, PredefinedType {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	public EClassifier getElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.types.CollectionType#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.ocl.expressions.CollectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.emf.ocl.expressions.CollectionKind
	 * @see org.eclipse.emf.ocl.types.TypesPackage#getCollectionType_Kind()
	 * @model required="true" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	CollectionKind getKind();

	/**
	 * Get the list of operations supported by OCL Collection Types
	 * @return the operations
	 */
	EList getOperations();

}
