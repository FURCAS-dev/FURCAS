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
 *<li>Rule 115:  postfixExpression ::= postfixExpression propertyInvocation
 *</b>
 */
public class PostfixExpression extends Node implements IpostfixExpression
{
    private IpostfixExpression _postfixExpression;
    private IpropertyInvocation _propertyInvocation;

    public IpostfixExpression getpostfixExpression() { return _postfixExpression; }
    public IpropertyInvocation getpropertyInvocation() { return _propertyInvocation; }

    public PostfixExpression(IToken leftIToken, IToken rightIToken,
                             IpostfixExpression _postfixExpression,
                             IpropertyInvocation _propertyInvocation)
    {
        super(leftIToken, rightIToken);

        this._postfixExpression = _postfixExpression;
        this._propertyInvocation = _propertyInvocation;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


