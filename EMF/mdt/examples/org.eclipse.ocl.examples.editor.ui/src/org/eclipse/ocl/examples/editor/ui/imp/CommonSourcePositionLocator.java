/**
 * <copyright>
 * 
 * Copyright (c) 2009,2010 Eclipse Modeling Project and others.
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
 * $Id: CommonSourcePositionLocator.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import lpg.runtime.IToken;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.parser.utils.CommonASTVisitor;
import org.eclipse.ocl.lpg.BasicEnvironment;

/**
 * NOTE:  This version of the Node Locator is for use when the Node
 * Locator and corresponding Parse Controller are generated separately from
 * a corresponding set of LPG grammar templates and possibly in the absence
 * of the lexer, parser, and AST-related types that would be generated from
 * those templates.  To enable compilation of the Locator and Controller,
 * dummy types have been defined as member types of the Controller in place
 * of possibly missing lexer, parser, and AST-related types.  This version
 * of the Node Locator refers to some of those types.  When those types
 * are replaced by real implementation types, the Locator must be modified
 * to refer to those.  Apart from statements to import needed types from
 * the Parse Controller, this Node Locator is the same as that used with
 * LPG.
 * @see the corresponding ParseController type
 * 
 * @author Stan Sutton (suttons@us.ibm.com)
 * @since May 15, 2007
 * 
 */
public class CommonSourcePositionLocator implements ISourcePositionLocator
{
	protected final BasicEnvironment environment;
	private int fStartOffset;
	private int fEndOffset;

	protected final class ASTNodeVisitor<N> extends CommonASTVisitor<CSTNode, N>
	{
		protected ASTNodeVisitor(Class<N> nodeClass) {
			super(nodeClass);
		}

		@Override
		public boolean preVisit(N astNode) {
			CSTNode cstNode = environment.getASTMapping(astNode);
			if (cstNode == null)
				return true;
			int nodeStartOffset = cstNode.getStartOffset();
			int nodeEndOffset = cstNode.getEndOffset();
			if (OCLExamplesEditorPlugin.VISITOR_TRACE.isActive())
				OCLExamplesEditorPlugin.VISITOR_TRACE.println(getClass().getSimpleName() + ".preVisit(ASTNode):  Examining " + astNode.getClass().getName() +
			    " @ [" + nodeStartOffset + "->" + nodeEndOffset + ']');
			// If this node contains the span of interest then record it
			if ((nodeStartOffset <= fStartOffset) && (fEndOffset <= (nodeEndOffset+1))) {	// nodeEndOffset+1 is the RHS of the last character
				if (OCLExamplesEditorPlugin.VISITOR_TRACE.isActive())
					OCLExamplesEditorPlugin.VISITOR_TRACE.println(getClass().getSimpleName() + ".preVisit(ASTNode) SELECTED for offsets [" + fStartOffset + ".." + fEndOffset + "]");
				result = cstNode;
				return true; // to continue visiting here?
			}
			return false; // to stop visiting here?
		}
	}

	protected CommonSourcePositionLocator(BasicEnvironment environment) {
		this.environment = environment;
	}

	private ASTNodeVisitor<Notifier> astVisitor = new ASTNodeVisitor<Notifier>(Notifier.class);
	private ASTNodeVisitor<CSTNode> cstVisitor = new ASTNodeVisitor<CSTNode>(CSTNode.class);

	public Object findNode(Object node, int offset) {
		return findNode(node, offset, offset);
	}

	public Object findNode(Object node, int startOffset, int endOffset) {
		if (node instanceof ICommonParseResult)
			node = ((ICommonParseResult) node).getCST();
		if (node instanceof CSTNode)
			return findCSTNode((CSTNode)node, startOffset, endOffset);
		else if (node instanceof Notifier)
			return findASTNode((Notifier)node, startOffset, endOffset);		// FIXME AST is very disjoint so this is suspect
		else
			return null;
	}

	public Notifier findASTNode(Notifier ast, int startOffset, int endOffset) {
		// System.out.println("Looking for node spanning offsets " + startOffset + " => " + endOffset);
		fStartOffset = startOffset;
		fEndOffset = endOffset;
		// ????The following could be treated as an IASTNodeToken, but ASTNode
		// is required for the visit/preVisit method, and there's no reason
		// to use both of those types
		Notifier astNode = astVisitor.enter(ast);
		if (OCLExamplesEditorPlugin.VISITOR_SELECTION.isActive()) {
			if (astNode == null)
				OCLExamplesEditorPlugin.VISITOR_SELECTION.println("Selected node:  null");
			else {
				CSTNode cstNode = environment.getASTMapping(astNode);
				OCLExamplesEditorPlugin.VISITOR_SELECTION.println("Selected node: " + cstNode + " [" +
					cstNode.getStartOffset() + ".." + cstNode.getEndOffset() + "]");

			}
		}
		return astNode;
	}

	public CSTNode findCSTNode(CSTNode cst, int startOffset, int endOffset) {
		// System.out.println("Looking for node spanning offsets " + startOffset + " => " + endOffset);
		fStartOffset = startOffset;
		fEndOffset = endOffset;
		// ????The following could be treated as an IASTNodeToken, but ASTNode
		// is required for the visit/preVisit method, and there's no reason
		// to use both of those types
		CSTNode cstNode = cstVisitor.enter(cst);
		if (OCLExamplesEditorPlugin.VISITOR_SELECTION.isActive()) {
			if (cstNode == null)
				OCLExamplesEditorPlugin.VISITOR_SELECTION.println("Selected node:  null");
			else
				OCLExamplesEditorPlugin.VISITOR_SELECTION.println("Selected node: " + cstNode + " [" +
					cstNode.getStartOffset() + ".." + cstNode.getEndOffset() + "]");
		}
		return cstNode;
	}

	public int getEndOffset(Object node) {
		if (node instanceof ICommonParseResult)
			node = ((ICommonParseResult) node).getCST();
		if (node instanceof CSTNode) {
			CSTNode n = (CSTNode) node;
			return n.getEndOffset();
		} else if (node instanceof Notifier) {
			CSTNode cstNode = environment.getASTMapping(node);
			return cstNode != null ? cstNode.getEndOffset() : 0;
		} else if (node instanceof IToken) {
			IToken t = (IToken) node;
			return t.getEndOffset();
		}
		return 0;
	}

	public int getLength(Object node) {
		return getEndOffset(node) - getStartOffset(node);
	}

	public IPath getPath(Object node) {
		// TODO Determine path of compilation unit containing this node
		return new Path("");
	}

	public int getStartOffset(Object node) {
		if (node instanceof ICommonParseResult)
			node = ((ICommonParseResult) node).getCST();
		if (node instanceof CSTNode) {
			CSTNode n = (CSTNode) node;
			return n.getStartOffset();
		} else if (node instanceof Notifier) {
			CSTNode cstNode = environment.getASTMapping(node);
			return cstNode != null ? cstNode.getStartOffset() : 0;
		} else if (node instanceof IToken) {
			IToken t = (IToken) node;
			return t.getStartOffset();
		}
		return 0;
	}
}
