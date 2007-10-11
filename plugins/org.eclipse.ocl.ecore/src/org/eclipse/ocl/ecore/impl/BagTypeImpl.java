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
 * $Id: BagTypeImpl.java,v 1.6 2007/10/11 23:04:41 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.util.Bag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bag Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BagTypeImpl extends CollectionTypeImpl implements BagType {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated NOT
	 */
    protected BagTypeImpl() {
		super();
        setInstanceClass(Bag.class);
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected BagTypeImpl(EClassifier elementType) {
        super(elementType);
        setInstanceClass(Bag.class);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.BAG_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public CollectionKind getKind() {
        return CollectionKind.BAG_LITERAL;
    }

} //BagTypeImpl
