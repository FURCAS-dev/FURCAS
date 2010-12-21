/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl#getStoreOpTo <em>Store Op To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl#getStoreRightTo <em>Store Right To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl#getStoreOperatorTo <em>Store Operator To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl#getStoreLeftSideTo <em>Store Left Side To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorTemplateImpl#getStoreRightSideTo <em>Store Right Side To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorTemplateImpl extends ContextTemplateImpl implements OperatorTemplate {
        /**
     * The cached value of the '{@link #getOperators() <em>Operators</em>}' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getOperators()
     * @generated
     * @ordered
     */
        protected EList<Operator> operators;

        /**
     * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
        protected static final String SOURCE_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
        protected String source = SOURCE_EDEFAULT;

        /**
     * The default value of the '{@link #getStoreOpTo() <em>Store Op To</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStoreOpTo()
     * @generated
     * @ordered
     */
        protected static final String STORE_OP_TO_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getStoreOpTo() <em>Store Op To</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStoreOpTo()
     * @generated
     * @ordered
     */
        protected String storeOpTo = STORE_OP_TO_EDEFAULT;

        /**
     * The default value of the '{@link #getStoreRightTo() <em>Store Right To</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStoreRightTo()
     * @generated
     * @ordered
     */
        protected static final String STORE_RIGHT_TO_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getStoreRightTo() <em>Store Right To</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStoreRightTo()
     * @generated
     * @ordered
     */
        protected String storeRightTo = STORE_RIGHT_TO_EDEFAULT;

        /**
     * The cached value of the '{@link #getStoreOperatorTo() <em>Store Operator To</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStoreOperatorTo()
     * @generated
     * @ordered
     */
        protected PropertyReference storeOperatorTo;

        /**
     * The cached value of the '{@link #getStoreLeftSideTo() <em>Store Left Side To</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStoreLeftSideTo()
     * @generated
     * @ordered
     */
        protected PropertyReference storeLeftSideTo;

        /**
     * The cached value of the '{@link #getStoreRightSideTo() <em>Store Right Side To</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getStoreRightSideTo()
     * @generated
     * @ordered
     */
        protected PropertyReference storeRightSideTo;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected OperatorTemplateImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.OPERATOR_TEMPLATE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<Operator> getOperators() {
        if (operators == null) {
            operators = new EObjectWithInverseResolvingEList.ManyInverse<Operator>(Operator.class, this, TCSPackage.OPERATOR_TEMPLATE__OPERATORS, TCSPackage.OPERATOR__TEMPLATES);
        }
        return operators;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getSource() {
        return source;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setSource(String newSource) {
        String oldSource = source;
        source = newSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__SOURCE, oldSource, source));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getStoreOpTo() {
        return storeOpTo;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setStoreOpTo(String newStoreOpTo) {
        String oldStoreOpTo = storeOpTo;
        storeOpTo = newStoreOpTo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO, oldStoreOpTo, storeOpTo));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getStoreRightTo() {
        return storeRightTo;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setStoreRightTo(String newStoreRightTo) {
        String oldStoreRightTo = storeRightTo;
        storeRightTo = newStoreRightTo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO, oldStoreRightTo, storeRightTo));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public PropertyReference getStoreOperatorTo() {
        return storeOperatorTo;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStoreOperatorTo(PropertyReference newStoreOperatorTo, NotificationChain msgs) {
        PropertyReference oldStoreOperatorTo = storeOperatorTo;
        storeOperatorTo = newStoreOperatorTo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO, oldStoreOperatorTo, newStoreOperatorTo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setStoreOperatorTo(PropertyReference newStoreOperatorTo) {
        if (newStoreOperatorTo != storeOperatorTo) {
            NotificationChain msgs = null;
            if (storeOperatorTo != null)
                msgs = ((InternalEObject)storeOperatorTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO, null, msgs);
            if (newStoreOperatorTo != null)
                msgs = ((InternalEObject)newStoreOperatorTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO, null, msgs);
            msgs = basicSetStoreOperatorTo(newStoreOperatorTo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO, newStoreOperatorTo, newStoreOperatorTo));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public PropertyReference getStoreLeftSideTo() {
        return storeLeftSideTo;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStoreLeftSideTo(PropertyReference newStoreLeftSideTo, NotificationChain msgs) {
        PropertyReference oldStoreLeftSideTo = storeLeftSideTo;
        storeLeftSideTo = newStoreLeftSideTo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO, oldStoreLeftSideTo, newStoreLeftSideTo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setStoreLeftSideTo(PropertyReference newStoreLeftSideTo) {
        if (newStoreLeftSideTo != storeLeftSideTo) {
            NotificationChain msgs = null;
            if (storeLeftSideTo != null)
                msgs = ((InternalEObject)storeLeftSideTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO, null, msgs);
            if (newStoreLeftSideTo != null)
                msgs = ((InternalEObject)newStoreLeftSideTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO, null, msgs);
            msgs = basicSetStoreLeftSideTo(newStoreLeftSideTo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO, newStoreLeftSideTo, newStoreLeftSideTo));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public PropertyReference getStoreRightSideTo() {
        return storeRightSideTo;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStoreRightSideTo(PropertyReference newStoreRightSideTo, NotificationChain msgs) {
        PropertyReference oldStoreRightSideTo = storeRightSideTo;
        storeRightSideTo = newStoreRightSideTo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO, oldStoreRightSideTo, newStoreRightSideTo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setStoreRightSideTo(PropertyReference newStoreRightSideTo) {
        if (newStoreRightSideTo != storeRightSideTo) {
            NotificationChain msgs = null;
            if (storeRightSideTo != null)
                msgs = ((InternalEObject)storeRightSideTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO, null, msgs);
            if (newStoreRightSideTo != null)
                msgs = ((InternalEObject)newStoreRightSideTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO, null, msgs);
            msgs = basicSetStoreRightSideTo(newStoreRightSideTo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO, newStoreRightSideTo, newStoreRightSideTo));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @SuppressWarnings("unchecked")
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperators()).basicAdd(otherEnd, msgs);
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
            case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
                return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO:
                return basicSetStoreOperatorTo(null, msgs);
            case TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO:
                return basicSetStoreLeftSideTo(null, msgs);
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO:
                return basicSetStoreRightSideTo(null, msgs);
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
            case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
                return getOperators();
            case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
                return getSource();
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
                return getStoreOpTo();
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
                return getStoreRightTo();
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO:
                return getStoreOperatorTo();
            case TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO:
                return getStoreLeftSideTo();
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO:
                return getStoreRightSideTo();
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
            case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
                getOperators().clear();
                getOperators().addAll((Collection<? extends Operator>)newValue);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
                setSource((String)newValue);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
                setStoreOpTo((String)newValue);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
                setStoreRightTo((String)newValue);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO:
                setStoreOperatorTo((PropertyReference)newValue);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO:
                setStoreLeftSideTo((PropertyReference)newValue);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO:
                setStoreRightSideTo((PropertyReference)newValue);
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
            case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
                getOperators().clear();
                return;
            case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
                setSource(SOURCE_EDEFAULT);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
                setStoreOpTo(STORE_OP_TO_EDEFAULT);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
                setStoreRightTo(STORE_RIGHT_TO_EDEFAULT);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO:
                setStoreOperatorTo((PropertyReference)null);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO:
                setStoreLeftSideTo((PropertyReference)null);
                return;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO:
                setStoreRightSideTo((PropertyReference)null);
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
            case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
                return operators != null && !operators.isEmpty();
            case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
                return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
                return STORE_OP_TO_EDEFAULT == null ? storeOpTo != null : !STORE_OP_TO_EDEFAULT.equals(storeOpTo);
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
                return STORE_RIGHT_TO_EDEFAULT == null ? storeRightTo != null : !STORE_RIGHT_TO_EDEFAULT.equals(storeRightTo);
            case TCSPackage.OPERATOR_TEMPLATE__STORE_OPERATOR_TO:
                return storeOperatorTo != null;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO:
                return storeLeftSideTo != null;
            case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO:
                return storeRightSideTo != null;
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
        result.append(" (source: ");
        result.append(source);
        result.append(", storeOpTo: ");
        result.append(storeOpTo);
        result.append(", storeRightTo: ");
        result.append(storeRightTo);
        result.append(')');
        return result.toString();
    }

} //OperatorTemplateImpl
