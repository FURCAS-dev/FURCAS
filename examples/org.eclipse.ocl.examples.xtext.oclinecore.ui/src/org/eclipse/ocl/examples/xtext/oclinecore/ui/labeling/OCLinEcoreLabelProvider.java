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
 * $Id: OCLinEcoreLabelProvider.java,v 1.6 2011/02/16 08:43:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling.EssentialOCLLabelProvider;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;

import com.google.inject.Inject;

/**
 * Provides labels for OCLinEcoreCST objects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class OCLinEcoreLabelProvider extends EssentialOCLLabelProvider {

	@Inject
	public OCLinEcoreLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

/*	public String text(AnnotationCS ele) {
		StringBuffer s = new StringBuffer();
//		String idName = ele.getIdSource();
//		if (idName != null) {
//			appendString(s, idName);			
//		}
//		else {
			s.append("\"");
			appendString(s, ele.getName());			
			s.append("\"");
//		}
		return s.toString();
	} */

	@Override
	protected String image(Annotation ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAnnotation.gif";
	}

	@Override
	protected String image(org.eclipse.ocl.examples.pivot.Class ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EClass.gif";
	}

	protected String image(OCLinEcoreConstraintCS ele) {
		String stereotype = ele.getStereotype();
		if ("body".equals(stereotype)) {
			return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/DefinitionConstraint.gif";
		}
		else if ("derivation".equals(stereotype)) {
			return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/DerivationConstraint.gif";
		}
		else if ("initial".equals(stereotype)) {
			return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/InitialConstraint.gif";
		}
		else if ("invariant".equals(stereotype)) {
			return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/InvariantConstraint.gif";
		}
		else if ("postcondition".equals(stereotype)) {
			return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/PostconditionConstraint.gif";
		}
		else if ("precondition".equals(stereotype)) {
			return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/PreconditionConstraint.gif";
		}
		return "/org.eclipse.ocl.edit/icons/full/obj16/Constraint.gif";
	}

	public String text(OCLinEcoreConstraintCS ele) {
		StringBuffer s = new StringBuffer();
		s.append("<");
		appendString(s, ele.getStereotype());
		s.append("> ");
		appendOptionalName(s, ele);
		return s.toString();
	}

	protected String image(DataType ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EDataType.gif";
	}

//	protected String image(DetailCS ele) {
//		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EStringToStringMapEntry.gif";
//	}

//	public String text(DocumentationCS ele) {
//		return "documentation";
//	}

	protected String image(org.eclipse.ocl.examples.pivot.Enumeration ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EEnum.gif";
	}

	@Override
	protected String image(EnumerationLiteral ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EEnumLiteral.gif";
	}

	@Override
	protected String image(Operation ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EOperation.gif";
	}

	@Override
	protected String image(org.eclipse.ocl.examples.pivot.Package ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EPackage.gif";
	}

	@Override
	protected String image(Parameter ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EParameter.gif";
	}

	@Override
	protected String image(Property ele) {
		if (ele.getType() instanceof DataType) {
			return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAttribute.gif";
		}
		else {
			return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EReference.gif";
		}
	}

//	protected String image(ReferenceCSRef ele) {
//		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EReference.gif";
//	}

	public String text(RootPackageCS ele) {
		return "OCL in Ecore document";
	}

	@Override
	protected String image(TemplateParameter ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/ETypeParameter.gif";
	}

	protected String image(TypeRefCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EGenericType.gif";
	}
}
