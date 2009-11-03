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
 *<li>Rule 183:  collectionRangeOpt ::= .. oclExpression
 *</b>
 */
public class CollectionRange extends Node implements IcollectionRangeOpt
{
    private IoclExpression _oclExpression;

    public IoclExpression getoclExpression() { return _oclExpression; }

    public CollectionRange(IToken leftIToken, IToken rightIToken,
                           IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


