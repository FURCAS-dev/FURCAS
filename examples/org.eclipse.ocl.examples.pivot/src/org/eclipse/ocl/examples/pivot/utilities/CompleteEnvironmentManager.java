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
 * $Id: CompleteEnvironmentManager.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.CompleteIteration;
import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteEnvironmentImpl;

public class CompleteEnvironmentManager extends CompleteEnvironmentImpl
{	
	private static final Logger logger = Logger.getLogger(CompleteEnvironmentManager.class);

	protected final TypeManager typeManager;

	private Map<Iteration, CompleteIteration> completeIterationMap = new HashMap<Iteration, CompleteIteration>();
	private Map<org.eclipse.ocl.examples.pivot.Package, CompletePackage> completePackageMap = new HashMap<org.eclipse.ocl.examples.pivot.Package, CompletePackage>();
	private Map<Operation, CompleteOperation> completeOperationMap = new HashMap<Operation, CompleteOperation>();
	private Map<Property, CompleteProperty> completePropertyMap = new HashMap<Property, CompleteProperty>();
	private Map<Type, CompleteType> completeTypeMap = new HashMap<Type, CompleteType>();

	public CompleteEnvironmentManager(TypeManager typeManager) {
		this.typeManager = typeManager;
	}
	
	protected CompleteType createCompleteType(Type type) {
		CompleteType completeType;
		completeType = PivotFactory.eINSTANCE.createCompleteType();
		completeType.setModel(type);
		completeType.setCompleteEnvironment(this);
		completeTypeMap.put(type, completeType);
		completeType.setName(type.getName());
		completeType.setPackage(getCompletePackage(type.getPackage()));
		return completeType;
	}
	
	protected CompleteIteration createCompleteIteration(Iteration iteration) {
		CompleteIteration completeIteration;
		completeIteration = PivotFactory.eINSTANCE.createCompleteIteration();
		completeIteration.setModel(iteration);
		completeIteration.setCompleteEnvironment(this);
		completeIterationMap.put(iteration, completeIteration);
		completeIteration.setClass_(getCompleteType(iteration.getClass_()));
		completeIteration.setName(iteration.getName());
		completeIteration.setImplementation(iteration.getImplementation());
		completeIteration.setImplementationClass(iteration.getImplementationClass());
		return completeIteration;
	}
	
	protected CompleteOperation createCompleteOperation(Operation operation) {
		CompleteOperation completeOperation;
		completeOperation = PivotFactory.eINSTANCE.createCompleteOperation();
		completeOperation.setModel(operation);
		completeOperation.setCompleteEnvironment(this);
		completeOperationMap.put(operation, completeOperation);
		completeOperation.setClass_(getCompleteType(operation.getClass_()));
		completeOperation.setName(operation.getName());
		completeOperation.setImplementation(operation.getImplementation());
		completeOperation.setImplementationClass(operation.getImplementationClass());
		return completeOperation;
	}
	
	protected CompletePackage createCompletePackage(org.eclipse.ocl.examples.pivot.Package pkg) {
		CompletePackage completePackage;
		completePackage = PivotFactory.eINSTANCE.createCompletePackage();
		completePackage.setModel(pkg);
		completePackage.setCompleteEnvironment(this);
		completePackageMap.put(pkg, completePackage);
		completePackage.setName(pkg.getName());
		Package nestingPackage = pkg.getNestingPackage();
		if (nestingPackage != null) {
			completePackage.setNestingPackage(getCompletePackage(nestingPackage));
		}
		return completePackage;
	}
	
	protected CompleteProperty createCompleteProperty(Property property) {
		CompleteProperty completeProperty;
		completeProperty = PivotFactory.eINSTANCE.createCompleteProperty();
		completeProperty.setModel(property);
		completeProperty.setCompleteEnvironment(this);
		completePropertyMap.put(property, completeProperty);
		completeProperty.setName(property.getName());
		completeProperty.setClass_(getCompleteType(property.getClass_()));
		return completeProperty;
	}

	@Override
	public CompleteType getCompleteType(Type type) {
		if (type == null) {
			logger.warn("getCompleteType for null");
			return null;
		}
		if (type instanceof CompleteType) {
			CompleteType completeType = (CompleteType) type;
			if (completeType.getCompleteEnvironment() == this) {
				return completeType;
			}
			logger.warn("getCompleteType for a CompleteType " + type);
			return getCompleteType(completeType.getModel());
		}
		CompleteType completeType = completeTypeMap.get(type);
		if (completeType == null) {
			completeType = createCompleteType(type);
		}
		return completeType;
	}

	@Override
	public CompleteIteration getCompleteIteration(Iteration iteration) {
		if (iteration == null) {
			logger.warn("getCompleteIteration for null");
			return null;
		}
		if (iteration instanceof CompleteIteration) {
			CompleteIteration completeIteration = (CompleteIteration) iteration;
			if (completeIteration.getCompleteEnvironment() == this) {
				return completeIteration;
			}
			logger.warn("getCompleteIteration for a CompleteIteration " + iteration);
			return getCompleteIteration(((CompleteIteration)iteration).getModel());
		}
		CompleteIteration completeIteration = completeIterationMap.get(iteration);
		if (completeIteration == null) {
			completeIteration = createCompleteIteration(iteration);
		}
		return completeIteration;
	}

	@Override
	public CompleteOperation getCompleteOperation(Operation operation) {
		if (operation == null) {
			logger.warn("getCompleteOperation for null");
			return null;
		}
		if (operation instanceof CompleteOperation) {
			CompleteOperation completeOperation = (CompleteOperation) operation;
			if (completeOperation.getCompleteEnvironment() == this) {
				return completeOperation;
			}
			logger.warn("getCompleteOperation for a CompleteOperation " + operation);
			return getCompleteOperation(((CompleteOperation)operation).getModel());
		}
		CompleteOperation completeOperation = completeOperationMap.get(operation);
		if (completeOperation == null) {
			completeOperation = createCompleteOperation(operation);
		}
		return completeOperation;
	}

	@Override
	public CompletePackage getCompletePackage(org.eclipse.ocl.examples.pivot.Package pkg) {
		if (pkg == null) {
			logger.warn("getCompletePackage for null");
			return null;
		}
		if (pkg instanceof CompletePackage) {
			CompletePackage completePackage = (CompletePackage) pkg;
			if (completePackage.getCompleteEnvironment() == this) {
				return completePackage;
			}
			logger.warn("getCompletePackage for a CompletePackage " + pkg);
			return getCompletePackage(((CompletePackage)pkg).getModel());
		}
		CompletePackage completePackage = completePackageMap.get(pkg);
		if (completePackage == null) {
			completePackage = createCompletePackage(pkg);
		}
		return completePackage;
	}

	@Override
	public CompleteProperty getCompleteProperty(Property property) {
		if (property == null) {
			logger.warn("getCompleteProperty for null");
			return null;
		}
		if (property instanceof CompleteProperty) {
			CompleteProperty completeProperty = (CompleteProperty) property;
			if (completeProperty.getCompleteEnvironment() == this) {
				return completeProperty;
			}
			logger.warn("getCompleteProperty for a CompleteProperty " + property);
			return getCompleteProperty(((CompleteProperty)property).getModel());
		}
		CompleteProperty completeProperty = completePropertyMap.get(property);
		if (completeProperty == null) {
			completeProperty = createCompleteProperty(property);
		}
		return completeProperty;
	}
	
	public TypeManager getTypeManager() {
		return typeManager;
	}
}