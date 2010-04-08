/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: OCLUnparser.java,v 1.2 2010/04/08 06:26:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.ocl.unparser;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.utilities.ExpressionInOCL;

// FIXME This functionality is incomplete

public class OCLUnparser extends OCLExpressionUnparser
{
	public static class DummyEcoreEnvironment extends EcoreEnvironment
	{
		public DummyEcoreEnvironment() {
			super((EPackage.Registry)null);
		}		
	}
	
	public OCLUnparser(Resource resource) {
		super(resource, new DummyEcoreEnvironment().getUMLReflection());
	}

	@Override protected String formatQualifiedName(Object object) {
		if (object instanceof PrimitiveType)
			return super.formatName(object);
		else
			return super.formatQualifiedName(object);
	}

	@Override public void unparse() {
		initialize();
		boolean first = true;
		for (EObject eObject : resource.getContents()) {
			if (!first)
				append("\n");
			if (eObject instanceof Constraint)
				unparseConstraint((Constraint) eObject);
			else
				unparseUnsupported(eObject);
			first = false;
		}
	}

	protected void unparseConstraint(Constraint constraint) {
		if (constraint == null)
			return;
		append("\ncontext");
		for (EModelElement constrainedElement : constraint.getConstrainedElements()) {
			append(" ");
			if (constrainedElement instanceof EStructuralFeature) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature) constrainedElement;
				appendQualifiedName(eStructuralFeature.getEContainingClass());
				append("::");
				appendName(eStructuralFeature);
				append(" : ");
				appendQualifiedName(eStructuralFeature.getEType());
			}
			else if (constrainedElement instanceof EOperation) {
				EOperation eOperation = (EOperation) constrainedElement;
				appendQualifiedName(eOperation.getEContainingClass());
				append("::");
				appendName(eOperation);
				append("(");
				boolean isFirst = true;
				for (EParameter eParameter : eOperation.getEParameters()) {
					if (!isFirst)
						append(", ");
					appendName(eParameter);
					EClassifier parameterType = eParameter.getEType();
					if (parameterType != null) {
						append(" : ");
						appendQualifiedName(eParameter.getEType());
					}
					isFirst = false;
				}
				append(")");
				EClassifier returnType = eOperation.getEType();
				append(" : ");
				if (returnType != null)
					appendQualifiedName(returnType);
			}
			else if (constrainedElement instanceof EClass) {
				appendQualifiedName(constrainedElement);
			}
			else
				appendQualifiedName(constrainedElement);
		}
		append("\n");
		String stereotype = constraint.getStereotype();
		if ("body".equals(stereotype))
			unparseKeyedExpression(constraint, "body");
		else if ("definition".equals(stereotype))
			unparseDefinition(constraint);
		else if ("derivation".equals(stereotype))
			unparseDerivation(constraint);
		else if ("initial".equals(stereotype))
			unparseInitial(constraint);
		else if ("invariant".equals(stereotype))
			unparseKeyedExpression(constraint, "inv");
		else if ("postcondition".equals(stereotype))
			unparseKeyedExpression(constraint, "post");
		else if ("precondition".equals(stereotype))
			unparseKeyedExpression(constraint, "pre");
		else
			append("***" + getClass().getSimpleName() + "-Unsupported-" + constraint.getClass().getSimpleName() + " " + stereotype + " ***\n");
			
	}
	
	protected void unparseDefinition(Constraint constraint) {
		ExpressionInOCL<EClassifier, EParameter> specification = constraint.getSpecification();
		if (specification == null)
			return;
		append("def");
		String name = constraint.getName();
		if (name != null) {
			append(" ");
			append(name);
		}
		append(": ");
		doExpressionSwitch(specification.getBodyExpression());
	}
	
	protected void unparseDerivation(Constraint constraint) {
		ExpressionInOCL<EClassifier, EParameter> specification = constraint.getSpecification();
		if (specification == null)
			return;
		append("derive: ");
		doExpressionSwitch(specification.getBodyExpression());
	}
	
	protected void unparseInitial(Constraint constraint) {
		ExpressionInOCL<EClassifier, EParameter> specification = constraint.getSpecification();
		if (specification == null)
			return;
		append("init: ");
		doExpressionSwitch(specification.getBodyExpression());
	}
	
	protected void unparseKeyedExpression(Constraint constraint, String keyword) {
		ExpressionInOCL<EClassifier, EParameter> specification = constraint.getSpecification();
		if (specification == null)
			return;
		append(keyword);
		String name = constraint.getName();
		if (name != null) {
			append(" ");
			append(name);
		}
		append(": ");
		doExpressionSwitch(specification.getBodyExpression());
	}
}
