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

import org.eclipse.emf.query2.exception.BaseException;
import org.eclipse.emf.query2.internal.moinql.parser.AstException;
import org.eclipse.emf.query2.internal.moinql.parser.LPGMessages;
import org.eclipse.emf.query2.report.LocalizedProcessException;
import org.eclipse.emf.query2.report.ProcessErrorImpl;
import org.eclipse.emf.query2.report.ProcessMessages;
import org.eclipse.emf.query2.report.ProcessReport;
import org.eclipse.emf.query2.report.ProcessWarningImpl;

import lpg.lpgjavaruntime.*;



/**
 *<b>
 *<li>Rule 20:  fromEntry ::= typeClause as identifier scopeClauseOpt
 *</b>
 */
public class FromEntry extends Node implements IfromEntry
{
    private TypeQName _typeClause;
    private Ident _identifier;
    private ScopeClause _scopeClauseOpt;

    public TypeQName gettypeClause() { return _typeClause; }
    public Ident getidentifier() { return _identifier; }
    /**
     * The value returned by <b>getscopeClauseOpt</b> may be <b>null</b>
     */
    public ScopeClause getscopeClauseOpt() { return _scopeClauseOpt; }

    public FromEntry(IToken leftIToken, IToken rightIToken,
                     TypeQName _typeClause,
                     Ident _identifier,
                     ScopeClause _scopeClauseOpt)
    {
        super(leftIToken, rightIToken);

        this._typeClause = _typeClause;
        this._identifier = _identifier;
        this._scopeClauseOpt = _scopeClauseOpt;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


