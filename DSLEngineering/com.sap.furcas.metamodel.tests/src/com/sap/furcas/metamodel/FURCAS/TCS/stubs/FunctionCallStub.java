/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;

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
