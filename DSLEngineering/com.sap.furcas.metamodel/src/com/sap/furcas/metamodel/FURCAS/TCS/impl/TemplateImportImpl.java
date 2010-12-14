/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImportImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TemplateImportImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateImportImpl extends ImportDeclarationImpl implements TemplateImport {
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
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MODE_EDEFAULT = null;
				/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected String mode = MODE_EDEFAULT;

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TemplateImportImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return TCSPackage.Literals.TEMPLATE_IMPORT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.TEMPLATE_IMPORT__TEMPLATE, oldTemplate, template));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE_IMPORT__TEMPLATE, oldTemplate, template));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMode() {
		return mode;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TEMPLATE_IMPORT__MODE, oldMode, mode));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.TEMPLATE_IMPORT__TEMPLATE:
				if (resolve) return getTemplate();
				return basicGetTemplate();
			case TCSPackage.TEMPLATE_IMPORT__MODE:
				return getMode();
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
			case TCSPackage.TEMPLATE_IMPORT__TEMPLATE:
				setTemplate((Template)newValue);
				return;
			case TCSPackage.TEMPLATE_IMPORT__MODE:
				setMode((String)newValue);
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
			case TCSPackage.TEMPLATE_IMPORT__TEMPLATE:
				setTemplate((Template)null);
				return;
			case TCSPackage.TEMPLATE_IMPORT__MODE:
				setMode(MODE_EDEFAULT);
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
			case TCSPackage.TEMPLATE_IMPORT__TEMPLATE:
				return template != null;
			case TCSPackage.TEMPLATE_IMPORT__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
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
		result.append(" (mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //TemplateImportImpl
