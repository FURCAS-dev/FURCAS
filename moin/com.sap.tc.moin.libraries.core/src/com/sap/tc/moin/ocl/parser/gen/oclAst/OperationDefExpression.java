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
 *<li>Rule 69:  defExpression ::= operation = oclExpression
 *</b>
 */
public class OperationDefExpression extends Node implements IdefExpression
{
    private OperationDecl _operation;
    private IoclExpression _oclExpression;

    public OperationDecl getoperation() { return _operation; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public OperationDefExpression(IToken leftIToken, IToken rightIToken,
                                  OperationDecl _operation,
                                  IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._operation = _operation;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


