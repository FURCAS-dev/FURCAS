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
 *<li>Rule 59:  initOrDerValueN ::= initOrDerValueN initOrDerValue
 *</b>
 */
public class InitOrDerValueN extends Node implements IinitOrDerValueN
{
    private IinitOrDerValueN _initOrDerValueN;
    private IinitOrDerValue _initOrDerValue;

    public IinitOrDerValueN getinitOrDerValueN() { return _initOrDerValueN; }
    public IinitOrDerValue getinitOrDerValue() { return _initOrDerValue; }

    public InitOrDerValueN(IToken leftIToken, IToken rightIToken,
                           IinitOrDerValueN _initOrDerValueN,
                           IinitOrDerValue _initOrDerValue)
    {
        super(leftIToken, rightIToken);

        this._initOrDerValueN = _initOrDerValueN;
        this._initOrDerValue = _initOrDerValue;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


