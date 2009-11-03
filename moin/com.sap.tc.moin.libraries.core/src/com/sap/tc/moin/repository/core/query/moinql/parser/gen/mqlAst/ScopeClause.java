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
 *<li>Rule 34:  scopeClauseOpt ::= notOpt in scopeClause
 *</b>
 */
public class ScopeClause extends Node implements IscopeClauseOpt
{
    private Not _notOpt;
    private IscopeClause _scopeClause;

    /**
     * The value returned by <b>getnotOpt</b> may be <b>null</b>
     */
    public Not getnotOpt() { return _notOpt; }
    public IscopeClause getscopeClause() { return _scopeClause; }

    public ScopeClause(IToken leftIToken, IToken rightIToken,
                       Not _notOpt,
                       IscopeClause _scopeClause)
    {
        super(leftIToken, rightIToken);

        this._notOpt = _notOpt;
        this._scopeClause = _scopeClause;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


