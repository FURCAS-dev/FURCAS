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
 *<li>Rule 106:  additiveExpression ::= additiveExpression + multiplicativeExpression
 *</b>
 */
public class PlusAdditiveExpression extends Node implements IadditiveExpression
{
    private IadditiveExpression _additiveExpression;
    private ImultiplicativeExpression _multiplicativeExpression;

    public IadditiveExpression getadditiveExpression() { return _additiveExpression; }
    public ImultiplicativeExpression getmultiplicativeExpression() { return _multiplicativeExpression; }

    public PlusAdditiveExpression(IToken leftIToken, IToken rightIToken,
                                  IadditiveExpression _additiveExpression,
                                  ImultiplicativeExpression _multiplicativeExpression)
    {
        super(leftIToken, rightIToken);

        this._additiveExpression = _additiveExpression;
        this._multiplicativeExpression = _multiplicativeExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


