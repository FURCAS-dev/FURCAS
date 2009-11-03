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
 *<li>Rule 84:  comparisonPostElementEquals ::= identifier comparisonPostFix
 *</b>
 */
public class IdentifierEqualsComparisonInPredicate extends Node implements IcomparisonPostElementEquals
{
    private Ident _identifier;
    private ComparisonPredicate _comparisonPostFix;

    public Ident getidentifier() { return _identifier; }
    /**
     * The value returned by <b>getcomparisonPostFix</b> may be <b>null</b>
     */
    public ComparisonPredicate getcomparisonPostFix() { return _comparisonPostFix; }

    public IdentifierEqualsComparisonInPredicate(IToken leftIToken, IToken rightIToken,
                                                 Ident _identifier,
                                                 ComparisonPredicate _comparisonPostFix)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._comparisonPostFix = _comparisonPostFix;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


