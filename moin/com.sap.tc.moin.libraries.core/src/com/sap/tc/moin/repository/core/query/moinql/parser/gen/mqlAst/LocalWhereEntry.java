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
 *<li>Rule 45:  localWhereEntry ::= for identifier ( localWhereCondition )
 *</b>
 */
public class LocalWhereEntry extends Node implements IlocalWhereEntry
{
    private Ident _identifier;
    private IlocalWhereCondition _localWhereCondition;

    public Ident getidentifier() { return _identifier; }
    public IlocalWhereCondition getlocalWhereCondition() { return _localWhereCondition; }

    public LocalWhereEntry(IToken leftIToken, IToken rightIToken,
                           Ident _identifier,
                           IlocalWhereCondition _localWhereCondition)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._localWhereCondition = _localWhereCondition;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


