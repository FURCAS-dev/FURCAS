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
 *<li>Rule 156:  iteratorExp ::= any ( iterContents )
 *</b>
 */
public class IteratorAny extends Node implements IiteratorExp
{
    private IiterContents _iterContents;

    public IiterContents getiterContents() { return _iterContents; }

    public IteratorAny(IToken leftIToken, IToken rightIToken,
                       IiterContents _iterContents)
    {
        super(leftIToken, rightIToken);

        this._iterContents = _iterContents;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


