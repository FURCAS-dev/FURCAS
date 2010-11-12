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
 * $Id: BaseTransformer.java,v 1.2 2010/05/22 19:02:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.xtext.ui.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;

/**
 * customization of the default outline structure
 * 
 */
public class BaseTransformer extends AbstractDeclarativeSemanticModelTransformer
{
	protected void addContent(List<EObject> contents, ElementCS csElement) {
		if (csElement != null)
			contents.add(csElement);
	}

	protected void addContents(List<EObject> contents, List<? extends ElementCS> csElements) {
		contents.addAll(csElements);
	}

	public List<EObject> getChildren(OperationCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getTypeParameters());
		addContents(contents, csElement.getParameters());
		addContents(contents, csElement.getAnnotations());
		return contents;
	}

	public List<EObject> getChildren(ParameterCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getAnnotations());
		return contents;
	}

	public List<EObject> getChildren(StructuralFeatureCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getAnnotations());
		return contents;
	}
}
