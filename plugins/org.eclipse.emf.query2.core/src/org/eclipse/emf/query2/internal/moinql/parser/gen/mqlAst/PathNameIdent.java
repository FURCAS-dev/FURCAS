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

import lpg.lpgjavaruntime.IToken;



/**
 *<b>
 *<li>Rule 6:  sPathName ::= identifier
 *</b>
 */
public class PathNameIdent extends Node implements IsPathName
{
    private Ident _identifier;

    public Ident getidentifier() { return _identifier; }

    public PathNameIdent(IToken leftIToken, IToken rightIToken,
                         Ident _identifier)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


