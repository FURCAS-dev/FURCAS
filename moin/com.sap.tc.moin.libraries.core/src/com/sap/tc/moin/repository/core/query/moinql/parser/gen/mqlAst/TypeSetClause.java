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
 *<li>Rule 30:  typeSetClauseOpt ::= { typePathNameN }
 *</b>
 */
public class TypeSetClause extends Node implements ItypeSetClauseOpt
{
    private ItypePathNameN _typePathNameN;

    public ItypePathNameN gettypePathNameN() { return _typePathNameN; }

    public TypeSetClause(IToken leftIToken, IToken rightIToken,
                         ItypePathNameN _typePathNameN)
    {
        super(leftIToken, rightIToken);

        this._typePathNameN = _typePathNameN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


