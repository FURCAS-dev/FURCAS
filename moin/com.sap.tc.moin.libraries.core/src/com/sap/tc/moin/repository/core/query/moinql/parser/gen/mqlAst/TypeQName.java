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
 *<li>Rule 25:  typeClauseQName ::= typePathName withoutsubtypesOpt
 *</b>
 */
public class TypeQName extends Node implements ItypeClauseQName
{
    private ItypePathName _typePathName;
    private Withoutsubtypes _withoutsubtypesOpt;

    public ItypePathName gettypePathName() { return _typePathName; }
    /**
     * The value returned by <b>getwithoutsubtypesOpt</b> may be <b>null</b>
     */
    public Withoutsubtypes getwithoutsubtypesOpt() { return _withoutsubtypesOpt; }

    public TypeQName(IToken leftIToken, IToken rightIToken,
                     ItypePathName _typePathName,
                     Withoutsubtypes _withoutsubtypesOpt)
    {
        super(leftIToken, rightIToken);

        this._typePathName = _typePathName;
        this._withoutsubtypesOpt = _withoutsubtypesOpt;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


