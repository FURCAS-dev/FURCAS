/**
   * This file is generated for MOIN-OCL with LPG. 
   */

package com.sap.tc.moin.ocl.parser.gen.oclAst;

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
 *<li>Rule 11:  variableDeclaration ::= identifier withTypeExpressionOpt
 *</b>
 */
public class VariableDeclaration extends Node implements IvariableDeclaration
{
    private Ident _identifier;
    private WithTypeExpression _withTypeExpressionOpt;

    public Ident getidentifier() { return _identifier; }
    /**
     * The value returned by <b>getwithTypeExpressionOpt</b> may be <b>null</b>
     */
    public WithTypeExpression getwithTypeExpressionOpt() { return _withTypeExpressionOpt; }

    public VariableDeclaration(IToken leftIToken, IToken rightIToken,
                               Ident _identifier,
                               WithTypeExpression _withTypeExpressionOpt)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._withTypeExpressionOpt = _withTypeExpressionOpt;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


