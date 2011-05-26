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
 * $Id: OCLstdlibPreOrderVisitor.java,v 1.11 2011/05/20 15:27:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePreOrderVisitor.OperationContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuations;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.MetaTypeName;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;
import org.eclipse.xtext.common.types.JvmType;

public class OCLstdlibPreOrderVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPreOrderVisitor>
{
	protected static class ClassifierInstanceTypeContinuation extends SingleContinuation<LibClassCS>
	{
		public ClassifierInstanceTypeContinuation(CS2PivotConversion context, LibClassCS csElement) {
			super(context, null, null, csElement, context.getPackagesHaveTypesInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			ClassifierType type = PivotUtil.getPivot(ClassifierType.class, csElement);
			TemplateSignature ownedTemplateSignature = type.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				List<TemplateParameter> parameters = ownedTemplateSignature.getParameters();
				if (parameters.size() > 0) {
					TemplateParameter templateParameter = parameters.get(0);
					if (templateParameter != null) {
						type.setInstanceType((Type) templateParameter.getParameteredElement());
					}
				}
			}
			return null;
		}
	}
	
	protected static class CollectionElementTypeContinuation extends SingleContinuation<LibClassCS>
	{
		public CollectionElementTypeContinuation(CS2PivotConversion context, LibClassCS csElement) {
			super(context, null, null, csElement, context.getPackagesHaveTypesInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			CollectionType type = PivotUtil.getPivot(CollectionType.class, csElement);
			TemplateSignature ownedTemplateSignature = type.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				List<TemplateParameter> parameters = ownedTemplateSignature.getParameters();
				if (parameters.size() > 0) {
					type.setElementType((Type) parameters.get(0).getParameteredElement());
				}
			}
			return null;
		}
	}
	
	protected static class LibIterationContinuation extends OperationContinuation<LibIterationCS>
	{
		public LibIterationContinuation(CS2PivotConversion context, LibIterationCS csElement) {
			super(context, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			String moniker = csElement.getMoniker();
			Iteration pivotIteration = context.refreshTypedMultiplicityElement(Iteration.class, PivotPackage.Literals.ITERATION, csElement);
			pivotIteration.setMoniker(moniker);
			context.refreshTemplateSignature(csElement, pivotIteration);
			refreshParameters(csElement.getOwnedIterator(), pivotIteration.getOwnedIterators());
			refreshParameters(csElement.getOwnedAccumulator(), pivotIteration.getOwnedAccumulators());
			refreshParameters(csElement.getOwnedParameter(), pivotIteration.getOwnedParameters());
			context.getOperationsHaveTemplateParametersInterDependency().setSatisfied(this);
//			pivotElement.setPrecedence(csIteration.getPrecedence());
//			pivotElement.setIsStatic(csIteration.isStatic());
			JvmType implementation = csElement.getImplementation();
			if (implementation != null) {
				pivotIteration.setImplementationClass(implementation.getIdentifier());
			}
			return null;
		}
	}
	
	protected static class LibOperationContinuation extends OperationContinuation<LibOperationCS>
	{
		public LibOperationContinuation(CS2PivotConversion context, LibOperationCS csElement) {
			super(context, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			BasicContinuation<?> continuation = super.execute();
			Operation pivotElement = PivotUtil.getPivot(Operation.class, csElement);
			Precedence precedence = csElement.getPrecedence();
			if ((precedence != null) && precedence.eIsProxy()) {
				precedence = null;
			}
			pivotElement.setPrecedence(precedence);
			pivotElement.setIsStatic(csElement.isStatic());
			JvmType implementation = csElement.getImplementation();
			if (implementation != null) {
				pivotElement.setImplementationClass(implementation.getIdentifier());
			}
			return continuation;
		}
	}
	
	protected static class LibPropertyContinuation extends SingleContinuation<LibPropertyCS>
	{
		public LibPropertyContinuation(CS2PivotConversion context, LibPropertyCS csElement) {
			super(context, null, null, csElement, context.getTypesHaveSignaturesInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			Property pivotElement = PivotUtil.getPivot(Property.class, csElement);
			pivotElement.setIsStatic(csElement.isStatic());
			JvmType implementation = csElement.getImplementation();
			if (implementation != null) {
				pivotElement.setImplementationClass(implementation.getIdentifier());
			}
			return null;
		}
	}

	protected static class LibraryPrecedenceContinuation extends SingleContinuation<LibRootPackageCS>
	{
		private LibraryPrecedenceContinuation(CS2PivotConversion context, LibRootPackageCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Library pivotElement = PivotUtil.getPivot(Library.class, csElement);
			context.refreshPivotList(Precedence.class, pivotElement.getOwnedPrecedences(), csElement.getOwnedPrecedence());
			return null;
		}
	}

	public OCLstdlibPreOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPreOrderVisitor(context), context);
	}

	@Override
	public Continuation<?> visitLibClassCS(LibClassCS csLibClass) {
		EClass eClass = null;
		MetaTypeName metaType = csLibClass.getMetaTypeName();
		if ((metaType != null) && !metaType.eIsProxy()) {
			String metaTypeName = metaType.getName();
			eClass = (EClass) EcoreUtils.getNamedElement(PivotPackage.eINSTANCE.getEClassifiers(), metaTypeName);
		}
		if (eClass == null) {
			eClass = PivotPackage.Literals.CLASS;
		}
		@SuppressWarnings("unchecked")
		Class<Type> instanceClass = (Class<Type>)eClass.getInstanceClass();
		Type type = context.refreshNamedElement(instanceClass, eClass, csLibClass);
		type.setMoniker(csLibClass.getMoniker());
		Continuation<?> continuation = super.visitLibClassCS(csLibClass);
		if (type instanceof CollectionType) {
			continuation = Continuations.combine(continuation,
				new CollectionElementTypeContinuation(context, csLibClass));
		}
		else if (type instanceof ClassifierType) {
			continuation = Continuations.combine(continuation,
				new ClassifierInstanceTypeContinuation(context, csLibClass));
		}
		return continuation;
	}

	@Override
	public Continuation<?> visitLibIterationCS(LibIterationCS csIteration) {
		return new LibIterationContinuation(context, csIteration);
	}

	@Override
	public Continuation<?> visitLibOperationCS(LibOperationCS csOperation) {
		return new LibOperationContinuation(context, csOperation);
	}

	@Override
	public Continuation<?> visitLibPropertyCS(LibPropertyCS csProperty) {
		return new LibPropertyContinuation(context, csProperty);
	}

	@Override
	public Continuation<?> visitLibRootPackageCS(LibRootPackageCS csLibRootPackage) {
		@SuppressWarnings("unused")
		Library pivotElement = context.refreshPackage(Library.class, PivotPackage.Literals.LIBRARY, csLibRootPackage);
		Continuation<?> superContinuation = super.visitLibRootPackageCS(csLibRootPackage);
		Continuation<?> localContinuation =  new LibraryPrecedenceContinuation(context, csLibRootPackage);
		return Continuations.combine(superContinuation, localContinuation);
	}

	@Override
	public Continuation<?> visitPrecedenceCS(PrecedenceCS csPrecedence) {
		Precedence pivotPrecedence = context.refreshNamedElement(Precedence.class,
			PivotPackage.Literals.PRECEDENCE, csPrecedence);
		pivotPrecedence.setAssociativity(csPrecedence.isRightAssociative() ? AssociativityKind.RIGHT : AssociativityKind.LEFT);
		return null;
	}
}