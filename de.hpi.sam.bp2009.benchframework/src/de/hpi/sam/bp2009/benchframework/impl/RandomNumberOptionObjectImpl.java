/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.WizardPage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Number Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.RandomNumberOptionObjectImpl#getWizardPage <em>Wizard Page</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.RandomNumberOptionObjectImpl#getNumberListIndex <em>Number List Index</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.RandomNumberOptionObjectImpl#getNumberList <em>Number List</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.RandomNumberOptionObjectImpl#getNumberGenerator <em>Number Generator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomNumberOptionObjectImpl extends EObjectImpl implements RandomNumberOptionObject {
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
	 * The default value of the '{@link #getNumberListIndex() <em>Number List Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberListIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_LIST_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberListIndex() <em>Number List Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberListIndex()
	 * @generated
	 * @ordered
	 */
	protected int numberListIndex = NUMBER_LIST_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNumberList() <em>Number List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberList()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> numberList;

	/**
	 * The default value of the '{@link #getNumberGenerator() <em>Number Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberGenerator()
	 * @generated
	 * @ordered
	 */
	protected static final Random NUMBER_GENERATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberGenerator() <em>Number Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberGenerator()
	 * @generated
	 * @ordered
	 */
	protected Random numberGenerator = NUMBER_GENERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RandomNumberOptionObjectImpl() {
		super();
		setNumberListIndex(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BenchframeworkPackage.Literals.RANDOM_NUMBER_OPTION_OBJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__WIZARD_PAGE, oldWizardPage, wizardPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberListIndex() {
		return numberListIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberListIndex(int newNumberListIndex) {
		int oldNumberListIndex = numberListIndex;
		numberListIndex = newNumberListIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST_INDEX, oldNumberListIndex, numberListIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method is lazy, that means if there is no numberList to get, then we initialize one and return it, else we return the existing one.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Integer> getNumberList() {
		if (numberList == null)
			setNumberList(new BasicEList<Integer>());
		return numberList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberList(EList<Integer> newNumberList) {
		EList<Integer> oldNumberList = numberList;
		numberList = newNumberList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST, oldNumberList, numberList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method is lazy, that means if there is no numberGenerator to get, then we initialize one and return it, else we return the existing one.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Random getNumberGenerator() {
		if (numberGenerator == null)
			setNumberGenerator(new Random());
		return numberGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberGenerator(Random newNumberGenerator) {
		Random oldNumberGenerator = numberGenerator;
		numberGenerator = newNumberGenerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_GENERATOR, oldNumberGenerator, numberGenerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Return the number at the '{@link #getNumberListIndex() <em>Number List Index</em>}' of the '{@link #getNumberList() <em>Number List</em>}'.
	 * If there is no entry for the given '{@link #getNumberListIndex() <em>Number List Index</em>}', a random number between 0 and upperLimit is generated and filled into the list.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @see #getNumberListIndex(), #getNumberList()
	 */
	public Integer getNextInt(Integer upperLimit) {
		int number;
		if (getNumberList().size() <= getNumberListIndex()){
			number = getNumberGenerator().nextInt(upperLimit);
			getNumberList().add(number);	
		}else
			number = getNumberList().get(getNumberListIndex());
		setNumberListIndex(getNumberListIndex() + 1);
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Return the number at the '{@link #getNumberListIndex() <em>Number List Index</em>}' of the '{@link #getNumberList() <em>Number List</em>}'.
	 * If there is no entry for the given '{@link #getNumberListIndex() <em>Number List Index</em>}', a random number is generated and filled into the list.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Integer getNextInt() {
		if (getNumberList().size() <= getNumberListIndex()){
			int number = getNumberGenerator().nextInt();
			getNumberList().add(number);
			setNumberListIndex(getNumberListIndex() + 1);
			return number;
		}
		return getNumberList().get(getNumberListIndex());
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
	public RandomNumberOptionObject clone() throws CloneNotSupportedException {
		return (RandomNumberOptionObject) EcoreUtil.copy(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__WIZARD_PAGE:
				return getWizardPage();
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST_INDEX:
				return getNumberListIndex();
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST:
				return getNumberList();
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_GENERATOR:
				return getNumberGenerator();
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
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage((WizardPage)newValue);
				return;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST_INDEX:
				setNumberListIndex((Integer)newValue);
				return;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST:
				setNumberList((EList<Integer>)newValue);
				return;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_GENERATOR:
				setNumberGenerator((Random)newValue);
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
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage(WIZARD_PAGE_EDEFAULT);
				return;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST_INDEX:
				setNumberListIndex(NUMBER_LIST_INDEX_EDEFAULT);
				return;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST:
				setNumberList((EList<Integer>)null);
				return;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_GENERATOR:
				setNumberGenerator(NUMBER_GENERATOR_EDEFAULT);
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
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__WIZARD_PAGE:
				return WIZARD_PAGE_EDEFAULT == null ? wizardPage != null : !WIZARD_PAGE_EDEFAULT.equals(wizardPage);
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST_INDEX:
				return numberListIndex != NUMBER_LIST_INDEX_EDEFAULT;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_LIST:
				return numberList != null;
			case BenchframeworkPackage.RANDOM_NUMBER_OPTION_OBJECT__NUMBER_GENERATOR:
				return NUMBER_GENERATOR_EDEFAULT == null ? numberGenerator != null : !NUMBER_GENERATOR_EDEFAULT.equals(numberGenerator);
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
		result.append(", numberListIndex: ");
		result.append(numberListIndex);
		result.append(", numberList: ");
		result.append(numberList);
		result.append(", numberGenerator: ");
		result.append(numberGenerator);
		result.append(')');
		return result.toString();
	}

} //RandomNumberOptionObjectImpl
