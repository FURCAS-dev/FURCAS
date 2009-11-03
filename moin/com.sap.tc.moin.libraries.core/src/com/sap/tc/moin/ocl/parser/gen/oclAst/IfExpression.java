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
 *<li>Rule 104:  ifExpression ::= if oclExpression then oclExpression else oclExpression endif
 *</b>
 */
public class IfExpression extends Node implements IifExpression
{
    private IoclExpression _oclExpression;
    private IoclExpression _oclExpression4;
    private IoclExpression _oclExpression6;

    public IoclExpression getoclExpression() { return _oclExpression; }
    public IoclExpression getoclExpression4() { return _oclExpression4; }
    public IoclExpression getoclExpression6() { return _oclExpression6; }

    public IfExpression(IToken leftIToken, IToken rightIToken,
                        IoclExpression _oclExpression,
                        IoclExpression _oclExpression4,
                        IoclExpression _oclExpression6)
    {
        super(leftIToken, rightIToken);

        this._oclExpression = _oclExpression;
        this._oclExpression4 = _oclExpression4;
        this._oclExpression6 = _oclExpression6;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


