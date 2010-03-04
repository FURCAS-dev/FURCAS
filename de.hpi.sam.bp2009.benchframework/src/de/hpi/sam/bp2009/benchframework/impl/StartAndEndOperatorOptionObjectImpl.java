/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.WizardPage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.StartAndEndOperatorOptionObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start And End Operator Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartAndEndOperatorOptionObjectImpl#getWizardPage <em>Wizard Page</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartAndEndOperatorOptionObjectImpl#getOtherEnd <em>Other End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StartAndEndOperatorOptionObjectImpl extends EObjectImpl implements StartAndEndOperatorOptionObject {
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
	 * The cached value of the '{@link #getOtherEnd() <em>Other End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherEnd()
	 * @generated
	 * @ordered
	 */
	protected Operator otherEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartAndEndOperatorOptionObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BenchframeworkPackage.Literals.START_AND_END_OPERATOR_OPTION_OBJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__WIZARD_PAGE, oldWizardPage, wizardPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOtherEnd() {
		if (otherEnd != null && otherEnd.eIsProxy()) {
			InternalEObject oldOtherEnd = (InternalEObject)otherEnd;
			otherEnd = (Operator)eResolveProxy(oldOtherEnd);
			if (otherEnd != oldOtherEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__OTHER_END, oldOtherEnd, otherEnd));
			}
		}
		return otherEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator basicGetOtherEnd() {
		return otherEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherEnd(Operator newOtherEnd) {
		Operator oldOtherEnd = otherEnd;
		otherEnd = newOtherEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__OTHER_END, oldOtherEnd, otherEnd));
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
	public StartAndEndOperatorOptionObject clone() throws CloneNotSupportedException {
		return (StartAndEndOperatorOptionObject) EcoreUtil.copy(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__WIZARD_PAGE:
				return getWizardPage();
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__OTHER_END:
				if (resolve) return getOtherEnd();
				return basicGetOtherEnd();
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
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage((WizardPage)newValue);
				return;
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__OTHER_END:
				setOtherEnd((Operator)newValue);
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
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage(WIZARD_PAGE_EDEFAULT);
				return;
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__OTHER_END:
				setOtherEnd((Operator)null);
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
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__WIZARD_PAGE:
				return WIZARD_PAGE_EDEFAULT == null ? wizardPage != null : !WIZARD_PAGE_EDEFAULT.equals(wizardPage);
			case BenchframeworkPackage.START_AND_END_OPERATOR_OPTION_OBJECT__OTHER_END:
				return otherEnd != null;
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

} //StartAndEndOperatorOptionObjectImpl
