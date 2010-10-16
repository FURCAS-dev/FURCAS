/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-03-27 17:34:32 +0100 (Do, 27 Mrz 2008) $
 * @version $Revision: 696 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules;


/**
 * defines an ANTLR3 Rule for Function TCS templates.
 */
public class FunctionProductionRule extends SimpleProductionRule  {

    /**
     * @param ruleHead
     * @param rulebody
     */
    public FunctionProductionRule(String ruleHead, String rulebody) {
        super(ruleHead + "[Object ret]", rulebody);
        // the only change to a simple rule is that the given Class is passed in as parameter "ret"
    }


    
}
