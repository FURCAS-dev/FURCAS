/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.wizard.WizardPage;

import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl#getWizardPage <em>Wizard Page</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTimeBenchmarkerOptionObjectImpl extends EObjectImpl implements ExecutionTimeBenchmarkerOptionObject {
	/**
	 * The default value of the '{@link #getWizardPage() <em>Wizard Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardPage()
	 * @generated
	 * @ordered
	 */
	protected static final WizardPage WIZARD_PAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getWizardPage() <em>Wizard Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardPage()
	 * @generated
	 * @ordered
	 */
	protected WizardPage wizardPage = WIZARD_PAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionTimeBenchmarkerOptionObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionTimeBenchmarkerPackage.Literals.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WizardPage getWizardPage() {
		return wizardPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWizardPage(WizardPage newWizardPage) {
		WizardPage oldWizardPage = wizardPage;
		wizardPage = newWizardPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__WIZARD_PAGE, oldWizardPage, wizardPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Object> getOptionsAsMap() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionsAsMap(Map<String, Object> map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__WIZARD_PAGE:
				return getWizardPage();
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage((WizardPage)newValue);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage(WIZARD_PAGE_EDEFAULT);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__WIZARD_PAGE:
				return WIZARD_PAGE_EDEFAULT == null ? wizardPage != null : !WIZARD_PAGE_EDEFAULT.equals(wizardPage);
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
		result.append(" (wizardPage: ");
		result.append(wizardPage);
		result.append(')');
		return result.toString();
	}

} //ExecutionTimeBenchmarkerOptionObjectImpl
