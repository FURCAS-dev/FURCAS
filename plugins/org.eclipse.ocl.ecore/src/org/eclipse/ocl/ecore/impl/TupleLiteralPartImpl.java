/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 241426, 207365
 * </copyright>
 *
 * $Id: TupleLiteralPartImpl.java,v 1.11 2010/04/23 05:52:39 ewillink Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.TupleLiteralPart;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.TupleLiteralPartOperations;
import org.eclipse.ocl.ecore.util.ToStringVisitor;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl#getTypeEndPosition <em>Type End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.TupleLiteralPartImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleLiteralPartImpl
		extends ETypedElementImpl
		implements TupleLiteralPart {

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
	protected OCLExpression<EClassifier> value;

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
	@Override
	protected EClass eStaticClass() {
		return EcorePackage.Literals.TUPLE_LITERAL_PART;
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
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.TUPLE_LITERAL_PART__START_POSITION,
				oldStartPosition, startPosition));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.TUPLE_LITERAL_PART__END_POSITION, oldEndPosition,
				endPosition));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.TUPLE_LITERAL_PART__TYPE_START_POSITION,
				oldTypeStartPosition, typeStartPosition));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.TUPLE_LITERAL_PART__TYPE_END_POSITION,
				oldTypeEndPosition, typeEndPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<EClassifier> getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(OCLExpression<EClassifier> newValue,
			NotificationChain msgs) {
		OCLExpression<EClassifier> oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, EcorePackage.TUPLE_LITERAL_PART__VALUE,
				oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(OCLExpression<EClassifier> newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.TUPLE_LITERAL_PART__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.TUPLE_LITERAL_PART__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.TUPLE_LITERAL_PART__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getAttribute() {
		if (attribute != null && ((EObject) attribute).eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject) attribute;
			attribute = (EStructuralFeature) eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE,
						oldAttribute, attribute));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE, oldAttribute,
				attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkValueType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return TupleLiteralPartOperations.checkValueType(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getType() {
		return getEType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(EClassifier type) {
		setEType(type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcorePackage.TUPLE_LITERAL_PART__VALUE :
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcorePackage.TUPLE_LITERAL_PART__START_POSITION :
				return getStartPosition();
			case EcorePackage.TUPLE_LITERAL_PART__END_POSITION :
				return getEndPosition();
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_START_POSITION :
				return getTypeStartPosition();
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_END_POSITION :
				return getTypeEndPosition();
			case EcorePackage.TUPLE_LITERAL_PART__VALUE :
				return getValue();
			case EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE :
				if (resolve)
					return getAttribute();
				return basicGetAttribute();
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
			case EcorePackage.TUPLE_LITERAL_PART__START_POSITION :
				setStartPosition((Integer) newValue);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__END_POSITION :
				setEndPosition((Integer) newValue);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_START_POSITION :
				setTypeStartPosition((Integer) newValue);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_END_POSITION :
				setTypeEndPosition((Integer) newValue);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__VALUE :
				setValue((OCLExpression<EClassifier>) newValue);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE :
				setAttribute((EStructuralFeature) newValue);
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
			case EcorePackage.TUPLE_LITERAL_PART__START_POSITION :
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__END_POSITION :
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_START_POSITION :
				setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_END_POSITION :
				setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__VALUE :
				setValue((OCLExpression<EClassifier>) null);
				return;
			case EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE :
				setAttribute((EStructuralFeature) null);
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
			case EcorePackage.TUPLE_LITERAL_PART__START_POSITION :
				return startPosition != START_POSITION_EDEFAULT;
			case EcorePackage.TUPLE_LITERAL_PART__END_POSITION :
				return endPosition != END_POSITION_EDEFAULT;
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_START_POSITION :
				return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
			case EcorePackage.TUPLE_LITERAL_PART__TYPE_END_POSITION :
				return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
			case EcorePackage.TUPLE_LITERAL_PART__VALUE :
				return value != null;
			case EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE :
				return attribute != null;
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
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == Visitable.class) {
			switch (derivedFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == ASTNode.class) {
			switch (derivedFeatureID) {
				case EcorePackage.TUPLE_LITERAL_PART__START_POSITION :
					return UtilitiesPackage.AST_NODE__START_POSITION;
				case EcorePackage.TUPLE_LITERAL_PART__END_POSITION :
					return UtilitiesPackage.AST_NODE__END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == TypedASTNode.class) {
			switch (derivedFeatureID) {
				case EcorePackage.TUPLE_LITERAL_PART__TYPE_START_POSITION :
					return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
				case EcorePackage.TUPLE_LITERAL_PART__TYPE_END_POSITION :
					return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.TupleLiteralPart.class) {
			switch (derivedFeatureID) {
				case EcorePackage.TUPLE_LITERAL_PART__VALUE :
					return ExpressionsPackage.TUPLE_LITERAL_PART__VALUE;
				case EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE :
					return ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE;
				default :
					return -1;
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
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == Visitable.class) {
			switch (baseFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == ASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.AST_NODE__START_POSITION :
					return EcorePackage.TUPLE_LITERAL_PART__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION :
					return EcorePackage.TUPLE_LITERAL_PART__END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == TypedASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION :
					return EcorePackage.TUPLE_LITERAL_PART__TYPE_START_POSITION;
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION :
					return EcorePackage.TUPLE_LITERAL_PART__TYPE_END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.TupleLiteralPart.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.TUPLE_LITERAL_PART__VALUE :
					return EcorePackage.TUPLE_LITERAL_PART__VALUE;
				case ExpressionsPackage.TUPLE_LITERAL_PART__ATTRIBUTE :
					return EcorePackage.TUPLE_LITERAL_PART__ATTRIBUTE;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		return accept(ToStringVisitor.getInstance(this));
	}

	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return ((Visitor<T, EClassifier, ?, EStructuralFeature, ?, ?, ?, ?, ?, ?>) v)
			.visitTupleLiteralPart(this);
	}

} //TupleLiteralPartImpl
