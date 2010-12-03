/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionTemplateImpl#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionTemplateImpl#getFunctionSequence <em>Function Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionTemplateImpl extends TemplateImpl implements FunctionTemplate {
        /**
	 * The default value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
        protected static final String FUNCTION_NAME_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
        protected String functionName = FUNCTION_NAME_EDEFAULT;

        /**
	 * The cached value of the '{@link #getFunctionSequence() <em>Function Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getFunctionSequence()
	 * @generated
	 * @ordered
	 */
        protected Sequence functionSequence;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected FunctionTemplateImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.FUNCTION_TEMPLATE;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getFunctionName() {
		return functionName;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setFunctionName(String newFunctionName) {
		String oldFunctionName = functionName;
		functionName = newFunctionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.FUNCTION_TEMPLATE__FUNCTION_NAME, oldFunctionName, functionName));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Sequence getFunctionSequence() {
		return functionSequence;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetFunctionSequence(Sequence newFunctionSequence, NotificationChain msgs) {
		Sequence oldFunctionSequence = functionSequence;
		functionSequence = newFunctionSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE, oldFunctionSequence, newFunctionSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setFunctionSequence(Sequence newFunctionSequence) {
		if (newFunctionSequence != functionSequence) {
			NotificationChain msgs = null;
			if (functionSequence != null)
				msgs = ((InternalEObject)functionSequence).eInverseRemove(this, TCSPackage.SEQUENCE__FUNCTION_CONTAINER, Sequence.class, msgs);
			if (newFunctionSequence != null)
				msgs = ((InternalEObject)newFunctionSequence).eInverseAdd(this, TCSPackage.SEQUENCE__FUNCTION_CONTAINER, Sequence.class, msgs);
			msgs = basicSetFunctionSequence(newFunctionSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE, newFunctionSequence, newFunctionSequence));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE:
				if (functionSequence != null)
					msgs = ((InternalEObject)functionSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE, null, msgs);
				return basicSetFunctionSequence((Sequence)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE:
				return basicSetFunctionSequence(null, msgs);
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
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_NAME:
				return getFunctionName();
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE:
				return getFunctionSequence();
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
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_NAME:
				setFunctionName((String)newValue);
				return;
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE:
				setFunctionSequence((Sequence)newValue);
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
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_NAME:
				setFunctionName(FUNCTION_NAME_EDEFAULT);
				return;
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE:
				setFunctionSequence((Sequence)null);
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
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_NAME:
				return FUNCTION_NAME_EDEFAULT == null ? functionName != null : !FUNCTION_NAME_EDEFAULT.equals(functionName);
			case TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE:
				return functionSequence != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (functionName: ");
		result.append(functionName);
		result.append(')');
		return result.toString();
	}

} //FunctionTemplateImpl
