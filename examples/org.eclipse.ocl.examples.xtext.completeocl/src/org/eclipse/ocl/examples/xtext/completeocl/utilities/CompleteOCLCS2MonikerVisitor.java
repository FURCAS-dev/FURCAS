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
 * $Id: CompleteOCLCS2MonikerVisitor.java,v 1.9 2011/03/14 10:19:42 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.utilities;

import java.util.List;

import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2Moniker;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextSpecificationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCS2MonikerVisitor;

public class CompleteOCLCS2MonikerVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<Boolean, CS2Moniker, EssentialOCLCSVisitor<Boolean, CS2Moniker>>
	implements PivotConstants
{	
	private static final class Factory implements CS2Moniker.Factory
	{
		private Factory() {
			EssentialOCLCS2MonikerVisitor.FACTORY.getClass();
			CS2Moniker.addFactory(CompleteOCLCSTPackage.eINSTANCE, this);
//			roleNames.put(CompleteOCLCSTPackage.Literals.LIB_CONSTRAINT_CS__OWNED_EXPRESSION, "z");
		}
		
		public BaseCSVisitor<?, ?> create(CS2Moniker context) {
			return new CompleteOCLCS2MonikerVisitor(context);
		}
	}

	public static CS2Moniker.Factory FACTORY = new Factory();

	public static String getStereotype(String stereotype) {
		if (stereotype == null) {
			return null;
		}
		else if (stereotype.equals("body")) {
			return UMLReflection.BODY;
		}
		else if (stereotype.equals("def")) {
			return UMLReflection.DEFINITION;
		}
		else if (stereotype.equals("derive")) {
			return UMLReflection.DERIVATION;
		}
		else if (stereotype.equals("init")) {
			return UMLReflection.INITIAL;
		}
		else if (stereotype.equals("inv")) {
			return UMLReflection.INVARIANT;
		}
		else if (stereotype.equals("pre")) {
			return UMLReflection.PRECONDITION;
		}
		else if (stereotype.equals("post")) {
			return UMLReflection.POSTCONDITION;
		}
		else {
			return stereotype;
		}
	}
		
	@SuppressWarnings("unchecked")
	public CompleteOCLCS2MonikerVisitor(CS2Moniker context) {
		super((EssentialOCLCSVisitor<Boolean, CS2Moniker>) context.getVisitor(EssentialOCLCSTPackage.eINSTANCE), context);
	}

	protected void appendParametersCS(List<VariableCS> csParameters) {
		context.append(PARAMETER_PREFIX);
		String prefix = ""; //$NON-NLS-1$
		for (VariableCS csParameter : csParameters) {
			context.append(prefix);
			context.appendElementCS(csParameter.getOwnedType());
			prefix = PARAMETER_SEPARATOR;
		}
		context.append(PARAMETER_SUFFIX);
	}

	@Override
	public Boolean visitClassifierContextDeclCS(ClassifierContextDeclCS object) {
		context.append(object.getClassifier().getMoniker());
		return true;
	}

	@Override
	public Boolean visitContextConstraintCS(ContextConstraintCS object) {
		throw new IllegalStateException("Context Constraint moniker should be defined on creation");
//		context.appendElement(object.getContextDecl().getPivot());
//		context.append(MONIKER_SCOPE_SEPARATOR);
//		context.append(getStereotype(object.getStereotype()));
//		context.appendConstraintCSDisambiguator(object);
//		return true;
	}

	@Override
	public Boolean visitContextSpecificationCS(ContextSpecificationCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		if (object.eContainer() instanceof InvCS) {
			InvCS csInv = (InvCS)object.eContainer();
			if (object == csInv.getMessageSpecification()) {
//				context.append("message");		// FIXME This and ContextSpecificationCS are a fudge 
//				context.append(MONIKER_OPERATOR_SEPARATOR);
//				context.append(MONIKER_SCOPE_SEPARATOR);
			}
		}
		else if (object.eContainer() instanceof DefCS) {
			context.append(UMLReflection.BODY);		// FIXME This and ContextSpecificationCS are a fudge 
			context.append(MONIKER_OPERATOR_SEPARATOR);
			context.append(MONIKER_SCOPE_SEPARATOR);
		}
		context.append(PivotPackage.Literals.CONSTRAINT__SPECIFICATION.getName());
		return true;
	}

	@Override
	public Boolean visitDefCS(DefCS object) {
		context.appendElement(object.getContextDecl().getPivot());
		context.append(MONIKER_SCOPE_SEPARATOR);
		context.append(object.getConstrainedName());
		if (object.isOperation()) {
			appendParametersCS(object.getParameters());
		}
		return true;
	}

	@Override
	public Boolean visitOperationContextDeclCS(OperationContextDeclCS object) {
		context.append(object.getOperation().getMoniker());
		return true;
	}

	@Override
	public Boolean visitPackageDeclarationCS(PackageDeclarationCS object) {
		context.append(object.getPackage().getMoniker());
		return true;
	}

	@Override
	public Boolean visitPropertyContextDeclCS(PropertyContextDeclCS object) {
		context.append(object.getProperty().getMoniker());
		return true;
	}
}
