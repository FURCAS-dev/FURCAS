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
 *<li>Rule 83:  variableAssignmentN ::= variableAssignment , variableAssignmentN
 *</b>
 */
public class VariableAssignmentN extends Node implements IvariableAssignmentN
{
    private VariableAssignment _variableAssignment;
    private IvariableAssignmentN _variableAssignmentN;

    public VariableAssignment getvariableAssignment() { return _variableAssignment; }
    public IvariableAssignmentN getvariableAssignmentN() { return _variableAssignmentN; }

    public VariableAssignmentN(IToken leftIToken, IToken rightIToken,
                               VariableAssignment _variableAssignment,
                               IvariableAssignmentN _variableAssignmentN)
    {
        super(leftIToken, rightIToken);

        this._variableAssignment = _variableAssignment;
        this._variableAssignmentN = _variableAssignmentN;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


