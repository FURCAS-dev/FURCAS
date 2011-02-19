/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Each Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.ForEachContextImpl#getForeachPedicatePropertyInit <em>Foreach Pedicate Property Init</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.ForEachContextImpl#getContextElement <em>Context Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.ForEachContextImpl#getResultModelElement <em>Result Model Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.ForEachContextImpl#getSourceModelElement <em>Source Model Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.ForEachContextImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.ForEachContextImpl#getContextString <em>Context String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForEachContextImpl extends EObjectImpl implements ForEachContext {
        /**
     * The cached value of the '{@link #getForeachPedicatePropertyInit() <em>Foreach Pedicate Property Init</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getForeachPedicatePropertyInit()
     * @generated
     * @ordered
     */
        protected ForeachPredicatePropertyInit foreachPedicatePropertyInit;

        /**
     * The cached value of the '{@link #getContextElement() <em>Context Element</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getContextElement()
     * @generated
     * @ordered
     */
        protected EObject contextElement;

        /**
     * The cached value of the '{@link #getResultModelElement() <em>Result Model Element</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getResultModelElement()
     * @generated
     * @ordered
     */
        protected EObject resultModelElement;

        /**
     * The cached value of the '{@link #getSourceModelElement() <em>Source Model Element</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getSourceModelElement()
     * @generated
     * @ordered
     */
        protected EObject sourceModelElement;

        /**
     * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplate()
     * @generated
     * @ordered
     */
    protected Template template;

        /**
     * The default value of the '{@link #getContextString() <em>Context String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextString()
     * @generated
     * @ordered
     */
    protected static final String CONTEXT_STRING_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getContextString() <em>Context String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextString()
     * @generated
     * @ordered
     */
    protected String contextString = CONTEXT_STRING_EDEFAULT;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected ForEachContextImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TextblocksPackage.Literals.FOR_EACH_CONTEXT;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ForeachPredicatePropertyInit getForeachPedicatePropertyInit() {
        if (foreachPedicatePropertyInit != null && foreachPedicatePropertyInit.eIsProxy()) {
            InternalEObject oldForeachPedicatePropertyInit = (InternalEObject)foreachPedicatePropertyInit;
            foreachPedicatePropertyInit = (ForeachPredicatePropertyInit)eResolveProxy(oldForeachPedicatePropertyInit);
            if (foreachPedicatePropertyInit != oldForeachPedicatePropertyInit) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblocksPackage.FOR_EACH_CONTEXT__FOREACH_PEDICATE_PROPERTY_INIT, oldForeachPedicatePropertyInit, foreachPedicatePropertyInit));
            }
        }
        return foreachPedicatePropertyInit;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ForeachPredicatePropertyInit basicGetForeachPedicatePropertyInit() {
        return foreachPedicatePropertyInit;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setForeachPedicatePropertyInit(ForeachPredicatePropertyInit newForeachPedicatePropertyInit) {
        ForeachPredicatePropertyInit oldForeachPedicatePropertyInit = foreachPedicatePropertyInit;
        foreachPedicatePropertyInit = newForeachPedicatePropertyInit;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.FOR_EACH_CONTEXT__FOREACH_PEDICATE_PROPERTY_INIT, oldForeachPedicatePropertyInit, foreachPedicatePropertyInit));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EObject getContextElement() {
        if (contextElement != null && contextElement.eIsProxy()) {
            InternalEObject oldContextElement = (InternalEObject)contextElement;
            contextElement = eResolveProxy(oldContextElement);
            if (contextElement != oldContextElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_ELEMENT, oldContextElement, contextElement));
            }
        }
        return contextElement;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject basicGetContextElement() {
        return contextElement;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextElement(EObject newContextElement) {
        EObject oldContextElement = contextElement;
        contextElement = newContextElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_ELEMENT, oldContextElement, contextElement));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EObject getResultModelElement() {
        if (resultModelElement != null && resultModelElement.eIsProxy()) {
            InternalEObject oldResultModelElement = (InternalEObject)resultModelElement;
            resultModelElement = eResolveProxy(oldResultModelElement);
            if (resultModelElement != oldResultModelElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblocksPackage.FOR_EACH_CONTEXT__RESULT_MODEL_ELEMENT, oldResultModelElement, resultModelElement));
            }
        }
        return resultModelElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EObject basicGetResultModelElement() {
        return resultModelElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setResultModelElement(EObject newResultModelElement) {
        EObject oldResultModelElement = resultModelElement;
        resultModelElement = newResultModelElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.FOR_EACH_CONTEXT__RESULT_MODEL_ELEMENT, oldResultModelElement, resultModelElement));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EObject getSourceModelElement() {
        if (sourceModelElement != null && sourceModelElement.eIsProxy()) {
            InternalEObject oldSourceModelElement = (InternalEObject)sourceModelElement;
            sourceModelElement = eResolveProxy(oldSourceModelElement);
            if (sourceModelElement != oldSourceModelElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblocksPackage.FOR_EACH_CONTEXT__SOURCE_MODEL_ELEMENT, oldSourceModelElement, sourceModelElement));
            }
        }
        return sourceModelElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EObject basicGetSourceModelElement() {
        return sourceModelElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setSourceModelElement(EObject newSourceModelElement) {
        EObject oldSourceModelElement = sourceModelElement;
        sourceModelElement = newSourceModelElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.FOR_EACH_CONTEXT__SOURCE_MODEL_ELEMENT, oldSourceModelElement, sourceModelElement));
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Template getTemplate() {
        if (template != null && template.eIsProxy()) {
            InternalEObject oldTemplate = (InternalEObject)template;
            template = (Template)eResolveProxy(oldTemplate);
            if (template != oldTemplate) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblocksPackage.FOR_EACH_CONTEXT__TEMPLATE, oldTemplate, template));
            }
        }
        return template;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Template basicGetTemplate() {
        return template;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTemplate(Template newTemplate) {
        Template oldTemplate = template;
        template = newTemplate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.FOR_EACH_CONTEXT__TEMPLATE, oldTemplate, template));
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContextString() {
        return contextString;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextString(String newContextString) {
        String oldContextString = contextString;
        contextString = newContextString;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_STRING, oldContextString, contextString));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TextblocksPackage.FOR_EACH_CONTEXT__FOREACH_PEDICATE_PROPERTY_INIT:
                if (resolve) return getForeachPedicatePropertyInit();
                return basicGetForeachPedicatePropertyInit();
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_ELEMENT:
                if (resolve) return getContextElement();
                return basicGetContextElement();
            case TextblocksPackage.FOR_EACH_CONTEXT__RESULT_MODEL_ELEMENT:
                if (resolve) return getResultModelElement();
                return basicGetResultModelElement();
            case TextblocksPackage.FOR_EACH_CONTEXT__SOURCE_MODEL_ELEMENT:
                if (resolve) return getSourceModelElement();
                return basicGetSourceModelElement();
            case TextblocksPackage.FOR_EACH_CONTEXT__TEMPLATE:
                if (resolve) return getTemplate();
                return basicGetTemplate();
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_STRING:
                return getContextString();
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
            case TextblocksPackage.FOR_EACH_CONTEXT__FOREACH_PEDICATE_PROPERTY_INIT:
                setForeachPedicatePropertyInit((ForeachPredicatePropertyInit)newValue);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_ELEMENT:
                setContextElement((EObject)newValue);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__RESULT_MODEL_ELEMENT:
                setResultModelElement((EObject)newValue);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__SOURCE_MODEL_ELEMENT:
                setSourceModelElement((EObject)newValue);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__TEMPLATE:
                setTemplate((Template)newValue);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_STRING:
                setContextString((String)newValue);
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
            case TextblocksPackage.FOR_EACH_CONTEXT__FOREACH_PEDICATE_PROPERTY_INIT:
                setForeachPedicatePropertyInit((ForeachPredicatePropertyInit)null);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_ELEMENT:
                setContextElement((EObject)null);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__RESULT_MODEL_ELEMENT:
                setResultModelElement((EObject)null);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__SOURCE_MODEL_ELEMENT:
                setSourceModelElement((EObject)null);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__TEMPLATE:
                setTemplate((Template)null);
                return;
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_STRING:
                setContextString(CONTEXT_STRING_EDEFAULT);
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
            case TextblocksPackage.FOR_EACH_CONTEXT__FOREACH_PEDICATE_PROPERTY_INIT:
                return foreachPedicatePropertyInit != null;
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_ELEMENT:
                return contextElement != null;
            case TextblocksPackage.FOR_EACH_CONTEXT__RESULT_MODEL_ELEMENT:
                return resultModelElement != null;
            case TextblocksPackage.FOR_EACH_CONTEXT__SOURCE_MODEL_ELEMENT:
                return sourceModelElement != null;
            case TextblocksPackage.FOR_EACH_CONTEXT__TEMPLATE:
                return template != null;
            case TextblocksPackage.FOR_EACH_CONTEXT__CONTEXT_STRING:
                return CONTEXT_STRING_EDEFAULT == null ? contextString != null : !CONTEXT_STRING_EDEFAULT.equals(contextString);
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
        result.append(" (contextString: ");
        result.append(contextString);
        result.append(')');
        return result.toString();
    }

} //ForEachContextImpl
