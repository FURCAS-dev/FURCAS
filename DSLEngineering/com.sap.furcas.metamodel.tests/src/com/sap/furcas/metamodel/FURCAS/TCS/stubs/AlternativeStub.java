/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;


/**
 *
 */
public class AlternativeStub extends SequenceElementStub implements Alternative {

    public EList<SequenceInAlternative> sequences;
    public boolean isMulti = false;

    /*
     * (non-Javadoc)
     * 
     * @see TCS.Alternative#isIsMulti()
     */
    @Override
    public boolean isIsMulti() {
	// TODO Auto-generated method stub
	return isMulti;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.Alternative#setIsMulti(boolean)
     */
    @Override
    public void setIsMulti(boolean value) {
	isMulti = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.SequenceElement#getElementSequence()
     */
    @Override
    public Sequence getElementSequence() {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.SequenceElement#setElementSequence(TCS.Sequence)
     */
    @Override
    public void setElementSequence(Sequence value) {
	// TODO Auto-generated method stub

    }

    @Override
    public EList<SequenceInAlternative> getSequences() {
	// TODO Auto-generated method stub
	return sequences;
    }

}
