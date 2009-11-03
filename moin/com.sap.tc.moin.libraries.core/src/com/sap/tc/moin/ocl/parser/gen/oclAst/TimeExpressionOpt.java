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
 *<li>Rule 166:  timeExpressionOpt ::= $Empty
 *<li>Rule 197:  timeExpressionOpt ::= ATPRE
 *</b>
 */
public class TimeExpressionOpt extends Node implements ItimeExpressionOpt
{


    public TimeExpressionOpt(IToken leftIToken, IToken rightIToken)
    {
        super(leftIToken, rightIToken);

        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


