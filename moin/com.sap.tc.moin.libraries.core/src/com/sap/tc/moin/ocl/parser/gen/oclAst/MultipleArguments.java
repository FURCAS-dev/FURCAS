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
 *<li>Rule 145:  arguments ::= ( argumentN )
 *</b>
 */
public class MultipleArguments extends Node implements Iarguments
{
    private IargumentN _argumentN;

    public IargumentN getargumentN() { return _argumentN; }

    public MultipleArguments(IToken leftIToken, IToken rightIToken,
                             IargumentN _argumentN)
    {
        super(leftIToken, rightIToken);

        this._argumentN = _argumentN;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


