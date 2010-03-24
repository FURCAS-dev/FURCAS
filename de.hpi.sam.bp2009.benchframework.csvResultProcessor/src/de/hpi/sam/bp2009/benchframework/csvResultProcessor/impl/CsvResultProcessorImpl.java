/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl;

import de.hpi.sam.bp2009.benchframework.TestRun;

import de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessor;
import de.hpi.sam.bp2009.benchframework.csvResultProcessor.CsvResultProcessorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.wizard.WizardPage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Csv Result Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorImpl#getResultPage <em>Result Page</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorImpl#getTestrun <em>Testrun</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl.CsvResultProcessorImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CsvResultProcessorImpl extends EObjectImpl implements CsvResultProcessor {
	/**
	 * The default value of the '{@link #getResultPage() <em>Result Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultPage()
	 * @generated
	 * @ordered
	 */
	protected static final WizardPage RESULT_PAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultPage() <em>Result Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultPage()
	 * @generated
	 * @ordered
	 */
	protected WizardPage resultPage = RESULT_PAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTestrun() <em>Testrun</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestrun()
	 * @generated
	 * @ordered
	 */
	protected TestRun testrun;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	private static final String NAME = "CSV";

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
	 * @generated NOT
	 */
	public CsvResultProcessorImpl() {
		super();
		setName(NAME);
		setResultPage(new CsvResultPage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CsvResultProcessorPackage.Literals.CSV_RESULT_PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WizardPage getResultPage() {
		return resultPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultPage(WizardPage newResultPage) {
		WizardPage oldResultPage = resultPage;
		resultPage = newResultPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__RESULT_PAGE, oldResultPage, resultPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestrun() {
		if (testrun != null && testrun.eIsProxy()) {
			InternalEObject oldTestrun = (InternalEObject)testrun;
			testrun = (TestRun)eResolveProxy(oldTestrun);
			if (testrun != oldTestrun) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__TESTRUN, oldTestrun, testrun));
			}
		}
		return testrun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun basicGetTestrun() {
		return testrun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestrun(TestRun newTestrun) {
		TestRun oldTestrun = testrun;
		testrun = newTestrun;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__TESTRUN, oldTestrun, testrun));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__RESULT_PAGE:
				return getResultPage();
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__TESTRUN:
				if (resolve) return getTestrun();
				return basicGetTestrun();
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__NAME:
				return getName();
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
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__RESULT_PAGE:
				setResultPage((WizardPage)newValue);
				return;
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__TESTRUN:
				setTestrun((TestRun)newValue);
				return;
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__NAME:
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
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__RESULT_PAGE:
				setResultPage(RESULT_PAGE_EDEFAULT);
				return;
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__TESTRUN:
				setTestrun((TestRun)null);
				return;
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__NAME:
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
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__RESULT_PAGE:
				return RESULT_PAGE_EDEFAULT == null ? resultPage != null : !RESULT_PAGE_EDEFAULT.equals(resultPage);
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__TESTRUN:
				return testrun != null;
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR__NAME:
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
		result.append(" (resultPage: ");
		result.append(resultPage);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CsvResultProcessorImpl
