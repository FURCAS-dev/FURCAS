/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules;

import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.furcas.parsergenerator.util.VarStringBuffer;

/**
 * defines an ANTLR rule for TCS operatorTemplates.
 */
public class OperatorTemplateProductionRule extends ClassProductionRule {
    
    
    private int additionalLength;
    private String parameters;

    public OperatorTemplateProductionRule(String ruleHead, String parameters, String initString,
            String rulebody, String returnDeclaration) {
        super(ruleHead, initString, rulebody, returnDeclaration, ObservationDirectivesHelper.getExitTemplateNotification());
        // nullify emptys
        if (parameters != null && ! parameters.trim().equals(EMPTY)) {
            this.parameters = parameters;
            additionalLength += parameters.length() + 2;
        } else {
            this.parameters = null;
            additionalLength = 0;
        }
    }

    @Override
    protected void addReturnAndInit(VarStringBuffer buf) {
        if (parameters != null) {
            buf.append('[');
            buf.append(parameters);
            buf.append(']');
        }
        super.addReturnAndInit(buf);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.IAntlr3Rule#getLength()
     */
    @Override
    public int getLength() {
        return super.getLength() + this.additionalLength;
    }
    
    
}
