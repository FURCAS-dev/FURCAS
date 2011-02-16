/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: BasePreOrderVisitor.java,v 1.4 2011/02/16 08:43:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;

public class BasePreOrderVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, CS2PivotConversion>
{
	private static final Logger logger = Logger.getLogger(BasePreOrderVisitor.class);

	protected static class ClassContentContinuation extends SingleContinuation<ClassCS>
	{
		public ClassContentContinuation(CS2PivotConversion context, org.eclipse.ocl.examples.pivot.Class pivotParent, ClassCS csElement) {
			super(context, pivotParent, null, csElement, context.getOperationsHaveTemplateParametersInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			org.eclipse.ocl.examples.pivot.Class pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Class.class, csElement);
			refreshOperations(csElement, pivotElement);
			return null;
		}

		protected void refreshOperations(ClassCS csClass, org.eclipse.ocl.examples.pivot.Class pivotElement) {
			List<OperationCS> csOperations = csClass.getOwnedOperation();
			List<Operation> newPivotOperations = new ArrayList<Operation>();
			for (OperationCS csOperation : csOperations) {
				Operation pivotOperation = PivotUtil.getPivot(Operation.class, csOperation);
				newPivotOperations.add(pivotOperation);
			}
			context.refreshList(pivotElement.getOwnedOperations(), newPivotOperations);
		}
	}

	protected static class ClassSupersContinuation extends SingleContinuation<ClassCS>
	{
		public ClassSupersContinuation(CS2PivotConversion context, org.eclipse.ocl.examples.pivot.Class pivotParent, ClassCS csElement) {
			super(context, pivotParent, null, csElement, context.getTypesHaveSpecializationsInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			org.eclipse.ocl.examples.pivot.Class pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Class.class, csElement);
			context.refreshList(org.eclipse.ocl.examples.pivot.Class.class, pivotElement.getSuperClasses(), csElement.getOwnedSuperType());
			return null;
		}
	}
	
	protected static class LambdaContinuation extends SingleContinuation<LambdaTypeCS>
	{
		public LambdaContinuation(CS2PivotConversion context, LambdaTypeCS csElement) {
			super(context, null, null, csElement, context.getPackagesHaveTypesInterDependency());
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			if (csElement.getOwnedContextType().getPivot() == null) {
				return false;
			}
			if (csElement.getOwnedResultType().getPivot() == null) {
				return false;
			}
			for (TypedRefCS csParameterType : csElement.getOwnedParameterType()) {
				if (csParameterType.getPivot() == null) {
					return false;
				}
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			LambdaType pivotLambdaType = context.refreshNamedElement(LambdaType.class, PivotPackage.Literals.LAMBDA_TYPE, csElement);
			pivotLambdaType.setContextType(PivotUtil.getPivot(Type.class, csElement.getOwnedContextType()));
			pivotLambdaType.setResultType(PivotUtil.getPivot(Type.class, csElement.getOwnedResultType()));
			List<TypedRefCS> csParameterTypes = csElement.getOwnedParameterType();
			List<Type> newPivotParameterTypes = new ArrayList<Type>();
			for (TypedRefCS csParameterType : csParameterTypes) {
				Type parameterType = PivotUtil.getPivot(Type.class, csParameterType);
				newPivotParameterTypes.add(parameterType);
			}
			context.refreshList(pivotLambdaType.getParameterTypes(), newPivotParameterTypes);
			context.getTypeManager().addOrphanType(pivotLambdaType);
			return null;
		}
	}
	
