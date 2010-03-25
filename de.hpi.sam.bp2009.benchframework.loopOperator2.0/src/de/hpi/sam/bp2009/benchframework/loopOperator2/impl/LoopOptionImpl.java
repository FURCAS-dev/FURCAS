/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOptionImpl#getRepetitions <em>Repetitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopOptionImpl extends OptionObjectImpl implements LoopOption {
	/**
	 * The default value of the '{@link #getRepetitions() <em>Repetitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitions()
	 * @generated
	 * @ordered
	 */
	protected static final Integer REPETITIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepetitions() <em>Repetitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitions()
	 * @generated
	 * @ordered
	 */
	protected Integer repetitions = REPETITIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LoopOptionImpl() {
		super();
		setWizardPage(new ConfigureRepetitions(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoopOperator2Package.Literals.LOOP_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getRepetitions() {
		return repetitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepetitions(Integer newRepetitions) {
		Integer oldRepetitions = repetitions;
		repetitions = newRepetitions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoopOperator2Package.LOOP_OPTION__REPETITIONS, oldRepetitions, repetitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoopOperator2Package.LOOP_OPTION__REPETITIONS:
				return getRepetitions();
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
			case LoopOperator2Package.LOOP_OPTION__REPETITIONS:
				setRepetitions((Integer)newValue);
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
			case LoopOperator2Package.LOOP_OPTION__REPETITIONS:
				setRepetitions(REPETITIONS_EDEFAULT);
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
			case LoopOperator2Package.LOOP_OPTION__REPETITIONS:
				return REPETITIONS_EDEFAULT == null ? repetitions != null : !REPETITIONS_EDEFAULT.equals(repetitions);
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
		result.append(" (repetitions: ");
		result.append(repetitions);
		result.append(')');
		return result.toString();
	}

} //LoopOptionImpl
