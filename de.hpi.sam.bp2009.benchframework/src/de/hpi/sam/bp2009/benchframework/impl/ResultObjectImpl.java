/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.ResultObject;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.swt.widgets.Composite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl#getResultDisplay <em>Result Display</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultObjectImpl extends EObjectImpl implements ResultObject {
	/**
	 * The default value of the '{@link #getResultDisplay() <em>Result Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultDisplay()
	 * @generated
	 * @ordered
	 */
	protected static final Composite RESULT_DISPLAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultDisplay() <em>Result Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultDisplay()
	 * @generated
	 * @ordered
	 */
	protected Composite resultDisplay = RESULT_DISPLAY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BenchframeworkPackage.Literals.RESULT_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composite getResultDisplay() {
		return resultDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultDisplay(Composite newResultDisplay) {
		Composite oldResultDisplay = resultDisplay;
		resultDisplay = newResultDisplay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.RESULT_OBJECT__RESULT_DISPLAY, oldResultDisplay, resultDisplay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Object> getPropertyMap() {
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
			case BenchframeworkPackage.RESULT_OBJECT__RESULT_DISPLAY:
				return getResultDisplay();
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
			case BenchframeworkPackage.RESULT_OBJECT__RESULT_DISPLAY:
				setResultDisplay((Composite)newValue);
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
			case BenchframeworkPackage.RESULT_OBJECT__RESULT_DISPLAY:
				setResultDisplay(RESULT_DISPLAY_EDEFAULT);
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
			case BenchframeworkPackage.RESULT_OBJECT__RESULT_DISPLAY:
				return RESULT_DISPLAY_EDEFAULT == null ? resultDisplay != null : !RESULT_DISPLAY_EDEFAULT.equals(resultDisplay);
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
		result.append(" (resultDisplay: ");
		result.append(resultDisplay);
		result.append(')');
		return result.toString();
	}

} //ResultObjectImpl
