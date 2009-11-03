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
 *<li>Rule 200:  iterateExp ::= iterate ( variableDeclaration ; variableAssignment | oclExpression )
 *</b>
 */
public class IterateVarDeclAndAcc extends Node implements IiterateExp
{
    private VariableDeclaration _variableDeclaration;
    private VariableAssignment _variableAssignment;
    private IoclExpression _oclExpression;

    public VariableDeclaration getvariableDeclaration() { return _variableDeclaration; }
    public VariableAssignment getvariableAssignment() { return _variableAssignment; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public IterateVarDeclAndAcc(IToken leftIToken, IToken rightIToken,
                                VariableDeclaration _variableDeclaration,
                                VariableAssignment _variableAssignment,
                                IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._variableDeclaration = _variableDeclaration;
        this._variableAssignment = _variableAssignment;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


