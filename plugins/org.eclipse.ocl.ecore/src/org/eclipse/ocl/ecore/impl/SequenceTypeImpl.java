/**
 * <copyright>
 * </copyright>
 *
 * $Id: SequenceTypeImpl.java,v 1.1 2007/01/25 18:29:08 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.expressions.CollectionKind;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected SequenceTypeImpl(EClassifier elementType) {
        super(elementType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.SEQUENCE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public CollectionKind getKind() {
        return CollectionKind.SEQUENCE_LITERAL;
    }

} //SequenceTypeImpl
