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
 * $Id: EssentialOCLLabelProvider.java,v 1.2 2010/05/17 09:18:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.labeling.BaseLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for EssentialOCL objects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class EssentialOCLLabelProvider extends BaseLabelProvider
{
	@Inject
	public EssentialOCLLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	protected String image(BooleanLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/BooleanLiteralExp.gif";
	}

	protected String image(CollectionLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralExp.gif";
	}

	protected String image(CollectionLiteralPartCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionLiteralPart.gif";
	}

	protected String image(CollectionTypeCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/CollectionType.gif";
	}

	protected String image(IfExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/IfExp.gif";
	}

	protected String image(LetExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/LetExp.gif";
	}

	protected String image(NameExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/VariableExp.gif";
	}

	protected String image(NumberLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/NumericLiteralExp.gif";
	}

	protected String image(PrimitiveTypeCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/PrimitiveType.gif";
	}

	protected String image(StringLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/StringLiteralExp.gif";
	}

	protected String image(TupleLiteralExpCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleLiteralExp.gif";
	}

	protected String image(TupleTypeCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/TupleType.gif";
	}

	protected String image(VariableCS ele) {
		return "/org.eclipse.ocl.edit/icons/full/obj16/Variable.gif";
	}
}
