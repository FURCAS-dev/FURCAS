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
 * $Id: CompletePackageImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl#getCompleteEnvironment <em>Complete Environment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl#getCompleteTypes <em>Complete Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompletePackageImpl#getCompletePackages <em>Complete Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletePackageImpl
		extends PackageImpl
		implements CompletePackage {

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.examples.pivot.Package model;

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
	protected CompletePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COMPLETE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package getModel() {
		if (model != null && ((EObject)model).eIsProxy())
		{
			InternalEObject oldModel = (InternalEObject)model;
			model = (org.eclipse.ocl.examples.pivot.Package)eResolveProxy(oldModel);
			if (model != oldModel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_PACKAGE__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(org.eclipse.ocl.examples.pivot.Package newModel) {
		org.eclipse.ocl.examples.pivot.Package oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_PACKAGE__MODEL, oldModel, model));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteType> getCompleteTypes()
	{
		// TODO: implement this method to return the 'Complete Type' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompletePackage> getCompletePackages() {
		// TODO: implement this method to return the 'Complete Package' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.COMPLETE_PACKAGE__MONIKER:
				return getMoniker();
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				return getName();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.COMPLETE_PACKAGE__IS_STATIC:
				return isStatic();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.COMPLETE_PACKAGE__TEMPLATE_BINDING:
				return getTemplateBindings();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				if (resolve) return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case PivotPackage.COMPLETE_PACKAGE__NESTED_PACKAGE:
				return getNestedPackages();
			case PivotPackage.COMPLETE_PACKAGE__NESTING_PACKAGE:
				if (resolve) return getNestingPackage();
				return basicGetNestingPackage();
			case PivotPackage.COMPLETE_PACKAGE__NS_PREFIX:
				return getNsPrefix();
			case PivotPackage.COMPLETE_PACKAGE__NS_URI:
				return getNsURI();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_PRECEDENCE:
				return getOwnedPrecedences();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TYPE:
				return getOwnedTypes();
			case PivotPackage.COMPLETE_PACKAGE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT:
				if (resolve) return getCompleteEnvironment();
				return basicGetCompleteEnvironment();
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_TYPE:
				return getCompleteTypes();
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_PACKAGE:
				return getCompletePackages();
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
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NESTED_PACKAGE:
				getNestedPackages().clear();
				getNestedPackages().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NS_URI:
				setNsURI((String)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_PRECEDENCE:
				getOwnedPrecedences().clear();
				getOwnedPrecedences().addAll((Collection<? extends Precedence>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TYPE:
				getOwnedTypes().clear();
				getOwnedTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__MODEL:
				setModel((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT:
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
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NESTED_PACKAGE:
				getNestedPackages().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PACKAGE__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_PRECEDENCE:
				getOwnedPrecedences().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TYPE:
				getOwnedTypes().clear();
				return;
			case PivotPackage.COMPLETE_PACKAGE__MODEL:
				setModel((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT:
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
			case PivotPackage.COMPLETE_PACKAGE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.COMPLETE_PACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COMPLETE_PACKAGE__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.COMPLETE_PACKAGE__NESTED_PACKAGE:
				return nestedPackages != null && !nestedPackages.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__NESTING_PACKAGE:
				return basicGetNestingPackage() != null;
			case PivotPackage.COMPLETE_PACKAGE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case PivotPackage.COMPLETE_PACKAGE__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case PivotPackage.COMPLETE_PACKAGE__OWNED_PRECEDENCE:
				return ownedPrecedences != null && !ownedPrecedences.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__OWNED_TYPE:
				return ownedTypes != null && !ownedTypes.isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__MODEL:
				return model != null;
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_ENVIRONMENT:
				return completeEnvironment != null;
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_TYPE:
				return !getCompleteTypes().isEmpty();
			case PivotPackage.COMPLETE_PACKAGE__COMPLETE_PACKAGE:
				return !getCompletePackages().isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCompletePackage(this);
	}
} //CompletePackageImpl