	public static class OperationContinuation<T extends OperationCS> extends SingleContinuation<T>
	{
		public OperationContinuation(CS2PivotConversion context, T csElement) {
			super(context, null, null, csElement, context.getTypesHaveSignaturesInterDependency());
			context.getOperationsHaveTemplateParametersInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			Operation pivotOperation = context.refreshTypedMultiplicityElement(Operation.class, PivotPackage.Literals.OPERATION, csElement);
			context.refreshTemplateSignature(csElement, pivotOperation);
			List<ParameterCS> csParameters = csElement.getOwnedParameter();
			List<Parameter> newPivotParameters = new ArrayList<Parameter>();
			for (ParameterCS csParameter : csParameters) {
				Parameter pivotParameter = context.refreshTypedMultiplicityElement(Parameter.class, PivotPackage.Literals.PARAMETER, csParameter);
				newPivotParameters.add(pivotParameter);
			}
			context.refreshList(pivotOperation.getOwnedParameters(), newPivotParameters);
			context.refreshList(Type.class, pivotOperation.getRaisedExceptions(), csElement.getOwnedException());
			context.getOperationsHaveTemplateParametersInterDependency().setSatisfied(this);
			return null;
		}
	}
	
	protected static class PackageContentContinuation extends SingleContinuation<PackageCS>
	{
		private PackageContentContinuation(CS2PivotConversion context, PackageCS csElement) {
			super(context, null, null, csElement);
			context.getPackagesHaveTypesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			org.eclipse.ocl.examples.pivot.Package pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, csElement);
			context.refreshPivotList(Type.class, pivotElement.getOwnedTypes(), csElement.getOwnedType());
			context.refreshPivotList(org.eclipse.ocl.examples.pivot.Package.class, pivotElement.getNestedPackages(), csElement.getOwnedNestedPackage());
			context.getPackagesHaveTypesInterDependency().setSatisfied(this);
			return null;
		}
	}

/*	protected static class SpecializationSupersContinuation extends SingleContinuation<TemplateBindingCS>
	{
		public SpecializationSupersContinuation(CS2PivotConversion context, org.eclipse.ocl.examples.pivot.Class pivotParent, TemplateBindingCS csElement) {
			super(context, pivotParent, null, csElement, context.getTypesHaveSpecializationsInterDependency());
		}

		@Override
		public boolean canExecute() {
			boolean superCanExecute = super.canExecute();
			if (!superCanExecute) {
				return false;
			}
			TemplateBinding pivotElement = PivotUtil.getPivot(TemplateBinding.class, csElement);
			TemplateableElement boundElement = pivotElement.getBoundElement();
			org.eclipse.ocl.examples.pivot.Class unboundType = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class)boundElement);
			List<org.eclipse.ocl.examples.pivot.Class> unboundSuperClasses = unboundType.getSuperClasses();
			if (unboundSuperClasses.size() <= 0) {	// Only OclAny has no sperClasses and OclAny is not templateable.
				return false;
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			TemplateBinding pivotElement = PivotUtil.getPivot(TemplateBinding.class, csElement);
			TemplateableElement boundElement = pivotElement.getBoundElement();
			context.getTypeManager().resolveSuperClasses((org.eclipse.ocl.examples.pivot.Class)boundElement);
			return null;
		}
	} */

	protected static class TemplateBindingContinuation extends SingleContinuation<TemplateBindingCS>
	{		
		public TemplateBindingContinuation(CS2PivotConversion context, TemplateBindingCS csElement) {
			super(context, csElement.getOwningTemplateBindableElement().getPivot(),
				PivotPackage.Literals.TEMPLATEABLE_ELEMENT__TEMPLATE_BINDING, csElement,
				context.getPackagesHaveTypesInterDependency());
			context.getTypesHaveSpecializationsInterDependency().addDependency(this);
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			TypedTypeRefCS csParameterizedTypeRef = csElement.getOwningTemplateBindableElement();
			if (csParameterizedTypeRef instanceof TypedTypeRefCSImpl) {
				Type unspecializedPivotElement = ((TypedTypeRefCSImpl)csParameterizedTypeRef).basicGetType();
				if (unspecializedPivotElement == null) {
					return false;
				}
//				if (unspecializedPivotElement.eIsProxy()) {
//					return false;
//				}
			}
			for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : csElement.getOwnedParameterSubstitution()) {
				ParameterableElementCS csTemplateParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
				if (!(csTemplateParameter instanceof WildcardTypeRefCS)) {
					Element pivot = csTemplateParameter.getPivot();
					if (pivot == null) {
						return false;
					}
				}
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			boolean isSpecialization = ElementUtil.isSpecialization(csElement);
			if (isSpecialization) {
				TypedTypeRefCS csTypedTypeRef = csElement.getOwningTemplateBindableElement();				
				@SuppressWarnings("unused")
				Type pivotType = (Type) context.specializeTemplates(csTypedTypeRef);
			}
			context.getTypesHaveSpecializationsInterDependency().setSatisfied(this);
			return null;
		}
	}

