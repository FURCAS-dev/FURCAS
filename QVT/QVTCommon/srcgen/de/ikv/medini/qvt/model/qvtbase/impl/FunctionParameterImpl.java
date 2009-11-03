/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.impl.ParameterImpl;
import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.IterateExp;
import org.oslo.ocl20.semantics.model.expressions.LoopExp;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;

import de.ikv.medini.qvt.model.qvtbase.FunctionParameter;
import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Function Parameter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl#getVariableExps <em>Variable Exps</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl#getTupleLiteralExp <em>Tuple Literal Exp</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl#getLoopExpr <em>Loop Expr</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl#getBaseExp <em>Base Exp</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionParameterImpl extends ParameterImpl implements FunctionParameter {
	/**
	 * The cached value of the '{@link #getVariableExps() <em>Variable Exps</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVariableExps()
	 * @generated
	 * @ordered
	 */
	protected EList variableExps;

	/**
	 * The cached value of the '{@link #getTupleLiteralExp() <em>Tuple Literal Exp</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTupleLiteralExp()
	 * @generated
	 * @ordered
	 */
	protected TupleLiteralExp tupleLiteralExp;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Classifier type;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	// protected Classifier type;
	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression initExpression;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtBasePackage.Literals.FUNCTION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVariableExps() {
		if (variableExps == null) {
			variableExps = new EObjectWithInverseResolvingEList(VariableExp.class, this, QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS, ExpressionsPackage.VARIABLE_EXP__REFERRED_VARIABLE);
		}
		return variableExps;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralExp getTupleLiteralExp() {
		if (tupleLiteralExp != null && tupleLiteralExp.eIsProxy()) {
			InternalEObject oldTupleLiteralExp = (InternalEObject)tupleLiteralExp;
			tupleLiteralExp = (TupleLiteralExp)eResolveProxy(oldTupleLiteralExp);
			if (tupleLiteralExp != oldTupleLiteralExp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP, oldTupleLiteralExp, tupleLiteralExp));
			}
		}
		return tupleLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralExp basicGetTupleLiteralExp() {
		return tupleLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTupleLiteralExp(TupleLiteralExp newTupleLiteralExp, NotificationChain msgs) {
		TupleLiteralExp oldTupleLiteralExp = tupleLiteralExp;
		tupleLiteralExp = newTupleLiteralExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP, oldTupleLiteralExp, newTupleLiteralExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTupleLiteralExp(TupleLiteralExp newTupleLiteralExp) {
		if (newTupleLiteralExp != tupleLiteralExp) {
			NotificationChain msgs = null;
			if (tupleLiteralExp != null)
				msgs = ((InternalEObject)tupleLiteralExp).eInverseRemove(this, ExpressionsPackage.TUPLE_LITERAL_EXP__TUPLE_PART, TupleLiteralExp.class, msgs);
			if (newTupleLiteralExp != null)
				msgs = ((InternalEObject)newTupleLiteralExp).eInverseAdd(this, ExpressionsPackage.TUPLE_LITERAL_EXP__TUPLE_PART, TupleLiteralExp.class, msgs);
			msgs = basicSetTupleLiteralExp(newTupleLiteralExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP, newTupleLiteralExp, newTupleLiteralExp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LoopExp getLoopExpr() {
		if (eContainerFeatureID != QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR) return null;
		return (LoopExp)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopExpr(LoopExp newLoopExpr, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLoopExpr, QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopExpr(LoopExp newLoopExpr) {
		if (newLoopExpr != eInternalContainer() || (eContainerFeatureID != QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR && newLoopExpr != null)) {
			if (EcoreUtil.isAncestor(this, newLoopExpr))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLoopExpr != null)
				msgs = ((InternalEObject)newLoopExpr).eInverseAdd(this, ExpressionsPackage.LOOP_EXP__ITERATORS, LoopExp.class, msgs);
			msgs = basicSetLoopExpr(newLoopExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR, newLoopExpr, newLoopExpr));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Classifier)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtBasePackage.FUNCTION_PARAMETER__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Classifier newType) {
		Classifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.FUNCTION_PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IterateExp getBaseExp() {
		if (eContainerFeatureID != QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP) return null;
		return (IterateExp)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseExp(IterateExp newBaseExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBaseExp, QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseExp(IterateExp newBaseExp) {
		if (newBaseExp != eInternalContainer() || (eContainerFeatureID != QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP && newBaseExp != null)) {
			if (EcoreUtil.isAncestor(this, newBaseExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBaseExp != null)
				msgs = ((InternalEObject)newBaseExp).eInverseAdd(this, ExpressionsPackage.ITERATE_EXP__RESULT, IterateExp.class, msgs);
			msgs = basicSetBaseExp(newBaseExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP, newBaseExp, newBaseExp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(OclExpression newInitExpression, NotificationChain msgs) {
		OclExpression oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(OclExpression newInitExpression) {
		if (newInitExpression != initExpression) {
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE, OclExpression.class, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE, OclExpression.class, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION, newInitExpression, newInitExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS:
				return ((InternalEList)getVariableExps()).basicAdd(otherEnd, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP:
				if (tupleLiteralExp != null)
					msgs = ((InternalEObject)tupleLiteralExp).eInverseRemove(this, ExpressionsPackage.TUPLE_LITERAL_EXP__TUPLE_PART, TupleLiteralExp.class, msgs);
				return basicSetTupleLiteralExp((TupleLiteralExp)otherEnd, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLoopExpr((LoopExp)otherEnd, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBaseExp((IterateExp)otherEnd, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				if (initExpression != null)
					msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION, null, msgs);
				return basicSetInitExpression((OclExpression)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS:
				return ((InternalEList)getVariableExps()).basicRemove(otherEnd, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP:
				return basicSetTupleLiteralExp(null, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR:
				return basicSetLoopExpr(null, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP:
				return basicSetBaseExp(null, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				return basicSetInitExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.LOOP_EXP__ITERATORS, LoopExp.class, msgs);
			case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.ITERATE_EXP__RESULT, IterateExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS:
				return getVariableExps();
			case QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP:
				if (resolve) return getTupleLiteralExp();
				return basicGetTupleLiteralExp();
			case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR:
				return getLoopExpr();
			case QvtBasePackage.FUNCTION_PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP:
				return getBaseExp();
			case QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				return getInitExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS:
				getVariableExps().clear();
				getVariableExps().addAll((Collection)newValue);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP:
				setTupleLiteralExp((TupleLiteralExp)newValue);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR:
				setLoopExpr((LoopExp)newValue);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__TYPE:
				setType((Classifier)newValue);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP:
				setBaseExp((IterateExp)newValue);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				setInitExpression((OclExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS:
				getVariableExps().clear();
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP:
				setTupleLiteralExp((TupleLiteralExp)null);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR:
				setLoopExpr((LoopExp)null);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__TYPE:
				setType((Classifier)null);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP:
				setBaseExp((IterateExp)null);
				return;
			case QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				setInitExpression((OclExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS:
				return variableExps != null && !variableExps.isEmpty();
			case QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP:
				return tupleLiteralExp != null;
			case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR:
				return getLoopExpr() != null;
			case QvtBasePackage.FUNCTION_PARAMETER__TYPE:
				return type != null;
			case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP:
				return getBaseExp() != null;
			case QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				return initExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == VariableDeclaration.class) {
			switch (derivedFeatureID) {
				case QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS: return ExpressionsPackage.VARIABLE_DECLARATION__VARIABLE_EXPS;
				case QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP: return ExpressionsPackage.VARIABLE_DECLARATION__TUPLE_LITERAL_EXP;
				case QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR: return ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR;
				case QvtBasePackage.FUNCTION_PARAMETER__TYPE: return ExpressionsPackage.VARIABLE_DECLARATION__TYPE;
				case QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP: return ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP;
				case QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION: return ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == VariableDeclaration.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.VARIABLE_DECLARATION__VARIABLE_EXPS: return QvtBasePackage.FUNCTION_PARAMETER__VARIABLE_EXPS;
				case ExpressionsPackage.VARIABLE_DECLARATION__TUPLE_LITERAL_EXP: return QvtBasePackage.FUNCTION_PARAMETER__TUPLE_LITERAL_EXP;
				case ExpressionsPackage.VARIABLE_DECLARATION__LOOP_EXPR: return QvtBasePackage.FUNCTION_PARAMETER__LOOP_EXPR;
				case ExpressionsPackage.VARIABLE_DECLARATION__TYPE: return QvtBasePackage.FUNCTION_PARAMETER__TYPE;
				case ExpressionsPackage.VARIABLE_DECLARATION__BASE_EXP: return QvtBasePackage.FUNCTION_PARAMETER__BASE_EXP;
				case ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION: return QvtBasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // FunctionParameterImpl
