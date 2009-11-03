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
 *<li>Rule 82:  nonLinkPredicate ::= not like literal
 *</b>
 */
public class ComparisonNotLikePredicate extends Node implements InonLinkPredicate
{
    private Iliteral _literal;

    public Iliteral getliteral() { return _literal; }

    public ComparisonNotLikePredicate(IToken leftIToken, IToken rightIToken,
                                      Iliteral _literal)
    {
        super(leftIToken, rightIToken);

        this._literal = _literal;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


