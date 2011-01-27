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
 * $Id: TypeTemplateParameterImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.internal.operations.TypeTemplateParameterOperations;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl#isAllowSubstitutable <em>Allow Substitutable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl#getConstrainingTypes <em>Constraining Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.TypeTemplateParameterImpl#getParameteredElement <em>Parametered Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeTemplateParameterImpl
		extends TemplateParameterImpl
		implements TypeTemplateParameter {

	/**
	 * The default value of the '{@link #isAllowSubstitutable() <em>Allow Substitutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowSubstitutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_SUBSTITUTABLE_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isAllowSubstitutable() <em>Allow Substitutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowSubstitutable()
	 * @generated
	 * @ordered
	 */
	protected static final int ALLOW_SUBSTITUTABLE_EFLAG = 1 << 8;

	/**
	 * The cached value of the '{@link #getConstrainingTypes() <em>Constraining Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainingTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> constrainingTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeTemplateParameterImpl() {
		super();
		eFlags |= ALLOW_SUBSTITUTABLE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPE_TEMPLATE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowSubstitutable() {
		return (eFlags & ALLOW_SUBSTITUTABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowSubstitutable(boolean newAllowSubstitutable) {
		boolean oldAllowSubstitutable = (eFlags & ALLOW_SUBSTITUTABLE_EFLAG) != 0;
		if (newAllowSubstitutable) eFlags |= ALLOW_SUBSTITUTABLE_EFLAG; else eFlags &= ~ALLOW_SUBSTITUTABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE, oldAllowSubstitutable, newAllowSubstitutable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getConstrainingTypes() {
		if (constrainingTypes == null)
		{
			constrainingTypes = new EObjectResolvingEList<Type>(Type.class, this, PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE);
		}
		return constrainingTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterableElement getParameteredElement() {
		if (parameteredElement != null && ((EObject)parameteredElement).eIsProxy())
		{
			InternalEObject oldParameteredElement = (InternalEObject)parameteredElement;
			parameteredElement = (ParameterableElement)eResolveProxy(oldParameteredElement);
			if (parameteredElement != oldParameteredElement)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, oldParameteredElement, parameteredElement));
			}
		}
		return parameteredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterableElement basicGetParameteredElement() {
		return parameteredElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain basicSetParameteredElement(
			ParameterableElement newParameteredElement, NotificationChain msgs) {
		ParameterableElement oldParameteredElement = parameteredElement;
		parameteredElement = newParameteredElement;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, oldParameteredElement, newParameteredElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameteredElement(ParameterableElement newParameteredElement) {
		if (newParameteredElement != parameteredElement)
		{
			NotificationChain msgs = null;
			if (parameteredElement != null)
				msgs = ((InternalEObject)parameteredElement).eInverseRemove(this, PivotPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER, ParameterableElement.class, msgs);
			if (newParameteredElement != null)
				msgs = ((InternalEObject)newParameteredElement).eInverseAdd(this, PivotPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER, ParameterableElement.class, msgs);
			msgs = basicSetParameteredElement(newParameteredElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, newParameteredElement, newParameteredElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParameteredElement() {
		return parameteredElement != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHasConstrainingType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return TypeTemplateParameterOperations.validateHasConstrainingType(this, diagnostics, context);
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				if (resolve) return getSignature();
				return basicGetSignature();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				if (resolve) return getParameteredElement();
				return basicGetParameteredElement();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				if (resolve) return getOwnedParameteredElement();
				return basicGetOwnedParameteredElement();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				if (resolve) return getDefault();
				return basicGetDefault();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				if (resolve) return getOwnedDefault();
				return basicGetOwnedDefault();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE:
				return isAllowSubstitutable();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE:
				return getConstrainingTypes();
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				setSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				setParameteredElement((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				setOwnedParameteredElement((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				setDefault((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				setOwnedDefault((ParameterableElement)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE:
				setAllowSubstitutable((Boolean)newValue);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE:
				getConstrainingTypes().clear();
				getConstrainingTypes().addAll((Collection<? extends Type>)newValue);
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				setSignature((TemplateSignature)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				setParameteredElement((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				setOwnedParameteredElement((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				setDefault((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				setOwnedDefault((ParameterableElement)null);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE:
				setAllowSubstitutable(ALLOW_SUBSTITUTABLE_EDEFAULT);
				return;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE:
				getConstrainingTypes().clear();
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__SIGNATURE:
				return basicGetSignature() != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__PARAMETERED_ELEMENT:
				return isSetParameteredElement();
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT:
				return ownedParameteredElement != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__DEFAULT:
				return default_ != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__OWNED_DEFAULT:
				return ownedDefault != null;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__ALLOW_SUBSTITUTABLE:
				return ((eFlags & ALLOW_SUBSTITUTABLE_EFLAG) != 0) != ALLOW_SUBSTITUTABLE_EDEFAULT;
			case PivotPackage.TYPE_TEMPLATE_PARAMETER__CONSTRAINING_TYPE:
				return constrainingTypes != null && !constrainingTypes.isEmpty();
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
			case PivotPackage.TYPE_TEMPLATE_PARAMETER___VALIDATE_MUST_BE_COMPATIBLE__DIAGNOSTICCHAIN_MAP:
				return validateMustBeCompatible((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.TYPE_TEMPLATE_PARAMETER___VALIDATE_HAS_CONSTRAINING_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateHasConstrainingType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitTypeTemplateParameter(this);
	}
} //TypeTemplateParameterImpl
