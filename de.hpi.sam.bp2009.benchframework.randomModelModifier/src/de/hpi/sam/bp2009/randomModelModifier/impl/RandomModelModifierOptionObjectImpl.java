/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.wizard.WizardPage;

import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage;
import de.hpi.sam.bp2009.randomModelModifier.tasks;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierOptionObjectImpl#getWizardPage <em>Wizard Page</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierOptionObjectImpl#getTimes <em>Times</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierOptionObjectImpl#getTask <em>Task</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomModelModifierOptionObjectImpl extends EObjectImpl implements RandomModelModifierOptionObject {
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
	 * The default value of the '{@link #getTimes() <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimes()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TIMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimes() <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimes()
	 * @generated
	 * @ordered
	 */
	protected Integer times = TIMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getTask() <em>Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected static final tasks TASK_EDEFAULT = tasks.CLASS_DELETE;

	/**
	 * The cached value of the '{@link #getTask() <em>Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected tasks task = TASK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomModelModifierOptionObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomModelModifierPackage.Literals.RANDOM_MODEL_MODIFIER_OPTION_OBJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__WIZARD_PAGE, oldWizardPage, wizardPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTimes() {
		return times;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimes(Integer newTimes) {
		Integer oldTimes = times;
		times = newTimes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES, oldTimes, times));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public tasks getTask() {
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTask(tasks newTask) {
		tasks oldTask = task;
		task = newTask == null ? TASK_EDEFAULT : newTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK, oldTask, task));
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__WIZARD_PAGE:
				return getWizardPage();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES:
				return getTimes();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK:
				return getTask();
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage((WizardPage)newValue);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES:
				setTimes((Integer)newValue);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK:
				setTask((tasks)newValue);
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage(WIZARD_PAGE_EDEFAULT);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES:
				setTimes(TIMES_EDEFAULT);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK:
				setTask(TASK_EDEFAULT);
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__WIZARD_PAGE:
				return WIZARD_PAGE_EDEFAULT == null ? wizardPage != null : !WIZARD_PAGE_EDEFAULT.equals(wizardPage);
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES:
				return TIMES_EDEFAULT == null ? times != null : !TIMES_EDEFAULT.equals(times);
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK:
				return task != TASK_EDEFAULT;
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
		result.append(", times: ");
		result.append(times);
		result.append(", task: ");
		result.append(task);
		result.append(')');
		return result.toString();
	}

} //RandomModelModifierOptionObjectImpl
