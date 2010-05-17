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
 * $Id: CompleteOCLTransformer.java,v 1.2 2010/05/17 09:18:00 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.outline.EssentialOCLTransformer;

/**
 * customization of the default outline structure
 * 
 */
public class CompleteOCLTransformer extends EssentialOCLTransformer
{
	public List<EObject> getChildren(CompleteOCLDocumentCS csDocument) {
		List<EObject> contents = new ArrayList<EObject>();
		contents.addAll(csDocument.getImports());
		contents.addAll(csDocument.getLibraries());
		contents.addAll(csDocument.getPackages());
		contents.addAll(csDocument.getAnnotations());
		return contents;
	}
}
