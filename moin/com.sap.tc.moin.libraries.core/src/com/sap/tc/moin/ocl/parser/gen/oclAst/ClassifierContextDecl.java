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
 *<li>Rule 62:  classifierContextDecl ::= context sPathName invOrDefN
 *</b>
 */
public class ClassifierContextDecl extends Node implements IclassifierContextDecl
{
    private IsPathName _sPathName;
    private IinvOrDefN _invOrDefN;

    public IsPathName getsPathName() { return _sPathName; }
    public IinvOrDefN getinvOrDefN() { return _invOrDefN; }

    public ClassifierContextDecl(IToken leftIToken, IToken rightIToken,
                                 IsPathName _sPathName,
                                 IinvOrDefN _invOrDefN)
    {
        super(leftIToken, rightIToken);

        this._sPathName = _sPathName;
        this._invOrDefN = _invOrDefN;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


