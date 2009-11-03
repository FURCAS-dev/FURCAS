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
 *<li>Rule 26:  typeClauseMri ::= type identifier withoutsubtypesOpt
 *</b>
 */
public class TypeMri extends Node implements ItypeClauseMri
{
    private Ident _identifier;
    private Withoutsubtypes _withoutsubtypesOpt;

    public Ident getidentifier() { return _identifier; }
    /**
     * The value returned by <b>getwithoutsubtypesOpt</b> may be <b>null</b>
     */
    public Withoutsubtypes getwithoutsubtypesOpt() { return _withoutsubtypesOpt; }

    public TypeMri(IToken leftIToken, IToken rightIToken,
                   Ident _identifier,
                   Withoutsubtypes _withoutsubtypesOpt)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._withoutsubtypesOpt = _withoutsubtypesOpt;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


