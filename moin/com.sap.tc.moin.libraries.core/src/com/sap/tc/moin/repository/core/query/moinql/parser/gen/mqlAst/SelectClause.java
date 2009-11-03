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
 *<li>Rule 14:  selectClause ::= select selectEntryN
 *</b>
 */
public class SelectClause extends Node implements IselectClause
{
    private IselectEntryN _selectEntryN;

    public IselectEntryN getselectEntryN() { return _selectEntryN; }

    public SelectClause(IToken leftIToken, IToken rightIToken,
                        IselectEntryN _selectEntryN)
    {
        super(leftIToken, rightIToken);

        this._selectEntryN = _selectEntryN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


