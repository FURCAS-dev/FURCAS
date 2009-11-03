/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.oslo.ocl20.semantics.bridge.Classifier;

import org.oslo.ocl20.semantics.bridge.impl.ModelElementImpl;

import org.oslo.ocl20.semantics.model.expressions.CallExp;
import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.LoopExp;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.PropertyCallExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl#isIsMarkedPre <em>Is
 * Marked Pre</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl#getLoopExp <em>Loop
 * Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl#getOperationCallExp
 * <em>Operation Call Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl#getPropertyCallExp
 * <em>Property Call Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl#getType <em>Type
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl#getAppliedProperty
 * <em>Applied Property</em>}</li>
 * <li>
 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl#getInitialisedVariable
 * <em>Initialised Variable</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OclExpressionImpl extends ModelElementImpl implements OclExpression {
	/**
	 * The default value of the '{@link #isIsMarkedPre() <em>Is Marked Pre</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsMarkedPre()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MARKED_PRE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMarkedPre() <em>Is Marked Pre</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsMarkedPre()
	 * @generated
	 * @ordered
	 */
	protected boolean isMarkedPre = IS_MARKED_PRE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Classifier type;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OclExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsMarkedPre() {
		return isMarkedPre;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsMarkedPre(boolean newIsMarkedPre) {
		boolean oldIsMarkedPre = isMarkedPre;
		isMarkedPre = newIsMarkedPre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__IS_MARKED_PRE,
			    oldIsMarkedPre, isMarkedPre));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LoopExp getLoopExp() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP)
			return null;
		return (LoopExp) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLoopExp(LoopExp newLoopExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newLoopExp, ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLoopExp(LoopExp newLoopExp) {
		if (newLoopExp != eInternalContainer()
		        || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP && newLoopExp != null)) {
			if (EcoreUtil.isAncestor(this, newLoopExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLoopExp != null)
				msgs = ((InternalEObject) newLoopExp).eInverseAdd(this, ExpressionsPackage.LOOP_EXP__BODY,
				    LoopExp.class, msgs);
			msgs = basicSetLoopExp(newLoopExp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP,
			    newLoopExp, newLoopExp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationCallExp getOperationCallExp() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP)
			return null;
		return (OperationCallExp) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOperationCallExp(OperationCallExp newOperationCallExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOperationCallExp,
		    ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOperationCallExp(OperationCallExp newOperationCallExp) {
		if (newOperationCallExp != eInternalContainer()
		        || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP && newOperationCallExp != null)) {
			if (EcoreUtil.isAncestor(this, newOperationCallExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperationCallExp != null)
				msgs = ((InternalEObject) newOperationCallExp).eInverseAdd(this,
				    ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, OperationCallExp.class, msgs);
			msgs = basicSetOperationCallExp(newOperationCallExp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP, newOperationCallExp, newOperationCallExp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyCallExp getPropertyCallExp() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP)
			return null;
		return (PropertyCallExp) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPropertyCallExp(PropertyCallExp newPropertyCallExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newPropertyCallExp,
		    ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPropertyCallExp(PropertyCallExp newPropertyCallExp) {
		if (newPropertyCallExp != eInternalContainer()
		        || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP && newPropertyCallExp != null)) {
			if (EcoreUtil.isAncestor(this, newPropertyCallExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPropertyCallExp != null)
				msgs = ((InternalEObject) newPropertyCallExp).eInverseAdd(this,
				    ExpressionsPackage.PROPERTY_CALL_EXP__QUALIFIERS, PropertyCallExp.class, msgs);
			msgs = basicSetPropertyCallExp(newPropertyCallExp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP,
			    newPropertyCallExp, newPropertyCallExp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (Classifier) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__TYPE,
					    oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(Classifier newType) {
		Classifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__TYPE, oldType,
			    type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CallExp getAppliedProperty() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY)
			return null;
		return (CallExp) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAppliedProperty(CallExp newAppliedProperty, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newAppliedProperty,
		    ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAppliedProperty(CallExp newAppliedProperty) {
		if (newAppliedProperty != eInternalContainer()
		        || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY && newAppliedProperty != null)) {
			if (EcoreUtil.isAncestor(this, newAppliedProperty))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAppliedProperty != null)
				msgs = ((InternalEObject) newAppliedProperty).eInverseAdd(this, ExpressionsPackage.CALL_EXP__SOURCE,
				    CallExp.class, msgs);
			msgs = basicSetAppliedProperty(newAppliedProperty, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY,
			    newAppliedProperty, newAppliedProperty));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariableDeclaration getInitialisedVariable() {
		if (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE)
			return null;
		return (VariableDeclaration) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInitialisedVariable(VariableDeclaration newInitialisedVariable,
	        NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newInitialisedVariable,
		    ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInitialisedVariable(VariableDeclaration newInitialisedVariable) {
		if (newInitialisedVariable != eInternalContainer()
		        || (eContainerFeatureID != ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE && newInitialisedVariable != null)) {
			if (EcoreUtil.isAncestor(this, newInitialisedVariable))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInitialisedVariable != null)
				msgs = ((InternalEObject) newInitialisedVariable).eInverseAdd(this,
				    ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
			msgs = basicSetInitialisedVariable(newInitialisedVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE, newInitialisedVariable, newInitialisedVariable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLoopExp((LoopExp) otherEnd, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperationCallExp((OperationCallExp) otherEnd, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPropertyCallExp((PropertyCallExp) otherEnd, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAppliedProperty((CallExp) otherEnd, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInitialisedVariable((VariableDeclaration) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP:
				return basicSetLoopExp(null, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP:
				return basicSetOperationCallExp(null, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP:
				return basicSetPropertyCallExp(null, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return basicSetAppliedProperty(null, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE:
				return basicSetInitialisedVariable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP:
				return eInternalContainer()
				        .eInverseRemove(this, ExpressionsPackage.LOOP_EXP__BODY, LoopExp.class, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS,
				    OperationCallExp.class, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__QUALIFIERS,
				    PropertyCallExp.class, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.CALL_EXP__SOURCE, CallExp.class,
				    msgs);
			case ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE:
				return eInternalContainer().eInverseRemove(this,
				    ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__IS_MARKED_PRE:
				return isIsMarkedPre() ? Boolean.TRUE : Boolean.FALSE;
			case ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP:
				return getLoopExp();
			case ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP:
				return getOperationCallExp();
			case ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP:
				return getPropertyCallExp();
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				if (resolve)
					return getType();
				return basicGetType();
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE:
				return getInitialisedVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__IS_MARKED_PRE:
				setIsMarkedPre(((Boolean) newValue).booleanValue());
				return;
			case ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP:
				setLoopExp((LoopExp) newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP:
				setOperationCallExp((OperationCallExp) newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP:
				setPropertyCallExp((PropertyCallExp) newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((Classifier) newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				setAppliedProperty((CallExp) newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE:
				setInitialisedVariable((VariableDeclaration) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__IS_MARKED_PRE:
				setIsMarkedPre(IS_MARKED_PRE_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP:
				setLoopExp((LoopExp) null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP:
				setOperationCallExp((OperationCallExp) null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP:
				setPropertyCallExp((PropertyCallExp) null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((Classifier) null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				setAppliedProperty((CallExp) null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE:
				setInitialisedVariable((VariableDeclaration) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__IS_MARKED_PRE:
				return isMarkedPre != IS_MARKED_PRE_EDEFAULT;
			case ExpressionsPackage.OCL_EXPRESSION__LOOP_EXP:
				return getLoopExp() != null;
			case ExpressionsPackage.OCL_EXPRESSION__OPERATION_CALL_EXP:
				return getOperationCallExp() != null;
			case ExpressionsPackage.OCL_EXPRESSION__PROPERTY_CALL_EXP:
				return getPropertyCallExp() != null;
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				return type != null;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.OCL_EXPRESSION__INITIALISED_VARIABLE:
				return getInitialisedVariable() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isMarkedPre: ");
		result.append(isMarkedPre);
		result.append(')');
		return result.toString();
	}

} // OclExpressionImpl
