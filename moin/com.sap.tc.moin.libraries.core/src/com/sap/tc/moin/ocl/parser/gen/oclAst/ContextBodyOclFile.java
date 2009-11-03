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
 *<li>Rule 41:  oclFile ::= contextBody
 *</b>
 */
public class ContextBodyOclFile extends Node implements IoclFile
{
    private IcontextBody _contextBody;

    public IcontextBody getcontextBody() { return _contextBody; }

    public ContextBodyOclFile(IToken leftIToken, IToken rightIToken,
                              IcontextBody _contextBody)
    {
        super(leftIToken, rightIToken);

        this._contextBody = _contextBody;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


