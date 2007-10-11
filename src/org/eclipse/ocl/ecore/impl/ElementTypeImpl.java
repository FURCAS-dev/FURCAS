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
 * $Id: ElementTypeImpl.java,v 1.4 2007/10/11 23:04:41 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EClassImpl;

import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.ElementType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ElementTypeImpl extends EClassImpl implements ElementType {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ElementTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.ELEMENT_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public String getName() {
        if (name == null) {
            name = SINGLETON_NAME;
        }
        
        return name;
    }

} //ElementTypeImpl
