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
 * $Id: OCLstdlibPostOrderVisitor.java,v 1.2 2011/01/24 22:28:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;
import org.eclipse.xtext.common.types.JvmType;

public class OCLstdlibPostOrderVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPostOrderVisitor>
{		
	protected static class LibConstraintCSCompletion extends SingleContinuation<LibConstraintCS>
	{
		public LibConstraintCSCompletion(CS2PivotConversion context, LibConstraintCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Constraint pivotElement = PivotUtil.getPivot(Constraint.class, csElement);
			String stereotype = csElement.getStereotype();
			pivotElement.setStereotype(stereotype);
			ValueSpecification specification = pivotElement.getSpecification();
			if (!(specification instanceof ExpressionInOcl)) {
				specification = PivotFactory.eINSTANCE.createExpressionInOcl();
				pivotElement.setSpecification(specification);
			}
			context.putPivotElement(specification);
			if (specification instanceof ExpressionInOcl) {
				ExpressionInOcl expressionInOcl = (ExpressionInOcl)specification;
				EObject classifierContext = ((ModelElementCS)csElement.eContainer()).getPivot();
				while ((classifierContext != null) && !(classifierContext instanceof org.eclipse.ocl.examples.pivot.Class)) {
					classifierContext = classifierContext.eContainer();
				}
				org.eclipse.ocl.examples.pivot.Class pivotClass = (org.eclipse.ocl.examples.pivot.Class)classifierContext;
				Variable contextVariable = expressionInOcl.getContextVariable();
				if (contextVariable == null) {
					contextVariable = PivotFactory.eINSTANCE.createVariable();
					expressionInOcl.setContextVariable(contextVariable);
				}
				context.refreshName(contextVariable, "self");
				context.setType(contextVariable, pivotClass);
				context.putPivotElement(contextVariable);
				if ("post".equals(stereotype)) {
					Variable resultVariable = expressionInOcl.getResultVariable();
					if (resultVariable == null) {
						resultVariable = PivotFactory.eINSTANCE.createVariable();
						expressionInOcl.setResultVariable(resultVariable);
					}
					context.refreshName(resultVariable, "result");
					context.putPivotElement(resultVariable);
					context.setType(resultVariable, ((Operation)pivotElement.eContainer()).getType());
				}
				OclExpression expression = context.refreshExpTree(OclExpression.class, csElement.getOwnedExpression());
				expressionInOcl.setBodyExpression(expression);
				context.installResidualMonikers(expression);
			}
			return null;
		}
	}
	
	public OCLstdlibPostOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPostOrderVisitor(context), context);
	}

	@Override
	public Continuation<?> visitLibConstraintCS(LibConstraintCS csLibConstraint) {
		Continuation<?> superContinuation = super.visitLibConstraintCS(csLibConstraint);
		assert superContinuation == null;		// No super continuation
		return new LibConstraintCSCompletion(context, csLibConstraint);
	}

	@Override
	public Continuation<?> visitLibIterationCS(LibIterationCS csIteration) {
		Operation pivotElement = PivotUtil.getPivot(Iteration.class, csIteration);
//		pivotElement.setPrecedence(csIteration.getPrecedence());
//		pivotElement.setIsStatic(csIteration.isStatic());
		JvmType implementation = csIteration.getImplementation();
		if (implementation != null) {
			pivotElement.setImplementationClass(implementation.getCanonicalName());
		}
		return super.visitLibIterationCS(csIteration);
	}

	@Override
	public Continuation<?> visitLibOperationCS(LibOperationCS csOperation) {
		Operation pivotElement = PivotUtil.getPivot(Operation.class, csOperation);
		pivotElement.setPrecedence(csOperation.getPrecedence());
		pivotElement.setIsStatic(csOperation.isStatic());
		JvmType implementation = csOperation.getImplementation();
		if (implementation != null) {
			pivotElement.setImplementationClass(implementation.getCanonicalName());
		}
		return super.visitLibOperationCS(csOperation);
	}

	@Override
	public Continuation<?> visitLibPropertyCS(LibPropertyCS csProperty) {
		Property pivotElement = PivotUtil.getPivot(Property.class, csProperty);
		pivotElement.setIsStatic(csProperty.isStatic());
		JvmType implementation = csProperty.getImplementation();
		if (implementation != null) {
			pivotElement.setImplementationClass(implementation.getCanonicalName());
		}
		return super.visitLibPropertyCS(csProperty);
	}

	@Override
	public Continuation<?> visitPrecedenceCS(PrecedenceCS csPrecedence) {
		return null;
	}
}