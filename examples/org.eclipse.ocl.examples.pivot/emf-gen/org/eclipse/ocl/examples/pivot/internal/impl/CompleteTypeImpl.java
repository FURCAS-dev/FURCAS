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
 * $Id: CompleteTypeImpl.java,v 1.3 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.CompleteIteration;
import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.CompleteEnvironmentManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CompleteTypeImpl#getModel <em>Model</em>}</li>
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
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Type model;

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
	public Type getModel() {
		if (model != null && ((EObject)model).eIsProxy())
		{
			InternalEObject oldModel = (InternalEObject)model;
			model = (Type)eResolveProxy(oldModel);
			if (model != oldModel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COMPLETE_TYPE__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Type newModel)
	{
		Type oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COMPLETE_TYPE__MODEL, oldModel, model));
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

	private EList<CompleteType> completeSuperTypes = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<CompleteType> getCompleteSuperTypes() {
		if (completeSuperTypes == null) {
			completeSuperTypes = new UniqueEList<CompleteType>();
			for (Type superType : getSuperClasses()) {
				completeSuperTypes.add(completeEnvironment.getCompleteType(superType));
			}
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
		return completeSuperTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean conformsTo(CompleteType aType) {
		if (this == aType) {
			return true;
		}
		for (CompleteType aSuperType : getCompleteSuperTypes()) {
			if (aSuperType.conformsTo(aType)) {
				return true;
			}
		}
		return false;
	}

	private Map<CompleteIteration, CompleteIteration> dynamicIterationMap = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CompleteIteration getDynamicIteration(CompleteIteration staticIteration)
	{
		if (dynamicIterationMap == null) {
			dynamicIterationMap = new HashMap<CompleteIteration, CompleteIteration>();
		}
		CompleteIteration dynamicIteration = dynamicIterationMap.get(staticIteration);
		if ((dynamicIteration == null)
			&& !dynamicIterationMap.containsKey(staticIteration)) {
			Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, model);
			Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions2 = PivotUtil.getAllTemplateParameterSubstitutions(null, staticIteration.getModel());
			List<Type> staticCompleteIteratorTypes = new ArrayList<Type>();
			for (Parameter staticIterator : staticIteration.getCompleteIterators()) {
				staticCompleteIteratorTypes.add(resolveType(staticIterator.getType(), bindings));
			}
			List<Type> staticCompleteAccumulatorTypes = new ArrayList<Type>();
			for (Parameter staticAccumulator : staticIteration.getCompleteAccumulators()) {
				staticCompleteAccumulatorTypes.add(resolveType(staticAccumulator.getType(), bindings));
			}
			List<Type> staticCompleteParameterTypes = new ArrayList<Type>();
			for (Parameter staticParameter : staticIteration.getCompleteParameters()) {
				staticCompleteParameterTypes.add(resolveType(staticParameter.getType(), bindings));
			}
			Set<CompleteIteration> dynamicIterations = findIterationsOrNull(
				this, staticIteration.getName(), staticCompleteIteratorTypes, staticCompleteAccumulatorTypes, staticCompleteParameterTypes);
			if (dynamicIterations != null) {
				if (dynamicIterations.size() == 1) {
					dynamicIteration = dynamicIterations.iterator().next();
				}
				else if (dynamicIterations.size() > 1) {
					CompleteIteration conformantIteration = null;
					boolean ok = true;
					for (CompleteIteration completeIteration : dynamicIterations) {
						if (conformantIteration == null) {
							conformantIteration = completeIteration;
						}
						else {
							org.eclipse.ocl.examples.pivot.Class completeClass = PivotUtil.getFeaturingClass(completeIteration.getModel());
							org.eclipse.ocl.examples.pivot.Class conformantClass = PivotUtil.getFeaturingClass(conformantIteration.getModel());
							if (conformsTo(completeClass, conformantClass)) {
								conformantIteration = completeIteration;
							}
							else if (!conformsTo(conformantClass, completeClass)) {
								ok = false;
							}
						}
					}
					if (ok) {
						dynamicIteration = conformantIteration;
					}
				}
			}
			dynamicIterationMap.put(staticIteration, dynamicIteration);
		}
		return dynamicIteration;
	}

	private static boolean conformsTo(Type aClass, Type requiredClass) {
		return conformsTo((org.eclipse.ocl.examples.pivot.Class)aClass, (org.eclipse.ocl.examples.pivot.Class)requiredClass);
	}

	private static boolean conformsTo(org.eclipse.ocl.examples.pivot.Class aClass, org.eclipse.ocl.examples.pivot.Class requiredClass) {
		if (aClass == requiredClass) {
			return true;
		}
		for (org.eclipse.ocl.examples.pivot.Class superClass : aClass.getSuperClasses()) {
			if (conformsTo(PivotUtil.getUnspecializedTemplateableElement(superClass), requiredClass)) {
				return true;
			}
		}
		return false;
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
		if ((dynamicOperation == null)
			&& !dynamicOperationMap.containsKey(staticOperation)) {
			Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(null, model);
			PivotUtil.getAllTemplateParameterSubstitutions(templateParameterSubstitutions, staticOperation.getModel());
			List<Type> staticCompleteTypes = new ArrayList<Type>();
			for (Parameter staticParameter : staticOperation.getCompleteParameters()) {
				staticCompleteTypes.add(resolveType(staticParameter.getType(), templateParameterSubstitutions));
			}
			Set<CompleteOperation> dynamicOperations = findOperationsOrNull(
				this, staticOperation.getName(), staticCompleteTypes, templateParameterSubstitutions);
			if ((dynamicOperations != null) && (dynamicOperations.size() == 1)) {
				dynamicOperation = dynamicOperations.iterator().next();
			}
			dynamicOperationMap.put(staticOperation, dynamicOperation);
		}
		return dynamicOperation;
	}

	private Type resolveType(Type type, Map<TemplateParameter, ParameterableElement> bindings) {
/*		TemplateParameter templateParameter = type.getOwningTemplateParameter();
		if ((templateParameter != null) && (templateParameterSubstitutions != null)) {
			ParameterableElement parameterableElement = templateParameterSubstitutions.get(templateParameter);
			if (parameterableElement instanceof Type) {
				type = (Type) parameterableElement;
			}
			else if (parameterableElement != null) {
				type = (Type) templateParameter.getParameteredElement();
			}
			else {
				return type;
			}
		} */
		TypeManager typeManager = ((CompleteEnvironmentManager) completeEnvironment).getTypeManager();
		Type specializedType = typeManager.getSpecializedType(type, bindings);
		return completeEnvironment.getCompleteType(specializedType); 
	}

	private Set<CompleteIteration> findIterationsOrNull(CompleteType completeType,
			String operationName, List<Type> staticCompleteIteratorTypes,
			List<Type> staticCompleteAccumulatorTypes, List<Type> staticCompleteParameterTypes) {
		Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions = PivotUtil.getAllTemplateParameterSubstitutions(null, model);
		int staticIteratorsSize = staticCompleteIteratorTypes.size();
		Set<CompleteIteration> list = null;
		for (CompleteIteration dynamicIteration : completeType.getCompleteIterations(operationName)) {
			Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions2 = PivotUtil.getAllTemplateParameterSubstitutions(null, dynamicIteration.getModel());
			List<Parameter> dynamicIterators = dynamicIteration.getCompleteIterators();
			if (staticIteratorsSize == dynamicIterators.size()) {
				boolean gotIt = true;
				for (int i = 0; i < staticIteratorsSize; i++) {
					Type staticCompleteIteratorType = staticCompleteIteratorTypes.get(i);
					Parameter dynamicIterator = dynamicIterators.get(i);
					Type dynamicCompleteIteratorType = resolveType(dynamicIterator.getType(), templateParameterSubstitutions);
					if (!conformsTo(dynamicCompleteIteratorType, staticCompleteIteratorType)) {
						gotIt = false;
					}
				}
				if (gotIt) {
					if (list == null) {
						list = new HashSet<CompleteIteration>();
					}
					list.add(dynamicIteration);
				}
			}
		}
		if (list == null) {
			for (CompleteType completeSuperType : completeType.getCompleteSuperTypes()) {
				Set<CompleteIteration> superIterations = findIterationsOrNull(
					completeSuperType, operationName, staticCompleteIteratorTypes,
					staticCompleteAccumulatorTypes, staticCompleteParameterTypes);
				if (superIterations != null) {
					if (list == null) {
						list = superIterations;
					} else {
						list.addAll(superIterations);
					}
				}
			}
		}
		return list;
	}

	private Set<CompleteOperation> findOperationsOrNull(CompleteType completeType,
			String operationName, List<Type> staticCompleteTypes, Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions) {
		int staticParametersSize = staticCompleteTypes.size();
		Set<CompleteOperation> list = null;
		for (CompleteOperation dynamicOperation : completeType.getCompleteOperations(operationName)) {
			List<Parameter> dynamicParameters = dynamicOperation.getCompleteParameters();
			if (staticParametersSize == dynamicParameters.size()) {
				boolean gotIt = true;
				for (int i = 0; i < staticParametersSize; i++) {
					Type staticCompleteType = staticCompleteTypes.get(i);
					Parameter dynamicParameter = dynamicParameters.get(i);
					Type dynamicCompleteType = resolveType(dynamicParameter.getType(), templateParameterSubstitutions);
					if (!conformsTo(dynamicCompleteType, staticCompleteType)) {
						gotIt = false;
					}
				}
				if (gotIt) {
					if (list == null) {
						list = new HashSet<CompleteOperation>();
					}
					list.add(dynamicOperation);
				}
			}
		}
		if (list == null) {
			for (CompleteType completeSuperType : completeType.getCompleteSuperTypes()) {
				Set<CompleteOperation> superOperations = findOperationsOrNull(
					completeSuperType, operationName, staticCompleteTypes, templateParameterSubstitutions);
				if (superOperations != null) {
					if (list == null) {
						list = superOperations;
					} else {
						list.addAll(superOperations);
					}
				}
			}
		}
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<CompleteIteration> getCompleteIterations(String name) {
		EList<CompleteIteration> completeIterations = new BasicEList<CompleteIteration>();
		for (Operation operation : getOwnedOperations()) {
			if ((operation instanceof Iteration) && name.equals(operation.getName())) {
				completeIterations.add(completeEnvironment
					.getCompleteIteration((Iteration)operation));
			}
		}
		Type thisModel = model;
		if (thisModel.getTemplateBindings().size() > 0) {
			thisModel = PivotUtil.getUnspecializedTemplateableElement(thisModel);
		}
		if (thisModel instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (Operation operation : ((org.eclipse.ocl.examples.pivot.Class)thisModel).getOwnedOperations()) {
				if ((operation instanceof Iteration) && name.equals(operation.getName())) {
					CompleteIteration completeIteration = completeEnvironment
						.getCompleteIteration((Iteration)operation);
					if (!completeIterations.contains(completeIteration)) {
						completeIterations.add(completeIteration);
					}
				}
			}
		}
		return completeIterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<CompleteOperation> getCompleteOperations(String name) {
		EList<CompleteOperation> completeOperations = new BasicEList<CompleteOperation>();
		for (Operation operation : getOwnedOperations()) {
			if (name.equals(operation.getName())) {
				completeOperations.add(completeEnvironment
					.getCompleteOperation(operation));
			}
		}
		Type thisModel = model;
		if (thisModel.getTemplateBindings().size() > 0) {
			thisModel = PivotUtil.getUnspecializedTemplateableElement(thisModel);
		}
		if (thisModel instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (Operation operation : ((org.eclipse.ocl.examples.pivot.Class)thisModel).getOwnedOperations()) {
				if (name.equals(operation.getName())) {
					CompleteOperation completeOperation = completeEnvironment
						.getCompleteOperation(operation);
					if (!completeOperations.contains(completeOperation)) {
						completeOperations.add(completeOperation);
					}
				}
			}
		}
		return completeOperations;
	}

	private EList<CompleteProperty> completeProperties = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<CompleteProperty> getCompleteProperties() {
		if (completeProperties == null) {
			completeProperties = new BasicEList<CompleteProperty>();
			for (Property property : getOwnedAttributes()) {
				completeProperties.add(completeEnvironment
					.getCompleteProperty(property));
			}
			if (model instanceof org.eclipse.ocl.examples.pivot.Class) {
				for (Property property : ((org.eclipse.ocl.examples.pivot.Class)model).getOwnedAttributes()) {
					completeProperties.add(completeEnvironment
						.getCompleteProperty(property));
				}
			}
		}
		return completeProperties;
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
			case PivotPackage.COMPLETE_TYPE__MODEL:
				setModel((Type)newValue);
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT:
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
			case PivotPackage.COMPLETE_TYPE__MODEL:
				setModel((Type)null);
				return;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT:
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
				return ownedAttributes != null && !ownedAttributes.isEmpty();
			case PivotPackage.COMPLETE_TYPE__OWNED_OPERATION:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.COMPLETE_TYPE__SUPER_CLASS:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.COMPLETE_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.COMPLETE_TYPE__SUB_CLASS:
				return subClasses != null && !subClasses.isEmpty();
			case PivotPackage.COMPLETE_TYPE__MODEL:
				return model != null;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_ENVIRONMENT:
				return completeEnvironment != null;
			case PivotPackage.COMPLETE_TYPE__COMPLETE_OPERATION:
				return !getCompleteOperations().isEmpty();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_PROPERTY:
				return !getCompleteProperties().isEmpty();
			case PivotPackage.COMPLETE_TYPE__COMPLETE_SUPER_TYPE:
				return !getCompleteSuperTypes().isEmpty();
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
			case PivotPackage.COMPLETE_TYPE___CONFORMS_TO__COMPLETETYPE:
				return conformsTo((CompleteType)arguments.get(0));
			case PivotPackage.COMPLETE_TYPE___GET_DYNAMIC_ITERATION__COMPLETEITERATION:
				return getDynamicIteration((CompleteIteration)arguments.get(0));
			case PivotPackage.COMPLETE_TYPE___GET_DYNAMIC_OPERATION__COMPLETEOPERATION:
				return getDynamicOperation((CompleteOperation)arguments.get(0));
			case PivotPackage.COMPLETE_TYPE___GET_COMPLETE_ITERATIONS__STRING:
				return getCompleteIterations((String)arguments.get(0));
			case PivotPackage.COMPLETE_TYPE___GET_COMPLETE_OPERATIONS__STRING:
				return getCompleteOperations((String)arguments.get(0));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	public EList<CompleteOperation> getCompleteOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCompleteType(this);
	}
} //CompleteClassImpl
