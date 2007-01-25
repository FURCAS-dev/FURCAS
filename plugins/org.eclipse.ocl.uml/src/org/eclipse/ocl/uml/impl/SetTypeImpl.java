/**
 * <copyright>
 * </copyright>
 *
 * $Id: SetTypeImpl.java,v 1.1 2007/01/25 18:39:26 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;

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
     * @generated NOT
     */
    public CollectionKind getKind() {
        return CollectionKind.SET_LITERAL;
    }

} //SetTypeImpl
