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
 *<li>Rule 18:  selectEntry ::= identifier . identifier
 *</b>
 */
public class SelectAttribute extends Node implements IselectEntry
{
    private Ident _identifier;
    private Ident _identifier3;

    public Ident getidentifier() { return _identifier; }
    public Ident getidentifier3() { return _identifier3; }

    public SelectAttribute(IToken leftIToken, IToken rightIToken,
                           Ident _identifier,
                           Ident _identifier3)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._identifier3 = _identifier3;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


