/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package com.sap.tc.moin.repository.core.query.moinql.parser.gen.mqlAst;

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
 *<li>Rule 79:  nonLinkPredicate ::= >= comparisonPostElementOtherOperation
 *</b>
 */
public class ComparisonGreaterEqualPredicate extends Node implements InonLinkPredicate
{
    private IcomparisonPostElementOtherOperation _comparisonPostElementOtherOperation;

    public IcomparisonPostElementOtherOperation getcomparisonPostElementOtherOperation() { return _comparisonPostElementOtherOperation; }

    public ComparisonGreaterEqualPredicate(IToken leftIToken, IToken rightIToken,
                                           IcomparisonPostElementOtherOperation _comparisonPostElementOtherOperation)
    {
        super(leftIToken, rightIToken);

        this._comparisonPostElementOtherOperation = _comparisonPostElementOtherOperation;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


