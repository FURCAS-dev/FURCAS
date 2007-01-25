/**
 * <copyright>
 * </copyright>
 *
 * $Id: EcoreFactory.java,v 1.1 2007/01/25 18:29:10 cdamus Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.ocl.utilities.TypeFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.ecore.EcorePackage
 * @generated
 */
public interface EcoreFactory extends EFactory, TypeFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EcoreFactory eINSTANCE = org.eclipse.ocl.ecore.impl.EcoreFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Any Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Any Type</em>'.
     * @generated
     */
    AnyType createAnyType();

    /**
     * Returns a new object of class '<em>Bag Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bag Type</em>'.
     * @generated
     */
    BagType createBagType();

    /**
     * Returns a new object of class '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Type</em>'.
     * @generated
     */
    CollectionType createCollectionType();

    /**
     * Returns a new object of class '<em>Element Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Element Type</em>'.
     * @generated
     */
    ElementType createElementType();

    /**
     * Returns a new object of class '<em>Invalid Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Invalid Type</em>'.
     * @generated
     */
    InvalidType createInvalidType();

    /**
     * Returns a new object of class '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Type</em>'.
     * @generated
     */
    MessageType createMessageType();

    /**
     * Returns a new object of class '<em>Ordered Set Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ordered Set Type</em>'.
     * @generated
     */
    OrderedSetType createOrderedSetType();

    /**
     * Returns a new object of class '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Type</em>'.
     * @generated
     */
    PrimitiveType createPrimitiveType();

    /**
     * Returns a new object of class '<em>Sequence Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Sequence Type</em>'.
     * @generated
     */
    SequenceType createSequenceType();

    /**
     * Returns a new object of class '<em>Set Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Set Type</em>'.
     * @generated
     */
    SetType createSetType();

    /**
     * Returns a new object of class '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Type</em>'.
     * @generated
     */
    TupleType createTupleType();

    /**
     * Returns a new object of class '<em>Type Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Type</em>'.
     * @generated
     */
    TypeType createTypeType();

    /**
     * Returns a new object of class '<em>Void Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Void Type</em>'.
     * @generated
     */
    VoidType createVoidType();

    /**
     * Returns a new object of class '<em>Call Operation Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Call Operation Action</em>'.
     * @generated
     */
    CallOperationAction createCallOperationAction();

    /**
     * Returns a new object of class '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Constraint</em>'.
     * @generated
     */
    Constraint createConstraint();

    /**
     * Returns a new object of class '<em>Send Signal Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Send Signal Action</em>'.
     * @generated
     */
    SendSignalAction createSendSignalAction();

    /**
     * Returns a new object of class '<em>Expression In OCL</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Expression In OCL</em>'.
     * @generated
     */
    ExpressionInOCL createExpressionInOCL();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    EcorePackage getEcorePackage();

} //EcoreFactory
