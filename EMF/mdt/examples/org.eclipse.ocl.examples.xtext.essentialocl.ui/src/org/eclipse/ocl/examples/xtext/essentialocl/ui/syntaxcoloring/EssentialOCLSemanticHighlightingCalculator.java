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
 * $Id: EssentialOCLSemanticHighlightingCalculator.java,v 1.2 2011/01/24 21:30:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class EssentialOCLSemanticHighlightingCalculator implements ISemanticHighlightingCalculator
{
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null)
			return;
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		for (INode abstractNode : rootNode.getAsTreeIterable()) {
			if (abstractNode.getGrammarElement() instanceof CrossReference) {
				acceptor.addPosition(abstractNode.getOffset(), abstractNode.getLength(),
					EssentialOCLHighlightingConfiguration.CROSS_REF);
			}
		}
	}
}
