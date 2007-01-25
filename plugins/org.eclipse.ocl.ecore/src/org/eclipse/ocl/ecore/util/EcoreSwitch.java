/**
 * <copyright>
 * </copyright>
 *
 * $Id: EcoreSwitch.java,v 1.1 2007/01/25 18:29:10 cdamus Exp $
 */
package org.eclipse.ocl.ecore.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.ecore.*;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.ecore.EcorePackage
 * @generated
 */
public class EcoreSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static EcorePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EcoreSwitch() {
        if (modelPackage == null) {
            modelPackage = EcorePackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case EcorePackage.ANY_TYPE: {
                AnyType anyType = (AnyType)theEObject;
                T result = caseAnyType(anyType);
                if (result == null) result = caseEClassifier(anyType);
                if (result == null) result = caseAnyType_1(anyType);
                if (result == null) result = caseENamedElement(anyType);
                if (result == null) result = casePredefinedType(anyType);
                if (result == null) result = caseEModelElement(anyType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.BAG_TYPE: {
                BagType bagType = (BagType)theEObject;
                T result = caseBagType(bagType);
                if (result == null) result = caseCollectionType(bagType);
                if (result == null) result = caseBagType_1(bagType);
                if (result == null) result = caseEDataType(bagType);
                if (result == null) result = caseCollectionType_1(bagType);
                if (result == null) result = caseEClassifier(bagType);
                if (result == null) result = casePredefinedType(bagType);
                if (result == null) result = caseTypedASTNode(bagType);
                if (result == null) result = caseENamedElement(bagType);
                if (result == null) result = caseASTNode(bagType);
                if (result == null) result = caseEModelElement(bagType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.COLLECTION_TYPE: {
                CollectionType collectionType = (CollectionType)theEObject;
                T result = caseCollectionType(collectionType);
                if (result == null) result = caseEDataType(collectionType);
                if (result == null) result = caseCollectionType_1(collectionType);
                if (result == null) result = caseEClassifier(collectionType);
                if (result == null) result = casePredefinedType(collectionType);
                if (result == null) result = caseTypedASTNode(collectionType);
                if (result == null) result = caseENamedElement(collectionType);
                if (result == null) result = caseASTNode(collectionType);
                if (result == null) result = caseEModelElement(collectionType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.ELEMENT_TYPE: {
                ElementType elementType = (ElementType)theEObject;
                T result = caseElementType(elementType);
                if (result == null) result = caseEClass(elementType);
                if (result == null) result = caseElementType_1(elementType);
                if (result == null) result = caseEClassifier(elementType);
                if (result == null) result = caseENamedElement(elementType);
                if (result == null) result = caseEModelElement(elementType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.INVALID_TYPE: {
                InvalidType invalidType = (InvalidType)theEObject;
                T result = caseInvalidType(invalidType);
                if (result == null) result = caseEClassifier(invalidType);
                if (result == null) result = caseInvalidType_1(invalidType);
                if (result == null) result = caseENamedElement(invalidType);
                if (result == null) result = casePredefinedType(invalidType);
                if (result == null) result = caseEModelElement(invalidType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.MESSAGE_TYPE: {
                MessageType messageType = (MessageType)theEObject;
                T result = caseMessageType(messageType);
                if (result == null) result = caseEClass(messageType);
                if (result == null) result = caseMessageType_1(messageType);
                if (result == null) result = caseEClassifier(messageType);
                if (result == null) result = casePredefinedType(messageType);
                if (result == null) result = caseENamedElement(messageType);
                if (result == null) result = caseEModelElement(messageType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.ORDERED_SET_TYPE: {
                OrderedSetType orderedSetType = (OrderedSetType)theEObject;
                T result = caseOrderedSetType(orderedSetType);
                if (result == null) result = caseCollectionType(orderedSetType);
                if (result == null) result = caseOrderedSetType_1(orderedSetType);
                if (result == null) result = caseEDataType(orderedSetType);
                if (result == null) result = caseCollectionType_1(orderedSetType);
                if (result == null) result = caseEClassifier(orderedSetType);
                if (result == null) result = casePredefinedType(orderedSetType);
                if (result == null) result = caseTypedASTNode(orderedSetType);
                if (result == null) result = caseENamedElement(orderedSetType);
                if (result == null) result = caseASTNode(orderedSetType);
                if (result == null) result = caseEModelElement(orderedSetType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.PRIMITIVE_TYPE: {
                PrimitiveType primitiveType = (PrimitiveType)theEObject;
                T result = casePrimitiveType(primitiveType);
                if (result == null) result = caseEDataType(primitiveType);
                if (result == null) result = casePrimitiveType_1(primitiveType);
                if (result == null) result = caseEClassifier(primitiveType);
                if (result == null) result = casePredefinedType(primitiveType);
                if (result == null) result = caseENamedElement(primitiveType);
                if (result == null) result = caseEModelElement(primitiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.SEQUENCE_TYPE: {
                SequenceType sequenceType = (SequenceType)theEObject;
                T result = caseSequenceType(sequenceType);
                if (result == null) result = caseCollectionType(sequenceType);
                if (result == null) result = caseSequenceType_1(sequenceType);
                if (result == null) result = caseEDataType(sequenceType);
                if (result == null) result = caseCollectionType_1(sequenceType);
                if (result == null) result = caseEClassifier(sequenceType);
                if (result == null) result = casePredefinedType(sequenceType);
                if (result == null) result = caseTypedASTNode(sequenceType);
                if (result == null) result = caseENamedElement(sequenceType);
                if (result == null) result = caseASTNode(sequenceType);
                if (result == null) result = caseEModelElement(sequenceType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.SET_TYPE: {
                SetType setType = (SetType)theEObject;
                T result = caseSetType(setType);
                if (result == null) result = caseCollectionType(setType);
                if (result == null) result = caseSetType_1(setType);
                if (result == null) result = caseEDataType(setType);
                if (result == null) result = caseCollectionType_1(setType);
                if (result == null) result = caseEClassifier(setType);
                if (result == null) result = casePredefinedType(setType);
                if (result == null) result = caseTypedASTNode(setType);
                if (result == null) result = caseENamedElement(setType);
                if (result == null) result = caseASTNode(setType);
                if (result == null) result = caseEModelElement(setType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.TUPLE_TYPE: {
                TupleType tupleType = (TupleType)theEObject;
                T result = caseTupleType(tupleType);
                if (result == null) result = caseEClass(tupleType);
                if (result == null) result = caseTupleType_1(tupleType);
                if (result == null) result = caseEClassifier(tupleType);
                if (result == null) result = casePredefinedType(tupleType);
                if (result == null) result = caseENamedElement(tupleType);
                if (result == null) result = caseEModelElement(tupleType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.TYPE_TYPE: {
                TypeType typeType = (TypeType)theEObject;
                T result = caseTypeType(typeType);
                if (result == null) result = caseEClassifier(typeType);
                if (result == null) result = caseTypeType_1(typeType);
                if (result == null) result = caseENamedElement(typeType);
                if (result == null) result = casePredefinedType(typeType);
                if (result == null) result = caseEModelElement(typeType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.VOID_TYPE: {
                VoidType voidType = (VoidType)theEObject;
                T result = caseVoidType(voidType);
                if (result == null) result = caseEClassifier(voidType);
                if (result == null) result = caseVoidType_1(voidType);
                if (result == null) result = caseENamedElement(voidType);
                if (result == null) result = casePredefinedType(voidType);
                if (result == null) result = caseEModelElement(voidType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.CALL_OPERATION_ACTION: {
                CallOperationAction callOperationAction = (CallOperationAction)theEObject;
                T result = caseCallOperationAction(callOperationAction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.CONSTRAINT: {
                Constraint constraint = (Constraint)theEObject;
                T result = caseConstraint(constraint);
                if (result == null) result = caseENamedElement(constraint);
                if (result == null) result = caseEModelElement(constraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.SEND_SIGNAL_ACTION: {
                SendSignalAction sendSignalAction = (SendSignalAction)theEObject;
                T result = caseSendSignalAction(sendSignalAction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case EcorePackage.EXPRESSION_IN_OCL: {
                ExpressionInOCL expressionInOCL = (ExpressionInOCL)theEObject;
                T result = caseExpressionInOCL(expressionInOCL);
                if (result == null) result = caseExpressionInOCL_1(expressionInOCL);
                if (result == null) result = caseVisitable(expressionInOCL);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Any Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Any Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAnyType(AnyType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Bag Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Bag Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBagType(BagType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Collection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCollectionType(CollectionType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Element Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Element Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElementType(ElementType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Invalid Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Invalid Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInvalidType(InvalidType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Message Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMessageType(MessageType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Ordered Set Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Ordered Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOrderedSetType(OrderedSetType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitiveType(PrimitiveType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Sequence Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Sequence Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSequenceType(SequenceType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Set Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSetType(SetType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Tuple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTupleType(TupleType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Type Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Type Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeType(TypeType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Void Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Void Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVoidType(VoidType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Call Operation Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Call Operation Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCallOperationAction(CallOperationAction object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConstraint(Constraint object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Send Signal Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Send Signal Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSendSignalAction(SendSignalAction object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Expression In OCL</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Expression In OCL</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExpressionInOCL(ExpressionInOCL object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EModel Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EModel Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEModelElement(EModelElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseENamedElement(ENamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EClassifier</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EClassifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEClassifier(EClassifier object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Predefined Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Predefined Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T casePredefinedType(PredefinedType<O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Any Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Any Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T caseAnyType_1(org.eclipse.ocl.types.AnyType<O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EData Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EData Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEDataType(EDataType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>AST Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseASTNode(ASTNode object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Typed AST Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Typed AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypedASTNode(TypedASTNode object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Collection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseCollectionType_1(org.eclipse.ocl.types.CollectionType<C, O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Bag Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Bag Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseBagType_1(org.eclipse.ocl.types.BagType<C, O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EClass</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EClass</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEClass(EClass object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Element Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Element Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElementType_1(org.eclipse.ocl.types.ElementType object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Invalid Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Invalid Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T caseInvalidType_1(org.eclipse.ocl.types.InvalidType<O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Message Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O, P> T caseMessageType_1(org.eclipse.ocl.types.MessageType<C, O, P> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Ordered Set Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Ordered Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseOrderedSetType_1(org.eclipse.ocl.types.OrderedSetType<C, O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T casePrimitiveType_1(org.eclipse.ocl.types.PrimitiveType<O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Sequence Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Sequence Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseSequenceType_1(org.eclipse.ocl.types.SequenceType<C, O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Set Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseSetType_1(org.eclipse.ocl.types.SetType<C, O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Tuple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O, P> T caseTupleType_1(org.eclipse.ocl.types.TupleType<O, P> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Type Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Type Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, O> T caseTypeType_1(org.eclipse.ocl.types.TypeType<C, O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Void Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Void Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <O> T caseVoidType_1(org.eclipse.ocl.types.VoidType<O> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Visitable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Visitable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVisitable(Visitable object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Expression In OCL</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Expression In OCL</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <C, PM> T caseExpressionInOCL_1(org.eclipse.ocl.utilities.ExpressionInOCL<C, PM> object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //EcoreSwitch
