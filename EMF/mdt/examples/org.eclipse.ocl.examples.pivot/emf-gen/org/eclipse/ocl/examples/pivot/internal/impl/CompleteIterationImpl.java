/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: CompleteIterationImpl.java,v 1.3 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.math.BigInteger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.CompleteIteration;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;

import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl#getCompleteEnvironment <em>Complete Environment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl#getCompleteIterators <em>Complete Iterator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl#getCompleteAccumulators <em>Complete Accumulator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteIterationImpl#getCompleteParameters <em>Complete Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteIterationImpl extends IterationImpl implements CompleteIteration
{
	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Iteration model;

	/**
	 * The cached value of the '{@link #getCompleteEnvironment() <em>Complete Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteEnvironment()
	 * @generated
	 * @ordered
	 */
	protected CompleteEnvironment completeEnvironment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteIterationImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.COMPLETE_ITERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iteration getModel()
	{
		if (model != null && ((EObject)model).eIsProxy())
		{
			InternalEObject oldModel = (InternalEObject)model;
			model = (Iteration)eResolveProxy(oldModel);
			if (model != oldModel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_ITERATION__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iteration basicGetModel()
	{
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Iteration newModel)
	{
		Iteration oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_ITERATION__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteEnvironment getCompleteEnvironment()
	{
		if (completeEnvironment != null && ((EObject)completeEnvironment).eIsProxy())
		{
			InternalEObject oldCompleteEnvironment = (InternalEObject)completeEnvironment;
			completeEnvironment = (CompleteEnvironment)eResolveProxy(oldCompleteEnvironment);
			if (completeEnvironment != oldCompleteEnvironment)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_ITERATION__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
			}
		}
		return completeEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteEnvironment basicGetCompleteEnvironment()
	{
		return completeEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompleteEnvironment(CompleteEnvironment newCompleteEnvironment)
	{
		CompleteEnvironment oldCompleteEnvironment = completeEnvironment;
		completeEnvironment = newCompleteEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_ITERATION__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Parameter> getCompleteIterators()
	{
		return getModel().getOwnedIterators();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Parameter> getCompleteAccumulators()
	{
		return getModel().getOwnedAccumulators();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Parameter> getCompleteParameters() {
		return getModel().getOwnedParameters();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case PivotPackage.COMPLETE_ITERATION__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.COMPLETE_ITERATION__MONIKER:
				return getMoniker();
			case PivotPackage.COMPLETE_ITERATION__NAME:
				return getName();
			case PivotPackage.COMPLETE_ITERATION__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.COMPLETE_ITERATION__IS_STATIC:
				return isStatic();
			case PivotPackage.COMPLETE_ITERATION__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.COMPLETE_ITERATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COMPLETE_ITERATION__IS_ORDERED:
				return isOrdered();
			case PivotPackage.COMPLETE_ITERATION__IS_UNIQUE:
				return isUnique();
			case PivotPackage.COMPLETE_ITERATION__LOWER:
				return getLower();
			case PivotPackage.COMPLETE_ITERATION__UPPER:
				return getUpper();
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION:
				return getImplementation();
			case PivotPackage.COMPLETE_ITERATION__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_BINDING:
				return getTemplateBindings();
			case PivotPackage.COMPLETE_ITERATION__OWNED_TEMPLATE_SIGNATURE:
				if (resolve) return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case PivotPackage.COMPLETE_ITERATION__RAISED_EXCEPTION:
				return getRaisedExceptions();
			case PivotPackage.COMPLETE_ITERATION__OWNED_PARAMETER:
				return getOwnedParameters();
			case PivotPackage.COMPLETE_ITERATION__PRECEDENCE:
				if (resolve) return getPrecedence();
				return basicGetPrecedence();
			case PivotPackage.COMPLETE_ITERATION__CLASS:
				if (resolve) return getClass_();
				return basicGetClass_();
			case PivotPackage.COMPLETE_ITERATION__OWNED_ITERATOR:
				return getOwnedIterators();
			case PivotPackage.COMPLETE_ITERATION__OWNED_ACCUMULATOR:
				return getOwnedAccumulators();
			case PivotPackage.COMPLETE_ITERATION__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ENVIRONMENT:
				if (resolve) return getCompleteEnvironment();
				return basicGetCompleteEnvironment();
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ITERATOR:
				return getCompleteIterators();
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ACCUMULATOR:
				return getCompleteAccumulators();
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_PARAMETER:
				return getCompleteParameters();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case PivotPackage.COMPLETE_ITERATION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__LOWER:
				setLower((BigInteger)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__UPPER:
				setUpper((BigInteger)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION_CLASS:
				setImplementationClass((String)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION:
				setImplementation((CallableImplementation)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__RAISED_EXCEPTION:
				getRaisedExceptions().clear();
				getRaisedExceptions().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_PARAMETER:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__PRECEDENCE:
				setPrecedence((Precedence)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_ITERATOR:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends Parameter>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_ACCUMULATOR:
				getOwnedAccumulators().clear();
				getOwnedAccumulators().addAll((Collection<? extends Parameter>)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__MODEL:
				setModel((Iteration)newValue);
				return;
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ENVIRONMENT:
				setCompleteEnvironment((CompleteEnvironment)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.COMPLETE_ITERATION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.COMPLETE_ITERATION__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION_CLASS:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.COMPLETE_ITERATION__RAISED_EXCEPTION:
				getRaisedExceptions().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_PARAMETER:
				getOwnedParameters().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__PRECEDENCE:
				setPrecedence((Precedence)null);
				return;
			case PivotPackage.COMPLETE_ITERATION__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)null);
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_ITERATOR:
				getOwnedIterators().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__OWNED_ACCUMULATOR:
				getOwnedAccumulators().clear();
				return;
			case PivotPackage.COMPLETE_ITERATION__MODEL:
				setModel((Iteration)null);
				return;
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ENVIRONMENT:
				setCompleteEnvironment((CompleteEnvironment)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case PivotPackage.COMPLETE_ITERATION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.COMPLETE_ITERATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COMPLETE_ITERATION__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__IS_STATIC:
				return isSetIsStatic();
			case PivotPackage.COMPLETE_ITERATION__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__TYPE:
				return type != null;
			case PivotPackage.COMPLETE_ITERATION__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case PivotPackage.COMPLETE_ITERATION__IS_UNIQUE:
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case PivotPackage.COMPLETE_ITERATION__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case PivotPackage.COMPLETE_ITERATION__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case PivotPackage.COMPLETE_ITERATION__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case PivotPackage.COMPLETE_ITERATION__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_PARAMETER:
				return isSetTemplateParameter();
			case PivotPackage.COMPLETE_ITERATION__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.COMPLETE_ITERATION__RAISED_EXCEPTION:
				return raisedExceptions != null && !raisedExceptions.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__OWNED_PARAMETER:
				return ownedParameters != null && !ownedParameters.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__PRECEDENCE:
				return precedence != null;
			case PivotPackage.COMPLETE_ITERATION__CLASS:
				return basicGetClass_() != null;
			case PivotPackage.COMPLETE_ITERATION__OWNED_ITERATOR:
				return ownedIterators != null && !ownedIterators.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__OWNED_ACCUMULATOR:
				return ownedAccumulators != null && !ownedAccumulators.isEmpty();
			case PivotPackage.COMPLETE_ITERATION__MODEL:
				return model != null;
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ENVIRONMENT:
				return completeEnvironment != null;
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ITERATOR:
				return !getCompleteIterators().isEmpty();
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_ACCUMULATOR:
				return !getCompleteAccumulators().isEmpty();
			case PivotPackage.COMPLETE_ITERATION__COMPLETE_PARAMETER:
				return !getCompleteParameters().isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCompleteIteration(this);
	}
} //CompleteIterationImpl
