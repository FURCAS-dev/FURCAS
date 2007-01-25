/**
 * <copyright>
 * </copyright>
 *
 * $Id: OCLExpressionImpl.java,v 1.1 2007/01/25 18:24:38 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.util.ToStringVisitor;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.OCLExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.OCLExpressionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.OCLExpressionImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.OCLExpressionImpl#getEndPosition <em>End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OCLExpressionImpl<C> extends EObjectImpl implements OCLExpression<C> {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected C type = null;

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
		return ExpressionsPackage.Literals.OCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public C getType() {
		if (type != null && ((EObject)type).eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (C)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(C newType) {
		C oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__START_POSITION, oldStartPosition, startPosition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__END_POSITION, oldEndPosition, endPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				return getName();
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
				return new Integer(getEndPosition());
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
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((C)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
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
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((C)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
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
			case ExpressionsPackage.OCL_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				return type != null;
			case ExpressionsPackage.OCL_EXPRESSION__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.OCL_EXPRESSION__END_POSITION:
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
		if (baseClass == Visitable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ASTNode.class) {
			switch (derivedFeatureID) {
				case ExpressionsPackage.OCL_EXPRESSION__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
				case ExpressionsPackage.OCL_EXPRESSION__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
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
		if (baseClass == Visitable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.OCL_EXPRESSION__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.OCL_EXPRESSION__END_POSITION;
				default: return -1;
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

} //OCLExpressionImpl
