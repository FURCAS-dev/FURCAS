/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package solution.impl;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import solution.ExpressionSupplier;
import solution.SolutionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Supplier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link solution.impl.ExpressionSupplierImpl#getIA <em>IA</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionSupplierImpl extends EObjectImpl implements ExpressionSupplier {
	/**
	 * The cached value of the '{@link #getIA() <em>IA</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIA()
	 * @generated
	 * @ordered
	 */
	protected ImpactAnalyzer ia;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionSupplierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.EXPRESSION_SUPPLIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactAnalyzer getIA() {
		if (ia != null && ia.eIsProxy()) {
			InternalEObject oldIA = (InternalEObject)ia;
			ia = (ImpactAnalyzer)eResolveProxy(oldIA);
			if (ia != oldIA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionPackage.EXPRESSION_SUPPLIER__IA, oldIA, ia));
			}
		}
		return ia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactAnalyzer basicGetIA() {
		return ia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIA(ImpactAnalyzer newIA) {
		ImpactAnalyzer oldIA = ia;
		ia = newIA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.EXPRESSION_SUPPLIER__IA, oldIA, ia));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SolutionPackage.EXPRESSION_SUPPLIER__IA:
				if (resolve) return getIA();
				return basicGetIA();
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
			case SolutionPackage.EXPRESSION_SUPPLIER__IA:
				setIA((ImpactAnalyzer)newValue);
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
			case SolutionPackage.EXPRESSION_SUPPLIER__IA:
				setIA((ImpactAnalyzer)null);
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
			case SolutionPackage.EXPRESSION_SUPPLIER__IA:
				return ia != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpressionSupplierImpl
