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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.8 2011/04/20 19:02:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

public class CompleteOCLPreOrderVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPreOrderVisitor>
{	
	protected class DefCSContinuation extends SingleContinuation<DefCS>
	{
		private DefCSContinuation(CS2PivotConversion context, DefCS csElement) {
			super(context, null, null, csElement, context.getTypesHaveSignaturesInterDependency());
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return true;
			}
			TypedRefCS ownedType = csElement.getOwnedType();
			if ((ownedType != null) && (ownedType.getPivot() == null)) {
				return false;
			}
			for (VariableCS csParameter : csElement.getParameters()) {
				ownedType = csParameter.getOwnedType();
				if (ownedType.getPivot() == null) {
					return false;
				}
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			Type type = ((ClassifierContextDeclCS) csElement.getContextDecl()).getClassifier();
//			org.eclipse.ocl.examples.pivot.Class classifier = (org.eclipse.ocl.examples.pivot.Class)type;
			org.eclipse.ocl.examples.pivot.Class classifier = getContextClassifier(type, csElement);
			Operation pivotOperation = null;
			Property pivotProperty = null;
			Feature pivotFeature = null;
			if (csElement.isOperation()) {
				pivotOperation = context.refreshMonikeredElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
				pivotFeature = pivotOperation;
			}
			else {
				pivotProperty = context.refreshMonikeredElement(Property.class, PivotPackage.Literals.PROPERTY, csElement);
				pivotFeature = pivotProperty;
			}
			context.installPivotElement(csElement, pivotFeature);
			context.refreshName(pivotFeature, csElement.getConstrainedName());
			TypedRefCS csType = csElement.getOwnedType();
			if (csType != null) {
				pivotFeature.setType(PivotUtil.getPivot(Type.class, csType));
			}
//			context.refreshComments(pivotOperation, csElement);
//			List<String> qualifiers = csTypedElement.getQualifier();
//			pivotElement.setIsOrdered(qualifiers.contains("ordered"));
//			pivotElement.setIsUnique(getQualifier(qualifiers, "unique", "!unique", true));
//			String multiplicity = csTypedElement.getMultiplicity();
//			if (multiplicity == null) {
//				pivotElement.setLower(BigInteger.valueOf(csTypedElement.getLower()));
//				pivotElement.setUpper(BigInteger.valueOf(csTypedElement.getUpper()));
//			}
//			else if ("*".equals(multiplicity)) {
//				pivotElement.setLower(BigInteger.valueOf(0));
//				pivotElement.setUpper(BigInteger.valueOf(-1));
//			}
//			else if ("+".equals(multiplicity)) {
//				pivotElement.setLower(BigInteger.valueOf(1));
//				pivotElement.setUpper(BigInteger.valueOf(-1));
//			}
//			else if ("?".equals(multiplicity)) {
//				pivotElement.setLower(BigInteger.valueOf(0));
//				pivotElement.setUpper(BigInteger.valueOf(1));
//			}
//			context.refreshTemplateSignature(csElement, pivotOperation);
			if (pivotOperation != null) {
				List<VariableCS> csParameters = csElement.getParameters();
				List<Parameter> newPivotParameters = new ArrayList<Parameter>();
				for (VariableCS csParameter : csParameters) {
	//				Parameter pivotParameter = context.refreshTypedMultiplicityElement(Parameter.class, PivotPackage.Literals.PARAMETER, csParameter);
					Parameter pivotParameter = context.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, csParameter);
					pivotParameter.setType(PivotUtil.getPivot(Type.class, csParameter.getOwnedType()));
					newPivotParameters.add(pivotParameter);
				}
				context.refreshList(pivotOperation.getOwnedParameters(), newPivotParameters);
				classifier.getOwnedOperations().add(pivotOperation);
			}
			else {
				classifier.getOwnedAttributes().add(pivotProperty);
			}
			return null;
		}
	}

	protected class OperationContextDeclCSContinuation extends SingleContinuation<OperationContextDeclCS>
	{
		private OperationContextDeclCSContinuation(CS2PivotConversion context, OperationContextDeclCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			for (VariableCS csParameter : csElement.getParameters()) {
				if (csParameter.getOwnedType().getPivot() == null) {
					return false;
				}
			}
			TypedRefCS csType = csElement.getOwnedType();
			if ((csType != null) && (csType.getPivot() == null)) {
				return false;
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			Operation modelOperation = csElement.getOperation();
			if ((modelOperation == null) || modelOperation.eIsProxy()) {
				return null;
			}
			org.eclipse.ocl.examples.pivot.Class contextType = getContextClassifier(modelOperation.getClass_(), csElement);
//			completeEnvironmentManager.getCompleteOperation(element);
//			if ((element == null) || element.eIsProxy()) {
//				context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//				element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//			}
			Operation contextOperation = context.refreshMonikeredElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
			String moniker = csElement.getMoniker();
			contextOperation.setMoniker(moniker);
			contextOperation.setName(modelOperation.getName());
			List<Parameter> modelParameters = modelOperation.getOwnedParameters();
			List<VariableCS> csParameters = csElement.getParameters();
			for (int i = 0; i < csParameters.size(); i++) {
				VariableCS csParameter = csParameters.get(i);
				Parameter contextParameter = context.refreshMonikeredElement(Parameter.class, PivotPackage.Literals.PARAMETER, csParameter);
				Parameter modelParameter = modelParameters.get(i);
				contextParameter.setName(csParameter.getName());
//				contextParameter.setType(PivotUtil.getPivot(Type.class, csParameter.getOwnedType()));
				contextParameter.setType(modelParameter.getType());				// FIXME consistency check
				contextOperation.getOwnedParameters().add(contextParameter);	// FIXME multiplicity
			}
			TypedRefCS csType = csElement.getOwnedType();
			if (csType != null) {
//				contextOperation.setType(PivotUtil.getPivot(Type.class, csType));
				contextOperation.setType(modelOperation.getType());			// FIXME consistency check
			}
			context.installPivotElement(csElement, contextOperation);
			contextType.getOwnedOperations().add(contextOperation);
//			typeManager.addContextOperation(modelOperation, contextOperation);
			return null;
		}
	}
	
	protected final TypeManager typeManager;

	public CompleteOCLPreOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPreOrderVisitor(context), context);
		typeManager = context.getTypeManager();
	}

	protected org.eclipse.ocl.examples.pivot.Class getContextClassifier(Type modelType, ModelElementCS csElement) {
		String moniker = modelType.getMoniker();
		MonikeredElement monikeredElement = context.getPivotElement(moniker);
		if (monikeredElement != null) {
			return (org.eclipse.ocl.examples.pivot.Class)monikeredElement;
		}
		org.eclipse.ocl.examples.pivot.Package contextPackage = getContextPackage(modelType.getPackage(), csElement);
		org.eclipse.ocl.examples.pivot.Class contextType = context.refreshMonikeredElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, moniker);
