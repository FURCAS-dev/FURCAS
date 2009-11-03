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
 *<li>Rule 72:  prePostOrBodyDeclN ::= prePostOrBodyDeclN prePostOrBodyDecl
 *</b>
 */
public class PrePostOrBodyDecls extends Node implements IprePostOrBodyDeclN
{
    private IprePostOrBodyDeclN _prePostOrBodyDeclN;
    private IprePostOrBodyDecl _prePostOrBodyDecl;

    public IprePostOrBodyDeclN getprePostOrBodyDeclN() { return _prePostOrBodyDeclN; }
    public IprePostOrBodyDecl getprePostOrBodyDecl() { return _prePostOrBodyDecl; }

    public PrePostOrBodyDecls(IToken leftIToken, IToken rightIToken,
                              IprePostOrBodyDeclN _prePostOrBodyDeclN,
                              IprePostOrBodyDecl _prePostOrBodyDecl)
    {
        super(leftIToken, rightIToken);

        this._prePostOrBodyDeclN = _prePostOrBodyDeclN;
        this._prePostOrBodyDecl = _prePostOrBodyDecl;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


