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
 *<li>Rule 69:  navigationStep ::= identifier navigationDisambiguationOpt
 *</b>
 */
public class NameBasedNavigation extends Node implements InavigationStep
{
    private Ident _identifier;
    private AssocNavigation _navigationDisambiguationOpt;

    public Ident getidentifier() { return _identifier; }
    /**
     * The value returned by <b>getnavigationDisambiguationOpt</b> may be <b>null</b>
     */
    public AssocNavigation getnavigationDisambiguationOpt() { return _navigationDisambiguationOpt; }

    public NameBasedNavigation(IToken leftIToken, IToken rightIToken,
                               Ident _identifier,
                               AssocNavigation _navigationDisambiguationOpt)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._navigationDisambiguationOpt = _navigationDisambiguationOpt;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


