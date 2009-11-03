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
 *<li>Rule 4:  identifierN ::= identifier , identifierN
 *</b>
 */
public class IdentifierN extends Node implements IidentifierN
{
    private Ident _identifier;
    private IidentifierN _identifierN;

    public Ident getidentifier() { return _identifier; }
    public IidentifierN getidentifierN() { return _identifierN; }

    public IdentifierN(IToken leftIToken, IToken rightIToken,
                       Ident _identifier,
                       IidentifierN _identifierN)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._identifierN = _identifierN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


