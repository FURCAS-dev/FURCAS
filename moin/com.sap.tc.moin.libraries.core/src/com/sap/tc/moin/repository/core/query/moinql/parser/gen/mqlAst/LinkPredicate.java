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
 *<li>Rule 74:  joinPart ::= notOpt in ( query )
 *</b>
 */
public class LinkPredicate extends Node implements IjoinPart
{
    private Not _notOpt;
    private MqlQuery _query;

    /**
     * The value returned by <b>getnotOpt</b> may be <b>null</b>
     */
    public Not getnotOpt() { return _notOpt; }
    /**
     * The value returned by <b>getquery</b> may be <b>null</b>
     */
    public MqlQuery getquery() { return _query; }

    public LinkPredicate(IToken leftIToken, IToken rightIToken,
                         Not _notOpt,
                         MqlQuery _query)
    {
        super(leftIToken, rightIToken);

        this._notOpt = _notOpt;
        this._query = _query;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


