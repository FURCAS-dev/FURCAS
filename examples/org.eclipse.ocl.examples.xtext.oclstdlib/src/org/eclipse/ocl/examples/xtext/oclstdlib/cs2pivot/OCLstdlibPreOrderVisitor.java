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
 * $Id: OCLstdlibPreOrderVisitor.java,v 1.4 2011/02/08 17:50:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasePreOrderVisitor.OperationContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuations;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;

public class OCLstdlibPreOrderVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPreOrderVisitor>
{
	private static final Logger logger = Logger.getLogger(OCLstdlibPreOrderVisitor.class);
	
	protected static class CollectionElementTypeContinuation extends SingleContinuation<LibClassCS>
	{
		public CollectionElementTypeContinuation(CS2PivotConversion context, LibClassCS csElement) {
			super(context, null, null, csElement, context.getPackagesHaveTypesInterDependency());
		}

		@Override
		public BasicContinuation<?> execute() {
			CollectionType type = PivotUtil.getPivot(CollectionType.class, csElement);
			type.setElementType((Type) type.getOwnedTemplateSignature().getParameters().get(0).getParameteredElement());
			return null;
		}
	}
	
	protected static class IterationContinuation extends OperationContinuation<LibIterationCS>
	{
		public IterationContinuation(CS2PivotConversion context, LibIterationCS csElement) {
			super(context, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Iteration pivotIteration = context.refreshNamedElement(Iteration.class, PivotPackage.Literals.ITERATION, csElement);
			context.refreshTemplateSignature(csElement, pivotIteration);
			List<ParameterCS> csIterators = csElement.getOwnedIterator();
			List<Parameter> newPivotIterators = new ArrayList<Parameter>();
			for (ParameterCS csIterator : csIterators) {
				Parameter pivotIterator = context.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, csIterator);
				newPivotIterators.add(pivotIterator);
			}
			context.refreshList(pivotIteration.getOwnedIterators(), newPivotIterators);
			List<ParameterCS> csAccumulators = csElement.getOwnedAccumulator();
			List<Parameter> newPivotAccumulators = new ArrayList<Parameter>();
			for (ParameterCS csAccumulator : csAccumulators) {
				Parameter pivotIterator = context.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, csAccumulator);
				newPivotAccumulators.add(pivotIterator);
			}
			context.refreshList(pivotIteration.getOwnedAccumulators(), newPivotAccumulators);
			List<ParameterCS> csParameters = csElement.getOwnedParameter();
			List<Parameter> newPivotParameters = new ArrayList<Parameter>();
			for (ParameterCS csParameter : csParameters) {
				Parameter pivotParameter = context.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, csParameter);
				newPivotParameters.add(pivotParameter);
			}
			context.refreshList(pivotIteration.getOwnedParameters(), newPivotParameters);
			context.getOperationsHaveTemplateParametersInterDependency().setSatisfied(this);
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
		String metaTypeName = csLibClass.getMetaTypeName();
		org.eclipse.ocl.examples.pivot.Class type;
		if ((metaTypeName == null) || "Class".equals(metaTypeName)) {
			type = context.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, csLibClass);
		}
		else if ("AnyType".equals(metaTypeName)) {
			type = context.refreshNamedElement(AnyType.class, PivotPackage.Literals.ANY_TYPE, csLibClass);
		}
		else if ("BagType".equals(metaTypeName)) {
			type = context.refreshNamedElement(BagType.class, PivotPackage.Literals.BAG_TYPE, csLibClass);
		}
		else if ("CollectionType".equals(metaTypeName)) {
			type = context.refreshNamedElement(CollectionType.class, PivotPackage.Literals.COLLECTION_TYPE, csLibClass);
		}
		else if ("InvalidType".equals(metaTypeName)) {
			type = context.refreshNamedElement(InvalidType.class, PivotPackage.Literals.INVALID_TYPE, csLibClass);
		}
		else if ("OrderedSetType".equals(metaTypeName)) {
			type = context.refreshNamedElement(OrderedSetType.class, PivotPackage.Literals.ORDERED_SET_TYPE, csLibClass);
		}
		else if ("PrimitiveType".equals(metaTypeName)) {
			type = context.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, csLibClass);
		}
		else if ("SequenceType".equals(metaTypeName)) {
			type = context.refreshNamedElement(SequenceType.class, PivotPackage.Literals.SEQUENCE_TYPE, csLibClass);
		}
		else if ("SetType".equals(metaTypeName)) {
			type = context.refreshNamedElement(SetType.class, PivotPackage.Literals.SET_TYPE, csLibClass);
		}
		else if ("TupleType".equals(metaTypeName)) {
			type = context.refreshNamedElement(TupleType.class, PivotPackage.Literals.TUPLE_TYPE, csLibClass);
		}
		else if ("VoidType".equals(metaTypeName)) {
			type = context.refreshNamedElement(VoidType.class, PivotPackage.Literals.VOID_TYPE, csLibClass);
		}
		else {
			logger.warn("Unsupported metaTypeName '" + metaTypeName + "'");
			type = context.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class,
				PivotPackage.Literals.CLASS, csLibClass);
		}
		Continuation<?> continuation = super.visitLibClassCS(csLibClass);
		if (type instanceof CollectionType) {
			continuation = Continuations.combine(continuation,
				new CollectionElementTypeContinuation(context, csLibClass));
		}
		return continuation;
	}

	@Override
	public Continuation<?> visitLibIterationCS(LibIterationCS csIteration) {
		return new IterationContinuation(context, csIteration);
	}

	@Override
	public Continuation<?> visitLibRootPackageCS(LibRootPackageCS csLibRootPackage) {
		@SuppressWarnings("unused")
		Library pivotElement = context.refreshNamedElement(Library.class, PivotPackage.Literals.LIBRARY, csLibRootPackage);
		Continuation<?> superContinuation = visitPackageCS(csLibRootPackage);
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