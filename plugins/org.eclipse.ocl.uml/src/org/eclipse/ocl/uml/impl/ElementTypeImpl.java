/**
 * <copyright>
 * </copyright>
 *
 * $Id: ElementTypeImpl.java,v 1.2 2007/02/14 02:05:55 cdamus Exp $
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
    public String getName() {
        if (name == null) {
            name = SINGLETON_NAME;
        }
        
        return name;
    }

} //ElementTypeImpl
