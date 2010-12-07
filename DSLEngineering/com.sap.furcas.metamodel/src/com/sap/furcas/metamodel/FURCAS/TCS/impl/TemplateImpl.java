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
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl#getDisambiguate <em>Disambiguate</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl#getDisambiguateV3 <em>Disambiguate V3</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl#getSemDisambiguate <em>Sem Disambiguate</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImpl#getTextBlockDefinition <em>Text Block Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TemplateImpl extends QualifiedNamedElementImpl implements Template {
        /**
     * The default value of the '{@link #getDisambiguate() <em>Disambiguate</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getDisambiguate()
     * @generated
     * @ordered
     */
        protected static final String DISAMBIGUATE_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getDisambiguate() <em>Disambiguate</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getDisambiguate()
     * @generated
     * @ordered
     */
        protected String disambiguate = DISAMBIGUATE_EDEFAULT;

        /**
     * The default value of the '{@link #getDisambiguateV3() <em>Disambiguate V3</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getDisambiguateV3()
     * @generated
     * @ordered
     */
        protected static final String DISAMBIGUATE_V3_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getDisambiguateV3() <em>Disambiguate V3</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getDisambiguateV3()
     * @generated
     * @ordered
     */
        protected String disambiguateV3 = DISAMBIGUATE_V3_EDEFAULT;

        /**
     * The default value of the '{@link #getSemDisambiguate() <em>Sem Disambiguate</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSemDisambiguate()
     * @generated
     * @ordered
     */
	protected static final String SEM_DISAMBIGUATE_EDEFAULT = null;

								/**
     * The cached value of the '{@link #getSemDisambiguate() <em>Sem Disambiguate</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSemDisambiguate()
     * @generated
     * @ordered
     */
	protected String semDisambiguate = SEM_DISAMBIGUATE_EDEFAULT;

								/**
     * The cached value of the '{@link #getTextBlockDefinition() <em>Text Block Definition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTextBlockDefinition()
     * @generated
     * @ordered
     */
	protected TextBlockDefinition textBlockDefinition;

								/**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected TemplateImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.TEMPLATE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ConcreteSyntax getConcreteSyntax() {
        if (eContainerFeatureID() != TCSPackage.TEMPLATE__CONCRETE_SYNTAX) return null;
        return (ConcreteSyntax)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetConcreteSyntax(ConcreteSyntax newConcreteSyntax, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newConcreteSyntax, TCSPackage.TEMPLATE__CONCRETE_SYNTAX, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setConcreteSyntax(ConcreteSyntax newConcreteSyntax) {
        if (newConcreteSyntax != eInternalContainer() || (eContainerFeatureID() != TCSPackage.TEMPLATE__CONCRETE_SYNTAX && newConcreteSyntax != null)) {
            if (EcoreUtil.isAncestor(this, newConcreteSyntax))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newConcreteSyntax != null)
                msgs = ((InternalEObject)newConcreteSyntax).eInverseAdd(this, TCSPackage.CONCRETE_SYNTAX__TEMPLATES, ConcreteSyntax.class, msgs);
            msgs = basicSetConcreteSyntax(newConcreteSyntax, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE__CONCRETE_SYNTAX, newConcreteSyntax, newConcreteSyntax));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getDisambiguate() {
        return disambiguate;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setDisambiguate(String newDisambiguate) {
        String oldDisambiguate = disambiguate;
        disambiguate = newDisambiguate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE__DISAMBIGUATE, oldDisambiguate, disambiguate));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getDisambiguateV3() {
        return disambiguateV3;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setDisambiguateV3(String newDisambiguateV3) {
        String oldDisambiguateV3 = disambiguateV3;
        disambiguateV3 = newDisambiguateV3;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE__DISAMBIGUATE_V3, oldDisambiguateV3, disambiguateV3));
    }

        /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getSemDisambiguate() {
        return semDisambiguate;
    }

								/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSemDisambiguate(String newSemDisambiguate) {
        String oldSemDisambiguate = semDisambiguate;
        semDisambiguate = newSemDisambiguate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE__SEM_DISAMBIGUATE, oldSemDisambiguate, semDisambiguate));
    }

								/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TextBlockDefinition getTextBlockDefinition() {
        return textBlockDefinition;
    }

								/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTextBlockDefinition(TextBlockDefinition newTextBlockDefinition, NotificationChain msgs) {
        TextBlockDefinition oldTextBlockDefinition = textBlockDefinition;
        textBlockDefinition = newTextBlockDefinition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION, oldTextBlockDefinition, newTextBlockDefinition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

								/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTextBlockDefinition(TextBlockDefinition newTextBlockDefinition) {
        if (newTextBlockDefinition != textBlockDefinition) {
            NotificationChain msgs = null;
            if (textBlockDefinition != null)
                msgs = ((InternalEObject)textBlockDefinition).eInverseRemove(this, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE, TextBlockDefinition.class, msgs);
            if (newTextBlockDefinition != null)
                msgs = ((InternalEObject)newTextBlockDefinition).eInverseAdd(this, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE, TextBlockDefinition.class, msgs);
            msgs = basicSetTextBlockDefinition(newTextBlockDefinition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION, newTextBlockDefinition, newTextBlockDefinition));
    }

								/**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.TEMPLATE__CONCRETE_SYNTAX:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetConcreteSyntax((ConcreteSyntax)otherEnd, msgs);
            case TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION:
                if (textBlockDefinition != null)
                    msgs = ((InternalEObject)textBlockDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION, null, msgs);
                return basicSetTextBlockDefinition((TextBlockDefinition)otherEnd, msgs);
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
            case TCSPackage.TEMPLATE__CONCRETE_SYNTAX:
                return basicSetConcreteSyntax(null, msgs);
            case TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION:
                return basicSetTextBlockDefinition(null, msgs);
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
            case TCSPackage.TEMPLATE__CONCRETE_SYNTAX:
                return eInternalContainer().eInverseRemove(this, TCSPackage.CONCRETE_SYNTAX__TEMPLATES, ConcreteSyntax.class, msgs);
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
            case TCSPackage.TEMPLATE__CONCRETE_SYNTAX:
                return getConcreteSyntax();
            case TCSPackage.TEMPLATE__DISAMBIGUATE:
                return getDisambiguate();
            case TCSPackage.TEMPLATE__DISAMBIGUATE_V3:
                return getDisambiguateV3();
            case TCSPackage.TEMPLATE__SEM_DISAMBIGUATE:
                return getSemDisambiguate();
            case TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION:
                return getTextBlockDefinition();
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
            case TCSPackage.TEMPLATE__CONCRETE_SYNTAX:
                setConcreteSyntax((ConcreteSyntax)newValue);
                return;
            case TCSPackage.TEMPLATE__DISAMBIGUATE:
                setDisambiguate((String)newValue);
                return;
            case TCSPackage.TEMPLATE__DISAMBIGUATE_V3:
                setDisambiguateV3((String)newValue);
                return;
            case TCSPackage.TEMPLATE__SEM_DISAMBIGUATE:
                setSemDisambiguate((String)newValue);
                return;
            case TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION:
                setTextBlockDefinition((TextBlockDefinition)newValue);
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
            case TCSPackage.TEMPLATE__CONCRETE_SYNTAX:
                setConcreteSyntax((ConcreteSyntax)null);
                return;
            case TCSPackage.TEMPLATE__DISAMBIGUATE:
                setDisambiguate(DISAMBIGUATE_EDEFAULT);
                return;
            case TCSPackage.TEMPLATE__DISAMBIGUATE_V3:
                setDisambiguateV3(DISAMBIGUATE_V3_EDEFAULT);
                return;
            case TCSPackage.TEMPLATE__SEM_DISAMBIGUATE:
                setSemDisambiguate(SEM_DISAMBIGUATE_EDEFAULT);
                return;
            case TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION:
                setTextBlockDefinition((TextBlockDefinition)null);
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
            case TCSPackage.TEMPLATE__CONCRETE_SYNTAX:
                return getConcreteSyntax() != null;
            case TCSPackage.TEMPLATE__DISAMBIGUATE:
                return DISAMBIGUATE_EDEFAULT == null ? disambiguate != null : !DISAMBIGUATE_EDEFAULT.equals(disambiguate);
            case TCSPackage.TEMPLATE__DISAMBIGUATE_V3:
                return DISAMBIGUATE_V3_EDEFAULT == null ? disambiguateV3 != null : !DISAMBIGUATE_V3_EDEFAULT.equals(disambiguateV3);
            case TCSPackage.TEMPLATE__SEM_DISAMBIGUATE:
                return SEM_DISAMBIGUATE_EDEFAULT == null ? semDisambiguate != null : !SEM_DISAMBIGUATE_EDEFAULT.equals(semDisambiguate);
            case TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION:
                return textBlockDefinition != null;
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
        result.append(" (disambiguate: ");
        result.append(disambiguate);
        result.append(", disambiguateV3: ");
        result.append(disambiguateV3);
        result.append(", semDisambiguate: ");
        result.append(semDisambiguate);
        result.append(')');
        return result.toString();
    }

} //TemplateImpl
