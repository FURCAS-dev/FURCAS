/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.Mapping;
import com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Line Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl#getStart <em>Start</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl#getEnd <em>End</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl#getEsc <em>Esc</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl#getEscMappings <em>Esc Mappings</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl#isDropStart <em>Drop Start</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.MultiLineRuleImpl#isDropEnd <em>Drop End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiLineRuleImpl extends RuleImpl implements MultiLineRule {
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
         * The cached value of the '{@link #getEnd() <em>End</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getEnd()
         * @generated
         * @ordered
         */
        protected StringPattern end;

        /**
         * The cached value of the '{@link #getEsc() <em>Esc</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getEsc()
         * @generated
         * @ordered
         */
        protected StringPattern esc;

        /**
         * The cached value of the '{@link #getEscMappings() <em>Esc Mappings</em>}' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getEscMappings()
         * @generated
         * @ordered
         */
        protected EList<Mapping> escMappings;

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
         * The default value of the '{@link #isDropEnd() <em>Drop End</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isDropEnd()
         * @generated
         * @ordered
         */
        protected static final boolean DROP_END_EDEFAULT = false;

        /**
         * The cached value of the '{@link #isDropEnd() <em>Drop End</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isDropEnd()
         * @generated
         * @ordered
         */
        protected boolean dropEnd = DROP_END_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected MultiLineRuleImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.MULTI_LINE_RULE;
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
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__START, oldStart, newStart);
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
                                msgs = ((InternalEObject)start).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.MULTI_LINE_RULE__START, null, msgs);
                        if (newStart != null)
                                msgs = ((InternalEObject)newStart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.MULTI_LINE_RULE__START, null, msgs);
                        msgs = basicSetStart(newStart, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__START, newStart, newStart));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public StringPattern getEnd() {
                return end;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public NotificationChain basicSetEnd(StringPattern newEnd, NotificationChain msgs) {
                StringPattern oldEnd = end;
                end = newEnd;
                if (eNotificationRequired()) {
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__END, oldEnd, newEnd);
                        if (msgs == null) msgs = notification; else msgs.add(notification);
                }
                return msgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setEnd(StringPattern newEnd) {
                if (newEnd != end) {
                        NotificationChain msgs = null;
                        if (end != null)
                                msgs = ((InternalEObject)end).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.MULTI_LINE_RULE__END, null, msgs);
                        if (newEnd != null)
                                msgs = ((InternalEObject)newEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.MULTI_LINE_RULE__END, null, msgs);
                        msgs = basicSetEnd(newEnd, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__END, newEnd, newEnd));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public StringPattern getEsc() {
                return esc;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public NotificationChain basicSetEsc(StringPattern newEsc, NotificationChain msgs) {
                StringPattern oldEsc = esc;
                esc = newEsc;
                if (eNotificationRequired()) {
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__ESC, oldEsc, newEsc);
                        if (msgs == null) msgs = notification; else msgs.add(notification);
                }
                return msgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setEsc(StringPattern newEsc) {
                if (newEsc != esc) {
                        NotificationChain msgs = null;
                        if (esc != null)
                                msgs = ((InternalEObject)esc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.MULTI_LINE_RULE__ESC, null, msgs);
                        if (newEsc != null)
                                msgs = ((InternalEObject)newEsc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.MULTI_LINE_RULE__ESC, null, msgs);
                        msgs = basicSetEsc(newEsc, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__ESC, newEsc, newEsc));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<Mapping> getEscMappings() {
                if (escMappings == null) {
                        escMappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, TCSPackage.MULTI_LINE_RULE__ESC_MAPPINGS);
                }
                return escMappings;
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
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__DROP_START, oldDropStart, dropStart));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public boolean isDropEnd() {
                return dropEnd;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setDropEnd(boolean newDropEnd) {
                boolean oldDropEnd = dropEnd;
                dropEnd = newDropEnd;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.MULTI_LINE_RULE__DROP_END, oldDropEnd, dropEnd));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case TCSPackage.MULTI_LINE_RULE__START:
                                return basicSetStart(null, msgs);
                        case TCSPackage.MULTI_LINE_RULE__END:
                                return basicSetEnd(null, msgs);
                        case TCSPackage.MULTI_LINE_RULE__ESC:
                                return basicSetEsc(null, msgs);
                        case TCSPackage.MULTI_LINE_RULE__ESC_MAPPINGS:
                                return ((InternalEList<?>)getEscMappings()).basicRemove(otherEnd, msgs);
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
                        case TCSPackage.MULTI_LINE_RULE__START:
                                return getStart();
                        case TCSPackage.MULTI_LINE_RULE__END:
                                return getEnd();
                        case TCSPackage.MULTI_LINE_RULE__ESC:
                                return getEsc();
                        case TCSPackage.MULTI_LINE_RULE__ESC_MAPPINGS:
                                return getEscMappings();
                        case TCSPackage.MULTI_LINE_RULE__DROP_START:
                                return isDropStart();
                        case TCSPackage.MULTI_LINE_RULE__DROP_END:
                                return isDropEnd();
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
                        case TCSPackage.MULTI_LINE_RULE__START:
                                setStart((StringPattern)newValue);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__END:
                                setEnd((StringPattern)newValue);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__ESC:
                                setEsc((StringPattern)newValue);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__ESC_MAPPINGS:
                                getEscMappings().clear();
                                getEscMappings().addAll((Collection<? extends Mapping>)newValue);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__DROP_START:
                                setDropStart((Boolean)newValue);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__DROP_END:
                                setDropEnd((Boolean)newValue);
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
                        case TCSPackage.MULTI_LINE_RULE__START:
                                setStart((StringPattern)null);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__END:
                                setEnd((StringPattern)null);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__ESC:
                                setEsc((StringPattern)null);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__ESC_MAPPINGS:
                                getEscMappings().clear();
                                return;
                        case TCSPackage.MULTI_LINE_RULE__DROP_START:
                                setDropStart(DROP_START_EDEFAULT);
                                return;
                        case TCSPackage.MULTI_LINE_RULE__DROP_END:
                                setDropEnd(DROP_END_EDEFAULT);
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
                        case TCSPackage.MULTI_LINE_RULE__START:
                                return start != null;
                        case TCSPackage.MULTI_LINE_RULE__END:
                                return end != null;
                        case TCSPackage.MULTI_LINE_RULE__ESC:
                                return esc != null;
                        case TCSPackage.MULTI_LINE_RULE__ESC_MAPPINGS:
                                return escMappings != null && !escMappings.isEmpty();
                        case TCSPackage.MULTI_LINE_RULE__DROP_START:
                                return dropStart != DROP_START_EDEFAULT;
                        case TCSPackage.MULTI_LINE_RULE__DROP_END:
                                return dropEnd != DROP_END_EDEFAULT;
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
                result.append(", dropEnd: ");
                result.append(dropEnd);
                result.append(')');
                return result.toString();
        }

} //MultiLineRuleImpl
