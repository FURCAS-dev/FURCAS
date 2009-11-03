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
 *<li>Rule 90:  logicalExpression ::= logicalExpression implies booleanExpression
 *</b>
 */
public class LogicalExpression extends Node implements IlogicalExpression
{
    private IlogicalExpression _logicalExpression;
    private IbooleanExpression _booleanExpression;

    public IlogicalExpression getlogicalExpression() { return _logicalExpression; }
    public IbooleanExpression getbooleanExpression() { return _booleanExpression; }

    public LogicalExpression(IToken leftIToken, IToken rightIToken,
                             IlogicalExpression _logicalExpression,
                             IbooleanExpression _booleanExpression)
    {
        super(leftIToken, rightIToken);

        this._logicalExpression = _logicalExpression;
        this._booleanExpression = _booleanExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


