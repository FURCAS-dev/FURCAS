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
 *<li>Ident
 *<li>PathNameIdent
 *<li>PathNames
 *<li>ContainerNamePrefix
 *<li>PrimTypeInteger
 *<li>PrimTypeString
 *<li>PrimTypeReal
 *<li>PrimTypeFloat
 *<li>PrimTypeDouble
 *<li>PrimTypeBoolean
 *<li>PrimTypeOclAny
 *<li>PrimTypeOclVoid
 *<li>PrimTypeOclInvalid
 *<li>CollectionType
 *<li>TupleType
 *</ul>
 *</b>
 */
public interface ItypePathName
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(OclAstVisitor v);
}


