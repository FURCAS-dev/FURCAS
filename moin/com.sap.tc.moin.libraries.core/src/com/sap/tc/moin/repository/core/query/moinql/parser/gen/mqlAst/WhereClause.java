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
 *<li>Rule 42:  whereClause ::= where whereEntry
 *</b>
 */
public class WhereClause extends Node implements IwhereClause
{
    private IwhereEntry _whereEntry;

    public IwhereEntry getwhereEntry() { return _whereEntry; }

    public WhereClause(IToken leftIToken, IToken rightIToken,
                       IwhereEntry _whereEntry)
    {
        super(leftIToken, rightIToken);

        this._whereEntry = _whereEntry;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


