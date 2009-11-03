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
 *<li>Rule 164:  iterContents ::= variableDeclaration , variableDeclaration | oclExpression
 *</b>
 */
public class IteratorTwoVarDecl extends Node implements IiterContents
{
    private VariableDeclaration _variableDeclaration;
    private VariableDeclaration _variableDeclaration3;
    private IoclExpression _oclExpression;

    public VariableDeclaration getvariableDeclaration() { return _variableDeclaration; }
    public VariableDeclaration getvariableDeclaration3() { return _variableDeclaration3; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public IteratorTwoVarDecl(IToken leftIToken, IToken rightIToken,
                              VariableDeclaration _variableDeclaration,
                              VariableDeclaration _variableDeclaration3,
                              IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._variableDeclaration = _variableDeclaration;
        this._variableDeclaration3 = _variableDeclaration3;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


