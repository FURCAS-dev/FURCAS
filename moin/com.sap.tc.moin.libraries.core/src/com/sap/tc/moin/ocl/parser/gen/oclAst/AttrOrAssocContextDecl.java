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
 *<li>Rule 57:  attrOrAssocContext ::= context sPathName withTypeExpression initOrDerValueN
 *</b>
 */
public class AttrOrAssocContextDecl extends Node implements IattrOrAssocContext
{
    private IsPathName _sPathName;
    private WithTypeExpression _withTypeExpression;
    private IinitOrDerValueN _initOrDerValueN;

    public IsPathName getsPathName() { return _sPathName; }
    public WithTypeExpression getwithTypeExpression() { return _withTypeExpression; }
    public IinitOrDerValueN getinitOrDerValueN() { return _initOrDerValueN; }

    public AttrOrAssocContextDecl(IToken leftIToken, IToken rightIToken,
                                  IsPathName _sPathName,
                                  WithTypeExpression _withTypeExpression,
                                  IinitOrDerValueN _initOrDerValueN)
    {
        super(leftIToken, rightIToken);

        this._sPathName = _sPathName;
        this._withTypeExpression = _withTypeExpression;
        this._initOrDerValueN = _initOrDerValueN;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


