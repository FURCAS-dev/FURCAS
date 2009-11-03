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
 * is implemented by:
 *<b>
 *<ul>
 *<li>LinkPredicate
 *<li>AssocOrComparisonPredicate
 *<li>ComparisonSmallerPredicate
 *<li>ComparisonGreaterPredicate
 *<li>ComparisonSmallerEqualPredicate
 *<li>ComparisonGreaterEqualPredicate
 *<li>ComparisonNotEqualPredicate
 *<li>ComparisonLikePredicate
 *<li>ComparisonNotLikePredicate
 *</ul>
 *</b>
 */
public interface IjoinPart
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(MqlAstVisitor v);
}


