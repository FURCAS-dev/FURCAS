/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc. and others.
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
 * $Id: CollectionTypeImpl.java,v 1.6 2008/05/11 05:37:15 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import java.util.Map;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.operations.CollectionTypeOperations;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.impl.CollectionTypeImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.impl.CollectionTypeImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.impl.CollectionTypeImpl#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.impl.CollectionTypeImpl#getTypeEndPosition <em>Type End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.impl.CollectionTypeImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.impl.CollectionTypeImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeImpl<C, O> extends EObjectImpl implements CollectionType<C, O> {
	/**
     * The default value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
	protected static final int START_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
	protected int startPosition = START_POSITION_EDEFAULT;

	/**
     * The default value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
	protected static final int END_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
	protected int endPosition = END_POSITION_EDEFAULT;

	/**
     * The default value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeStartPosition()
     * @generated
     * @ordered
     */
	protected static final int TYPE_START_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeStartPosition()
     * @generated
     * @ordered
     */
	protected int typeStartPosition = TYPE_START_POSITION_EDEFAULT;

	/**
     * The default value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEndPosition()
     * @generated
     * @ordered
     */
	protected static final int TYPE_END_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeEndPosition()
     * @generated
     * @ordered
     */
	protected int typeEndPosition = TYPE_END_POSITION_EDEFAULT;

	/**
     * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElementType()
     * @generated
     * @ordered
     */
	protected C elementType;

	/**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected static final CollectionKind KIND_EDEFAULT = CollectionKind.SET_LITERAL;

	private String name;
	private EList<O> operations;
	private EList<O> iterators;
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CollectionTypeImpl() {
        super();
    }
	
	protected CollectionTypeImpl(C elementType) {
		this.elementType = elementType;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TypesPackage.Literals.COLLECTION_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public String getName() {
		if (name == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			StringBuffer myName = new StringBuffer();
			
			switch (getKind()) {
			case SET_LITERAL:
				myName.append(SetType.SINGLETON_NAME);
				break;
			case ORDERED_SET_LITERAL:
				myName.append(OrderedSetType.SINGLETON_NAME);
				break;
			case BAG_LITERAL:
				myName.append(BagType.SINGLETON_NAME);
				break;
			case SEQUENCE_LITERAL:
				myName.append(SequenceType.SINGLETON_NAME);
				break;
			default:
				myName.append(CollectionType.SINGLETON_NAME);
				break;
			}
			
            myName.append('(');
            
			C elementType = getElementType();
			String elementTypeName;
			if (elementType instanceof PredefinedType) {
				elementTypeName = ((PredefinedType<C>) elementType).getName();
			} else {
				elementTypeName = env.getUMLReflection().getName(elementType);
			}
			
			myName.append(elementTypeName);
			myName.append(')');
			
			name = myName.toString();
		}
		
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclOperations() {
		if (operations == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			List<O> myOperations;
			
			switch (getKind()) {
			case SET_LITERAL:
				myOperations = OCLStandardLibraryUtil.createSetOperations(env);
				break;
			case ORDERED_SET_LITERAL:
				myOperations = OCLStandardLibraryUtil.createOrderedSetOperations(env);
				break;
			case BAG_LITERAL:
				myOperations = OCLStandardLibraryUtil.createBagOperations(env);
				break;
			case SEQUENCE_LITERAL:
				myOperations = OCLStandardLibraryUtil.createSequenceOperations(env);
				break;
			default:
				myOperations = OCLStandardLibraryUtil.createCollectionOperations(env);
				break;
			}
			
			operations = new BasicEList<O>(myOperations);
		}
		
		return operations;
	}

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkCollectionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return CollectionTypeOperations.checkCollectionTypeName(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkNoInvalidValues(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return CollectionTypeOperations.checkNoInvalidValues(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getStartPosition() {
        return startPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setStartPosition(int newStartPosition) {
        int oldStartPosition = startPosition;
        startPosition = newStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__START_POSITION, oldStartPosition, startPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getEndPosition() {
        return endPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEndPosition(int newEndPosition) {
        int oldEndPosition = endPosition;
        endPosition = newEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__END_POSITION, oldEndPosition, endPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getTypeStartPosition() {
        return typeStartPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeStartPosition(int newTypeStartPosition) {
        int oldTypeStartPosition = typeStartPosition;
        typeStartPosition = newTypeStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION, oldTypeStartPosition, typeStartPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getTypeEndPosition() {
        return typeEndPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeEndPosition(int newTypeEndPosition) {
        int oldTypeEndPosition = typeEndPosition;
        typeEndPosition = newTypeEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION, oldTypeEndPosition, typeEndPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public C getElementType() {
        if (elementType != null && ((EObject)elementType).eIsProxy()) {
            InternalEObject oldElementType = (InternalEObject)elementType;
            elementType = (C)eResolveProxy(oldElementType);
            if (elementType != oldElementType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
            }
        }
        return elementType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public C basicGetElementType() {
        return elementType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setElementType(C newElementType) {
        C oldElementType = elementType;
        elementType = newElementType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollectionKind getKind() {
		return CollectionKind.COLLECTION_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclIterators() {
		if (iterators == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			List<O> myIterators;
			
			switch (getKind()) {
			case SET_LITERAL:
				myIterators = OCLStandardLibraryUtil.createSetIterators(env);
				break;
			case ORDERED_SET_LITERAL:
				myIterators = OCLStandardLibraryUtil.createOrderedSetIterators(env);
				break;
			case BAG_LITERAL:
				myIterators = OCLStandardLibraryUtil.createBagIterators(env);
				break;
			case SEQUENCE_LITERAL:
				myIterators = OCLStandardLibraryUtil.createSequenceIterators(env);
				break;
			default:
				myIterators = OCLStandardLibraryUtil.createCollectionIterators(env);
				break;
			}
			
			iterators = new BasicEList<O>(myIterators);
		}
		
		return iterators;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TypesPackage.COLLECTION_TYPE__START_POSITION:
                return new Integer(getStartPosition());
            case TypesPackage.COLLECTION_TYPE__END_POSITION:
                return new Integer(getEndPosition());
            case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                return new Integer(getTypeStartPosition());
            case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                return new Integer(getTypeEndPosition());
            case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                if (resolve) return getElementType();
                return basicGetElementType();
            case TypesPackage.COLLECTION_TYPE__KIND:
                return getKind();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TypesPackage.COLLECTION_TYPE__START_POSITION:
                setStartPosition(((Integer)newValue).intValue());
                return;
            case TypesPackage.COLLECTION_TYPE__END_POSITION:
                setEndPosition(((Integer)newValue).intValue());
                return;
            case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                setTypeStartPosition(((Integer)newValue).intValue());
                return;
            case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                setTypeEndPosition(((Integer)newValue).intValue());
                return;
            case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                setElementType((C)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case TypesPackage.COLLECTION_TYPE__START_POSITION:
                setStartPosition(START_POSITION_EDEFAULT);
                return;
            case TypesPackage.COLLECTION_TYPE__END_POSITION:
                setEndPosition(END_POSITION_EDEFAULT);
                return;
            case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
                return;
            case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
                return;
            case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                setElementType((C)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case TypesPackage.COLLECTION_TYPE__START_POSITION:
                return startPosition != START_POSITION_EDEFAULT;
            case TypesPackage.COLLECTION_TYPE__END_POSITION:
                return endPosition != END_POSITION_EDEFAULT;
            case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
            case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
            case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                return elementType != null;
            case TypesPackage.COLLECTION_TYPE__KIND:
                return getKind() != KIND_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == ASTNode.class) {
            switch (derivedFeatureID) {
                case TypesPackage.COLLECTION_TYPE__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
                case TypesPackage.COLLECTION_TYPE__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == TypedASTNode.class) {
            switch (derivedFeatureID) {
                case TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
                case TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == ASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.AST_NODE__START_POSITION: return TypesPackage.COLLECTION_TYPE__START_POSITION;
                case UtilitiesPackage.AST_NODE__END_POSITION: return TypesPackage.COLLECTION_TYPE__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == TypedASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION: return TypesPackage.COLLECTION_TYPE__TYPE_START_POSITION;
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION: return TypesPackage.COLLECTION_TYPE__TYPE_END_POSITION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (startPosition: "); //$NON-NLS-1$
        result.append(startPosition);
        result.append(", endPosition: "); //$NON-NLS-1$
        result.append(endPosition);
        result.append(", typeStartPosition: "); //$NON-NLS-1$
        result.append(typeStartPosition);
        result.append(", typeEndPosition: "); //$NON-NLS-1$
        result.append(typeEndPosition);
        result.append(')');
        return result.toString();
    }

} //CollectionTypeImpl
