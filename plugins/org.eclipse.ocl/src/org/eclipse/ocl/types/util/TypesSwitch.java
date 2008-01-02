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
 * $Id: TypesSwitch.java,v 1.5 2008/01/02 20:12:59 cdamus Exp $
 */
package org.eclipse.ocl.types.util;

//import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.ocl.types.*;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.ElementType;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;


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
 * @see org.eclipse.ocl.types.TypesPackage
 * @generated
 */
public class TypesSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static TypesPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypesSwitch() {
        if (modelPackage == null) {
            modelPackage = TypesPackage.eINSTANCE;
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
	 * @generated NOT
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
            // account for multiple inheritance
            T result = doSwitchSuperTypes(theEClass, theEObject);
            
			if (result == null) {
                result = defaultCase(theEObject);
            }
            
            return result;
		}
	}
    
    protected T doSwitchSuperTypes(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        
        // account for multiple inheritance
        for (EClass esuper : theEClass.getESuperTypes()) {
            T result = doSwitchSuperTypes(esuper, theEObject);
            
            if (result != null) {
                return result;
            }
        }
        
        return null;
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
            case TypesPackage.ANY_TYPE: {
                AnyType<?> anyType = (AnyType<?>)theEObject;
                T result = caseAnyType(anyType);
                if (result == null) result = casePredefinedType(anyType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.BAG_TYPE: {
                BagType<?, ?> bagType = (BagType<?, ?>)theEObject;
                T result = caseBagType(bagType);
                if (result == null) result = caseCollectionType(bagType);
                if (result == null) result = casePredefinedType(bagType);
                if (result == null) result = caseTypedASTNode(bagType);
                if (result == null) result = caseASTNode(bagType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.COLLECTION_TYPE: {
                CollectionType<?, ?> collectionType = (CollectionType<?, ?>)theEObject;
                T result = caseCollectionType(collectionType);
                if (result == null) result = casePredefinedType(collectionType);
                if (result == null) result = caseTypedASTNode(collectionType);
                if (result == null) result = caseASTNode(collectionType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.ELEMENT_TYPE: {
                ElementType elementType = (ElementType)theEObject;
                T result = caseElementType(elementType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.INVALID_TYPE: {
                InvalidType<?> invalidType = (InvalidType<?>)theEObject;
                T result = caseInvalidType(invalidType);
                if (result == null) result = casePredefinedType(invalidType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.MESSAGE_TYPE: {
                MessageType<?, ?, ?> messageType = (MessageType<?, ?, ?>)theEObject;
                T result = caseMessageType(messageType);
                if (result == null) result = casePredefinedType(messageType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.ORDERED_SET_TYPE: {
                OrderedSetType<?, ?> orderedSetType = (OrderedSetType<?, ?>)theEObject;
                T result = caseOrderedSetType(orderedSetType);
                if (result == null) result = caseCollectionType(orderedSetType);
                if (result == null) result = casePredefinedType(orderedSetType);
                if (result == null) result = caseTypedASTNode(orderedSetType);
                if (result == null) result = caseASTNode(orderedSetType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.PRIMITIVE_TYPE: {
                PrimitiveType<?> primitiveType = (PrimitiveType<?>)theEObject;
                T result = casePrimitiveType(primitiveType);
                if (result == null) result = casePredefinedType(primitiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.SEQUENCE_TYPE: {
                SequenceType<?, ?> sequenceType = (SequenceType<?, ?>)theEObject;
                T result = caseSequenceType(sequenceType);
                if (result == null) result = caseCollectionType(sequenceType);
                if (result == null) result = casePredefinedType(sequenceType);
                if (result == null) result = caseTypedASTNode(sequenceType);
                if (result == null) result = caseASTNode(sequenceType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.SET_TYPE: {
                SetType<?, ?> setType = (SetType<?, ?>)theEObject;
                T result = caseSetType(setType);
                if (result == null) result = caseCollectionType(setType);
                if (result == null) result = casePredefinedType(setType);
                if (result == null) result = caseTypedASTNode(setType);
                if (result == null) result = caseASTNode(setType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.TUPLE_TYPE: {
                TupleType<?, ?> tupleType = (TupleType<?, ?>)theEObject;
                T result = caseTupleType(tupleType);
                if (result == null) result = casePredefinedType(tupleType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.TYPE_TYPE: {
                TypeType<?, ?> typeType = (TypeType<?, ?>)theEObject;
                T result = caseTypeType(typeType);
                if (result == null) result = casePredefinedType(typeType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TypesPackage.VOID_TYPE: {
                VoidType<?> voidType = (VoidType<?>)theEObject;
                T result = caseVoidType(voidType);
                if (result == null) result = casePredefinedType(voidType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <O> T caseAnyType(AnyType<O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O> T caseBagType(BagType<C, O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O> T caseCollectionType(CollectionType<C, O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Element Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseElementType(ElementType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invalid Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <O> T caseInvalidType(InvalidType<O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O, P> T caseMessageType(MessageType<C, O, P> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O> T caseOrderedSetType(OrderedSetType<C, O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <O> T casePrimitiveType(PrimitiveType<O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O> T caseSequenceType(SequenceType<C, O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O> T caseSetType(SetType<C, O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <O, P> T caseTupleType(TupleType<O, P> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Type Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, O> T caseTypeType(TypeType<C, O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <O> T caseVoidType(VoidType<O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <O> T casePredefinedType(PredefinedType<O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseASTNode(ASTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypedASTNode(TypedASTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	public T defaultCase(EObject object) {
        return null;
    }

} //TypesSwitch
