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
 *<li>Rule 28:  withoutsubtypesOpt ::= withoutsubtypes typeSetClauseOpt
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


