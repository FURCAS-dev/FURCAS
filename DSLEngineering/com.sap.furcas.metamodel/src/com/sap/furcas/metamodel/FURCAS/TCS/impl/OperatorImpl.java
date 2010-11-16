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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl#isPostfix <em>Postfix</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl#getArity <em>Arity</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorImpl#getTemplates <em>Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends NamedElementImpl implements Operator {
        /**
     * The default value of the '{@link #isPostfix() <em>Postfix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isPostfix()
     * @generated
     * @ordered
     */
    protected static final boolean POSTFIX_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isPostfix() <em>Postfix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isPostfix()
     * @generated
     * @ordered
     */
    protected boolean postfix = POSTFIX_EDEFAULT;

        /**
     * The default value of the '{@link #getArity() <em>Arity</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getArity()
     * @generated
     * @ordered
     */
        protected static final Integer ARITY_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getArity() <em>Arity</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getArity()
     * @generated
     * @ordered
     */
        protected Integer arity = ARITY_EDEFAULT;

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
    public boolean isPostfix() {
        return postfix;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPostfix(boolean newPostfix) {
        boolean oldPostfix = postfix;
        postfix = newPostfix;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR__POSTFIX, oldPostfix, postfix));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public Integer getArity() {
        return arity;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setArity(Integer newArity) {
        Integer oldArity = arity;
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
            case TCSPackage.OPERATOR__POSTFIX:
                return isPostfix();
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
            case TCSPackage.OPERATOR__POSTFIX:
                setPostfix((Boolean)newValue);
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
            case TCSPackage.OPERATOR__POSTFIX:
                setPostfix(POSTFIX_EDEFAULT);
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
            case TCSPackage.OPERATOR__POSTFIX:
                return postfix != POSTFIX_EDEFAULT;
            case TCSPackage.OPERATOR__ARITY:
                return ARITY_EDEFAULT == null ? arity != null : !ARITY_EDEFAULT.equals(arity);
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
        result.append(" (postfix: ");
        result.append(postfix);
        result.append(", arity: ");
        result.append(arity);
        result.append(')');
        return result.toString();
    }

} //OperatorImpl
