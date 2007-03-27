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
 * $Id: SequenceTypeImpl.java,v 1.3 2007/03/27 15:05:16 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.uml.SequenceType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.uml2.uml.Classifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SequenceTypeImpl extends CollectionTypeImpl implements SequenceType {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SequenceTypeImpl() {
		super();
	}

    /**
     * @generated NOT
     */
    protected SequenceTypeImpl(Classifier elementType) {
        super(elementType);
    }

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return UMLPackage.Literals.SEQUENCE_TYPE;
	}

    /**
     * @generated NOT
     */
    public CollectionKind getKind() {
        return CollectionKind.SEQUENCE_LITERAL;
    }

} //SequenceTypeImpl
