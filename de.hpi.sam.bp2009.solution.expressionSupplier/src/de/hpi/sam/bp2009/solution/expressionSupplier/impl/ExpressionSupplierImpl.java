/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.expressionSupplier.impl;

import de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplier;
import de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierPackage;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Supplier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierImpl#getAnalyzer <em>Analyzer</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierImpl#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionSupplierImpl extends EObjectImpl implements ExpressionSupplier {
	/**
	 * The cached value of the '{@link #getAnalyzer() <em>Analyzer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzer()
	 * @generated
	 * @ordered
	 */
	protected ImpactAnalyzer analyzer;

	/**
	 * The cached value of the '{@link #getQueries() <em>Queries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueries()
	 * @generated
	 * @ordered
	 */
	protected EList<OclQuery> queries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionSupplierImpl() {
		super();
		this.setAnalyzer(ImpactAnalyzerFactory.eINSTANCE.createImpactAnalyzer());

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionSupplierPackage.Literals.EXPRESSION_SUPPLIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactAnalyzer getAnalyzer() {
		if (analyzer != null && analyzer.eIsProxy()) {
			InternalEObject oldAnalyzer = (InternalEObject)analyzer;
			analyzer = (ImpactAnalyzer)eResolveProxy(oldAnalyzer);
			if (analyzer != oldAnalyzer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionSupplierPackage.EXPRESSION_SUPPLIER__ANALYZER, oldAnalyzer, analyzer));
			}
		}
		return analyzer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactAnalyzer basicGetAnalyzer() {
		return analyzer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalyzer(ImpactAnalyzer newAnalyzer) {
		ImpactAnalyzer oldAnalyzer = analyzer;
		analyzer = newAnalyzer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionSupplierPackage.EXPRESSION_SUPPLIER__ANALYZER, oldAnalyzer, analyzer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclQuery> getQueries() {
		return queries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueries(EList<OclQuery> newQueries) {
		EList<OclQuery> oldQueries = queries;
		queries = newQueries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionSupplierPackage.EXPRESSION_SUPPLIER__QUERIES, oldQueries, queries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__ANALYZER:
				if (resolve) return getAnalyzer();
				return basicGetAnalyzer();
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__QUERIES:
				return getQueries();
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
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__ANALYZER:
				setAnalyzer((ImpactAnalyzer)newValue);
				return;
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__QUERIES:
				setQueries((EList<OclQuery>)newValue);
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
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__ANALYZER:
				setAnalyzer((ImpactAnalyzer)null);
				return;
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__QUERIES:
				setQueries((EList<OclQuery>)null);
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
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__ANALYZER:
				return analyzer != null;
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER__QUERIES:
				return queries != null;
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
		result.append(" (queries: ");
		result.append(queries);
		result.append(')');
		return result.toString();
	}

} //ExpressionSupplierImpl
