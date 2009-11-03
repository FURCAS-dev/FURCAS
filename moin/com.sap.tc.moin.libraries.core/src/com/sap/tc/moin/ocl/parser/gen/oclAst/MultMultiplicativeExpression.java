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
 *<li>Rule 109:  multiplicativeExpression ::= multiplicativeExpression * unaryExpression
 *</b>
 */
public class MultMultiplicativeExpression extends Node implements ImultiplicativeExpression
{
    private ImultiplicativeExpression _multiplicativeExpression;
    private IunaryExpression _unaryExpression;

    public ImultiplicativeExpression getmultiplicativeExpression() { return _multiplicativeExpression; }
    public IunaryExpression getunaryExpression() { return _unaryExpression; }

    public MultMultiplicativeExpression(IToken leftIToken, IToken rightIToken,
                                        ImultiplicativeExpression _multiplicativeExpression,
                                        IunaryExpression _unaryExpression)
    {
        super(leftIToken, rightIToken);

        this._multiplicativeExpression = _multiplicativeExpression;
        this._unaryExpression = _unaryExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


