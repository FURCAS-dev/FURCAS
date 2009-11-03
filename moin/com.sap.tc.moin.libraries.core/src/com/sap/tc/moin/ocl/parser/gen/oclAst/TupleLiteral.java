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
 *<li>Rule 195:  tupleLiteral ::= Tuple { variableAssignmentM }
 *</b>
 */
public class TupleLiteral extends Node implements ItupleLiteral
{
    private IvariableAssignmentM _variableAssignmentM;

    /**
     * The value returned by <b>getvariableAssignmentM</b> may be <b>null</b>
     */
    public IvariableAssignmentM getvariableAssignmentM() { return _variableAssignmentM; }

    public TupleLiteral(IToken leftIToken, IToken rightIToken,
                        IvariableAssignmentM _variableAssignmentM)
    {
        super(leftIToken, rightIToken);

        this._variableAssignmentM = _variableAssignmentM;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


