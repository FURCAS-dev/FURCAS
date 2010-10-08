/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import java.util.Collection;
import java.util.List;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.SequenceInAlternative;

/**
 *
 */
public class AlternativeStub extends SequenceElementStub implements Alternative {

	public List<SequenceInAlternative> sequences;
	public boolean isMulti = false;

    /* (non-Javadoc)
     * @see TCS.Alternative#isIsMulti()
     */
    public boolean isMulti() {
        // TODO Auto-generated method stub
        return isMulti;
    }

    /* (non-Javadoc)
     * @see TCS.Alternative#setIsMulti(boolean)
     */
    public void setMulti(boolean value) {
	isMulti = value;
    }

    /* (non-Javadoc)
     * @see TCS.SequenceElement#getElementSequence()
     */
    public Sequence getElementSequence() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.SequenceElement#setElementSequence(TCS.Sequence)
     */
    public void setElementSequence(Sequence value) {
        // TODO Auto-generated method stub

    }

	@Override
	public Collection<SequenceInAlternative> getSequences() throws JmiException {
		// TODO Auto-generated method stub
		return sequences;
	}


    
}
