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
 *<li>Rule 176:  collectionLiteralPartN ::= collectionLiteralPartN , collectionLiteralPart
 *</b>
 */
public class CollectionLiteralParts extends Node implements IcollectionLiteralPartN
{
    private IcollectionLiteralPartN _collectionLiteralPartN;
    private IcollectionLiteralPart _collectionLiteralPart;

    public IcollectionLiteralPartN getcollectionLiteralPartN() { return _collectionLiteralPartN; }
    public IcollectionLiteralPart getcollectionLiteralPart() { return _collectionLiteralPart; }

    public CollectionLiteralParts(IToken leftIToken, IToken rightIToken,
                                  IcollectionLiteralPartN _collectionLiteralPartN,
                                  IcollectionLiteralPart _collectionLiteralPart)
    {
        super(leftIToken, rightIToken);

        this._collectionLiteralPartN = _collectionLiteralPartN;
        this._collectionLiteralPart = _collectionLiteralPart;
        initialize();
    }

    public void accept(OclAstVisitor v) { v.visit(this); }
}


