/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.RequiredInterfaceTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl#getRequireingSyntax <em>Requireing Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl#getProvidingSyntax <em>Providing Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl#getRequiredTemplate <em>Required Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl#getProvidedTemplate <em>Provided Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.BindingImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingImpl extends EObjectImpl implements Binding {
	/**
	 * The cached value of the '{@link #getRequireingSyntax() <em>Requireing Syntax</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequireingSyntax()
	 * @generated
	 * @ordered
	 */
	protected ConcreteSyntax requireingSyntax;

	/**
	 * The cached value of the '{@link #getProvidingSyntax() <em>Providing Syntax</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidingSyntax()
	 * @generated
	 * @ordered
	 */
	protected ConcreteSyntax providingSyntax;

	/**
	 * The cached value of the '{@link #getRequiredTemplate() <em>Required Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredTemplate()
	 * @generated
	 * @ordered
	 */
	protected RequiredInterfaceTemplate requiredTemplate;

	/**
	 * The cached value of the '{@link #getProvidedTemplate() <em>Provided Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedTemplate()
	 * @generated
	 * @ordered
	 */
	protected Template providedTemplate;

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
	protected BindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InterfaceconfigurationPackage.Literals.BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntax getRequireingSyntax() {
		if (requireingSyntax != null && requireingSyntax.eIsProxy()) {
			InternalEObject oldRequireingSyntax = (InternalEObject)requireingSyntax;
			requireingSyntax = (ConcreteSyntax)eResolveProxy(oldRequireingSyntax);
			if (requireingSyntax != oldRequireingSyntax) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InterfaceconfigurationPackage.BINDING__REQUIREING_SYNTAX, oldRequireingSyntax, requireingSyntax));
			}
		}
		return requireingSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntax basicGetRequireingSyntax() {
		return requireingSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequireingSyntax(ConcreteSyntax newRequireingSyntax) {
		ConcreteSyntax oldRequireingSyntax = requireingSyntax;
		requireingSyntax = newRequireingSyntax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InterfaceconfigurationPackage.BINDING__REQUIREING_SYNTAX, oldRequireingSyntax, requireingSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntax getProvidingSyntax() {
		if (providingSyntax != null && providingSyntax.eIsProxy()) {
			InternalEObject oldProvidingSyntax = (InternalEObject)providingSyntax;
			providingSyntax = (ConcreteSyntax)eResolveProxy(oldProvidingSyntax);
			if (providingSyntax != oldProvidingSyntax) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InterfaceconfigurationPackage.BINDING__PROVIDING_SYNTAX, oldProvidingSyntax, providingSyntax));
			}
		}
		return providingSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntax basicGetProvidingSyntax() {
		return providingSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingSyntax(ConcreteSyntax newProvidingSyntax) {
		ConcreteSyntax oldProvidingSyntax = providingSyntax;
		providingSyntax = newProvidingSyntax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InterfaceconfigurationPackage.BINDING__PROVIDING_SYNTAX, oldProvidingSyntax, providingSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredInterfaceTemplate getRequiredTemplate() {
		if (requiredTemplate != null && requiredTemplate.eIsProxy()) {
			InternalEObject oldRequiredTemplate = (InternalEObject)requiredTemplate;
			requiredTemplate = (RequiredInterfaceTemplate)eResolveProxy(oldRequiredTemplate);
			if (requiredTemplate != oldRequiredTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InterfaceconfigurationPackage.BINDING__REQUIRED_TEMPLATE, oldRequiredTemplate, requiredTemplate));
			}
		}
		return requiredTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredInterfaceTemplate basicGetRequiredTemplate() {
		return requiredTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredTemplate(RequiredInterfaceTemplate newRequiredTemplate) {
		RequiredInterfaceTemplate oldRequiredTemplate = requiredTemplate;
		requiredTemplate = newRequiredTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InterfaceconfigurationPackage.BINDING__REQUIRED_TEMPLATE, oldRequiredTemplate, requiredTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getProvidedTemplate() {
		if (providedTemplate != null && providedTemplate.eIsProxy()) {
			InternalEObject oldProvidedTemplate = (InternalEObject)providedTemplate;
			providedTemplate = (Template)eResolveProxy(oldProvidedTemplate);
			if (providedTemplate != oldProvidedTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InterfaceconfigurationPackage.BINDING__PROVIDED_TEMPLATE, oldProvidedTemplate, providedTemplate));
			}
		}
		return providedTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template basicGetProvidedTemplate() {
		return providedTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedTemplate(Template newProvidedTemplate) {
		Template oldProvidedTemplate = providedTemplate;
		providedTemplate = newProvidedTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InterfaceconfigurationPackage.BINDING__PROVIDED_TEMPLATE, oldProvidedTemplate, providedTemplate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, InterfaceconfigurationPackage.BINDING__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InterfaceconfigurationPackage.BINDING__REQUIREING_SYNTAX:
				if (resolve) return getRequireingSyntax();
				return basicGetRequireingSyntax();
			case InterfaceconfigurationPackage.BINDING__PROVIDING_SYNTAX:
				if (resolve) return getProvidingSyntax();
				return basicGetProvidingSyntax();
			case InterfaceconfigurationPackage.BINDING__REQUIRED_TEMPLATE:
				if (resolve) return getRequiredTemplate();
				return basicGetRequiredTemplate();
			case InterfaceconfigurationPackage.BINDING__PROVIDED_TEMPLATE:
				if (resolve) return getProvidedTemplate();
				return basicGetProvidedTemplate();
			case InterfaceconfigurationPackage.BINDING__MODE:
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
			case InterfaceconfigurationPackage.BINDING__REQUIREING_SYNTAX:
				setRequireingSyntax((ConcreteSyntax)newValue);
				return;
			case InterfaceconfigurationPackage.BINDING__PROVIDING_SYNTAX:
				setProvidingSyntax((ConcreteSyntax)newValue);
				return;
			case InterfaceconfigurationPackage.BINDING__REQUIRED_TEMPLATE:
				setRequiredTemplate((RequiredInterfaceTemplate)newValue);
				return;
			case InterfaceconfigurationPackage.BINDING__PROVIDED_TEMPLATE:
				setProvidedTemplate((Template)newValue);
				return;
			case InterfaceconfigurationPackage.BINDING__MODE:
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
			case InterfaceconfigurationPackage.BINDING__REQUIREING_SYNTAX:
				setRequireingSyntax((ConcreteSyntax)null);
				return;
			case InterfaceconfigurationPackage.BINDING__PROVIDING_SYNTAX:
				setProvidingSyntax((ConcreteSyntax)null);
				return;
			case InterfaceconfigurationPackage.BINDING__REQUIRED_TEMPLATE:
				setRequiredTemplate((RequiredInterfaceTemplate)null);
				return;
			case InterfaceconfigurationPackage.BINDING__PROVIDED_TEMPLATE:
				setProvidedTemplate((Template)null);
				return;
			case InterfaceconfigurationPackage.BINDING__MODE:
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
			case InterfaceconfigurationPackage.BINDING__REQUIREING_SYNTAX:
				return requireingSyntax != null;
			case InterfaceconfigurationPackage.BINDING__PROVIDING_SYNTAX:
				return providingSyntax != null;
			case InterfaceconfigurationPackage.BINDING__REQUIRED_TEMPLATE:
				return requiredTemplate != null;
			case InterfaceconfigurationPackage.BINDING__PROVIDED_TEMPLATE:
				return providedTemplate != null;
			case InterfaceconfigurationPackage.BINDING__MODE:
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

} //BindingImpl
