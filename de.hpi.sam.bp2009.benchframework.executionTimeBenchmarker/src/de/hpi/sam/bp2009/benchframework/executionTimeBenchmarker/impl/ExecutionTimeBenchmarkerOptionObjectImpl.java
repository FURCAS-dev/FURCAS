/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl#getStartLiteral <em>Start Literal</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl#getClassLiteral <em>Class Literal</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl#getEndLiteral <em>End Literal</em>}</li>
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
	 * The default value of the '{@link #getStartLiteral() <em>Start Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final Integer START_LITERAL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStartLiteral() <em>Start Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLiteral()
	 * @generated
	 * @ordered
	 */
	protected Integer startLiteral = START_LITERAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getClassLiteral() <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final Integer CLASS_LITERAL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getClassLiteral() <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassLiteral()
	 * @generated
	 * @ordered
	 */
	protected Integer classLiteral = CLASS_LITERAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getEndLiteral() <em>End Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final Integer END_LITERAL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEndLiteral() <em>End Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLiteral()
	 * @generated
	 * @ordered
	 */
	protected Integer endLiteral = END_LITERAL_EDEFAULT;

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
	public Integer getStartLiteral() {
		return startLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLiteral(Integer newStartLiteral) {
		Integer oldStartLiteral = startLiteral;
		startLiteral = newStartLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__START_LITERAL, oldStartLiteral, startLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getClassLiteral() {
		return classLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassLiteral(Integer newClassLiteral) {
		Integer oldClassLiteral = classLiteral;
		classLiteral = newClassLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__CLASS_LITERAL, oldClassLiteral, classLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEndLiteral() {
		return endLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLiteral(Integer newEndLiteral) {
		Integer oldEndLiteral = endLiteral;
		endLiteral = newEndLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__END_LITERAL, oldEndLiteral, endLiteral));
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__START_LITERAL:
				return getStartLiteral();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__CLASS_LITERAL:
				return getClassLiteral();
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__END_LITERAL:
				return getEndLiteral();
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__START_LITERAL:
				setStartLiteral((Integer)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__CLASS_LITERAL:
				setClassLiteral((Integer)newValue);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__END_LITERAL:
				setEndLiteral((Integer)newValue);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__START_LITERAL:
				setStartLiteral(START_LITERAL_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__CLASS_LITERAL:
				setClassLiteral(CLASS_LITERAL_EDEFAULT);
				return;
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__END_LITERAL:
				setEndLiteral(END_LITERAL_EDEFAULT);
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
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__START_LITERAL:
				return START_LITERAL_EDEFAULT == null ? startLiteral != null : !START_LITERAL_EDEFAULT.equals(startLiteral);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__CLASS_LITERAL:
				return CLASS_LITERAL_EDEFAULT == null ? classLiteral != null : !CLASS_LITERAL_EDEFAULT.equals(classLiteral);
			case ExecutionTimeBenchmarkerPackage.EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__END_LITERAL:
				return END_LITERAL_EDEFAULT == null ? endLiteral != null : !END_LITERAL_EDEFAULT.equals(endLiteral);
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
		result.append(", startLiteral: ");
		result.append(startLiteral);
		result.append(", classLiteral: ");
		result.append(classLiteral);
		result.append(", endLiteral: ");
		result.append(endLiteral);
		result.append(')');
		return result.toString();
	}

	@Override
	public ExecutionTimeBenchmarkerOptionObject clone() throws CloneNotSupportedException {
		return (ExecutionTimeBenchmarkerOptionObject) EcoreUtil.copy(this);
	}
} //ExecutionTimeBenchmarkerOptionObjectImpl
