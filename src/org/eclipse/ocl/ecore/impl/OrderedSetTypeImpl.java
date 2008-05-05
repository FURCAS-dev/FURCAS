/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * $Id: OrderedSetTypeImpl.java,v 1.7 2008/05/05 16:47:32 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.operations.OrderedSetTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordered Set Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrderedSetTypeImpl extends CollectionTypeImpl implements OrderedSetType {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated NOT
	 */
    protected OrderedSetTypeImpl() {
		super();
        setInstanceClass(LinkedHashSet.class);
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected OrderedSetTypeImpl(EClassifier elementType) {
        super(elementType);
        setInstanceClass(LinkedHashSet.class);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.ORDERED_SET_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public CollectionKind getKind() {
        return CollectionKind.ORDERED_SET_LITERAL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public boolean checkCollectionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return OrderedSetTypeOperations.checkCollectionTypeName(this, diagnostics, context);
    }

} //OrderedSetTypeImpl
