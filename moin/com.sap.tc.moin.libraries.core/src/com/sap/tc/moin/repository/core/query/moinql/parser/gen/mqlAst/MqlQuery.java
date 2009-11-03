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
 *<li>Rule 12:  query ::= selectClause fromClause whereClauseM
 *</b>
 */
public class MqlQuery extends Node implements Iquery
{
    private SelectClause _selectClause;
    private FromClause _fromClause;
    private IwhereClauseM _whereClauseM;

    public SelectClause getselectClause() { return _selectClause; }
    public FromClause getfromClause() { return _fromClause; }
    /**
     * The value returned by <b>getwhereClauseM</b> may be <b>null</b>
     */
    public IwhereClauseM getwhereClauseM() { return _whereClauseM; }

    public MqlQuery(IToken leftIToken, IToken rightIToken,
                    SelectClause _selectClause,
                    FromClause _fromClause,
                    IwhereClauseM _whereClauseM)
    {
        super(leftIToken, rightIToken);

        this._selectClause = _selectClause;
        this._fromClause = _fromClause;
        this._whereClauseM = _whereClauseM;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


