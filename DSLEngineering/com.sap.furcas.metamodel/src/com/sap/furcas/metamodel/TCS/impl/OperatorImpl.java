/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.impl;

import com.sap.furcas.metamodel.TCS.Literal;
import com.sap.furcas.metamodel.TCS.Operator;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.Priority;
import com.sap.furcas.metamodel.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.OperatorImpl#isIsPostfix <em>Is Postfix</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.OperatorImpl#getArity <em>Arity</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.OperatorImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.OperatorImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.OperatorImpl#getTemplates <em>Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends NamedElementImpl implements Operator {
        /**
         * The default value of the '{@link #isIsPostfix() <em>Is Postfix</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isIsPostfix()
         * @generated
         * @ordered
         */
        protected static final boolean IS_POSTFIX_EDEFAULT = false;

        /**
         * The cached value of the '{@link #isIsPostfix() <em>Is Postfix</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isIsPostfix()
         * @generated
         * @ordered
         */
        protected boolean isPostfix = IS_POSTFIX_EDEFAULT;

        /**
         * The default value of the '{@link #getArity() <em>Arity</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getArity()
         * @generated
         * @ordered
         */
        protected static final int ARITY_EDEFAULT = 0;

        /**
         * The cached value of the '{@link #getArity() <em>Arity</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getArity()
         * @generated
         * @ordered
         */
        protected int arity = ARITY_EDEFAULT;

        /**
         * The cached value of the '{@link #getLiteral() <em>Literal</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getLiteral()
         * @generated
         * @ordered
         */
        protected Literal literal;

        /**
         * The cached value of the '{@link #getTemplates() <em>Templates</em>}' reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getTemplates()
         * @generated
         * @ordered
         */
        protected EList<OperatorTemplate> templates;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected OperatorImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.OPERATOR;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public boolean isIsPostfix() {
                return isPostfix;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setIsPostfix(boolean newIsPostfix) {
                boolean oldIsPostfix = isPostfix;
                isPostfix = newIsPostfix;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR__IS_POSTFIX, oldIsPostfix, isPostfix));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public int getArity() {
                return arity;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setArity(int newArity) {
                int oldArity = arity;
                arity = newArity;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR__ARITY, oldArity, arity));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Literal getLiteral() {
                if (literal != null && literal.eIsProxy()) {
                        InternalEObject oldLiteral = (InternalEObject)literal;
                        literal = (Literal)eResolveProxy(oldLiteral);
                        if (literal != oldLiteral) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.OPERATOR__LITERAL, oldLiteral, literal));
                        }
                }
                return literal;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Literal basicGetLiteral() {
                return literal;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public NotificationChain basicSetLiteral(Literal newLiteral, NotificationChain msgs) {
                Literal oldLiteral = literal;
                literal = newLiteral;
                if (eNotificationRequired()) {
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR__LITERAL, oldLiteral, newLiteral);
                        if (msgs == null) msgs = notification; else msgs.add(notification);
                }
                return msgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setLiteral(Literal newLiteral) {
                if (newLiteral != literal) {
                        NotificationChain msgs = null;
                        if (literal != null)
                                msgs = ((InternalEObject)literal).eInverseRemove(this, TCSPackage.LITERAL__OPERATORS, Literal.class, msgs);
                        if (newLiteral != null)
                                msgs = ((InternalEObject)newLiteral).eInverseAdd(this, TCSPackage.LITERAL__OPERATORS, Literal.class, msgs);
                        msgs = basicSetLiteral(newLiteral, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR__LITERAL, newLiteral, newLiteral));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Priority getPriority() {
                if (eContainerFeatureID() != TCSPackage.OPERATOR__PRIORITY) return null;
                return (Priority)eContainer();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public NotificationChain basicSetPriority(Priority newPriority, NotificationChain msgs) {
                msgs = eBasicSetContainer((InternalEObject)newPriority, TCSPackage.OPERATOR__PRIORITY, msgs);
                return msgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setPriority(Priority newPriority) {
                if (newPriority != eInternalContainer() || (eContainerFeatureID() != TCSPackage.OPERATOR__PRIORITY && newPriority != null)) {
                        if (EcoreUtil.isAncestor(this, newPriority))
                                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
                        NotificationChain msgs = null;
                        if (eInternalContainer() != null)
                                msgs = eBasicRemoveFromContainer(msgs);
                        if (newPriority != null)
                                msgs = ((InternalEObject)newPriority).eInverseAdd(this, TCSPackage.PRIORITY__OPERATORS, Priority.class, msgs);
                        msgs = basicSetPriority(newPriority, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR__PRIORITY, newPriority, newPriority));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<OperatorTemplate> getTemplates() {
                if (templates == null) {
                        templates = new EObjectWithInverseResolvingEList.ManyInverse<OperatorTemplate>(OperatorTemplate.class, this, TCSPackage.OPERATOR__TEMPLATES, TCSPackage.OPERATOR_TEMPLATE__OPERATORS);
                }
                return templates;
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
                        case TCSPackage.OPERATOR__LITERAL:
                                if (literal != null)
                                        msgs = ((InternalEObject)literal).eInverseRemove(this, TCSPackage.LITERAL__OPERATORS, Literal.class, msgs);
                                return basicSetLiteral((Literal)otherEnd, msgs);
                        case TCSPackage.OPERATOR__PRIORITY:
                                if (eInternalContainer() != null)
                                        msgs = eBasicRemoveFromContainer(msgs);
                                return basicSetPriority((Priority)otherEnd, msgs);
                        case TCSPackage.OPERATOR__TEMPLATES:
                                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplates()).basicAdd(otherEnd, msgs);
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
                        case TCSPackage.OPERATOR__LITERAL:
                                return basicSetLiteral(null, msgs);
                        case TCSPackage.OPERATOR__PRIORITY:
                                return basicSetPriority(null, msgs);
                        case TCSPackage.OPERATOR__TEMPLATES:
                                return ((InternalEList<?>)getTemplates()).basicRemove(otherEnd, msgs);
                }
                return super.eInverseRemove(otherEnd, featureID, msgs);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
                switch (eContainerFeatureID()) {
                        case TCSPackage.OPERATOR__PRIORITY:
                                return eInternalContainer().eInverseRemove(this, TCSPackage.PRIORITY__OPERATORS, Priority.class, msgs);
                }
                return super.eBasicRemoveFromContainerFeature(msgs);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TCSPackage.OPERATOR__IS_POSTFIX:
                                return isIsPostfix();
                        case TCSPackage.OPERATOR__ARITY:
                                return getArity();
                        case TCSPackage.OPERATOR__LITERAL:
                                if (resolve) return getLiteral();
                                return basicGetLiteral();
                        case TCSPackage.OPERATOR__PRIORITY:
                                return getPriority();
                        case TCSPackage.OPERATOR__TEMPLATES:
                                return getTemplates();
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
                        case TCSPackage.OPERATOR__IS_POSTFIX:
                                setIsPostfix((Boolean)newValue);
                                return;
                        case TCSPackage.OPERATOR__ARITY:
                                setArity((Integer)newValue);
                                return;
                        case TCSPackage.OPERATOR__LITERAL:
                                setLiteral((Literal)newValue);
                                return;
                        case TCSPackage.OPERATOR__PRIORITY:
                                setPriority((Priority)newValue);
                                return;
                        case TCSPackage.OPERATOR__TEMPLATES:
                                getTemplates().clear();
                                getTemplates().addAll((Collection<? extends OperatorTemplate>)newValue);
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
                        case TCSPackage.OPERATOR__IS_POSTFIX:
                                setIsPostfix(IS_POSTFIX_EDEFAULT);
                                return;
                        case TCSPackage.OPERATOR__ARITY:
                                setArity(ARITY_EDEFAULT);
                                return;
                        case TCSPackage.OPERATOR__LITERAL:
                                setLiteral((Literal)null);
                                return;
                        case TCSPackage.OPERATOR__PRIORITY:
                                setPriority((Priority)null);
                                return;
                        case TCSPackage.OPERATOR__TEMPLATES:
                                getTemplates().clear();
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
                        case TCSPackage.OPERATOR__IS_POSTFIX:
                                return isPostfix != IS_POSTFIX_EDEFAULT;
                        case TCSPackage.OPERATOR__ARITY:
                                return arity != ARITY_EDEFAULT;
                        case TCSPackage.OPERATOR__LITERAL:
                                return literal != null;
                        case TCSPackage.OPERATOR__PRIORITY:
                                return getPriority() != null;
                        case TCSPackage.OPERATOR__TEMPLATES:
                                return templates != null && !templates.isEmpty();
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
                result.append(" (isPostfix: ");
                result.append(isPostfix);
                result.append(", arity: ");
                result.append(arity);
                result.append(')');
                return result.toString();
        }

} //OperatorImpl