	protected static class TemplateSignatureContinuation extends SingleContinuation<ClassifierCS>
	{
		public TemplateSignatureContinuation(CS2PivotConversion context, NamedElement pivotParent, ClassifierCS csElement) {
			super(context, pivotParent, PivotPackage.Literals.TEMPLATEABLE_ELEMENT__OWNED_TEMPLATE_SIGNATURE, csElement);
			context.getTypesHaveSignaturesInterDependency().addDependency(this);
		}

		@Override
		public BasicContinuation<?> execute() {
			Type pivotElement = PivotUtil.getPivot(Type.class, csElement);
			context.refreshTemplateSignature(csElement, pivotElement);
			context.getTypesHaveSignaturesInterDependency().setSatisfied(this);
			return null;
		}
	}
	
	protected static class TupleContinuation extends SingleContinuation<TupleTypeCS>
	{
		public TupleContinuation(CS2PivotConversion context, TupleTypeCS csElement) {
			super(context, null, null, csElement, context.getPackagesHaveTypesInterDependency());
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			for (TuplePartCS csTuplePart : csElement.getOwnedParts()) {
				TypedRefCS ownedType = csTuplePart.getOwnedType();
				if (ownedType.getPivot() == null) {
					return false;
				}
			}
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			TupleType pivotTupleType = context.refreshNamedElement(TupleType.class, PivotPackage.Literals.TUPLE_TYPE, csElement);
			List<TuplePartCS> csTupleParts = csElement.getOwnedParts();
			List<Property> newPivotParts = new ArrayList<Property>();
			for (TuplePartCS csTuplePart : csTupleParts) {
				Property pivotPart = context.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, csTuplePart);
				Type partType = PivotUtil.getPivot(Type.class, csTuplePart.getOwnedType());
				pivotPart.setType(partType);
				newPivotParts.add(pivotPart);
			}
			context.refreshList(pivotTupleType.getOwnedAttributes(), newPivotParts);
			context.getTypeManager().addOrphanType(pivotTupleType);
			return null;
		}
	}

	protected static class TypeRefContinuation extends SingleContinuation<TypedTypeRefCS>
	{
		protected static final class TemplateBindingPivotDependency extends AbstractDependency<TemplateBindingCS>
		{
			protected TemplateBindingPivotDependency(TemplateBindingCS csElement) {
				super(csElement);
			}

			@Override
			public boolean canExecute() {
				boolean isSpecialization = false;
				TypedTypeRefCS csTypedTypeRef = element.getOwningTemplateBindableElement();
				Element type = csTypedTypeRef.getPivot();
				if (type == null) {
					return false;
				}
				for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : element.getOwnedParameterSubstitution()) {
					ParameterableElementCS ownedActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
					org.eclipse.ocl.examples.pivot.Class actualParameterClass = (org.eclipse.ocl.examples.pivot.Class) ownedActualParameter.getPivot();
					if (actualParameterClass == null) {
						return false;
					}
					TemplateParameter owningTemplateParameter = actualParameterClass.getOwningTemplateParameter();
					if (owningTemplateParameter == null) {
						isSpecialization = true;
					}
					else {
						TemplateSignature signature = owningTemplateParameter.getSignature();
						TemplateableElement template = signature.getTemplate();
						if (template != type) {
							isSpecialization = true;
						}
					}
				}
				return !isSpecialization || (element.getPivot() != null);
			}
		}

		private static Dependency[] computeDependencies(CS2PivotConversion context, TypedTypeRefCS csElement) {
			Dependency typeDependency = ElementUtil.isInOperation(csElement)
				? context.getOperationsHaveTemplateParametersInterDependency()
				: context.getPackagesHaveTypesInterDependency();
			TemplateBindingCS csTemplateBinding = csElement.getOwnedTemplateBinding();
			if (csTemplateBinding == null) {
				return new Dependency[] {typeDependency};
			}
			else {
				return new Dependency[] {typeDependency, new TemplateBindingPivotDependency(csTemplateBinding)};
			}
		}
		
		public TypeRefContinuation(CS2PivotConversion context, TypedTypeRefCS csElement) {
			super(context, null, null, csElement, computeDependencies(context, csElement));
		}

		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}
			context.resolveNamespaces(csElement.getNamespace());
			return true;
		}

		@Override
		public BasicContinuation<?> execute() {
			Element pivotType = csElement.getType();
			if (pivotType.eIsProxy()) {
				Type badType = context.addBadTypeError(csElement, OCLMessages.ErrorUnresolvedTypeName, csElement);
				csElement.setType(badType);
			}
			else {
				TemplateBindingCS csTemplateBinding = csElement.getOwnedTemplateBinding();
				if ((csTemplateBinding != null) && ElementUtil.isSpecialization(csTemplateBinding)) {
					TemplateBinding pivotTemplateBinding = PivotUtil.getPivot(TemplateBinding.class, csTemplateBinding);
					pivotType = pivotTemplateBinding.getBoundElement();
				}
				context.installPivotElement(csElement, pivotType);
			}
			return null;
		}
	}

