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

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTags;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl#isIsContext <em>Is Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl#isIsAddToContext <em>Is Add To Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl#isIsReferenceOnly <em>Is Reference Only</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl#getContextTags <em>Context Tags</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ContextTemplateImpl#getTemplateSequence <em>Template Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextTemplateImpl extends TemplateImpl implements ContextTemplate {
        /**
     * The default value of the '{@link #isIsContext() <em>Is Context</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsContext()
     * @generated
     * @ordered
     */
        protected static final boolean IS_CONTEXT_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isIsContext() <em>Is Context</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsContext()
     * @generated
     * @ordered
     */
        protected boolean isContext = IS_CONTEXT_EDEFAULT;

        /**
     * The default value of the '{@link #isIsAddToContext() <em>Is Add To Context</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsAddToContext()
     * @generated
     * @ordered
     */
        protected static final boolean IS_ADD_TO_CONTEXT_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isIsAddToContext() <em>Is Add To Context</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsAddToContext()
     * @generated
     * @ordered
     */
        protected boolean isAddToContext = IS_ADD_TO_CONTEXT_EDEFAULT;

        /**
     * The default value of the '{@link #isIsReferenceOnly() <em>Is Reference Only</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsReferenceOnly()
     * @generated
     * @ordered
     */
        protected static final boolean IS_REFERENCE_ONLY_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isIsReferenceOnly() <em>Is Reference Only</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsReferenceOnly()
     * @generated
     * @ordered
     */
        protected boolean isReferenceOnly = IS_REFERENCE_ONLY_EDEFAULT;

        /**
     * The cached value of the '{@link #getContextTags() <em>Context Tags</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getContextTags()
     * @generated
     * @ordered
     */
        protected ContextTags contextTags;

        /**
     * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getScope()
     * @generated
     * @ordered
     */
        protected ScopeArg scope;

        /**
     * The cached value of the '{@link #getTemplateSequence() <em>Template Sequence</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplateSequence()
     * @generated
     * @ordered
     */
    protected Sequence templateSequence;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected ContextTemplateImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.CONTEXT_TEMPLATE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isIsContext() {
        return isContext;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setIsContext(boolean newIsContext) {
        boolean oldIsContext = isContext;
        isContext = newIsContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__IS_CONTEXT, oldIsContext, isContext));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isIsAddToContext() {
        return isAddToContext;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setIsAddToContext(boolean newIsAddToContext) {
        boolean oldIsAddToContext = isAddToContext;
        isAddToContext = newIsAddToContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT, oldIsAddToContext, isAddToContext));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isIsReferenceOnly() {
        return isReferenceOnly;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setIsReferenceOnly(boolean newIsReferenceOnly) {
        boolean oldIsReferenceOnly = isReferenceOnly;
        isReferenceOnly = newIsReferenceOnly;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__IS_REFERENCE_ONLY, oldIsReferenceOnly, isReferenceOnly));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ContextTags getContextTags() {
        if (contextTags != null && contextTags.eIsProxy()) {
            InternalEObject oldContextTags = (InternalEObject)contextTags;
            contextTags = (ContextTags)eResolveProxy(oldContextTags);
            if (contextTags != oldContextTags) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.CONTEXT_TEMPLATE__CONTEXT_TAGS, oldContextTags, contextTags));
            }
        }
        return contextTags;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ContextTags basicGetContextTags() {
        return contextTags;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setContextTags(ContextTags newContextTags) {
        ContextTags oldContextTags = contextTags;
        contextTags = newContextTags;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__CONTEXT_TAGS, oldContextTags, contextTags));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ScopeArg getScope() {
        return scope;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetScope(ScopeArg newScope, NotificationChain msgs) {
        ScopeArg oldScope = scope;
        scope = newScope;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__SCOPE, oldScope, newScope);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setScope(ScopeArg newScope) {
        if (newScope != scope) {
            NotificationChain msgs = null;
            if (scope != null)
                msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CONTEXT_TEMPLATE__SCOPE, null, msgs);
            if (newScope != null)
                msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CONTEXT_TEMPLATE__SCOPE, null, msgs);
            msgs = basicSetScope(newScope, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__SCOPE, newScope, newScope));
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Sequence getTemplateSequence() {
        return templateSequence;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTemplateSequence(Sequence newTemplateSequence, NotificationChain msgs) {
        Sequence oldTemplateSequence = templateSequence;
        templateSequence = newTemplateSequence;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE, oldTemplateSequence, newTemplateSequence);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTemplateSequence(Sequence newTemplateSequence) {
        if (newTemplateSequence != templateSequence) {
            NotificationChain msgs = null;
            if (templateSequence != null)
                msgs = ((InternalEObject)templateSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE, null, msgs);
            if (newTemplateSequence != null)
                msgs = ((InternalEObject)newTemplateSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE, null, msgs);
            msgs = basicSetTemplateSequence(newTemplateSequence, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE, newTemplateSequence, newTemplateSequence));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.CONTEXT_TEMPLATE__SCOPE:
                return basicSetScope(null, msgs);
            case TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE:
                return basicSetTemplateSequence(null, msgs);
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
            case TCSPackage.CONTEXT_TEMPLATE__IS_CONTEXT:
                return isIsContext();
            case TCSPackage.CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT:
                return isIsAddToContext();
            case TCSPackage.CONTEXT_TEMPLATE__IS_REFERENCE_ONLY:
                return isIsReferenceOnly();
            case TCSPackage.CONTEXT_TEMPLATE__CONTEXT_TAGS:
                if (resolve) return getContextTags();
                return basicGetContextTags();
            case TCSPackage.CONTEXT_TEMPLATE__SCOPE:
                return getScope();
            case TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE:
                return getTemplateSequence();
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
            case TCSPackage.CONTEXT_TEMPLATE__IS_CONTEXT:
                setIsContext((Boolean)newValue);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT:
                setIsAddToContext((Boolean)newValue);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__IS_REFERENCE_ONLY:
                setIsReferenceOnly((Boolean)newValue);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__CONTEXT_TAGS:
                setContextTags((ContextTags)newValue);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__SCOPE:
                setScope((ScopeArg)newValue);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE:
                setTemplateSequence((Sequence)newValue);
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
            case TCSPackage.CONTEXT_TEMPLATE__IS_CONTEXT:
                setIsContext(IS_CONTEXT_EDEFAULT);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT:
                setIsAddToContext(IS_ADD_TO_CONTEXT_EDEFAULT);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__IS_REFERENCE_ONLY:
                setIsReferenceOnly(IS_REFERENCE_ONLY_EDEFAULT);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__CONTEXT_TAGS:
                setContextTags((ContextTags)null);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__SCOPE:
                setScope((ScopeArg)null);
                return;
            case TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE:
                setTemplateSequence((Sequence)null);
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
            case TCSPackage.CONTEXT_TEMPLATE__IS_CONTEXT:
                return isContext != IS_CONTEXT_EDEFAULT;
            case TCSPackage.CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT:
                return isAddToContext != IS_ADD_TO_CONTEXT_EDEFAULT;
            case TCSPackage.CONTEXT_TEMPLATE__IS_REFERENCE_ONLY:
                return isReferenceOnly != IS_REFERENCE_ONLY_EDEFAULT;
            case TCSPackage.CONTEXT_TEMPLATE__CONTEXT_TAGS:
                return contextTags != null;
            case TCSPackage.CONTEXT_TEMPLATE__SCOPE:
                return scope != null;
            case TCSPackage.CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE:
                return templateSequence != null;
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
        result.append(" (isContext: ");
        result.append(isContext);
        result.append(", isAddToContext: ");
        result.append(isAddToContext);
        result.append(", isReferenceOnly: ");
        result.append(isReferenceOnly);
        result.append(')');
        return result.toString();
    }

} //ContextTemplateImpl
