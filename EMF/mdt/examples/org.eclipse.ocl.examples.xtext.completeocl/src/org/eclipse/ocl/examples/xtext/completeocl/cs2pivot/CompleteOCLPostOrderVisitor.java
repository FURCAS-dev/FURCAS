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
 * $Id: CompleteOCLPostOrderVisitor.java,v 1.4 2011/02/15 10:37:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

public class CompleteOCLPostOrderVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPostOrderVisitor>
{
//	protected static class ConstraintCSCompletion extends SingleContinuation<ContextConstraintCS>
//	{
//		public ConstraintCSCompletion(CS2PivotConversion context, ContextConstraintCS csElement) {
//			super(context, null, null, csElement);
//		}

//		@Override
//		public BasicContinuation<?> execute() {
//			context.visitLeft2Right(csElement);
//			return null;
//		}
//	}

	public CompleteOCLPostOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPostOrderVisitor(context), context);
	}

	@Override
	public Continuation<?> visitContextConstraintCS(ContextConstraintCS csConstraint) {
		Constraint pivotConstraint = context.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csConstraint);
		pivotConstraint.setStereotype(csConstraint.getStereotype());
		context.installPivotElement(csConstraint, pivotConstraint);
		ExpCS ownedExpression = csConstraint.getOwnedExpression();
		if (ownedExpression != null) {
			ValueSpecification specification = pivotConstraint.getSpecification();
			ExpressionInOcl pivotSpecification;
			if (specification instanceof ExpressionInOcl) {
				pivotSpecification = (ExpressionInOcl) specification;
			}
			else {
				pivotSpecification = PivotFactory.eINSTANCE.createExpressionInOcl();
				pivotConstraint.setSpecification(pivotSpecification);
			}
			ContextDeclCS csContextDecl = csConstraint.getContextDecl();
			String selfVariableName = Environment.SELF_VARIABLE_NAME;
			Type typeContext = null;
			Operation operationContext = null;
			Property propertyContext = null;
			if (csContextDecl instanceof ClassifierContextDeclCS) {
				typeContext = PivotUtil.getPivot(Type.class, csContextDecl);
				String name = ((ClassifierContextDeclCS)csContextDecl).getSelfName();
				if (name != null) {
					selfVariableName = name;
				}
			}
			else if (csContextDecl instanceof OperationContextDeclCS) {
				operationContext = PivotUtil.getPivot(Operation.class, csContextDecl);
				if (operationContext instanceof CompleteOperation) {
					operationContext = ((CompleteOperation)operationContext).getModel();
				}
				if (operationContext != null) {
					typeContext = operationContext.getClass_();
				}
			}
			else if (csContextDecl instanceof PropertyContextDeclCS) {
				propertyContext = PivotUtil.getPivot(Property.class, csContextDecl);
				if (propertyContext instanceof CompleteProperty) {
					propertyContext = ((CompleteProperty)propertyContext).getModel();
				}
				if (propertyContext != null) {
					typeContext = propertyContext.getClass_();
				}
			}
			if (typeContext instanceof CompleteType) {
				typeContext = ((CompleteType)typeContext).getModel();
			}
			Variable contextVariable = pivotSpecification.getContextVariable();
			if (contextVariable == null) {
				contextVariable = PivotFactory.eINSTANCE.createVariable();
			}
			context.refreshName(contextVariable, selfVariableName);
			pivotSpecification.setContextVariable(contextVariable);
//			context.putPivotElement(contextVariable);
			context.setType(contextVariable, typeContext);
			if (operationContext != null) {
		        pivotSpecification.getParameterVariables().clear();
		        for (Parameter parameter : operationContext.getOwnedParameters()) {
			        Variable param = PivotFactory.eINSTANCE.createVariable();
			        param.setName(parameter.getName());
			        param.setType(parameter.getType());
			        param.setRepresentedParameter(parameter);
			        pivotSpecification.getParameterVariables().add(param);
		        }
		        if (csConstraint instanceof PostCS) {
					Variable resultVariable = pivotSpecification.getResultVariable();
					if (resultVariable == null) {
						resultVariable = PivotFactory.eINSTANCE.createVariable();
					}
					resultVariable.setName(Environment.RESULT_VARIABLE_NAME);
					resultVariable.setType(operationContext.getType());
//					resultVariable.setRepresentedParameter(parameter);
					pivotSpecification.setResultVariable(resultVariable);
		        }
			}
					
			ExpCS csExpression = csConstraint.getOwnedExpression();
			OclExpression expression = context.refreshExpTree(OclExpression.class, csExpression);
			if (expression != null) {
				pivotSpecification.setBodyExpression(expression);
				context.setType(pivotSpecification, expression.getType());
			}
//			return new ConstraintCSCompletion(context, csConstraint);
		}
//		else {
			return null;
//		}
	}

	@Override
	public Continuation<?> visitContextDeclCS(ContextDeclCS object) {
		NamedElement pivotElement = PivotUtil.getPivot(NamedElement.class, object);
		context.refreshList(Constraint.class, pivotElement.getOwnedRules(), object.getRules());
		return null;
	}

	@Override
	public Continuation<?> visitDefCS(DefCS csConstraint) {
		Constraint pivotConstraint = context.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csConstraint);
		pivotConstraint.setStereotype(csConstraint.getStereotype());
		context.installPivotElement(csConstraint, pivotConstraint);
		ExpCS ownedExpression = csConstraint.getOwnedExpression();
		if (ownedExpression != null) {
			ValueSpecification specification = pivotConstraint.getSpecification();
			ExpressionInOcl pivotSpecification;
			if (specification instanceof ExpressionInOcl) {
				pivotSpecification = (ExpressionInOcl) specification;
			}
			else {
				pivotSpecification = PivotFactory.eINSTANCE.createExpressionInOcl();
				pivotConstraint.setSpecification(pivotSpecification);
			}
			ContextDeclCS csContextDecl = csConstraint.getContextDecl();
//			String selfVariableName = Environment.SELF_VARIABLE_NAME;
			Type typeContext = null;
			if (csContextDecl instanceof ClassifierContextDeclCS) {
				typeContext = PivotUtil.getPivot(Type.class, csContextDecl);
			}	// Else qualified name in PackageDecl
			if (typeContext instanceof CompleteType) {
				typeContext = ((CompleteType)typeContext).getModel();
			}
			Variable contextVariable = pivotSpecification.getContextVariable();
			if (contextVariable == null) {
				contextVariable = PivotFactory.eINSTANCE.createVariable();
			}
			context.refreshName(contextVariable, Environment.SELF_VARIABLE_NAME);
			pivotSpecification.setContextVariable(contextVariable);
//			context.putPivotElement(contextVariable);
			context.setType(contextVariable, typeContext);
		    pivotSpecification.getParameterVariables().clear();
		    for (VariableCS csParameter : csConstraint.getParameters()) {
		        Variable param = context.refreshNamedElement(Variable.class, PivotPackage.Literals.VARIABLE, csParameter);
		        param.setName(csParameter.getName());
		        param.setType(PivotUtil.getPivot(Type.class, csParameter.getOwnedType()));
//		        param.setRepresentedParameter(csParameter);
		        pivotSpecification.getParameterVariables().add(param);
	        }
					
			ExpCS csExpression = csConstraint.getOwnedExpression();
			OclExpression expression = context.refreshExpTree(OclExpression.class, csExpression);
			if (expression != null) {
				pivotSpecification.setBodyExpression(expression);
				context.setType(pivotSpecification, expression.getType());
			}
//			return new ConstraintCSCompletion(context, csConstraint);
		}
//		else {
			return null;
//		}
	}
}