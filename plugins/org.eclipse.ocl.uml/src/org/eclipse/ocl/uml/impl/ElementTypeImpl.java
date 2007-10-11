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
 * $Id: ElementTypeImpl.java,v 1.5 2007/10/11 23:05:21 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.uml.ElementType;
import org.eclipse.ocl.uml.UMLPackage;

import org.eclipse.uml2.uml.internal.impl.ClassifierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class ElementTypeImpl extends ClassifierImpl implements ElementType {
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
        return UMLPackage.Literals.ELEMENT_TYPE;
    }
    
    /**
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
