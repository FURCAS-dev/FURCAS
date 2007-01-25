/**
 * <copyright>
 * </copyright>
 *
 * $Id: SequenceTypeImpl.java,v 1.1 2007/01/25 18:39:26 cdamus Exp $
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
