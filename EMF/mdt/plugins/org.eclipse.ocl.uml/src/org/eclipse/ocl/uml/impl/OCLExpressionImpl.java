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
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: OCLExpressionImpl.java,v 1.11 2010/04/23 05:52:13 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.util.ToStringVisitor;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.impl.TypedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.OCLExpressionImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.OCLExpressionImpl#getEndPosition <em>End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public abstract class OCLExpressionImpl
		extends TypedElementImpl
		implements OCLExpression {

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLPackage.Literals.OCL_EXPRESSION;
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
				UMLPackage.OCL_EXPRESSION__START_POSITION, oldStartPosition,
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
				UMLPackage.OCL_EXPRESSION__END_POSITION, oldEndPosition,
				endPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLPackage.OCL_EXPRESSION__START_POSITION :
				return getStartPosition();
			case UMLPackage.OCL_EXPRESSION__END_POSITION :
				return getEndPosition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLPackage.OCL_EXPRESSION__START_POSITION :
				setStartPosition((Integer) newValue);
				return;
			case UMLPackage.OCL_EXPRESSION__END_POSITION :
				setEndPosition((Integer) newValue);
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
			case UMLPackage.OCL_EXPRESSION__START_POSITION :
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case UMLPackage.OCL_EXPRESSION__END_POSITION :
				setEndPosition(END_POSITION_EDEFAULT);
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
			case UMLPackage.OCL_EXPRESSION__START_POSITION :
				return startPosition != START_POSITION_EDEFAULT;
			case UMLPackage.OCL_EXPRESSION__END_POSITION :
				return endPosition != END_POSITION_EDEFAULT;
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
				case UMLPackage.OCL_EXPRESSION__START_POSITION :
					return UtilitiesPackage.AST_NODE__START_POSITION;
				case UMLPackage.OCL_EXPRESSION__END_POSITION :
					return UtilitiesPackage.AST_NODE__END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.OCLExpression.class) {
			switch (derivedFeatureID) {
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
					return UMLPackage.OCL_EXPRESSION__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION :
					return UMLPackage.OCL_EXPRESSION__END_POSITION;
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.expressions.OCLExpression.class) {
			switch (baseFeatureID) {
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

		return this
			.<String, Visitor<String, ?, ?, ?, ?, ?, ?, ?, ?, ?>> accept(ToStringVisitor
				.getInstance(this));
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Classifier getType() {
		// override in order to unambiguously narrow the return type
		return (Classifier) super.getType();
	}

	/**
	 * @generated NOT
	 */
	public void setType(Classifier type) {
		setType((Type) type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		// subclasses must override
		throw new UnsupportedOperationException();
	}

} //OCLExpressionImpl
