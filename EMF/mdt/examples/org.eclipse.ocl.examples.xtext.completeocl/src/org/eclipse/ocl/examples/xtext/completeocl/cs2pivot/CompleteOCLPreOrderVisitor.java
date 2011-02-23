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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.4 2011/02/15 10:37:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;

public class CompleteOCLPreOrderVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPreOrderVisitor>
{	
	protected static class CompleteOperationContentContinuation extends SingleContinuation<OperationContextDeclCS>
	{
		private CompleteOperationContentContinuation(CS2PivotConversion context, OperationContextDeclCS csElement) {
			super(context, null, null, csElement);
//			context.getPackagesHaveTypesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			Operation element = csElement.getOperation();
//			if ((element == null) || element.eIsProxy()) {
//				context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//				element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//			}
			CompleteOperation pivotElement = context.refreshMonikeredElement(CompleteOperation.class,
				PivotPackage.Literals.COMPLETE_OPERATION, csElement);
			pivotElement.setModel(element);
			context.installPivotElement(csElement, pivotElement);
			return null;
		}
	}
	
	protected static class CompletePackageContentContinuation extends SingleContinuation<PackageDeclarationCS>
	{
		private CompletePackageContentContinuation(CS2PivotConversion context, PackageDeclarationCS csElement) {
			super(context, null, null, csElement);
//			context.getPackagesHaveTypesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			org.eclipse.ocl.examples.pivot.Package pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, csElement);
			List<CompleteType> completeTypes = new ArrayList<CompleteType>();
			Map<Type, CompleteType> completingTypes = new HashMap<Type, CompleteType>();
			for (ContextDeclCS csContext : csElement.getContexts()) {
				if (csContext instanceof ClassifierContextDeclCS) {
					ClassifierContextDeclCS csClassifierContext = (ClassifierContextDeclCS)csContext;
					CompleteType completeType = PivotUtil.getPivot(CompleteType.class, csClassifierContext);
					completeTypes.add(completeType);
					completingTypes.put(completeType.getModel(), completeType);
				}
			}
			Map<Type, List<CompleteOperation>> completeOperationsPerType = new HashMap<Type, List<CompleteOperation>>();
			Map<Type, List<CompleteProperty>> completePropertiesPerType = new HashMap<Type, List<CompleteProperty>>();
			for (ContextDeclCS csContext : csElement.getContexts()) {
				if (csContext instanceof OperationContextDeclCS) {
					OperationContextDeclCS csOperationContext = (OperationContextDeclCS)csContext;
					CompleteOperation completeOperation = PivotUtil.getPivot(CompleteOperation.class, csOperationContext);
					Operation operation = completeOperation.getModel();
					Type type = PivotUtil.getFeaturingClass(operation);
					CompleteType completeType = completingTypes.get(type);
					if (completeType == null) {
						completeType = PivotFactory.eINSTANCE.createCompleteType();
						completeType.setName(type.getName());
						completeType.setModel(type);
						completeTypes.add(completeType);
						completingTypes.put(type, completeType);
					}
					List<CompleteOperation> completeOperations = completeOperationsPerType.get(type);
					if (completeOperations == null) {
						completeOperations = new ArrayList<CompleteOperation>();
						completeOperationsPerType.put(type, completeOperations);
					}
					completeOperations.add(completeOperation);
				}
				else if (csContext instanceof PropertyContextDeclCS) {
					PropertyContextDeclCS csPropertyContext = (PropertyContextDeclCS)csContext;
					CompleteProperty completeProperty = PivotUtil.getPivot(CompleteProperty.class, csPropertyContext);
					Property property = completeProperty.getModel();
					Type type = PivotUtil.getFeaturingClass(property);
					CompleteType completeType = completingTypes.get(type);
					if (completeType == null) {
						completeType = PivotFactory.eINSTANCE.createCompleteType();
						completeType.setName(type.getName());
						completeType.setModel(type);
						completeTypes.add(completeType);
						completingTypes.put(type, completeType);
					}
					List<CompleteProperty> completeProperties = completePropertiesPerType.get(type);
					if (completeProperties == null) {
						completeProperties = new ArrayList<CompleteProperty>();
						completePropertiesPerType.put(type, completeProperties);
					}
					completeProperties.add(completeProperty);
				}
			}
			context.refreshList(pivotElement.getOwnedTypes(), completeTypes);
			for (Map.Entry<Type, List<CompleteOperation>> entry : completeOperationsPerType.entrySet()) {
				CompleteType completeType = completingTypes.get(entry.getKey());
				context.refreshList(completeType.getOwnedOperations(), entry.getValue());
			}
			for (Map.Entry<Type, List<CompleteProperty>> entry : completePropertiesPerType.entrySet()) {
				CompleteType completeType = completingTypes.get(entry.getKey());
				context.refreshList(completeType.getOwnedAttributes(), entry.getValue());
			}
//			context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackages(), csElement.getOwnedNestedPackage());
//			context.getPackagesHaveTypesInterDependency().setSatisfied(this);
			return null;
		}
	}

	public CompleteOCLPreOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPreOrderVisitor(context), context);
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(ClassifierContextDeclCS object) {
		context.resolveNamespaces(object.getNamespace());
		Type element = object.getClassifier();
//		if ((element == null) || element.eIsProxy()) {
//			context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//			element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//		}
		CompleteType pivotElement = context.refreshMonikeredElement(CompleteType.class,
			PivotPackage.Literals.COMPLETE_TYPE, object);
		pivotElement.setModel(element);
		pivotElement.setName(element.getName());
		context.installPivotElement(object, pivotElement);
		return null;
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(OperationContextDeclCS object) {
		context.resolveNamespaces(object.getNamespace());
		// Must wait till parameters have types before resolving operation name
		return new CompleteOperationContentContinuation(context, object);
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(PackageDeclarationCS object) {
		context.resolveNamespaces(object.getNamespace());
		org.eclipse.ocl.examples.pivot.Package element = object.getPackage();
//		if ((element == null) || element.eIsProxy()) {
//			context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//			element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//		}
		CompletePackage pivotElement = context.refreshMonikeredElement(CompletePackage.class,
			PivotPackage.Literals.COMPLETE_PACKAGE, object);
		pivotElement.setModel(element);
		pivotElement.setName(element.getName());
//		pivotElement.setNsPrefix(element.getNsPrefix());
//		pivotElement.setNsURI(element.getNsURI());
		context.installPivotElement(object, pivotElement);
		context.getTypeManager().addOrphanPackage(pivotElement);
		return new CompletePackageContentContinuation(context, object);
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(PropertyContextDeclCS object) {
		context.resolveNamespaces(object.getNamespace());
		Property element = object.getProperty();
//		if ((element == null) || element.eIsProxy()) {
//			context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//			element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//		}
		CompleteProperty pivotElement = context.refreshMonikeredElement(CompleteProperty.class,
			PivotPackage.Literals.COMPLETE_PROPERTY, object);
		pivotElement.setModel(element);
		pivotElement.setName(element.getName());
		context.installPivotElement(object, pivotElement);
		return null;
//		return new PropertyContextNamespaceContinuation(context, object);
	}
}