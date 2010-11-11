/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl#getTemplateName <em>Template Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl#getTokenName <em>Token Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl#getSerializer <em>Serializer</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PrimitiveTemplateImpl#isOrKeyword <em>Or Keyword</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveTemplateImpl extends TemplateImpl implements PrimitiveTemplate {
        /**
	 * The default value of the '{@link #getTemplateName() <em>Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getTemplateName()
	 * @generated
	 * @ordered
	 */
        protected static final String TEMPLATE_NAME_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getTemplateName() <em>Template Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getTemplateName()
	 * @generated
	 * @ordered
	 */
        protected String templateName = TEMPLATE_NAME_EDEFAULT;

        /**
	 * The default value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsDefault()
	 * @generated
	 * @ordered
	 */
        protected static final boolean IS_DEFAULT_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsDefault()
	 * @generated
	 * @ordered
	 */
        protected boolean isDefault = IS_DEFAULT_EDEFAULT;

        /**
	 * The default value of the '{@link #getTokenName() <em>Token Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getTokenName()
	 * @generated
	 * @ordered
	 */
        protected static final String TOKEN_NAME_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getTokenName() <em>Token Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getTokenName()
	 * @generated
	 * @ordered
	 */
        protected String tokenName = TOKEN_NAME_EDEFAULT;

        /**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
        protected static final String VALUE_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
        protected String value = VALUE_EDEFAULT;

        /**
	 * The default value of the '{@link #getSerializer() <em>Serializer</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getSerializer()
	 * @generated
	 * @ordered
	 */
        protected static final String SERIALIZER_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getSerializer() <em>Serializer</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getSerializer()
	 * @generated
	 * @ordered
	 */
        protected String serializer = SERIALIZER_EDEFAULT;

        /**
	 * The default value of the '{@link #isOrKeyword() <em>Or Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isOrKeyword()
	 * @generated
	 * @ordered
	 */
        protected static final boolean OR_KEYWORD_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isOrKeyword() <em>Or Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isOrKeyword()
	 * @generated
	 * @ordered
	 */
        protected boolean orKeyword = OR_KEYWORD_EDEFAULT;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected PrimitiveTemplateImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.PRIMITIVE_TEMPLATE;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getTemplateName() {
		return templateName;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setTemplateName(String newTemplateName) {
		String oldTemplateName = templateName;
		templateName = newTemplateName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIMITIVE_TEMPLATE__TEMPLATE_NAME, oldTemplateName, templateName));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isIsDefault() {
		return isDefault;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIsDefault(boolean newIsDefault) {
		boolean oldIsDefault = isDefault;
		isDefault = newIsDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIMITIVE_TEMPLATE__IS_DEFAULT, oldIsDefault, isDefault));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getTokenName() {
		return tokenName;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setTokenName(String newTokenName) {
		String oldTokenName = tokenName;
		tokenName = newTokenName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIMITIVE_TEMPLATE__TOKEN_NAME, oldTokenName, tokenName));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getValue() {
		return value;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIMITIVE_TEMPLATE__VALUE, oldValue, value));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getSerializer() {
		return serializer;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setSerializer(String newSerializer) {
		String oldSerializer = serializer;
		serializer = newSerializer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIMITIVE_TEMPLATE__SERIALIZER, oldSerializer, serializer));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isOrKeyword() {
		return orKeyword;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setOrKeyword(boolean newOrKeyword) {
		boolean oldOrKeyword = orKeyword;
		orKeyword = newOrKeyword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PRIMITIVE_TEMPLATE__OR_KEYWORD, oldOrKeyword, orKeyword));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.PRIMITIVE_TEMPLATE__TEMPLATE_NAME:
				return getTemplateName();
			case TCSPackage.PRIMITIVE_TEMPLATE__IS_DEFAULT:
				return isIsDefault();
			case TCSPackage.PRIMITIVE_TEMPLATE__TOKEN_NAME:
				return getTokenName();
			case TCSPackage.PRIMITIVE_TEMPLATE__VALUE:
				return getValue();
			case TCSPackage.PRIMITIVE_TEMPLATE__SERIALIZER:
				return getSerializer();
			case TCSPackage.PRIMITIVE_TEMPLATE__OR_KEYWORD:
				return isOrKeyword();
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
			case TCSPackage.PRIMITIVE_TEMPLATE__TEMPLATE_NAME:
				setTemplateName((String)newValue);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__IS_DEFAULT:
				setIsDefault((Boolean)newValue);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__TOKEN_NAME:
				setTokenName((String)newValue);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__VALUE:
				setValue((String)newValue);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__SERIALIZER:
				setSerializer((String)newValue);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__OR_KEYWORD:
				setOrKeyword((Boolean)newValue);
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
			case TCSPackage.PRIMITIVE_TEMPLATE__TEMPLATE_NAME:
				setTemplateName(TEMPLATE_NAME_EDEFAULT);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__IS_DEFAULT:
				setIsDefault(IS_DEFAULT_EDEFAULT);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__TOKEN_NAME:
				setTokenName(TOKEN_NAME_EDEFAULT);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__SERIALIZER:
				setSerializer(SERIALIZER_EDEFAULT);
				return;
			case TCSPackage.PRIMITIVE_TEMPLATE__OR_KEYWORD:
				setOrKeyword(OR_KEYWORD_EDEFAULT);
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
			case TCSPackage.PRIMITIVE_TEMPLATE__TEMPLATE_NAME:
				return TEMPLATE_NAME_EDEFAULT == null ? templateName != null : !TEMPLATE_NAME_EDEFAULT.equals(templateName);
			case TCSPackage.PRIMITIVE_TEMPLATE__IS_DEFAULT:
				return isDefault != IS_DEFAULT_EDEFAULT;
			case TCSPackage.PRIMITIVE_TEMPLATE__TOKEN_NAME:
				return TOKEN_NAME_EDEFAULT == null ? tokenName != null : !TOKEN_NAME_EDEFAULT.equals(tokenName);
			case TCSPackage.PRIMITIVE_TEMPLATE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case TCSPackage.PRIMITIVE_TEMPLATE__SERIALIZER:
				return SERIALIZER_EDEFAULT == null ? serializer != null : !SERIALIZER_EDEFAULT.equals(serializer);
			case TCSPackage.PRIMITIVE_TEMPLATE__OR_KEYWORD:
				return orKeyword != OR_KEYWORD_EDEFAULT;
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
		result.append(" (templateName: ");
		result.append(templateName);
		result.append(", isDefault: ");
		result.append(isDefault);
		result.append(", tokenName: ");
		result.append(tokenName);
		result.append(", value: ");
		result.append(value);
		result.append(", serializer: ");
		result.append(serializer);
		result.append(", orKeyword: ");
		result.append(orKeyword);
		result.append(')');
		return result.toString();
	}

} //PrimitiveTemplateImpl
