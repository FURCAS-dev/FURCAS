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
 * $Id: CompleteOCLLabelProvider.java,v 1.9 2011/05/02 09:31:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.labeling;

import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling.EssentialOCLLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for CompleteOCLCST objects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class CompleteOCLLabelProvider extends EssentialOCLLabelProvider
{
	@Inject
	public CompleteOCLLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(BodyCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/DefinitionConstraint.gif";
	}

	protected String text(BodyCS ele) {
		String name = ele.getName();
		return name != null ? "body " + name : "body";
	}

	protected String image(ClassifierContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Class.gif";
	}

	protected String text(ClassifierContextDeclCS ele) {
		return ele.getClassifier().getName();
	}

	protected String text(CompleteOCLDocumentCS ele) {
		return "Complete OCL document";
	}

	protected String image(DefCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/DefinitionConstraint.gif";
	}

	protected String text(DefCS ele) {
		StringBuffer s = new StringBuffer();
		s.append("def ");
		appendOptionalString(s, ele.getName());
		s.append(": ");
		appendString(s, ele.getConstrainedName());
		List<VariableCS> parameters = ele.getParameters();
		if (!parameters.isEmpty()) {
			s.append("(");
			String prefix = "";
			for (VariableCS csVariable : parameters) {
				s.append(prefix);
//				appendName(s, csVariable);
//				s.append(" : ");
				appendType(s, csVariable.getOwnedType());
				prefix = ", ";
			}
			s.append(")");
		}
		s.append(" : ");
		appendType(s, ele.getOwnedType());
		return s.toString();
	}

	protected String image(DerCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/DerivationConstraint.gif";
	}

	protected String text(DerCS ele) {
		return "derive";
	}

	protected String image(InitCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/InitialConstraint.gif";
	}

	protected String text(InitCS ele) {
		return "init";
	}

	protected String image(InvCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/InvariantConstraint.gif";
	}

	protected String text(InvCS ele) {
		String name = ele.getName();
		return name != null ? "inv " + name : "inv";
	}

	protected String image(OperationContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Operation.gif";
	}

	protected String text(OperationContextDeclCS ele) {
		StringBuffer s = new StringBuffer();
		Operation operation = ele.getOperation();
		appendName(s, PivotUtil.getFeaturingClass(operation));
		s.append("::");
		appendName(s, operation);
		s.append("(");
		String prefix = "";
		for (Parameter parameter : operation.getOwnedParameters()) {
			s.append(prefix);
//			appendName(s, csParameter);
//			s.append(" : ");
			appendType(s, parameter.getType());
			prefix = ", ";
		}
		s.append(")");
		s.append(" : ");
		appendType(s, operation.getType());
		return s.toString();
	}

	protected String image(PackageDeclarationCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif";
	}

	protected String text(PackageDeclarationCS ele) {
		return safeGetMoniker(ele.getPackage());
	}

	protected String image(PostCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/PostconditionConstraint.gif";
	}

	protected String text(PostCS ele) {
		String name = ele.getName();
		return name != null ? "post " + name : "post";
	}

	protected String image(PreCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/PreconditionConstraint.gif";
	}

	protected String text(PreCS ele) {
		String name = ele.getName();
		return name != null ? "pre " + name : "pre";
	}

	protected String image(PropertyContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}

	protected String text(PropertyContextDeclCS ele) {
		StringBuffer s = new StringBuffer();
		Property feature = ele.getProperty();
		appendName(s, PivotUtil.getFeaturingClass(feature));
		s.append("::");
		appendName(s, feature);
		s.append(" : ");
		appendType(s, feature.getType());
		return s.toString();
	}
}