//		context.installPivotElement(csElement, contextType);
		contextType.setName(modelType.getName());
		contextPackage.getOwnedTypes().add(contextType);
//		typeManager.addContextType(modelType, contextType);
		return contextType;
	}

	protected org.eclipse.ocl.examples.pivot.Package getContextPackage(org.eclipse.ocl.examples.pivot.Package modelPackage, ElementCS csElement) {
		if (modelPackage == null) {
			return null;
		}
		String moniker = modelPackage.getMoniker();
		MonikeredElement monikeredElement = context.getPivotElement(moniker);
		if (monikeredElement != null) {
			return (org.eclipse.ocl.examples.pivot.Package)monikeredElement;
		}
		org.eclipse.ocl.examples.pivot.Package contextNestingPackage = getContextPackage(modelPackage.getNestingPackage(), csElement);
		org.eclipse.ocl.examples.pivot.Package contextPackage = context.refreshMonikeredElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, moniker);
		contextPackage.setName(modelPackage.getName());
		contextPackage.setMoniker(modelPackage.getMoniker());
		if (contextNestingPackage != null) {
			contextNestingPackage.getNestedPackages().add(contextPackage);
//			typeManager.addContextPackage(modelPackage, contextPackage);
		}
		else {
			Resource pivotResource = context.getConverter().getPivotResource(csElement.eResource());
			pivotResource.getContents().add(contextPackage);
		}
		typeManager.installPackage(contextPackage);
		return contextPackage;
	}

	@Override
	public Continuation<?> visitClassifierContextDeclCS(ClassifierContextDeclCS object) {
		context.resolveNamespaces(object.getNamespace());
		Type modelClassifier = object.getClassifier();
		if ((modelClassifier == null) || modelClassifier.eIsProxy()) {
			return null;
		}
		Type contextClassifier = getContextClassifier(modelClassifier, object);
//		if ((element == null) || element.eIsProxy()) {
//			context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//			element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//		}
		context.installPivotElement(object, contextClassifier);
		return null;
	}

	@Override
	public Continuation<?> visitDefCS(DefCS object) {
		return new DefCSContinuation(context, object);
	}

	@Override
	public Continuation<?> visitOperationContextDeclCS(OperationContextDeclCS object) {
		context.resolveNamespaces(object.getNamespace());
		// Must wait till parameters have types before resolving operation name
		return new OperationContextDeclCSContinuation(context, object);
	}

	@Override
	public Continuation<?> visitPackageDeclarationCS(PackageDeclarationCS object) {
		context.resolveNamespaces(object.getNamespace());
		org.eclipse.ocl.examples.pivot.Package modelPackage = object.getPackage();
		if ((modelPackage == null) || modelPackage.eIsProxy()) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Package contextPackage = getContextPackage(modelPackage, object);
//		if ((element == null) || element.eIsProxy()) {
//			context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//			element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//		}
		context.installPivotElement(object, contextPackage);
		return null; //new CompletePackageContentContinuation(context, object);
	}

	@Override
	public Continuation<?> visitPropertyContextDeclCS(PropertyContextDeclCS object) {
		context.resolveNamespaces(object.getNamespace());
		Property modelProperty = object.getProperty();
		if ((modelProperty == null) || modelProperty.eIsProxy()) {
			return null;
		}
		org.eclipse.ocl.examples.pivot.Class contextType = getContextClassifier(modelProperty.getClass_(), object);
//		if ((element == null) || element.eIsProxy()) {
//			context.addBadPackageError(csElement, OCLMessages.ErrorUnresolvedPackageName, csElement.toString());
//			element = context.getTypeManager().getOclInvalidType();	// FIXME with reason
//		}
		Property contextProperty = context.refreshMonikeredElement(Property.class, PivotPackage.Literals.PROPERTY, object);
		contextProperty.setName(modelProperty.getName());
		contextProperty.setType(modelProperty.getType());
		context.installPivotElement(object, contextProperty);
		contextType.getOwnedAttributes().add(contextProperty);
//		typeManager.addContextProperty(modelProperty, contextProperty);
		return null;
	}
}