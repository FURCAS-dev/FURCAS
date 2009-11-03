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
 *<li>Rule 177:  collectionLiteralPart ::= oclExpression collectionRangeOpt
 *</b>
 */
public class CollectionLiteralExpression extends Node implements IcollectionLiteralPart
{
    private IoclExpression _oclExpression;
    private CollectionRange _collectionRangeOpt;

    public IoclExpression getoclExpression() { return _oclExpression; }
    /**
     * The value returned by <b>getcollectionRangeOpt</b> may be <b>null</b>
     */
    public CollectionRange getcollectionRangeOpt() { return _collectionRangeOpt; }

    public CollectionLiteralExpression(IToken leftIToken, IToken rightIToken,
                                       IoclExpression _oclExpression,
                                       CollectionRange _collectionRangeOpt)
    {
        super(leftIToken, rightIToken);

        this._oclExpression = _oclExpression;
        this._collectionRangeOpt = _collectionRangeOpt;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


