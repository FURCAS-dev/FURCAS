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
 *<li>Rule 70:  operationContextDecl ::= context operation prePostOrBodyDeclN
 *</b>
 */
public class OperationContextDecl extends Node implements IoperationContextDecl
{
    private OperationDecl _operation;
    private IprePostOrBodyDeclN _prePostOrBodyDeclN;

    public OperationDecl getoperation() { return _operation; }
    public IprePostOrBodyDeclN getprePostOrBodyDeclN() { return _prePostOrBodyDeclN; }

    public OperationContextDecl(IToken leftIToken, IToken rightIToken,
                                OperationDecl _operation,
                                IprePostOrBodyDeclN _prePostOrBodyDeclN)
    {
        super(leftIToken, rightIToken);

        this._operation = _operation;
        this._prePostOrBodyDeclN = _prePostOrBodyDeclN;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


