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
 * $Id: CompletePropertyImpl.java,v 1.3 2011/01/27 06:59:07 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePropertyImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePropertyImpl#getCompleteEnvironment <em>Complete Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletePropertyImpl
		extends PropertyImpl
		implements CompleteProperty {

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Property model;

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
	protected CompletePropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COMPLETE_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getModel() {
		if (model != null && ((EObject)model).eIsProxy())
		{
			InternalEObject oldModel = (InternalEObject)model;
			model = (Property)eResolveProxy(oldModel);
			if (model != oldModel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_PROPERTY__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Property newModel) {
		Property oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_PROPERTY__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteEnvironment getCompleteEnvironment() {
		if (completeEnvironment != null && ((EObject)completeEnvironment).eIsProxy())
		{
			InternalEObject oldCompleteEnvironment = (InternalEObject)completeEnvironment;
			completeEnvironment = (CompleteEnvironment)eResolveProxy(oldCompleteEnvironment);
			if (completeEnvironment != oldCompleteEnvironment)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
			}
		}
		return completeEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteEnvironment basicGetCompleteEnvironment() {
		return completeEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompleteEnvironment(
			CompleteEnvironment newCompleteEnvironment) {
		CompleteEnvironment oldCompleteEnvironment = completeEnvironment;
		completeEnvironment = newCompleteEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
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
			case PivotPackage.COMPLETE_PROPERTY__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.COMPLETE_PROPERTY__MONIKER:
				return getMoniker();
			case PivotPackage.COMPLETE_PROPERTY__NAME:
				return getName();
			case PivotPackage.COMPLETE_PROPERTY__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.COMPLETE_PROPERTY__IS_STATIC:
				return isStatic();
			case PivotPackage.COMPLETE_PROPERTY__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.COMPLETE_PROPERTY__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COMPLETE_PROPERTY__IS_ORDERED:
				return isOrdered();
			case PivotPackage.COMPLETE_PROPERTY__IS_UNIQUE:
				return isUnique();
			case PivotPackage.COMPLETE_PROPERTY__LOWER:
				return getLower();
			case PivotPackage.COMPLETE_PROPERTY__UPPER:
				return getUpper();
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION:
				return getImplementation();
			case PivotPackage.COMPLETE_PROPERTY__FEATURING_CLASS:
				return getFeaturingClass();
			case PivotPackage.COMPLETE_PROPERTY__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.COMPLETE_PROPERTY__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.COMPLETE_PROPERTY__IS_READ_ONLY:
				return isReadOnly();
			case PivotPackage.COMPLETE_PROPERTY__DEFAULT:
				return getDefault();
			case PivotPackage.COMPLETE_PROPERTY__IS_COMPOSITE:
				return isComposite();
			case PivotPackage.COMPLETE_PROPERTY__IS_DERIVED:
				return isDerived();
			case PivotPackage.COMPLETE_PROPERTY__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case PivotPackage.COMPLETE_PROPERTY__ASSOCIATION:
				if (resolve) return getAssociation();
				return basicGetAssociation();
			case PivotPackage.COMPLETE_PROPERTY__IMPLICIT:
				return isImplicit();
			case PivotPackage.COMPLETE_PROPERTY__IS_ID:
				return isID();
			case PivotPackage.COMPLETE_PROPERTY__KEYS:
				return getKeys();
			case PivotPackage.COMPLETE_PROPERTY__IS_RESOLVE_PROXIES:
				return isResolveProxies();
			case PivotPackage.COMPLETE_PROPERTY__IS_TRANSIENT:
				return isTransient();
			case PivotPackage.COMPLETE_PROPERTY__IS_UNSETTABLE:
				return isUnsettable();
			case PivotPackage.COMPLETE_PROPERTY__IS_VOLATILE:
				return isVolatile();
			case PivotPackage.COMPLETE_PROPERTY__CLASS:
				if (resolve) return getClass_();
				return basicGetClass_();
			case PivotPackage.COMPLETE_PROPERTY__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case PivotPackage.COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT:
				if (resolve) return getCompleteEnvironment();
				return basicGetCompleteEnvironment();
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
			case PivotPackage.COMPLETE_PROPERTY__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__LOWER:
				setLower((BigInteger)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__UPPER:
				setUpper((BigInteger)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION_CLASS:
				setImplementationClass((String)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION:
				setImplementation((CallableImplementation)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_READ_ONLY:
				setIsReadOnly((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__DEFAULT:
				setDefault((String)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_COMPOSITE:
				setIsComposite((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_DERIVED:
				setIsDerived((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OPPOSITE:
				setOpposite((Property)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__ASSOCIATION:
				setAssociation((AssociationClass)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_ID:
				setIsID((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_RESOLVE_PROXIES:
				setIsResolveProxies((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_TRANSIENT:
				setIsTransient((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_UNSETTABLE:
				setIsUnsettable((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_VOLATILE:
				setIsVolatile((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__MODEL:
				setModel((Property)newValue);
				return;
			case PivotPackage.COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT:
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COMPLETE_PROPERTY__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.COMPLETE_PROPERTY__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COMPLETE_PROPERTY__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION_CLASS:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COMPLETE_PROPERTY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_READ_ONLY:
				setIsReadOnly(IS_READ_ONLY_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_COMPOSITE:
				setIsComposite(IS_COMPOSITE_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_DERIVED:
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__OPPOSITE:
				setOpposite((Property)null);
				return;
			case PivotPackage.COMPLETE_PROPERTY__ASSOCIATION:
				setAssociation((AssociationClass)null);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_ID:
				setIsID(IS_ID_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__KEYS:
				getKeys().clear();
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_RESOLVE_PROXIES:
				setIsResolveProxies(IS_RESOLVE_PROXIES_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_TRANSIENT:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_UNSETTABLE:
				setIsUnsettable(IS_UNSETTABLE_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__IS_VOLATILE:
				setIsVolatile(IS_VOLATILE_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PROPERTY__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)null);
				return;
			case PivotPackage.COMPLETE_PROPERTY__MODEL:
				setModel((Property)null);
				return;
			case PivotPackage.COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT:
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COMPLETE_PROPERTY__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COMPLETE_PROPERTY__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.COMPLETE_PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COMPLETE_PROPERTY__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.COMPLETE_PROPERTY__IS_STATIC:
				return isSetIsStatic();
			case PivotPackage.COMPLETE_PROPERTY__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COMPLETE_PROPERTY__TYPE:
				return type != null;
			case PivotPackage.COMPLETE_PROPERTY__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__IS_UNIQUE:
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case PivotPackage.COMPLETE_PROPERTY__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case PivotPackage.COMPLETE_PROPERTY__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case PivotPackage.COMPLETE_PROPERTY__FEATURING_CLASS:
				return getFeaturingClass() != null;
			case PivotPackage.COMPLETE_PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.COMPLETE_PROPERTY__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.COMPLETE_PROPERTY__IS_READ_ONLY:
				return ((eFlags & IS_READ_ONLY_EFLAG) != 0) != IS_READ_ONLY_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case PivotPackage.COMPLETE_PROPERTY__IS_COMPOSITE:
				return ((eFlags & IS_COMPOSITE_EFLAG) != 0) != IS_COMPOSITE_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__IS_DERIVED:
				return ((eFlags & IS_DERIVED_EFLAG) != 0) != IS_DERIVED_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__OPPOSITE:
				return opposite != null;
			case PivotPackage.COMPLETE_PROPERTY__ASSOCIATION:
				return association != null;
			case PivotPackage.COMPLETE_PROPERTY__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__IS_ID:
				return ((eFlags & IS_ID_EFLAG) != 0) != IS_ID_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__KEYS:
				return keys != null && !keys.isEmpty();
			case PivotPackage.COMPLETE_PROPERTY__IS_RESOLVE_PROXIES:
				return ((eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0) != IS_RESOLVE_PROXIES_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__IS_TRANSIENT:
				return ((eFlags & IS_TRANSIENT_EFLAG) != 0) != IS_TRANSIENT_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__IS_UNSETTABLE:
				return ((eFlags & IS_UNSETTABLE_EFLAG) != 0) != IS_UNSETTABLE_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__IS_VOLATILE:
				return ((eFlags & IS_VOLATILE_EFLAG) != 0) != IS_VOLATILE_EDEFAULT;
			case PivotPackage.COMPLETE_PROPERTY__CLASS:
				return basicGetClass_() != null;
			case PivotPackage.COMPLETE_PROPERTY__MODEL:
				return model != null;
			case PivotPackage.COMPLETE_PROPERTY__COMPLETE_ENVIRONMENT:
				return completeEnvironment != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCompleteProperty(this);
	}
} //CompletePropertyImpl
