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
 * $Id: OCLinEcoreLabelProvider.java,v 1.2 2010/05/17 09:18:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.labeling;

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
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl;

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

	protected String image(ConstraintCSImpl ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/Constraint.gif";
	}

	protected String image(DataTypeCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EDataType.gif";
	}

	protected String image(DetailCS ele) {
		return "/org.eclipse.emf.ecore.edit/icons/full/obj16/EStringToStringMapEntry.gif";
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
