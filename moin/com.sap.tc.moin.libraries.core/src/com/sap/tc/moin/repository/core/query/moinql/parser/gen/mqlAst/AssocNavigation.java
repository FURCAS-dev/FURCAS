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
 *<li>Rule 72:  navigationDisambiguationOpt ::= [ pathName ]
 *</b>
 */
public class AssocNavigation extends Node implements InavigationDisambiguationOpt
{
    private IpathName _pathName;

    public IpathName getpathName() { return _pathName; }

    public AssocNavigation(IToken leftIToken, IToken rightIToken,
                           IpathName _pathName)
    {
        super(leftIToken, rightIToken);

        this._pathName = _pathName;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


