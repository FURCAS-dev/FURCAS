/**
 * <copyright>
 * </copyright>
 *
 * $Id: BagTypeImpl.java,v 1.1 2007/01/25 18:29:09 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.expressions.CollectionKind;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected BagTypeImpl(EClassifier elementType) {
        super(elementType);
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
    public CollectionKind getKind() {
        return CollectionKind.BAG_LITERAL;
    }

} //BagTypeImpl
