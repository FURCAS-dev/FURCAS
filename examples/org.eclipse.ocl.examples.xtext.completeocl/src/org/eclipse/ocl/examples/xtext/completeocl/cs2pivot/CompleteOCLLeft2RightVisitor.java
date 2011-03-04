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
 * $Id: CompleteOCLLeft2RightVisitor.java,v 1.4 2011/03/04 13:56:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.cs2pivot;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;

public class CompleteOCLLeft2RightVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<MonikeredElement, CS2PivotConversion, EssentialOCLLeft2RightVisitor>
{
	public CompleteOCLLeft2RightVisitor(CS2PivotConversion context) {
		super(new EssentialOCLLeft2RightVisitor(context), context);
	}

	@Override
	public MonikeredElement visitContextConstraintCS(ContextConstraintCS csConstraint) {
		Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csConstraint);
		ExpSpecificationCS csSpecification = (ExpSpecificationCS) csConstraint.getSpecification();
		ExpCS csExpression = csSpecification.getOwnedExpression();
		if (csExpression != null) {
			ExpressionInOcl pivotSpecification = context.refreshMonikeredElement(ExpressionInOcl.class,
				PivotPackage.Literals.EXPRESSION_IN_OCL, csSpecification);
			context.installPivotElement(csSpecification, pivotSpecification);
			pivotConstraint.setSpecification(pivotSpecification);
	
			Variable contextVariable = pivotSpecification.getContextVariable();
			if (contextVariable == null) {
				contextVariable = PivotFactory.eINSTANCE.createVariable();
				pivotSpecification.setContextVariable(contextVariable);
			}
			String selfVariableName = Environment.SELF_VARIABLE_NAME;
			ContextDeclCS contextDecl = csConstraint.getContextDecl();
			if (contextDecl instanceof ClassifierContextDeclCS) {
				ClassifierContextDeclCS csClassifierContextDecl = (ClassifierContextDeclCS)contextDecl;
				Type contextType = csClassifierContextDecl.getClassifier();
				context.setType(contextVariable, contextType);
				String selfName = csClassifierContextDecl.getSelfName();
				if (selfName != null) {
					selfVariableName = selfName;
				}
			}
			else if (contextDecl instanceof PropertyContextDeclCS) {
				PropertyContextDeclCS csPropertyContextDecl = (PropertyContextDeclCS)contextDecl;
				Property contextProperty = csPropertyContextDecl.getProperty();
				context.setType(contextVariable, contextProperty.getClass_());
			}
			else if (contextDecl instanceof OperationContextDeclCS) {
				OperationContextDeclCS csOperationContextDecl = (OperationContextDeclCS)contextDecl;
				Operation contextOperation = csOperationContextDecl.getOperation();
				context.setType(contextVariable, contextOperation.getClass_());
		        pivotSpecification.getParameterVariables().clear();
		        for (Parameter parameter : contextOperation.getOwnedParameters()) {
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
					resultVariable.setType(contextOperation.getType());
					pivotSpecification.setResultVariable(resultVariable);
		        }
			}
			context.refreshName(contextVariable, selfVariableName);
			
			
			OclExpression bodyExpression = context.visitLeft2Right(OclExpression.class, csExpression);		
			pivotSpecification.setBodyExpression(bodyExpression);
			pivotSpecification.setType(bodyExpression.getType());
			ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS) csConstraint.getMessageSpecification();
			if (csMessageSpecification != null) {
				context.reusePivotElement(csMessageSpecification, pivotSpecification);
				ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
				if (csMessageExpression != null) {
					OclExpression messageExpression = context.visitLeft2Right(OclExpression.class, csMessageExpression);		
					pivotSpecification.setMessageExpression(messageExpression);
				}
			}
//			NamedElement pivotObject = PivotUtil.getPivot(NamedElement.class, contextDecl);
//			if (pivotObject != null) {
//				pivotObject.getOwnedRules().add(pivotConstraint);
//			}
		}
		return pivotConstraint;
	}

	@Override
	public MonikeredElement visitDefCS(DefCS csDef) {
		Operation contextOperation = PivotUtil.getPivot(Operation.class, csDef);
		ExpSpecificationCS csSpecification = (ExpSpecificationCS) csDef.getSpecification();
		ExpCS csExpression = csSpecification.getOwnedExpression();
		Constraint pivotConstraint = context.refreshMonikeredElement(Constraint.class,
			PivotPackage.Literals.CONSTRAINT, csSpecification.getMoniker() + "xx");
		ExpressionInOcl pivotSpecification = context.refreshMonikeredElement(ExpressionInOcl.class,
			PivotPackage.Literals.EXPRESSION_IN_OCL, csSpecification);
		context.installPivotElement(csSpecification, pivotSpecification);
		pivotConstraint.setSpecification(pivotSpecification);
		pivotConstraint.setStereotype(UMLReflection.BODY);

		Variable contextVariable = pivotSpecification.getContextVariable();
		if (contextVariable == null) {
			contextVariable = PivotFactory.eINSTANCE.createVariable();
			pivotSpecification.setContextVariable(contextVariable);
		}
		String selfVariableName = Environment.SELF_VARIABLE_NAME;
		context.setType(contextVariable, contextOperation.getClass_());
        pivotSpecification.getParameterVariables().clear();
        for (Parameter parameter : contextOperation.getOwnedParameters()) {
	        Variable param = PivotFactory.eINSTANCE.createVariable();
	        param.setName(parameter.getName());
	        param.setType(parameter.getType());
	        param.setRepresentedParameter(parameter);
	        pivotSpecification.getParameterVariables().add(param);
        }
/*	       if (csConstraint instanceof PostCS) {
			Variable resultVariable = pivotSpecification.getResultVariable();
			if (resultVariable == null) {
				resultVariable = PivotFactory.eINSTANCE.createVariable();
			}
			resultVariable.setName(Environment.RESULT_VARIABLE_NAME);
			resultVariable.setType(contextOperation.getType());
			pivotSpecification.setResultVariable(resultVariable);
	       } */
		context.refreshName(contextVariable, selfVariableName);
		OclExpression bodyExpression = context.visitLeft2Right(OclExpression.class, csExpression);		
		pivotSpecification.setBodyExpression(bodyExpression);
		contextOperation.getOwnedRules().add(pivotConstraint);
		return contextOperation;
	}
}