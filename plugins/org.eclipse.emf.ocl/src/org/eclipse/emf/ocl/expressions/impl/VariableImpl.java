/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: VariableImpl.java,v 1.5 2007/04/09 17:35:25 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.uml.impl.TypedElementImpl;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Variable</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.VariableImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.VariableImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.VariableImpl#getTypeStartPosition <em>Type Start Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.VariableImpl#getTypeEndPosition <em>Type End Position</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.VariableImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.VariableImpl#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl
	extends TypedElementImpl
	implements Variable {

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
	 * The cached value of the '
	 * {@link #getInitExpression() <em>Init Expression</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression initExpression;

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected VariableImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.VARIABLE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE__START_POSITION, oldStartPosition, startPosition));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE__END_POSITION, oldEndPosition, endPosition));
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression getInitExpression() {
        return initExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetInitExpression(OCLExpression newInitExpression, NotificationChain msgs) {
        OCLExpression oldInitExpression = initExpression;
        initExpression = newInitExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE__INIT_EXPRESSION, oldInitExpression, newInitExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInitExpression(OCLExpression newInitExpression) {
        if (newInitExpression != initExpression) {
            NotificationChain msgs = null;
            if (initExpression != null)
                msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.VARIABLE__INIT_EXPRESSION, null, msgs);
            if (newInitExpression != null)
                msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.VARIABLE__INIT_EXPRESSION, null, msgs);
            msgs = basicSetInitExpression(newInitExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE__INIT_EXPRESSION, newInitExpression, newInitExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EParameter getRepresentedParameter() {
        if (representedParameter != null && representedParameter.eIsProxy()) {
            InternalEObject oldRepresentedParameter = (InternalEObject)representedParameter;
            representedParameter = (EParameter)eResolveProxy(oldRepresentedParameter);
            if (representedParameter != oldRepresentedParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER, oldRepresentedParameter, representedParameter));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER, oldRepresentedParameter, representedParameter));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE__TYPE_START_POSITION, oldTypeStartPosition, typeStartPosition));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE__TYPE_END_POSITION, oldTypeEndPosition, typeEndPosition));
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
                case ExpressionsPackage.VARIABLE__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
                case ExpressionsPackage.VARIABLE__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == TypedASTNode.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.VARIABLE__TYPE_START_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
                case ExpressionsPackage.VARIABLE__TYPE_END_POSITION: return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
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
                case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.VARIABLE__START_POSITION;
                case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.VARIABLE__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == TypedASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION: return ExpressionsPackage.VARIABLE__TYPE_START_POSITION;
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION: return ExpressionsPackage.VARIABLE__TYPE_END_POSITION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
	 * @generated NOT
	 */
	public String toString() {
		return ToStringVisitorImpl.toString(this);
	}

	public Object accept(Visitor v) {
		return v.visitVariable(this);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.VARIABLE__INIT_EXPRESSION:
                return basicSetInitExpression(null, msgs);
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
            case ExpressionsPackage.VARIABLE__START_POSITION:
                return new Integer(getStartPosition());
            case ExpressionsPackage.VARIABLE__END_POSITION:
                return new Integer(getEndPosition());
            case ExpressionsPackage.VARIABLE__TYPE_START_POSITION:
                return new Integer(getTypeStartPosition());
            case ExpressionsPackage.VARIABLE__TYPE_END_POSITION:
                return new Integer(getTypeEndPosition());
            case ExpressionsPackage.VARIABLE__INIT_EXPRESSION:
                return getInitExpression();
            case ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER:
                if (resolve) return getRepresentedParameter();
                return basicGetRepresentedParameter();
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
            case ExpressionsPackage.VARIABLE__START_POSITION:
                setStartPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.VARIABLE__END_POSITION:
                setEndPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.VARIABLE__TYPE_START_POSITION:
                setTypeStartPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.VARIABLE__TYPE_END_POSITION:
                setTypeEndPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.VARIABLE__INIT_EXPRESSION:
                setInitExpression((OCLExpression)newValue);
                return;
            case ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER:
                setRepresentedParameter((EParameter)newValue);
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
            case ExpressionsPackage.VARIABLE__START_POSITION:
                setStartPosition(START_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.VARIABLE__END_POSITION:
                setEndPosition(END_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.VARIABLE__TYPE_START_POSITION:
                setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.VARIABLE__TYPE_END_POSITION:
                setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.VARIABLE__INIT_EXPRESSION:
                setInitExpression((OCLExpression)null);
                return;
            case ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER:
                setRepresentedParameter((EParameter)null);
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
            case ExpressionsPackage.VARIABLE__START_POSITION:
                return startPosition != START_POSITION_EDEFAULT;
            case ExpressionsPackage.VARIABLE__END_POSITION:
                return endPosition != END_POSITION_EDEFAULT;
            case ExpressionsPackage.VARIABLE__TYPE_START_POSITION:
                return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
            case ExpressionsPackage.VARIABLE__TYPE_END_POSITION:
                return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
            case ExpressionsPackage.VARIABLE__INIT_EXPRESSION:
                return initExpression != null;
            case ExpressionsPackage.VARIABLE__REPRESENTED_PARAMETER:
                return representedParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //VariableDeclarationImpl
