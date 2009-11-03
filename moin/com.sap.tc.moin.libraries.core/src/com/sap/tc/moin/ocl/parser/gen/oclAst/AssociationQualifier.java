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
 *<li>Rule 149:  associationQualifier ::= [ pathName ]
 *</b>
 */
public class AssociationQualifier extends Node implements IassociationQualifier
{
    private IpathName _pathName;

    public IpathName getpathName() { return _pathName; }

    public AssociationQualifier(IToken leftIToken, IToken rightIToken,
                                IpathName _pathName)
    {
        super(leftIToken, rightIToken);

        this._pathName = _pathName;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


