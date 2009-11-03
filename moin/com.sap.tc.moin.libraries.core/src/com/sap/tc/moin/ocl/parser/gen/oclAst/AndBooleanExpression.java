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
 *<li>Rule 92:  booleanExpression ::= booleanExpression and relationalExpression
 *</b>
 */
public class AndBooleanExpression extends Node implements IbooleanExpression
{
    private IbooleanExpression _booleanExpression;
    private IrelationalExpression _relationalExpression;

    public IbooleanExpression getbooleanExpression() { return _booleanExpression; }
    public IrelationalExpression getrelationalExpression() { return _relationalExpression; }

    public AndBooleanExpression(IToken leftIToken, IToken rightIToken,
                                IbooleanExpression _booleanExpression,
                                IrelationalExpression _relationalExpression)
    {
        super(leftIToken, rightIToken);

        this._booleanExpression = _booleanExpression;
        this._relationalExpression = _relationalExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


