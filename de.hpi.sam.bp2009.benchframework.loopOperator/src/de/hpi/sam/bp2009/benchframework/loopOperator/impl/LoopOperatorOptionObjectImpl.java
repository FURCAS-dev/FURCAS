/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorOptionObjectImpl#getLoopCount <em>Loop Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopOperatorOptionObjectImpl extends OptionObjectImpl implements LoopOperatorOptionObject {
	/**
	 * The default value of the '{@link #getLoopCount() <em>Loop Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCount()
	 * @generated
	 * @ordered
	 */
	protected static final int LOOP_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLoopCount() <em>Loop Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCount()
	 * @generated
	 * @ordered
	 */
	protected int loopCount = LOOP_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LoopOperatorOptionObjectImpl() {
		super();
		setWizardPage(new LoopOperatorEndWizardPage(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoopOperatorPackage.Literals.LOOP_OPERATOR_OPTION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLoopCount() {
		return loopCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopCount(int newLoopCount) {
		int oldLoopCount = loopCount;
		loopCount = newLoopCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoopOperatorPackage.LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT, oldLoopCount, loopCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoopOperatorPackage.LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT:
				return getLoopCount();
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
			case LoopOperatorPackage.LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT:
				setLoopCount((Integer)newValue);
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
			case LoopOperatorPackage.LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT:
				setLoopCount(LOOP_COUNT_EDEFAULT);
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
			case LoopOperatorPackage.LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT:
				return loopCount != LOOP_COUNT_EDEFAULT;
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
		result.append(" (loopCount: ");
		result.append(loopCount);
		result.append(')');
		return result.toString();
	}

} //LoopOperatorOptionObjectImpl
