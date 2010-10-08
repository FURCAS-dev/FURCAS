/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import com.sap.furcas.metamodel.TCS.SequenceElement;

/**
 * Stub for the superClass of all concrete SequenceElements. Is abstract in the real metamodel.
 */
public class SequenceElementStub extends LocatedElementStub implements SequenceElement {

    
    
    private Sequence elementSequence;

    public Sequence getElementSequence() {
        return elementSequence;
    }

    public void setElementSequence(Sequence elementSequence) {
        this.elementSequence = elementSequence;
    }

    @Override
    public Template getParentTemplate() throws JmiException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setParentTemplate(Template newValue) throws JmiException {
	// TODO Auto-generated method stub
	
    }

    @Override
    public boolean hasSyntaxContributions() throws JmiException {
        // TODO Auto-generated method stub
        return false;
    }   
   

}
