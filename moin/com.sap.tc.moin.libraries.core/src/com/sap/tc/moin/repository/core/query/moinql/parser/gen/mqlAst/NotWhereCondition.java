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
 *<li>Rule 49:  negativeWhereCondition ::= not negativeWhereCondition
 *</b>
 */
public class NotWhereCondition extends Node implements InegativeWhereCondition
{
    private InegativeWhereCondition _negativeWhereCondition;

    public InegativeWhereCondition getnegativeWhereCondition() { return _negativeWhereCondition; }

    public NotWhereCondition(IToken leftIToken, IToken rightIToken,
                             InegativeWhereCondition _negativeWhereCondition)
    {
        super(leftIToken, rightIToken);

        this._negativeWhereCondition = _negativeWhereCondition;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


