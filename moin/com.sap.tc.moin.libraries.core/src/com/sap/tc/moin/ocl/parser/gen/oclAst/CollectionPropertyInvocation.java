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
 *<li>Rule 121:  propertyInvocation ::= -> propertyCall
 *</b>
 */
public class CollectionPropertyInvocation extends Node implements IpropertyInvocation
{
    private IpropertyCall _propertyCall;

    public IpropertyCall getpropertyCall() { return _propertyCall; }

    public CollectionPropertyInvocation(IToken leftIToken, IToken rightIToken,
                                        IpropertyCall _propertyCall)
    {
        super(leftIToken, rightIToken);

        this._propertyCall = _propertyCall;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


