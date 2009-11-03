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
 *<li>Rule 19:  fromClause ::= from fromEntryN
 *</b>
 */
public class FromClause extends Node implements IfromClause
{
    private IfromEntryN _fromEntryN;

    public IfromEntryN getfromEntryN() { return _fromEntryN; }

    public FromClause(IToken leftIToken, IToken rightIToken,
                      IfromEntryN _fromEntryN)
    {
        super(leftIToken, rightIToken);

        this._fromEntryN = _fromEntryN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


