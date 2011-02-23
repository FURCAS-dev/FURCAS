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
 * $Id: LambdaTypeImpl.java,v 1.1 2011/02/15 10:38:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lambda Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl#getParameterTypes <em>Parameter Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.LambdaTypeImpl#getResultType <em>Result Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LambdaTypeImpl extends DataTypeImpl implements LambdaType
{
	/**
	 * The cached value of the '{@link #getContextType() <em>Context Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextType()
	 * @generated
	 * @ordered
	 */
	protected Type contextType;

	/**
	 * The cached value of the '{@link #getParameterTypes() <em>Parameter Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> parameterTypes;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected Type resultType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LambdaTypeImpl()
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
		return PivotPackage.Literals.LAMBDA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getContextType()
	{
		if (contextType != null && ((EObject)contextType).eIsProxy())
		{
			InternalEObject oldContextType = (InternalEObject)contextType;
			contextType = (Type)eResolveProxy(oldContextType);
			if (contextType != oldContextType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE, oldContextType, contextType));
			}
		}
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetContextType()
	{
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextType(Type newContextType)
	{
		Type oldContextType = contextType;
		contextType = newContextType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE, oldContextType, contextType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getParameterTypes()
	{
		if (parameterTypes == null)
		{
			parameterTypes = new EObjectResolvingEList<Type>(Type.class, this, PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE);
		}
		return parameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getResultType()
	{
		if (resultType != null && ((EObject)resultType).eIsProxy())
		{
			InternalEObject oldResultType = (InternalEObject)resultType;
			resultType = (Type)eResolveProxy(oldResultType);
			if (resultType != oldResultType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.LAMBDA_TYPE__RESULT_TYPE, oldResultType, resultType));
			}
		}
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetResultType()
	{
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultType(Type newResultType)
	{
		Type oldResultType = resultType;
		resultType = newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.LAMBDA_TYPE__RESULT_TYPE, oldResultType, resultType));
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
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.LAMBDA_TYPE__MONIKER:
				return getMoniker();
			case PivotPackage.LAMBDA_TYPE__NAME:
				return getName();
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				return getTemplateBindings();
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				if (resolve) return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				if (resolve) return getPackage();
				return basicGetPackage();
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				return getOwnedAttributes();
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				return getOwnedOperations();
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				return getSuperClasses();
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.LAMBDA_TYPE__SUB_CLASS:
				return getSubClasses();
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				return isSerializable();
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				if (resolve) return getBehavioralType();
				return basicGetBehavioralType();
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				if (resolve) return getContextType();
				return basicGetContextType();
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				return getParameterTypes();
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				if (resolve) return getResultType();
				return basicGetResultType();
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
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__SUB_CLASS:
				getSubClasses().clear();
				getSubClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				setContextType((Type)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				getParameterTypes().clear();
				getParameterTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				setResultType((Type)newValue);
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
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttributes().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				getOwnedOperations().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				getSuperClasses().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__SUB_CLASS:
				getSubClasses().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				setBehavioralType((Type)null);
				return;
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				setContextType((Type)null);
				return;
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				getParameterTypes().clear();
				return;
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				setResultType((Type)null);
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
			case PivotPackage.LAMBDA_TYPE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.LAMBDA_TYPE__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.LAMBDA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.LAMBDA_TYPE__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.LAMBDA_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_PARAMETER:
				return isSetTemplateParameter();
			case PivotPackage.LAMBDA_TYPE__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.LAMBDA_TYPE__PACKAGE:
				return basicGetPackage() != null;
			case PivotPackage.LAMBDA_TYPE__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case PivotPackage.LAMBDA_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__OWNED_ATTRIBUTE:
				return ownedAttributes != null && !ownedAttributes.isEmpty();
			case PivotPackage.LAMBDA_TYPE__OWNED_OPERATION:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.LAMBDA_TYPE__SUPER_CLASS:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.LAMBDA_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__SUB_CLASS:
				return subClasses != null && !subClasses.isEmpty();
			case PivotPackage.LAMBDA_TYPE__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case PivotPackage.LAMBDA_TYPE__BEHAVIORAL_TYPE:
				return behavioralType != null;
			case PivotPackage.LAMBDA_TYPE__CONTEXT_TYPE:
				return contextType != null;
			case PivotPackage.LAMBDA_TYPE__PARAMETER_TYPE:
				return parameterTypes != null && !parameterTypes.isEmpty();
			case PivotPackage.LAMBDA_TYPE__RESULT_TYPE:
				return resultType != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitLambdaType(this);
	}
} //LambdaTypeImpl
