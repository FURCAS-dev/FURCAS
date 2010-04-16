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
 * $Id: OCLinEcoreTransformer.java,v 1.2 2010/04/16 18:09:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.outline;

import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;

/**
 * customization of the default outline structure
 * 
 */
public class OCLinEcoreTransformer extends AbstractDeclarativeSemanticModelTransformer {
	  /**
	   * This method will be called by naming convention:
	   * - method name must be createNode
	   * - first param: subclass of EObject
	   * - second param: ContentOutlineNode 
	   *
	  public ContentOutlineNode createNode(
	      ClassifierCS semanticNode, ContentOutlineNode parentNode) {
	    ContentOutlineNode node = super.newOutlineNode(semanticNode, parentNode);
	    node.setLabel("special " + node.getLabel() + " " + semanticNode.eClass().getName());
	    return node;
	  } */
	
}
