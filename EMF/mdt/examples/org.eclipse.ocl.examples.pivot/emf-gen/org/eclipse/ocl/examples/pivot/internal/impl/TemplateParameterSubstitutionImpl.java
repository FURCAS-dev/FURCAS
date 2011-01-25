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
 * $Id: TemplateParameterSubstitutionImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.internal.operations.TemplateParameterSubstitutionOperations;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl#getActual <em>Actual</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl#getFormal <em>Formal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl#getOwnedActual <em>Owned Actual</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TemplateParameterSubstitutionImpl#getTemplateBinding <em>Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateParameterSubstitutionImpl
		extends ElementImpl
		implements TemplateParameterSubstitution {

	/**
	 * The cached value of the '{@link #getActual() <em>Actual</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActual()
	 * @generated
	 * @ordered
	 */
	protected ParameterableElement actual;

	/**
	 * The cached value of the '{@link #getFormal() <em>Formal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormal()
	 * @generated
	 * @ordered
	 */
	protected TemplateParameter formal;

	/**
	 * The cached value of the '{@link #getOwnedActual() <em>Owned Actual</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedActual()
	 * @generated
	 * @ordered
	 */
	protected ParameterableElement ownedActual;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateParameterSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterableElement getActual() {
		if (actual != null && ((EObject)actual).eIsProxy())
		{
			InternalEObject oldActual = (InternalEObject)actual;
			actual = (ParameterableElement)eResolveProxy(oldActual);
			if (actual != oldActual)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL, oldActual, actual));
			}
		}
		return actual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterableElement basicGetActual() {
		return actual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActual(ParameterableElement newActual) {
		ParameterableElement oldActual = actual;
		actual = newActual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL, oldActual, actual));
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (ownedActual != null && ownedActual != newActual)
			{
				setOwnedActual(null);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getFormal() {
		if (formal != null && ((EObject)formal).eIsProxy())
		{
			InternalEObject oldFormal = (InternalEObject)formal;
			formal = (TemplateParameter)eResolveProxy(oldFormal);
			if (formal != oldFormal)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL, oldFormal, formal));
			}
		}
		return formal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter basicGetFormal() {
		return formal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormal(TemplateParameter newFormal) {
		TemplateParameter oldFormal = formal;
		formal = newFormal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL, oldFormal, formal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterableElement getOwnedActual() {
		if (ownedActual != null && ((EObject)ownedActual).eIsProxy())
		{
			InternalEObject oldOwnedActual = (InternalEObject)ownedActual;
			ownedActual = (ParameterableElement)eResolveProxy(oldOwnedActual);
			if (ownedActual != oldOwnedActual)
			{
				InternalEObject newOwnedActual = (InternalEObject)ownedActual;
				NotificationChain msgs = oldOwnedActual.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, null, null);
				if (newOwnedActual.eInternalContainer() == null)
				{
					msgs = newOwnedActual.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, oldOwnedActual, ownedActual));
			}
		}
		return ownedActual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterableElement basicGetOwnedActual() {
		return ownedActual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedActual(
			ParameterableElement newOwnedActual, NotificationChain msgs) {
		ParameterableElement oldOwnedActual = ownedActual;
		ownedActual = newOwnedActual;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, oldOwnedActual, newOwnedActual);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwnedActual != null)
			{
				if (newOwnedActual != actual)
				{
					setActual(newOwnedActual);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedActual(ParameterableElement newOwnedActual) {
		if (newOwnedActual != ownedActual)
		{
			NotificationChain msgs = null;
			if (ownedActual != null)
				msgs = ((InternalEObject)ownedActual).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, null, msgs);
			if (newOwnedActual != null)
				msgs = ((InternalEObject)newOwnedActual).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, null, msgs);
			msgs = basicSetOwnedActual(newOwnedActual, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL, newOwnedActual, newOwnedActual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterableElement createOwnedActual(EClass eClass) {
		ParameterableElement newOwnedActual = (ParameterableElement) create(eClass);
		setOwnedActual(newOwnedActual);
		return newOwnedActual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding getTemplateBinding() {
		if (eContainerFeatureID() != PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING) return null;
		return (TemplateBinding)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding basicGetTemplateBinding() {
		if (eContainerFeatureID() != PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING) return null;
		return (TemplateBinding)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplateBinding(
			TemplateBinding newTemplateBinding, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTemplateBinding, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateBinding(TemplateBinding newTemplateBinding) {
		if (newTemplateBinding != eInternalContainer() || (eContainerFeatureID() != PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING && newTemplateBinding != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newTemplateBinding))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTemplateBinding != null)
				msgs = ((InternalEObject)newTemplateBinding).eInverseAdd(this, PivotPackage.TEMPLATE_BINDING__PARAMETER_SUBSTITUTION, TemplateBinding.class, msgs);
			msgs = basicSetTemplateBinding(newTemplateBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING, newTemplateBinding, newTemplateBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMustBeCompatible(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return TemplateParameterSubstitutionOperations.validateMustBeCompatible(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTemplateBinding((TemplateBinding)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
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
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL:
				return basicSetOwnedActual(null, msgs);
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING:
				return basicSetTemplateBinding(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_BINDING__PARAMETER_SUBSTITUTION, TemplateBinding.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL:
				if (resolve) return getFormal();
				return basicGetFormal();
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL:
				if (resolve) return getActual();
				return basicGetActual();
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL:
				if (resolve) return getOwnedActual();
				return basicGetOwnedActual();
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING:
				if (resolve) return getTemplateBinding();
				return basicGetTemplateBinding();
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
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL:
				setFormal((TemplateParameter)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL:
				setActual((ParameterableElement)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL:
				setOwnedActual((ParameterableElement)newValue);
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING:
				setTemplateBinding((TemplateBinding)newValue);
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
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL:
				setFormal((TemplateParameter)null);
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL:
				setActual((ParameterableElement)null);
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL:
				setOwnedActual((ParameterableElement)null);
				return;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING:
				setTemplateBinding((TemplateBinding)null);
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
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__FORMAL:
				return formal != null;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__ACTUAL:
				return actual != null;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__OWNED_ACTUAL:
				return ownedActual != null;
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION__TEMPLATE_BINDING:
				return basicGetTemplateBinding() != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP:
				return validateMustBeCompatible((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitTemplateParameterSubstitution(this);
	}
} //TemplateParameterSubstitutionImpl
