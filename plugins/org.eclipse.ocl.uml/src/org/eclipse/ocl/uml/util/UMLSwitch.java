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
 * $Id: UMLSwitch.java,v 1.2 2007/02/14 13:42:08 cdamus Exp $
 */
package org.eclipse.ocl.uml.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.uml.*;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.Visitable;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.ValueSpecification;

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
 * @see org.eclipse.ocl.uml.UMLPackage
 * @generated
 */
public class UMLSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static UMLPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLSwitch() {
        if (modelPackage == null) {
            modelPackage = UMLPackage.eINSTANCE;
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
            case UMLPackage.ANY_TYPE: {
                AnyType anyType = (AnyType)theEObject;
                T result = caseAnyType(anyType);
                if (result == null) result = caseClassifier(anyType);
                if (result == null) result = caseAnyType_1(anyType);
                if (result == null) result = caseNamespace(anyType);
                if (result == null) result = caseRedefinableElement(anyType);
                if (result == null) result = caseType(anyType);
                if (result == null) result = caseTemplateableElement(anyType);
                if (result == null) result = casePredefinedType(anyType);
                if (result == null) result = caseNamedElement(anyType);
                if (result == null) result = casePackageableElement(anyType);
                if (result == null) result = caseElement(anyType);
                if (result == null) result = caseParameterableElement(anyType);
                if (result == null) result = caseEModelElement(anyType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.VOID_TYPE: {
                VoidType voidType = (VoidType)theEObject;
                T result = caseVoidType(voidType);
                if (result == null) result = caseClassifier(voidType);
                if (result == null) result = caseVoidType_1(voidType);
                if (result == null) result = caseNamespace(voidType);
                if (result == null) result = caseRedefinableElement(voidType);
                if (result == null) result = caseType(voidType);
                if (result == null) result = caseTemplateableElement(voidType);
                if (result == null) result = casePredefinedType(voidType);
                if (result == null) result = caseNamedElement(voidType);
                if (result == null) result = casePackageableElement(voidType);
                if (result == null) result = caseElement(voidType);
                if (result == null) result = caseParameterableElement(voidType);
                if (result == null) result = caseEModelElement(voidType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.INVALID_TYPE: {
                InvalidType invalidType = (InvalidType)theEObject;
                T result = caseInvalidType(invalidType);
                if (result == null) result = caseClassifier(invalidType);
                if (result == null) result = caseInvalidType_1(invalidType);
                if (result == null) result = caseNamespace(invalidType);
                if (result == null) result = caseRedefinableElement(invalidType);
                if (result == null) result = caseType(invalidType);
                if (result == null) result = caseTemplateableElement(invalidType);
                if (result == null) result = casePredefinedType(invalidType);
                if (result == null) result = caseNamedElement(invalidType);
                if (result == null) result = casePackageableElement(invalidType);
                if (result == null) result = caseElement(invalidType);
                if (result == null) result = caseParameterableElement(invalidType);
                if (result == null) result = caseEModelElement(invalidType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.ELEMENT_TYPE: {
                ElementType elementType = (ElementType)theEObject;
                T result = caseElementType(elementType);
                if (result == null) result = caseClassifier(elementType);
                if (result == null) result = caseElementType_1(elementType);
                if (result == null) result = caseNamespace(elementType);
                if (result == null) result = caseRedefinableElement(elementType);
                if (result == null) result = caseType(elementType);
                if (result == null) result = caseTemplateableElement(elementType);
                if (result == null) result = caseNamedElement(elementType);
                if (result == null) result = casePackageableElement(elementType);
                if (result == null) result = caseElement(elementType);
                if (result == null) result = caseParameterableElement(elementType);
                if (result == null) result = caseEModelElement(elementType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.TYPE_TYPE: {
                TypeType typeType = (TypeType)theEObject;
                T result = caseTypeType(typeType);
                if (result == null) result = caseClassifier(typeType);
                if (result == null) result = caseTypeType_1(typeType);
                if (result == null) result = caseNamespace(typeType);
                if (result == null) result = caseRedefinableElement(typeType);
                if (result == null) result = caseType(typeType);
                if (result == null) result = caseTemplateableElement(typeType);
                if (result == null) result = casePredefinedType(typeType);
                if (result == null) result = caseNamedElement(typeType);
                if (result == null) result = casePackageableElement(typeType);
                if (result == null) result = caseElement(typeType);
                if (result == null) result = caseParameterableElement(typeType);
                if (result == null) result = caseEModelElement(typeType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.MESSAGE_TYPE: {
                MessageType messageType = (MessageType)theEObject;
                T result = caseMessageType(messageType);
                if (result == null) result = caseClassifier(messageType);
                if (result == null) result = caseMessageType_1(messageType);
                if (result == null) result = caseNamespace(messageType);
                if (result == null) result = caseRedefinableElement(messageType);
                if (result == null) result = caseType(messageType);
                if (result == null) result = caseTemplateableElement(messageType);
                if (result == null) result = casePredefinedType(messageType);
                if (result == null) result = caseNamedElement(messageType);
                if (result == null) result = casePackageableElement(messageType);
                if (result == null) result = caseElement(messageType);
                if (result == null) result = caseParameterableElement(messageType);
                if (result == null) result = caseEModelElement(messageType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.PRIMITIVE_TYPE: {
                PrimitiveType primitiveType = (PrimitiveType)theEObject;
                T result = casePrimitiveType(primitiveType);
                if (result == null) result = casePrimitiveType_1(primitiveType);
                if (result == null) result = casePrimitiveType_2(primitiveType);
                if (result == null) result = caseDataType(primitiveType);
                if (result == null) result = casePredefinedType(primitiveType);
                if (result == null) result = caseClassifier(primitiveType);
                if (result == null) result = caseNamespace(primitiveType);
                if (result == null) result = caseRedefinableElement(primitiveType);
                if (result == null) result = caseType(primitiveType);
                if (result == null) result = caseTemplateableElement(primitiveType);
                if (result == null) result = caseNamedElement(primitiveType);
                if (result == null) result = casePackageableElement(primitiveType);
                if (result == null) result = caseElement(primitiveType);
                if (result == null) result = caseParameterableElement(primitiveType);
                if (result == null) result = caseEModelElement(primitiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.COLLECTION_TYPE: {
                CollectionType collectionType = (CollectionType)theEObject;
                T result = caseCollectionType(collectionType);
                if (result == null) result = caseDataType(collectionType);
                if (result == null) result = caseCollectionType_1(collectionType);
                if (result == null) result = caseClassifier(collectionType);
                if (result == null) result = casePredefinedType(collectionType);
                if (result == null) result = caseTypedASTNode(collectionType);
                if (result == null) result = caseNamespace(collectionType);
                if (result == null) result = caseRedefinableElement(collectionType);
                if (result == null) result = caseType(collectionType);
                if (result == null) result = caseTemplateableElement(collectionType);
                if (result == null) result = caseASTNode(collectionType);
                if (result == null) result = caseNamedElement(collectionType);
                if (result == null) result = casePackageableElement(collectionType);
                if (result == null) result = caseElement(collectionType);
                if (result == null) result = caseParameterableElement(collectionType);
                if (result == null) result = caseEModelElement(collectionType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.TUPLE_TYPE: {
                TupleType tupleType = (TupleType)theEObject;
                T result = caseTupleType(tupleType);
                if (result == null) result = caseDataType(tupleType);
                if (result == null) result = caseTupleType_1(tupleType);
                if (result == null) result = caseClassifier(tupleType);
                if (result == null) result = casePredefinedType(tupleType);
                if (result == null) result = caseNamespace(tupleType);
                if (result == null) result = caseRedefinableElement(tupleType);
                if (result == null) result = caseType(tupleType);
                if (result == null) result = caseTemplateableElement(tupleType);
                if (result == null) result = caseNamedElement(tupleType);
                if (result == null) result = casePackageableElement(tupleType);
                if (result == null) result = caseElement(tupleType);
                if (result == null) result = caseParameterableElement(tupleType);
                if (result == null) result = caseEModelElement(tupleType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.BAG_TYPE: {
                BagType bagType = (BagType)theEObject;
                T result = caseBagType(bagType);
                if (result == null) result = caseCollectionType(bagType);
                if (result == null) result = caseBagType_1(bagType);
                if (result == null) result = caseDataType(bagType);
                if (result == null) result = caseCollectionType_1(bagType);
                if (result == null) result = caseClassifier(bagType);
                if (result == null) result = casePredefinedType(bagType);
                if (result == null) result = caseTypedASTNode(bagType);
                if (result == null) result = caseNamespace(bagType);
                if (result == null) result = caseRedefinableElement(bagType);
                if (result == null) result = caseType(bagType);
                if (result == null) result = caseTemplateableElement(bagType);
                if (result == null) result = caseASTNode(bagType);
                if (result == null) result = caseNamedElement(bagType);
                if (result == null) result = casePackageableElement(bagType);
                if (result == null) result = caseElement(bagType);
                if (result == null) result = caseParameterableElement(bagType);
                if (result == null) result = caseEModelElement(bagType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.SET_TYPE: {
                SetType setType = (SetType)theEObject;
                T result = caseSetType(setType);
                if (result == null) result = caseCollectionType(setType);
                if (result == null) result = caseSetType_1(setType);
                if (result == null) result = caseDataType(setType);
                if (result == null) result = caseCollectionType_1(setType);
                if (result == null) result = caseClassifier(setType);
                if (result == null) result = casePredefinedType(setType);
                if (result == null) result = caseTypedASTNode(setType);
                if (result == null) result = caseNamespace(setType);
                if (result == null) result = caseRedefinableElement(setType);
                if (result == null) result = caseType(setType);
                if (result == null) result = caseTemplateableElement(setType);
                if (result == null) result = caseASTNode(setType);
                if (result == null) result = caseNamedElement(setType);
                if (result == null) result = casePackageableElement(setType);
                if (result == null) result = caseElement(setType);
                if (result == null) result = caseParameterableElement(setType);
                if (result == null) result = caseEModelElement(setType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.ORDERED_SET_TYPE: {
                OrderedSetType orderedSetType = (OrderedSetType)theEObject;
                T result = caseOrderedSetType(orderedSetType);
                if (result == null) result = caseCollectionType(orderedSetType);
                if (result == null) result = caseOrderedSetType_1(orderedSetType);
                if (result == null) result = caseDataType(orderedSetType);
                if (result == null) result = caseCollectionType_1(orderedSetType);
                if (result == null) result = caseClassifier(orderedSetType);
                if (result == null) result = casePredefinedType(orderedSetType);
                if (result == null) result = caseTypedASTNode(orderedSetType);
                if (result == null) result = caseNamespace(orderedSetType);
                if (result == null) result = caseRedefinableElement(orderedSetType);
                if (result == null) result = caseType(orderedSetType);
                if (result == null) result = caseTemplateableElement(orderedSetType);
                if (result == null) result = caseASTNode(orderedSetType);
                if (result == null) result = caseNamedElement(orderedSetType);
                if (result == null) result = casePackageableElement(orderedSetType);
                if (result == null) result = caseElement(orderedSetType);
                if (result == null) result = caseParameterableElement(orderedSetType);
                if (result == null) result = caseEModelElement(orderedSetType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.SEQUENCE_TYPE: {
                SequenceType sequenceType = (SequenceType)theEObject;
                T result = caseSequenceType(sequenceType);
                if (result == null) result = caseCollectionType(sequenceType);
                if (result == null) result = caseSequenceType_1(sequenceType);
                if (result == null) result = caseDataType(sequenceType);
                if (result == null) result = caseCollectionType_1(sequenceType);
                if (result == null) result = caseClassifier(sequenceType);
                if (result == null) result = casePredefinedType(sequenceType);
                if (result == null) result = caseTypedASTNode(sequenceType);
                if (result == null) result = caseNamespace(sequenceType);
                if (result == null) result = caseRedefinableElement(sequenceType);
                if (result == null) result = caseType(sequenceType);
                if (result == null) result = caseTemplateableElement(sequenceType);
                if (result == null) result = caseASTNode(sequenceType);
                if (result == null) result = caseNamedElement(sequenceType);
                if (result == null) result = casePackageableElement(sequenceType);
                if (result == null) result = caseElement(sequenceType);
                if (result == null) result = caseParameterableElement(sequenceType);
                if (result == null) result = caseEModelElement(sequenceType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UMLPackage.EXPRESSION_IN_OCL: {
                ExpressionInOCL expressionInOCL = (ExpressionInOCL)theEObject;
                T result = caseExpressionInOCL(expressionInOCL);
                if (result == null) result = caseOpaqueExpression(expressionInOCL);
                if (result == null) result = caseExpressionInOCL_1(expressionInOCL);
                if (result == null) result = caseValueSpecification(expressionInOCL);
                if (result == null) result = caseVisitable(expressionInOCL);
                if (result == null) result = casePackageableElement(expressionInOCL);
                if (result == null) result = caseTypedElement(expressionInOCL);
                if (result == null) result = caseNamedElement(expressionInOCL);
                if (result == null) result = caseParameterableElement(expressionInOCL);
                if (result == null) result = caseElement(expressionInOCL);
                if (result == null) result = caseEModelElement(expressionInOCL);
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
     * Returns the result of interpretting the object as an instance of '<em>Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElement(Element object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Namespace</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Namespace</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamespace(Namespace object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Redefinable Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Redefinable Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRedefinableElement(RedefinableElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Parameterable Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Parameterable Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterableElement(ParameterableElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Packageable Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Packageable Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePackageableElement(PackageableElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType(Type object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Templateable Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Templateable Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTemplateableElement(TemplateableElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Classifier</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Classifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseClassifier(Classifier object) {
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
     * Returns the result of interpretting the object as an instance of '<em>Data Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Data Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataType(DataType object) {
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
    public T casePrimitiveType_1(org.eclipse.uml2.uml.PrimitiveType object) {
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
    public <O> T casePrimitiveType_2(org.eclipse.ocl.types.PrimitiveType<O> object) {
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
     * Returns the result of interpretting the object as an instance of '<em>Typed Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypedElement(TypedElement object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Value Specification</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Value Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueSpecification(ValueSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Opaque Expression</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Opaque Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOpaqueExpression(OpaqueExpression object) {
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

} //UMLSwitch
