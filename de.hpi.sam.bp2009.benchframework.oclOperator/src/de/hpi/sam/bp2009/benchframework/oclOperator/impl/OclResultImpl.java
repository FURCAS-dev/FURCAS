/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclResultImpl#getQueriesToResults <em>Queries To Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclResultImpl extends ResultObjectImpl implements OclResult {
	/**
	 * The cached value of the '{@link #getQueriesToResults() <em>Queries To Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueriesToResults()
	 * @generated
	 * @ordered
	 */
	protected Map<String, IQueryResult> queriesToResults;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclOperatorPackage.Literals.OCL_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, IQueryResult> getQueriesToResults() {
		return queriesToResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueriesToResults(Map<String, IQueryResult> newQueriesToResults) {
		Map<String, IQueryResult> oldQueriesToResults = queriesToResults;
		queriesToResults = newQueriesToResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_RESULT__QUERIES_TO_RESULTS, oldQueriesToResults, queriesToResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OclOperatorPackage.OCL_RESULT__QUERIES_TO_RESULTS:
				return getQueriesToResults();
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
			case OclOperatorPackage.OCL_RESULT__QUERIES_TO_RESULTS:
				setQueriesToResults((Map<String, IQueryResult>)newValue);
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
			case OclOperatorPackage.OCL_RESULT__QUERIES_TO_RESULTS:
				setQueriesToResults((Map<String, IQueryResult>)null);
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
			case OclOperatorPackage.OCL_RESULT__QUERIES_TO_RESULTS:
				return queriesToResults != null;
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
		result.append(" (queriesToResults: ");
		result.append(queriesToResults);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Composite getComposite(Composite parent) {
		Composite composite = super.getComposite(parent);
		if(queriesToResults==null)
			return composite;
		for(Entry<String, IQueryResult> entry:queriesToResults.entrySet()){
			Label label1 = new Label(composite, SWT.CENTER);
			label1.setText(entry.getKey() +" : "+entry.getValue());
		}
		return composite;
	}
} //OclResultImpl
