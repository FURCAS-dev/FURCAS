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
 *<li>Rule 98:  relationalExpression ::= relationalExpression > compareableExpression
 *</b>
 */
public class GreaterRelationalExpression extends Node implements IrelationalExpression
{
    private IrelationalExpression _relationalExpression;
    private IcompareableExpression _compareableExpression;

    public IrelationalExpression getrelationalExpression() { return _relationalExpression; }
    public IcompareableExpression getcompareableExpression() { return _compareableExpression; }

    public GreaterRelationalExpression(IToken leftIToken, IToken rightIToken,
                                       IrelationalExpression _relationalExpression,
                                       IcompareableExpression _compareableExpression)
    {
        super(leftIToken, rightIToken);

        this._relationalExpression = _relationalExpression;
        this._compareableExpression = _compareableExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


