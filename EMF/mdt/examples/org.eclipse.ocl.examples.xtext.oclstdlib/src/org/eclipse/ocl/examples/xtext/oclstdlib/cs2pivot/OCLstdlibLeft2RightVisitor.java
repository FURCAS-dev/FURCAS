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
 * $Id: OCLstdlibLeft2RightVisitor.java,v 1.5 2011/04/01 19:57:09 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;

public class OCLstdlibLeft2RightVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<MonikeredElement, CS2PivotConversion, EssentialOCLLeft2RightVisitor>
{
	public OCLstdlibLeft2RightVisitor(CS2PivotConversion context) {
		super(new EssentialOCLLeft2RightVisitor(context), context);
	}

	@Override
	public MonikeredElement visitLibConstraintCS(LibConstraintCS csConstraint) {
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
			context.putPivotElement(contextVariable);
			context.refreshName(contextVariable, Environment.SELF_VARIABLE_NAME);
			EObject eContainer = csConstraint.eContainer();
			if (eContainer instanceof TypeCS) {
				Type contextType = PivotUtil.getPivot(Type.class, (TypeCS)eContainer);
				context.setType(contextVariable, contextType);
			}
			else if (eContainer instanceof StructuralFeatureCS) {
				Property contextProperty = PivotUtil.getPivot(Property.class, (StructuralFeatureCS)eContainer);
				context.setType(contextVariable, contextProperty.getClass_());
			}
			else if (eContainer instanceof OperationCS) {
				Operation contextOperation = PivotUtil.getPivot(Operation.class, (OperationCS)eContainer);
				context.setType(contextVariable, contextOperation.getClass_());
				List<Variable> oldVariables = new ArrayList<Variable>(pivotSpecification.getParameterVariables());
				List<Variable> newVariables = new ArrayList<Variable>();
		        for (Parameter parameter : contextOperation.getOwnedParameters()) {
			        String name = parameter.getName();
					Variable param = PivotUtil.getNamedElement(oldVariables, name);
			        if (param != null) {
			        	oldVariables.remove(param);
			        }
			        else {
			        	param = PivotFactory.eINSTANCE.createVariable();
				        param.setName(name);
			        }
			        param.setType(parameter.getType());
			        param.setRepresentedParameter(parameter);
			        newVariables.add(param);
		        }
		        context.refreshList(pivotSpecification.getParameterVariables(), newVariables);
		        for (Variable parameterVariable : pivotSpecification.getParameterVariables()) {
					context.putPivotElement(parameterVariable);
		        }
		        if ("post".equals(csConstraint.getStereotype())) {		// FIXME constant
					Variable resultVariable = pivotSpecification.getResultVariable();
					if (resultVariable == null) {
						resultVariable = PivotFactory.eINSTANCE.createVariable();
					}
					resultVariable.setName(Environment.RESULT_VARIABLE_NAME);
					resultVariable.setType(contextOperation.getType());
					pivotSpecification.setResultVariable(resultVariable);
					context.putPivotElement(resultVariable);
		        }
			}
			
			
			OclExpression bodyExpression = context.visitLeft2Right(OclExpression.class, csExpression);		
			pivotSpecification.setBodyExpression(bodyExpression);
			ExpSpecificationCS csMessageSpecification = (ExpSpecificationCS) csConstraint.getMessageSpecification();
			if (csMessageSpecification != null) {
				ExpCS csMessageExpression = csMessageSpecification.getOwnedExpression();
				if (csMessageExpression != null) {
					OclExpression messageExpression = context.visitLeft2Right(OclExpression.class, csMessageExpression);		
					pivotSpecification.setMessageExpression(messageExpression);
				}
			}
		}
		return pivotConstraint;
	}

	@Override
	public MonikeredElement visitPrecedenceCS(PrecedenceCS object) {
		return null;
	}
}