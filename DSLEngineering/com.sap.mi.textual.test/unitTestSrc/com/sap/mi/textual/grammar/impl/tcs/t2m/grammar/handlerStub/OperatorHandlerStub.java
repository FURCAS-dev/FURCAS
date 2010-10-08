/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.OperatorHandler;

/**
 *
 */
public class OperatorHandlerStub extends OperatorHandler {

    /**
     * @param writer
     * @param syntaxLookup
     */
    public OperatorHandlerStub() {
        super(null, null, null);
    }
    public List<OperatorList> elements = new ArrayList<OperatorList>();
    public List<String> templates = new ArrayList<String>();
   
    @Override
    public void addOperatorList(OperatorList opList, String classTemplateName, boolean hasPrimaries) {
        // add to list to check called operations later
        elements.add(opList);
        templates.add(classTemplateName);
        
    }
    
    
  

}
