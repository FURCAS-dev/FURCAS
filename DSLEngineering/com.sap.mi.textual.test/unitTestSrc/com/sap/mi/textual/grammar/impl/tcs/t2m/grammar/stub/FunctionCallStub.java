/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import tcs.FunctionCall;
import tcs.FunctionTemplate;

/**
 *
 */
public class FunctionCallStub extends SequenceElementStub implements FunctionCall {

    public FunctionTemplate template;

    /* (non-Javadoc)
     * @see TCS.FunctionCall#getCalledFunction()
     */
    public FunctionTemplate getCalledFunction() {
        return template;
    }

    /* (non-Javadoc)
     * @see TCS.FunctionCall#setCalledFunction(TCS.FunctionTemplate)
     */
    public void setCalledFunction(FunctionTemplate value) {

    }

  

  

}
