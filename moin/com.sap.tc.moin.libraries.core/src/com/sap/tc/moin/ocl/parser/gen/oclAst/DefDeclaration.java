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
 *<li>Rule 66:  invOrDef ::= def identifierOpt : defExpression
 *</b>
 */
public class DefDeclaration extends Node implements IinvOrDef
{
    private Ident _identifierOpt;
    private IdefExpression _defExpression;

    /**
     * The value returned by <b>getidentifierOpt</b> may be <b>null</b>
     */
    public Ident getidentifierOpt() { return _identifierOpt; }
    public IdefExpression getdefExpression() { return _defExpression; }

    public DefDeclaration(IToken leftIToken, IToken rightIToken,
                          Ident _identifierOpt,
                          IdefExpression _defExpression)
    {
        super(leftIToken, rightIToken);

        this._identifierOpt = _identifierOpt;
        this._defExpression = _defExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


