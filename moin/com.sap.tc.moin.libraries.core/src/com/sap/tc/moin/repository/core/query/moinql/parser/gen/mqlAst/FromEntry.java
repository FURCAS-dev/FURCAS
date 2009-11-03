/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package com.sap.tc.moin.repository.core.query.moinql.parser.gen.mqlAst;

import lpg.lpgjavaruntime.*;


import com.sap.tc.moin.repository.shared.util.parsers.AstException;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;
import com.sap.tc.moin.repository.shared.util.ProcessMessages;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.shared.util.parsers.LPGMessages;
import com.sap.tc.moin.repository.shared.util.LocalizedProcessException;

/**
 *<b>
 *<li>Rule 22:  fromEntry ::= typeClause as identifier scopeClauseOpt
 *</b>
 */
public class FromEntry extends Node implements IfromEntry
{
    private ItypeClause _typeClause;
    private Ident _identifier;
    private ScopeClause _scopeClauseOpt;

    public ItypeClause gettypeClause() { return _typeClause; }
    public Ident getidentifier() { return _identifier; }
    /**
     * The value returned by <b>getscopeClauseOpt</b> may be <b>null</b>
     */
    public ScopeClause getscopeClauseOpt() { return _scopeClauseOpt; }

    public FromEntry(IToken leftIToken, IToken rightIToken,
                     ItypeClause _typeClause,
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


