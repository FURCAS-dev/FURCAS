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
 * $Id: CompleteTypeImpl.java,v 1.5 2011/03/01 08:47:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Constraint;
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
 * An implementation of the model object '<em><b>Complete Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl#getCompleteEnvironment <em>Complete Environment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl#getCompleteOperations <em>Complete Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl#getCompleteProperties <em>Complete Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl#getCompleteSuperTypes <em>Complete Super Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteTypeImpl
		extends ClassImpl
		implements CompleteType {

	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> models;

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
	 * The cached value of the '{@link #getCompleteOperations() <em>Complete Operation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteOperation> completeOperations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COMPLETE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getModel()
	{
		Type model = basicGetModel();
		return model != null && ((EObject)model).eIsProxy() ? (Type)eResolveProxy((InternalEObject)model) : model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Type basicGetModel()
	{
		return getModels().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getModels()
	{
		if (models == null)
		{
			models = new EObjectResolvingEList<Type>(Type.class, this, PivotPackage.COMPLETE_TYPE__MODELS);
		}
		return models;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT, oldCompleteEnvironment, completeEnvironment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteOperation> getCompleteOperations()
	{
		if (completeOperations == null)
		{
			completeOperations = new EObjectResolvingEList<CompleteOperation>(CompleteOperation.class, this, PivotPackage.COMPLETE_TYPE__COMPLETE_OPERATION);
		}
		return completeOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompleteSuperTypes()
	{
		return completeSuperTypes != null && !completeSuperTypes.isEmpty();
	}
	
	private Map<CompleteOperation, CompleteOperation> dynamicOperationMap = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CompleteOperation getDynamicOperation(CompleteOperation staticOperation) {
		if (dynamicOperationMap == null) {
			dynamicOperationMap = new HashMap<CompleteOperation, CompleteOperation>();
		}
		CompleteOperation dynamicOperation = dynamicOperationMap.get(staticOperation);
		if (dynamicOperation != null) {
			return dynamicOperation;
		}
		if (dynamicOperationMap.containsKey(staticOperation)) {
			return dynamicOperation;
		}
		dynamicOperation = completeEnvironment.getDynamicOperation(this, staticOperation);
		dynamicOperationMap.put(staticOperation, dynamicOperation);
		return dynamicOperation;
	}

	/**
	 * The cached value of the '{@link #getCompleteProperties() <em>Complete Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteProperty> completeProperties;

	/**
	 * The cached value of the '{@link #getCompleteSuperTypes() <em>Complete Super Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteType> completeSuperTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompleteProperties()
	{
		return completeProperties != null && !completeProperties.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteType> getCompleteSuperTypes()
	{
		if (completeSuperTypes == null)
		{
			completeSuperTypes = new EObjectResolvingEList<CompleteType>(CompleteType.class, this, PivotPackage.COMPLETE_TYPE__COMPLETE_SUPER_TYPE);
//			for (Type superType : getSuperClasses()) {
//				completeSuperTypes.add(completeEnvironment.getCompleteType(superType));
//			}
			for (Type model : models) {
				if (model instanceof org.eclipse.ocl.examples.pivot.Class) {
					org.eclipse.ocl.examples.pivot.Class thisModelClass = (org.eclipse.ocl.examples.pivot.Class)model;
					if (thisModelClass.getTemplateBindings().size() > 0) {
	//					thisModelClass = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class)model);
					}
					for (Type superType : thisModelClass.getSuperClasses()) {
						completeSuperTypes.add(completeEnvironment.getCompleteType(superType));
					}
				}
			}
		}
		return completeSuperTypes;
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
			case PivotPackage.COMPLETE_TYPE__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.COMPLETE_TYPE__MONIKER:
				return getMoniker();
			case PivotPackage.COMPLETE_TYPE__NAME:
				return getName();
			case PivotPackage.COMPLETE_TYPE__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.COMPLETE_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.COMPLETE_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.COMPLETE_TYPE__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_BINDING:
				return getTemplateBindings();
			case PivotPackage.COMPLETE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				if (resolve) return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case PivotPackage.COMPLETE_TYPE__PACKAGE:
				if (resolve) return getPackage();
				return basicGetPackage();
			case PivotPackage.COMPLETE_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.COMPLETE_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.COMPLETE_TYPE__OWNED_ATTRIBUTE:
				return getOwnedAttributes();
			case PivotPackage.COMPLETE_TYPE__OWNED_OPERATION:
				return getOwnedOperations();
			case PivotPackage.COMPLETE_TYPE__SUPER_CLASS:
				return getSuperClasses();
			case PivotPackage.COMPLETE_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.COMPLETE_TYPE__SUB_CLASS:
				return getSubClasses();
			case PivotPackage.COMPLETE_TYPE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case PivotPackage.COMPLETE_TYPE__MODELS:
				return getModels();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT:
				if (resolve) return getCompleteEnvironment();
				return basicGetCompleteEnvironment();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_OPERATION:
				return getCompleteOperations();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_PROPERTY:
				return getCompleteProperties();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_SUPER_TYPE:
				return getCompleteSuperTypes();
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
			case PivotPackage.COMPLETE_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_OPERATION:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__SUPER_CLASS:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__SUB_CLASS:
				getSubClasses().clear();
				getSubClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends Type>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT:
				setCompleteEnvironment((CompleteEnvironment)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_OPERATION:
				getCompleteOperations().clear();
				getCompleteOperations().addAll((Collection<? extends CompleteOperation>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_PROPERTY:
				getCompleteProperties().clear();
				getCompleteProperties().addAll((Collection<? extends CompleteProperty>)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_SUPER_TYPE:
				getCompleteSuperTypes().clear();
				getCompleteSuperTypes().addAll((Collection<? extends CompleteType>)newValue);
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
			case PivotPackage.COMPLETE_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.COMPLETE_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.COMPLETE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttributes().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__OWNED_OPERATION:
				getOwnedOperations().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__SUPER_CLASS:
				getSuperClasses().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.COMPLETE_TYPE__SUB_CLASS:
				getSubClasses().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__MODELS:
				getModels().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT:
				setCompleteEnvironment((CompleteEnvironment)null);
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_OPERATION:
				getCompleteOperations().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_PROPERTY:
				getCompleteProperties().clear();
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_SUPER_TYPE:
				getCompleteSuperTypes().clear();
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
			case PivotPackage.COMPLETE_TYPE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COMPLETE_TYPE__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.COMPLETE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COMPLETE_TYPE__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.COMPLETE_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COMPLETE_TYPE__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COMPLETE_TYPE__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_PARAMETER:
				return isSetTemplateParameter();
			case PivotPackage.COMPLETE_TYPE__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case PivotPackage.COMPLETE_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.COMPLETE_TYPE__PACKAGE:
				return basicGetPackage() != null;
			case PivotPackage.COMPLETE_TYPE__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case PivotPackage.COMPLETE_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.COMPLETE_TYPE__OWNED_ATTRIBUTE:
				return isSetOwnedAttributes();
			case PivotPackage.COMPLETE_TYPE__OWNED_OPERATION:
				return isSetOwnedOperations();
			case PivotPackage.COMPLETE_TYPE__SUPER_CLASS:
				return isSetSuperClasses();
			case PivotPackage.COMPLETE_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.COMPLETE_TYPE__SUB_CLASS:
				return subClasses != null && !subClasses.isEmpty();
			case PivotPackage.COMPLETE_TYPE__MODEL:
				return basicGetModel() != null;
			case PivotPackage.COMPLETE_TYPE__MODELS:
				return models != null && !models.isEmpty();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT:
				return completeEnvironment != null;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_OPERATION:
				return isSetCompleteOperations();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_PROPERTY:
				return isSetCompleteProperties();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_SUPER_TYPE:
				return isSetCompleteSuperTypes();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.COMPLETE_TYPE___HAS_MONIKER:
				return hasMoniker();
			case PivotPackage.COMPLETE_TYPE___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.COMPLETE_TYPE___PARAMETERABLE_ELEMENTS:
				return parameterableElements();
			case PivotPackage.COMPLETE_TYPE___IS_TEMPLATE:
				return isTemplate();
			case PivotPackage.COMPLETE_TYPE___GET_DYNAMIC_OPERATION__COMPLETEOPERATION:
				return getDynamicOperation((CompleteOperation)arguments.get(0));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getOwnedOperations()
	{
		@SuppressWarnings("unchecked")
		EList<Operation> completeOperation = (EList<Operation>)((EList<?>)getCompleteOperations());
		return completeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedOperations()
	{
  		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getOwnedAttributes()
	{
		@SuppressWarnings("unchecked")
		EList<Property> completeProperty = (EList<Property>)((EList<?>)getCompleteProperties());
		return completeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedAttributes()
	{
  		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<org.eclipse.ocl.examples.pivot.Class> getSuperClasses()
	{
		@SuppressWarnings("unchecked")
		EList<org.eclipse.ocl.examples.pivot.Class> completeSuperType = (EList<org.eclipse.ocl.examples.pivot.Class>)((EList<?>)getCompleteSuperTypes());
		return completeSuperType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuperClasses()
	{
  		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompleteOperations()
	{
		return completeOperations != null && !completeOperations.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteProperty> getCompleteProperties()
	{
		if (completeProperties == null)
		{
			completeProperties = new EObjectResolvingEList<CompleteProperty>(CompleteProperty.class, this, PivotPackage.COMPLETE_TYPE__COMPLETE_PROPERTY);
		}
		return completeProperties;
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCompleteType(this);
	}
} //CompleteClassImpl
