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
 *<li>Rule 88:  varPathName ::= pathName timeExpressionOpt associationQualifierOpt
 *</b>
 */
public class Variable extends Node implements IvarPathName
{
    private IpathName _pathName;
    private TimeExpressionOpt _timeExpressionOpt;
    private AssociationQualifier _associationQualifierOpt;

    public IpathName getpathName() { return _pathName; }
    /**
     * The value returned by <b>gettimeExpressionOpt</b> may be <b>null</b>
     */
    public TimeExpressionOpt gettimeExpressionOpt() { return _timeExpressionOpt; }
    /**
     * The value returned by <b>getassociationQualifierOpt</b> may be <b>null</b>
     */
    public AssociationQualifier getassociationQualifierOpt() { return _associationQualifierOpt; }

    public Variable(IToken leftIToken, IToken rightIToken,
                    IpathName _pathName,
                    TimeExpressionOpt _timeExpressionOpt,
                    AssociationQualifier _associationQualifierOpt)
    {
        super(leftIToken, rightIToken);

        this._pathName = _pathName;
        this._timeExpressionOpt = _timeExpressionOpt;
        this._associationQualifierOpt = _associationQualifierOpt;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


