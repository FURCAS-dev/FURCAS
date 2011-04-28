/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class FunctionTemplateStub extends TemplateStub implements FunctionTemplate {

    public String functionName;
    public Sequence functionSequence;
    
    @Override
    public String getFunctionName() {
        return functionName;
    }
    @Override
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    @Override
    public Sequence getFunctionSequence() {
        return functionSequence;
    }
    @Override
    public void setFunctionSequence(Sequence functionSequence) {
        this.functionSequence = functionSequence;
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getFunctionTemplate();
    }

}
