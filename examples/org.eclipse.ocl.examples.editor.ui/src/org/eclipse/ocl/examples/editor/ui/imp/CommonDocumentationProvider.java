/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonDocumentationProvider.java,v 1.1 2010/03/11 14:51:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IDocumentationProvider;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.expressions.LiteralExp;

public abstract class CommonDocumentationProvider implements IDocumentationProvider, ILanguageService
{
	public static String getSubstring(IParseResult parseResult, CSTNode cstNode) {
		return parseResult.getTextRange(cstNode.getStartOffset(), cstNode.getEndOffset() - cstNode.getStartOffset() + 1);
	}

	protected String getASTDocumentation(Object node) {
		if (node instanceof LiteralExp<?>) {
			return EcoreUtils.simpleNameFor(((EObject)node).eClass()) + " : " + node.toString();
		}
		else if (node instanceof EObject) {
			return EcoreUtils.simpleNameFor(((EObject)node).eClass()) + " : " + EcoreUtils.qualifiedNameFor(node);
		}
		return null;
	}

	protected String getCSTDocumentation(CSTNode cstNode, ICommonParseResult parseResult) {
		ICommonParseController.TokenKind tokenKind = parseResult.getParseController().getTokenKind(getTokenKindForNode(cstNode));
		switch (tokenKind) {
		case IDENTIFIER:
			return "'" + getSubstring(parseResult, cstNode) + "' is an identifier";
		case INTEGER:
			return "'" + getSubstring(parseResult, cstNode) + "' is an integer number";
		case REAL:
			return "'" + getSubstring(parseResult, cstNode) + "' is a floating point number";
		case KEYWORD:
			return "'" + getSubstring(parseResult, cstNode) + "' is a keyword";
		case LINE_COMMENT:
			return "'" + getSubstring(parseResult, cstNode) + "' is a line comment";
		case PARAGRAPH_COMMENT:
			return "'" + getSubstring(parseResult, cstNode) + "' is a paragraph comment";
		case STRING:
			return "'" + getSubstring(parseResult, cstNode) + "' is a string";
		default:
			//return "No documentation available for token kind = " + tokenKind;
			return null;
		}
	}

	public String getDocumentation(Object node, IParseController controller) {
		if (node == null)
			return null;
		if (node instanceof CSTNode) {
			ICommonParseResult parseResult = ((CommonParseController)controller).getCurrentResult();
			if (parseResult == null)
				return null;
			return getCSTDocumentation((CSTNode)node, parseResult);
		}
		return getASTDocumentation(node);
	}

	public int getTokenKindForNode(CSTNode node) {
		// If you want some token for a node
		// other than the right token, compute
		// that here ...
		return node.getEndToken().getKind();
	}
}
