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
 *<li>Rule 74:  prePostOrBodyDecl ::= post identifierOpt : oclExpression
 *</b>
 */
public class PostConditionDecl extends Node implements IprePostOrBodyDecl
{
    private Ident _identifierOpt;
    private IoclExpression _oclExpression;

    /**
     * The value returned by <b>getidentifierOpt</b> may be <b>null</b>
     */
    public Ident getidentifierOpt() { return _identifierOpt; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public PostConditionDecl(IToken leftIToken, IToken rightIToken,
                             Ident _identifierOpt,
                             IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._identifierOpt = _identifierOpt;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}

