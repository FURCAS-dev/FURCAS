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
 *<li>Rule 51:  operationCondition ::= identifier operationPart
 *</b>
 */
public class OperationCondition extends Node implements IoperationCondition
{
    private Ident _identifier;
    private IoperationPart _operationPart;

    public Ident getidentifier() { return _identifier; }
    public IoperationPart getoperationPart() { return _operationPart; }

    public OperationCondition(IToken leftIToken, IToken rightIToken,
                              Ident _identifier,
                              IoperationPart _operationPart)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._operationPart = _operationPart;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


