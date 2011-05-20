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
 * $Id: EssentialOCLOutlineTreeProvider.java,v 1.5 2011/05/15 20:18:00 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.TextRegion;

/**
 * customization of the default outline structure
 * 
 */
public class EssentialOCLOutlineTreeProvider extends DefaultOutlineTreeProvider
{
	@Override
	protected EObjectNode createEObjectNode(IOutlineNode parentNode, EObject modelElement) {
		if (!(modelElement instanceof Element)) {
			return super.createEObjectNode(parentNode, modelElement);
		}
		Object text = textDispatcher.invoke(modelElement);
		Image image = imageDispatcher.invoke(modelElement);
		EObjectNode eObjectNode = new ElementNode(modelElement, parentNode, image, text, isLeafDispatcher.invoke(modelElement));
		ICompositeNode parserNode = NodeModelUtils.getNode(modelElement);
		if (parserNode != null)
			eObjectNode.setTextRegion(new TextRegion(parserNode.getOffset(), parserNode.getLength()));
		eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(modelElement));
		return eObjectNode;
	}
	
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
