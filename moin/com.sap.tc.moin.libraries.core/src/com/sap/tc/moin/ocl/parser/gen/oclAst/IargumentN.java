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
 *<li>LetExpression
 *<li>Self
 *<li>TypeLiteral
 *<li>Variable
 *<li>LogicalExpression
 *<li>AndBooleanExpression
 *<li>OrBooleanExpression
 *<li>XorBooleanExpression
 *<li>EqualRelationalExpression
 *<li>NotEqualRelationalExpression
 *<li>GreaterRelationalExpression
 *<li>LessRelationalExpression
 *<li>GreaterEqualRelationalExpression
 *<li>LessEqualRelationalExpression
 *<li>IfExpression
 *<li>PlusAdditiveExpression
 *<li>MinusAdditiveExpression
 *<li>MultMultiplicativeExpression
 *<li>DivideMultiplicativeExpression
 *<li>MinusUnaryExpression
 *<li>NotUnaryExpression
 *<li>PostfixExpression
 *<li>ParenthesizedPrimaryExpression
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
 *<li>CollectionLiteral
 *<li>IntegerLiteral
 *<li>RealLiteral
 *<li>StringLiteral
 *<li>BooleanLiteralTrue
 *<li>BooleanLiteralFalse
 *<li>NullLiteral
 *<li>InvalidLiteral
 *<li>TupleLiteral
 *<li>Arguments
 *</ul>
 *</b>
 */
public interface IargumentN
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(OclAstVisitor v);
}

