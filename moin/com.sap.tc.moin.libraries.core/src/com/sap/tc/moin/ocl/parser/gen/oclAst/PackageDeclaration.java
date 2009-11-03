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
 *<li>Rule 49:  packageDeclaration ::= package sPathName contextDeclarationM endpackage
 *</b>
 */
public class PackageDeclaration extends Node implements IpackageDeclaration
{
    private IsPathName _sPathName;
    private IcontextDeclarationM _contextDeclarationM;

    public IsPathName getsPathName() { return _sPathName; }
    /**
     * The value returned by <b>getcontextDeclarationM</b> may be <b>null</b>
     */
    public IcontextDeclarationM getcontextDeclarationM() { return _contextDeclarationM; }

    public PackageDeclaration(IToken leftIToken, IToken rightIToken,
                              IsPathName _sPathName,
                              IcontextDeclarationM _contextDeclarationM)
    {
        super(leftIToken, rightIToken);

        this._sPathName = _sPathName;
        this._contextDeclarationM = _contextDeclarationM;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


