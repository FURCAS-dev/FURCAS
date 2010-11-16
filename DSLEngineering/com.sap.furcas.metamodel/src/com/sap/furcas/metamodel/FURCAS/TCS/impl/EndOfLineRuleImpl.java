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

import com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Of Line Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EndOfLineRuleImpl#getStart <em>Start</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EndOfLineRuleImpl#isDropStart <em>Drop Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndOfLineRuleImpl extends RuleImpl implements EndOfLineRule {
        /**
     * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStart()
     * @generated
     * @ordered
     */
        protected StringPattern start;

        /**
     * The default value of the '{@link #isDropStart() <em>Drop Start</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isDropStart()
     * @generated
     * @ordered
     */
        protected static final boolean DROP_START_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isDropStart() <em>Drop Start</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isDropStart()
     * @generated
     * @ordered
     */
        protected boolean dropStart = DROP_START_EDEFAULT;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected EndOfLineRuleImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.END_OF_LINE_RULE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public StringPattern getStart() {
        return start;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetStart(StringPattern newStart, NotificationChain msgs) {
        StringPattern oldStart = start;
        start = newStart;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.END_OF_LINE_RULE__START, oldStart, newStart);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setStart(StringPattern newStart) {
        if (newStart != start) {
            NotificationChain msgs = null;
            if (start != null)
                msgs = ((InternalEObject)start).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.END_OF_LINE_RULE__START, null, msgs);
            if (newStart != null)
                msgs = ((InternalEObject)newStart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.END_OF_LINE_RULE__START, null, msgs);
            msgs = basicSetStart(newStart, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.END_OF_LINE_RULE__START, newStart, newStart));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isDropStart() {
        return dropStart;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setDropStart(boolean newDropStart) {
        boolean oldDropStart = dropStart;
        dropStart = newDropStart;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.END_OF_LINE_RULE__DROP_START, oldDropStart, dropStart));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.END_OF_LINE_RULE__START:
                return basicSetStart(null, msgs);
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
            case TCSPackage.END_OF_LINE_RULE__START:
                return getStart();
            case TCSPackage.END_OF_LINE_RULE__DROP_START:
                return isDropStart();
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
            case TCSPackage.END_OF_LINE_RULE__START:
                setStart((StringPattern)newValue);
                return;
            case TCSPackage.END_OF_LINE_RULE__DROP_START:
                setDropStart((Boolean)newValue);
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
            case TCSPackage.END_OF_LINE_RULE__START:
                setStart((StringPattern)null);
                return;
            case TCSPackage.END_OF_LINE_RULE__DROP_START:
                setDropStart(DROP_START_EDEFAULT);
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
            case TCSPackage.END_OF_LINE_RULE__START:
                return start != null;
            case TCSPackage.END_OF_LINE_RULE__DROP_START:
                return dropStart != DROP_START_EDEFAULT;
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
        result.append(" (dropStart: ");
        result.append(dropStart);
        result.append(')');
        return result.toString();
    }

} //EndOfLineRuleImpl
