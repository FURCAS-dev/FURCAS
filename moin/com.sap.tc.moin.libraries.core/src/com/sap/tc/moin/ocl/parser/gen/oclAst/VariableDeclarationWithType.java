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
 *<li>Rule 15:  variableDeclarationWithType ::= identifier withTypeExpression
 *</b>
 */
public class VariableDeclarationWithType extends Node implements IvariableDeclarationWithType
{
    private Ident _identifier;
    private WithTypeExpression _withTypeExpression;

    public Ident getidentifier() { return _identifier; }
    public WithTypeExpression getwithTypeExpression() { return _withTypeExpression; }

    public VariableDeclarationWithType(IToken leftIToken, IToken rightIToken,
                                       Ident _identifier,
                                       WithTypeExpression _withTypeExpression)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._withTypeExpression = _withTypeExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


