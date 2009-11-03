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
 *<li>Rule 76:  operation ::= sPathName ( variableDeclarationWithTypeM ) withTypeExpression
 *</b>
 */
public class OperationDecl extends Node implements Ioperation
{
    private IsPathName _sPathName;
    private IvariableDeclarationWithTypeM _variableDeclarationWithTypeM;
    private WithTypeExpression _withTypeExpression;

    public IsPathName getsPathName() { return _sPathName; }
    /**
     * The value returned by <b>getvariableDeclarationWithTypeM</b> may be <b>null</b>
     */
    public IvariableDeclarationWithTypeM getvariableDeclarationWithTypeM() { return _variableDeclarationWithTypeM; }
    public WithTypeExpression getwithTypeExpression() { return _withTypeExpression; }

    public OperationDecl(IToken leftIToken, IToken rightIToken,
                         IsPathName _sPathName,
                         IvariableDeclarationWithTypeM _variableDeclarationWithTypeM,
                         WithTypeExpression _withTypeExpression)
    {
        super(leftIToken, rightIToken);

        this._sPathName = _sPathName;
        this._variableDeclarationWithTypeM = _variableDeclarationWithTypeM;
        this._withTypeExpression = _withTypeExpression;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


