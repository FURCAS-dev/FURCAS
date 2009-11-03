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
 *<li>Rule 38:  tupleType ::= Tuple ( variableDeclarationWithTypeM )
 *</b>
 */
public class TupleType extends Node implements ItupleType
{
    private IvariableDeclarationWithTypeM _variableDeclarationWithTypeM;

    /**
     * The value returned by <b>getvariableDeclarationWithTypeM</b> may be <b>null</b>
     */
    public IvariableDeclarationWithTypeM getvariableDeclarationWithTypeM() { return _variableDeclarationWithTypeM; }

    public TupleType(IToken leftIToken, IToken rightIToken,
                     IvariableDeclarationWithTypeM _variableDeclarationWithTypeM)
    {
        super(leftIToken, rightIToken);

        this._variableDeclarationWithTypeM = _variableDeclarationWithTypeM;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


