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
 * $Id: IterationImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
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
 * An implementation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl#getOwnedIterators <em>Owned Iterator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.IterationImpl#getOwnedAccumulators <em>Owned Accumulator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterationImpl extends OperationImpl implements Iteration
{
	/**
	 * The cached value of the '{@link #getOwnedIterators() <em>Owned Iterator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedIterators;

	/**
	 * The cached value of the '{@link #getOwnedAccumulators() <em>Owned Accumulator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAccumulators()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedAccumulators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationImpl()
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
		return PivotPackage.Literals.ITERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getOwnedIterators()
	{
		if (ownedIterators == null)
		{
			ownedIterators = new EObjectContainmentEList.Resolving<Parameter>(Parameter.class, this, PivotPackage.ITERATION__OWNED_ITERATOR);
		}
		return ownedIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createOwnedIterator()
	{
		Parameter newOwnedIterator = (Parameter) create(PivotPackage.Literals.PARAMETER);
		getOwnedIterators().add(newOwnedIterator);
		return newOwnedIterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getOwnedAccumulators()
	{
		if (ownedAccumulators == null)
		{
			ownedAccumulators = new EObjectContainmentEList.Resolving<Parameter>(Parameter.class, this, PivotPackage.ITERATION__OWNED_ACCUMULATOR);
		}
		return ownedAccumulators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createOwnedAccumulator()
	{
		Parameter newOwnedAccumulator = (Parameter) create(PivotPackage.Literals.PARAMETER);
		getOwnedAccumulators().add(newOwnedAccumulator);
		return newOwnedAccumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case PivotPackage.ITERATION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATION__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATION__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.ITERATION__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.ITERATION__TEMPLATE_BINDING:
				return ((InternalEList<?>)getTemplateBindings()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATION__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case PivotPackage.ITERATION__OWNED_PARAMETER:
				return ((InternalEList<?>)getOwnedParameters()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATION__CLASS:
				return basicSetClass_(null, msgs);
			case PivotPackage.ITERATION__OWNED_ITERATOR:
				return ((InternalEList<?>)getOwnedIterators()).basicRemove(otherEnd, msgs);
			case PivotPackage.ITERATION__OWNED_ACCUMULATOR:
				return ((InternalEList<?>)getOwnedAccumulators()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.ITERATION__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.ITERATION__MONIKER:
				return getMoniker();
			case PivotPackage.ITERATION__NAME:
				return getName();
			case PivotPackage.ITERATION__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.ITERATION__IS_STATIC:
				return isStatic();
			case PivotPackage.ITERATION__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.ITERATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.ITERATION__IS_ORDERED:
				return isOrdered();
			case PivotPackage.ITERATION__IS_UNIQUE:
				return isUnique();
			case PivotPackage.ITERATION__LOWER:
				return getLower();
			case PivotPackage.ITERATION__UPPER:
				return getUpper();
			case PivotPackage.ITERATION__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case PivotPackage.ITERATION__IMPLEMENTATION:
				return getImplementation();
			case PivotPackage.ITERATION__FEATURING_CLASS:
				return getFeaturingClass();
			case PivotPackage.ITERATION__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.ITERATION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.ITERATION__TEMPLATE_BINDING:
				return getTemplateBindings();
			case PivotPackage.ITERATION__OWNED_TEMPLATE_SIGNATURE:
				if (resolve) return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case PivotPackage.ITERATION__RAISED_EXCEPTION:
				return getRaisedExceptions();
			case PivotPackage.ITERATION__OWNED_PARAMETER:
				return getOwnedParameters();
			case PivotPackage.ITERATION__PRECEDENCE:
				if (resolve) return getPrecedence();
				return basicGetPrecedence();
			case PivotPackage.ITERATION__CLASS:
				if (resolve) return getClass_();
				return basicGetClass_();
			case PivotPackage.ITERATION__OWNED_ITERATOR:
				return getOwnedIterators();
			case PivotPackage.ITERATION__OWNED_ACCUMULATOR:
				return getOwnedAccumulators();
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
			case PivotPackage.ITERATION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ITERATION__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.ITERATION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ITERATION__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ITERATION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ITERATION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.ITERATION__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.ITERATION__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case PivotPackage.ITERATION__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case PivotPackage.ITERATION__LOWER:
				setLower((BigInteger)newValue);
				return;
			case PivotPackage.ITERATION__UPPER:
				setUpper((BigInteger)newValue);
				return;
			case PivotPackage.ITERATION__IMPLEMENTATION_CLASS:
				setImplementationClass((String)newValue);
				return;
			case PivotPackage.ITERATION__IMPLEMENTATION:
				setImplementation((CallableImplementation)newValue);
				return;
			case PivotPackage.ITERATION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.ITERATION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.ITERATION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.ITERATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.ITERATION__RAISED_EXCEPTION:
				getRaisedExceptions().clear();
				getRaisedExceptions().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.ITERATION__OWNED_PARAMETER:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case PivotPackage.ITERATION__PRECEDENCE:
				setPrecedence((Precedence)newValue);
				return;
			case PivotPackage.ITERATION__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)newValue);
				return;
			case PivotPackage.ITERATION__OWNED_ITERATOR:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends Parameter>)newValue);
				return;
			case PivotPackage.ITERATION__OWNED_ACCUMULATOR:
				getOwnedAccumulators().clear();
				getOwnedAccumulators().addAll((Collection<? extends Parameter>)newValue);
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
			case PivotPackage.ITERATION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.ITERATION__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.ITERATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ITERATION__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.ITERATION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ITERATION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.ITERATION__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.ITERATION__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case PivotPackage.ITERATION__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case PivotPackage.ITERATION__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case PivotPackage.ITERATION__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case PivotPackage.ITERATION__IMPLEMENTATION_CLASS:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case PivotPackage.ITERATION__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case PivotPackage.ITERATION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.ITERATION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.ITERATION__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case PivotPackage.ITERATION__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.ITERATION__RAISED_EXCEPTION:
				getRaisedExceptions().clear();
				return;
			case PivotPackage.ITERATION__OWNED_PARAMETER:
				getOwnedParameters().clear();
				return;
			case PivotPackage.ITERATION__PRECEDENCE:
				setPrecedence((Precedence)null);
				return;
			case PivotPackage.ITERATION__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)null);
				return;
			case PivotPackage.ITERATION__OWNED_ITERATOR:
				getOwnedIterators().clear();
				return;
			case PivotPackage.ITERATION__OWNED_ACCUMULATOR:
				getOwnedAccumulators().clear();
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
			case PivotPackage.ITERATION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.ITERATION__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.ITERATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ITERATION__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.ITERATION__IS_STATIC:
				return isSetIsStatic();
			case PivotPackage.ITERATION__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.ITERATION__TYPE:
				return type != null;
			case PivotPackage.ITERATION__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case PivotPackage.ITERATION__IS_UNIQUE:
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case PivotPackage.ITERATION__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case PivotPackage.ITERATION__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
			case PivotPackage.ITERATION__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case PivotPackage.ITERATION__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case PivotPackage.ITERATION__FEATURING_CLASS:
				return getFeaturingClass() != null;
			case PivotPackage.ITERATION__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.ITERATION__TEMPLATE_PARAMETER:
				return isSetTemplateParameter();
			case PivotPackage.ITERATION__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case PivotPackage.ITERATION__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.ITERATION__RAISED_EXCEPTION:
				return raisedExceptions != null && !raisedExceptions.isEmpty();
			case PivotPackage.ITERATION__OWNED_PARAMETER:
				return ownedParameters != null && !ownedParameters.isEmpty();
			case PivotPackage.ITERATION__PRECEDENCE:
				return precedence != null;
			case PivotPackage.ITERATION__CLASS:
				return basicGetClass_() != null;
			case PivotPackage.ITERATION__OWNED_ITERATOR:
				return ownedIterators != null && !ownedIterators.isEmpty();
			case PivotPackage.ITERATION__OWNED_ACCUMULATOR:
				return ownedAccumulators != null && !ownedAccumulators.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitIteration(this);
	}

} //IterationImpl
