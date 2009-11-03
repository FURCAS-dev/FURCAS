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
 * is always implemented by <b>NodeToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>Ident
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
 *<li>SetKind
 *<li>BagKind
 *<li>SequenceKind
 *<li>OrderedSetKind
 *<li>CollectionKind
 *<li>TupleType
 *<li>Self
 *<li>TypeLiteral
 *<li>Variable
 *<li>TimeExpressionOpt
 *<li>IntegerLiteralRange
 *<li>Minus
 *<li>IntegerLiteral
 *<li>RealLiteral
 *<li>StringLiteral
 *<li>BooleanLiteralTrue
 *<li>BooleanLiteralFalse
 *<li>NullLiteral
 *<li>InvalidLiteral
 *</ul>
 *</b>
 */
public interface INodeToken
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(OclAstVisitor v);
}


