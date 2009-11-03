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
 *<li>Rule 87:  varPathName ::= typeLiteral
 *</b>
 */
public class TypeLiteral extends Node implements IvarPathName
{
    private ItypeLiteral _typeLiteral;

    public ItypeLiteral gettypeLiteral() { return _typeLiteral; }

    public TypeLiteral(IToken leftIToken, IToken rightIToken,
                       ItypeLiteral _typeLiteral)
    {
        super(leftIToken, rightIToken);

        this._typeLiteral = _typeLiteral;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


