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
 *<li>Rule 37:  scopeClause ::= elements { identifierM }
 *</b>
 */
public class InElements extends Node implements IscopeClause
{
    private IidentifierM _identifierM;

    /**
     * The value returned by <b>getidentifierM</b> may be <b>null</b>
     */
    public IidentifierM getidentifierM() { return _identifierM; }

    public InElements(IToken leftIToken, IToken rightIToken,
                      IidentifierM _identifierM)
    {
        super(leftIToken, rightIToken);

        this._identifierM = _identifierM;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


