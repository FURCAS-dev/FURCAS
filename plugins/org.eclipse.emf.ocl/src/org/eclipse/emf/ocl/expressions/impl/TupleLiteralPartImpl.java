/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: TupleLiteralPartImpl.java,v 1.2 2007/04/09 17:35:25 cdamus Exp $
 */
package org.eclipse.emf.ocl.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.uml.impl.TypedElementImpl;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.TupleLiteralPartImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.TupleLiteralPartImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.TupleLiteralPartImpl#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.TupleLiteralPartImpl#getTypeEndPosition <em>Type End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.TupleLiteralPartImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.TupleLiteralPartImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleLiteralPartImpl extends TypedElementImpl implements TupleLiteralPart {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = ""; //$NON-NLS-1$

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
     * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected OCLExpression value;

	/**
     * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
	protected EStructuralFeature attribute;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TupleLiteralPartImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.TUPLE_LITERAL_PART;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION, oldStartPosition, startPosition));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION, oldEndPosition, endPosition));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION, oldTypeStartPosition, typeStartPosition));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION, oldTypeEndPosition, typeEndPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression getValue() {
        return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetValue(OCLExpression newValue, NotificationChain msgs) {
        OCLExpression oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TUPLE_LITERAL_PART__VALUE, oldValue, newValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValue(OCLExpression newValue) {
        if (newValue != value) {
            NotificationChain msgs = null;
            if (value != null)
                msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TUPLE_LITERAL_PART__VALUE, null, msgs);
            if (newValue != null)
                msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TUPLE_LITERAL_PART__VALUE, null, msgs);
            msgs = basicSetValue(newValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TUPLE_LITERAL_PART__VALUE, newValue, newValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EStructuralFeature getAttribute() {
        if (attribute != null && attribute.eIsProxy()) {
            InternalEObject oldAttribute = (InternalEObject)attribute;
            attribute = (EStructuralFeature)eResolveProxy(oldAttribute);
            if (attribute != oldAttribute) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE, oldAttribute, attribute));
            }
        }
        return attribute;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EStructuralFeature basicGetAttribute() {
        return attribute;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAttribute(EStructuralFeature newAttribute) {
        EStructuralFeature oldAttribute = attribute;
        attribute = newAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE, oldAttribute, attribute));
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object accept(Visitor v) {
		return v.visitTupleLiteralPart(this);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_PART__VALUE:
                return basicSetValue(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION:
                return new Integer(getStartPosition());
            case ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION:
                return new Integer(getEndPosition());
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION:
                return new Integer(getTypeStartPosition());
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION:
                return new Integer(getTypeEndPosition());
            case ExpressionsPackage.TUPLE_LITERAL_PART__VALUE:
                return getValue();
            case ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE:
                if (resolve) return getAttribute();
                return basicGetAttribute();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION:
                setStartPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION:
                setEndPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION:
                setTypeStartPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION:
                setTypeEndPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__VALUE:
                setValue((OCLExpression)newValue);
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE:
                setAttribute((EStructuralFeature)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION:
                setStartPosition(START_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION:
                setEndPosition(END_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION:
                setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION:
                setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__VALUE:
                setValue((OCLExpression)null);
                return;
            case ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE:
                setAttribute((EStructuralFeature)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION:
                return startPosition != START_POSITION_EDEFAULT;
            case ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION:
                return endPosition != END_POSITION_EDEFAULT;
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION:
                return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
            case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION:
                return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
            case ExpressionsPackage.TUPLE_LITERAL_PART__VALUE:
                return value != null;
            case ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE:
                return attribute != null;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
        if (baseClass == Visitable.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == ASTNode.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
                case ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == TypedASTNode.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
                case ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
        if (baseClass == Visitable.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == ASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.TUPLE_LITERAL_PART__START_POSITION;
                case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.TUPLE_LITERAL_PART__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == TypedASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION: return ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_START_POSITION;
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION: return ExpressionsPackage.TUPLE_LITERAL_PART__TYPE_END_POSITION;
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

} //TupleLiteralPartImpl
