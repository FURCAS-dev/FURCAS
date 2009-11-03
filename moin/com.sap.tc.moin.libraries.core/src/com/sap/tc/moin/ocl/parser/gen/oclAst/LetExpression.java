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
 *<li>Rule 79:  letExpression ::= let variableAssignmentN in oclExpression
 *</b>
 */
public class LetExpression extends Node implements IletExpression
{
    private IvariableAssignmentN _variableAssignmentN;
    private IoclExpression _oclExpression;

    public IvariableAssignmentN getvariableAssignmentN() { return _variableAssignmentN; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public LetExpression(IToken leftIToken, IToken rightIToken,
                         IvariableAssignmentN _variableAssignmentN,
                         IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._variableAssignmentN = _variableAssignmentN;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


