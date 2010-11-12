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
 * $Id: CompleteOCLTransformer.java,v 1.3 2010/05/22 19:02:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.outline.EssentialOCLTransformer;

/**
 * customization of the default outline structure
 * 
 */
public class CompleteOCLTransformer extends EssentialOCLTransformer
{	
	public List<EObject> getChildren(ClassifierContextDeclCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getDefs());
		addContents(contents, csElement.getInvs());
		return contents;
	}

	public List<EObject> getChildren(CompleteOCLDocumentCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getImports());
		addContents(contents, csElement.getLibraries());
		addContents(contents, csElement.getPackages());
		addContents(contents, csElement.getAnnotations());
		return contents;
	}

	public List<EObject> getChildren(DefCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContent(contents, csElement.getExpression());
		return contents;
	}
	
	public List<EObject> getChildren(OperationContextDeclCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
//		addContents(contents, csElement.getParameters());
		addContents(contents, csElement.getPres());
		addContents(contents, csElement.getBodies());
		addContents(contents, csElement.getPosts());
		return contents;
	}

	public List<EObject> getChildren(PackageDeclarationCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getContexts());
		return contents;
	}
	
	public List<EObject> getChildren(PropertyContextDeclCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContent(contents, csElement.getInit());
		addContent(contents, csElement.getDer());
		return contents;
	}
}
