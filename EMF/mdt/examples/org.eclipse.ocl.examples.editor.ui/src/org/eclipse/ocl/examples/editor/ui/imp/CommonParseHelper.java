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
 * $Id: CommonParseHelper.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.lpg.AbstractParser;

/**
 * CommonParseHelper provides a cache of properties of the grammar. It is typically
 * created following a first parse and presumed to be unchanged for subsequent parses.
 * <p>
 * The cache comprises information as to which tokens are keywords.
 */
public class CommonParseHelper
{
	private List<ICommonKeyword> keywords = null;
    private String tokenKindNames[] = null;
    private boolean fIsKeyword[] = null;

    public CommonParseHelper(AbstractParser parser) {
		tokenKindNames = parser.orderedTerminalSymbols();
        fIsKeyword= new boolean[tokenKindNames.length];
        keywords = new ArrayList<ICommonKeyword>();
        int[] keywordKinds= parser.getLexer().getKeywordKinds();
        for(int i= 1; i < keywordKinds.length; i++) {
            int index= parser.getIPrsStream().mapKind(keywordKinds[i]);
            fIsKeyword[index]= true;
            keywords.add(createKeyword(tokenKindNames[index]));
        }
    }

	protected ICommonKeyword createKeyword(String text) {
		return new CommonKeyword(text);
	}

	public List<ICommonKeyword> getKeywords() {
		return keywords;
	}

    public boolean isKeyword(int kind) {
        return kind < tokenKindNames.length && fIsKeyword[kind];
    }
}