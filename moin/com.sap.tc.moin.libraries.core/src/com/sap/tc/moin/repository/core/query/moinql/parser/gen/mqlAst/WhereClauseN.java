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
 *<li>Rule 41:  whereClauseN ::= whereClause whereClauseN
 *</b>
 */
public class WhereClauseN extends Node implements IwhereClauseN
{
    private WhereClause _whereClause;
    private IwhereClauseN _whereClauseN;

    public WhereClause getwhereClause() { return _whereClause; }
    public IwhereClauseN getwhereClauseN() { return _whereClauseN; }

    public WhereClauseN(IToken leftIToken, IToken rightIToken,
                        WhereClause _whereClause,
                        IwhereClauseN _whereClauseN)
    {
        super(leftIToken, rightIToken);

        this._whereClause = _whereClause;
        this._whereClauseN = _whereClauseN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


