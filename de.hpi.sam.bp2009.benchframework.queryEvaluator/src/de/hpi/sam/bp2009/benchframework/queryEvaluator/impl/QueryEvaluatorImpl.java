/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.queryEvaluator.impl;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.ecore.OCL.Query;

import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorLiterals;
import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Evaluator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class QueryEvaluatorImpl extends EObjectImpl implements QueryEvaluator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryEvaluatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueryEvaluatorPackage.Literals.QUERY_EVALUATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean evaluateQuery(Query query, EList<?> contextInstances) {
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this, QueryEvaluatorLiterals.START_QUERY_EVALUATION_VALUE, Notification.NO_FEATURE_ID, id, QueryEvaluatorLiterals.START_QUERY_EVALUATION.getName()));
		query.evaluate(contextInstances);
//		boolean result = query.check(contextInstances);
		eNotify(new ENotificationImpl(this, QueryEvaluatorLiterals.END_QUERY_EVALUATION_VALUE, Notification.NO_FEATURE_ID, id, QueryEvaluatorLiterals.END_QUERY_EVALUATION.getName()));
		return true;
	}

} //QueryEvaluatorImpl
