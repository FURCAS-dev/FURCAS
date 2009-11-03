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
 *<li>IteratorForAll
 *<li>IteratorExists
 *<li>IteratorIsUnique
 *<li>IteratorOne
 *<li>IteratorAny
 *<li>IteratorCollect
 *<li>IteratorSelect
 *<li>IteratorReject
 *<li>IteratorCollectNested
 *<li>IteratorSortedBy
 *<li>IterateVarDecl
 *<li>IterateVarDeclAndAcc
 *</ul>
 *</b>
 */
public interface IloopExp
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(OclAstVisitor v);
}


