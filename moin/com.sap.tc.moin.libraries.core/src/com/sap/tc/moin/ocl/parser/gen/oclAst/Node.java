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

public abstract class Node implements com.sap.tc.moin.repository.shared.util.parsers.CstNode 
{
    protected IToken leftIToken,
                     rightIToken;
    public IToken getLeftIToken() { return leftIToken; }
    public IToken getRightIToken() { return rightIToken; }
    public IToken[] getPrecedingAdjuncts() { return leftIToken.getPrecedingAdjuncts(); }
    public IToken[] getFollowingAdjuncts() { return rightIToken.getPrecedingAdjuncts(); }
    public String toString()
    {
        PrsStream prsStream = leftIToken.getPrsStream();
        return new String(prsStream.getInputChars(),
                          leftIToken.getStartOffset(),
                          rightIToken.getEndOffset() - leftIToken.getStartOffset() + 1);
    }
    public Node(IToken token) { this.leftIToken = this.rightIToken = token; }
    public Node(IToken leftIToken, IToken rightIToken)
    {
        this.leftIToken = leftIToken;
        this.rightIToken = rightIToken;
    }
    public void initialize() {}
    /**
     * Since the Ast type has no children, any two instances of it are equal.
     */
    public abstract void accept(OclAstVisitor v);
public int getStartOffset() { return getLeftIToken().getStartOffset();} 
public int getLine() { return getLeftIToken().getLine(); } 
public int getColumn() { return getLeftIToken().getColumn(); } 
public int getEndOffset() { return getRightIToken().getEndOffset(); } 
public int getEndLine() { return getRightIToken().getEndLine(); } 
public int getEndColumn() { return getRightIToken().getEndColumn(); } 
}


