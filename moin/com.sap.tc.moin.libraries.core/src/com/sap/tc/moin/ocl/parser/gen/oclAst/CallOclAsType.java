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
 *<li>Rule 129:  operationCall ::= oclAsType timeExpressionOpt arguments
 *</b>
 */
public class CallOclAsType extends Node implements IoperationCall
{
    private TimeExpressionOpt _timeExpressionOpt;
    private Iarguments _arguments;

    /**
     * The value returned by <b>gettimeExpressionOpt</b> may be <b>null</b>
     */
    public TimeExpressionOpt gettimeExpressionOpt() { return _timeExpressionOpt; }
    public Iarguments getarguments() { return _arguments; }

    public CallOclAsType(IToken leftIToken, IToken rightIToken,
                         TimeExpressionOpt _timeExpressionOpt,
                         Iarguments _arguments)
    {
        super(leftIToken, rightIToken);

        this._timeExpressionOpt = _timeExpressionOpt;
        this._arguments = _arguments;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


