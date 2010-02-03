/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import de.hpi.sam.bp2009.solution.eventManager.impl.EventNotificationImpl;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.QueryReevaluateNotification;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Reevaluate Notification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.QueryReevaluateNotificationImpl#getReevaluatedQueries <em>Reevaluated Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryReevaluateNotificationImpl extends EventNotificationImpl implements QueryReevaluateNotification {
	/**
	 * The cached value of the '{@link #getReevaluatedQueries() <em>Reevaluated Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReevaluatedQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<OclQuery> reevaluatedQueries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryReevaluateNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactAnalyzerPackage.Literals.QUERY_REEVALUATE_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclQuery> getReevaluatedQueries() {
		return reevaluatedQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReevaluatedQueries(EList<OclQuery> newReevaluatedQueries) {
		EList<OclQuery> oldReevaluatedQueries = reevaluatedQueries;
		reevaluatedQueries = newReevaluatedQueries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactAnalyzerPackage.QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES, oldReevaluatedQueries, reevaluatedQueries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpactAnalyzerPackage.QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES:
				return getReevaluatedQueries();
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
			case ImpactAnalyzerPackage.QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES:
				setReevaluatedQueries((EList<OclQuery>)newValue);
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
			case ImpactAnalyzerPackage.QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES:
				setReevaluatedQueries((EList<OclQuery>)null);
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
			case ImpactAnalyzerPackage.QUERY_REEVALUATE_NOTIFICATION__REEVALUATED_QUERIES:
				return reevaluatedQueries != null;
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
		result.append(" (reevaluatedQueries: ");
		result.append(reevaluatedQueries);
		result.append(')');
		return result.toString();
	}

} //QueryReevaluateNotificationImpl
