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
 * $Id: OCLinEcoreLeft2RightVisitor.java,v 1.5 2011/02/08 17:43:41 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.util.AbstractExtendingDelegatingOCLinEcoreCSVisitor;

public class OCLinEcoreLeft2RightVisitor
	extends AbstractExtendingDelegatingOCLinEcoreCSVisitor<MonikeredElement, CS2PivotConversion, EssentialOCLLeft2RightVisitor>
{
	public OCLinEcoreLeft2RightVisitor(CS2PivotConversion context) {
		super(new EssentialOCLLeft2RightVisitor(context), context);
	}

	@Override
	public MonikeredElement visitOCLinEcoreConstraintCS(OCLinEcoreConstraintCS csConstraint) {
		Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csConstraint);
		ExpressionInOcl pivotElement = context.refreshMonikeredElement(ExpressionInOcl.class,
			PivotPackage.Literals.EXPRESSION_IN_OCL, csConstraint.getMoniker() + "/xyzzy");
		pivotConstraint.setSpecification(pivotElement);
		Variable contextVariable = pivotElement.getContextVariable();
		if (contextVariable == null) {
			contextVariable = PivotFactory.eINSTANCE.createVariable();
			pivotElement.setContextVariable(contextVariable);
		}
		EObject eContainer = csConstraint.eContainer();
		if (eContainer instanceof FeatureCS) {
			Feature contextFeature = PivotUtil.getPivot(Feature.class, (FeatureCS)eContainer);
			context.setType(contextVariable, PivotUtil.getFeaturingClass(contextFeature));
		}
//		if (eContainer instanceof OperationCS) {
//			Operation contextOperation = PivotUtil.getPivot(Operation.class, (OperationCS)eContainer);
//			context.setType(contextVariable, contextOperation.getClass_());
//		}
//		else if (eContainer instanceof StructuralFeatureCS) {
//			Property contextProperty = PivotUtil.getPivot(Property.class, (StructuralFeatureCS)eContainer);
//			context.setType(contextVariable, contextProperty.getClass_());
//		}
		else if (eContainer instanceof TypeCS) {
			Type contextType = PivotUtil.getPivot(Type.class, (TypeCS)eContainer);
			context.setType(contextVariable, contextType);
		}
//		if (resource instanceof EvaluationContext) {			
//			PivotEnvironment environment = ((EvaluationContext)resource).getEnvironment();
//			if (environment != null) {
//				Type contextType = environment.getContextClassifier();
//				Feature contextFeature = ((EvaluationContext)resource).getContextFeature();
//				context.setType(contextVariable, contextType);
//			}
//		}
		context.refreshName(contextVariable, Environment.SELF_VARIABLE_NAME);
		context.putPivotElement(contextVariable);
				
		ExpCS csExpression = csConstraint.getOwnedExpression();
		OclExpression expression = context.refreshExpTree(OclExpression.class, csExpression);
		if (expression != null) {
			pivotElement.setBodyExpression(expression);
			context.setType(pivotElement, expression.getType());
		}
		return pivotElement;
	}
}