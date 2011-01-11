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
 *<li>Rule 24:  withoutsubtypesOpt ::= withoutsubtypes typeSetClauseOpt
 *</b>
 */
public class Withoutsubtypes extends Node implements IwithoutsubtypesOpt
{
    private TypeSetClause _typeSetClauseOpt;

    /**
     * The value returned by <b>gettypeSetClauseOpt</b> may be <b>null</b>
     */
    public TypeSetClause gettypeSetClauseOpt() { return _typeSetClauseOpt; }

    public Withoutsubtypes(IToken leftIToken, IToken rightIToken,
                           TypeSetClause _typeSetClauseOpt)
    {
        super(leftIToken, rightIToken);

        this._typeSetClauseOpt = _typeSetClauseOpt;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


