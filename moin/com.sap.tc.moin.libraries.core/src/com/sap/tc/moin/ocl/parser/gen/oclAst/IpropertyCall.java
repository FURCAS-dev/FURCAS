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
 * is implemented by:
 *<b>
 *<ul>
 *<li>OperationCall
 *<li>CallOclIsUndefined
 *<li>CallOclIsInvalid
 *<li>CallAllInstances
 *<li>CallOclAsType
 *<li>CallOclIsKindOf
 *<li>CallOclIsTypeOf
 *<li>CallEqual
 *<li>CallNotEqual
 *<li>CallPlus
 *<li>CallMult
 *<li>CallDivide
 *<li>CallGreater
 *<li>CallLess
 *<li>CallGreaterEqual
 *<li>CallLessEqual
 *<li>CallAnd
 *<li>CallOr
 *<li>CallXor
 *<li>AttrOrNavCall
 *</ul>
 *</b>
 */
public interface IpropertyCall
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(OclAstVisitor v);
}


