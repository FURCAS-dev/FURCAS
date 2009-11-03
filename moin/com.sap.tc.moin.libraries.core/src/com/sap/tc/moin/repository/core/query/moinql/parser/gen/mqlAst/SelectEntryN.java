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
 *<li>Rule 15:  selectEntryN ::= selectEntry , selectEntryN
 *</b>
 */
public class SelectEntryN extends Node implements IselectEntryN
{
    private IselectEntry _selectEntry;
    private IselectEntryN _selectEntryN;

    public IselectEntry getselectEntry() { return _selectEntry; }
    public IselectEntryN getselectEntryN() { return _selectEntryN; }

    public SelectEntryN(IToken leftIToken, IToken rightIToken,
                        IselectEntry _selectEntry,
                        IselectEntryN _selectEntryN)
    {
        super(leftIToken, rightIToken);

        this._selectEntry = _selectEntry;
        this._selectEntryN = _selectEntryN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


