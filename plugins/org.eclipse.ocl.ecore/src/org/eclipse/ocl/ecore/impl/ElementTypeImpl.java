/**
 * <copyright>
 * </copyright>
 *
 * $Id: ElementTypeImpl.java,v 1.1 2007/01/25 18:29:09 cdamus Exp $
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
    public String getName() {
        if (name == null) {
            name = SINGLETON_NAME;
        }
        
        return name;
    }

} //ElementTypeImpl
