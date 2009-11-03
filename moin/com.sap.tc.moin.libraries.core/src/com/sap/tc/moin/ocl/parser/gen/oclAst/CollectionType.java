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
 *<li>Rule 32:  collectionType ::= collectionKind ( typePathName )
 *</b>
 */
public class CollectionType extends Node implements IcollectionType
{
    private IcollectionKind _collectionKind;
    private ItypePathName _typePathName;

    public IcollectionKind getcollectionKind() { return _collectionKind; }
    public ItypePathName gettypePathName() { return _typePathName; }

    public CollectionType(IToken leftIToken, IToken rightIToken,
                          IcollectionKind _collectionKind,
                          ItypePathName _typePathName)
    {
        super(leftIToken, rightIToken);

        this._collectionKind = _collectionKind;
        this._typePathName = _typePathName;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


