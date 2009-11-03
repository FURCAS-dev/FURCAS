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
 *<li>Rule 122:  propertyInvocation ::= -> loopExp
 *</b>
 */
public class LoopPropertyInvocation extends Node implements IpropertyInvocation
{
    private IloopExp _loopExp;

    public IloopExp getloopExp() { return _loopExp; }

    public LoopPropertyInvocation(IToken leftIToken, IToken rightIToken,
                                  IloopExp _loopExp)
    {
        super(leftIToken, rightIToken);

        this._loopExp = _loopExp;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


