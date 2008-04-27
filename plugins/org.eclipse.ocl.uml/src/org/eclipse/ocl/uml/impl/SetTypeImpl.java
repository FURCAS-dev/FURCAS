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
 * $Id: SetTypeImpl.java,v 1.6 2008/04/27 23:48:06 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.types.operations.SetTypeOperations;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.uml2.uml.Classifier;

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
	 * @generated
	 */
    protected SetTypeImpl() {
		super();
	}

    /**
     * @generated NOT
     */
    protected SetTypeImpl(Classifier elementType) {
        super(elementType);
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return UMLPackage.Literals.SET_TYPE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean checkCollectionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return SetTypeOperations.checkCollectionTypeName(this, diagnostics, context);
	}

    /**
     * @generated NOT
     */
    @Override
    public CollectionKind getKind() {
        return CollectionKind.SET_LITERAL;
    }

} //SetTypeImpl
