/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: EssentialOCLOutlineTreeProvider.java,v 1.4 2011/02/17 17:48:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.outline;

import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

/**
 * customization of the default outline structure
 * 
 */
public class EssentialOCLOutlineTreeProvider extends DefaultOutlineTreeProvider
{
	protected void _createChildren(IOutlineNode parentNode, Constraint constraint) {
		createChildren(parentNode, constraint.getSpecification());
	}

	protected void _createNode(IOutlineNode parentNode, CollectionItem collectionItem) {
		createNode(parentNode, collectionItem.getItem());
	}

	protected void _createNode(IOutlineNode parentNode, TemplateParameter templateParameter) {
		createNode(parentNode, templateParameter.getParameteredElement());
	}

	protected void _createNode(IOutlineNode parentNode, TemplateSignature templateSignature) {
		createChildren(parentNode, templateSignature);
	}
}
