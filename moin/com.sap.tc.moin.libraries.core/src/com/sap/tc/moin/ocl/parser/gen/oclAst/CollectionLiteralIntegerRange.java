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
 *<li>Rule 178:  collectionLiteralPart ::= minusOpt integerLiteralRange oclExpression
 *</b>
 */
public class CollectionLiteralIntegerRange extends Node implements IcollectionLiteralPart
{
    private Minus _minusOpt;
    private IntegerLiteralRange _integerLiteralRange;
    private IoclExpression _oclExpression;

    /**
     * The value returned by <b>getminusOpt</b> may be <b>null</b>
     */
    public Minus getminusOpt() { return _minusOpt; }
    public IntegerLiteralRange getintegerLiteralRange() { return _integerLiteralRange; }
    public IoclExpression getoclExpression() { return _oclExpression; }

    public CollectionLiteralIntegerRange(IToken leftIToken, IToken rightIToken,
                                         Minus _minusOpt,
                                         IntegerLiteralRange _integerLiteralRange,
                                         IoclExpression _oclExpression)
    {
        super(leftIToken, rightIToken);

        this._minusOpt = _minusOpt;
        this._integerLiteralRange = _integerLiteralRange;
        this._oclExpression = _oclExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


