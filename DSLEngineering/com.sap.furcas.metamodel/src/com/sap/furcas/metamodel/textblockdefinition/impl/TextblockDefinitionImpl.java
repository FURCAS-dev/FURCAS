/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblockdefinition.impl;

import com.sap.furcas.metamodel.TCS.Template;

import com.sap.furcas.metamodel.textblockdefinition.FormatPolicy;
import com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition;
import com.sap.furcas.metamodel.textblockdefinition.TextblockdefinitionPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Textblock Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl#getFormatPolicy <em>Format Policy</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl#getDefaultTemplate <em>Default Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl#getParseRule <em>Parse Rule</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl#getContext <em>Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl#getSubDefinitions <em>Sub Definitions</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl#getGeneralisation <em>Generalisation</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblockdefinition.impl.TextblockDefinitionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextblockDefinitionImpl extends EObjectImpl implements TextblockDefinition {
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
	 * The cached value of the '{@link #getParseRule() <em>Parse Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParseRule()
	 * @generated
	 * @ordered
	 */
	protected Template parseRule;

	/**
	 * The cached value of the '{@link #getSubDefinitions() <em>Sub Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TextblockDefinition> subDefinitions;

	/**
	 * The cached value of the '{@link #getGeneralisation() <em>Generalisation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralisation()
	 * @generated
	 * @ordered
	 */
	protected TextblockDefinition generalisation;

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
	protected TextblockDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TextblockdefinitionPackage.Literals.TEXTBLOCK_DEFINITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__FORMAT_POLICY, oldFormatPolicy, formatPolicy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE, oldDefaultTemplate, defaultTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getParseRule() {
		if (parseRule != null && parseRule.eIsProxy()) {
			InternalEObject oldParseRule = (InternalEObject)parseRule;
			parseRule = (Template)eResolveProxy(oldParseRule);
			if (parseRule != oldParseRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__PARSE_RULE, oldParseRule, parseRule));
			}
		}
		return parseRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template basicGetParseRule() {
		return parseRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParseRule(Template newParseRule) {
		Template oldParseRule = parseRule;
		parseRule = newParseRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__PARSE_RULE, oldParseRule, parseRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextblockDefinition getContext() {
		if (eContainerFeatureID() != TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT) return null;
		return (TextblockDefinition)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(TextblockDefinition newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(TextblockDefinition newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID() != TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS, TextblockDefinition.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TextblockDefinition> getSubDefinitions() {
		if (subDefinitions == null) {
			subDefinitions = new EObjectContainmentWithInverseEList<TextblockDefinition>(TextblockDefinition.class, this, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT);
		}
		return subDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextblockDefinition getGeneralisation() {
		if (generalisation != null && generalisation.eIsProxy()) {
			InternalEObject oldGeneralisation = (InternalEObject)generalisation;
			generalisation = (TextblockDefinition)eResolveProxy(oldGeneralisation);
			if (generalisation != oldGeneralisation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__GENERALISATION, oldGeneralisation, generalisation));
			}
		}
		return generalisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextblockDefinition basicGetGeneralisation() {
		return generalisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralisation(TextblockDefinition newGeneralisation) {
		TextblockDefinition oldGeneralisation = generalisation;
		generalisation = newGeneralisation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__GENERALISATION, oldGeneralisation, generalisation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__NAME, oldName, name));
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
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((TextblockDefinition)otherEnd, msgs);
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS:
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
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT:
				return basicSetContext(null, msgs);
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS:
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
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT:
				return eInternalContainer().eInverseRemove(this, TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS, TextblockDefinition.class, msgs);
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
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__FORMAT_POLICY:
				return getFormatPolicy();
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE:
				return getDefaultTemplate();
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__PARSE_RULE:
				if (resolve) return getParseRule();
				return basicGetParseRule();
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT:
				return getContext();
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS:
				return getSubDefinitions();
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__GENERALISATION:
				if (resolve) return getGeneralisation();
				return basicGetGeneralisation();
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__NAME:
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
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__FORMAT_POLICY:
				setFormatPolicy((FormatPolicy)newValue);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE:
				setDefaultTemplate((String)newValue);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__PARSE_RULE:
				setParseRule((Template)newValue);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT:
				setContext((TextblockDefinition)newValue);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS:
				getSubDefinitions().clear();
				getSubDefinitions().addAll((Collection<? extends TextblockDefinition>)newValue);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__GENERALISATION:
				setGeneralisation((TextblockDefinition)newValue);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__NAME:
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
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__FORMAT_POLICY:
				setFormatPolicy(FORMAT_POLICY_EDEFAULT);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE:
				setDefaultTemplate(DEFAULT_TEMPLATE_EDEFAULT);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__PARSE_RULE:
				setParseRule((Template)null);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT:
				setContext((TextblockDefinition)null);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS:
				getSubDefinitions().clear();
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__GENERALISATION:
				setGeneralisation((TextblockDefinition)null);
				return;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__NAME:
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
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__FORMAT_POLICY:
				return formatPolicy != FORMAT_POLICY_EDEFAULT;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__DEFAULT_TEMPLATE:
				return DEFAULT_TEMPLATE_EDEFAULT == null ? defaultTemplate != null : !DEFAULT_TEMPLATE_EDEFAULT.equals(defaultTemplate);
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__PARSE_RULE:
				return parseRule != null;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__CONTEXT:
				return getContext() != null;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__SUB_DEFINITIONS:
				return subDefinitions != null && !subDefinitions.isEmpty();
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__GENERALISATION:
				return generalisation != null;
			case TextblockdefinitionPackage.TEXTBLOCK_DEFINITION__NAME:
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

} //TextblockDefinitionImpl
