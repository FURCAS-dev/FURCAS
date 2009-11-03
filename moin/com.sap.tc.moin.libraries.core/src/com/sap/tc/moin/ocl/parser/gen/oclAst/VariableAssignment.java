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
 *<li>Rule 84:  variableAssignment ::= identifier withTypeExpressionOpt = oclExpression
 *</b>
 */
public class VariableAssignment extends Node implements IvariableAssignment
{
    private Ident _identifier;
    private WithTypeExpression _withTypeExpressionOpt;
    private IoclExpression _oclExpression;

    public Ident getidentifier() { return _identifier; }
    /**
     * The value returned by <b>getwithTypeExpressionOpt</b> may be <b>null</b>
     */
    public WithTypeExpression getwithTypeExpressionOpt() { return _withTypeExpressionOpt; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public VariableAssignment(IToken leftIToken, IToken rightIToken,
                              Ident _identifier,
                              WithTypeExpression _withTypeExpressionOpt,
                              IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._withTypeExpressionOpt = _withTypeExpressionOpt;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


