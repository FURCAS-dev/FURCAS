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
 *<li>Rule 172:  collectionLiteral ::= collectionKind { collectionLiteralPartM }
 *</b>
 */
public class CollectionLiteral extends Node implements IcollectionLiteral
{
    private IcollectionKind _collectionKind;
    private IcollectionLiteralPartM _collectionLiteralPartM;

    public IcollectionKind getcollectionKind() { return _collectionKind; }
    /**
     * The value returned by <b>getcollectionLiteralPartM</b> may be <b>null</b>
     */
    public IcollectionLiteralPartM getcollectionLiteralPartM() { return _collectionLiteralPartM; }

    public CollectionLiteral(IToken leftIToken, IToken rightIToken,
                             IcollectionKind _collectionKind,
                             IcollectionLiteralPartM _collectionLiteralPartM)
    {
        super(leftIToken, rightIToken);

        this._collectionKind = _collectionKind;
        this._collectionLiteralPartM = _collectionLiteralPartM;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


