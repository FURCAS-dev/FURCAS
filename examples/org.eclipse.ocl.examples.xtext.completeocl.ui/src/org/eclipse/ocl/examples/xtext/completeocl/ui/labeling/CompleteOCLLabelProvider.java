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
 * $Id: CompleteOCLLabelProvider.java,v 1.5 2010/05/17 09:17:59 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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

	public String text(CompleteOCLDocumentCS ele) {
		return "Complete OCL document";
	}

	protected String image(ClassifierContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Class.gif";
	}

	protected String image(DefCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/DefinitionCondition.gif";
	}

	protected String image(DerCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/DerivationCondition.gif";
	}

	protected String image(InitCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/InitialCondition.gif";
	}

	protected String image(InvCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/InvariantCondition.gif";
	}

	protected String image(OperationContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Operation.gif";
	}

	protected String image(PostCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/PostconditionCondition.gif";
	}

	protected String image(PreCS ele) {
		return "/org.eclipse.ocl.examples.xtext.oclinecore.ui/icons/full/obj16/PreconditionCondition.gif";
	}

	protected String image(PackageDeclarationCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif";
	}

	protected String image(PropertyContextDeclCS ele) {
		return "/org.eclipse.uml2.uml.edit/icons/full/obj16/Property.gif";
	}
}
