/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

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
    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getFunctionCall();
    }

}
