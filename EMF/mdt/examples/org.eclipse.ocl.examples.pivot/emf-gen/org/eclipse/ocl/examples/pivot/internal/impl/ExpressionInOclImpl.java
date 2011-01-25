/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ExpressionInOclImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression In Ocl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl#getContextVariable <em>Context Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl#getResultVariable <em>Result Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.ExpressionInOclImpl#getParameterVariables <em>Parameter Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionInOclImpl
		extends OpaqueExpressionImpl
		implements ExpressionInOcl {

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression bodyExpression;

	/**
	 * The cached value of the '{@link #getContextVariable() <em>Context Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable contextVariable;

	/**
	 * The cached value of the '{@link #getResultVariable() <em>Result Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable resultVariable;

	/**
	 * The cached value of the '{@link #getParameterVariables() <em>Parameter Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameterVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionInOclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.EXPRESSION_IN_OCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getBodyExpression() {
		if (bodyExpression != null && ((EObject)bodyExpression).eIsProxy())
		{
			InternalEObject oldBodyExpression = (InternalEObject)bodyExpression;
			bodyExpression = (OclExpression)eResolveProxy(oldBodyExpression);
			if (bodyExpression != oldBodyExpression)
			{
				InternalEObject newBodyExpression = (InternalEObject)bodyExpression;
				NotificationChain msgs = oldBodyExpression.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null, null);
				if (newBodyExpression.eInternalContainer() == null)
				{
					msgs = newBodyExpression.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, oldBodyExpression, bodyExpression));
			}
		}
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyExpression(
			OclExpression newBodyExpression, NotificationChain msgs) {
		OclExpression oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, oldBodyExpression, newBodyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyExpression(OclExpression newBodyExpression) {
		if (newBodyExpression != bodyExpression)
		{
			NotificationChain msgs = null;
			if (bodyExpression != null)
				msgs = ((InternalEObject)bodyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null, msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject)newBodyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null, msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, newBodyExpression, newBodyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createBodyExpression(EClass eClass) {
		OclExpression newBodyExpression = (OclExpression) create(eClass);
		setBodyExpression(newBodyExpression);
		return newBodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression createBodyExpression() {
		return createBodyExpression(PivotPackage.Literals.OCL_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getContextVariable() {
		if (contextVariable != null && ((EObject)contextVariable).eIsProxy())
		{
			InternalEObject oldContextVariable = (InternalEObject)contextVariable;
			contextVariable = (Variable)eResolveProxy(oldContextVariable);
			if (contextVariable != oldContextVariable)
			{
				InternalEObject newContextVariable = (InternalEObject)contextVariable;
				NotificationChain msgs = oldContextVariable.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null, null);
				if (newContextVariable.eInternalContainer() == null)
				{
					msgs = newContextVariable.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, oldContextVariable, contextVariable));
			}
		}
		return contextVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetContextVariable() {
		return contextVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextVariable(
			Variable newContextVariable, NotificationChain msgs) {
		Variable oldContextVariable = contextVariable;
		contextVariable = newContextVariable;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, oldContextVariable, newContextVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextVariable(Variable newContextVariable) {
		if (newContextVariable != contextVariable)
		{
			NotificationChain msgs = null;
			if (contextVariable != null)
				msgs = ((InternalEObject)contextVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null, msgs);
			if (newContextVariable != null)
				msgs = ((InternalEObject)newContextVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null, msgs);
			msgs = basicSetContextVariable(newContextVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, newContextVariable, newContextVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createContextVariable() {
		Variable newContextVariable = (Variable) create(PivotPackage.Literals.VARIABLE);
		setContextVariable(newContextVariable);
		return newContextVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getResultVariable() {
		if (resultVariable != null && ((EObject)resultVariable).eIsProxy())
		{
			InternalEObject oldResultVariable = (InternalEObject)resultVariable;
			resultVariable = (Variable)eResolveProxy(oldResultVariable);
			if (resultVariable != oldResultVariable)
			{
				InternalEObject newResultVariable = (InternalEObject)resultVariable;
				NotificationChain msgs = oldResultVariable.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null, null);
				if (newResultVariable.eInternalContainer() == null)
				{
					msgs = newResultVariable.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, oldResultVariable, resultVariable));
			}
		}
		return resultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetResultVariable() {
		return resultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultVariable(Variable newResultVariable,
			NotificationChain msgs) {
		Variable oldResultVariable = resultVariable;
		resultVariable = newResultVariable;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, oldResultVariable, newResultVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultVariable(Variable newResultVariable) {
		if (newResultVariable != resultVariable)
		{
			NotificationChain msgs = null;
			if (resultVariable != null)
				msgs = ((InternalEObject)resultVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null, msgs);
			if (newResultVariable != null)
				msgs = ((InternalEObject)newResultVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null, msgs);
			msgs = basicSetResultVariable(newResultVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, newResultVariable, newResultVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createResultVariable() {
		Variable newResultVariable = (Variable) create(PivotPackage.Literals.VARIABLE);
		setResultVariable(newResultVariable);
		return newResultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getParameterVariables() {
		if (parameterVariables == null)
		{
			parameterVariables = new EObjectContainmentEList.Resolving<Variable>(Variable.class, this, PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		}
		return parameterVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createParameterVariable() {
		Variable newParameterVariable = (Variable) create(PivotPackage.Literals.VARIABLE);
		getParameterVariables().add(newParameterVariable);
		return newParameterVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				return basicSetBodyExpression(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				return basicSetContextVariable(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				return basicSetResultVariable(null, msgs);
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				return ((InternalEList<?>)getParameterVariables()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.EXPRESSION_IN_OCL__MONIKER:
				return getMoniker();
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				return getName();
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				return isStatic();
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				return getBodies();
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				return getLanguages();
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				if (resolve) return getBodyExpression();
				return basicGetBodyExpression();
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				if (resolve) return getContextVariable();
				return basicGetContextVariable();
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				if (resolve) return getResultVariable();
				return basicGetResultVariable();
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				return getParameterVariables();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				getBodies().clear();
				getBodies().addAll((Collection<? extends String>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				getLanguages().clear();
				getLanguages().addAll((Collection<? extends String>)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				setBodyExpression((OclExpression)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				setContextVariable((Variable)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				setResultVariable((Variable)newValue);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				getParameterVariables().clear();
				getParameterVariables().addAll((Collection<? extends Variable>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				getBodies().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				getLanguages().clear();
				return;
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				setBodyExpression((OclExpression)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				setContextVariable((Variable)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				setResultVariable((Variable)null);
				return;
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				getParameterVariables().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.EXPRESSION_IN_OCL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.EXPRESSION_IN_OCL__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__TYPE:
				return type != null;
			case PivotPackage.EXPRESSION_IN_OCL__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.EXPRESSION_IN_OCL__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.EXPRESSION_IN_OCL__BODY:
				return bodies != null && !bodies.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__LANGUAGE:
				return languages != null && !languages.isEmpty();
			case PivotPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION:
				return bodyExpression != null;
			case PivotPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE:
				return contextVariable != null;
			case PivotPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE:
				return resultVariable != null;
			case PivotPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE:
				return parameterVariables != null && !parameterVariables.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitExpressionInOcl(this);
	}

} //ExpressionInOclImpl