/*	protected static class WildcardTypeRefContinuation extends SingleContinuation<WildcardTypeRefCS>
	{		
		public WildcardTypeRefContinuation(CS2PivotConversion context, WildcardTypeRefCS csElement) {
			super(context, null, null, csElement, context.getPackagesHaveTypesInterDependency());
		}

//		@Override
//		public boolean canExecute() {
//			Type type = csElement.getType();
//			return !type.eIsProxy();
//		}

		@Override
		public BasicContinuation<?> execute() {
			TemplateParameterSubstitutionCS csTemplateParameterSubstitution = (TemplateParameterSubstitutionCS)csElement.eContainer();
			TemplateBindingCS csTemplateBinding = csTemplateParameterSubstitution.getOwningTemplateBinding();
			ParameterizedTypeRefCS csParameterizedTypeRef = csTemplateBinding.getOwningTemplateBindableElement();
			Type type = csParameterizedTypeRef.getType();

			
			org.eclipse.ocl.examples.pivot.Class pivotElement = PivotFactory.eINSTANCE.createClass();
			String name = PivotConstants.WILDCARD_NAME;
			pivotElement.setName(name);
			
			
			context.installPivotElement(csElement, pivotElement);
			return null;
		}
	} */

	public BasePreOrderVisitor(CS2PivotConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	protected BasicContinuation<?> refreshClassifier(ClassifierCS csClassifier, org.eclipse.ocl.examples.pivot.Class pivotElement) {
		if (csClassifier.eIsSet(BaseCSTPackage.Literals.CLASSIFIER_CS__INSTANCE_CLASS_NAME)) {
			pivotElement.setInstanceClassName(csClassifier.getInstanceClassName());
		}
		else {
			pivotElement.eUnset(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME);
		}
		String newInstanceClassName = csClassifier.getInstanceClassName();
		String oldInstanceClassName = pivotElement.getInstanceClassName();
		if ((newInstanceClassName != oldInstanceClassName) && ((newInstanceClassName == null) || !newInstanceClassName.equals(oldInstanceClassName))) {
			pivotElement.setInstanceClassName(newInstanceClassName);
		}
		if (csClassifier.getOwnedTemplateSignature() != null) {
			return new TemplateSignatureContinuation(context, pivotElement, csClassifier);
		}
		if (pivotElement.getOwnedTemplateSignature() != null) {
			pivotElement.setOwnedTemplateSignature(null);
		}
		return null;
	}

	protected void refreshEnumerationLiterals(EnumerationCS csEnumeration, org.eclipse.ocl.examples.pivot.Enumeration pivotElement) {
		List<EnumerationLiteralCS> csEnumerationLiterals = csEnumeration.getOwnedLiterals();
		List<EnumerationLiteral> newPivotLiterals = new ArrayList<EnumerationLiteral>();
		for (EnumerationLiteralCS csEnumerationLiteral : csEnumerationLiterals) {
			EnumerationLiteral pivotEnumerationLiteral = context.refreshNamedElement(EnumerationLiteral.class,
				PivotPackage.Literals.ENUMERATION_LITERAL, csEnumerationLiteral);
			newPivotLiterals.add(pivotEnumerationLiteral);
			pivotEnumerationLiteral.setValue(BigInteger.valueOf(csEnumerationLiteral.getValue()));
		}
		context.refreshList(pivotElement.getOwnedLiterals(), newPivotLiterals);
	}

	protected void refreshProperties(ClassCS csClass, org.eclipse.ocl.examples.pivot.Class pivotElement) {
		List<StructuralFeatureCS> csProperties = csClass.getOwnedProperty();
		List<Property> newPivotProperties = new ArrayList<Property>();
		for (StructuralFeatureCS csProperty : csProperties) {
			Property pivotProperty = context.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, csProperty);
			newPivotProperties.add(pivotProperty);
		}
		context.refreshList(pivotElement.getOwnedAttributes(), newPivotProperties);
	}

	public Continuation<?> visiting(VisitableCS visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}

	@Override
	public Continuation<?> visitAnnotationCS(AnnotationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitClassCS(ClassCS csClass) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = context.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class,
			PivotPackage.Literals.CLASS, csClass);
		List<String> qualifiers = csClass.getQualifier();
		pivotElement.setIsAbstract(qualifiers.contains("abstract"));
		pivotElement.setIsInterface(qualifiers.contains("interface"));
		pivotElement.setIsStatic(qualifiers.contains("static"));
		refreshProperties(csClass, pivotElement);
		Continuations continuations = new Continuations();
		continuations.add(refreshClassifier(csClass, pivotElement));
		continuations.add(new ClassContentContinuation(context, pivotElement, csClass));
		if (csClass.getOwnedSuperType().size() > 0) {
			continuations.add(new ClassSupersContinuation(context, pivotElement, csClass));
		}
		return continuations.getContinuation();
	}

	@Override
	public Continuation<?> visitConstraintCS(ConstraintCS csConstraint) {
		return null;
	}

	@Override
	public Continuation<?> visitDataTypeCS(DataTypeCS csDataType) {
		DataType pivotElement = context.refreshNamedElement(DataType.class,
			PivotPackage.Literals.DATA_TYPE, csDataType);
		List<String> qualifiers = csDataType.getQualifier();
		pivotElement.setIsSerializable(qualifiers.contains("serializable"));
		return refreshClassifier(csDataType, pivotElement);
	}

	@Override
	public Continuation<?> visitDocumentationCS(DocumentationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitEnumerationCS(EnumerationCS csEnumeration) {
		org.eclipse.ocl.examples.pivot.Enumeration pivotElement = context.refreshNamedElement(org.eclipse.ocl.examples.pivot.Enumeration.class,
			PivotPackage.Literals.ENUMERATION, csEnumeration);
		refreshEnumerationLiterals(csEnumeration, pivotElement);
		List<String> qualifiers = csEnumeration.getQualifier();
		pivotElement.setIsSerializable(qualifiers.contains("serializable"));
		return refreshClassifier(csEnumeration, pivotElement);
	}

	@Override
	public Continuation<?> visitEnumerationLiteralCS(EnumerationLiteralCS csEnumerationLiteral) {
		return null;
	}

	@Override
	public Continuation<?> visitLambdaTypeCS(LambdaTypeCS csLambdaType) {
		return new LambdaContinuation(context, csLambdaType);
	}

	@Override
	public Continuation<?> visitModelElementCS(ModelElementCS csModelElement) {
		return null;
	}

	@Override
	public Continuation<?> visitOperationCS(OperationCS csOperation) {
		return new OperationContinuation<OperationCS>(context, csOperation);
	}

	@Override
	public Continuation<?> visitPackageCS(PackageCS csPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotElement = context.refreshNamedElement(org.eclipse.ocl.examples.pivot.Package.class,
			PivotPackage.Literals.PACKAGE, csPackage);
		context.declareAlias(pivotElement, csPackage);
		String newNsPrefix = csPackage.getNsPrefix();
		String oldNsPrefix = pivotElement.getNsPrefix();
		if ((newNsPrefix != oldNsPrefix) && ((newNsPrefix == null) || !newNsPrefix.equals(oldNsPrefix))) {
			pivotElement.setNsPrefix(newNsPrefix);
		}
		String newNsURI = csPackage.getNsURI();
		String oldNsURI = pivotElement.getNsURI();
		if ((newNsURI != oldNsURI) && ((newNsURI == null) || !newNsURI.equals(oldNsURI))) {
			pivotElement.setNsURI(newNsURI);
		}
		return new PackageContentContinuation(context, csPackage);
	}

	@Override
	public Continuation<?> visitPrimitiveTypeRefCS(PrimitiveTypeRefCS csPrimitiveTypeRef) {
		Type type = context.getTypeManager().getLibraryType(csPrimitiveTypeRef.getName());
		context.reusePivotElement(csPrimitiveTypeRef, type);
		return null;
	}

	@Override
	public Continuation<?> visitReferenceCSRef(ReferenceCSRef object) {
		return null;
	}

	@Override
	public Continuation<?> visitStructuralFeatureCS(StructuralFeatureCS csStructuralFeature) {
		Property pivotElement = context.refreshTypedMultiplicityElement(Property.class, PivotPackage.Literals.PROPERTY, csStructuralFeature);
		List<String> qualifiers = csStructuralFeature.getQualifier();
		pivotElement.setIsComposite(qualifiers.contains("composes"));
		pivotElement.setIsDerived(qualifiers.contains("derived"));
		pivotElement.setIsID(qualifiers.contains("id"));
		pivotElement.setIsReadOnly(qualifiers.contains("readonly"));
		pivotElement.setIsResolveProxies(context.getQualifier(qualifiers, "resolve", "!resolve", true));
		pivotElement.setIsStatic(qualifiers.contains("static"));
		pivotElement.setIsTransient(qualifiers.contains("transient"));
		pivotElement.setIsUnsettable(qualifiers.contains("unsettable"));
		pivotElement.setIsVolatile(qualifiers.contains("volatile"));
		if (csStructuralFeature.eIsSet(BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT)) {
			pivotElement.setDefault(csStructuralFeature.getDefault());
		}
		else {
			pivotElement.eUnset(PivotPackage.Literals.PROPERTY__DEFAULT);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTemplateBindingCS(TemplateBindingCS csTemplateBinding) {
		if (csTemplateBinding.getOwnedParameterSubstitution().isEmpty()) {
			return null;
		}
		else {
			return new TemplateBindingContinuation(context, csTemplateBinding);
		}
	}

	@Override
	public Continuation<?> visitTemplateSignatureCS(TemplateSignatureCS csTemplateSignature) {
		return null;
	}

	@Override
	public Continuation<?> visitTupleTypeCS(TupleTypeCS csTupleType) {
		return new TupleContinuation(context, csTupleType);
	}

	@Override
	public Continuation<?> visitTypedTypeRefCS(TypedTypeRefCS csTypedTypeRef) {
		return new TypeRefContinuation(context, csTypedTypeRef);
	}
}