/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.expressions.OCLExpression;

import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;
import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl#getContext <em>Context</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl#getExtentMap <em>Extent Map</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclQueryImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclQueryImpl extends EObjectImpl implements OclQuery {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EObject context;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected static final Object RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Object result = RESULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtentMap() <em>Extent Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtentMap()
	 * @generated
	 * @ordered
	 */
	protected Map<EClass, EList<? extends EObject>> extentMap;

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final OCLExpression EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression expression = EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclEvaluatorPackage.Literals.OCL_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclEvaluatorPackage.OCL_QUERY__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(EObject newContext) {
		EObject oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclEvaluatorPackage.OCL_QUERY__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(OCLExpression newExpression) {
		OCLExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclEvaluatorPackage.OCL_QUERY__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(Object newResult) {
		Object oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclEvaluatorPackage.OCL_QUERY__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<EClass, EList<? extends EObject>> getExtentMap() {
		return extentMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtentMap(Map<EClass, EList<? extends EObject>> newExtentMap) {
		Map<EClass, EList<? extends EObject>> oldExtentMap = extentMap;
		extentMap = newExtentMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclEvaluatorPackage.OCL_QUERY__EXTENT_MAP, oldExtentMap, extentMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OclEvaluatorPackage.OCL_QUERY__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case OclEvaluatorPackage.OCL_QUERY__RESULT:
				return getResult();
			case OclEvaluatorPackage.OCL_QUERY__EXTENT_MAP:
				return getExtentMap();
			case OclEvaluatorPackage.OCL_QUERY__EXPRESSION:
				return getExpression();
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
			case OclEvaluatorPackage.OCL_QUERY__CONTEXT:
				setContext((EObject)newValue);
				return;
			case OclEvaluatorPackage.OCL_QUERY__RESULT:
				setResult(newValue);
				return;
			case OclEvaluatorPackage.OCL_QUERY__EXTENT_MAP:
				setExtentMap((Map<EClass, EList<? extends EObject>>)newValue);
				return;
			case OclEvaluatorPackage.OCL_QUERY__EXPRESSION:
				setExpression((OCLExpression)newValue);
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
			case OclEvaluatorPackage.OCL_QUERY__CONTEXT:
				setContext((EObject)null);
				return;
			case OclEvaluatorPackage.OCL_QUERY__RESULT:
				setResult(RESULT_EDEFAULT);
				return;
			case OclEvaluatorPackage.OCL_QUERY__EXTENT_MAP:
				setExtentMap((Map<EClass, EList<? extends EObject>>)null);
				return;
			case OclEvaluatorPackage.OCL_QUERY__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
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
			case OclEvaluatorPackage.OCL_QUERY__CONTEXT:
				return context != null;
			case OclEvaluatorPackage.OCL_QUERY__RESULT:
				return RESULT_EDEFAULT == null ? result != null : !RESULT_EDEFAULT.equals(result);
			case OclEvaluatorPackage.OCL_QUERY__EXTENT_MAP:
				return extentMap != null;
			case OclEvaluatorPackage.OCL_QUERY__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
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
		result.append(" (result: ");
		result.append(result);
		result.append(", extentMap: ");
		result.append(extentMap);
		result.append(", expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //OclQueryImpl
