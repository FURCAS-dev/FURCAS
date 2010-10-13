/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/**
 * This file is generated for MOIN-MQL with LPG. 
 */

package org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst;

import org.eclipse.emf.query2.internal.moinql.parser.CstNode;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;


public abstract class Node implements CstNode {
	protected IToken leftIToken, rightIToken;

	public IToken getLeftIToken() {
		return leftIToken;
	}

	public IToken getRightIToken() {
		return rightIToken;
	}

	public IToken[] getPrecedingAdjuncts() {
		return leftIToken.getPrecedingAdjuncts();
	}

	public IToken[] getFollowingAdjuncts() {
		return rightIToken.getPrecedingAdjuncts();
	}

	public String toString() {
		PrsStream prsStream = leftIToken.getPrsStream();
		return new String(prsStream.getInputChars(), leftIToken.getStartOffset(), rightIToken.getEndOffset() - leftIToken.getStartOffset()
				+ 1);
	}

	public Node(IToken token) {
		this.leftIToken = this.rightIToken = token;
	}

	public Node(IToken leftIToken, IToken rightIToken) {
		this.leftIToken = leftIToken;
		this.rightIToken = rightIToken;
	}

	public void initialize() {
	}

	/**
	 * Since the Ast type has no children, any two instances of it are equal.
	 */
	public abstract void accept(MqlAstVisitor v);

	public int getStartOffset() {
		return getLeftIToken().getStartOffset();
	}

	public int getLine() {
		return getLeftIToken().getLine();
	}

	public int getColumn() {
		return getLeftIToken().getColumn();
	}

	public int getEndOffset() {
		return getRightIToken().getEndOffset();
	}

	public int getEndLine() {
		return getRightIToken().getEndLine();
	}

	public int getEndColumn() {
		return getRightIToken().getEndColumn();
	}
}
