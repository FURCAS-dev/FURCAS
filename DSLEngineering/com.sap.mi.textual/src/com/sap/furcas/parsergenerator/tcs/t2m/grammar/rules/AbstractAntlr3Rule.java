/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules;

import com.sap.furcas.parsergenerator.util.VarStringBuffer;

/**
 * Defines an ANTLR rule to be created.
 */
public abstract class AbstractAntlr3Rule {

    protected static final String COLONSTRING = "\n  :\n  ";
    protected static final String SEMICOLONSTRING = "\n  ;\n";


    private String ruleHead;
    
    public AbstractAntlr3Rule(String ruleHead) {
        super();
        this.ruleHead = ruleHead;
    }
    
    /**
     * @param buffer 
     */
    public final void addToSerializationBuffer(VarStringBuffer buf) {
        buf.ensureCapacity(buf.length() + this.getLength());
        addRuleHead(buf);
        // consider todo addAfter()
        buf.append(COLONSTRING);
        addRuleBody(buf);
        buf.append(SEMICOLONSTRING);
        addCatch(buf);
        addFinally(buf);
    }


    public String toString() {
        VarStringBuffer buf = new VarStringBuffer(this.getLength());
        this.addToSerializationBuffer(buf);
        return buf.toString();
    }
    
    /**
     * @return an a priori calculation of the length of this rule
     */
    public abstract int getLength();
    
    protected void addRuleHead(VarStringBuffer buf) {
        buf.append(ruleHead);
    }
    
    protected abstract void addRuleBody(VarStringBuffer buf);
    
    /**
     * @param buf
     */
    protected void addFinally(VarStringBuffer buf) {
    }

    /**
     * @param buf
     */
    protected void addCatch(VarStringBuffer buf) {
    }
    
 
}
