/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Block Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl#getFormatPolicy <em>Format Policy</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl#getDefaultTemplate <em>Default Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl#getParseRule <em>Parse Rule</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl#getContext <em>Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl#getSubDefinitions <em>Sub Definitions</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl#getGeneralisation <em>Generalisation</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextBlockDefinitionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextBlockDefinitionImpl extends EObjectImpl implements TextBlockDefinition {
        /**
	 * The default value of the '{@link #getFormatPolicy() <em>Format Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getFormatPolicy()
	 * @generated
	 * @ordered
	 */
        protected static final FormatPolicy FORMAT_POLICY_EDEFAULT = FormatPolicy.KEEP_ALWAYS;

        /**
	 * The cached value of the '{@link #getFormatPolicy() <em>Format Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getFormatPolicy()
	 * @generated
	 * @ordered
	 */
        protected FormatPolicy formatPolicy = FORMAT_POLICY_EDEFAULT;

        /**
	 * The default value of the '{@link #getDefaultTemplate() <em>Default Template</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getDefaultTemplate()
	 * @generated
	 * @ordered
	 */
        protected static final String DEFAULT_TEMPLATE_EDEFAULT = "";

        /**
	 * The cached value of the '{@link #getDefaultTemplate() <em>Default Template</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getDefaultTemplate()
	 * @generated
	 * @ordered
	 */
        protected String defaultTemplate = DEFAULT_TEMPLATE_EDEFAULT;

        /**
	 * The cached value of the '{@link #getSubDefinitions() <em>Sub Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getSubDefinitions()
	 * @generated
	 * @ordered
	 */
        protected EList<TextBlockDefinition> subDefinitions;

        /**
	 * The cached value of the '{@link #getGeneralisation() <em>Generalisation</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getGeneralisation()
	 * @generated
	 * @ordered
	 */
        protected TextBlockDefinition generalisation;

        /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
        protected static final String NAME_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
        protected String name = NAME_EDEFAULT;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected TextBlockDefinitionImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TextblockdefinitionPackage.Literals.TEXT_BLOCK_DEFINITION;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public FormatPolicy getFormatPolicy() {
		return formatPolicy;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setFormatPolicy(FormatPolicy newFormatPolicy) {
		FormatPolicy oldFormatPolicy = formatPolicy;
		formatPolicy = newFormatPolicy == null ? FORMAT_POLICY_EDEFAULT : newFormatPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__FORMAT_POLICY, oldFormatPolicy, formatPolicy));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getDefaultTemplate() {
		return defaultTemplate;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setDefaultTemplate(String newDefaultTemplate) {
		String oldDefaultTemplate = defaultTemplate;
		defaultTemplate = newDefaultTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE, oldDefaultTemplate, defaultTemplate));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Template getParseRule() {
		if (eContainerFeatureID() != TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE) return null;
		return (Template)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParseRule(Template newParseRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParseRule, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE, msgs);
		return msgs;
	}

								/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setParseRule(Template newParseRule) {
		if (newParseRule != eInternalContainer() || (eContainerFeatureID() != TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE && newParseRule != null)) {
			if (EcoreUtil.isAncestor(this, newParseRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParseRule != null)
				msgs = ((InternalEObject)newParseRule).eInverseAdd(this, TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION, Template.class, msgs);
			msgs = basicSetParseRule(newParseRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE, newParseRule, newParseRule));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextBlockDefinition getContext() {
		if (eContainerFeatureID() != TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT) return null;
		return (TextBlockDefinition)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetContext(TextBlockDefinition newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT, msgs);
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setContext(TextBlockDefinition newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID() != TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS, TextBlockDefinition.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT, newContext, newContext));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<TextBlockDefinition> getSubDefinitions() {
		if (subDefinitions == null) {
			subDefinitions = new EObjectContainmentWithInverseEList<TextBlockDefinition>(TextBlockDefinition.class, this, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT);
		}
		return subDefinitions;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextBlockDefinition getGeneralisation() {
		if (generalisation != null && generalisation.eIsProxy()) {
			InternalEObject oldGeneralisation = (InternalEObject)generalisation;
			generalisation = (TextBlockDefinition)eResolveProxy(oldGeneralisation);
			if (generalisation != oldGeneralisation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__GENERALISATION, oldGeneralisation, generalisation));
			}
		}
		return generalisation;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextBlockDefinition basicGetGeneralisation() {
		return generalisation;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setGeneralisation(TextBlockDefinition newGeneralisation) {
		TextBlockDefinition oldGeneralisation = generalisation;
		generalisation = newGeneralisation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__GENERALISATION, oldGeneralisation, generalisation));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getName() {
		return name;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__NAME, oldName, name));
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
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParseRule((Template)otherEnd, msgs);
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((TextBlockDefinition)otherEnd, msgs);
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubDefinitions()).basicAdd(otherEnd, msgs);
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
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE:
				return basicSetParseRule(null, msgs);
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT:
				return basicSetContext(null, msgs);
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS:
				return ((InternalEList<?>)getSubDefinitions()).basicRemove(otherEnd, msgs);
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
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE:
				return eInternalContainer().eInverseRemove(this, TCSPackage.TEMPLATE__TEXT_BLOCK_DEFINITION, Template.class, msgs);
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT:
				return eInternalContainer().eInverseRemove(this, TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS, TextBlockDefinition.class, msgs);
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
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__FORMAT_POLICY:
				return getFormatPolicy();
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE:
				return getDefaultTemplate();
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE:
				return getParseRule();
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT:
				return getContext();
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS:
				return getSubDefinitions();
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__GENERALISATION:
				if (resolve) return getGeneralisation();
				return basicGetGeneralisation();
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__NAME:
				return getName();
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
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__FORMAT_POLICY:
				setFormatPolicy((FormatPolicy)newValue);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE:
				setDefaultTemplate((String)newValue);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE:
				setParseRule((Template)newValue);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT:
				setContext((TextBlockDefinition)newValue);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS:
				getSubDefinitions().clear();
				getSubDefinitions().addAll((Collection<? extends TextBlockDefinition>)newValue);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__GENERALISATION:
				setGeneralisation((TextBlockDefinition)newValue);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__NAME:
				setName((String)newValue);
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
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__FORMAT_POLICY:
				setFormatPolicy(FORMAT_POLICY_EDEFAULT);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE:
				setDefaultTemplate(DEFAULT_TEMPLATE_EDEFAULT);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE:
				setParseRule((Template)null);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT:
				setContext((TextBlockDefinition)null);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS:
				getSubDefinitions().clear();
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__GENERALISATION:
				setGeneralisation((TextBlockDefinition)null);
				return;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
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
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__FORMAT_POLICY:
				return formatPolicy != FORMAT_POLICY_EDEFAULT;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__DEFAULT_TEMPLATE:
				return DEFAULT_TEMPLATE_EDEFAULT == null ? defaultTemplate != null : !DEFAULT_TEMPLATE_EDEFAULT.equals(defaultTemplate);
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__PARSE_RULE:
				return getParseRule() != null;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__CONTEXT:
				return getContext() != null;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__SUB_DEFINITIONS:
				return subDefinitions != null && !subDefinitions.isEmpty();
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__GENERALISATION:
				return generalisation != null;
			case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (formatPolicy: ");
		result.append(formatPolicy);
		result.append(", defaultTemplate: ");
		result.append(defaultTemplate);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TextBlockDefinitionImpl
