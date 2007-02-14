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
 * $Id: BagTypeImpl.java,v 1.2 2007/02/14 13:42:07 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.uml.BagType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.uml2.uml.Classifier;

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
     * @generated
     */
    protected BagTypeImpl() {
        super();
    }

    /**
     * @generated NOT
     */
    protected BagTypeImpl(Classifier elementType) {
        super(elementType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UMLPackage.Literals.BAG_TYPE;
    }
    
    /**
     * @generated NOT
     */
    public CollectionKind getKind() {
        return CollectionKind.BAG_LITERAL;
    }

} //BagTypeImpl
