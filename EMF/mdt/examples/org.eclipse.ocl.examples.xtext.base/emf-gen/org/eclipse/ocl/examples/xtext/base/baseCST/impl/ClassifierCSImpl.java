/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ClassifierCSImpl.java,v 1.4 2011/01/24 20:59:32 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl#getOwnedTemplateSignature <em>Owned Template Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassifierCSImpl extends NamedElementCSImpl implements ClassifierCS {
	/**
	 * The cached value of the '{@link #getOwnedTemplateSignature() <em>Owned Template Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignatureCS ownedTemplateSignature;
	/**
	 * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;
	/**
	 * This is true if the Instance Class Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean instanceClassNameESet;
	/**
	 * The cached value of the '{@link #getOwnedConstraint() <em>Owned Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> ownedConstraint;
	/**
	 * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected EList<String> qualifier;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.CLASSIFIER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignatureCS getOwnedTemplateSignature() {
		return ownedTemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateSignature(TemplateSignatureCS newOwnedTemplateSignature, NotificationChain msgs) {
		TemplateSignatureCS oldOwnedTemplateSignature = ownedTemplateSignature;
		ownedTemplateSignature = newOwnedTemplateSignature;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE, oldOwnedTemplateSignature, newOwnedTemplateSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedTemplateSignature(TemplateSignatureCS newOwnedTemplateSignature) {
		if (newOwnedTemplateSignature != ownedTemplateSignature)
		{
			NotificationChain msgs = null;
			if (ownedTemplateSignature != null)
				msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, TemplateSignatureCS.class, msgs);
			if (newOwnedTemplateSignature != null)
				msgs = ((InternalEObject)newOwnedTemplateSignature).eInverseAdd(this, BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, TemplateSignatureCS.class, msgs);
			msgs = basicSetOwnedTemplateSignature(newOwnedTemplateSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE, newOwnedTemplateSignature, newOwnedTemplateSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageCS getOwner() {
		if (eContainerFeatureID() != BaseCSTPackage.CLASSIFIER_CS__OWNER) return null;
		return (PackageCS)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(PackageCS newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, BaseCSTPackage.CLASSIFIER_CS__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(PackageCS newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != BaseCSTPackage.CLASSIFIER_CS__OWNER && newOwner != null))
		{
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, BaseCSTPackage.PACKAGE_CS__OWNED_TYPE, PackageCS.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.CLASSIFIER_CS__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceClassName()
	{
		return instanceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceClassName(String newInstanceClassName)
	{
		String oldInstanceClassName = instanceClassName;
		instanceClassName = newInstanceClassName;
		boolean oldInstanceClassNameESet = instanceClassNameESet;
		instanceClassNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME, oldInstanceClassName, instanceClassName, !oldInstanceClassNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInstanceClassName()
	{
		String oldInstanceClassName = instanceClassName;
		boolean oldInstanceClassNameESet = instanceClassNameESet;
		instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;
		instanceClassNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME, oldInstanceClassName, INSTANCE_CLASS_NAME_EDEFAULT, oldInstanceClassNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInstanceClassName()
	{
		return instanceClassNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getOwnedConstraint()
	{
		if (ownedConstraint == null)
		{
			ownedConstraint = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT);
		}
		return ownedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getQualifier()
	{
		if (qualifier == null)
		{
			qualifier = new EDataTypeUniqueEList<String>(String.class, this, BaseCSTPackage.CLASSIFIER_CS__QUALIFIER);
		}
		return qualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TemplateSignatureCS getTemplateSignature() {
		return getOwnedTemplateSignature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignatureCS)otherEnd, msgs);
			case BaseCSTPackage.CLASSIFIER_CS__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((PackageCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case BaseCSTPackage.CLASSIFIER_CS__OWNER:
				return basicSetOwner(null, msgs);
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT:
				return ((InternalEList<?>)getOwnedConstraint()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case BaseCSTPackage.CLASSIFIER_CS__OWNER:
				return eInternalContainer().eInverseRemove(this, BaseCSTPackage.PACKAGE_CS__OWNED_TYPE, PackageCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case BaseCSTPackage.CLASSIFIER_CS__OWNER:
				return getOwner();
			case BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT:
				return getOwnedConstraint();
			case BaseCSTPackage.CLASSIFIER_CS__QUALIFIER:
				return getQualifier();
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
		switch (featureID)
		{
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignatureCS)newValue);
				return;
			case BaseCSTPackage.CLASSIFIER_CS__OWNER:
				setOwner((PackageCS)newValue);
				return;
			case BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				getOwnedConstraint().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case BaseCSTPackage.CLASSIFIER_CS__QUALIFIER:
				getQualifier().clear();
				getQualifier().addAll((Collection<? extends String>)newValue);
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
		switch (featureID)
		{
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignatureCS)null);
				return;
			case BaseCSTPackage.CLASSIFIER_CS__OWNER:
				setOwner((PackageCS)null);
				return;
			case BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME:
				unsetInstanceClassName();
				return;
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				return;
			case BaseCSTPackage.CLASSIFIER_CS__QUALIFIER:
				getQualifier().clear();
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
		switch (featureID)
		{
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case BaseCSTPackage.CLASSIFIER_CS__OWNER:
				return getOwner() != null;
			case BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT:
				return ownedConstraint != null && !ownedConstraint.isEmpty();
			case BaseCSTPackage.CLASSIFIER_CS__QUALIFIER:
				return qualifier != null && !qualifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TypeCS.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == TemplateableElementCS.class)
		{
			switch (derivedFeatureID)
			{
				case BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE: return BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE;
				default: return -1;
			}
		}
		if (baseClass == ParameterableElementCS.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TypeCS.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == TemplateableElementCS.class)
		{
			switch (baseFeatureID)
			{
				case BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE: return BaseCSTPackage.CLASSIFIER_CS__OWNED_TEMPLATE_SIGNATURE;
				default: return -1;
			}
		}
		if (baseClass == ParameterableElementCS.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitClassifierCS(this);
	}
} //ClassifierCSImpl
