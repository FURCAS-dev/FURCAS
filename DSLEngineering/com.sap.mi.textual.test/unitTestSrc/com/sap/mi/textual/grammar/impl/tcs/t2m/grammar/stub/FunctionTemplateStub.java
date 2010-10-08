/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import com.sap.furcas.metamodel.TCS.FunctionTemplate;

/**
 *
 */
public class FunctionTemplateStub extends TemplateStub implements FunctionTemplate {

    public String functionName;
    public Sequence functionSequence;
    
    public String getFunctionName() {
        return functionName;
    }
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    public Sequence getFunctionSequence() {
        return functionSequence;
    }
    public void setFunctionSequence(Sequence functionSequence) {
        this.functionSequence = functionSequence;
    }
    
    


}
