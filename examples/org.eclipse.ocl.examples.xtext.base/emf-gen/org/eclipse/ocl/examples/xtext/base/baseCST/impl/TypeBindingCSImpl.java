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
 * $Id: TypeBindingCSImpl.java,v 1.2 2010/05/24 08:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Binding CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingCSImpl#getTypeParameter <em>Type Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingCSImpl#getTypeArgument <em>Type Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeBindingCSImpl extends ElementCSImpl implements TypeBindingCS {
	/**
	 * The cached value of the '{@link #getTypeParameter() <em>Type Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameter()
	 * @generated
	 * @ordered
	 */
	protected TypeParameterCS typeParameter;

	/**
	 * The cached value of the '{@link #getTypeArgument() <em>Type Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArgument()
	 * @generated
	 * @ordered
	 */
	protected ClassifierCS typeArgument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeBindingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.TYPE_BINDING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeParameterCS getTypeParameter() {
		return typeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeParameter(TypeParameterCS newTypeParameter) {
		TypeParameterCS oldTypeParameter = typeParameter;
		typeParameter = newTypeParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.TYPE_BINDING_CS__TYPE_PARAMETER, oldTypeParameter, typeParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierCS getTypeArgument() {
		return typeArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeArgument(ClassifierCS newTypeArgument) {
		ClassifierCS oldTypeArgument = typeArgument;
		typeArgument = newTypeArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.TYPE_BINDING_CS__TYPE_ARGUMENT, oldTypeArgument, typeArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_PARAMETER:
				return getTypeParameter();
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_ARGUMENT:
				return getTypeArgument();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_PARAMETER:
				setTypeParameter((TypeParameterCS)newValue);
				return;
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_ARGUMENT:
				setTypeArgument((ClassifierCS)newValue);
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
		switch (featureID) {
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_PARAMETER:
				setTypeParameter((TypeParameterCS)null);
				return;
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_ARGUMENT:
				setTypeArgument((ClassifierCS)null);
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
		switch (featureID) {
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_PARAMETER:
				return typeParameter != null;
			case BaseCSTPackage.TYPE_BINDING_CS__TYPE_ARGUMENT:
				return typeArgument != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		TypeParameterCS typeParameter = getTypeParameter();
		s.append(((NamedElementCS)typeParameter.eContainer()).getName());
		s.append("::"); //$NON-NLS-1$
		s.append(typeParameter.getName());
		s.append("="); //$NON-NLS-1$
		s.append(getTypeArgument().getSignature());
		return s.toString();
	}

	@Override
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		signature.appendElement(getTypeParameter(), typeBindings);
		signature.append("="); //$NON-NLS-1$
		signature.appendElement(getTypeArgument(), typeBindings);
	}

} //TypeBindingCSImpl
