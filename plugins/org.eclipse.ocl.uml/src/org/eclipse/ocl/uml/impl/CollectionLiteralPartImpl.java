/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CollectionLiteralPartImpl.java,v 1.5 2007/10/11 23:05:22 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.uml.CollectionLiteralPart;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.impl.TypedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public abstract class CollectionLiteralPartImpl extends TypedElementImpl implements CollectionLiteralPart {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CollectionLiteralPartImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return UMLPackage.Literals.COLLECTION_LITERAL_PART;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Classifier getType() {
		// override in order to unambiguously narrow the return type
		return (Classifier) super.getType();
	}

	/**
	 * @generated NOT
	 */
	public void setType(Classifier type) {
		setType((Type) type);
	}

} //CollectionLiteralPartImpl
