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
 *<li>Rule 48:  packageDeclarationN ::= packageDeclarationN packageDeclaration
 *</b>
 */
public class PackageDeclarations extends Node implements IpackageDeclarationN
{
    private IpackageDeclarationN _packageDeclarationN;
    private PackageDeclaration _packageDeclaration;

    public IpackageDeclarationN getpackageDeclarationN() { return _packageDeclarationN; }
    public PackageDeclaration getpackageDeclaration() { return _packageDeclaration; }

    public PackageDeclarations(IToken leftIToken, IToken rightIToken,
                               IpackageDeclarationN _packageDeclarationN,
                               PackageDeclaration _packageDeclaration)
    {
        super(leftIToken, rightIToken);

        this._packageDeclarationN = _packageDeclarationN;
        this._packageDeclaration = _packageDeclaration;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


