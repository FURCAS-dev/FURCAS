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
 *<li>Rule 64:  invOrDefN ::= invOrDefN invOrDef
 *</b>
 */
public class InvOrDefs extends Node implements IinvOrDefN
{
    private IinvOrDefN _invOrDefN;
    private IinvOrDef _invOrDef;

    public IinvOrDefN getinvOrDefN() { return _invOrDefN; }
    public IinvOrDef getinvOrDef() { return _invOrDef; }

    public InvOrDefs(IToken leftIToken, IToken rightIToken,
                     IinvOrDefN _invOrDefN,
                     IinvOrDef _invOrDef)
    {
        super(leftIToken, rightIToken);

        this._invOrDefN = _invOrDefN;
        this._invOrDef = _invOrDef;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


