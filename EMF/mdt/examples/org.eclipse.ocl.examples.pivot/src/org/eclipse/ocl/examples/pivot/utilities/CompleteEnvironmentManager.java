/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: CompleteEnvironmentManager.java,v 1.4 2011/03/12 13:28:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteEnvironmentImpl;

public class CompleteEnvironmentManager extends CompleteEnvironmentImpl
{	
	private static final Logger logger = Logger.getLogger(CompleteEnvironmentManager.class);

	protected final TypeManager typeManager;
	private final CompletePackage rootCompletePackage;
	private final Map<org.eclipse.ocl.examples.pivot.Package, CompletePackage> completePackageMap = new HashMap<org.eclipse.ocl.examples.pivot.Package, CompletePackage>();
	private final Map<Operation, CompleteOperation> completeOperationMap = new HashMap<Operation, CompleteOperation>();
	private final Map<Property, CompleteProperty> completePropertyMap = new HashMap<Property, CompleteProperty>();
	private final Map<Type, CompleteType> completeTypeMap = new HashMap<Type, CompleteType>();

	public CompleteEnvironmentManager(TypeManager typeManager) {
		this.typeManager = typeManager;
		rootCompletePackage = PivotFactory.eINSTANCE.createCompletePackage();
		rootCompletePackage.setName("$");
		rootCompletePackage.setCompleteEnvironment(this);
	}

