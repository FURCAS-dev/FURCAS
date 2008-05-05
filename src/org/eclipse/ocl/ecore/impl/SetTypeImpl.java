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
 * $Id: SetTypeImpl.java,v 1.7 2008/05/05 16:47:32 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.operations.SetTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SetTypeImpl extends CollectionTypeImpl implements SetType {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated NOT
	 */
    protected SetTypeImpl() {
		super();
        setInstanceClass(Set.class);
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected SetTypeImpl(EClassifier elementType) {
        super(elementType);
        setInstanceClass(Set.class);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.SET_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public CollectionKind getKind() {
        return CollectionKind.SET_LITERAL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public boolean checkCollectionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return SetTypeOperations.checkCollectionTypeName(this, diagnostics, context);
    }

} //SetTypeImpl
