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
 *<li>Rule 67:  joinWhereEntry ::= identifier . navigationStep joinPart
 *</b>
 */
public class JoinWhereEntry extends Node implements IjoinWhereEntry
{
    private Ident _identifier;
    private InavigationStep _navigationStep;
    private IjoinPart _joinPart;

    public Ident getidentifier() { return _identifier; }
    public InavigationStep getnavigationStep() { return _navigationStep; }
    public IjoinPart getjoinPart() { return _joinPart; }

    public JoinWhereEntry(IToken leftIToken, IToken rightIToken,
                          Ident _identifier,
                          InavigationStep _navigationStep,
                          IjoinPart _joinPart)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._navigationStep = _navigationStep;
        this._joinPart = _joinPart;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


