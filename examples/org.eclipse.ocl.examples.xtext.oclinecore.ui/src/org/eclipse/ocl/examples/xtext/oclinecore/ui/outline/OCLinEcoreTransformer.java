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
 * $Id: OCLinEcoreTransformer.java,v 1.5 2010/05/22 19:02:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.outline.EssentialOCLTransformer;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS;

/**
 * customization of the default outline structure
 * 
 */
public class OCLinEcoreTransformer extends EssentialOCLTransformer
{
	public List<EObject> getChildren(OCLinEcoreClassCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getTypeParameters());
		addContents(contents, csElement.getSuperTypes());
		addContents(contents, csElement.getOperations());
		addContents(contents, csElement.getStructuralFeatures());
		addContents(contents, csElement.getConstraints());
		addContents(contents, csElement.getAnnotations());
		return contents;
	}

	public List<EObject> getChildren(OCLinEcoreClassifierCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getTypeParameters());
		addContents(contents, csElement.getConstraints());
		addContents(contents, csElement.getAnnotations());
		return contents;
	}

	public List<EObject> getChildren(OCLinEcoreDocumentCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getImports());
		addContents(contents, csElement.getLibraries());
		addContents(contents, csElement.getPackages());
		addContents(contents, csElement.getAnnotations());
		return contents;
	}

	public List<EObject> getChildren(OCLinEcoreOperationCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getTypeParameters());
		addContents(contents, csElement.getParameters());
		addContents(contents, csElement.getConstraints());
		addContents(contents, csElement.getAnnotations());
		return contents;
	}

	public List<EObject> getChildren(OCLinEcoreStructuralFeatureCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getConstraints());
		addContents(contents, csElement.getAnnotations());
		return contents;
	}
}
