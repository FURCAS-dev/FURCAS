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
 * $Id: ICommonParseResult.java,v 1.1 2010/03/11 14:51:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseController.TokenKind;
import org.eclipse.ocl.lpg.AbstractParser;

/**
 * An ICommonParseResult extends IParseResult to support access to a parse
 * result that has distinct AST and CST representations.
 */
public interface ICommonParseResult extends IParseResult
{
	public Resource getAST();

	public Object getASTNode(Object node);

	public Object getASTorCSTNode(Object node);

	public CSTNode getCST();

	public CSTNode getCSTNode(Object node);

	public List<ICommonKeyword> getKeywords();

	public ICommonParseController getParseController();

	public AbstractParser getParser();

	public Collection<Resource> getResourcesVisibleAt(EObject node);

	public ISourcePositionLocator getSourcePositionLocator();

	public TokenKind getTokenKind(int kind);

	public boolean isCompleteable(int kind);

	public boolean isIdentifier(int kind);

	public boolean isKeyword(int kind);
}
