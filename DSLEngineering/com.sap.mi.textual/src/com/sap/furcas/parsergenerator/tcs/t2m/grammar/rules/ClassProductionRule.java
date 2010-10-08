/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-03-04 17:03:31 +0100 (Do, 04 Mrz 2010) $
 * @version $Revision: 9523 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules;

import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.furcas.parsergenerator.util.VarStringBuffer;

/**
 * defines an ANTLR3 Rule for Class TCS templates.
 */
public class ClassProductionRule extends SimpleProductionRule  {

    protected static final String EMPTY = "";
    private static final String RETURNSTRING = " returns[";
    private static final String INITSTRING = " @init{";
    private static final String FINALLYSTRING = " finally {";
    private static final String CATCHSTRING = "catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}";
    
    
    
    private String initString, returnDeclaration, finalizeString, catchString; 
    private int additionalLength;
    
    public static ClassProductionRule getClassTemplateProductionRule(String ruleHead, 
            String returnDeclaration, String initString, String rulebody, boolean addExitNotification, boolean catchString) {
        String exitNotification = null;
        if (addExitNotification) {
            exitNotification = ObservationDirectivesHelper.getExitTemplateNotification();
        }
        ClassProductionRule rule = new ClassProductionRule(ruleHead, returnDeclaration, initString, rulebody, exitNotification);
        if (catchString ) { 
            rule.catchString = CATCHSTRING;
            rule.additionalLength += CATCHSTRING.length();
        }
        return rule;
    }
    
    public ClassProductionRule(String ruleHead, 
            String returnDeclaration, String initString, String rulebody, String finalizeString) {
        super(ruleHead, rulebody);
        this.additionalLength = 0; 
        // nullify emptys
        if (initString != null && ! initString.trim().equals(EMPTY)) {
            this.initString = initString;
            additionalLength += INITSTRING.length() + initString.length() + 1;
        } else {
            this.initString = null;
        }
        if (returnDeclaration != null && ! returnDeclaration.trim().equals(EMPTY)) {
            this.returnDeclaration = returnDeclaration;
            additionalLength += RETURNSTRING.length() + returnDeclaration.length() + 1;
        } else {
            this.returnDeclaration = null;
        }
        if (finalizeString != null && ! finalizeString.trim().equals(EMPTY)) {
            this.finalizeString = finalizeString;
            additionalLength += FINALLYSTRING.length() + finalizeString.length() + 1;
        } else {
            this.finalizeString = null;
        }
        if (finalizeString != null && ! finalizeString.trim().equals(EMPTY)) {
            this.finalizeString = finalizeString;
            additionalLength += FINALLYSTRING.length() + finalizeString.length() + 1;
        } else {
            this.finalizeString = null;
        }
        this.returnDeclaration = returnDeclaration;
       
    }


    @Override
    protected void addRuleHead(VarStringBuffer buf) {
        super.addRuleHead(buf);
        addReturnAndInit(buf); 
        
    }


    protected void addReturnAndInit(VarStringBuffer buf) {
        if (returnDeclaration != null) {
            buf.append(RETURNSTRING);
            buf.append(returnDeclaration);
                    buf.append(']');
        }
        if (initString != null) {
            buf.append(INITSTRING);
            buf.append(initString);
            buf.append( '}');
        }
    }
    
    
    
    @Override
    protected void addFinally(VarStringBuffer buf) {
        if (finalizeString != null) {
            buf.append(FINALLYSTRING).append(finalizeString).append('}');
        }
    }
    
    @Override
    protected void addCatch(VarStringBuffer buf) {
        if (catchString != null) {
            buf.append(catchString);
        }
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.IAntlr3Rule#getLength()
     */
    @Override
    public int getLength() {
        return super.getLength() + this.additionalLength;
    }
    
}