	private Set<Iteration> findModelIterationsOrNull(CompleteType completeType,
			String operationName, List<CompleteType> staticCompleteIteratorTypes,
			List<CompleteType> staticCompleteAccumulatorTypes, List<CompleteType> staticCompleteParameterTypes) {
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, completeType.getModel());
		int staticIteratorsSize = staticCompleteIteratorTypes.size();
		Set<Iteration> list = null;
		for (Iteration modelIteration : getLocalModelIterations(completeType, operationName)) {
//			Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions2 = PivotUtil.getAllTemplateParameterSubstitutions(null, dynamicIteration.getModel());
			List<Parameter> modelIterators = modelIteration.getOwnedIterators();
			if (staticIteratorsSize == modelIterators.size()) {
				boolean gotIt = true;
				for (int i = 0; i < staticIteratorsSize; i++) {
					Type staticCompleteIteratorType = staticCompleteIteratorTypes.get(i);
					Parameter modelIterator = modelIterators.get(i);
					Type dynamicCompleteIteratorType = resolveType(modelIterator.getType(), bindings);
					if (!typeManager.conformsTo(dynamicCompleteIteratorType, staticCompleteIteratorType, null)) {
						gotIt = false;
					}
				}
				if (gotIt) {
					if (list == null) {
						list = new HashSet<Iteration>();
					}
					list.add(modelIteration);
				}
			}
		}
		if (list == null) {
			for (CompleteType completeSuperType : completeType.getCompleteSuperTypes()) {
				Set<Iteration> superIterations = findModelIterationsOrNull(
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

	private Set<Operation> findModelOperationsOrNull(CompleteType completeType,
			String operationName, List<CompleteType> staticCompleteTypes, Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions) {
		int staticParametersSize = staticCompleteTypes.size();
		Set<Operation> list = null;
		for (Operation modelOperation : getLocalModelOperations(completeType, operationName)) {
			List<Parameter> modelParameters = modelOperation.getOwnedParameters();
			if (staticParametersSize == modelParameters.size()) {
				boolean gotIt = true;
				for (int i = 0; i < staticParametersSize; i++) {
					Type staticCompleteType = staticCompleteTypes.get(i);
					Parameter modelParameter = modelParameters.get(i);
					Type dynamicCompleteType = resolveType(modelParameter.getType(), templateParameterSubstitutions);
					if (!typeManager.conformsTo(dynamicCompleteType, staticCompleteType, null)) {
						gotIt = false;
					}
				}
				if (gotIt) {
					if (list == null) {
						list = new HashSet<Operation>();
					}
					list.add(modelOperation);
				}
			}
		}
		if (list == null) {
			for (CompleteType completeSuperType : completeType.getCompleteSuperTypes()) {
				Set<Operation> superOperations = findModelOperationsOrNull(
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

/*	public CompleteOperation getCompleteIteration(Iteration iteration) {
		CompleteOperation completeIteration = completeOperationMap.get(iteration);
		if (completeIteration != null) {
			return completeIteration;
		}
		if (iteration instanceof CompleteOperation) {
			return (CompleteOperation)iteration;
		}
		if (iteration == null) {
			throw new NullPointerException("getCompleteIteration for null");
		}
		CompleteType completeType = getCompleteType(iteration.getClass_());
		for (CompleteOperation candidateIteration : getCompleteIterations(completeType, iteration.getName())) {
			List<Parameter> candidateIterators = candidateIteration.getOwnedIterators();
			List<Parameter> iterators = iteration.getOwnedIterators();
			if (candidateIterators.size() == iterators.size()) {
				completeIteration = candidateIteration;
				break;
			}
		}
		if (completeIteration == null) {
			completeIteration = PivotFactory.eINSTANCE.createCompleteIteration();
			completeIteration.setCompleteEnvironment(this);
			completeIteration.setClass_(getCompleteType(iteration.getClass_()));
			completeIteration.setName(iteration.getName());
			completeIteration.setImplementation(iteration.getImplementation());
			completeIteration.setImplementationClass(iteration.getImplementationClass());
		}
		completeIteration.getModels().add(iteration);
		completeOperationMap.put(iteration, completeIteration);
		return completeIteration;
	} */
	
	public void addOperation(CompleteOperation completeOperation, Operation operation) {
		completeOperation.getModels().add(operation);
		completeOperationMap.put(operation, completeOperation);
	}

	public void addPackage(CompletePackage completePackage, org.eclipse.ocl.examples.pivot.Package aPackage) {
		completePackage.getModels().add(aPackage);
		completePackageMap.put(aPackage, completePackage);
	}
	
	public void addProperty(CompleteProperty completeProperty, Property property) {
		completeProperty.getModels().add(property);
		completePropertyMap.put(property, completeProperty);
	}
	
	public void addType(CompleteType completeType, Type type) {
		completeType.getModels().add(type);
		assert completeType.getModel().getMoniker().equals(type.getMoniker());
		completeTypeMap.put(type, completeType);
	}

/*	public CompleteElement getCompleteElement(NamedElement namedElement) {
		if (namedElement instanceof Operation) {
			return getCompleteOperation((Operation)namedElement);
		}
		if (namedElement instanceof org.eclipse.ocl.examples.pivot.Package) {
			return getCompletePackage((org.eclipse.ocl.examples.pivot.Package)namedElement);
		}
		if (namedElement instanceof Property) {
			return getCompleteProperty((Property)namedElement);
		}
		if (namedElement instanceof Type) {
			return getCompleteType((Type)namedElement);
		}
		return null;
	} */

	@Override
	public CompleteOperation getCompleteOperation(Operation operation) {
		CompleteOperation completeOperation = completeOperationMap.get(operation);
		if (completeOperation != null) {
			return completeOperation;
		}
		if (operation instanceof CompleteOperation) {
			return (CompleteOperation)operation;
		}
		if (operation == null) {
			throw new NullPointerException("getCompleteOperation for null");
		}
		CompleteType completeType = getCompleteType(operation.getClass_());
		if (operation instanceof Iteration) {
			completeOperation = getCompleteOperationForIteration(completeType, (Iteration) operation);
		}
		else {
			completeOperation = getCompleteOperationForOperation(completeType, operation);
		}
		if (completeOperation == null) {
			completeOperation = PivotFactory.eINSTANCE.createCompleteOperation();
			completeOperation.setCompleteEnvironment(this);
			completeOperation.setClass_(completeType);
			completeOperation.setName(operation.getName());
			completeOperation.setImplementation(operation.getImplementation());
			completeOperation.setImplementationClass(operation.getImplementationClass());
		}
		addOperation(completeOperation, operation);
		return completeOperation;
	}
	
	protected CompleteOperation getCompleteOperationForIteration(CompleteType completeType, Iteration iteration) {
		String iterationMoniker = iteration.getMoniker();
		List<Parameter> iterators = iteration.getOwnedIterators();
		for (CompleteOperation candidateOperation : completeType.getCompleteOperations()) {
			Operation candidateModel = candidateOperation.getModel();
			if ((candidateModel instanceof Iteration) && candidateModel.getMoniker().equals(iterationMoniker)) {
				Iteration candidateIteration = (Iteration) candidateModel;
				List<Parameter> candidateIterators = candidateIteration.getOwnedIterators();
				if (candidateIterators.size() == iterators.size()) {
					return candidateOperation;
				}
			}
		}
		return null;
	}

	protected CompleteOperation getCompleteOperationForOperation(CompleteType completeType, Operation operation) {
		String operationName = operation.getName();
		List<Parameter> parameters = operation.getOwnedParameters();
		for (CompleteOperation candidateOperation : completeType.getCompleteOperations()) {
			Operation candidateModel = candidateOperation.getModel();
			if (!(candidateModel instanceof Iteration) && candidateModel.getName().equals(operationName)) {
				List<Parameter> candidateParameters = candidateModel.getOwnedParameters();
				if (candidateParameters.size() == parameters.size()) {
					boolean gotIt = true;
					for (int i = 0; i < candidateParameters.size(); i++) {
						Parameter candidateParameter = candidateParameters.get(i);
						Parameter parameter = parameters.get(i);
						if (candidateParameter.getType() != getCompleteType(parameter.getType())) {
							gotIt = false;
							break;
						}
					}
					if (gotIt) {
						return candidateOperation;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public CompletePackage getCompletePackage(org.eclipse.ocl.examples.pivot.Package pkg) {
		CompletePackage completePackage = completePackageMap.get(pkg);
		if (completePackage != null) {
			return completePackage;
		}
		if (pkg instanceof CompletePackage) {
			return (CompletePackage)pkg;
		}
		if (pkg == null) {
			logger.warn("getCompletePackage for null");
			return null;
		}
		CompletePackage nestingCompletePackage;
		org.eclipse.ocl.examples.pivot.Package nestingPackage = pkg.getNestingPackage();
		if (nestingPackage == null) {
			nestingCompletePackage = rootCompletePackage;
		}
		else {
			nestingCompletePackage = getCompletePackage(nestingPackage);
		}
		completePackage = PivotUtil.getNamedElement(nestingCompletePackage.getCompletePackages(), pkg.getName());
		if (completePackage == null) {
			completePackage = PivotFactory.eINSTANCE.createCompletePackage();
			completePackage.setCompleteEnvironment(this);
			completePackage.setName(pkg.getName());
			completePackage.setNestingPackage(nestingCompletePackage);
		}
		addPackage(completePackage, pkg);
		return completePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 *
	public EList<CompleteProperty> getCompleteProperties() {
		if (completeProperties == null) {
			completeProperties = new BasicEList<CompleteProperty>();
			for (Property property : getOwnedAttributes()) {
				completeProperties.add(completeEnvironment
					.getCompleteProperty(property));
			}
			for (Type model : models) {
				if (model instanceof org.eclipse.ocl.examples.pivot.Class) {
					for (Property property : ((org.eclipse.ocl.examples.pivot.Class)model).getOwnedAttributes()) {
						completeProperties.add(completeEnvironment
							.getCompleteProperty(property));
					}
				}
			}
		}
		return completeProperties;
	} */

	@Override
	public CompleteProperty getCompleteProperty(Property property) {
		CompleteProperty completeProperty = completePropertyMap.get(property);
		if (completeProperty != null) {
			return completeProperty;
		}
		if (property instanceof CompleteProperty) {
			return (CompleteProperty)property;
		}
		if (property == null) {
			throw new NullPointerException("getCompleteProperty for null");
		}
		CompleteType completeType = getCompleteType(property.getClass_());
		completeProperty = PivotUtil.getNamedElement(completeType.getCompleteProperties(), property.getName());
		if (completeProperty != null) {
			if (completeProperty.getType() != getCompleteType(property.getType())) {
				return null;
			}
		}
		else {
			completeProperty = PivotFactory.eINSTANCE.createCompleteProperty();
			completeProperty.setCompleteEnvironment(this);
			completeProperty.setName(property.getName());
			completeProperty.setClass_(completeType);
		}
		addProperty(completeProperty, property);
		return completeProperty;
	}

	@Override
	public CompleteType getCompleteType(Type type) {
		CompleteType completeType = completeTypeMap.get(type);
		if (completeType != null) {
			return completeType;
		}
		if (type instanceof CompleteType) {
			return (CompleteType) type;
		}
		if (type == null) {
			throw new NullPointerException("getCompleteType for null");
		}
		CompletePackage completePackage = getCompletePackage(type.getPackage());
		for (CompleteType aCompleteType : completePackage.getCompleteTypes()) {
			if (aCompleteType.getMoniker().equals(type.getMoniker())) {
				completeType = aCompleteType;
				break;
			}
		}
		if (completeType == null) {
			completeType = PivotFactory.eINSTANCE.createCompleteType();
			completeType.setCompleteEnvironment(this);
			completeType.setName(type.getName());
			completeType.setPackage(completePackage);
		}
		addType(completeType, type);
		return completeType;
	}

	@Override
	public CompleteOperation getDynamicOperation(CompleteType completeType, CompleteOperation staticOperation) {
		Operation staticModelOperation = staticOperation.getModel();
		Operation dynamicModelOperation;
		if (staticModelOperation instanceof Iteration) {
			dynamicModelOperation = getDynamicOperationForIteration(completeType, (Iteration) staticModelOperation);
		}
		else {
			dynamicModelOperation = getDynamicOperationForOperation(completeType, staticModelOperation);
		}
		if (dynamicModelOperation != null) {
			return getCompleteOperation(dynamicModelOperation);
		}
		else {
			return null;
		}
	}
	
	protected Iteration getDynamicOperationForIteration(CompleteType completeType, Iteration staticModelIteration)
	{
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, completeType.getModel());
//		Map<TemplateParameter, ParameterableElement> templateParameterSubstitutions2 = PivotUtil.getAllTemplateParameterSubstitutions(null, staticIteration.getModel());
		List<CompleteType> staticCompleteIteratorTypes = new ArrayList<CompleteType>();
		for (Parameter staticIterator : staticModelIteration.getOwnedIterators()) {
			staticCompleteIteratorTypes.add(resolveType(staticIterator.getType(), bindings));
		}
		List<CompleteType> staticCompleteAccumulatorTypes = new ArrayList<CompleteType>();
		for (Parameter staticAccumulator : staticModelIteration.getOwnedAccumulators()) {
			staticCompleteAccumulatorTypes.add(resolveType(staticAccumulator.getType(), bindings));
		}
		List<CompleteType> staticCompleteParameterTypes = new ArrayList<CompleteType>();
		for (Parameter staticParameter : staticModelIteration.getOwnedParameters()) {
			staticCompleteParameterTypes.add(resolveType(staticParameter.getType(), bindings));
		}
		Iteration dynamicIteration = null;
		Set<Iteration> modelIterations = findModelIterationsOrNull(completeType, staticModelIteration.getName(),
			staticCompleteIteratorTypes, staticCompleteAccumulatorTypes, staticCompleteParameterTypes);
		if (modelIterations != null) {
			if (modelIterations.size() == 1) {
				dynamicIteration = modelIterations.iterator().next();
			}
			else if (modelIterations.size() > 1) {
				Iteration conformantIteration = null;
				boolean ok = true;
				for (Iteration completeIteration : modelIterations) {
					if (conformantIteration == null) {
						conformantIteration = completeIteration;
					}
					else {
						org.eclipse.ocl.examples.pivot.Class completeClass = PivotUtil.getFeaturingClass(completeIteration);
						org.eclipse.ocl.examples.pivot.Class conformantClass = PivotUtil.getFeaturingClass(conformantIteration);
						if (typeManager.conformsTo(completeClass, conformantClass, bindings)) {
							conformantIteration = completeIteration;
						}
						else if (!typeManager.conformsTo(conformantClass, completeClass, bindings)) {
							ok = false;
						}
					}
				}
				if (ok) {
					dynamicIteration = conformantIteration;
				}
			}
		}
		return dynamicIteration;
	}

	protected CompleteOperation getDynamicOperationForOperation(CompleteType completeType, Operation staticModelOperation) {
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, completeType.getModel());
		PivotUtil.getAllTemplateParameterSubstitutions(bindings, staticModelOperation);
		List<CompleteType> staticCompleteTypes = new ArrayList<CompleteType>();
		for (Parameter staticParameter : staticModelOperation.getOwnedParameters()) {
			staticCompleteTypes.add(resolveType(staticParameter.getType(), bindings));
		}
		Operation dynamicModelOperation = null;
		String name = staticModelOperation.getName();
		Set<Operation> modelOperations = findModelOperationsOrNull(completeType, name, staticCompleteTypes, bindings);
		if ((modelOperations != null) && (modelOperations.size() == 1)) {
			dynamicModelOperation = modelOperations.iterator().next();
		}
		if (dynamicModelOperation != null) {
			return getCompleteOperation(dynamicModelOperation);
		}
		else {
			return null;
		}
	}

	protected Iterable<Iteration> getLocalModelIterations(CompleteType completeType, String name) {
		List<Iteration> modelIterations = new ArrayList<Iteration>();
		Type type = completeType.getModel();
		if (type.getTemplateBindings().size() > 0) {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
		}
		if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (Operation operation : typeManager.getLocalOperations((org.eclipse.ocl.examples.pivot.Class)type)) {
				if ((operation instanceof Iteration) && name.equals(operation.getName())) {
					Operation modelIteration = getCompleteOperation(operation).getModel();
					if (!modelIterations.contains(modelIteration)) {
						modelIterations.add((Iteration) modelIteration);
					}
				}
			}
		}
		return modelIterations;
	}

	protected Iterable<Operation> getLocalModelOperations(CompleteType completeType, String name) {	// FIXME return an iterator
		List<Operation> modelOperations = new ArrayList<Operation>();
		Type type = completeType.getModel();
		if (type.getTemplateBindings().size() > 0) {
			type = PivotUtil.getUnspecializedTemplateableElement(type);
		}
		if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (Operation operation : typeManager.getLocalOperations((org.eclipse.ocl.examples.pivot.Class)type)) {
				if (!(operation instanceof Iteration) && name.equals(operation.getName())) {
					Operation modelOperation = getCompleteOperation(operation).getModel();
					if (!modelOperations.contains(modelOperation)) {
						modelOperations.add(modelOperation);
					}
				}
			}
		}
		return modelOperations;
	}
	
	public TypeManager getTypeManager() {
		return typeManager;
	}

	private CompleteType resolveType(Type type, Map<TemplateParameter, ParameterableElement> bindings) {
		Type specializedType = typeManager.getSpecializedType(type, bindings);
		return getCompleteType(specializedType); 
	}
	
//	public CompletePackage getRootCompletePackage() {
//		return rootCompletePackage;
//	}
}