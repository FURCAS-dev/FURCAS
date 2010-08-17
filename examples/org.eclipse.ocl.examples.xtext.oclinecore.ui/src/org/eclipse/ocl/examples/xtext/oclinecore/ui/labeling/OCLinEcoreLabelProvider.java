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
 * $Id: OCLinEcoreLabelProvider.java,v 1.4 2010/08/17 18:52:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.labeling;

import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling.EssentialOCLLabelProvider;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;

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

	public String text(AnnotationCS ele) {
		StringBuffer s = new StringBuffer();
		String idName = ele.getIdSource();
		if (idName != null) {
			appendString(s, idName);			
		}
		else {
			s.append("\"");
			appendString(s, ele.getStringSource());			
			s.append("\"");
		}
		return s.toString();
	}

	@Override
	protected String image(AnnotationElementCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAnnotation.gif";
	}

	protected String image(AttributeCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EAttribute.gif";
	}

	@Override
	protected String image(ClassifierCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EClass.gif";
	}

	protected String image(ConstraintCS ele) {
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

	public String text(ConstraintCS ele) {
		StringBuffer s = new StringBuffer();
		s.append("<");
		appendString(s, ele.getStereotype());
		s.append("> ");
		appendOptionalName(s, ele);
		return s.toString();
	}

	protected String image(DataTypeCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EDataType.gif";
	}

	protected String text(DataTypeOrEnumCS ele) {
		StringBuffer s = new StringBuffer();
		appendName(s, ele);
		List<TypeParameterCS> typeParameters = ele.getTypeParameters();
		if (!typeParameters.isEmpty()) {
			s.append("<");
			String prefix = "";
			for (TypeParameterCS typeParameter : typeParameters) {
				s.append(prefix);
				appendType(s, typeParameter);
				prefix = ", ";
			}
			s.append(">");
		}
		String instance = ele.getInstanceClassName();
		if (instance != null) {
			s.append(" [");
			s.append(instance);
			s.append("]");
		}
		return s.toString();
	}

	protected String image(DetailCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EStringToStringMapEntry.gif";
	}

	public String text(DetailCS ele) {
		StringBuffer s = new StringBuffer();
		String idName = ele.getIdName();
		if (idName != null) {
			appendString(s, idName);			
		}
		else {
			s.append("\"");
			appendString(s, ele.getStringName());			
			s.append("\"");
		}
		s.append(" : ");
		appendString(s, ele.getValue().get(0));
		return s.toString();
	}

	public String text(DocumentationCS ele) {
		return "documentation";
	}

	protected String image(EnumCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EEnum.gif";
	}

	@Override
	protected String image(EnumLiteralCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EEnumLiteral.gif";
	}

	@Override
	protected String image(OperationCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EOperation.gif";
	}

	@Override
	protected String image(PackageCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EPackage.gif";
	}

	@Override
	protected String image(ParameterCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EParameter.gif";
	}

	protected String image(ReferenceCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EReference.gif";
	}

	protected String image(ReferenceCSRef ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EReference.gif";
	}

	@Override
	protected String image(TypeParameterCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/ETypeParameter.gif";
	}

	protected String image(TypeRefCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EGenericType.gif";
	}

	public String text(OCLinEcoreDocumentCS ele) {
		return "OCL in Ecore document";
	}
}
