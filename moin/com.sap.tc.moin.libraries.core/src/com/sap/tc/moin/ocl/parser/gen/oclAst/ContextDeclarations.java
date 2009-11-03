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
 *<li>Rule 53:  contextDeclarationN ::= contextDeclarationN contextDeclaration
 *</b>
 */
public class ContextDeclarations extends Node implements IcontextDeclarationN
{
    private IcontextDeclarationN _contextDeclarationN;
    private IcontextDeclaration _contextDeclaration;

    public IcontextDeclarationN getcontextDeclarationN() { return _contextDeclarationN; }
    public IcontextDeclaration getcontextDeclaration() { return _contextDeclaration; }

    public ContextDeclarations(IToken leftIToken, IToken rightIToken,
                               IcontextDeclarationN _contextDeclarationN,
                               IcontextDeclaration _contextDeclaration)
    {
        super(leftIToken, rightIToken);

        this._contextDeclarationN = _contextDeclarationN;
        this._contextDeclaration = _contextDeclaration;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


