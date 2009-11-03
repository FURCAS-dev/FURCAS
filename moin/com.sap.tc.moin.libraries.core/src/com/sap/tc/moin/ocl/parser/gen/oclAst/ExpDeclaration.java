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
 *<li>Rule 67:  invOrDef ::= exp identifierOpt : oclExpression
 *</b>
 */
public class ExpDeclaration extends Node implements IinvOrDef
{
    private Ident _identifierOpt;
    private IoclExpression _oclExpression;

    /**
     * The value returned by <b>getidentifierOpt</b> may be <b>null</b>
     */
    public Ident getidentifierOpt() { return _identifierOpt; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public ExpDeclaration(IToken leftIToken, IToken rightIToken,
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


