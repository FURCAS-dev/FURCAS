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
 *<li>Rule 19:  variableDeclarationWithTypeN ::= variableDeclarationWithType , variableDeclarationWithTypeN
 *</b>
 */
public class VariableDeclarationWithTypeN extends Node implements IvariableDeclarationWithTypeN
{
    private VariableDeclarationWithType _variableDeclarationWithType;
    private IvariableDeclarationWithTypeN _variableDeclarationWithTypeN;

    public VariableDeclarationWithType getvariableDeclarationWithType() { return _variableDeclarationWithType; }
    public IvariableDeclarationWithTypeN getvariableDeclarationWithTypeN() { return _variableDeclarationWithTypeN; }

    public VariableDeclarationWithTypeN(IToken leftIToken, IToken rightIToken,
                                        VariableDeclarationWithType _variableDeclarationWithType,
                                        IvariableDeclarationWithTypeN _variableDeclarationWithTypeN)
    {
        super(leftIToken, rightIToken);

        this._variableDeclarationWithType = _variableDeclarationWithType;
        this._variableDeclarationWithTypeN = _variableDeclarationWithTypeN;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


