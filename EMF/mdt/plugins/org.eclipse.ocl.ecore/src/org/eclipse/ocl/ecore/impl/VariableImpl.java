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
 *
 * </copyright>
 *
 * $Id: VariableImpl.java,v 1.12 2010/12/15 17:32:43 ewillink Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.utilities.ToStringVisitor;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.VariableOperations;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.VariableImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.VariableImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.VariableImpl#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.VariableImpl#getTypeEndPosition <em>Type End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.VariableImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.VariableImpl#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl
		extends ETypedElementImpl
		implements Variable {

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
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<EClassifier> initExpression;

	/**
	 * The cached value of the '{@link #getRepresentedParameter() <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedParameter()
	 * @generated
	 * @ordered
	 */
	protected EParameter representedParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorePackage.Literals.VARIABLE;
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
				EcorePackage.VARIABLE__START_POSITION, oldStartPosition,
				startPosition));
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
				EcorePackage.VARIABLE__END_POSITION, oldEndPosition,
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
				EcorePackage.VARIABLE__TYPE_START_POSITION,
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
				EcorePackage.VARIABLE__TYPE_END_POSITION, oldTypeEndPosition,
				typeEndPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<EClassifier> getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(
			OCLExpression<EClassifier> newInitExpression, NotificationChain msgs) {
		OCLExpression<EClassifier> oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, EcorePackage.VARIABLE__INIT_EXPRESSION,
				oldInitExpression, newInitExpression);
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
	public void setInitExpression(OCLExpression<EClassifier> newInitExpression) {
		if (newInitExpression != initExpression) {
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject) initExpression).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.VARIABLE__INIT_EXPRESSION, null, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject) newInitExpression).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.VARIABLE__INIT_EXPRESSION, null, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.VARIABLE__INIT_EXPRESSION, newInitExpression,
				newInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EParameter getRepresentedParameter() {
		if (representedParameter != null
			&& ((EObject) representedParameter).eIsProxy()) {
			InternalEObject oldRepresentedParameter = (InternalEObject) representedParameter;
			representedParameter = (EParameter) eResolveProxy(oldRepresentedParameter);
			if (representedParameter != oldRepresentedParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EcorePackage.VARIABLE__REPRESENTED_PARAMETER,
						oldRepresentedParameter, representedParameter));
			}
		}
		return representedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EParameter basicGetRepresentedParameter() {
		return representedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedParameter(EParameter newRepresentedParameter) {
		EParameter oldRepresentedParameter = representedParameter;
		representedParameter = newRepresentedParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.VARIABLE__REPRESENTED_PARAMETER,
				oldRepresentedParameter, representedParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkInitType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return VariableOperations.checkInitType(this, diagnostics, context);
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
			case EcorePackage.VARIABLE__INIT_EXPRESSION :
				return basicSetInitExpression(null, msgs);
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
			case EcorePackage.VARIABLE__START_POSITION :
				return getStartPosition();
			case EcorePackage.VARIABLE__END_POSITION :
				return getEndPosition();
			case EcorePackage.VARIABLE__TYPE_START_POSITION :
				return getTypeStartPosition();
			case EcorePackage.VARIABLE__TYPE_END_POSITION :
				return getTypeEndPosition();
			case EcorePackage.VARIABLE__INIT_EXPRESSION :
				return getInitExpression();
			case EcorePackage.VARIABLE__REPRESENTED_PARAMETER :
				if (resolve)
					return getRepresentedParameter();
				return basicGetRepresentedParameter();
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
			case EcorePackage.VARIABLE__START_POSITION :
				setStartPosition((Integer) newValue);
				return;
			case EcorePackage.VARIABLE__END_POSITION :
				setEndPosition((Integer) newValue);
				return;
			case EcorePackage.VARIABLE__TYPE_START_POSITION :
				setTypeStartPosition((Integer) newValue);
				return;
			case EcorePackage.VARIABLE__TYPE_END_POSITION :
				setTypeEndPosition((Integer) newValue);
				return;
			case EcorePackage.VARIABLE__INIT_EXPRESSION :
				setInitExpression((OCLExpression<EClassifier>) newValue);
				return;
			case EcorePackage.VARIABLE__REPRESENTED_PARAMETER :
				setRepresentedParameter((EParameter) newValue);
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
			case EcorePackage.VARIABLE__START_POSITION :
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case EcorePackage.VARIABLE__END_POSITION :
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case EcorePackage.VARIABLE__TYPE_START_POSITION :
				setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
				return;
			case EcorePackage.VARIABLE__TYPE_END_POSITION :
				setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
				return;
			case EcorePackage.VARIABLE__INIT_EXPRESSION :
				setInitExpression((OCLExpression<EClassifier>) null);
				return;
			case EcorePackage.VARIABLE__REPRESENTED_PARAMETER :
				setRepresentedParameter((EParameter) null);
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
			case EcorePackage.VARIABLE__START_POSITION :
				return startPosition != START_POSITION_EDEFAULT;
			case EcorePackage.VARIABLE__END_POSITION :
				return endPosition != END_POSITION_EDEFAULT;
			case EcorePackage.VARIABLE__TYPE_START_POSITION :
				return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
			case EcorePackage.VARIABLE__TYPE_END_POSITION :
				return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
			case EcorePackage.VARIABLE__INIT_EXPRESSION :
				return initExpression != null;
			case EcorePackage.VARIABLE__REPRESENTED_PARAMETER :
				return representedParameter != null;
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
				case EcorePackage.VARIABLE__START_POSITION :
					return UtilitiesPackage.AST_NODE__START_POSITION;
				case EcorePackage.VARIABLE__END_POSITION :
					return UtilitiesPackage.AST_NODE__END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == TypedASTNode.class) {
			switch (derivedFeatureID) {
				case EcorePackage.VARIABLE__TYPE_START_POSITION :
					return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
				case EcorePackage.VARIABLE__TYPE_END_POSITION :
					return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.Variable.class) {
			switch (derivedFeatureID) {
				case EcorePackage.VARIABLE__INIT_EXPRESSION :
					return ExpressionsPackage.VARIABLE__INIT_EXPRESSION;
				case EcorePackage.VARIABLE__REPRESENTED_PARAMETER :
					return ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER;
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
					return EcorePackage.VARIABLE__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION :
					return EcorePackage.VARIABLE__END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == TypedASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION :
					return EcorePackage.VARIABLE__TYPE_START_POSITION;
				case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION :
					return EcorePackage.VARIABLE__TYPE_END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.Variable.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.VARIABLE__INIT_EXPRESSION :
					return EcorePackage.VARIABLE__INIT_EXPRESSION;
				case ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER :
					return EcorePackage.VARIABLE__REPRESENTED_PARAMETER;
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
		return ((Visitor<T, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?>) v)
			.visitVariable(this);
	}

} //VariableImpl
