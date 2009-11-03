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
 *<li>Rule 85:  variableAssignmentWithType ::= identifier withTypeExpression = oclExpression
 *</b>
 */
public class VariableAssignmentWithType extends Node implements IvariableAssignmentWithType
{
    private Ident _identifier;
    private WithTypeExpression _withTypeExpression;
    private IoclExpression _oclExpression;

    public Ident getidentifier() { return _identifier; }
    public WithTypeExpression getwithTypeExpression() { return _withTypeExpression; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public VariableAssignmentWithType(IToken leftIToken, IToken rightIToken,
                                      Ident _identifier,
                                      WithTypeExpression _withTypeExpression,
                                      IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._withTypeExpression = _withTypeExpression;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


